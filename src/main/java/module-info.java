module at.transparentdesign.tdtools {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;

    requires org.apache.commons.lang3;

    opens at.transparentdesign.tdtools to javafx.fxml;
    exports at.transparentdesign.tdtools;
    exports at.transparentdesign.tdtools.loader;
    opens at.transparentdesign.tdtools.loader to javafx.fxml;
    exports at.transparentdesign.tdtools.satz;
    opens at.transparentdesign.tdtools.satz to javafx.fxml;
}