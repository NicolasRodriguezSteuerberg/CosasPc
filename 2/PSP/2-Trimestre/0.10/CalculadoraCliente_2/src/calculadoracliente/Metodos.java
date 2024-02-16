package calculadoracliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Metodos {
    InputStream is;
    OutputStream os;
    DataOutputStream dos;
    DataInputStream dis;
    int[] numbers = new int[2];
    ObjectInputStream ois;
    JLabel operationLabel;

    public void connect() throws IOException{
        Socket clienteSocket = new Socket();
        System.out.println("Estableciendo la conexion");
        
        InetSocketAddress addr = new InetSocketAddress("192.168.0.1", 6666);
        clienteSocket.connect(addr);
        
        setIs(clienteSocket.getInputStream());
        setOs(clienteSocket.getOutputStream());
        setDos(new  DataOutputStream(os));
        setDis(new DataInputStream(is));
        
        ois = new ObjectInputStream(clienteSocket.getInputStream());
    }
    
    public void sendOperation() throws IOException{
        // get operation from client
        String operation = JOptionPane.showInputDialog("Teclee la operacion");
        
        // send the operation to the server
        byte[] sendMessageOperation = operation.getBytes();

        dos.writeInt(sendMessageOperation.length);
        dos.write(sendMessageOperation);
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
        String[] receivedArray = receivedString.split("_");
        if(receivedArray[0].equals("null")){
            JOptionPane.showMessageDialog(null, "TU OPERACION NO ESTÁ BIEN FORMADA POR FAVOR INGRESE UNA VALIDA");
            sendContinue(true);
            // retorno true por que así ya le saca el mensaje de operación
            return true;
        }
        
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
