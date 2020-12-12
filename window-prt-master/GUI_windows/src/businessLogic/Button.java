package businessLogic;

import Abstract.Point;
import Abstract.Pressable;

public class Button implements Point, Pressable {

    private int row;
    private int column;
    private boolean pressed;
    private boolean preState;

    public Button(){
        super();
    }

    public Button(int row, int column){
        setRow(row);
        setColumn(column);
    }

    //A Pressable interfész implementálása.
    @Override
    public boolean isPressed() {
        return pressed;
    }

    @Override
    public void setPressed(boolean press) {
        this.pressed = press;
    }

    @Override
    public void buttonPress() {
        this.pressed = !pressed;
    }


    //A Point interfész implementálása.
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

	public boolean isPreState() {
		return preState;
	}

	public void setPreState(boolean preState) {
		this.preState = preState;
	}

}
