package Abstract;

import businessLogic.Button;

public interface BasicButtonContainer {

    void setButtonContainer(int size);
    void addButton(Button button);
    Button getButton(int index);
    int getContainerSize();

}
