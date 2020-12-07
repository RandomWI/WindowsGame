
package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import businessLogic.Button;
import businessLogic.Table;
import businessLogic.Window;

public class CreateTableClassFromXml {

	public Table TableCreator(String filename) throws IOException {
		
		String filePath = filename;
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Vector<Button> buttonContainer = new Vector<>();
		Table table = new Table();
		Window window = new Window();
		Vector<Window> windows = new Vector<>();
		
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
	
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("Window");

		for (int i = 0; i < nodeList.getLength(); i++) {

		/*	if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nodeList.item(i);
				window.setColumn(Integer.parseInt(getTagValue("Col", element)));
				System.out.println(window.getColumn());
				window.setRow(Integer.parseInt(getTagValue("Row", element)));
				System.out.println(window.getRow());
			}*/
			
			buttonContainer.clear();
			NodeList nodeListButton = doc.getElementsByTagName("Button");
			for (int y = 0; y < nodeListButton.getLength(); y++) {
				buttonContainer.add(getButton(nodeList.item(y)));
			}
			window.setButtonContainer(buttonContainer);
			table.addWindow(window);
		}
        }catch (Exception e) {
			// TODO: handle exception
		}
        
		return table;

	}

	private static Button getButton(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		Button item = new Button();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			item.setPressed(Boolean.parseBoolean(getTagValue("ACTIVE", element)));
			item.setColumn(Integer.parseInt(getTagValue("COL", element)));
			item.setRow(Integer.parseInt(getTagValue("ROW", element)));
		}

		return item;
	}
	
	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}

}