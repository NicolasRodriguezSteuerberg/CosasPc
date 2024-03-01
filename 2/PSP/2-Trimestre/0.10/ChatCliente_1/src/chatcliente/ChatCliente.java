package chatcliente;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;


public class ChatCliente {

    public static void main(String[] args) throws IOException {
        String ip = null;
        do{
            ip = JOptionPane.showInputDialog("Dime la ip del chat");
        } while(ip==null);
        int puerto = 0;
        do{
            puerto = Integer.parseInt(JOptionPane.showInputDialog("Dime el puerto del chat"));
        } while (puerto == 0);
        String nickname = null;
        do{
            nickname = JOptionPane.showInputDialog("Teclee tu nickname");
        }while(nickname==null);
        Socket clienteSocket = new Socket();
        System.out.println("Estableciendo la conexion");
        
        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
        clienteSocket.connect(addr);
        
        Metodos obx = new Metodos();
        obx.initializeStreams(clienteSocket, nickname);
        if(obx.getEntryChat()){
            obx.sendNickname();
            ThreadLeer miThread = new ThreadLeer(obx);
            miThread.start();
            obx.sendMensaje();
        }
    }
    
}
