package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create labels containing the image of a production card
 */
public class CardLabel extends JLabel {

    /**
     * This attribute indicates the width of the card
     */
    private static final int cardWidth = 140;
    /**
     * This attribute indicates the height of the card
     */
    private static final int cardHeight = 212;

    /**
     * This attribute contains the image of the card
     */
    private Image cardImage;


    /**
     * Constructor of the class. It creates the label containing the card.
     * @param cardKey : the key of the card
     */
    public CardLabel(int cardKey){
        this.cardImage = Paths.getProdImageFromKey(cardKey).getScaledInstance(cardWidth,cardHeight,0);
        this.setSize(cardWidth,cardHeight);
        this.setBorder(BorderFactory.createBevelBorder(0));
    }

    /**
     * This method is used to show the label
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cardImage, 0, 0, null);

    }
}
