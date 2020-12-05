package XML;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import GUI_WindowsApp.GWindow;
import GUI_WindowsApp.GWindowContainer;

public class XMLWriter {

	public static final String xmlFilePath = "gameState.xml";

	   public void Write(GWindowContainer container) {
	        
	      
	        ArrayList<GWindow> gwindowList = new ArrayList<GWindow>();
	        gwindowList = container.getGwindowList();
	    int end = 0;
	        
	        try {
	        	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	        	 
	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	 
	            Document doc = documentBuilder.newDocument();
	            //add elements to Document
	            Element rootElement =
	                doc.createElement("Container");
	            //append root element to document
	            doc.appendChild(rootElement);

	            //append first child element to root element
	          
	            for (GWindow element : gwindowList) {
	            	end ++;
	            	System.out.println(end);
	            	
	            	Element GWindow = doc.createElement("GWindow");
	            	rootElement.appendChild(GWindow);
	            	
	            	Attr attrID = doc.createAttribute("ID");
	                attrID.setValue(element.getIndex()+"");
	                
	                GWindow.setAttributeNode(attrID);
	                
	                
	            	Element ButtonOne = doc.createElement("ButtonOne");
	            	Element ButtonTwo = doc.createElement("ButtonTwo");
	            	Element ButtonThree = doc.createElement("ButtonThree");
	            	Element ButtonFour = doc.createElement("ButtonFour");
	            	
	            	
	            	Attr attrRowBT1 = doc.createAttribute("ROW");
	                attrRowBT1.setValue(element.getButtonOne().getRow()+"");
	                Attr attrColBT1 = doc.createAttribute("COL");
	                attrColBT1.setValue(element.getButtonOne().getColumn()+"");
	                Attr attrActiveBT1 = doc.createAttribute("ACTIVE");
	                attrActiveBT1.setValue(element.getButtonOne().isPressed()+"");
	                
	                Attr attrRowBT2 = doc.createAttribute("ROW");
	                attrRowBT2.setValue(element.getButtonTwo().getRow()+"");
	                Attr attrColBT2 = doc.createAttribute("COL");
	                attrColBT2.setValue(element.getButtonTwo().getColumn()+"");
	                Attr attrActiveBT2 = doc.createAttribute("ACTIVE");
	                attrActiveBT2.setValue(element.getButtonTwo().isPressed()+"");
	                
	                Attr attrRowBT3 = doc.createAttribute("ROW");
	                attrRowBT3.setValue(element.getButtonThree().getRow()+"");
	                Attr attrColBT3 = doc.createAttribute("COL");
	                attrColBT3.setValue(element.getButtonThree().getColumn()+"");
	                Attr attrActiveBT3 = doc.createAttribute("ACTIVE");
	                attrActiveBT3.setValue(element.getButtonThree().isPressed()+"");
	                
	                Attr attrRowBT4 = doc.createAttribute("ROW");
	                attrRowBT4.setValue(element.getButtonFour().getRow()+"");
	                Attr attrColBT4 = doc.createAttribute("COL");
	                attrColBT4.setValue(element.getButtonFour().getColumn()+"");
	                Attr attrActiveBT4 = doc.createAttribute("ACTIVE");
	                attrActiveBT4.setValue(element.getButtonFour().isPressed()+"");
	                
	            	
	            	ButtonOne.setAttributeNode(attrRowBT1);
	            	ButtonOne.setAttributeNode(attrColBT1);
	            	ButtonOne.setAttributeNode(attrActiveBT1);
	            	
	            	ButtonTwo.setAttributeNode(attrRowBT2);
	            	ButtonTwo.setAttributeNode(attrColBT2);
	            	ButtonTwo.setAttributeNode(attrActiveBT2);
	            	
	            	ButtonThree.setAttributeNode(attrRowBT3);
	            	ButtonThree.setAttributeNode(attrColBT3);
	            	ButtonThree.setAttributeNode(attrActiveBT3);
	            	
	            	ButtonFour.setAttributeNode(attrRowBT4);
	            	ButtonFour.setAttributeNode(attrColBT4);
	            	ButtonFour.setAttributeNode(attrActiveBT4);
	  
	            	GWindow.appendChild(ButtonOne);
	            	GWindow.appendChild(ButtonTwo);
	            	GWindow.appendChild(ButtonThree);
	            	GWindow.appendChild(ButtonFour);
	            	if(end==container.getSize())
	            	{
	            		break;
	            	}
				}
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource domSource = new DOMSource(doc);
	            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	 
	            transformer.transform(domSource, streamResult);
	 
	            System.out.println("DONE");
	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
	    }
	}
