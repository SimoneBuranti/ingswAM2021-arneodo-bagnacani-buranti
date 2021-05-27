package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

public class CardLabel extends JLabel {

    private static final int cardWidth = 140;
    private static final int cardHeight = 212;

    private Image cardImage;


    public CardLabel(int cardkey){

        this.cardImage = Paths.getProdImageFromKey(cardkey).getScaledInstance(cardWidth,cardHeight,0);
        this.setSize(cardWidth,cardHeight);
        this.setBorder(BorderFactory.createBevelBorder(0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cardImage, 0, 0, null);

    }
}
