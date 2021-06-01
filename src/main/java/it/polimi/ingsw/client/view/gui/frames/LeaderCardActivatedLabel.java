package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

public class LeaderCardActivatedLabel extends EmptyLeaderCardLabel {
    private static final int cardWidth = 150;
    private static final int cardHeight = 222;
    private static final int panelHeight = 232;

    private int key;
    private int index;
    private Image cardImage;
    private JLabel cardLabel;
    private JLabel textLabel;


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

    public int keyOfLeaderCard(){
        return key;
    }

    public int getIndex(){
        return index;
    }

    @Override
    public void enableButtons() {

    }

    @Override
    public void disableButtons() {

    }
}
