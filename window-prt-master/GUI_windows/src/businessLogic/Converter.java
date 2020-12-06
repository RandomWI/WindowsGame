package businessLogic;

import GUI_WindowsApp.GWindow;
import GUI_WindowsApp.GWindowButton;

public class Converter {

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



    public static GWindow convertToGWindow(Window window){
        GWindow modified = new GWindow();

        modified.setRow(window.getRow());
        modified.setColumn(window.getColumn());

        for(int i = 0; i < window.getContainerSize(); i++){
            modified.addButton(convertToGWindowButton(window.getButton(i)));
        }

        modified.setButtons();

        return modified;
    }

    public static GWindowButton convertToGWindowButton(Button button){
        GWindowButton modified = new GWindowButton();

        modified.setRow(button.getRow());
        modified.setColumn(button.getColumn());

        modified.setPressed(button.isPressed());

        return modified;
    }

}
