package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderCardsPanel extends JPanel {
    private final static int leaderWidth = 370;
    private final static int leaderHeight = 278;

    private JLabel firstCard;
    private JLabel secondCard;

    public LeaderCardsPanel(){
        super();
        this.setLayout(null);
        this.setBounds(810, 280, leaderWidth, leaderHeight);
        setOpaque(false);
    }

    public void addLeaderCards(ArrayList<LeaderCard> leaderCards, boolean activated){
        if(!activated){
            firstCard = new LeaderCardLabel(leaderCards.get(0).getKey());
            firstCard.setBounds(0,0, 150, 278);
            this.add(firstCard);
            if(leaderCards.size() == 2) {
                secondCard = new LeaderCardLabel(leaderCards.get(1).getKey());
                secondCard.setBounds(160, 0, 150, 278);
                this.add(secondCard);
            }
        }else {
            if(firstCard != null){
                firstCard = new LeaderCardActivatedLabel(leaderCards.get(0).getKey());
                firstCard.setBounds(0,0, 150, 278);
                this.add(firstCard);
                if(leaderCards.size() == 2) {
                    secondCard = new LeaderCardActivatedLabel(leaderCards.get(1).getKey());
                    secondCard.setBounds(160, 0, 150, 278);
                    this.add(secondCard);
                }
            }else{
                secondCard = new LeaderCardActivatedLabel(leaderCards.get(0).getKey());
                secondCard.setBounds(160, 0, 150, 278);
                this.add(secondCard);
            }
        }
    }

    public void discardLeaderCard(int pos){
        if(pos == 0){
            this.remove(firstCard);
            firstCard = new JLabel();
            firstCard.setBounds(0,0, 150, 278);
            firstCard.setBackground(Color.WHITE);
            this.add(firstCard);
        }else{
            this.remove(secondCard);
            secondCard = new JLabel();
            secondCard.setBounds(160,0, 150, 278);
            secondCard.setBackground(Color.WHITE);
            this.add(secondCard);
        }
    }

    public void activatedLeaderCard(int pos, int key){
        if(pos == 0){
            this.remove(firstCard);
            firstCard = new LeaderCardActivatedLabel(key);
            firstCard.setBounds(0,0, 150, 278);
            this.add(firstCard);
        }else{
            this.remove(secondCard);
            secondCard = new LeaderCardActivatedLabel(key);
            secondCard.setBounds(160,0, 150, 278);
            this.add(secondCard);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(backgroundImage, 0, 0, null);

    }
}