package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;

/**
 * This class is used to create empty leader card labels. Methods are implemented in subclasses.
 */
public class EmptyLeaderCardLabel extends JLabel {

    public void enableButtons(){}

    public void disableButtons(){}

    public int keyOfLeaderCard(){
        return 0;
    }

    public int getIndex(){
        return 0;
    }

    public void setIndex(int index){}
}
