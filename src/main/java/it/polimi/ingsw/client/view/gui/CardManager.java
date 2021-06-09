package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.view.gui.listeners.CardListener;

import java.awt.*;

/**
 * A cards switcher with an action listener that enable multiple or single selection
 */
public class CardManager {

    /**
     * Gui reference.
     */
    private Gui gui;

    /**
     * Panel container attribute.
     */
    private  PanelContainer container;

    /**
     * Card container attribute.
     */
    private PanelContainer cardDetailsContainer;

    /**
     * Card container attribute.
     */
    private PanelContainer cardContainer;

    /**
     * Name label attribute.
     */
    private Label nameLabel;

    /**
     * User interface label.
     */
    private Label descriptionLabel;


    /**
     * Card manager constructor.
     * @param container
     * @param gui
     */
    public CardManager(PanelContainer container, Gui gui){
        this.container=container;
        this.gui=gui;

        // Prepares the external container
        cardContainer = new PanelContainer();
        cardContainer.setBounds(10, 30, container.getWidth(), 300);
        cardContainer.setLayout(new GridLayout(1, 9, 10, 0));

        // Prepare the card details container
        cardDetailsContainer = new PanelContainer();
        cardDetailsContainer.setBounds(10, 280, container.getWidth(), 150);
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
        label.setBackground(Color.WHITE);
        label.setBounds(0, 0, container.getWidth(), 40);
        container.add(label);
    }

    /**
     * This method shows the four initial leader cards so that the player can pick two of them.
     * @param selectable
     */
    public void showWhatToChoose(boolean selectable) {

        container.add(cardContainer);

        for (int i=0; i<4; i++) {
            Image scaledImage = Paths.getLeaderImageFromKey(gui
                                                            .getViewController()
                                                            .getGame()
                                                            .getGameBoardOfPlayer()
                                                            .getLeaderCard(i)
                                                            .getKey())
                                                            .getScaledInstance(150, 300, Image.SCALE_SMOOTH);

            SensibleButton cardButton = new SensibleButton(scaledImage);
            cardContainer.add(cardButton);
            cardButton.addMouseListener(new CardListener(gui
                                                                .getViewController()
                                                                .getGame()
                                                                .getGameBoardOfPlayer()
                                                                .getLeaderCard(i), this, selectable,gui));
        }

    }




}