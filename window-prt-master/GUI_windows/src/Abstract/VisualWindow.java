package Abstract;


import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public abstract class VisualWindow extends JPanel implements Point, VisualButtonContainer{

    private int row;
    private int column;

    protected Vector<VisualButton> buttonContainer;

    public VisualWindow(){
        super(new GridBagLayout());
    }


    //A VisualButtonContainer implementálása.
    @Override
    public void setButtonContainer(){
        this.buttonContainer = new Vector<>();
    }

    @Override
    public void addButton(VisualButton button){
        buttonContainer.add(button);
    }

    @Override
    public VisualButton getButton(int index){
        return buttonContainer.get(index);
    }

    @Override
    public int getContainerSize(){
        return buttonContainer.size();
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
