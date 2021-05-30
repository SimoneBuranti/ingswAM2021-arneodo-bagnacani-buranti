package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

public class CardLabelWithButton extends JPanel {
    private static final int cardWidth = 140;
    private static final int cardHeight = 212;
    private static final int panelHeight = 248;

    private Image cardImage;
    private JLabel cardLabel;
    private JButton button;


    public CardLabelWithButton(int cardkey, int deck){

        this.cardImage = Paths.getProdImageFromKey(cardkey).getScaledInstance(cardWidth,cardHeight,0);
        cardLabel = new JLabel();
        cardLabel.setSize(cardWidth,cardHeight);
        cardLabel.setIcon(new ImageIcon(cardImage));
        button = new JButton("Deck "+ deck);
        button.setBounds(30,220, 100, 28);
        button.setBackground(new Color(188, 143, 143));
        //button.setBackground(new Color(153, 139, 109));
        this.add(cardLabel);
        this.add(button);
        this.setSize(cardWidth,panelHeight);
        this.setBounds(0, 0,cardWidth, panelHeight);
        this.setBackground( new Color(232,228,212) );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(cardImage, 0, 0, null);

    }
}
