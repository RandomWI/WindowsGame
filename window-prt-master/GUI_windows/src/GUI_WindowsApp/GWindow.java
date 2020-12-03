package GUI_WindowsApp;

import businessLogic.Point;
import businessLogic.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Egy GWindowButton osztályból példányosított objektum négy GWindowButton objketumot foglal magába.
 * A JPanel osztály kiterjesztése.
 */
public class GWindow extends JPanel implements Point {

    private GWindowButton buttonOne;
    private GWindowButton buttonTwo;
    private GWindowButton buttonThree;
    private GWindowButton buttonFour;

    private int activeButton = 0;

    private int row;
    private int column;


    public GWindow(WindowSize size){
        super(new GridBagLayout());

        setButtonsSize(size);
        setButtonsPosition();


        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonAction(buttonOne);
            }
        });

        buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonAction(buttonTwo);
            }
        });

        buttonThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonAction(buttonThree);
            }
        });

        buttonFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonAction(buttonFour);
            }
        });

    }

    public void setButtonsSize(WindowSize size){
        buttonOne = new GWindowButton(size);
        buttonTwo = new GWindowButton(size);
        buttonThree = new GWindowButton(size);
        buttonFour = new GWindowButton(size);
    }

    public void setButtonsPosition(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 0, 0);

        //buttonOne
        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonOne.setCoordinate(0, 0);
        this.add(buttonOne, constraints);

        //buttonTwo
        constraints.gridx = 1;
        buttonTwo.setCoordinate(1, 0);
        this.add(buttonTwo, constraints);

        //buttonThree
        constraints.gridx = 0;
        constraints.gridy = 1;
        buttonThree.setCoordinate(0, 1);
        this.add(buttonThree, constraints);

        //buttonFour
        constraints.gridx = 1;
        buttonFour.setCoordinate(1, 1);
        this.add(buttonFour, constraints);
    }

    public void ButtonAction(GWindowButton button){

        if(activeButton < 2){
            if(!button.getPressed()){
                button.buttonPress();
                button.setBackground(Color.YELLOW);
                activeButton++;
                //System.out.println(activeButton);
            }
            else{
                button.buttonPress();
                button.setBackground(null);
                activeButton--;
                //System.out.println(activeButton);
            }
        }
        else{
            if(button.getPressed()){
                button.buttonPress();
                button.setBackground(null);
                activeButton--;
                //System.out.println(activeButton);
            }
        }

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

    public  Window convertToWindow(){
        Window modified = new Window();

        modified.setRow(getRow());
        modified.setColumn(getColumn());

        modified.addButton(buttonOne.convertToButton());
        modified.addButton(buttonTwo.convertToButton());
        modified.addButton(buttonThree.convertToButton());
        modified.addButton((buttonFour.convertToButton()));

        return modified;
    }

}

