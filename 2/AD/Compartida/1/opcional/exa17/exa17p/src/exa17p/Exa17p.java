package exa17p;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.xml.stream.XMLStreamException;

public class Exa17p {

    public static void main(String[] args) throws SQLException, FileNotFoundException, XMLStreamException {
        Metodos obx = new Metodos();
        String ruta = "/media/sf_Compartida/opcional/exa17/examen17/pedidos.xml";
        Connection con = obx.dbConection();
        
        obx.leerXML(ruta, con);
        
        obx.closeConection(con);
    }
    
}
