package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.BuyProductionCardMessage;
import it.polimi.ingsw.messages.ProductionOnMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        gui.getViewController().sendMessage(new BuyProductionCardMessage(deckKey,column));
        gui.actionDoneMode();
    }

}
