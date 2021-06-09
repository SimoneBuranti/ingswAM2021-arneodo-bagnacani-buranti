package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.ResourceManager;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.InitialResourcesMessage;
import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the listener of the initial resources that are chosen
 */
public class ResourceListener implements MouseListener {
    /**
     * This attribute represents the reference to the resource to listen
     */
    private Resource resource ;
    /**
     * This attribute represents the reference to the gui
     */
    private Gui gui;
    /**
     * This attribute contains the resources to send to the server
     */
    private ArrayList<Resource> sendableArray = new ArrayList<>();


    /**
     * Constructor: build a CardListener with single selection
     * @param resource                 The manager resource
     * @param resourceManager          The resource switcher to be controlled
     * @param gui                      The reference to the gui
     */
    public ResourceListener(Resource resource , ResourceManager resourceManager, Gui gui) {

        this.resource=resource;
        this.gui=gui;

    }


    /**
     * This method sends an initial resource and end of turn messages to the server when the initial resources
     * have been chosen
     */
    public void mouseClicked(MouseEvent e) {
        addToArrayList(resource);

        if (gui.getViewController().getGame().getPosition()==3 || gui.getViewController().getGame().getPosition()==4){
            if (gui.getReadyToSend()==2){
                (new Thread(() -> {
                try {
                    gui.notifyObserver(new InitialResourcesMessage(sendableArray));
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

        else if (gui.getViewController().getGame().getPosition()==2){
            (new Thread(() -> {
                try {
                    gui.notifyObserver(new InitialResourcesMessage(sendableArray));
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


    /**
     * This method adds the resource passed as a parameter to the sendableArray
     */
    private void addToArrayList(Resource resource) {
        sendableArray.add(resource);
    }



    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
