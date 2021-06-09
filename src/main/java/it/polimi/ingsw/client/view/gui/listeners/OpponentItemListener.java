package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.AskInformationMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpponentItemListener implements ActionListener {

    /**
     * View controller reference.
     */
    private ViewController viewController;

    /**
     * Action listener parameter. It contains the player number so that a correct message is sent.
     */
    private int playerNumber;

    /**
     * Class constructor.
     * @param viewController
     * @param playerNumber
     */
    public OpponentItemListener(ViewController viewController, int playerNumber) {
        this.viewController = viewController;
        this.playerNumber = playerNumber;
    }

    /**
     * When the button is pressed a new thread calls the view controller sendMessage method to send the corresponding
     * message request to the server.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        (new Thread( () -> {
            viewController.sendMessage(new AskInformationMessage(playerNumber+1));
        })).start();
    }
}
