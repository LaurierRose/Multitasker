module com.example.multitasker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.multitasker to javafx.fxml;
    exports com.example.multitasker;
    exports com.example.multitasker.controller;
    opens com.example.multitasker.controller to javafx.fxml;
}