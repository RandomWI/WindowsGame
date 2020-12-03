package GUI_WindowsApp;

import Abstract.Point;
import Abstract.Pressable;

import javax.swing.*;
import java.awt.*;


public class GWindowButton extends JButton implements Point, Pressable {

    private int row;
    private int column;

    private boolean pressed = false;

    public GWindowButton(WindowSize size){
        super();
        setBackground(Color.WHITE);

        switch (size){
            case LARGE -> this.setPreferredSize(new Dimension(42, 42));
            case MEDIUM -> this.setPreferredSize(new Dimension(20, 20));
            case SMALL -> this.setPreferredSize(new Dimension(12, 12));
        }

    }

    //A Pressable interfész implementálása.
    @Override
    public boolean isPressed() {
        return pressed;
    }

    @Override
    public void setPressed(boolean isPressed) {
        this.pressed = isPressed;
    }

    @Override
    public void buttonPress() {
        this.pressed = !pressed;
    }



    //A Point interfész implementálása.
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

}
