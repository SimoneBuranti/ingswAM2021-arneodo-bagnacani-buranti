package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.client.view.gui.listeners.ActivateLeaderListener;
import it.polimi.ingsw.client.view.gui.listeners.DiscardLeaderListener;

import javax.swing.*;
import java.awt.*;
/**
 * This class is used to create labels containing the image of a leader card with two buttons.
 */
public class LeaderCardLabel extends EmptyLeaderCardLabel {
    /**
     * This attribute indicates the width of the card
     */
    private static final int cardWidth = 150;
    /**
     * This attribute indicates the height of the card
     */
    private static final int cardHeight = 222;
    /**
     * This attribute indicates the height of the label
     */
    private static final int panelHeight = 278;

    /**
     * This attribute represents the activate button's listener
     */
    ActivateLeaderListener activateListener;
    /**
     * This attribute represents the discard button's listener
     */
    DiscardLeaderListener discardListener;

    /**
     * This attribute contains the image of the card
     */
    private final Image cardImage;
    /**
     * This attribute contains the cardImage
     */
    private final JLabel cardLabel;
    /**
     * This attribute contains a text
     */
    private final JLabel textLabel;
    /**
     * This attribute represents the activate button
     */
    private final JButton buttonActivate;
    /**
     * This attribute represents the discard button
     */
    private final JButton buttonDiscard;
    /**
     * This attribute represents the reference to the gui
     */
    private final Gui gui;
    /**
     * This attribute represents the leader card's position in the light model
     */
    private int index;
    /**
     * This attribute represents the leader card's key
     */
    private final int key;

    /**
     * Constructor of the class. It creates the label containing the card, the text and the two buttons.
     * @param key : the key of the card
     * @param gui : the reference to the gui
     * @param index : the leader card's position in the light model
     */
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
        activateListener = new ActivateLeaderListener(this.gui, this.index, this);
        buttonActivate.addActionListener(activateListener);
        buttonDiscard = new JButton("D");
        buttonDiscard.setBounds(85,243, 50, 28);
        buttonDiscard.setBackground(new Color(232,228,212));
        discardListener = new DiscardLeaderListener(this.gui, this.index, this);
        buttonDiscard.addActionListener(discardListener);
        this.add(textLabel);
        this.add(cardLabel);
        this.add(buttonActivate);
        this.add(buttonDiscard);
        this.setSize(cardWidth,panelHeight);
        this.setBounds(0, 0,cardWidth, panelHeight);
    }

    /**
     * @return the key of the card
     */
    public int keyOfLeaderCard(){
        return key;
    }

    /**
     * @return the index of the card
     */
    public int getIndex(){
        return index;
    }

    /**
     * This method sets the new card index
     * @param index : the new card index
     */
    public void setIndex(int index){
        this.index = index;
        activateListener.setIndex(index);
        discardListener.setIndex(index);
    }

    /**
     * This method is used to show the panel
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    /**
     * This method enables the buttons
     */
    @Override
    public void enableButtons() {
        buttonActivate.setEnabled(true);
        buttonDiscard.setEnabled(true);
    }

    /**
     * This method disables the buttons
     */
    @Override
    public void disableButtons() {
        buttonActivate.setEnabled(false);
        buttonDiscard.setEnabled(false);
    }
}
