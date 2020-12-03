package businessLogic;

import Abstract.BasicButton;
import Abstract.BasicButtonContainer;
import Abstract.VisualButton;
import Abstract.VisualWindow;

public final class Converter {

    public static Window convertToWindow(VisualWindow visualW){
        Window modified = new Window();

        modified.setRow(visualW.getRow());
        modified.setColumn(visualW.getColumn());

        visualW.setButtonContainer();
        modified.setButtonContainer(visualW.getContainerSize());

        for(int i = 0; i < visualW.getContainerSize(); i++){
            modified.addButton(convertToButton(visualW.getButton(i)));
        }


        return modified;
    }


    public static BasicButton convertToButton(VisualButton visualButton){
        BasicButton modified = new BasicButton();

        modified.setRow(visualButton.getRow());
        modified.setColumn(visualButton.getColumn());

        modified.setPressed(visualButton.isPressed());

        return modified;
    }


}
