package fr.uphf.tp_architecture_des_applications_internet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 7777);
            ThreadClient threadClient = new ThreadClient(client);
            threadClient.start();
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());

            Scanner scan = new Scanner(System.in);
            System.out.println("Entrer un nom d'utilisateur...");
            String pseudo = scan.nextLine();
            dout.writeUTF(pseudo + " est connecté...");
            dout.flush();
            String text = "";
            while (!text.equals("exit")) {
                text = scan.nextLine();

                if (text.equals("exit")) {
                    String deco = (pseudo + " est deconnecté...");
                    ;
                    dout.writeUTF(deco);

                } else {
                    dout.writeUTF(pseudo + ":" + text);
                    dout.flush();
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

