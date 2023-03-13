package ficheroSerializado;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


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
