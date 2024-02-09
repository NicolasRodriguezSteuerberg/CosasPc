package calculadoraserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class CalculadoraServer {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ServerSocket serverSocket = new ServerSocket();

        InetSocketAddress addr=new InetSocketAddress("192.168.0.1",6666);
        System.out.println("Esperando conexion");
        serverSocket.bind(addr);
        
        while(true){
            Socket newSocket = serverSocket.accept();
            System.out.println("Conexion realizada");
            ClientHandler clientThread = new ClientHandler(newSocket);
            clientThread.start();
        }
        
        
    }
    
}
