package fr.uphf.tp_architecture_des_applications_internet;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadClientView extends Thread {
    private Socket comm;
    private ClientChatController clientChatController;

    public ThreadClientView(Socket comm, ClientChatController clientChatController) {
        this.comm = comm;
        this.clientChatController = clientChatController;
    }

    @Override
    public void run() {
        try {
            DataInputStream dout = new DataInputStream(comm.getInputStream());

            while (true) {
                String s = dout.readUTF();

                Platform.runLater(() -> {
                    TextFlow txtFlowChat = clientChatController.getTxtFlowChat();
                    Text text=new Text(s + "\n");
                    txtFlowChat.getChildren().add(text);
                });
                Thread.sleep(20);

            }
        } catch (Exception e) {
            System.err.println("Exception...");
        }
    }
    public void close() throws IOException {
        comm.close();
    }
}

