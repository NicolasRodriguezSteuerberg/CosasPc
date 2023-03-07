/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheroSerializado;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author dam1
 */
public class MeuObjectOutputStream extends ObjectOutputStream{
    
    public MeuObjectOutputStream () throws IOException{
        super();
    }
    
    public MeuObjectOutputStream (OutputStream ou) throws IOException{
        super(ou);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        
    }
    
    
}
