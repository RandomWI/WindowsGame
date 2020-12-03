package Abstract;

import java.util.Vector;

public interface VisualButtonContainer {

    public void setButtonContainer();
    public void addButton(VisualButton button);
    public VisualButton getButton(int index);
    public int getContainerSize();
}
