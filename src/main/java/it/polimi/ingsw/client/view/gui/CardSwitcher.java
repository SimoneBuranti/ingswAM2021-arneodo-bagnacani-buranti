package it.polimi.ingsw.client.view.gui;

import java.awt.*;
import java.util.List;

/**
 * A cards switcher with an action listener that enable multiple or single selection
 */
public class CardSwitcher {
    private Gui gui;
    private  PanelContainer container;

    private PanelContainer cardDetailsContainer;
    private PanelContainer cardContainer;
    private Label nameLabel;
    private Label descriptionLabel;
    private PanelContainer labelContainer;
    private boolean switcherVisibility;


    public CardSwitcher(PanelContainer container, Gui gui){
        this.container=container;
        this.gui=gui;
        switcherVisibility=false;

        // Prepares the external container
        cardContainer = new PanelContainer();
        cardContainer.setBounds(0, 80, container.getWidth(), 138);
        cardContainer.setLayout(new GridLayout(1, 9, 10, 0));

        // Prepare the card details container
        cardDetailsContainer = new PanelContainer();
        cardDetailsContainer.setBounds(0, 280, container.getWidth(), 150);
        cardDetailsContainer.setLayout(null);

        // Prepare the card name label
        nameLabel = new Label("");
        nameLabel.setForeground(new Color(186, 164, 154));
        nameLabel.setBounds(0, 20, cardDetailsContainer.getWidth(), 35);
        cardDetailsContainer.add(nameLabel);

        // Prepare the card description label
        descriptionLabel = new Label("");
        descriptionLabel.setFont(new Font("Helvetica", Font.PLAIN, 17));
        descriptionLabel.setBounds(90, 50, cardDetailsContainer.getWidth() - 180, 80);
        cardDetailsContainer.add(descriptionLabel);
    }

    /**
     * Sets the text of the card switcher heading
     * @param heading   The text to be shown
     */
    public void setHeading(String heading){
        Label label = new Label(heading);
       label.setBounds(0, 0, container.getWidth(), 40);
        container.add(label);
    }

    /**
     * Sets the card label to be shown below each card
     * @param owners  The label values or null value to clear the labels
     */
    public void setSingleCardLabel(List<String> owners){
        if(labelContainer==null) {
            labelContainer = new PanelContainer();
            labelContainer.setBounds(0, 225, container.getWidth(), 30);
            labelContainer.setLayout(new GridLayout(1, 3, 10, 0));
            container.add(labelContainer);

            for(String owner: owners){
                Label cardLabel = new Label(owner);
                cardLabel.setForeground(new Color(186, 164, 154));
                labelContainer.add(cardLabel);
            }
        }
    }



    public void showWhatToChoose(boolean selectable) {
        switcherVisibility=true;
        container.add(cardContainer);

        for (int i=0; i<4; i++) {
            Image scaledImage = Paths.getLeaderImageFromKey(gui
                                                            .getViewController()
                                                            .getGame()
                                                            .getGameBoardOfPlayer()
                                                            .getLeaderCard(i)
                                                            .getKey())
                                                            .getScaledInstance(82, 138, Image.SCALE_SMOOTH);

            SensibleButton cardButton = new SensibleButton(scaledImage);
            cardContainer.add(cardButton);
            cardButton.addMouseListener(new CardListener(gui
                                                                .getViewController()
                                                                .getGame()
                                                                .getGameBoardOfPlayer()
                                                                .getLeaderCard(i), this, selectable,gui));
        }
    }

   /**
     * Adds the switcher to the container in a default position with a multiple selection action listener
     * The switcher contains all the cards except a specified set of cards
     *
     * @param chosenCards   The cards not to be shown
     * @param numCards      The number of cards to be selected
     */
   /* public void showWhatToChoose(List<LeaderCard> chosenCards,int numCards) {
        switcherVisibility=true;
        container.add(cardContainer);

        List<LeaderCard> allCardList = Configurator.getAllCards();
        allCardList.removeAll(chosenCards);
        for (Card card : allCardList) {
            Image scaledImage = Configurator.getCardImage(card.getName()).getScaledInstance(82, 138, Image.SCALE_SMOOTH);
            SensibleButton cardButton = new SensibleButton(scaledImage);
            cardContainer.add(cardButton);
            cardButton.addMouseListener(new CardListener(card, this, chosenCards, numCards));
        }
    }*/

   /* /**
     * Adds the card details container to the default container in a default position
     * if the switcher has already been added.
     */
   /* public void showCardDetails() {
        if(!switcherVisibility)
            return;
        container.add(cardDetailsContainer);
    }*/



}