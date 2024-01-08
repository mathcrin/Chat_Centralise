package fr.uphf.tp_architecture_des_applications_internet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Serveur  {
    static ArrayList<Socket> listClient = new ArrayList<>();

    public static void main(String[] args){
        try{
            ServerSocket conn = new ServerSocket(7777);
            System.out.println("Serveur crée...");
           while(true){
                Socket comm = conn.accept();
                listClient.add(comm);
                ThreadServer threadServer = new ThreadServer(comm);
                threadServer.start();
            }

        } catch (IOException ex){
            Logger.getLogger(ServerSocket.class.getName()).log( Level.SEVERE, null, ex);
        }
    }
}
