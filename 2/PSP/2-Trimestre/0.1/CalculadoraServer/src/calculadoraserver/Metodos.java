package calculadoraserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;


public class Metodos {
    InputStream is;
    OutputStream os;
    DataOutputStream dos;
    DataInputStream dis;
    String operaciones = "+,-,*,/";
    String operando;
    int numbers[] = new int[2];
    
    
    public void waitingConnection() throws IOException{
        ServerSocket serverSocket = new ServerSocket();

        InetSocketAddress addr=new InetSocketAddress("192.168.0.1",6666);
        System.out.println("Esperando conexion");
        serverSocket.bind(addr);
       
        Socket newSocket = serverSocket.accept();
        System.out.println("Conexion realizada");
        setIs(newSocket.getInputStream());
        setOs(newSocket.getOutputStream());
        setDos(new  DataOutputStream(os));
        setDis(new DataInputStream(is));
    }
    
    
    public void sendPosibilityOperations() throws IOException{
        byte[] mensajeEnviarBytes = operaciones.getBytes();
        // convertimos el mensaje en un ByteBuffer y lo pasamos a array
        dos.writeInt(mensajeEnviarBytes.length);
        // enviamos el mensaje
        dos.write(mensajeEnviarBytes);
    }
    
    public void getOperando() throws IOException{
        // Leemos la longitud del mensaje
        int messageLength = dis.readInt();
        
        //Leemos el mensaje como array de bytes
        byte[] messageBuffer = new byte[messageLength];
        dis.readFully(messageBuffer);
        
        // convertimos los bytes a String
        operando = new String(messageBuffer);
        System.out.println(operando);
    }
    
    public void getNumbers() throws IOException{
        // recibir la longitud
        int arrayLength = dis.readInt();

        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = dis.readInt();
            System.out.println(numbers[i]);
        }
    }
    
    public void sendCalculation() throws IOException{
        // hacemos el calculo
        int calc = doCalculation();
        // send mensaje
        String mandar = calc + ",nuevo,finalizar";
        byte[] mensajeEnviarBytes = mandar.getBytes();
        
        // Enviamos la longitud del mensaje
        dos.writeInt(mensajeEnviarBytes.length);
        // enviamos el mensaje
        dos.write(mensajeEnviarBytes);
    }
    
    public int doCalculation(){
        switch(operando){
            case "+":
                return numbers[0] + numbers[1];
            case "-":
                return numbers[0] - numbers[1];
            case "*":
                return numbers[0] * numbers[1];
            case "/":
                return numbers[0] / numbers[1];
            default:
                return 0;
        }
    }
    
    public boolean getContinuation() throws IOException{
        boolean isContinue = dis.readBoolean();
        return isContinue;
    }
    
    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public DataOutputStream getDos() {
        return dos;
    }

    public void setDos(DataOutputStream dos) {
        this.dos = dos;
    }

    public DataInputStream getDis() {
        return dis;
    }

    public void setDis(DataInputStream dis) {
        this.dis = dis;
    }
    
    
    
    
    
    
}
