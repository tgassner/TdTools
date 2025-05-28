package at.transparentdesign.tdtools;

import at.transparentdesign.tdtools.converter.Bmd55ToNtscConverter;
import at.transparentdesign.tdtools.loader.Bmd55FileLoader;
import at.transparentdesign.tdtools.loader.FileLoader;
import at.transparentdesign.tdtools.parser.Satzart0FiBuBuchungssatzParser;
import at.transparentdesign.tdtools.satz.Bmd55FiBuRecord;
import at.transparentdesign.tdtools.satz.NtscFiBuRecord;
import at.transparentdesign.tdtools.writer.AusgangsrechnungWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TdToolsMainController {

    FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
            new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                    .configure(new Parameters().properties()
                            .setFileName("tdTools.properties")
                            .setListDelimiterHandler(new DefaultListDelimiterHandler(',')));

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

    private void storeProperty(String key, String value) {
        try {
            Configuration config = getConfiguration();
            config.setProperty(key, value);
            builder.save();
        } catch (ConfigurationException e) {
            // Schlucken.. what shells
        }
    }

    private String loadBmd55InputFilePath() {
        try {
            return getConfiguration().getString("BMD55InputFilePath");
        } catch (ConfigurationException e) {
            return StringUtils.EMPTY;
        }
    }

    private Configuration getConfiguration() throws ConfigurationException {
        return builder.getConfiguration();
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
}