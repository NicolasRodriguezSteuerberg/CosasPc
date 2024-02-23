package chatcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Metodos {
    String nickname;
    
    DataOutputStream dos;
    DataInputStream dis;
    Socket newSocket;
    
    public void initializeStreams(Socket newSocket) throws IOException{
        this.newSocket = newSocket;
        dos = (new  DataOutputStream(this.newSocket.getOutputStream()));
        dis = (new DataInputStream(this.newSocket.getInputStream()));
    }
    
    public void leerMensaje() throws IOException{
        int messageLenght;
        byte[] messageBuffer;
        String mensaje;
        
        while(!newSocket.isClosed()){
            messageLenght = dis.readInt();
            messageBuffer = new byte[messageLenght];
            dis.readFully(messageBuffer);
            
            mensaje = new String(messageBuffer);
            System.out.println(mensaje);
        }
    }
    
    public void sendMensaje() throws IOException{
        Scanner sc = new Scanner(System.in);
        String mensaje="";
        byte[] mensajeEnviarBytes;
        
        while(!mensaje.equals("/bye")){
            mensaje = nickname + ": " + sc.next();
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
    
    public void cerrarConexion() throws IOException{
        this.newSocket.close();
    }
}
