package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.client.view.gui.listeners.BuyCardListener;

import javax.swing.*;
import java.awt.*;
/**
 * This class is used to create panels containing the image of a production card and under a clickable button
 */
public class CardLabelWithButton extends JPanel {
    /**
     * This attribute indicates the width of the card
     */
    private static final int cardWidth = 140;
    /**
     * This attribute indicates the height of the card
     */
    private static final int cardHeight = 212;
    /**
     * This attribute indicates the height of the panel
     */
    private static final int panelHeight = 248;

    /**
     * This attribute represents the reference to the gui
     */
    private Gui gui;
    /**
     * This attribute represents the number of the production card's deck
     */
    private final int deckNumber;
    /**
     * This attribute contains the image of the card
     */
    private final Image cardImage;
    /**
     * This attribute contains the cardImage
     */
    private final JLabel cardLabel;
    /**
     * This attribute represents the panel's button
     */
    private final JButton button;

    /**
     * Constructor of the class. It creates the panel containing the card and the button.
     * @param cardKey : the key of the card
     * @param deck : the number of the production card's deck
     * @param gui : the reference to the gui
     */
    public CardLabelWithButton(int cardKey, int deck, Gui gui){
        this.deckNumber = deck;
        this.cardImage = Paths.getProdImageFromKey(cardKey).getScaledInstance(cardWidth,cardHeight,0);
        cardLabel = new JLabel();
        cardLabel.setSize(cardWidth,cardHeight);
        cardLabel.setIcon(new ImageIcon(cardImage));
        button = new JButton("Deck "+ deck);
        button.setBounds(30,220, 100, 28);
        button.setBackground(new Color(188, 143, 143));
        button.addActionListener(new BuyCardListener(gui,deckNumber));
        //button.setBackground(new Color(153, 139, 109));
        this.add(cardLabel);
        this.add(button);
        this.setSize(cardWidth,panelHeight);
        this.setBounds(0, 0,cardWidth, panelHeight);
        this.setBackground( new Color(232,228,212) );
    }

    /**
     * This method disables the button
     */
    public void disableButton(){
        this.button.setEnabled(false);
    }
    /**
     * This method enables the button
     */
    public void enableButton(){
        this.button.setEnabled(true);
    }

    /**
     * This method is used to show the panel
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
