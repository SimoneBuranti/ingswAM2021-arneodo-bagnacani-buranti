package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;

public class ProductionButton extends JButton {

    private boolean token = false;

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }
}
