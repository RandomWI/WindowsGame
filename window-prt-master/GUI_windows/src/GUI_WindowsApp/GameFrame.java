package GUI_WindowsApp;

import businessLogic.Table;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    private SizePanel sizePanel;
    private PlayGround playGround;
    private ButtonBar buttonBar;

    private JPanel mainPanel;
    private Table table;

    public GameFrame(){
        super("Demo");
    }

    public GameFrame(int size){
        super("Demo");
        mainPanel = new JPanel(new BorderLayout());

        sizePanel = new SizePanel(this);
        playGround = new PlayGround(size, table);
        buttonBar = new ButtonBar();

        //Add the panels to this MainPanel
        mainPanel.add(sizePanel, BorderLayout.PAGE_START);
        mainPanel.add(playGround, BorderLayout.CENTER);
        mainPanel.add(buttonBar, BorderLayout.PAGE_END);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setFrame(int size){
        mainPanel = new JPanel(new BorderLayout());

        sizePanel = new SizePanel(this);
        playGround = new PlayGround(size, table);
        buttonBar = new ButtonBar();

        //Add the panels to this MainPanel
        mainPanel.add(sizePanel, BorderLayout.PAGE_START);
        mainPanel.add(playGround, BorderLayout.CENTER);
        mainPanel.add(buttonBar, BorderLayout.PAGE_END);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected void ResizeApp(int size){
        setVisible(false);
        remove(mainPanel);
        setFrame(size);
        setVisible(true);
    }

    public void joinTable(Table table){
        this.table = table;
    }

}
