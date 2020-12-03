package businessLogic;

import Abstract.BasicButtonContainer;
import Abstract.Point;

import java.util.Vector;

public class Window implements Point, BasicButtonContainer {

    private int row;
    private int column;

    private Vector<Button> buttonContainer;

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


    //A BasicButtonContainer interfész implementálása.
    @Override
    public void setButtonContainer(int size) {
        buttonContainer = new Vector<>(size);
    }

    @Override
    public void addButton(Button button) {
        buttonContainer.add(button);
    }

    public Button getButton(int index){
        return buttonContainer.get(index);
    }

    @Override
    public int getContainerSize() {
        return buttonContainer.size();
    }

}
