package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class Metodos {
    // escribir
    DataOutputStream dos;
    // leer
    DataInputStream dis;
    static final int MAX_CLIENTES = 2;
    public static Set<DataOutputStream> connectedClients = new HashSet<>();
    static int nConnectedClients=0;
    String nickname;
    private String accept = "si";
    private String dennied = "no";
    
    static boolean serverRunning = true;
    
    static ServerSocket serverSocket;
    
    public void initializeStreams() {
        try{
        System.out.println("Esperando conexion");
        serverSocket = new ServerSocket();
        int puerto = Integer.parseInt(JOptionPane.showInputDialog("Que puerto quieres usar?"));
        InetSocketAddress addr=new InetSocketAddress("192.168.0.1",puerto);
        serverSocket.bind(addr);
        System.out.println("Ningun cliente conectado");
        while(serverRunning){
            // aceptamos los clientes
            Socket socketCliente = serverSocket.accept();
            if (connectedClients.size() < MAX_CLIENTES){
                nConnectedClients++;
                System.out.println("Hay: " + nConnectedClients + " conectados");
                dos = (new  DataOutputStream(socketCliente.getOutputStream()));
                dis = (new DataInputStream(socketCliente.getInputStream()));
                sendEntryChat(accept);
                nickname = receiveNickname();
                
                // lo añadimos a la lista
                connectedClients.add(dos);
                
                sendMessages((nickname + " se ha conectado"));
                
                new ThreadCliente(dis, dos, nickname).start();
            } else{
                dos = (new  DataOutputStream(socketCliente.getOutputStream()));
                dis = (new DataInputStream(socketCliente.getInputStream()));
                sendEntryChat(dennied);
            }
        }
        } catch(IOException ex){
            System.out.println("Aviso: " + ex);
        }
    }
    
    public static void sendMessages(String mensaje){
        System.out.println(mensaje);
        byte[] mensajeBytes = mensaje.getBytes();
        synchronized(connectedClients){
            for(DataOutputStream clientWrite: connectedClients){
                try {
                    clientWrite.writeInt(mensajeBytes.length);
                    clientWrite.write(mensajeBytes);
                } catch (IOException ex) {

                }
            }
        }
    }
    
    public void sendEntryChat(String mensaje) throws IOException{
        byte[] mensajeEnviarBytes = mensaje.getBytes();
        dos.writeInt(mensajeEnviarBytes.length);
        dos.write(mensajeEnviarBytes);
    }
    
    public String receiveNickname() throws IOException{
        int messageLenght = dis.readInt();
        byte[] messageBuffer = new byte[messageLenght];
        dis.readFully(messageBuffer);
        return new String(messageBuffer);
    }
}
