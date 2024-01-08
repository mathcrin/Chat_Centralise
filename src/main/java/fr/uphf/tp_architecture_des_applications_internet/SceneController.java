package fr.uphf.tp_architecture_des_applications_internet;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneController {

    public static ClientChatController switchToChatScene(Stage stage, String pseudo) throws Exception {
        Parent root;
        Scene scene;
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("ClientChat.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ClientChatController clientChatController = loader.getController();
        clientChatController.connexion(pseudo);
        return clientChatController;
    }

}
