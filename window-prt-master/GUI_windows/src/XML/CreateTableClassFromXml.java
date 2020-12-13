
package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import businessLogic.Button;
import businessLogic.Table;
import businessLogic.Window;

public class CreateTableClassFromXml {

	public Table TableCreator(Document doc) throws IOException {

		Vector<Button> buttonContainer;
		Table table = new Table();
		Window window;
		Vector<Window> windows = new Vector<>();
		Button one;
		Button two;
		Button three;
		Button four;

		try {
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList contItem = doc.getElementsByTagName("Container");
			
			table.setPressCounter(Integer.parseInt(contItem.item(0).getAttributes().item(0).getNodeValue()));
			NodeList nodeList = doc.getElementsByTagName("Window");
			System.out.println(nodeList.item(0).getAttributes().item(0).getNodeName());
			System.out.println(nodeList.item(0).getAttributes().item(1).getNodeName());
			System.out.println(nodeList.item(0).getAttributes().item(2).getNodeName());
		
			
			System.out.println(nodeList.item(3).getNodeValue());
			// NodeList list = ((Document) nodeList).getElementsByTagName("Button");

			for (int i = 0; i < nodeList.getLength(); i++) {
				window = new Window();
				one = new Button();
				two = new Button();
				three = new Button();
				four = new Button();
				buttonContainer = new Vector<>();
				
				window.setColumn(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()));
				window.setRow(Integer.parseInt(nodeList.item(i).getAttributes().item(2).getNodeValue()));
				buttonContainer.clear();
				NodeList childList = nodeList.item(i).getChildNodes();
				int counter = 0;
				for (int j = 0; j < childList.getLength(); j++) {

					Node child = childList.item(j);
					if (!child.getNodeName().equals("#text")) {
						switch (counter) {
						case 0:
							buttonContainer.add(getButton(child, one));
							break;
						case 1:
							buttonContainer.add(getButton(child, two));
							break;
						case 2:
							buttonContainer.add(getButton(child, three));
							break;
						case 3:
							buttonContainer.add(getButton(child, four));
							break;
						}
						
						counter++;
						//System.out.println(child.getNodeName() + " -> " + child.getAttributes().item(0).getNodeValue());
					}
				}
				window.setButtonContainer(buttonContainer);
				table.addWindow(window);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return table;

	}

	private static Button getButton(Node node, Button but) {
		System.out.println(node.getAttributes().item(0).getNodeName());
		System.out.println(node.getAttributes().item(1).getNodeName());
		System.out.println(node.getAttributes().item(2).getNodeName());
		System.out.println(node.getAttributes().item(3).getNodeName());
		
		but.setPressed(Boolean.parseBoolean(node.getAttributes().item(0).getNodeValue()));
		but.setPreState(Boolean.parseBoolean(node.getAttributes().item(2).getNodeValue()));
		but.setColumn(Integer.parseInt(node.getAttributes().item(1).getNodeValue()));
		but.setRow(Integer.parseInt(node.getAttributes().item(3).getNodeValue()));
		return but;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}

}