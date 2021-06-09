package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.view.gui.listeners.ResourceListener;
import it.polimi.ingsw.server.model.Resource;

import java.awt.*;

public class ResourceManager {

    /**
     * Gui reference.
     */
    private Gui gui;

    /**
     * Panel container attribute.
     */
    private  PanelContainer container;

    /**
     * Resource container attribute.
     */
    private PanelContainer resourceContainer;


    /**
     * Resurce manager constructor.
     * @param container
     * @param gui
     */
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


    /**
     * This method shows the resource types at the beginning in order to let the player choose them.
     * @param selectable
     */
    public void showWhatToChoose(boolean selectable) {

        container.add(resourceContainer);


        Image scaledImage1 = Paths.getImageFromResource(Resource.COIN)
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        SensibleButton cardButton1 = new SensibleButton(scaledImage1);
        resourceContainer.add(cardButton1);
        cardButton1.addMouseListener(new ResourceListener(Resource.COIN, this,gui));


        Image scaledImage2 = Paths.getImageFromResource(Resource.ROCK)
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        SensibleButton cardButton2 = new SensibleButton(scaledImage2);
        resourceContainer.add(cardButton2);
        cardButton2.addMouseListener(new ResourceListener(Resource.ROCK, this,gui));



        Image scaledImage3 = Paths.getImageFromResource(Resource.SERVANT)
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        SensibleButton cardButton3 = new SensibleButton(scaledImage3);
        resourceContainer.add(cardButton3);
        cardButton3.addMouseListener(new ResourceListener(Resource.SERVANT, this,gui));



        Image scaledImage4 = Paths.getImageFromResource(Resource.SHIELD)
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);  //1000, Image.SCALE_SMOOTH

        SensibleButton cardButton4 = new SensibleButton(scaledImage4);
        resourceContainer.add(cardButton4);
        cardButton4.addMouseListener(new ResourceListener(Resource.SHIELD, this,gui));

    }

}
