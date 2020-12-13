package GUI_WindowsApp;

import businessLogic.Table;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

	public static int osszLepes;
	
    private SizePanel sizePanel;
    private PlayGround playGround;
    private ButtonBar buttonBar;

    private JPanel mainPanel;
    private Table table;

    public GameFrame(){
        super("Demo");
    }

    public GameFrame(int numberOfWindows){
        super("Demo");
        setFrame(numberOfWindows);
    }

    public void ScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void setFrame(int numberOfWindows){
        mainPanel = new JPanel(new BorderLayout());

        sizePanel = new SizePanel(this);
        playGround = new PlayGround(numberOfWindows, table);
        buttonBar = new ButtonBar(this, table);

        //Add the panels to this MainPanel
        mainPanel.add(sizePanel, BorderLayout.PAGE_START);
        mainPanel.add(playGround, BorderLayout.CENTER);
        mainPanel.add(buttonBar, BorderLayout.PAGE_END);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void ResizeApp(int numberOfWindows){
        setVisible(false);
        remove(mainPanel);
        setFrame(numberOfWindows);
        setVisible(true);
        Table.setPressCounter(0);
    }

    public void ReLoading(){
        setVisible(false);
        remove(mainPanel);

        mainPanel = new JPanel(new BorderLayout()); //Nem feltétlenül szükséges új példányt létrehozni
        //Table.setPressCounter(0);
        sizePanel = new SizePanel(this); //Nem feltétlenül szükséges új példányt létrehozni
        playGround = new PlayGround(table);
        buttonBar = new ButtonBar(this, table); //Nem feltétlenül szükséges új példányt létrehozni

        //Add the panels to this MainPanel
        mainPanel.add(sizePanel, BorderLayout.PAGE_START);
        mainPanel.add(playGround, BorderLayout.CENTER);
        mainPanel.add(buttonBar, BorderLayout.PAGE_END);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void joinTable(Table table){
        this.table = table;
    }

}
