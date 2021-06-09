package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create labels containing the image of a activated leader card.
 */
public class LeaderCardActivatedLabel extends EmptyLeaderCardLabel {
    /**
     * This attribute indicates the width of the card
     */
    private static final int cardWidth = 150;
    /**
     * This attribute indicates the height of the card
     */
    private static final int cardHeight = 222;
    /**
     * This attribute indicates the height of the panel
     */
    private static final int panelHeight = 232;

    /**
     * This attribute represents the leader card's key
     */
    private final int key;
    /**
     * This attribute represents the leader card's position in the light model
     */
    private final int index;
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
     * Constructor of the class. It creates the label containing the card and the text.
     * @param key : the key of the card
     * @param index : the leader card's position in the light model
     */
    public LeaderCardActivatedLabel(int key, int index){

        this.index = index;
        this.key = key;
        textLabel = new JLabel("Activated card");
        textLabel.setBounds(0, 0, 150, 10);

        this.cardImage = Paths.getLeaderImageFromKey(key).getScaledInstance(cardWidth,cardHeight,0);
        cardLabel = new JLabel();
        cardLabel.setSize(cardWidth,cardHeight);
        cardLabel.setIcon(new ImageIcon(cardImage));
        cardLabel.setBounds(0,13, cardWidth, cardHeight);
        this.add(textLabel);
        this.add(cardLabel);
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

    @Override
    public void enableButtons() {}

    @Override
    public void disableButtons() {}
}
