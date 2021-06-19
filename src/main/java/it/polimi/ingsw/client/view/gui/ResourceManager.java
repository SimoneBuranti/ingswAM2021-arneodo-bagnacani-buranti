package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.view.gui.listeners.ResourceListener;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.InitialResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

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

    ArrayList<Resource> buffer = new ArrayList<>();


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
        cardButton1.addActionListener(e -> {
            buffer.add(Resource.COIN);
            sendInitResource();
        });


        Image scaledImage2 = Paths.getImageFromResource(Resource.ROCK)
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        SensibleButton cardButton2 = new SensibleButton(scaledImage2);
        resourceContainer.add(cardButton2);
        cardButton2.addActionListener(e -> {
            buffer.add(Resource.ROCK);
            sendInitResource();
        });



        Image scaledImage3 = Paths.getImageFromResource(Resource.SERVANT)
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        SensibleButton cardButton3 = new SensibleButton(scaledImage3);
        resourceContainer.add(cardButton3);
        cardButton3.addActionListener(e -> {
            buffer.add(Resource.SERVANT);
            sendInitResource();
        });



        Image scaledImage4 = Paths.getImageFromResource(Resource.SHIELD)
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);  //1000, Image.SCALE_SMOOTH

        SensibleButton cardButton4 = new SensibleButton(scaledImage4);
        resourceContainer.add(cardButton4);
        cardButton4.addActionListener(e -> {
            buffer.add(Resource.SHIELD);
            sendInitResource();
        });

    }

    private void sendInitResource(){
        if (gui.getViewController().getGame().getPosition()==4){
            if (buffer.size()==2){
                (new Thread(() -> {
                    try {
                        gui.notifyObserver(new InitialResourcesMessage(buffer));
                    } catch (IOException | InterruptedException e2) {
                        e2.printStackTrace();
                    }
                })).start();
                (new Thread(() -> {
                    try {
                        gui.notifyObserver(new EndOfTurnMessage());
                    } catch (IOException | InterruptedException e3) {
                        e3.printStackTrace();
                    }
                })).start();

                gui.switchToGameMode();
            }
        }

        else if (gui.getViewController().getGame().getPosition()==2 || gui.getViewController().getGame().getPosition()==3){
            (new Thread(() -> {
                try {
                    gui.notifyObserver(new InitialResourcesMessage(buffer));
                } catch (IOException | InterruptedException e3) {
                    e3.printStackTrace();
                }
            })).start();

            (new Thread(() -> {
                try {
                    gui.notifyObserver(new EndOfTurnMessage());
                } catch (IOException | InterruptedException e3) {
                    e3.printStackTrace();
                }
            })).start();

            gui.switchToGameMode();
        }
    }

}
