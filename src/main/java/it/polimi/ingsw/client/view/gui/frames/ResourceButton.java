package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;

public class ResourceButton extends JButton {

    private Resource resource;

    public ResourceButton(Resource resource){
        this.resource = resource;
        this.setIcon(new ImageIcon((Paths.getImageFromResource(resource)).getScaledInstance(40,40,0)));
        this.setBackground(new Color(232,228,212));
        this.setSize(40,40);
    }

    public Resource getResource(){
        return resource;
    }
}
