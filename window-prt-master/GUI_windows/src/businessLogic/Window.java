package businessLogic;

import java.util.Vector;

public class Window implements Point{

    private int row;
    private int column;

    private Vector<Button> buttons = new Vector<>(4);

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

    public void addButton(Button button){
        buttons.add(button);
    }

    public Button getButton(int index){
        return buttons.get(index);
    }

}
