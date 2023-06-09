module com.example.sae201 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.logging;
    requires jdk.jsobject;
    requires javafx.web;
    requires org.apache.commons.csv;
    requires com.gluonhq.maps;

    opens com.example.sae201 to javafx.fxml;
    exports com.example.sae201;
}