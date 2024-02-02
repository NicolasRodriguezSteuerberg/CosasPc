package calculadoracliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    DataOutputStream dos;
    DataInputStream dis;
    int[] numbers = new int[2];

    public void connect() throws IOException{
        Socket clienteSocket = new Socket();
        System.out.println("Estableciendo la conexion");
        
        InetSocketAddress addr = new InetSocketAddress("192.168.0.1", 6666);
        clienteSocket.connect(addr);
        
        setIs(clienteSocket.getInputStream());
        setOs(clienteSocket.getOutputStream());
        setDos(new  DataOutputStream(os));
        setDis(new DataInputStream(is));
    }
    
    public void getOperationOptions() throws IOException{
        // Leemos la longitud del mensaje
        int dataLength = dis.readInt();

        // leemos el array de bytes
        byte[] receivedData = new byte[dataLength];
        dis.readFully(receivedData);

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

        dos.writeInt(mensajeMandarBytes.length);
        dos.write(mensajeMandarBytes);
    }
    
    public void sendOperaciones() throws IOException{
        for (int i = 0; i < 2; i++) {
            numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("TECLEE EL " + (i+1) + " OPERANDO"));
        }

        // Obtener la longitud del array
        int arrayLength = numbers.length;

        // Enviar la longitud del array
        dos.writeInt(arrayLength);
        
        // Enviar los numeros
        for (int i = 0; i < arrayLength; i++) {
            dos.writeInt(numbers[i]);
        }
    }
    
    public boolean receiveCalculation() throws IOException{
        // Leemos la longitud del mensaje
        int messageLength = dis.readInt();
        
        // Leemos el mensaje como array de bytes
        byte[] mensajeBytes = new byte[messageLength];
        dis.readFully(mensajeBytes);
        
        // Convertimos los bytes a String
        String receivedString = new String(mensajeBytes);
        
        // lo pasamos a array
        String[] receivedArray = receivedString.split(",");
        
        boolean isContinue = sendContinueResult(receivedArray);
        sendContinue(isContinue);
        return isContinue;
    }
    
    
    public void sendContinue(boolean isContinue) throws IOException{
        dos.writeBoolean(isContinue);
    }
    
    public boolean sendContinueResult(String[] array){
        String[] options = new String[]{array[1],array[2]};
        int choice = JOptionPane.showOptionDialog(
                null, 
                "Tu operacion es de\n" + array[0],
                "VENTANA CLIENTE", 0, 0,
                null,
                options,
                options[1]
        );
        
        if(choice == 0){
            return true;
        } else{
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
