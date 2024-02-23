package chatcliente;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;


public class ChatCliente {

    public static void main(String[] args) throws IOException {
        String ip = JOptionPane.showInputDialog("Dime la ip del chat");
        int puerto = Integer.parseInt(JOptionPane.showInputDialog("Dime el puerto del chat"));
        Socket clienteSocket = new Socket();
        System.out.println("Estableciendo la conexion");
        
        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
        clienteSocket.connect(addr);
        
        Metodos obx = new Metodos();
        obx.initializeStreams(clienteSocket);
        if(obx.getEntryChat()){
            ThreadLeer miThread = new ThreadLeer(obx);
            miThread.start();
            obx.sendMensaje();
        }
    }
    
}
