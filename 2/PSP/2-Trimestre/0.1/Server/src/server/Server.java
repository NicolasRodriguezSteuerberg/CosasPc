package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import javax.swing.JOptionPane;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Creando socket servidor");

        ServerSocket serverSocket = new ServerSocket();

        System.out.println("Realizando el bind");

        InetSocketAddress addr=new InetSocketAddress("192.168.0.1",6666);
        serverSocket.bind(addr);

        System.out.println("Aceptando conexiones");

        Socket newSocket = serverSocket.accept();

        System.out.println("Conexion recibida");

        InputStream is = newSocket.getInputStream();
        OutputStream os = newSocket.getOutputStream();


        // El mensaje recibir y enviar 3 veces repetido de continuo intercalado
        String mensajeMandar = "";
        String mensajeRecibido = "";
        while(!mensajeRecibido.equalsIgnoreCase("adios")){
            
            // Usamos un buffer de 4 bytes para almacenar la longitud del mensaje
            // para pasarlo a int necesitamos 32 bits (1 espacio de byte tiene 8), 4x8=32
            byte[] lengthBuffer = new byte[4];
            
            // is.read(lengthBuffer) -> el metodo read toma los bytes del flujo de entrada
            // y los coloca en el array de lengtBuffer
            is.read(lengthBuffer);
            
            // ByteBuffer -> (clase java que proporciona trabajar con datos binarios)
            // .wrap() -> crea objeto tipo ByteBuffer
            // .getInt() -> extrae un entero de 32 bits del buffer
            int messageLength = ByteBuffer.wrap(lengthBuffer).getInt();
            
            // creamos un array de bytes igual al length de bytes
            byte[] messageBuffer = new byte[messageLength];
            // coloca los bytes en el array
            is.read(messageBuffer);
            // convertimos los bytes a String
            mensajeRecibido = new String(messageBuffer);
            
            System.out.println("Mensaje del cliente: " + mensajeRecibido);
            
            if(mensajeRecibido.equalsIgnoreCase("adios")){
                mensajeMandar = "adios";
            } else{
                mensajeMandar = JOptionPane.showInputDialog("Que le quieres decir al cliente?");
            }
            
            // pasamos a bytes el mensaje que vamos a mandar
            byte[] mensajeEnviarBytes = mensajeMandar.getBytes();
            // ByteBuffer.allocate(4) -> crea un ByteBuffer de 4 bytes
            // .putInt( -> escribe la longitud del mensaje
            //.array() -> convierte el buffer en array
            os.write(ByteBuffer.allocate(4).putInt(mensajeEnviarBytes.length).array());
            // enviamos el mensaje
            os.write(mensajeEnviarBytes);
            
        }
        
        System.out.println("Cerrando el nuevo socket");
        newSocket.close();

        System.out.println("Cerrando el socket servidor");
        serverSocket.close();

        System.out.println("Terminado");
    }
}
