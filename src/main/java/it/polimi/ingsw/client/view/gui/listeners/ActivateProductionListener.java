package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.ProductionButton;
import it.polimi.ingsw.messages.DiscardLeaderCardMessage;
import it.polimi.ingsw.messages.ProductionOnMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActivateProductionListener implements ActionListener {

    /**
     * Player's gui reference.
     */
    private Gui gui;

    /**
     * Button to which the ActionListener is added.
     */
    private ProductionButton button;

    /**
     * Production parameter.
     */
    private int column;


    /**
     * Listener constructor.
     * @param gui
     * @param button
     * @param column
     */
    public ActivateProductionListener(Gui gui, ProductionButton button, int column) {
        this.gui = gui;
        this.button = button;
        this.column = column;

        button.setText("Activate");
    }


    /**
     * When the button is pressed, a new ProductionOnMessage instance is notified and the production button is disabled.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        (new Thread(() -> {
            try {
                gui.notifyObserver(new ProductionOnMessage(column));
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        })).start();
        button.setEnabled(false);
        button.setToken(false);
        gui.disableAllExceptProductions();
    }

}
