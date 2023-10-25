package ejercicio;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Metodos {
    
    public void leerXML(String ruta) throws IOException, XMLStreamException{
        FileInputStream obxFile = new FileInputStream(ruta);
        XMLInputFactory obxFactory = XMLInputFactory.newInstance();
        XMLStreamReader obxReader = obxFactory.createXMLStreamReader(obxFile);
        
        int numero;
        String element = "";
        
        
        while(obxReader.hasNext()){
            obxReader.next();
            numero = obxReader.getEventType();
            
            if(numero == XMLStreamConstants.START_ELEMENT){
                element = obxReader.getLocalName();
                if (element.equals("autor")){
                    System.out.println(obxReader.getAttributeValue(0));
                }else if(element.equals("nome") || element.equals("titulo")){
                    System.out.println("\t" + obxReader.getElementText());
                }
            }
            
        }
        
    }
    
    // sax            stax
    public void escribirXML(String ruta) throws IOException, XMLStreamException{
        FileWriter obxFile = new FileWriter(ruta);
        XMLOutputFactory obxFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter obxWriter = obxFactory.createXMLStreamWriter(obxFile);
        
        // Empieza la escritura
        obxWriter.writeStartDocument("1.0");
        // Se escribe la raíz
        obxWriter.writeStartElement("autores");
            obxWriter.writeStartElement("autor");
            //escribe un atributo para o elemento actual
            obxWriter.writeAttribute("codigo","a1");
                //nombre
                obxWriter.writeStartElement("nome");
                    obxWriter.writeCharacters("Alexandre Dumas");
                obxWriter.writeEndElement();
                
                //titulo
                obxWriter.writeStartElement("titulo");
                    obxWriter.writeCharacters("El conde de montecristo");
                obxWriter.writeEndElement();
                //titulo
                obxWriter.writeStartElement("titulo");
                    obxWriter.writeCharacters("Los miserables");
                obxWriter.writeEndElement();
            //autor
            obxWriter.writeEndElement();
            
            obxWriter.writeStartElement("autor");
            //escribe un atributo para o elemento actual
            obxWriter.writeAttribute("codigo","a2");
                //nombre
                obxWriter.writeStartElement("nome");
                    obxWriter.writeCharacters("Alexandre Dumas");
                obxWriter.writeEndElement();
                //titulo
                obxWriter.writeStartElement("titulo");
                    obxWriter.writeCharacters("El conde de montecristo");
                obxWriter.writeEndElement();
                //titulo
                obxWriter.writeStartElement("titulo");
                    obxWriter.writeCharacters("Los miserables");
                obxWriter.writeEndElement();
            //autor
            obxWriter.writeEndElement();
            
        //autores
        obxWriter.writeEndElement();
        
        obxWriter.close();
    }
}
