module com.arcreane.wordscambler {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.arcreane.wordscambler to javafx.fxml;
    exports com.arcreane.wordscambler;
}