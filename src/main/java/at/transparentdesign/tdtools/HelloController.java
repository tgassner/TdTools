package at.transparentdesign.tdtools;

import at.transparentdesign.tdtools.loader.Bmd55FileLoader;
import at.transparentdesign.tdtools.loader.FileLoader;
import at.transparentdesign.tdtools.parser.Satzart0FIBUBuchungssatzParser;
import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatz;
import at.transparentdesign.tdtools.writer.AusgangsrechnungWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
            new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                    .configure(new Parameters().properties()
                            .setFileName("tdTools.properties")
                            .setListDelimiterHandler(new DefaultListDelimiterHandler(',')));

    @FXML
    public TextField inputFileTextField;
    @FXML
    public TextField outputFileTextField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void initialize() {
        inputFileTextField.setText(loadBmd55InputFilePath());
        outputFileTextField.setText(loadNtscOutputFilePath());
    }

    @FXML
    protected void onDoBookingConvertationClick() {
        String inputFileStr = inputFileTextField.getText();
        Path inputFilePath = Path.of(inputFileStr);

        String outputFileStr = outputFileTextField.getText();
        Path outputFilePath = Path.of(outputFileStr);

        //welcomeText.setText("Welcome to JavaFX Application!");
        if (StringUtils.isEmpty(inputFileStr) || !Files.exists(inputFilePath)) {
            messageBox("Keine existierende input Datei ausgewählt", "Bitte eine Datei auswählen", "", Alert.AlertType.INFORMATION);
            return;
        }

        if (StringUtils.isEmpty(outputFileStr) || !isFilenameValid(outputFileStr)) {
            messageBox("Keine valide Datei ausgewählt", "Bitte eine gültige Datei definieren", "", Alert.AlertType.INFORMATION);
            return;
        }

        storeBmd55InputFilePath(inputFilePath);
        storeNtscOutputFilePath(outputFilePath);

        FileLoader fileLoader = new Bmd55FileLoader();
        Satzart0FIBUBuchungssatzParser satzart0FIBUBuchungssatzParser = new Satzart0FIBUBuchungssatzParser();
        try {
            List<String> records = fileLoader.loadFileToLines(inputFilePath, true);

            List<Satzart0FIBUBuchungssatz> saetze = new ArrayList<>();

            for (String record : records) {
               Satzart0FIBUBuchungssatz satzart0FIBUBuchungssatz = satzart0FIBUBuchungssatzParser.parse(record);
                saetze.add(satzart0FIBUBuchungssatz);
            }

            AusgangsrechnungWriter ausgangsrechnungWriter = new AusgangsrechnungWriter();
            ausgangsrechnungWriter.write(saetze, outputFileStr);

            welcomeText.setText(records.toString());
        } catch (Exception e) {
            if (MalformedInputException.class.equals(ExceptionUtils.getRootCause(e).getClass())) {
                messageBox("Ungültige Datei", "I glaub do hots wos mit der Datei oder so..", "", Alert.AlertType.ERROR);
                return;
            }
            messageBox("Allgemeiner Fehler", "Gassi berichten\n" + e.getMessage(), ExceptionUtils.getStackTrace(e), Alert.AlertType.ERROR);
            welcomeText.setText(e.getMessage()); //throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onOpenInputFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("BMD 5.5 Buchungs Datei öffnen");

        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(txtFilter);
        FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(allFilter);

        String directoryInGuiString = inputFileTextField.getText();
        if (StringUtils.isNoneEmpty(directoryInGuiString)) {
            Path directoryInGuiPath = Paths.get(directoryInGuiString);
            if (Files.exists(directoryInGuiPath) && Files.isDirectory(directoryInGuiPath)) {
                fileChooser.setInitialDirectory(new File(directoryInGuiString));
            }
        }

        File file = fileChooser.showOpenDialog(welcomeText.getScene().getWindow());
        if (file != null) {
            inputFileTextField.setText(file.getAbsolutePath());
        }
    }

    @FXML
    public void onDefineOutputFileButtonClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("NTCS Ziel Datei");

        FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(csvFilter);

        File file = fileChooser.showSaveDialog(welcomeText.getScene().getWindow());
        if (file != null) {
            outputFileTextField.setText(file.getAbsolutePath());
        }
    }

    private void messageBox(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean isFilenameValid(String fileName) {
        File f = new File(fileName);
        try {
            return StringUtils.equals(f.getCanonicalFile().getAbsolutePath(), fileName);
        } catch (IOException e) {
            return false;
        }
    }

    private void storeBmd55InputFilePath(Path bmd55InputFilePath) {
        storeProperty("BMD55InputFilePath", bmd55InputFilePath.getParent().toString());
    }

    private void storeNtscOutputFilePath(Path ntscOutputFilePath) {
        storeProperty("NTSCOutputFilePath", ntscOutputFilePath.getParent().toString());
    }

    private void storeProperty(String key, String value) {
        try {
            //FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
            //        new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
            //                .configure(new Parameters().properties()
            //                        .setFileName("tdTools.properties")
            //                        .setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
            Configuration config = getConfiguration();
            config.setProperty(key, value);
            builder.save();
        } catch (ConfigurationException e) {
            //messageBox(e.getMessage(), "", ExceptionUtils.getStackTrace(e), Alert.AlertType.ERROR);
            e.printStackTrace();
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    private String loadBmd55InputFilePath() {
        try {
            return getConfiguration().getString("BMD55InputFilePath");
        } catch (ConfigurationException e) {
            return StringUtils.EMPTY;
        }
    }

    private String loadNtscOutputFilePath() {
        try {
            return getConfiguration().getString("NTSCOutputFilePath");
        } catch (ConfigurationException e) {
            return StringUtils.EMPTY;
        }
    }

    private Configuration getConfiguration() throws ConfigurationException {
        //FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
        //        new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
        //                .configure(new Parameters().properties()
        //                        .setFileName("tdTools.properties")
        //                        .setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
        return builder.getConfiguration();
    }
}