package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.lightModel.lightGameBoard.LightLeaderCards;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardStorage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderCardsPanel extends JPanel {
    private final static int leaderWidth = 370;
    private final static int leaderHeight = 290; //278

    private EmptyLeaderCardLabel firstCard;
    private EmptyLeaderCardLabel secondCard;
    private ArrayList<ResourceLabel> firstResources;
    private ArrayList<ResourceLabel> secondResources;

    private Gui gui;

    public LeaderCardsPanel(Gui gui){
        super();
        this.gui = gui;
        firstResources = new ArrayList<>();
        secondResources = new ArrayList<>();
        this.setLayout(null);
        this.setBounds(810, 280, leaderWidth, leaderHeight);
        setOpaque(false);
    }



    public void addLeaderCards(ArrayList<LeaderCard> leaderCards, boolean activated){
        if(!activated){
            firstCard = new LeaderCardLabel(leaderCards.get(0).getKey(), gui, 0);
            firstCard.setBounds(0,0, 150, 278);
            this.add(firstCard);
            if(leaderCards.size() == 2) {
                secondCard = new LeaderCardLabel(leaderCards.get(1).getKey(), gui, 1);
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
            firstCard = new EmptyLeaderCardLabel();
            firstCard.setBounds(0,0, 150, 278);
            firstCard.setBackground(Color.WHITE);
            this.add(firstCard);
        }else{
            this.remove(secondCard);
            secondCard = new EmptyLeaderCardLabel();
            secondCard.setBounds(160,0, 150, 278);
            secondCard.setBackground(Color.WHITE);
            this.add(secondCard);
        }
    }

    public void activatedLeaderCard(int pos, int key){
        if(pos == 0){
            this.remove(firstCard);
            firstCard = new LeaderCardActivatedLabel(key);
            firstCard.setBounds(0,0, 150, 232);
            this.add(firstCard);
            new LightLeaderCards();
            if(LightLeaderCards.leaderCardByKey(key) instanceof LeaderCardStorage){
                JLabel textLabel = new JLabel("Extra storage:");
                textLabel.setBounds(40, 234, 150, 15);
                this.add(textLabel);
            }
        }else{
            this.remove(secondCard);
            secondCard = new LeaderCardActivatedLabel(key);
            secondCard.setBounds(160,0, 150, 232);
            this.add(secondCard);
            new LightLeaderCards();
            if(LightLeaderCards.leaderCardByKey(key) instanceof LeaderCardStorage){
                JLabel textLabel = new JLabel("Extra storage:");
                textLabel.setBounds(200, 234, 150, 15);
                this.add(textLabel);
            }
        }

    }

    public void addToStorageExtra(int position, Resource resource, int quantity){
        if(position == 0){
            for(ResourceLabel resourceLabel : firstResources){
                this.remove(resourceLabel);
            }
            if(quantity == 1){
                ResourceLabel firstLabel = new ResourceLabel(30, 250, 40, resource);
                firstResources.add(firstLabel);
                firstLabel.setBounds(30, 250, 40, 40);
                this.add(firstLabel);
            }else if(quantity == 2){
                ResourceLabel firstLabel = new ResourceLabel(30, 250, 40, resource);
                firstResources.add(firstLabel);
                firstLabel.setBounds(30, 250, 40, 40);
                this.add(firstLabel);

                ResourceLabel secondLabel = new ResourceLabel(85, 250, 40, resource);
                firstResources.add(secondLabel);
                secondLabel.setBounds(85, 250, 40, 40);
                this.add(secondLabel);
            }
        }else{
            for(ResourceLabel resourceLabel : secondResources){
                this.remove(resourceLabel);
            }
            if(quantity == 1){
                ResourceLabel firstLabel = new ResourceLabel(190, 250, 40, resource);
                secondResources.add(firstLabel);
                firstLabel.setBounds(190, 250, 40, 40);
                this.add(firstLabel);
            }else if(quantity == 2){
                ResourceLabel firstLabel = new ResourceLabel(190, 250, 40, resource);
                secondResources.add(firstLabel);
                firstLabel.setBounds(190, 250, 40, 40);
                this.add(firstLabel);

                ResourceLabel secondLabel = new ResourceLabel(245, 250, 40, resource);
                secondResources.add(secondLabel);
                secondLabel.setBounds(245, 250, 40, 40);
                this.add(secondLabel);
            }
        }
    }

    public void enableButtons(){
        firstCard.enableButtons();
        secondCard.enableButtons();
    }

    public void disableButtons(){
        firstCard.disableButtons();
        secondCard.disableButtons();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(backgroundImage, 0, 0, null);

    }

    public void addLeaderCardsAsInt(ArrayList<Integer> leaderCards, boolean activated){
        if(!activated){
            firstCard = new LeaderCardLabel(leaderCards.get(0),gui,0);
            firstCard.setBounds(0,0, 150, 278);
            this.add(firstCard);
            if(leaderCards.size() == 2) {
                secondCard = new LeaderCardLabel(leaderCards.get(1),gui,1);
                secondCard.setBounds(160, 0, 150, 278);
                this.add(secondCard);
            }
        }else {
            if(firstCard != null){
                firstCard = new LeaderCardActivatedLabel(leaderCards.get(0));
                firstCard.setBounds(0,0, 150, 278);
                this.add(firstCard);
                if(leaderCards.size() == 2) {
                    secondCard = new LeaderCardActivatedLabel(leaderCards.get(1));
                    secondCard.setBounds(160, 0, 150, 278);
                    this.add(secondCard);
                }
            }else{
                secondCard = new LeaderCardActivatedLabel(leaderCards.get(0));
                secondCard.setBounds(160, 0, 150, 278);
                this.add(secondCard);
            }
        }
}
    public void addToStorageExtraPlayerOpponent(Resource resource1, Resource resource2, int howmany1, int howmany2){

            if(howmany1 == 1){
                ResourceLabel firstLabel = new ResourceLabel(30, 250, 40, resource1);
                firstResources.add(firstLabel);
                firstLabel.setBounds(30, 250, 40, 40);
                this.add(firstLabel);
            }else if(howmany1 == 2){
                ResourceLabel firstLabel = new ResourceLabel(30, 250, 40, resource1);
                firstResources.add(firstLabel);
                firstLabel.setBounds(30, 250, 40, 40);
                this.add(firstLabel);

                ResourceLabel secondLabel = new ResourceLabel(85, 250, 40, resource1);
                firstResources.add(secondLabel);
                secondLabel.setBounds(85, 250, 40, 40);
                this.add(secondLabel);
            }

            if(howmany2 == 1){
                ResourceLabel firstLabel = new ResourceLabel(190, 250, 40, resource2);
                secondResources.add(firstLabel);
                firstLabel.setBounds(190, 250, 40, 40);
                this.add(firstLabel);
            }else if(howmany2 == 2){
                ResourceLabel firstLabel = new ResourceLabel(190, 250, 40, resource2);
                secondResources.add(firstLabel);
                firstLabel.setBounds(190, 250, 40, 40);
                this.add(firstLabel);

                ResourceLabel secondLabel = new ResourceLabel(245, 250, 40, resource2);
                secondResources.add(secondLabel);
                secondLabel.setBounds(245, 250, 40, 40);
                this.add(secondLabel);
            }

    }




}