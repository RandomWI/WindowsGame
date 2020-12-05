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

   
	/**
	 * @return the table
	 */
	static Table getTable() {
		return table;
	}

    private int numberOfWindows;
    private int windowSize;

    private Vector<GWindow> gWindows;
    private static Table table;

    public PlayGround(int numberOfWindows, Table table){
        super(new GridBagLayout());

        this.numberOfWindows = numberOfWindows;

        joinTable(table);

        setWindowSize(numberOfWindows);
        generateWindows();
        setPlayGround();

    }

    public void setWindowSize(int numberOfWindows){

        double screenHeight;
        double screenWidth;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.getHeight();
        screenWidth = screenSize.getWidth();

        if(screenHeight<screenWidth)
            this.windowSize = (int)((screenHeight*1)/numberOfWindows);
        else
            this.windowSize = (int)((screenWidth*1)/numberOfWindows);

    }

    public void generateWindows(){
    	
        gWindows = new Vector<>();

        int row = 0;
        int column = 0;
        int index=0;
        for(int i = 0; i < numberOfWindows; i++){
        
            for(int j = 0; j < numberOfWindows; j++){
            	
                GWindow newGWindow = new GWindow(windowSize);
                newGWindow.setCoordinate(row, column);
                newGWindow.setIndex(index);
                gWindows.add(newGWindow);

                column++;
                index++;
                //setTable(newGWindow.convertToWindow());
            }
            column = 0;
            row++;
        }
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

}
