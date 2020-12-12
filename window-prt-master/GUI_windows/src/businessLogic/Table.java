package businessLogic;

import java.io.StringWriter;
import java.util.Vector;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import XML.CreateTableClassFromXml;
import XML.StringParseToXML;
import XML.XMLParseToString;
import XML.XMLWriter;
import Server.Insert;
import Server.SelectState;

public class Table {

	private int index;
    private Vector<Window> windows;
    int counter=0;
    XMLWriter writer = new XMLWriter();
    XMLParseToString reader = new XMLParseToString();
    StringParseToXML parser = new StringParseToXML();
    CreateTableClassFromXml returner = new CreateTableClassFromXml();
    Insert sender = new Insert();
    SelectState requesting = new SelectState();
    

    public Table(){
        windows = new Vector<>();
    }

    public void addWindow(Window window){
        windows.add(window);
        counter++;
    }

    public Window getWindow(int index){
        return windows.get(index);
    }

    public void clear(){
        windows.clear();
    }

    public int size(){
        return windows.size();
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void save(Table container,String filename){
	writer.Write(container,filename);
	String actualState = reader.XmlToString(filename);
	sender.stateToDB(filename, actualState);
	}

	public void load(String filename) throws Exception{
	String returnState = requesting.select(filename);
	System.out.println(returnState);
	Document doc = parser.loadXMLFromString(returnState);
	Table test = returner.TableCreator(doc);
	this.windows = test.windows;
	}

}
