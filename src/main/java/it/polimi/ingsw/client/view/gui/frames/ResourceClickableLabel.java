package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ResourceClickableLabel extends JLabel implements MouseListener {

    private Resource selected;

    private static final int resourceDimension = 20;

    public ResourceClickableLabel(int x,int y){

        this.selected = Resource.COIN;
        this.setSize(resourceDimension,resourceDimension);
        this.setBounds(x,y,resourceDimension,resourceDimension);
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.selected)).getScaledInstance(resourceDimension,resourceDimension,0)));
        this.addMouseListener(this);
    }

    public Resource getSelected() {
        return selected;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(this.selected) {
            case COIN: {
                this.selected = Resource.ROCK;
                break;
            }
            case ROCK: {
                this.selected = Resource.SHIELD;
                break;
            }
            case SHIELD: {
                this.selected = Resource.SERVANT;
                break;
            }
            case SERVANT: {
                this.selected = Resource.COIN;
                break;
            }
        }
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.selected)).getScaledInstance(resourceDimension, resourceDimension, 0)));
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
