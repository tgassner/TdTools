package at.transparentdesign.tdtools;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        //welcomeText.setText("Welcome to JavaFX Application!");

        FileLoader fileLoader = new Bmd55FileLoader();
        try {
            List<String> records = fileLoader.loadFileToLines(Path.of("./examples/buerf_20250415-134848_v.txt"), true);
            welcomeText.setText(records.toString());
        } catch (Exception e) {
            welcomeText.setText(e.getMessage()); //throw new RuntimeException(e);
        }
    }
}