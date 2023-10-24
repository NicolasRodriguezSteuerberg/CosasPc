package xml2;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;


public class Xml2 {


    public static void main(String[] args) throws ClassNotFoundException, IOException, FileNotFoundException, FileNotFoundException, XMLStreamException, XMLStreamException, XMLStreamException, XMLStreamException {
        Metodos obx = new Metodos();
        String rutaEsc = "/media/sf_Compartida/xml/ejercicio2/products.xml";
        String rutaLeer = "/media/sf_Compartida/Serializacion/2/texto.txt";
        //obx.escribirProducts(rutaEsc, rutaLeer);
        obx.leer(rutaEsc);
    }
    
}
