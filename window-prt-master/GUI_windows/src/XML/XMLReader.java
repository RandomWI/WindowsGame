
package XML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLReader {

public String Read(String filename) {

	
	
	
		String xmlString = "";
	   TransformerFactory tf = TransformerFactory.newInstance();
       Transformer transformer;
       try {
           transformer = tf.newTransformer(); 
	File file = new File(filename);  
	DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
	Document document = documentBuilder.parse(file);
	
    StringWriter writer = new StringWriter();
    transformer.transform(new DOMSource(document), new StreamResult(writer));
    xmlString = writer.getBuffer().toString();   
    System.out.println(xmlString);              
} 
catch (TransformerException e) 
{
    e.printStackTrace();
}
catch (Exception e) 
{
    e.printStackTrace();
}
       
       
if(!xmlString.equals("")) {
return xmlString;
}
else {
return "false";
}
}


}



