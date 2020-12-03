package businessLogic;

import Abstract.BasicButton;

public class Button extends BasicButton {


    public Button(){
        super();
    }

    public Button(int row, int column){
        setRow(row);
        setColumn(column);
    }

}
