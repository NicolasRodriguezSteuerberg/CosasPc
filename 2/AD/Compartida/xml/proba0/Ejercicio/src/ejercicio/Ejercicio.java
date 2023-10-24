package ejercicio;

import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

public class Ejercicio {

    public static void main(String[] args) throws IOException, XMLStreamException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        String ruta = "/media/sf_Compartida/xml/proba0/mixml.xml";
        obx.leerXML(ruta);
    }
    
}
