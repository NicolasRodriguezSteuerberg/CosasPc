package chatserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {
    
    static int genteConectada = 0;
    final static int genteMaxima = 3;

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket serverSocket = new ServerSocket();

        InetSocketAddress addr=new InetSocketAddress("192.168.0.1",6666);
        System.out.println("Esperando conexion");
        serverSocket.bind(addr);
        Socket serverSocket2 = new Socket();
        Metodos obx = new Metodos();
        
        while(true){
            if(genteConectada < genteMaxima){
                Socket newSocket = serverSocket.accept();
                System.out.println("Conexion realizada");
                
                ThreadCliente clientThread = new ThreadCliente(newSocket);
                clientThread.start();
            }
            
            
        }
    }
    
}
