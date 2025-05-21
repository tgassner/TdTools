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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public TextField inputFileTextField;
    @FXML
    public TextField outputFileTextField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onDoBookingConvertationClick() {
        String inputFileStr = inputFileTextField.getText();
        Path inputFilePath = Path.of(inputFileStr);

        //welcomeText.setText("Welcome to JavaFX Application!");
        if (StringUtils.isEmpty(inputFileStr) || !Files.exists(inputFilePath)) {
            messageBox("Keine existierende Datei ausgewählt", "Bitte eine Datei auswählen", "", Alert.AlertType.INFORMATION);
            return;
        }

        FileLoader fileLoader = new Bmd55FileLoader();
        Satzart0FIBUBuchungssatzParser satzart0FIBUBuchungssatzParser = new Satzart0FIBUBuchungssatzParser();
        try {
            List<String> records = fileLoader.loadFileToLines(inputFilePath, true);

            System.out.println("Anzahl an Feldern:" + records.size());

            List<Satzart0FIBUBuchungssatz> saetze = new ArrayList<>();

            for (String record : records) {
               Satzart0FIBUBuchungssatz satzart0FIBUBuchungssatz = satzart0FIBUBuchungssatzParser.parse(record);
                saetze.add(satzart0FIBUBuchungssatz);
               System.out.println(satzart0FIBUBuchungssatz);
            }

            AusgangsrechnungWriter ausgangsrechnungWriter = new AusgangsrechnungWriter();
            ausgangsrechnungWriter.write(saetze);

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
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(welcomeText.getScene().getWindow());
        inputFileTextField.setText(file.getAbsolutePath());
    }

    @FXML
    public void onDefineOutputFileButtonClick(ActionEvent actionEvent) {
    }

    private void messageBox(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}