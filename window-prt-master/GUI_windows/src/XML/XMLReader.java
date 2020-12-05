package XML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import GUI_WindowsApp.GWindow;
import GUI_WindowsApp.GWindowContainer;

import java.io.File;  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import org.w3c.dom.Document;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList; 

public class XMLReader {
	
public void ReadXMLFile(String filename) {

	//Nincs befejezve!!!
	
	try   
	{  
	File file = new File(filename);  
	DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
	Document document = documentBuilder.parse(file);  
	System.out.println("Root element: "+ document.getDocumentElement().getNodeName());  
	if (document.hasChildNodes())   
	{  
	printNodeList(document.getChildNodes());  
	}  
	}   
	catch (Exception e)  
	{  
	System.out.println(e.getMessage());  
	}  
	} 


	private static void printNodeList(NodeList nodeList)  
	{  
	for (int count = 0; count < nodeList.getLength(); count++)   
	{  
	Node elemNode = nodeList.item(count);  
	if (elemNode.getNodeType() == Node.ELEMENT_NODE)   
	{  
	// get node name and value  
	System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");  
	System.out.println("Node Content =" + elemNode.getTextContent());  
	if (elemNode.hasAttributes())   
	{  
	NamedNodeMap nodeMap = elemNode.getAttributes();  
	for (int i = 0; i < nodeMap.getLength(); i++)   
	{  
	Node node = nodeMap.item(i);  
	System.out.println("attr name : " + node.getNodeName());  
	System.out.println("attr value : " + node.getNodeValue());  
	}  
	}  
	if (elemNode.hasChildNodes())   
	{  
	//recursive call if the node has child nodes  
	printNodeList(elemNode.getChildNodes());  
	}  
	System.out.println("Node Name =" + elemNode.getNodeName()+ " [CLOSE]");  
	}  
	}  
}
	 
}

