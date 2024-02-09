package calculadoraserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.Socket;
import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Metodos {
    InputStream is;
    OutputStream os;
    DataOutputStream dos;
    DataInputStream dis;
    ObjectOutputStream oos;
    String operacion;
    ScriptEngineManager manager;
    DecimalFormat formato;
    
    
    public void initializeStreams(Socket newSocket) throws IOException{
        setIs(newSocket.getInputStream());
        setOs(newSocket.getOutputStream());
        setDos(new  DataOutputStream(os));
        setDis(new DataInputStream(is));
        manager = new ScriptEngineManager();
        formato = new DecimalFormat("#.##");
        oos = new ObjectOutputStream(newSocket.getOutputStream());
    }
    
    public void sendButtons() throws IOException{
        String buttonLabels = "7_8_9_*_4_5_6_-_1_2_3_+_0_._/_=";
        
        byte[] mensajeEnviarBytes = buttonLabels.getBytes();
        
        // Enviamos la longitud del mensaje
        dos.writeInt(mensajeEnviarBytes.length);
        // enviamos el mensaje
        dos.write(mensajeEnviarBytes);
    }
    
    public void getOperation() throws IOException, ScriptException{
        // Leemos la longitud del mensaje
        int messageLength = dis.readInt();
        
        // Leemos el mensaje
        byte[] messageBuffer = new byte[messageLength];
        dis.readFully(messageBuffer);
        
        // convertimos los bytes a String
        operacion = new String(messageBuffer);
        System.out.println(operacion);
    }
    
    @SuppressWarnings("removal")
    public double calculation(){
        ScriptEngine engine = manager.getEngineByName("js");
        try{
            Object resultado = engine.eval(new StringReader(operacion));
            return Double.parseDouble(resultado.toString());
        } catch(ScriptException e){
            e.printStackTrace();
            return Double.NaN;
        }
    }
    
    public void sendCalculation() throws IOException, ScriptException{
        // hacemos el calculo
        Double result = calculation();
        String calc;
        if(result.isNaN()){
            calc = "null";
        } else{
            calc = formato.format(result);
        }
        System.out.println(calc);
        // send mensaje
        String mandar = calc + "_nuevo_finalizar";
        byte[] mensajeEnviarBytes = mandar.getBytes();
        
        // Enviamos la longitud del mensaje
        dos.writeInt(mensajeEnviarBytes.length);
        // enviamos el mensaje
        dos.write(mensajeEnviarBytes);
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
