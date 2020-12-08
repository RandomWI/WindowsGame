package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

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

import businessLogic.Button;
import businessLogic.Table;
import businessLogic.Window;

public class XMLWriter {


	public void Write(Table container,String xmlFilePath) {

		Window fluffyWindow = new Window();
		Vector<Button> buttonContainer;
		Button one;
		Button two;
		Button three;
		Button four;

		int end = 0;

		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();

			Element rootElement = doc.createElement("Container");
			doc.appendChild(rootElement);

			int index;
			for (int i = 0; i < container.size(); i++) {

				index = 0;
				fluffyWindow = container.getWindow(i);
				buttonContainer = fluffyWindow.getButtonContainer();

				one = buttonContainer.get(index);
				index++;
				two = buttonContainer.get(index);
				index++;
				three = buttonContainer.get(index);
				index++;
				four = buttonContainer.get(index);

				Element Window = doc.createElement("Window");
				rootElement.appendChild(Window);

				Attr attrID = doc.createAttribute("ID");
				attrID.setValue(i + "");

				Window.setAttributeNode(attrID);

				Attr attrRow = doc.createAttribute("Row");
				attrRow.setValue(fluffyWindow.getRow() + "");

				Window.setAttributeNode(attrRow);

				Attr attrCol = doc.createAttribute("Col");
				attrCol.setValue(fluffyWindow.getColumn() + "");

				Window.setAttributeNode(attrCol);
				Element ButtonOne = doc.createElement("Button");
				Element ButtonTwo = doc.createElement("Button");
				Element ButtonThree = doc.createElement("Button");
				Element ButtonFour = doc.createElement("Button");

				Attr attrRowBT1 = doc.createAttribute("ROW");
				attrRowBT1.setValue(one.getRow() + "");
				Attr attrColBT1 = doc.createAttribute("COL");
				attrColBT1.setValue(one.getColumn() + "");
				Attr attrActiveBT1 = doc.createAttribute("ACTIVE");
				attrActiveBT1.setValue(one.isPressed() + "");

				Attr attrRowBT2 = doc.createAttribute("ROW");
				attrRowBT2.setValue(two.getRow() + "");
				Attr attrColBT2 = doc.createAttribute("COL");
				attrColBT2.setValue(two.getColumn() + "");
				Attr attrActiveBT2 = doc.createAttribute("ACTIVE");
				attrActiveBT2.setValue(two.isPressed() + "");

				Attr attrRowBT3 = doc.createAttribute("ROW");
				attrRowBT3.setValue(three.getRow() + "");
				Attr attrColBT3 = doc.createAttribute("COL");
				attrColBT3.setValue(three.getColumn() + "");
				Attr attrActiveBT3 = doc.createAttribute("ACTIVE");
				attrActiveBT3.setValue(three.isPressed() + "");

				Attr attrRowBT4 = doc.createAttribute("ROW");
				attrRowBT4.setValue(four.getRow() + "");
				Attr attrColBT4 = doc.createAttribute("COL");
				attrColBT4.setValue(four.getColumn() + "");
				Attr attrActiveBT4 = doc.createAttribute("ACTIVE");
				attrActiveBT4.setValue(four.isPressed() + "");

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

				Window.appendChild(ButtonOne);
				Window.appendChild(ButtonTwo);
				Window.appendChild(ButtonThree);
				Window.appendChild(ButtonFour);
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
