package Abstract;

public interface BasicButtonContainer {

    public void setButtonContainer(int size);
    public void addButton(BasicButton button);
    public BasicButton getButton(int index);
    public int getContainerSize();

}
