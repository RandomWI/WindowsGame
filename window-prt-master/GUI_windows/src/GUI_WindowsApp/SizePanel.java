package GUI_WindowsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A SizePanel a pálya átméretezéséhez szükséges kezelőket valósítja meg.
 * A tényleges átméretezést nem ez az osztály végzi.
 */
public class SizePanel extends JPanel {

    private JLabel labelSize;
    private JTextField textSize;
    protected JButton buttonResize;

    private GameFrame frame;

    public SizePanel(GameFrame frame){
        super(new GridBagLayout());

        this.frame = frame;
        setSizePanel();

        buttonResize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.ResizeApp(getNewSize());
            }
        });

    }

    private void setSizePanel(){
        labelSize = new JLabel("Adja meg a méretet (n*n): ");
        textSize = new JTextField(10);
        buttonResize = new JButton("Átméretezés");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelSize, constraints);

        constraints.gridx = 1;
        add(textSize, constraints);

        constraints.gridx = 2;
        add(buttonResize, constraints);
    }

    /**
     * Visszaadja a felhasznló által a szövegmezőben megadott értéket.
     * @return a pálya kívánt mérete
     */
    public int getNewSize(){
        return Integer.parseInt(textSize.getText());
    }

}
