package GUI_WindowsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.FileChannel;
import java.util.Vector;

import XML.XMLWriter;
import businessLogic.Converter;
import businessLogic.Table;

/**
 * A ButtonBar tartalmazza a pálya mentéséhez és visszatöltéséhez szükséges kezelőket.
 */
public class ButtonBar extends JPanel {

	protected JButton buttonLoading;
    protected JButton buttonSave;
    String fileName = "";

    private GameFrame frame;
    private Table table ;

    private JFileChooser jfc = new JFileChooser("D:");

    
    public ButtonBar(GameFrame frame, Table table){
        super(new GridBagLayout());

        this.frame = frame;
        this.table = table;

        setButtonBar();
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAction();

                fileName = "gameState.xml";

                //System.out.println(PlayGround.getTable());
                //PlayGround.getTable().write(PlayGround.getTable(),fileName);
                table.save(table, fileName);
            }
        });

        buttonLoading.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fileName = "gameState.xml";
              table.load(fileName);
                LoadingToPlayGround();
                frame.ReLoading();
            }
        });
    }
    
    public void setButtonBar(){
    	buttonSave = new JButton("Mentés");
        buttonLoading = new JButton("Betöltés");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(buttonSave, constraints);

        constraints.gridx = 1;
        add(buttonLoading, constraints);
    }

    private void SaveAction(){
        table.clear(); // Mentés előtt törli a table tartalmát.

        for(GWindow gw : PlayGround.getGWindowsContainer()){
            table.addWindow(Converter.convertToWindow(gw));
        }
    }


    private void LoadingToPlayGround(){
        PlayGround.getGWindowsContainer().clear(); //Törli a már benne lévő tartalmat mielőtt rátöltené.

        GWindow gw;

        for(int i = 0; i < table.size(); i++){
            gw = Converter.convertToGWindow(table.getWindow(i), table.size());
            PlayGround.getGWindowsContainer().add(gw);
        }
    }


}
