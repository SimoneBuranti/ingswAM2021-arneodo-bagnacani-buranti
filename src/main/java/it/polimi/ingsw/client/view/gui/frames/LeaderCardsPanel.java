package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.lightModel.lightGameBoard.LightLeaderCards;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.BaseProductionOnMessage;
import it.polimi.ingsw.messages.DoubleProductionOnMessage;
import it.polimi.ingsw.messages.ExtraProductionOnMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardProduction;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardStorage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LeaderCardsPanel extends JPanel {
    private final static int leaderWidth = 370;
    private final static int leaderHeight = 290; //278

    private EmptyLeaderCardLabel firstCard;
    private EmptyLeaderCardLabel secondCard;
    private ArrayList<ResourceLabel> firstResources;
    private ArrayList<ResourceLabel> secondResources;
    private ResourceClickableLabel firstResourceProduction;
    private JButton firstActivateButton;
    private ResourceClickableLabel secondResourceProduction;
    private JButton secondActivateButton;

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

    public LeaderCardsPanel(){
        super();
        firstResources = new ArrayList<>();
        secondResources = new ArrayList<>();
        this.setLayout(null);
        this.setBounds(810, 280, leaderWidth, leaderHeight);
        setOpaque(false);
    }


    public void addLeaderCards(ArrayList<LeaderCard> leaderCards, boolean activated){
        if(leaderCards.size() < 3) {
            if (!activated) {
                firstCard = new LeaderCardLabel(leaderCards.get(0).getKey(), gui, 0);
                firstCard.setBounds(0, 0, 150, 278);
                this.add(firstCard);
                if (leaderCards.size() == 2) {
                    secondCard = new LeaderCardLabel(leaderCards.get(1).getKey(), gui, 1);
                    secondCard.setBounds(160, 0, 150, 278);
                    this.add(secondCard);
                }
            } else {
                new LightLeaderCards();
                if (firstCard != null) {
                    firstCard = new LeaderCardActivatedLabel(leaderCards.get(0).getKey(), 0);
                    firstCard.setBounds(0, 0, 150, 278);
                    if(LightLeaderCards.leaderCardByKey(firstCard.keyOfLeaderCard()) instanceof LeaderCardStorage){
                        leaderCardStorageFirst();
                    }else if(LightLeaderCards.leaderCardByKey(firstCard.keyOfLeaderCard()) instanceof LeaderCardProduction)
                        leaderCardProductionFirst();
                    this.add(firstCard);
                    if (leaderCards.size() == 2) {
                        secondCard = new LeaderCardActivatedLabel(leaderCards.get(1).getKey(), 1);
                        secondCard.setBounds(160, 0, 150, 278);
                        if(LightLeaderCards.leaderCardByKey(secondCard.keyOfLeaderCard()) instanceof LeaderCardStorage){
                            leaderCardStorageSecond();
                        }else if(LightLeaderCards.leaderCardByKey(secondCard.keyOfLeaderCard()) instanceof LeaderCardProduction)
                            leaderCardProductionSecond();
                        this.add(secondCard);
                    }
                } else {
                    secondCard = new LeaderCardActivatedLabel(leaderCards.get(0).getKey(), 0);
                    secondCard.setBounds(160, 0, 150, 278);
                    if(LightLeaderCards.leaderCardByKey(secondCard.keyOfLeaderCard()) instanceof LeaderCardStorage){
                        leaderCardStorageSecond();
                    }else if(LightLeaderCards.leaderCardByKey(secondCard.keyOfLeaderCard()) instanceof LeaderCardProduction)
                        leaderCardProductionSecond();
                    this.add(secondCard);
                }
            }
        }
    }

    public void discardLeaderCard(int pos){
        if(pos == 0){
            this.remove(firstCard);
            if(secondCard != null) {
                if (secondCard instanceof LeaderCardLabel) {
                    firstCard = new LeaderCardLabel(secondCard.keyOfLeaderCard(), gui, 0);
                    firstCard.setBounds(0, 0, 150, 278);
                    this.add(firstCard);
                } else {
                    firstCard = new LeaderCardActivatedLabel(secondCard.keyOfLeaderCard(), 0);
                    new LightLeaderCards();
                    if (LightLeaderCards.leaderCardByKey(firstCard.keyOfLeaderCard()) instanceof LeaderCardStorage) {
                        leaderCardStorageFirst();
                    } else if (LightLeaderCards.leaderCardByKey(firstCard.keyOfLeaderCard()) instanceof LeaderCardProduction)
                        leaderCardProductionFirst();
                    firstCard.setBounds(0, 0, 150, 278);
                    this.add(firstCard);
                }
                this.remove(secondCard);
                secondCard = null;
            }
            /*secondCard = new EmptyLeaderCardLabel();
            secondCard.setBounds(0,0, 150, 278);
            secondCard.setBackground(Color.WHITE);
            this.add(secondCard);*/
        }else{
            this.remove(secondCard);
            secondCard = null;
            /*secondCard = new EmptyLeaderCardLabel();
            secondCard.setBounds(160,0, 150, 278);
            secondCard.setBackground(Color.WHITE);
            this.add(secondCard);*/
        }
    }

    public void leaderCardStorageFirst(){
        JLabel textLabel = new JLabel("Extra storage:");
        textLabel.setBounds(40, 234, 150, 15);
        this.add(textLabel);
    }

    public void leaderCardStorageSecond(){
        JLabel textLabel = new JLabel("Extra storage:");
        textLabel.setBounds(200, 234, 150, 15);
        this.add(textLabel);
    }

    public void leaderCardProductionFirst(){
        JLabel textLabel = new JLabel("Choose:");
        textLabel.setBounds(10, 242, 50, 15);
        this.add(textLabel);
        firstResourceProduction = new ResourceClickableLabel(75, 236);
        this.add(firstResourceProduction);
        firstActivateButton = new JButton();
        firstActivateButton.setText("Activate");
        firstActivateButton.setBounds(26, 268, 108, 20);
        this.add(firstActivateButton);

        firstActivateButton.addActionListener( e -> {
            try {
                if(firstCard.getIndex() == 0)
                    this.gui.notifyObserver(new ExtraProductionOnMessage(firstResourceProduction.getResource(), leaderCardResource(0)));
                else
                    this.gui.notifyObserver(new DoubleProductionOnMessage(firstResourceProduction.getResource(), leaderCardResource(0)));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //System.out.println(new BaseProductionOnMessage(this.input1.getResource(),this.input2.getResource(),this.output.getResource()));
            this.firstActivateButton.setEnabled(false);
            this.gui.disableAllExceptProductions();
        });
    }

    public void leaderCardProductionSecond(){
        JLabel textLabel = new JLabel("Choose:");
        textLabel.setBounds(170, 242, 50, 15);
        this.add(textLabel);
        secondResourceProduction = new ResourceClickableLabel(235, 236);
        this.add(secondResourceProduction);
        secondActivateButton = new JButton();
        secondActivateButton.setText("Activate");
        secondActivateButton.setBounds(186, 268, 108, 20);
        this.add(secondActivateButton);

        secondActivateButton.addActionListener( e -> {
            try {
                if(firstCard.getIndex() == 0)
                    this.gui.notifyObserver(new ExtraProductionOnMessage(secondResourceProduction.getResource(), leaderCardResource(1)));
                else
                    this.gui.notifyObserver(new DoubleProductionOnMessage(secondResourceProduction.getResource(), leaderCardResource(1)));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //System.out.println(new BaseProductionOnMessage(this.input1.getResource(),this.input2.getResource(),this.output.getResource()));
            this.secondActivateButton.setEnabled(false);
            this.gui.disableAllExceptProductions();
        });
    }

    public void activatedLeaderCard(int key, int index){
        if(key == firstCard.keyOfLeaderCard()){
            this.remove(firstCard);
            firstCard = new LeaderCardActivatedLabel(key, index);
            firstCard.setBounds(0,0, 150, 232);
            this.add(firstCard);
            new LightLeaderCards();
            if(LightLeaderCards.leaderCardByKey(key) instanceof LeaderCardStorage){
                leaderCardStorageFirst();
            }else if(LightLeaderCards.leaderCardByKey(key) instanceof LeaderCardProduction){
                leaderCardProductionSecond();
            }
        }else{
            this.remove(secondCard);
            secondCard = new LeaderCardActivatedLabel(key, index);
            secondCard.setBounds(160,0, 150, 232);
            this.add(secondCard);
            new LightLeaderCards();
            if(LightLeaderCards.leaderCardByKey(key) instanceof LeaderCardStorage){
                leaderCardStorageSecond();
            }else if(LightLeaderCards.leaderCardByKey(key) instanceof LeaderCardProduction){
                leaderCardProductionSecond();
            }
        }

    }

    public Resource leaderCardResource(int index){
        int key;
        LeaderCard temp;
        new LightLeaderCards();
        if(index == 0){
            key = firstCard.keyOfLeaderCard();
        }else{
            key = secondCard.keyOfLeaderCard();
        }
        temp = LightLeaderCards.leaderCardByKey(key);
        return temp.getResourceEffect();
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

    public void enableProductionButtons(){
        if(firstActivateButton != null)
            firstActivateButton.setEnabled(true);
        if(secondActivateButton != null)
            secondActivateButton.setEnabled(true);
    }

    public void disableProductionButtons(){
        if(firstActivateButton != null)
            firstActivateButton.setEnabled(false);
        if(secondActivateButton != null)
            secondActivateButton.setEnabled(false);
    }


    public void enableButtons(){
        if(firstCard != null)
            firstCard.enableButtons();
        if(firstCard != null)
            secondCard.enableButtons();
    }

    public void disableButtons(){
        if(firstCard != null)
            firstCard.disableButtons();
        if(firstCard != null)
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
                firstCard = new LeaderCardActivatedLabel(leaderCards.get(0), 0);
                firstCard.setBounds(0,0, 150, 278);
                this.add(firstCard);
                if(leaderCards.size() == 2) {
                    secondCard = new LeaderCardActivatedLabel(leaderCards.get(1), 1);
                    secondCard.setBounds(160, 0, 150, 278);
                    this.add(secondCard);
                }
            }else{
                secondCard = new LeaderCardActivatedLabel(leaderCards.get(0),0);
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