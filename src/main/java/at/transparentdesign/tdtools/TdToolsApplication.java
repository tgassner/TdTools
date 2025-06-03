package at.transparentdesign.tdtools;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;

public class TdToolsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TdToolsApplication.class.getResource("tdToolsMain-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("TD Tools");
        stage.setScene(scene);
        stage.show();

        stage.getIcons().add(new Image("icon.png"));

        ModuleDescriptor descriptor = getClass().getModule().getDescriptor();
        if (descriptor.version().isPresent()) {
            String version = descriptor.version().get().toString();
            stage.setTitle(stage.getTitle() + " - " + StringUtils.defaultIfBlank(version, "DEVELOPMENT"));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}