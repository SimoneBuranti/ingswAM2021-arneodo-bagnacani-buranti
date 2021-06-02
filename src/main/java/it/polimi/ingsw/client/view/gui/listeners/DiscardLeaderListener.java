package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.LeaderCardLabel;
import it.polimi.ingsw.messages.ActivateLeaderCardMessage;
import it.polimi.ingsw.messages.BuyProductionCardMessage;
import it.polimi.ingsw.messages.DiscardLeaderCardMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DiscardLeaderListener implements ActionListener {
    Gui gui;
    int index;
    LeaderCardLabel leaderCardLabel;

    public DiscardLeaderListener(Gui gui, int index, LeaderCardLabel leaderCardLabel){
        this.gui = gui;
        this.index = index;
        this.leaderCardLabel = leaderCardLabel;
    }

    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        (new Thread(() -> {
            try {
                gui.notifyObserver(new DiscardLeaderCardMessage(index));
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        })).start();
        leaderCardLabel.disableButtons();
    }
}
