package at.transparentdesign.tdtools;

import at.transparentdesign.tdtools.loader.Bmd55FileLoader;
import at.transparentdesign.tdtools.loader.FileLoader;
import at.transparentdesign.tdtools.parser.Satzart0FIBUBuchungssatzParser;
import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatz;
import at.transparentdesign.tdtools.writer.AusgangsrechnungWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public TextField inputFileTextField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onDoBookingConvertationClick() {

        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Keine existierende Datei ausgewählt");
        alert2.setHeaderText(inputFileTextField.getText());
        alert2.showAndWait();

        //welcomeText.setText("Welcome to JavaFX Application!");
        if (!Files.exists(Path.of(inputFileTextField.getText()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Keine existierende Datei ausgewählt");
            alert.setHeaderText("Bitte eine Datei auswählen");
            alert.setContentText("I have a great message for you!");
            alert.showAndWait();
            return;
        }


        FileLoader fileLoader = new Bmd55FileLoader();
        Satzart0FIBUBuchungssatzParser satzart0FIBUBuchungssatzParser = new Satzart0FIBUBuchungssatzParser();
        try {
            List<String> records = fileLoader.loadFileToLines(Path.of("./examples/buerf_20250508-142243_v.txt"), true);

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
            welcomeText.setText(e.getMessage()); //throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onOpenFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(welcomeText.getScene().getWindow());
        inputFileTextField.setText(file.getAbsolutePath());
    }
}