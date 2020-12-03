package Abstract;

public class BasicButton implements Point, Pressable{

    private int row;
    private int column;

    private boolean pressed;

    public BasicButton(){
        super();
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

}
