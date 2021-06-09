package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyCardListener implements ActionListener {

    /**
     * Gui reference.
     */
    private Gui gui;

    /**
     * Deck button listener parameter.
     */
    private int key;


    /**
     * Listener constructor.
     * @param gui
     * @param key
     */
    public BuyCardListener(Gui gui,int key) {
        this.key = key;
        this.gui = gui;
    }

    /**
     * Whe the button is pressed all the deck buttons are disabled while production ones change their action listener.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setChosenDeckNumber(key);
        gui.putProdCardMode();
    }
}
