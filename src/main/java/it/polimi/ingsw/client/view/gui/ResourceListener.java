package it.polimi.ingsw.client.view.gui;

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



    public ResourceListener(Resource resource , ResourceManager resourceManager,Gui gui) {

        this.resource=resource;
        this.gui=gui;

    }

    public void mouseClicked(MouseEvent e) {
        addToArrayList(resource);

        if (gui.getViewController().getGame().getPosition()==3 || gui.getViewController().getGame().getPosition()==4){
            if (gui.getReadyToSend()==2){
                try {
                    gui.notifyObserver(new KeepResourcesMessage(sendableArray));
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }}}

        if (gui.getViewController().getGame().getPosition()==2){
            if (gui.getReadyToSend()==1){
                try {
                    gui.notifyObserver(new KeepResourcesMessage(sendableArray));
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }}}
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
