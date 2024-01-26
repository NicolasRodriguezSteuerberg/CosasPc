package calculadoracliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.swing.JOptionPane;


public class Metodos {
    InputStream is;
    OutputStream os;
    int[] numbers = new int[2];

    public void connect() throws IOException{
        Socket clienteSocket = new Socket();
        System.out.println("Estableciendo la conexion");
        
        InetSocketAddress addr = new InetSocketAddress("192.168.0.1", 6666);
        clienteSocket.connect(addr);
        
        setIs(clienteSocket.getInputStream());
        setOs(clienteSocket.getOutputStream());
    }
    
    public void getOperationOptions() throws IOException{
        byte[] lengthBuffer = new byte[4];
        is.read(lengthBuffer);
        int dataLength = ByteBuffer.wrap(lengthBuffer).getInt();

        // Recibir el array de bytes
        byte[] receivedData = new byte[dataLength];
        is.read(receivedData);

        // Convertir los bytes a un string
        String receivedString = new String(receivedData);

        // Dividir el string en un array de strings utilizando el delimitador ","
        String[] receivedArray = receivedString.split(",");
        
        // enviar el operando
        sendOperando(receivedArray);
    }
    
    public void sendOperando(String[] operandos) throws IOException{
        int choice = JOptionPane.showOptionDialog(
                null, 
                "Elige el operando",
                "VENTANA CLIENTE", 0, 0,
                null,
                operandos,
                operandos[0]
        );
        
        String mensajeMandar = operandos[choice];
        byte[] mensajeMandarBytes = mensajeMandar.getBytes();

        os.write(ByteBuffer.allocate(4).putInt(mensajeMandarBytes.length).array()); // Enviamos la longitud del mensaje
        os.write(mensajeMandarBytes);
    }
    
    public void sendOperaciones() throws IOException{
        numbers[0] = Integer.parseInt(JOptionPane.showInputDialog("TECLEE 1 OPERANDO"));

        // Obtener la longitud del array
        int arrayLength = numbers.length;

        // Enviar la longitud del array
        os.write(ByteBuffer.allocate(4).putInt(arrayLength).array());

        // Enviar el array de enteros
        ByteBuffer intBuffer = ByteBuffer.allocate(4 * arrayLength);
        IntBuffer intBufferData = intBuffer.asIntBuffer();
        intBufferData.put(numbers);
        os.write(intBuffer.array());
    }
    
    public void getContinueMessage(){
        
    }
    
    public void sendContinue(){
        
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
