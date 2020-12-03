package businessLogic;

import GUI_WindowsApp.GWindow;
import GUI_WindowsApp.GWindowButton;

public final class Converter {

    public static Window convertToWindow(GWindow visualW){
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


    public static Button convertToButton(GWindowButton visualButton){
        Button modified = new Button();

        modified.setRow(visualButton.getRow());
        modified.setColumn(visualButton.getColumn());

        modified.setPressed(visualButton.isPressed());

        return modified;
    }

}
