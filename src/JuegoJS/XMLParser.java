/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JuegoJS;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author sergi
 */
public class XMLParser {

File archivoXML;
DocumentBuilder db;
Document doc;

XMLParser (String deckName) throws ParserConfigurationException, SAXException, IOException
{
    archivoXML=new File(deckName+".xml");
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    db=dbf.newDocumentBuilder();
    doc=db.parse(archivoXML);
    doc.getDocumentElement().normalize();
}

public Mazo recuperarMazo(Mazo m)
{
    Node nodoRaiz = doc.getDocumentElement().getFirstChild();//Recuperamos el nodo raiz del xml
    for (Node hijo = nodoRaiz.getFirstChild(); hijo != null;
         hijo = hijo.getNextSibling()) 
    {
       
    
    }
}
    
    

class MyErrorHandler implements ErrorHandler {
     
    private PrintWriter out;

    MyErrorHandler(PrintWriter out) {
        this.out = out;
    }

    private String getParseExceptionInfo(SAXParseException spe) {
        String systemId = spe.getSystemId();
        if (systemId == null) {
            systemId = "null";
        }

        String info = "URI=" + systemId + " Line=" + spe.getLineNumber() +
                      ": " + spe.getMessage();
        return info;
    }

    @Override
    public void warning(SAXParseException spe) throws SAXException {
        out.println("Warning: " + getParseExceptionInfo(spe));
    }
        
    @Override
    public void error(SAXParseException spe) throws SAXException {
        String message = "Error: " + getParseExceptionInfo(spe);
        throw new SAXException(message);
    }

    @Override
    public void fatalError(SAXParseException spe) throws SAXException {
        String message = "Fatal Error: " + getParseExceptionInfo(spe);
        throw new SAXException(message);
    }
}