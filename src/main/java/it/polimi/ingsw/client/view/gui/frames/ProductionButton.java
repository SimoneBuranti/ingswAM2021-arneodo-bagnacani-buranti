package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;

/**
 * This class provides an additional token attribute for the turn phase of the game.
 */
public class ProductionButton extends JButton {

    /**
     * The token attribute indicates whether a production has been already selected or not.
     */
    private boolean token = false;

    /**
     * Token getter method.
     * @return
     */
    public boolean isToken() {
        return token;
    }

    /**
     * Token setter method.
     * @param token
     */
    public void setToken(boolean token) {
        this.token = token;
    }
}
