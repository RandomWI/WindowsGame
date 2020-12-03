package businessLogic;

import java.util.Vector;

public class Table {

    private Vector<Window> windows;

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

}
