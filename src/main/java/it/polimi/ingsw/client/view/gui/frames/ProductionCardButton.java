package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.messages.BuyProductionCardMessage;
import it.polimi.ingsw.messages.PushColumnMessage;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductionCardButton extends JButton{

    public ProductionCardButton(ProductionCard productionCard){

        this.setIcon(new ImageIcon((Paths.getLeaderImageFromKey(productionCard.getKey()).getScaledInstance(140,212,0))));
        this.setSize(140,212);
    }

}
