package businessLogic;

import GUI_WindowsApp.GWindow;
import GUI_WindowsApp.GWindowButton;
import GUI_WindowsApp.PlayGround;

import java.util.Vector;

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
        modified.setPreState(visualButton.isHidePressed());
        modified.setPressed(visualButton.isPressed());

        return modified;
    }


    public static GWindow convertToGWindow(Window window, int tableSize){

        int numberOfWindows = (int)Math.sqrt(tableSize);
        int windowSize = PlayGround.getWindowSize(numberOfWindows);

        Vector<GWindowButton> gbuttons = new Vector<>();

        for(int i = 0; i < window.getContainerSize(); i++){
            gbuttons.add(convertToGWindowButton(window.getButton(i), GWindow.ButtonSizeCalc(windowSize)));
        }

        GWindow modified = new GWindow(gbuttons, windowSize);

        modified.setRow(window.getRow());
        modified.setColumn(window.getColumn());

        return modified;
    }

    public static GWindowButton convertToGWindowButton(Button button, int buttonSize){
        GWindowButton modified = new GWindowButton(buttonSize);

        modified.setRow(button.getRow());
        modified.setColumn(button.getColumn());
        modified.setHidePressed(button.isPreState());
        modified.setPressed(button.isPressed());

        return modified;
    }

}
