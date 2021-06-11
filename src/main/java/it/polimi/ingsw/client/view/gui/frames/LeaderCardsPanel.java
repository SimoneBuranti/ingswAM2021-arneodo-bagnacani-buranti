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
/**
 * This class is used to create panels containing the leader cards of the game board.
 */
public class LeaderCardsPanel extends JPanel {
    /**
     * This attribute indicates the width of the panel
     */
    private final static int leaderWidth = 370;
    /**
     * This attribute indicates the height of the panel
     */
    private final static int leaderHeight = 290; //278

    /**
     * This attribute represents the first leader card
     */
    private EmptyLeaderCardLabel firstCard;
    /**
     * This attribute represents the second leader card
     */
    private EmptyLeaderCardLabel secondCard;
    /**
     * This attribute contains the resources of the first storage extra
     */
    private ArrayList<ResourceLabel> firstResources;
    /**
     * This attribute contains the resources of the second storage extra
     */
    private ArrayList<ResourceLabel> secondResources;
    /**
     * This attribute contains the clickable resource of the first production extra
     */
    private ResourceClickableLabel firstResourceProduction;
    /**
     * This attribute contains the button of the first production extra
     */
    private ProductionButton firstActivateButton;
    /**
     * This attribute contains the clickable resource of the second production extra
     */
    private ResourceClickableLabel secondResourceProduction;
    /**
     * This attribute contains the button of the second production extra
     */
    private ProductionButton secondActivateButton;
    /**
     * This attribute represents the reference to the gui
     */
    private Gui gui;


    /**
     * Constructor of the class. It creates the leader cards panel.
     * @param gui : the reference to the gui
     */
    public LeaderCardsPanel(Gui gui){
        super();
        this.gui = gui;
        firstResources = new ArrayList<>();
        secondResources = new ArrayList<>();
        this.setLayout(null);
        this.setBounds(810, 280, leaderWidth, leaderHeight);
        setOpaque(false);
    }

    /**
     * Constructor of the class. It creates the leader cards panel.
     */
    public LeaderCardsPanel(){
        super();
        firstResources = new ArrayList<>();
        secondResources = new ArrayList<>();
        this.setLayout(null);
        this.setBounds(810, 280, leaderWidth, leaderHeight);
        setOpaque(false);
    }

    /**
     * This method adds to the panel the leader cards present in the list passed as e parameter.
     * @param leaderCards : the list containing the leader cards
     * @param activated : true if the leader cards are activated
     */
    public void addLeaderCards(ArrayList<LeaderCard> leaderCards, boolean activated){
        if(leaderCards.size() < 3 && leaderCards.size()>0) {
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
                if (firstCard == null) {
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

    /**
     * This method discards the leader card in position pos
     * @param pos : the card's position
     */
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
        }else{
            this.remove(secondCard);
            secondCard = null;
        }
    }

    /**
     * This method creates the storage extra of the first card
     */
    public void leaderCardStorageFirst(){
        JLabel textLabel = new JLabel("Extra storage:");
        textLabel.setBounds(40, 234, 150, 15);
        this.add(textLabel);
    }

    /**
     * This method creates the storage extra of the second card
     */
    public void leaderCardStorageSecond(){
        JLabel textLabel = new JLabel("Extra storage:");
        textLabel.setBounds(200, 234, 150, 15);
        this.add(textLabel);
    }

    /**
     * This method creates the production extra of the first card
     */
    public void leaderCardProductionFirst(){
        JLabel textLabel = new JLabel("Choose:");
        textLabel.setBounds(10, 242, 50, 15);
        this.add(textLabel);
        firstResourceProduction = new ResourceClickableLabel(75, 236);
        this.add(firstResourceProduction);
        firstActivateButton = new ProductionButton();
        firstActivateButton.setText("Activate");
        firstActivateButton.setBounds(26, 268, 108, 20);
        this.add(firstActivateButton);

        if(gui.isActionDoneMode())
            firstActivateButton.setEnabled(false);

        firstActivateButton.addActionListener( e -> {
            try {
                if(firstCard.getIndex() == 0) {
                    this.gui.notifyObserver(new ExtraProductionOnMessage(firstResourceProduction.getResource(), leaderCardResource(0)));
                }
                else
                    this.gui.notifyObserver(new DoubleProductionOnMessage(firstResourceProduction.getResource(), leaderCardResource(0)));
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
            this.firstActivateButton.setEnabled(false);
            this.firstActivateButton.setToken(false);
            this.gui.disableAllExceptProductions();
        });
    }

    /**
     * This method creates the production extra of the second card
     */
    public void leaderCardProductionSecond(){
        JLabel textLabel = new JLabel("Choose:");
        textLabel.setBounds(170, 242, 50, 15);
        this.add(textLabel);
        secondResourceProduction = new ResourceClickableLabel(235, 236);
        this.add(secondResourceProduction);
        secondActivateButton = new ProductionButton();
        secondActivateButton.setText("Activate");
        secondActivateButton.setBounds(186, 268, 108, 20);
        this.add(secondActivateButton);
        if(gui.isActionDoneMode())
            secondActivateButton.setEnabled(false);

        secondActivateButton.addActionListener( e -> {
            try {
                if(secondCard.getIndex() == 0)
                    this.gui.notifyObserver(new ExtraProductionOnMessage(secondResourceProduction.getResource(), leaderCardResource(1)));
                else
                    this.gui.notifyObserver(new DoubleProductionOnMessage(secondResourceProduction.getResource(), leaderCardResource(1)));
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
            this.secondActivateButton.setEnabled(false);
            this.secondActivateButton.setToken(false);
            this.gui.disableAllExceptProductions();
        });
    }

    /**
     * This method activates the leader card with the key equal to the one passed as a parameter
     * @param key : the leader card's key
     * @param index : the leader card's new position in the light model
     */
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
                leaderCardProductionFirst();
            }
            if(secondCard != null && secondCard instanceof LeaderCardLabel){
                secondCard.setIndex(0);
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

    /**
     * This method returns the leader card's resource
     * @param index : the card's position in the panel
     * @return Resource : the resource of the card
     */
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

    /**
     * This method adds to the extra storage of the card with index equals to position the resource passed as a parameter
     * for a quantity equivalent to the quantity passed as a parameter
     * @param position : the card's index
     * @param resource : the resource to add
     * @param quantity : the quantity to add
     */
    public void addToStorageExtra(int position, Resource resource, int quantity){
        if(firstCard instanceof LeaderCardActivatedLabel && position == firstCard.getIndex()){
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
        }else if(secondCard instanceof LeaderCardActivatedLabel && position == secondCard.getIndex()){

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

    /**
     * This method enables all production buttons
     */
    public void enableProductionButtons(){
        if(firstActivateButton != null){
            firstActivateButton.setToken(true);
            firstActivateButton.setEnabled(true);
        }
        if(secondActivateButton != null){
            secondActivateButton.setToken(true);
            secondActivateButton.setEnabled(true);
        }

    }

    /**
     * This method disables all production buttons
     */
    public void disableProductionButtons(){
        if(firstActivateButton != null)
            firstActivateButton.setEnabled(false);
        if(secondActivateButton != null)
            secondActivateButton.setEnabled(false);
    }


    /**
     * This method enables all buttons of not activated leader cards
     */
    public void enableButtons(){
        if(firstCard != null)
            firstCard.enableButtons();
        if(secondCard != null)
            secondCard.enableButtons();
    }

    /**
     * This method disables all buttons of not activated leader cards
     */
    public void disableButtons(){
        if(firstCard != null)
            firstCard.disableButtons();
        if(secondCard != null)
            secondCard.disableButtons();
    }

    /**
     * This method is used to show the panel
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    /**
     * This method adds the opponent's leader cards
     * @param leaderCards : opponent's leader cards
     * @param activated : true if the leader cards are activated
     */
    public void addLeaderCardsAsInt(ArrayList<Integer> leaderCards, boolean activated){
        if (leaderCards.size()>0) {
            firstCard = new LeaderCardActivatedLabel(leaderCards.get(0), 0);
            firstCard.setBounds(0, 0, 150, 278);
            this.add(firstCard);
            new LightLeaderCards();
            if(LightLeaderCards.leaderCardByKey(leaderCards.get(0)) instanceof LeaderCardStorage) {
                leaderCardStorageFirst();
            }
            if (leaderCards.size() == 2) {
                secondCard = new LeaderCardActivatedLabel(leaderCards.get(1), 1);
                secondCard.setBounds(160, 0, 150, 278);
                this.add(secondCard);
                if(LightLeaderCards.leaderCardByKey(secondCard.keyOfLeaderCard()) instanceof LeaderCardStorage) {
                    leaderCardStorageSecond();
                }
            }
        }
    }

    /**
     * This method adds resources to the storage extra of opponent's game board
     * @param resource1 : first type of resource to add
     * @param resource2 : second type f resource to add
     * @param howMany1 : first quantity to add
     * @param howMany2 : second quantity to add
     */
    public void addToStorageExtraPlayerOpponent(Resource resource1, Resource resource2, int howMany1, int howMany2){
            if(howMany1 == 1){
                ResourceLabel firstLabel = new ResourceLabel(30, 250, 40, resource1);
                firstResources.add(firstLabel);
                firstLabel.setBounds(30, 250, 40, 40);
                this.add(firstLabel);
            }else if(howMany1 == 2){
                ResourceLabel firstLabel = new ResourceLabel(30, 250, 40, resource1);
                firstResources.add(firstLabel);
                firstLabel.setBounds(30, 250, 40, 40);
                this.add(firstLabel);

                ResourceLabel secondLabel = new ResourceLabel(85, 250, 40, resource1);
                firstResources.add(secondLabel);
                secondLabel.setBounds(85, 250, 40, 40);
                this.add(secondLabel);
            }

            if(howMany2 == 1){
                ResourceLabel firstLabel = new ResourceLabel(190, 250, 40, resource2);
                secondResources.add(firstLabel);
                firstLabel.setBounds(190, 250, 40, 40);
                this.add(firstLabel);
            }else if(howMany2 == 2){
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

    /**
     * @return the number of productions activated
     */
    public int howManyActivated() {
        int cont = 0;

        if (firstActivateButton != null && !firstActivateButton.isToken())
            cont++;
        if (secondActivateButton != null && !secondActivateButton.isToken())
            cont++;

        return cont;
    }
}