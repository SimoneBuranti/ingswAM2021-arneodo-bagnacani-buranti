package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ResourceClickableLabel extends ResourceLabel implements MouseListener {

    private static final int resourceDimension = 27;

    public ResourceClickableLabel(int x,int y){
        super(x,y,resourceDimension,Resource.COIN);
        this.setSize(resourceDimension,resourceDimension);
        this.setBounds(x,y,resourceDimension,resourceDimension);
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.resource)).getScaledInstance(resourceDimension,resourceDimension,0)));
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(this.resource) {
            case COIN: {
                this.resource = Resource.ROCK;
                break;
            }
            case ROCK: {
                this.resource = Resource.SHIELD;
                break;
            }
            case SHIELD: {
                this.resource = Resource.SERVANT;
                break;
            }
            case SERVANT: {
                this.resource = Resource.COIN;
                break;
            }
        }
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.resource)).getScaledInstance(resourceDimension, resourceDimension, 0)));
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
