package at.transparentdesign.tdtools;

import at.transparentdesign.tdtools.converter.Bmd55ToNtscConverter;
import at.transparentdesign.tdtools.loader.Bmd55FileLoader;
import at.transparentdesign.tdtools.loader.FileLoader;
import at.transparentdesign.tdtools.parser.Satzart0FiBuBuchungssatzParser;
import at.transparentdesign.tdtools.satz.Bmd55FiBuRecord;
import at.transparentdesign.tdtools.satz.FiBuRecordFields;
import at.transparentdesign.tdtools.satz.NtscFiBuRecord;
import at.transparentdesign.tdtools.tools.ApplicationDirectories;
import at.transparentdesign.tdtools.writer.AusgangsrechnungWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TdToolsMainController {

    Properties prop = new Properties();

    @FXML
    public Button ntscQuickViewButton;
    @FXML
    public Button bmd55QuickViewButton;
    @FXML
    public TextArea bookingBmd55ToNTSCtextArea;
    @FXML
    public TabPane mainBox;
    @FXML
    public TextField inputFileTextField;
    @FXML
    public TextField outputFileTextField;
    @FXML
    public Button loadInputFileButton;
    @FXML
    public Button doBookingConvertationButton;
    @FXML
    public Button saveOutputFileButton;
    @FXML
    public Button copyOutputFileToClipboard;
    @FXML
    public Button copyInputFileToClipboard;

    private List<Bmd55FiBuRecord> bmd55Records;
    private List<NtscFiBuRecord> ntscRecords;
    private TableView<Bmd55FiBuRecord> bmd55TableView;
    private TableView<NtscFiBuRecord> ntscTableView;

    public TdToolsMainController() {

    }

    @FXML
    protected void initialize() {

        Image imageCopyToClipboard = new Image("copied-icon.png");
        ImageView imageViewCopyInputFilePathToClipboard = new ImageView(imageCopyToClipboard);
        imageViewCopyInputFilePathToClipboard.setFitHeight(16);
        imageViewCopyInputFilePathToClipboard.setFitWidth(16);
        this.copyInputFileToClipboard.setGraphic(imageViewCopyInputFilePathToClipboard);
        ImageView imageViewCopyOutputFilePathToClipboard = new ImageView(imageCopyToClipboard);
        imageViewCopyOutputFilePathToClipboard.setFitHeight(16);
        imageViewCopyOutputFilePathToClipboard.setFitWidth(16);
        this.copyOutputFileToClipboard.setGraphic(imageViewCopyOutputFilePathToClipboard);

        Path propertyPath = Paths.get(getPropertyPath());
        if (Files.exists(propertyPath)) {
            try (InputStream  stream = new FileInputStream(propertyPath.toString())) {
                prop.load(stream);
                appendGuiLog("Loaded Properties File from Config Dir: " + propertyPath);
            } catch (IOException e) {
                appendGuiLog(e);
            }
        } else {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            try (InputStream stream = loader.getResourceAsStream("tdTools.properties")) {
                prop.load(stream);
                appendGuiLog("Load Properties File by ClassLoader : " + Thread.currentThread().getContextClassLoader().getResource("tdTools.properties").getPath());
            } catch (IOException e) {
                appendGuiLog(e);
            }
        }

    }

    @FXML
    protected void onDoBookingConvertationClick() {
        Bmd55ToNtscConverter converter = new Bmd55ToNtscConverter();
        ntscRecords = converter.convert(bmd55Records);
        appendGuiLog(this.ntscRecords.size() + " Datenzeilen konvertiert.");
        this.doBookingConvertationButton.setDisable(true);
        this.saveOutputFileButton.setDisable(false);
        this.ntscQuickViewButton.setDisable(false);
        this.copyInputFileToClipboard.setDisable(false);
        this.copyOutputFileToClipboard.setDisable(true);
        this.outputFileTextField.setText(StringUtils.EMPTY);
    }

    @FXML
    protected void onLoadInputFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("BMD 5.5 Buchungs Datei öffnen");

        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(txtFilter);
        FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(allFilter);

        String directoryInGuiString = loadBmd55InputFilePath();
        if (StringUtils.isNotEmpty(directoryInGuiString)) {
            Path directoryInGuiPath = Paths.get(directoryInGuiString);
            if (Files.exists(directoryInGuiPath) && Files.isDirectory(directoryInGuiPath)) {
                fileChooser.setInitialDirectory(new File(directoryInGuiString));
            }
        }

        File file = fileChooser.showOpenDialog(mainBox.getScene().getWindow());
        if (file == null) {
            return;
        }

        Path inputPath = Path.of(file.getAbsolutePath());

        appendGuiLog("Lade Datei: " + file.getAbsolutePath());

        FileLoader fileLoader = new Bmd55FileLoader();

        List<String> records;
        try {
            records = fileLoader.loadFileToLines(inputPath, true);
            appendGuiLog(records.size() + " Datenzeilen gelesen.");

            bmd55Records = new ArrayList<>();

            Satzart0FiBuBuchungssatzParser satzart0FIBUBuchungssatzParser = new Satzart0FiBuBuchungssatzParser();

            for (String record : records) {
                Bmd55FiBuRecord bmd55FiBuRecord = satzart0FIBUBuchungssatzParser.parse(record);
                bmd55Records.add(bmd55FiBuRecord);
            }

        } catch (Exception e) {
            if (MalformedInputException.class.equals(ExceptionUtils.getRootCause(e).getClass())) {
                appendGuiLog("BMD5.5 Datei ungültig. -> Vorgang abgebrochen.");
                messageBox("Ungültige Datei", "I glaub do hots wos mit der Datei oder so..", "", Alert.AlertType.ERROR);
                return;
            }
            appendGuiLog("Allgemeiner Fehler!\nGassi berichten\n\n" + e.getMessage() + "\n\n" +  ExceptionUtils.getStackTrace(e));
            messageBox("Allgemeiner Fehler", "Gassi berichten\n" + e.getMessage(), ExceptionUtils.getStackTrace(e), Alert.AlertType.ERROR);
        }

        appendGuiLog(bmd55Records.size() + " Datenzeilen erkannt.");

        this.inputFileTextField.setText(file.getAbsolutePath());
        this.outputFileTextField.setText(StringUtils.EMPTY);
        storeBmd55InputFilePath(inputPath);
        this.doBookingConvertationButton.setDisable(false);
        this.saveOutputFileButton.setDisable(true);
        this.bmd55QuickViewButton.setDisable(false);
        this.ntscQuickViewButton.setDisable(true);
        this.copyInputFileToClipboard.setDisable(false);
        this.copyOutputFileToClipboard.setDisable(true);
    }

    @FXML
    public void onSaveOutputFileButtonClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("NTCS Ziel Datei");

        FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(csvFilter);

        String inputFileString = this.inputFileTextField.getText();
        if (StringUtils.isNotEmpty(inputFileString)) {
            Path directoryOutGuiPath = Paths.get(inputFileString);
            Path parent = directoryOutGuiPath.getParent();
            if (Files.exists(parent) && Files.isDirectory(parent)) {
                String outputFilename = directoryOutGuiPath.getFileName().toString();
                if (StringUtils.contains(outputFilename, ".")) {
                    outputFilename = StringUtils.substringBeforeLast(outputFilename, ".");
                }
                fileChooser.setInitialDirectory(new File(parent.toString()));
                fileChooser.setInitialFileName(outputFilename + ".csv");
            }
        }

        File file = fileChooser.showSaveDialog(mainBox.getScene().getWindow());
        if (file == null) {
            return;
        }

        Path outputFilePath = Path.of(file.getAbsolutePath());

        AusgangsrechnungWriter ausgangsrechnungWriter = new AusgangsrechnungWriter();
        try {
            ausgangsrechnungWriter.write(ntscRecords, file.getAbsolutePath());
        } catch (Exception e) {
            appendGuiLog(e);
        }

        appendGuiLog(ntscRecords.size() + " Datensätze geschrieben");
        appendGuiLog("Datei geschrieben: " + outputFilePath.toAbsolutePath());

        outputFileTextField.setText(file.getAbsolutePath());

        this.doBookingConvertationButton.setDisable(true);
        this.saveOutputFileButton.setDisable(false);
        this.ntscQuickViewButton.setDisable(false);
        this.copyInputFileToClipboard.setDisable(false);
        this.copyOutputFileToClipboard.setDisable(false);
    }

    private boolean messageBox(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        Optional<ButtonType> buttonType = alert.showAndWait();
        return buttonType != null && buttonType.isPresent() && buttonType.get().equals(ButtonType.OK);
    }

    private void copyStringToClipboard(String text) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }

    private void storeBmd55InputFilePath(Path bmd55InputFilePath) {
        storeProperty("BMD55InputFilePath", bmd55InputFilePath.getParent().toString());
    }

    private String getPropertyPath() {
        Path path = ApplicationDirectories.configDir("TdTools");
        return path.toAbsolutePath().toString() + FileSystems.getDefault().getSeparator() + "tdTools.properties";
    }

    private void storeProperty(String key, String value) {
        prop.setProperty(key, value);
        String propertyPathString = getPropertyPath();
        Path propertyPath = Paths.get(propertyPathString);
        try {
            if (!Files.exists(propertyPath.getParent())) {
                Files.createDirectories(propertyPath.getParent());
            }

            if (!Files.exists(propertyPath)) {
                Files.createFile(propertyPath);
            }
            prop.store(new FileOutputStream(propertyPathString), null);

        } catch (IOException e) {
            appendGuiLog(e);
            throw new RuntimeException(e);
        }
    }

    private String loadBmd55InputFilePath() {
        return this.prop.getProperty("BMD55InputFilePath");
    }

    private void appendGuiLog(Exception e) {
        appendGuiLog("ERROR" + "\n" + e.getMessage() + "\n" + ExceptionUtils.getStackTrace(e) + "\n");
    }

    private void appendGuiLog(String message) {
        this.bookingBmd55ToNTSCtextArea.appendText(message + "\n");
        this.bookingBmd55ToNTSCtextArea.setScrollTop(Double.MAX_VALUE);
    }

    @FXML
    public void copyInputFileToClipboard(ActionEvent actionEvent) {
        copyStringToClipboard(this.inputFileTextField.getText());
    }

    @FXML
    public void copyOutputFileToClipboard(ActionEvent actionEvent) {
        copyStringToClipboard(this.outputFileTextField.getText());
    }

    @FXML
    public void onBmd55QuickViewButton(ActionEvent actionEvent) {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1300, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BMD 5.5 Ansicht");

        this.bmd55TableView = new TableView<>();
        bmd55TableView.setPrefWidth(1300);
        bmd55TableView.setPrefHeight(600);

        defileBmd55Column("Satzart", "satzart", bmd55TableView);
        defileBmd55Column("Konto", "konto", bmd55TableView);
        defileBmd55Column("buchdat", "buchdat", bmd55TableView);
        defileBmd55Column("gkto", "gkto", bmd55TableView);
        defileBmd55Column("belegnr", "belegnr", bmd55TableView);
        defileBmd55Column("belegdat", "belegdat", bmd55TableView);
        defileBmd55Column("kost", "kost", bmd55TableView);
        defileBmd55Column("unused1", "unused1", bmd55TableView);
        defileBmd55Column("kotraeger", "kotraeger", bmd55TableView);
        defileBmd55Column("komenge", "komenge", bmd55TableView);
        defileBmd55Column("komengenr", "komengenr", bmd55TableView);
        defileBmd55Column("kovariator", "kovariator", bmd55TableView);
        defileBmd55Column("koperiode", "koperiode", bmd55TableView);
        defileBmd55Column("komonteiler", "komonteiler", bmd55TableView);
        defileBmd55Column("mwst", "mwst", bmd55TableView);
        defileBmd55Column("steucod", "steucod", bmd55TableView);
        defileBmd55Column("ebkennz", "ebkennz", bmd55TableView);
        defileBmd55Column("bucod", "bucod", bmd55TableView);
        defileBmd55Column("betrag", "betrag", bmd55TableView);
        defileBmd55Column("steuer", "steuer", bmd55TableView);
        defileBmd55Column("skonto", "skonto", bmd55TableView);
        defileBmd55Column("opbetrag", "opbetrag", bmd55TableView);
        defileBmd55Column("periode", "periode", bmd55TableView);
        defileBmd55Column("kursnr", "kursnr", bmd55TableView);
        defileBmd55Column("fwkurs", "fwkurs", bmd55TableView);
        defileBmd55Column("fwfaktor", "fwfaktor", bmd55TableView);
        defileBmd55Column("fwbetrag", "fwbetrag", bmd55TableView);
        defileBmd55Column("fwsteuer", "fwsteuer", bmd55TableView);
        defileBmd55Column("fwskonto", "fwskonto", bmd55TableView);
        defileBmd55Column("fwopbetr", "fwopbetr", bmd55TableView);
        defileBmd55Column("landkz", "landkz", bmd55TableView);
        defileBmd55Column("lkzkurs", "lkzkurs", bmd55TableView);
        defileBmd55Column("lkzfaktor", "lkzfaktor", bmd55TableView);
        defileBmd55Column("text", "text", bmd55TableView);
        defileBmd55Column("symbol", "symbol", bmd55TableView);
        defileBmd55Column("extbelegnr", "extbelegnr", bmd55TableView);
        defileBmd55Column("zesskz", "zesskz", bmd55TableView);
        defileBmd55Column("zziel", "zziel", bmd55TableView);
        defileBmd55Column("skontopz", "skontopz", bmd55TableView);
        defileBmd55Column("skontotage", "skontotage", bmd55TableView);
        defileBmd55Column("skontopz2", "skontopz2", bmd55TableView);
        defileBmd55Column("skontotage2", "skontotage2", bmd55TableView);
        defileBmd55Column("valutadatum", "valutadatum", bmd55TableView);
        defileBmd55Column("wechseldatum", "wechseldatum", bmd55TableView);
        defileBmd55Column("vertnr", "vertnr", bmd55TableView);
        defileBmd55Column("provpz", "provpz", bmd55TableView);
        defileBmd55Column("auftkz", "auftkz", bmd55TableView);
        defileBmd55Column("auftnr", "auftnr", bmd55TableView);
        defileBmd55Column("zmart", "zmart", bmd55TableView);
        defileBmd55Column("zmbericht", "zmbericht", bmd55TableView);
        defileBmd55Column("menge", "menge", bmd55TableView);
        defileBmd55Column("benutzer", "benutzer", bmd55TableView);
        defileBmd55Column("buchart", "buchart", bmd55TableView);
        defileBmd55Column("buchkz", "buchkz", bmd55TableView);
        defileBmd55Column("mahnz", "mahnz", bmd55TableView);
        defileBmd55Column("leistdat", "leistdat", bmd55TableView);
        defileBmd55Column("uvaPeriode", "uvaPeriode", bmd55TableView);
        defileBmd55Column("uidnr", "uidnr", bmd55TableView);
        defileBmd55Column("steuerart", "steuerart", bmd55TableView);
        defileBmd55Column("korekonto", "korekonto", bmd55TableView);
        defileBmd55Column("erZahlbank", "erZahlbank", bmd55TableView);
        defileBmd55Column("bauSteucod", "bauSteucod", bmd55TableView);
        defileBmd55Column("unused2", "unused2", bmd55TableView);
        defileBmd55Column("vstAbzugpz", "vstAbzugpz", bmd55TableView);
        defileBmd55Column("zvMahnsp", "zvMahnsp", bmd55TableView);
        defileBmd55Column("erSteukorrKz", "erSteukorrKz", bmd55TableView);
        defileBmd55Column("gegenbuchkz", "gegenbuchkz", bmd55TableView);
        defileBmd55Column("verbuchkz", "verbuchkz", bmd55TableView);
        defileBmd55Column("unused3", "unused3", bmd55TableView);
        defileBmd55Column("unused4", "unused4", bmd55TableView);

        for (Bmd55FiBuRecord bmd55FiBuRecord : bmd55Records) {
            bmd55TableView.getItems().add(bmd55FiBuRecord);
        }

        pane.getChildren().add(bmd55TableView);

        stage.getIcons().add(new Image("icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);

        pane.widthProperty().addListener((observable, oldValue, newValue) -> {
            //messageBox(oldValue + "", newValue + "", "", Alert.AlertType.INFORMATION);
            this.bmd55TableView.setPrefWidth(newValue.doubleValue());
        });

        pane.heightProperty().addListener((observable, oldValue, newValue) -> {
            //messageBox(oldValue + "", newValue + "", "", Alert.AlertType.INFORMATION);
            this.bmd55TableView.setPrefHeight(newValue.doubleValue());
        });

        stage.show();
    }

    @FXML
    public void onNtscQuickViewButton(ActionEvent actionEvent) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1300, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("NTSC Ansicht");

        this.ntscTableView = new TableView<>();
        ntscTableView.setPrefWidth(1300);
        ntscTableView.setPrefHeight(600);

        defileNtscColumn(FiBuRecordFields.SATZART.getNtcsBookingheaderElement(), "satzart", ntscTableView);
        defileNtscColumn(FiBuRecordFields.KONTO.getNtcsBookingheaderElement(), "konto", ntscTableView);
        defileNtscColumn(FiBuRecordFields.BUCHDAT.getNtcsBookingheaderElement(), "buchdatum", ntscTableView);
        defileNtscColumn(FiBuRecordFields.GKTO.getNtcsBookingheaderElement(), "gkonto", ntscTableView);
        defileNtscColumn(FiBuRecordFields.BELEGNR.getNtcsBookingheaderElement(), "belegnr", ntscTableView);
        defileNtscColumn(FiBuRecordFields.BELEGDAT.getNtcsBookingheaderElement(), "belegdatum", ntscTableView);
        defileNtscColumn(FiBuRecordFields.MWST.getNtcsBookingheaderElement(), "prozent", ntscTableView);
        defileNtscColumn(FiBuRecordFields.STEUCOD.getNtcsBookingheaderElement(), "steuercode", ntscTableView);
        defileNtscColumn(FiBuRecordFields.BUCOD.getNtcsBookingheaderElement(), "buchcode", ntscTableView);
        defileNtscColumn(FiBuRecordFields.BETRAG.getNtcsBookingheaderElement(), "betrag", ntscTableView);
        defileNtscColumn(FiBuRecordFields.STEUER.getNtcsBookingheaderElement(), "steuer", ntscTableView);
        defileNtscColumn(FiBuRecordFields.SKONTO.getNtcsBookingheaderElement(), "skonto", ntscTableView);
        defileNtscColumn(FiBuRecordFields.TEXT.getNtcsBookingheaderElement(), "text", ntscTableView);
        defileNtscColumn(FiBuRecordFields.SYMBOL.getNtcsBookingheaderElement(), "buchsymbol", ntscTableView);
        defileNtscColumn(FiBuRecordFields.EXTBELEGNR.getNtcsBookingheaderElement(), "extbelegnr", ntscTableView);
        defileNtscColumn(FiBuRecordFields.KOST.getNtcsBookingheaderElement(), "kost", ntscTableView);

        for (NtscFiBuRecord ntscFiBuRecord : ntscRecords) {
            ntscTableView.getItems().add(ntscFiBuRecord);
        }

        pane.getChildren().add(ntscTableView);

        stage.getIcons().add(new Image("icon.png"));
        stage.initModality(Modality.APPLICATION_MODAL);

        pane.widthProperty().addListener((observable, oldValue, newValue) -> {
            this.ntscTableView.setPrefWidth(newValue.doubleValue());
        });

        pane.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.ntscTableView.setPrefHeight(newValue.doubleValue());
        });

        stage.show();
    }

    private void defileBmd55Column(String header, String reflectionValue, TableView<Bmd55FiBuRecord> tableView) {
        TableColumn<Bmd55FiBuRecord, String> column1 =
                new TableColumn<>(header);

        column1.setCellValueFactory(
                new PropertyValueFactory<>(reflectionValue));
        tableView.getColumns().add(column1);
    }

    private void defileNtscColumn(String header, String reflectionValue, TableView<NtscFiBuRecord> tableView) {
        TableColumn<NtscFiBuRecord, String> column1 =
                new TableColumn<>(header);

        column1.setCellValueFactory(
                new PropertyValueFactory<>(reflectionValue));
        tableView.getColumns().add(column1);
    }

}