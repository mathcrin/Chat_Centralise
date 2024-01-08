package fr.uphf.tp_architecture_des_applications_internet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientView extends Application {

    private static ClientChatController clientChatController;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(ClientView.class.getResource("ClientUsername.fxml")));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setOnCloseRequest(event -> {
                try {
                    if (clientChatController != null) clientChatController.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToChatScene(Stage stage, String pseudo) throws Exception {
        clientChatController = SceneController.switchToChatScene(stage, pseudo);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
