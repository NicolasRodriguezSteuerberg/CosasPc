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
        
        while(obxReader.hasNext()){
            obxReader.next();
            numero = obxReader.getEventType();
            switch(numero){
                case XMLStreamConstants.START_ELEMENT:
                    
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    
                    break;
                case XMLStreamConstants.ATTRIBUTE:
                    
                    break;
                case XMLStreamConstants.CHARACTERS:
                    
                    break;
                case XMLStreamConstants.COMMENT:
                    
                    break;
                case XMLStreamConstants.SPACE:
                    
                    break;
                case XMLStreamConstants.DTD:
                    
                    break;
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
