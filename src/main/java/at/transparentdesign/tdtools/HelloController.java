package at.transparentdesign.tdtools;

import at.transparentdesign.tdtools.loader.Bmd55FileLoader;
import at.transparentdesign.tdtools.loader.FileLoader;
import at.transparentdesign.tdtools.parser.Satzart0FIBUBuchungssatzParser;
import at.transparentdesign.tdtools.satz.Satzart0FIBUBuchungssatz;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.nio.file.Path;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        //welcomeText.setText("Welcome to JavaFX Application!");

        FileLoader fileLoader = new Bmd55FileLoader();
        Satzart0FIBUBuchungssatzParser satzart0FIBUBuchungssatzParser = new Satzart0FIBUBuchungssatzParser();
        try {
            List<String> records = fileLoader.loadFileToLines(Path.of("./examples/buerf_20250508-142243_v.txt"), true);

            System.out.println("Anzahl an Feldern:" + records.size());

            for (String record : records) {
               Satzart0FIBUBuchungssatz satzart0FIBUBuchungssatz = satzart0FIBUBuchungssatzParser.parse(record);
               System.out.println(satzart0FIBUBuchungssatz);
            }
            welcomeText.setText(records.toString());
        } catch (Exception e) {
            welcomeText.setText(e.getMessage()); //throw new RuntimeException(e);
        }
    }
}