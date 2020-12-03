package Abstract;

import GUI_WindowsApp.GWindowButton;

import java.util.Vector;

public interface VisualButtonContainer {

    void setButtonContainer();
    void addButton(GWindowButton button);
    GWindowButton getButton(int index);
    int getContainerSize();

}
