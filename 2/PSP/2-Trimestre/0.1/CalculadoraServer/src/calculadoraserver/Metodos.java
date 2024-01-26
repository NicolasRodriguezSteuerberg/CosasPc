package calculadoraserver;

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
    }
    
    
    public void sendPosibilityOperations() throws IOException{
        byte[] mensajeEnviarBytes = operaciones.getBytes();
        // convertimos el mensaje en un ByteBuffer y lo pasamos a array
        os.write(ByteBuffer.allocate(4).putInt(mensajeEnviarBytes.length).array());
        // enviamos el mensaje
        os.write(mensajeEnviarBytes);
    }
    
    public void getOperando() throws IOException{
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
        operando = new String(messageBuffer);
    }
    
    public void getNumbers() throws IOException{
        byte[] lengthBuffer = new byte[4];            
        is.read(lengthBuffer);
        int arrayLength = ByteBuffer.wrap(lengthBuffer).getInt();

        // creamos un array de bytes igual al length de bytes
        // lo multiplicamos por 2 por que recibimos array de 2 numeros
        byte[] receivedData = new byte[2 * arrayLength];
        // coloca los bytes en el array
        is.read(receivedData);
        
        // convertimos los bytes al array
        IntBuffer intBuffer = ByteBuffer.wrap(receivedData).asIntBuffer();
        // transferimos los valores de intBuffer al array numbers
        intBuffer.get(numbers);
    }
    
    public void sendCalculation() throws IOException{
        // hacemos el calculo
        int calc = doCalculation();
        // send mensaje
        String mandar = calc + ",nuevo,finalizar";
        byte[] mensajeEnviarBytes = mandar.getBytes();
        // convertimos el mensaje en un ByteBuffer y lo pasamos a array
        os.write(ByteBuffer.allocate(4).putInt(mensajeEnviarBytes.length).array());
        // enviamos el mensaje
        os.write(mensajeEnviarBytes);
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
        byte[] lengthBuffer = new byte[4];
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
        String continuation = new String(messageBuffer);
        if (continuation.equalsIgnoreCase("nuevo")){
            return true;
        }
        else{
            return false;
        }
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
    
    
    
    
    
    
}
