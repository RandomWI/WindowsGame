package GUI_WindowsApp;

import javax.swing.*;
import java.awt.*;

/**
 * A ButtonBar tartalmazza a pálya mentéséhez és visszatöltéséhez szükséges kezelőket.
 */
public class ButtonBar extends JPanel {

    public ButtonBar(){
        super(new GridBagLayout());

        JButton buttonSave = new JButton("Mentés");
        JButton buttonLoaLoading = new JButton("Betöltés");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(buttonSave, constraints);

        constraints.gridx = 1;
        add(buttonLoaLoading, constraints);
    }
}
