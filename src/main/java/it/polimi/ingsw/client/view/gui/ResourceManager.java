package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.view.gui.listeners.ResourceListener;
import it.polimi.ingsw.server.model.Resource;

import java.awt.*;

public class ResourceManager {
    private Gui gui;
    private  PanelContainer container;

    private PanelContainer cardDetailsContainer;
    private PanelContainer resourceContainer;
    private Label nameLabel;
    private Label descriptionLabel;
    private PanelContainer labelContainer;



    public ResourceManager(PanelContainer container, Gui gui){
        this.container=container;
        this.gui=gui;

        // Prepares the external container
        resourceContainer = new PanelContainer();
        resourceContainer.setBounds(0, 80, container.getWidth(), 138);
        resourceContainer.setLayout(new GridLayout(1, 9, 10, 0));

    }

    /**
     * Sets the text of the card switcher heading
     * @param heading   The text to be shown
     */
    public void setHeading(String heading){
        Label label = new Label(heading);
        label.setBackground(Color.GRAY);
        label.setBounds(0, 0, container.getWidth(), 40);
        container.add(label);
    }

    public void showWhatToChoose(boolean selectable) {

        container.add(resourceContainer);


        Image scaledImage1 = Paths.getImageFromResource(Resource.COIN)
                    .getScaledInstance(50, 1000, Image.SCALE_SMOOTH);

        SensibleButton cardButton1 = new SensibleButton(scaledImage1);
        resourceContainer.add(cardButton1);
        cardButton1.addMouseListener(new ResourceListener(Resource.COIN, this,gui));


        Image scaledImage2 = Paths.getImageFromResource(Resource.ROCK)
                .getScaledInstance(50, 1000, Image.SCALE_SMOOTH);

        SensibleButton cardButton2 = new SensibleButton(scaledImage2);
        resourceContainer.add(cardButton2);
        cardButton2.addMouseListener(new ResourceListener(Resource.ROCK, this,gui));



        Image scaledImage3 = Paths.getImageFromResource(Resource.SERVANT)
                .getScaledInstance(50, 1000, Image.SCALE_SMOOTH);

        SensibleButton cardButton3 = new SensibleButton(scaledImage3);
        resourceContainer.add(cardButton3);
        cardButton3.addMouseListener(new ResourceListener(Resource.SERVANT, this,gui));



        Image scaledImage4 = Paths.getImageFromResource(Resource.SHIELD)
                .getScaledInstance(50, 1000, Image.SCALE_SMOOTH);

        SensibleButton cardButton4 = new SensibleButton(scaledImage4);
        resourceContainer.add(cardButton4);
        cardButton4.addMouseListener(new ResourceListener(Resource.SHIELD, this,gui));

    }

}
