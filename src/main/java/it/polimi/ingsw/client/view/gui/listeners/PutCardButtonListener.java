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

    private Gui gui;
    private int deckKey;
    private int column;


    public PutCardButtonListener(Gui gui, int deckKey,int column) {
        this.gui = gui;
        this.deckKey = deckKey;
        this.column = column;
    }


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
