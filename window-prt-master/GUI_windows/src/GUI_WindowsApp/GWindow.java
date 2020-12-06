package GUI_WindowsApp;


import Abstract.Point;
import Abstract.VisualButtonContainer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Egy GWindow osztályból példányosított objektum négy GWindowButton objketumot foglal magába.
 * A JPanel osztály kiterjesztése.
 */
public class GWindow extends JPanel implements Point, VisualButtonContainer{

	private int row;
    private int column;

    private int index = 0;

    private Vector<GWindowButton> buttonContainer;

    protected GWindowButton buttonOne;
    protected GWindowButton buttonTwo;
    protected GWindowButton buttonThree;
    protected GWindowButton buttonFour;

    private int activeButton = 0;

    public GWindow(){
        super(new GridBagLayout());
    }


    public GWindow(int windowSize){
        super(new GridBagLayout());

        setButtonSize(windowSize);
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

    public void setButtonSize(int windowSize){
        buttonOne = new GWindowButton(windowSize/4);
        buttonTwo = new GWindowButton(windowSize/4);
        buttonThree = new GWindowButton(windowSize/4);
        buttonFour = new GWindowButton(windowSize/4);
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

    //A gombnyomások hatását kezeli.
    public void ButtonAction(GWindowButton button){

        if(activeButton < 2){
            if(!button.isPressed()){
                button.buttonPress();
                button.setBackground(Color.YELLOW);
                activeButton++;
                //System.out.println(activeButton);
            }
            else{
                button.buttonPress();
                button.setBackground(Color.WHITE);
                activeButton--;
                //System.out.println(activeButton);
            }
        }
        else{
            if(button.isPressed()){
                button.buttonPress();
                button.setBackground(Color.WHITE);
                activeButton--;
                //System.out.println(activeButton);
            }
        }
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


    //A VisualButtonContainer implementálása.
    @Override
    public void setButtonContainer(){
        buttonContainer = new Vector<>(4);

        addButton(buttonOne);
        addButton(buttonTwo);
        addButton(buttonThree);
        addButton(buttonFour);
    }

    public void setButtons(){
        buttonOne = buttonContainer.get(0);
        buttonTwo = buttonContainer.get(1);
        buttonThree = buttonContainer.get(2);
        buttonFour = buttonContainer.get(3);
    }

    @Override
    public void addButton(GWindowButton button){
        buttonContainer.add(button);
    }

    @Override
    public GWindowButton getButton(int index){
        return buttonContainer.get(index);
    }

    @Override
    public int getContainerSize(){
        return buttonContainer.size();
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}

