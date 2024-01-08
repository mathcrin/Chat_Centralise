module fr.uphf.tp_architecture_des_applications_internet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.logging;

    opens fr.uphf.tp_architecture_des_applications_internet to javafx.fxml;
    exports fr.uphf.tp_architecture_des_applications_internet;
}