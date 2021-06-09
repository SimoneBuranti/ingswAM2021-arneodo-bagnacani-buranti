package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.LeaderCardLabel;
import it.polimi.ingsw.messages.ActivateLeaderCardMessage;
import it.polimi.ingsw.messages.ProductionOnMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class represents the listener of the button to activate a leader card
 */
public class ActivateLeaderListener implements ActionListener {

    /**
     * This attribute represents the reference to the gui
     */
    Gui gui;
    /**
     * This attribute represents the leader card's position in the light model
     */
    int index;
    /**
     * This attribute represents the reference to the label containing the card to activate
     */
    LeaderCardLabel leaderCardLabel;

    /**
     * Constructor of the class. It creates the listener of the activate button
     * @param gui : the reference to the gui
     * @param index : the leader card's position in the light model
     * @param leaderCardLabel : the reference to the label containing the activate button
     */
    public ActivateLeaderListener(Gui gui, int index, LeaderCardLabel leaderCardLabel){
        this.gui = gui;
        this.index = index;
        this.leaderCardLabel = leaderCardLabel;
    }

    /**
     * This method sets the new index of the card
     * @param index : the new card's index
     */
    public void setIndex(int index){
        this.index = index;
    }

    /**
     * This method sends to the server an activate leader message when the activate button has been clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        (new Thread(() -> {
            try {
                gui.notifyObserver(new ActivateLeaderCardMessage(index));
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        })).start();
        leaderCardLabel.disableButtons();
    }
}
