package chatcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Metodos {
    String nickname;
    
    DataOutputStream dos;
    DataInputStream dis;
    Socket newSocket;
    
    public void initializeStreams(Socket newSocket, String nickname) throws IOException{
        this.newSocket = newSocket;
        dos = (new  DataOutputStream(this.newSocket.getOutputStream()));
        dis = (new DataInputStream(this.newSocket.getInputStream()));
        this.nickname = nickname;
    }
    
    public void leerMensaje() throws IOException{
        int messageLenght;
        byte[] messageBuffer;
        String mensaje;
        
        do{
            messageLenght = dis.readInt();
            messageBuffer = new byte[messageLenght];
            dis.readFully(messageBuffer);
            
            mensaje = new String(messageBuffer);
            System.out.println(mensaje);
        } while(!mensaje.equalsIgnoreCase("Se cerro el servidor"));
        cerrarConexion();
    }
    
    public void sendMensaje() throws IOException{
        Scanner sc = new Scanner(System.in);
        String mensaje="";
        byte[] mensajeEnviarBytes;
        
        while(!mensaje.contains("/bye")){
            mensaje = nickname + ": " + sc.nextLine();
            if(!mensaje.equals("/bye")){
                mensajeEnviarBytes = mensaje.getBytes();
                dos.writeInt(mensajeEnviarBytes.length);
                dos.write(mensajeEnviarBytes);
            }
        }
        
        cerrarConexion();
    }
    
    public boolean getEntryChat() throws IOException{
        int messageLenght = dis.readInt();
        byte[] messageBuffer = new byte[messageLenght];
        dis.readFully(messageBuffer);
        
        String mensaje = new String(messageBuffer);
        if(mensaje.equals("no")){
            cerrarConexion();
            return false;
        } else{
            return true;
        }
    }
    
    public void sendNickname() throws IOException{
        byte[] mensajeBytes = nickname.getBytes();
        dos.writeInt(mensajeBytes.length);
        dos.write(mensajeBytes);
    }
    
    public void cerrarConexion() throws IOException{
        this.newSocket.close();
        System.exit(0);
    }
}
