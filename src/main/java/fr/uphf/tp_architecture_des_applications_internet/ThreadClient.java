package fr.uphf.tp_architecture_des_applications_internet;

import java.io.DataInputStream;
import java.net.Socket;
public class ThreadClient extends Thread{
    Socket comm ;
    public ThreadClient(Socket comm) {

        this.comm = comm;
    }
    @Override
    public void run() {
        try {
        DataInputStream dout = new DataInputStream(comm.getInputStream());
        while (true) {
                String s = dout.readUTF();
                System.out.println("" + s);
        }
        } catch (Exception e) {
            System.err.println("exception ..");
        }
    }
}

