package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadCliente extends Thread{
    DataInputStream dis;
    DataOutputStream dos;
    String nickname;
    
    
    public ThreadCliente(DataInputStream dis, DataOutputStream dos, String nickname){
         this.dis = dis;
         this.dos = dos;
         this.nickname = nickname;
    }
    
    public void run(){
        try {
            String mensaje;
            int messageLenght;
            byte[] messageBuffer;
            do{
                messageLenght = dis.readInt();
                messageBuffer = new byte[messageLenght];
                dis.readFully(messageBuffer);
                mensaje = new String(messageBuffer);
                if(!mensaje.contains("/bye")){
                    Metodos.sendMessages(mensaje);
                }
            }while(!mensaje.contains("/bye"));
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Metodos.nConnectedClients--;
            
            if(Metodos.nConnectedClients == 0){
                System.out.println("");
                System.out.println("Ningun cliente conectado");
            } else{
                System.out.println("Hay: " + Metodos.nConnectedClients + " conectados");
                Metodos.connectedClients.remove(dos);
                String mensaje = nickname + ": dejo el chat";
                Metodos.sendMessages(mensaje);
                
                int option = JOptionPane.showConfirmDialog(null, "Quieres cerrar conexion?");
                if(option == 0){
                    Metodos.serverRunning = false;
                }
                
                if(!Metodos.serverRunning){
                    synchronized(Metodos.connectedClients){
                        String mensaje2 = "Se cerro el servidor";
                        Metodos.sendMessages(mensaje2);
                        byte[] mensajeBytes = mensaje2.getBytes();
                        try{
                            Metodos.serverSocket.close();
                            System.out.println("SERVIDOR DESCONECTADO");
                            System.exit(0);
                        } catch (IOException ex) {
                            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
        }
    }
}
