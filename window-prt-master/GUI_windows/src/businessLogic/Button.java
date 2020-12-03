package businessLogic;

public class Button implements Point, Pressable{

    private int row;
    private int column;
    private boolean pressed;

    public Button(){

    }
    public Button(int row, int column){
        this.row = row;
        this.column = column;
    }

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
}
