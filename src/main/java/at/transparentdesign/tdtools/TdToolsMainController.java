package at.transparentdesign.tdtools;

import at.transparentdesign.tdtools.converter.Bmd55ToNtscConverter;
import at.transparentdesign.tdtools.loader.Bmd55FileLoader;
import at.transparentdesign.tdtools.loader.FileLoader;
import at.transparentdesign.tdtools.parser.Satzart0FiBuBuchungssatzParser;
import at.transparentdesign.tdtools.satz.Bmd55FiBuRecord;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.controlsfx.control.tableview2.TableView2;

import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class TdToolsMainController {

    Properties prop = new Properties();

    @FXML
    public Button bmd55PreviewButton;
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
        this.bmd55PreviewButton.setDisable(false);
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

    public void onBmd55PreviewButton(ActionEvent actionEvent) {

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1320, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BMD 5.5 Ansicht");
        stage.setMaxWidth(1520);

        TableView<Bmd55FiBuRecord> tableView = new TableView<>();
        tableView.setMaxWidth(1500);
        tableView.setPrefWidth(1300);
        //tableView.setPrefHeight(200);

        defileBmd55Column("Satzart", "satzart", tableView);
        defileBmd55Column("Konto", "konto", tableView);
        defileBmd55Column("buchdat", "buchdat", tableView);
        defileBmd55Column("gkto", "gkto", tableView);
        defileBmd55Column("belegnr", "belegnr", tableView);
        defileBmd55Column("belegdat", "belegdat", tableView);
        defileBmd55Column("kost", "kost", tableView);
        defileBmd55Column("unused1", "unused1", tableView);
        defileBmd55Column("kotraeger", "kotraeger", tableView);
        defileBmd55Column("komenge", "komenge", tableView);
        defileBmd55Column("komengenr", "komengenr", tableView);
        defileBmd55Column("kovariator", "kovariator", tableView);
        defileBmd55Column("koperiode", "koperiode", tableView);
        defileBmd55Column("komonteiler", "komonteiler", tableView);
        defileBmd55Column("mwst", "mwst", tableView);
        defileBmd55Column("steucod", "steucod", tableView);
        defileBmd55Column("ebkennz", "ebkennz", tableView);
        defileBmd55Column("bucod", "bucod", tableView);
        defileBmd55Column("betrag", "betrag", tableView);
        defileBmd55Column("steuer", "steuer", tableView);
        defileBmd55Column("skonto", "skonto", tableView);
        defileBmd55Column("opbetrag", "opbetrag", tableView);
        defileBmd55Column("periode", "periode", tableView);
        defileBmd55Column("kursnr", "kursnr", tableView);
        defileBmd55Column("fwkurs", "fwkurs", tableView);
        defileBmd55Column("fwfaktor", "fwfaktor", tableView);
        defileBmd55Column("fwbetrag", "fwbetrag", tableView);
        defileBmd55Column("fwsteuer", "fwsteuer", tableView);
        defileBmd55Column("fwskonto", "fwskonto", tableView);
        defileBmd55Column("fwopbetr", "fwopbetr", tableView);
        defileBmd55Column("landkz", "landkz", tableView);
        defileBmd55Column("lkzkurs", "lkzkurs", tableView);
        defileBmd55Column("lkzfaktor", "lkzfaktor", tableView);
        defileBmd55Column("text", "text", tableView);
        defileBmd55Column("symbol", "symbol", tableView);
        defileBmd55Column("extbelegnr", "extbelegnr", tableView);
        defileBmd55Column("zesskz", "zesskz", tableView);
        defileBmd55Column("zziel", "zziel", tableView);
        defileBmd55Column("skontopz", "skontopz", tableView);
        defileBmd55Column("skontotage", "skontotage", tableView);
        defileBmd55Column("skontopz2", "skontopz2", tableView);
        defileBmd55Column("skontotage2", "skontotage2", tableView);
        defileBmd55Column("valutadatum", "valutadatum", tableView);
        defileBmd55Column("wechseldatum", "wechseldatum", tableView);
        defileBmd55Column("vertnr", "vertnr", tableView);
        defileBmd55Column("provpz", "provpz", tableView);
        defileBmd55Column("auftkz", "auftkz", tableView);
        defileBmd55Column("auftnr", "auftnr", tableView);
        defileBmd55Column("zmart", "zmart", tableView);
        defileBmd55Column("zmbericht", "zmbericht", tableView);
        defileBmd55Column("menge", "menge", tableView);
        defileBmd55Column("benutzer", "benutzer", tableView);
        defileBmd55Column("buchart", "buchart", tableView);
        defileBmd55Column("buchkz", "buchkz", tableView);
        defileBmd55Column("mahnz", "mahnz", tableView);
        defileBmd55Column("leistdat", "leistdat", tableView);
        defileBmd55Column("uvaPeriode", "uvaPeriode", tableView);
        defileBmd55Column("uidnr", "uidnr", tableView);
        defileBmd55Column("steuerart", "steuerart", tableView);
        defileBmd55Column("korekonto", "korekonto", tableView);
        defileBmd55Column("erZahlbank", "erZahlbank", tableView);
        defileBmd55Column("bauSteucod", "bauSteucod", tableView);
        defileBmd55Column("unused2", "unused2", tableView);
        defileBmd55Column("vstAbzugpz", "vstAbzugpz", tableView);
        defileBmd55Column("zvMahnsp", "zvMahnsp", tableView);
        defileBmd55Column("erSteukorrKz", "erSteukorrKz", tableView);
        defileBmd55Column("gegenbuchkz", "gegenbuchkz", tableView);
        defileBmd55Column("verbuchkz", "verbuchkz", tableView);
        defileBmd55Column("unused3", "unused3", tableView);
        defileBmd55Column("unused4", "unused4", tableView);



        for (Bmd55FiBuRecord bmd55FiBuRecord : bmd55Records) {
            tableView.getItems().add(bmd55FiBuRecord);
        }

        pane.getChildren().add(tableView);

        stage.show();
    }

    private static void defileBmd55Column(String header, String reflectionValue, TableView<Bmd55FiBuRecord> tableView) {
        TableColumn<Bmd55FiBuRecord, String> column1 =
                new TableColumn<>(header);

        column1.setCellValueFactory(
                new PropertyValueFactory<>(reflectionValue));
        tableView.getColumns().add(column1);
    }
}