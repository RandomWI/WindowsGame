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


    private int numberOfWindows;
    private int windowSize;
    Window manager;

    private static Vector<GWindow> gWindows;
    //private static Table table;

    public PlayGround(int numberOfWindows, Table table){
        super(new GridBagLayout());

        this.numberOfWindows = numberOfWindows;

        //joinTable(table);

        windowSize = getWindowSize(numberOfWindows);
        System.out.println(windowSize);
        manager = new Window();
        generateWindows();
        setPlayGround();
        manager.windowsHandler(gWindows);
    }

    public PlayGround(Table table){
        super(new GridBagLayout());

        numberOfWindows = gWindows.size();

        //joinTable(table);
        setPlayGround();
        //gWindows.clear();
    }


    public static int getWindowSize(int numberOfWindows){
        double screenHeight;
        double screenWidth;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.getHeight();
        screenWidth = screenSize.getWidth();

        if(screenHeight<screenWidth)
            return (int)((screenHeight*0.70)/numberOfWindows);
        else
            return (int)((screenWidth*0.70)/numberOfWindows);
    }

    public void generateWindows(){
        try {
            gWindows.clear(); // Enélkül csak bővítené a vektrot.
            System.err.println("A vektor elemei sikeresen törölve!");
        } catch (NullPointerException ex){
            System.err.println("A vektor még  üres!");
        }

    	
        gWindows = new Vector<>();

        int row = 0;
        int column = 0;

        for(int i = 0; i < numberOfWindows; i++){
        
            for(int j = 0; j < numberOfWindows; j++){
            	
                GWindow newGWindow = new GWindow(windowSize);
                newGWindow.setCoordinate(row, column);
                gWindows.add(newGWindow);

                column++;
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
            //setTable(Converter.convertToWindow(gW));
        }
    }

    /*
    public void joinTable(Table table){
        this.table = table;
    }

    public void setTable(Window window){
        table.addWindow(window);
    }


    public static Table getTable() {
        return table;
    }

     */

    public static Vector<GWindow> getGWindowsContainer(){
        return gWindows;
    }

}
