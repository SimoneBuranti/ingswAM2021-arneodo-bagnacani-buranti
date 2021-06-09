package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * This class is used to create clickable pop up resources for the exception of the white marble
 */
public class WhiteMarbleLabel extends ResourceLabel implements MouseListener {

    /**
     * This attribute indicates the dimension of the resource clickable label
     */
    private static final int resourceDimension = 40;
    /**
     * This attribute contains the resources with which the white marble can be exchanged
     */
    private final ArrayList<Resource> resources;

    /**
     * Constructor of the class. It creates the clickable resource
     * @param x : the x position
     * @param y : the y position
     * @param resources : the resources with which the white marble can be exchanged
     */
    public WhiteMarbleLabel(int x, int y, ArrayList<Resource> resources){
        super(x,y,resourceDimension, resources.get(0));
        this.resources = resources;
        this.setSize(resourceDimension,resourceDimension);
        this.setBounds(x,y,resourceDimension,resourceDimension);
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.resource)).getScaledInstance(resourceDimension,resourceDimension,0)));
        this.addMouseListener(this);
    }

    /**
     * This method changes the image of the resource when the label is clicked
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if( this.resource == this.resources.get(0))
            this.resource = this.resources.get(1);
        else
            this.resource = this.resources.get(0);

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
