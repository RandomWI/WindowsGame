package businessLogic;

import GUI_WindowsApp.GameFrame;

public class Driver {

    public static void main(String[] args) {
        Table newTable = new Table();

        GameFrame newFrame = new GameFrame();
        newFrame.joinTable(newTable);
        newFrame.setFrame(5);

        System.out.println(newTable.size());
    }

}
