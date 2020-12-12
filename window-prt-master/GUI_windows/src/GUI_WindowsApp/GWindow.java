package GUI_WindowsApp;


import Abstract.Point;
import Abstract.VisualButtonContainer;
import businessLogic.Window;

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
    private Window WManager = new Window();
    public Vector<GWindowButton> buttonContainer = new Vector<>();


    private GWindowButton buttonOne;
    private GWindowButton buttonTwo;
    private GWindowButton buttonThree;
    private GWindowButton buttonFour;

    private int buttonSize;
    private int activeButton = 0;


    public GWindow(Vector<GWindowButton> buttons, int windowSize){
        super(new GridBagLayout());

        buttonSize = ButtonSizeCalc(windowSize);

        for(GWindowButton gB : buttons){
            buttonContainer.add(gB);
            if(gB.isPressed())
                activeButton++;
        }

        initButtonsFromContainer();
        setButtonsPosition();

        buttonOne.addActionListener(new CustomActionListener());
        buttonTwo.addActionListener(new CustomActionListener());
        buttonFour.addActionListener(new CustomActionListener());
        buttonThree.addActionListener(new CustomActionListener());

    }


    public GWindow(int windowSize){
        super(new GridBagLayout());

        buttonSize = ButtonSizeCalc(windowSize);
        intiButton();
        setButtonsPosition();

        buttonOne.addActionListener(new CustomActionListener());
        buttonTwo.addActionListener(new CustomActionListener());
        buttonFour.addActionListener(new CustomActionListener());
        buttonThree.addActionListener(new CustomActionListener());

    }


    class CustomActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ButtonAction((GWindowButton) e.getSource());
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
    }


    public void intiButton(){
        buttonOne = new GWindowButton(buttonSize);
        buttonTwo = new GWindowButton(buttonSize);
        buttonThree = new GWindowButton(buttonSize);
        buttonFour = new GWindowButton(buttonSize);
    }

    public void initButtonsFromContainer(){
        buttonOne = buttonContainer.get(0);
        buttonTwo = buttonContainer.get(1);
        buttonThree = buttonContainer.get(2);
        buttonFour = buttonContainer.get(3);
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

    public static int ButtonSizeCalc(int windowSize){
        return windowSize/2;
    }

    public int getButtonSize(){
        return buttonSize;
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

	/**
	 * @return the buttonOne
	 */
	public GWindowButton getButtonOne() {
		return buttonOne;
	}


	/**
	 * @return the buttonTwo
	 */
	public GWindowButton getButtonTwo() {
		return buttonTwo;
	}


	/**
	 * @return the buttonThree
	 */
	public GWindowButton getButtonThree() {
		return buttonThree;
	}


	/**
	 * @return the buttonFour
	 */
	public GWindowButton getButtonFour() {
		return buttonFour;
	}

}

