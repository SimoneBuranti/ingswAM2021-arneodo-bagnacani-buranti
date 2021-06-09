package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.BuyProductionCardMessage;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.ProductionOnMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PutCardButtonListener implements ActionListener {

    /**
     * Gui reference.
     */
    private Gui gui;

    /**
     * Deck key parameter.
     */
    private int deckKey;

    /**
     * Column parameter.
     */
    private int column;


    /**
     * PutCardButtonListener constructor.
     * @param gui
     * @param deckKey
     * @param column
     */
    public PutCardButtonListener(Gui gui, int deckKey,int column) {
        this.gui = gui;
        this.deckKey = deckKey;
        this.column = column;
    }


    /**
     * When the button is pressed, the actionDoneMode is set and a BuyProductionCardMessage instance is sent.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        (new Thread(() -> {
            try {
                gui.notifyObserver(new BuyProductionCardMessage(deckKey,column));
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        })).start();

        gui.actionDoneMode();
    }

}
