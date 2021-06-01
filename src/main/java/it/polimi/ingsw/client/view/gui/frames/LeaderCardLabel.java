package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.client.view.gui.listeners.ActivateLeaderListener;
import it.polimi.ingsw.client.view.gui.listeners.DiscardLeaderListener;

import javax.swing.*;
import java.awt.*;

public class LeaderCardLabel extends EmptyLeaderCardLabel {
    private static final int cardWidth = 150;
    private static final int cardHeight = 222;
    private static final int panelHeight = 278;

    private Image cardImage;
    private JLabel cardLabel;
    private JLabel textLabel;
    private JButton buttonActivate;
    private JButton buttonDiscard;

    private Gui gui;
    private int index;
    private int key;


    public LeaderCardLabel(int key, Gui gui, int index){
        this.key = key;
        this.gui = gui;
        this.index = index;
        textLabel = new JLabel("Card to activate/discard");
        textLabel.setBounds(0, 0, 150, 10);

        this.cardImage = Paths.getLeaderImageFromKey(key).getScaledInstance(cardWidth,cardHeight,0);
        cardLabel = new JLabel();
        cardLabel.setSize(cardWidth,cardHeight);
        cardLabel.setIcon(new ImageIcon(cardImage));
        cardLabel.setBounds(0,13, cardWidth, cardHeight);
        buttonActivate = new JButton("A");
        buttonActivate.setBounds(15,243, 50, 28); //230
        buttonActivate.setBackground(new Color(232,228,212));
        buttonActivate.addActionListener(new ActivateLeaderListener(gui, index, this));
        buttonDiscard = new JButton("D");
        buttonDiscard.setBounds(85,243, 50, 28);
        buttonDiscard.setBackground(new Color(232,228,212));
        buttonDiscard.addActionListener(new DiscardLeaderListener(gui, index, this));
        this.add(textLabel);
        this.add(cardLabel);
        this.add(buttonActivate);
        this.add(buttonDiscard);
        this.setSize(cardWidth,panelHeight);
        this.setBounds(0, 0,cardWidth, panelHeight);
    }

    public int keyOfLeaderCard(){
        return key;
    }

    public int getIndex(){
        return index;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(cardImage, 0, 0, null);

    }

    @Override
    public void enableButtons() {
        buttonActivate.setEnabled(true);
        buttonDiscard.setEnabled(true);
    }

    @Override
    public void disableButtons() {
        buttonActivate.setEnabled(false);
        buttonDiscard.setEnabled(false);
    }
}
