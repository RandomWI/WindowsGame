package businessLogic;

import Abstract.BasicButton;
import Abstract.Point;
import Abstract.Pressable;

public class Button extends BasicButton{


    public Button(){
        super();
    }

    public Button(int row, int column){
        setRow(row);
        setColumn(column);
    }



}
