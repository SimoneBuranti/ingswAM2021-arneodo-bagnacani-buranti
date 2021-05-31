package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyCardListener implements ActionListener {

    private Gui gui;
    private int key;


    public BuyCardListener(Gui gui,int key) {
        this.key = key;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setChosenDeckNumber(key);
        gui.putProdCardMode();
    }
}
