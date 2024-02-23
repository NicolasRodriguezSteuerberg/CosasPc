package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Metodos {
    DataOutputStream dos;
    DataInputStream dis;
    
    public void initializeStreams(Socket newSocket) throws IOException{
        dos = (new  DataOutputStream(newSocket.getOutputStream()));
        dis = (new DataInputStream(newSocket.getInputStream()));
    }
    
    
    
    
}
