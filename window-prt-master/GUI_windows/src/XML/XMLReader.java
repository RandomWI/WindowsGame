/*
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
import GUI_WindowsApp.GWindowButton;
import GUI_WindowsApp.WindowSize;

import java.awt.Container;
import java.io.File;  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import org.w3c.dom.Document;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList; 


public class XMLReader {

	ArrayList <GWindow> elements = new ArrayList<>();
public void Read(String filename) {

	//Nincs befejezve!!!
	//GWindow item = new GWindow();
	
	
	
	
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





GWindow itemsS = new GWindow(WindowSize.SMALL);
GWindow itemsM = new GWindow(WindowSize.MEDIUM);
GWindow itemsL = new GWindow(WindowSize.LARGE);

GWindowButton buttonOne = null;
GWindowButton buttonTwo = null;
GWindowButton buttonThree = null;
GWindowButton buttonFour = null;
WindowSize size = null;

boolean buttonFirstIs=false;
boolean buttonSecondIs=false;
boolean buttonThirdIs=false;
boolean buttonFourthIs=false;

	public void printNodeList(NodeList nodeList)  
	{  
	int id = 0;
	
    
    
	for (int count = 0; count < nodeList.getLength(); count++)   
	{  
	Node elemNode = nodeList.item(count);  
	if (elemNode.getNodeType() == Node.ELEMENT_NODE)   
	{  
	    
		if(elemNode.getNodeName().equals("ButtonOne")) {
		buttonFirstIs=true;
		}
		if(elemNode.getNodeName().equals("ButtonTwo")) {
		buttonSecondIs=true;	
		}
		if(elemNode.getNodeName().equals("ButtonThree")) {
		buttonThirdIs=true;
		}
		if(elemNode.getNodeName().equals("ButtonFour")) {
		buttonFourthIs=true;
		}
		
	// get node name and value  
	System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");  
	System.out.println("Node Content =" + elemNode.getTextContent());
	
	
	if (elemNode.hasAttributes())   
	{  
	NamedNodeMap nodeMap = elemNode.getAttributes();  
	System.out.println(nodeMap);
	for (int i = 0; i < nodeMap.getLength(); i++)   
	{  
	Node node = nodeMap.item(i);  
	System.out.println("attr name : " + node.getNodeName());  
	System.out.println("attr value : " + node.getNodeValue());  
	if(node.getNodeName().equals("ID")) {
		System.out.println(node.getNodeValue());
		id=Integer.parseInt(node.getNodeValue());
		}
	else if(node.getNodeName().equals("WSize")) {
		size=WindowSize.valueOf(node.getNodeValue());
		}
	
	else if(buttonFirstIs) {
	
		if(node.getNodeName().equals("ACTIVE")) {
			System.out.println(size);
			buttonOne=new GWindowButton(size);
		buttonOne.setPressed(Boolean.valueOf(node.getNodeValue()));	
		}
		else if(node.getNodeName().equals("COL"))
		{
		buttonOne.setColumn(Integer.parseInt(node.getNodeValue()));
		}
		else if(node.getNodeName().equals("ROW"))
		{
		buttonOne.setRow(Integer.parseInt(node.getNodeValue()));
		
		buttonFirstIs=false;
	    buttonSecondIs=false;
	    buttonThirdIs=false;
	    buttonFourthIs=false;
		}
	}
	
	else if(buttonSecondIs) {
		
		if(node.getNodeName().equals("ACTIVE")) {
			buttonTwo=new GWindowButton(size);
		buttonTwo.setPressed(Boolean.parseBoolean(node.getNodeValue()));	
		}
		else if(node.getNodeName().equals("COL"))
		{
		buttonTwo.setColumn(Integer.parseInt(node.getNodeValue()));
		}
		else if(node.getNodeName().equals("ROW"))
		{
		buttonTwo.setRow(Integer.parseInt(node.getNodeValue()));
		buttonFirstIs=false;
	    buttonSecondIs=false;
	    buttonThirdIs=false;
	    buttonFourthIs=false;
		}
	}
	
	else if(buttonThirdIs) {
		
		if(node.getNodeName().equals("ACTIVE")) {
			buttonThree=new GWindowButton(size);
		buttonThree.setPressed(Boolean.parseBoolean(node.getNodeValue()));	
		}
		else if(node.getNodeName().equals("COL"))
		{
		buttonThree.setColumn(Integer.parseInt(node.getNodeValue()));
		}
		else if(node.getNodeName().equals("ROW"))
		{
		buttonThree.setRow(Integer.parseInt(node.getNodeValue()));
		buttonFirstIs=false;
	    buttonSecondIs=false;
	    buttonThirdIs=false;
	    buttonFourthIs=false;
		}
	}
	
	else if(buttonFourthIs) {
		
		if(node.getNodeName().equals("ACTIVE")) {
			buttonFour=new GWindowButton(size);
		buttonFour.setPressed(Boolean.parseBoolean(node.getNodeValue()));	
		}
		else if(node.getNodeName().equals("COL"))
		{
		buttonFour.setColumn(Integer.parseInt(node.getNodeValue()));
		}
		else if(node.getNodeName().equals("ROW"))
		{
		buttonFour.setRow(Integer.parseInt(node.getNodeValue()));
		buttonFirstIs=false;
	    buttonSecondIs=false;
	    buttonThirdIs=false;
	    buttonFourthIs=false;
		}
	}
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
	
	if(size.equals(WindowSize.SMALL)) {
		itemsS.setIndex(id);
		itemsS.setwSize(size);
		itemsS.addButton(buttonOne);
		itemsS.addButton(buttonTwo);
		itemsS.addButton(buttonThree);
		itemsS.addButton(buttonFour);
		elements.add(itemsS);
		}
		
		else if(size.equals(WindowSize.MEDIUM)) {
		itemsM.setIndex(id);
		itemsM.setwSize(size);
		itemsM.addButton(buttonOne);
		itemsM.addButton(buttonTwo);
		itemsM.addButton(buttonThree);
		itemsM.addButton(buttonFour);
		elements.add(itemsM);
		}

		else if(size.equals(WindowSize.LARGE)) {
		itemsL.setIndex(id);
		itemsL.setwSize(size);
		itemsL.addButton(buttonOne);
		itemsL.addButton(buttonTwo);
		itemsL.addButton(buttonThree);
		itemsL.addButton(buttonFour);	
		elements.add(itemsL);
		}
}
	 
}

 */

