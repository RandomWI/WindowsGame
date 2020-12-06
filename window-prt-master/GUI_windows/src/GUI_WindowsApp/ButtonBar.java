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
    String fileName;


    private JFileChooser jfc = new JFileChooser("D:");

    
    public ButtonBar(){
        super(new GridBagLayout());

        setButtonBar();
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(PlayGround.getTable());
                PlayGround.getTable().write(PlayGround.getTable(),fileName);
            }
        });

        buttonLoading.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfc.showOpenDialog(null);
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


    private void LoadingToPlayGround(){

        GWindow gw;

        for(int i = 0; i < PlayGround.getTable().size(); i++){
            gw = Converter.convertToGWindow(PlayGround.getTable().getWindow(i));
            PlayGround.getgWindowsContainer().add(gw);
        }
    }


}
