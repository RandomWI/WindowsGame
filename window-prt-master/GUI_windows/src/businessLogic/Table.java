package businessLogic;

import java.util.Vector;

public class Table {

	private int index;
    private final Vector<Window> windows;

    public Table(){
        windows = new Vector<>();
    }

    public void addWindow(Window window){
        windows.add(window);
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

}
