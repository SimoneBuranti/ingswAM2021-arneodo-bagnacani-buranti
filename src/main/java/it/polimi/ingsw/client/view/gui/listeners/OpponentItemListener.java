package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.AskInformationMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpponentItemListener implements ActionListener {

    private ViewController viewController;

    private int playerNumber;

    public OpponentItemListener(ViewController viewController, int playerNumber) {
        this.viewController = viewController;
        this.playerNumber = playerNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        (new Thread( () -> {
            viewController.sendMessage(new AskInformationMessage(playerNumber));
        })).start();
    }
}
