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

    private Gui gui;
    private ProductionButton button;
    private int column;



    public ActivateProductionListener(Gui gui, ProductionButton button, int column) {
        this.gui = gui;
        this.button = button;
        this.column = column;

        button.setText("Activate");
    }


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
