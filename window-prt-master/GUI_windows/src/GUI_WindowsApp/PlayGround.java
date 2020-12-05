package GUI_WindowsApp;

import businessLogic.Converter;
import businessLogic.Table;
import businessLogic.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * A PlayGround osztály a GWindow osztály példányainak tárolására szolgál.
 */
public class PlayGround extends JPanel {

   
	private int size;
    private WindowSize wSize;

    private Vector<GWindow> gWindows;
    private Table table;

    static GWindowContainer container = new GWindowContainer();


    public PlayGround(int size, Table table){
        super(new GridBagLayout());
        removeContainer();

        joinTable(table);

        setSize(size);
        generateWindows();
        setPlayGround();

    }

    public void setSize(int size){
                this.size = size;
        /*A kinézet széthullásának megelőzése érdekében nagyobb méretnél csökkenteni
        kell a gombok és ezzel az ablak méretét. */
        if(size<=10)
            wSize = WindowSize.LARGE;
        else if(size>10 && size<=20)
            wSize = WindowSize.MEDIUM;
        else
            wSize = WindowSize.SMALL;
    }

    public void generateWindows(){
    	
        gWindows = new Vector<>();

        int row = 0;
        int column = 0;
        int index=0;
        for(int i = 0; i < size; i++){
        
            for(int j = 0; j < size; j++){
            	
                GWindow newGWindow = new GWindow(wSize);
                newGWindow.setCoordinate(row, column);
                newGWindow.setIndex(index);
                gWindows.add(newGWindow);
                
                container.gwindowList.add(newGWindow);
                column++;
                index++;
                //setTable(newGWindow.convertToWindow());
            }
            column = 0;
            row++;
        }
        
        container.setSize(index);
    }

    public void setPlayGround(){

        setBackground(Color.BLACK);

        //Create constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);


        for(GWindow gW : gWindows){
            constraints.gridx = gW.getColumn();
            constraints.gridy = gW.getRow();
            add(gW, constraints);
            setTable(Converter.convertToWindow(gW));
        }
    }

    /*public void setPlayGround(){
        //Create constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);

        //Create a new Windows
        constraints.gridx = 0;
        constraints.gridy = 0;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                GWindow newGWindow = new GWindow(wSize);
                add(newGWindow, constraints);
                setTable(newGWindow.convertToWindow());
                constraints.gridx += 1;
            }
            constraints.gridx = 0;
            constraints.gridy += 1;
        }
    }
     */

    public void joinTable(Table table){
        this.table = table;
    }

    public void setTable(Window window){
        table.addWindow(window);
    }

    public void removeContainer(){
        container.clear();
    }

}
