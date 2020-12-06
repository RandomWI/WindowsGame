package businessLogic;

import java.util.Vector;

import XML.XMLReader;
import XML.XMLWriter;
import Server.Insert;

public class Table {

	private int index;
    private Vector<Window> windows;
    int counter=0;
    XMLWriter writer = new XMLWriter();
    XMLReader reader = new XMLReader();
    Insert sender = new Insert();

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
	
	public void write(Table container,String filename){
	writer.Write(container);
	String state = reader.Read(filename);
	sender.stateToDB(filename, state);
	}

	/* public void SomeMethod(String file_path){

	    Publikus elérésű metódus létrehozása melyenk hatására az adatok betöltődnek xml-ből
	    vagy adatbázisból a table osztályba.
	    Paraméterként megkapja annak a fájlnak a nevét amit be kell töltenie.
	}
	 */

}
