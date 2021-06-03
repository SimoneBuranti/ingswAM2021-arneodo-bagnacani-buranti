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

public class ResourceListener implements MouseListener {
    private Resource resource ;
    private Gui gui;
    private ArrayList<Resource> sendableArray = new ArrayList<>();



    public ResourceListener(Resource resource , ResourceManager resourceManager, Gui gui) {

        this.resource=resource;
        this.gui=gui;

    }


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

                System.out.println("hey lo chiamo da qua1"+Thread.currentThread().getName());
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


            System.out.println("hey lo chiamo da qua2"+Thread.currentThread().getName());
            gui.switchToGameMode();
            }
        }

    private void addToArrayList(Resource resource) {
        sendableArray.add(resource);
    }


    /**
     * Mouse on-card-press manager: same as on-card-click
     * @param e The mouse event
     */
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
    }



    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
