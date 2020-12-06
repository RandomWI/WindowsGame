package businessLogic;

import java.util.Vector;

import XML.XMLReader;
import XML.XMLWriter;
import Server.Insert;
import Server.Select;

public class Table {

	private int index;
    private Vector<Window> windows;
    int counter=0;
    XMLWriter writer = new XMLWriter();
    XMLReader reader = new XMLReader();
    Insert sender = new Insert();
    Select requesting = new Select();

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
	writer.Write(container);
	String actualState = reader.XmlToString(filename);
	sender.stateToDB(filename, actualState);
	}

	public void load(String filename){
	String returnState = requesting.select(filename);
	System.out.println(returnState);
	}

}
