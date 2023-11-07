package exa15brevep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.stream.XMLStreamException;


public class PreExamen {

    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException, SQLException, SQLException, SQLException, SQLException, XMLStreamException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        String ruta = "/media/sf_Compartida/exa15prev/platoss";
        String rutaEsc = "/media/sf_Compartida/exa15prev/platos.xml";
        obx.lecturaSerializada(ruta, rutaEsc);
    }
    
}
