package xml2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import serializacion2.Product;


public class Metodos {
    
    public void escribirProducts(String rutaEsc, String rutaLeer) throws FileNotFoundException, IOException, ClassNotFoundException, XMLStreamException{
        // para leer la serializacion
        ObjectInputStream lec = null;
        Product obx = null;
        lec = new ObjectInputStream(new FileInputStream(rutaLeer));
        
        // para escribir el xml
        FileWriter obxFile = new FileWriter(rutaEsc);
        XMLOutputFactory obxFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter obxWriter = obxFactory.createXMLStreamWriter(obxFile);
        
        // empezamos el xml
        obxWriter.writeStartDocument("1.0");
        obxWriter.writeStartElement("products");
        
        
        do{
            obx = (Product) lec.readObject();
            if(obx != null){
                System.out.println(obx.toString());
                // empezamos un producto
                obxWriter.writeStartElement("produto");
                    obxWriter.writeStartElement("codigo");
                        obxWriter.writeCharacters(obx.getCodigo());
                    obxWriter.writeEndElement();
                    // escribimos la descricion
                    obxWriter.writeStartElement("descripcion");
                        obxWriter.writeCharacters(obx.getDescripcion());
                    obxWriter.writeEndElement();
                    // escribimos el precio
                    obxWriter.writeStartElement("precio");
                        obxWriter.writeCharacters(String.valueOf(obx.getPrezo()));
                    obxWriter.writeEndElement();
                obxWriter.writeEndElement();
            }
            else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
        
        // cerramos la raíz
        obxWriter.writeEndElement();
        obxWriter.close();
        lec.close();
    }
    
    
    public static final int CODIGO = 1;
    public static final int DESCRIPCION = 2;
    public static final int PRECIO = 3;
    
    public void leer(String rutaXML) throws XMLStreamException, FileNotFoundException{
        // creo los objetos que necesito para leer
        FileInputStream obxFile = new FileInputStream(rutaXML);
        XMLInputFactory obxFactory = XMLInputFactory.newInstance();
        XMLStreamReader obxReader = obxFactory.createXMLStreamReader(obxFile);
        
        ArrayList<Product> lista = new ArrayList();
        
        int numero;
        
        String element = null;
        String texto = null;
        int etiquetaPadre = 0;
        
        Product obx = new Product();
        
        while(obxReader.hasNext()){
            obxReader.next();
            numero = obxReader.getEventType();
            switch(numero){
                case XMLStreamConstants.START_ELEMENT:
                    element = obxReader.getLocalName();
                    // guardo en una varible en que etiqueta estamos 
                    // para que cuando cojamos el texto sepamos donde estamos
                    switch(element){
                        case "codigo":
                            etiquetaPadre = CODIGO;
                            break;
                        case "descripcion":
                            etiquetaPadre = DESCRIPCION;
                            break;
                        case "precio":
                            etiquetaPadre = PRECIO;
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    break;
                case XMLStreamConstants.ATTRIBUTE:
                    
                    break;
                case XMLStreamConstants.CHARACTERS:
                    texto = obxReader.getText();
                    
                    // para saber que tenemos que cambiar en el objeto
                    switch(etiquetaPadre){
                        case CODIGO:
                            obx.setCodigo(texto);
                            break;
                        case DESCRIPCION:
                            obx.setDescripcion(texto);
                            break;
                        case PRECIO:
                            obx.setPrezo(Double.parseDouble(texto));
                            lista.add(new Product(obx.getCodigo(),obx.getDescripcion(),obx.getPrezo()));
                            break;
                    }
                    break;
            }
        }
        
        for(Product elemento :lista){
            System.out.println(elemento.toString());
        }
    }
}
