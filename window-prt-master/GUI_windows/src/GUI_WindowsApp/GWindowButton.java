package GUI_WindowsApp;

import Abstract.VisualButton;

import java.awt.*;


/**
 * Az osztály a VisualButton absztrakt osztály kiterjesztése.
 * A GWindow osztály építőeleme.
 * @see VisualButton
 */
public class GWindowButton extends VisualButton {


    /**
     * Létrehoz egy GWindowButton osztály egy példányát.
     * A gomobok méretét az átadott size paraméter alapján választja meg.
     * @param size
     * @see WindowSize
     */
    public GWindowButton(WindowSize size){
        super();

        switch (size){
            case LARGE -> this.setPreferredSize(new Dimension(42, 42));
            case MEDIUM -> this.setPreferredSize(new Dimension(20, 20));
            case SMALL -> this.setPreferredSize(new Dimension(12, 12));
        }

    }

}
