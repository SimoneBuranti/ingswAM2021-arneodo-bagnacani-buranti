package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.ProductionOnMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivateProductionListener implements ActionListener {

    private Gui gui;
    private JButton button;
    private int column;



    public ActivateProductionListener(Gui gui,JButton button,int column) {
        this.gui = gui;
        this.button = button;
        this.column = column;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        button.setEnabled(false);
        gui.getViewController().sendMessage(new ProductionOnMessage(column));
        gui.disableAllExceptProductions();
    }

}
