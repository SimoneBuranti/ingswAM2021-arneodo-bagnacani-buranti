package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import javax.swing.*;

/**
 * This class is used to create row buttons of the market
 */
public class PushRowButton extends JButton{


    /**
     * Constructor of the class. It creates a button with the image of the arrow
     */
    public PushRowButton(){

        this.setIcon(new ImageIcon((Paths.getImageFromPath("/punchboard/frecciaSx.png")).getScaledInstance(60,30,0)));
        this.setSize(60,30);
    }

}
