package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.LeaderCardLabel;
import it.polimi.ingsw.messages.ActivateLeaderCardMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActivateLeaderListener implements ActionListener {

    Gui gui;
    int index;
    LeaderCardLabel leaderCardLabel;

    public ActivateLeaderListener(Gui gui, int index, LeaderCardLabel leaderCardLabel){
        this.gui = gui;
        this.index = index;
        this.leaderCardLabel = leaderCardLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gui.notifyObserver(new ActivateLeaderCardMessage(index));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        leaderCardLabel.disableButtons();
    }
}
