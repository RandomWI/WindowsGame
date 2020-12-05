package GUI_WindowsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.FileChannel;

import XML.XMLWriter;

/**
 * A ButtonBar tartalmazza a pálya mentéséhez és visszatöltéséhez szükséges kezelőket.
 */
public class ButtonBar extends JPanel {

	protected JButton buttonLoading;
    protected JButton buttonSave;


    private JFileChooser jfc = new JFileChooser("D:");

    
    public ButtonBar(){
        super(new GridBagLayout());

        setButtonBar();
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(PlayGround.getTable());
                PlayGround.getTable().write(PlayGround.getTable());
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
}
