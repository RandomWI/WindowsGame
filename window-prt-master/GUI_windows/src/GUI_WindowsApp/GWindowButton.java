package GUI_WindowsApp;

import businessLogic.Point;
import businessLogic.Button;

import javax.swing.*;
import java.awt.*;


/**
 * Az osztály a JButton osztály kiterjesztése.
 * A GWindow osztály építőeleme.
 */
public class GWindowButton extends JButton implements Point{

    private int row;
    private int column;

    /**
     * A gomb álapotát jelzi, ha true a gomb be van nyomva, ha false a gomb nincs benyomva.
     */
    private boolean pressed = false;

    /**
     * Létrehoz egy GWindowButton osztály egy példányát.
     * A gomobok méretét az átadott size paraméter alapján választja meg.
     * @param size
     * @see WindowSize
     */
    public GWindowButton(WindowSize size){
        super();

        switch (size){
            case LARGE -> this.setPreferredSize(new Dimension(42, 42));
            case MEDIUM -> this.setPreferredSize(new Dimension(20, 20));
            case SMALL -> this.setPreferredSize(new Dimension(12, 12));
        }

    }


    public void buttonPress(){
        if(!pressed){
            pressed = !pressed;
        }
        else{
            pressed = !pressed;
        }
    }

    public boolean getPressed(){
        return pressed;
    }


    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public void setCoordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Button convertToButton(){
        Button modified = new Button();

        modified.setRow(getRow());
        modified.setColumn(getColumn());

        modified.setActive(getPressed());

        return modified;
    }

}
