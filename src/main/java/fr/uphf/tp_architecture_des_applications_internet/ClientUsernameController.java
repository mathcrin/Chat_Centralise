package fr.uphf.tp_architecture_des_applications_internet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientUsernameController {
    @FXML
    private TextField txtInpNom;


    @FXML
    protected void onConnexionClick(ActionEvent event) throws Exception {
        String pseudo = txtInpNom.getText();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ClientView.switchToChatScene(stage,pseudo);
    }

}
