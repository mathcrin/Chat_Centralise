package fr.uphf.tp_architecture_des_applications_internet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientChatController {
    @FXML
    private TextArea txtAreaMsg;

    @FXML
    private Button btnEnvoyer;

    @FXML
    private TextFlow txtFlowChat;
    private Socket clientSocket;
    private DataOutputStream dout;
    private ThreadClientView threadClient;
    private String pseudo;

    public void connexion(String pseudo){
        this.pseudo=pseudo;
        try {
            clientSocket = new Socket("localhost", 7777);
            threadClient = new ThreadClientView(clientSocket, this);
            threadClient.start();
            dout = new DataOutputStream(clientSocket.getOutputStream());
            dout.writeUTF(pseudo+" est connecté...");
            dout.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void onEnvoyerClick(ActionEvent event) throws IOException {
        String message = txtAreaMsg.getText();
        dout.writeUTF(pseudo+" : "+message);
        txtAreaMsg.clear();
    }

    @FXML
    public void onDeconnexionClick(ActionEvent event) {
        try {
            dout.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TextFlow getTxtFlowChat() {
        return txtFlowChat;
    }

    public void close () throws IOException {
        dout.writeUTF(pseudo+" est deconnecté...");
        dout.writeUTF("exit");
        dout.flush();
        dout.close();
        threadClient.close();
        threadClient.interrupt();
    }
}