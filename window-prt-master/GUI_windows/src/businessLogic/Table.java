package businessLogic;

import java.util.Vector;

import XML.XMLReader;
import XML.XMLWriter;

public class Table {

	private int index;
    private final Vector<Window> windows;
    int counter=0;
    XMLWriter writer = new XMLWriter();
    XMLReader reader = new XMLReader();

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

    public int size(){
        return windows.size();
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void write(Table container,String filename){
	writer.Write(container);
	String state = reader.Read(filename);
	}

}
