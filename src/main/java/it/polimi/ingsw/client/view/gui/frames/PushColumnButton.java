package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;

/**
 * This class is used to create column buttons of the market
 */
public class PushColumnButton extends JButton{


    /**
     * Constructor of the class. It creates a button with the image of the arrow
     */
    public PushColumnButton(){
        this.setIcon(new ImageIcon((Paths.getImageFromPath("/punchboard/frecciaSu.png")).getScaledInstance(30,60,0)));
        this.setSize(30,60);
    }

}
