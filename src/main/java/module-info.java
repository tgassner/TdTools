module at.transparentdesign.tdtools {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;

    requires org.apache.commons.lang3;
    requires org.apache.commons.csv;
    requires org.apache.commons.configuration2;
    requires org.apache.commons.beanutils;

    //requires org.apache.commons.commons-cli:commons-cli:1.9.0")
    //requires org.apache.commons:commons-csv:1.14.0")
    //requires org.apache.commons:commons-text:1.13.1")
    //requires org.apache.commons:commons-collections4:4.5.0")
    //requires org.apache.commons:commons-configuration2:2.12.0")
    //requires commons-io:commons-io:2.19.0")


    opens at.transparentdesign.tdtools to javafx.fxml;
    exports at.transparentdesign.tdtools;
    exports at.transparentdesign.tdtools.loader;
    opens at.transparentdesign.tdtools.loader to javafx.fxml;
    exports at.transparentdesign.tdtools.satz;
    opens at.transparentdesign.tdtools.satz to javafx.fxml;
}