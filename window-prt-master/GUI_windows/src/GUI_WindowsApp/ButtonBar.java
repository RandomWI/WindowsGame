package GUI_WindowsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import XML.XMLWriter;

/**
 * A ButtonBar tartalmazza a pálya mentéséhez és visszatöltéséhez szükséges kezelőket.
 */
public class ButtonBar extends JPanel {

	protected JButton buttonLoading;
    protected JButton buttonSave;
    XMLWriter manager = new XMLWriter();
    GWindowContainer cont = new GWindowContainer();
    
    public ButtonBar(){
        super(new GridBagLayout());

        /*JButton buttonSave = new JButton("Mentés");
        JButton buttonLoaLoading = new JButton("Betöltés");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(buttonSave, constraints);

        constraints.gridx = 1;
        add(buttonLoaLoading, constraints);*/
        
        setButtonBar();
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            manager.Write(PlayGround.container);
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
