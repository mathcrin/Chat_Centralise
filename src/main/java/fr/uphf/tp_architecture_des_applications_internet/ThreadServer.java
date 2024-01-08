package fr.uphf.tp_architecture_des_applications_internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ThreadServer extends Thread {

    Socket comm;
    public ThreadServer(Socket comm)
    {

        this.comm = comm;

    }
    @Override
    public void run() {
        try {
            DataInputStream dout = new DataInputStream(comm.getInputStream());
            String s;
            while (true) {
                s= dout.readUTF();
                if(s.compareTo("exit")==0){
                    Serveur.listClient.remove(comm);
                    comm.close();
                    break;
                }else{
                    System.out.println(s);
                    for(Socket socket : Serveur.listClient){
                        DataOutputStream dout1 = new DataOutputStream(socket.getOutputStream());
                        dout1.writeUTF(s);
                    }
                }


        }
        } catch (Exception e) {
            System.err.println("exception ..");
        }
        }
    }

