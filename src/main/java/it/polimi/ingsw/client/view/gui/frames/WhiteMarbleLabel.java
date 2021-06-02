package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WhiteMarbleLabel extends ResourceLabel implements MouseListener {

    private static final int resourceDimension = 40;
    private final ArrayList<Resource> resources;

    public WhiteMarbleLabel(int x, int y, ArrayList<Resource> resources){
        super(x,y,resourceDimension, resources.get(0));
        this.resources = resources;
        this.setSize(resourceDimension,resourceDimension);
        this.setBounds(x,y,resourceDimension,resourceDimension);
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.resource)).getScaledInstance(resourceDimension,resourceDimension,0)));
        this.addMouseListener(this);
    }

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
