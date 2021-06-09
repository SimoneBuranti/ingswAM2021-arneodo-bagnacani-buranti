package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create buttons with the image of a resource
 */
public class ResourceButton extends JButton {

    /**
     * The resource of the button
     */
    private Resource resource;

    /**
     * This constructor creates the button with the image of the resource passed as a parameter
     */
    public ResourceButton(Resource resource){
        this.resource = resource;
        this.setIcon(new ImageIcon((Paths.getImageFromResource(resource)).getScaledInstance(40,40,0)));
        this.setBackground(new Color(232,228,212));
        this.setSize(40,40);
    }

    /**
     * @return the resource of the button
     */
    public Resource getResource(){
        return resource;
    }
}
