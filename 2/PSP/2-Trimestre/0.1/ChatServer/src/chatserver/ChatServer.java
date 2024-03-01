package chatserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;


public class ChatServer {
    
    static int genteConectada = 0;
    final static int genteMaxima = 3;

    public static void main(String[] args) throws IOException {
        Metodos obx = new Metodos();
        obx.initializeStreams();
    }
    
}
