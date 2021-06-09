package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;

public class ResourceLabel extends JLabel{

    /**
     * Resource type of the label.
     */
    protected Resource resource;

    /**
     * Amount of the displayed resource.
     */
    private int resourceDimension;

    /**
     * Resource label constructor.
     * @param x
     * @param y
     * @param dimension
     * @param resource
     */
    public ResourceLabel(int x,int y,int dimension,Resource resource){
        this.resourceDimension = dimension;
        this.resource = resource;
        this.setSize(resourceDimension,resourceDimension);
        this.setBounds(x,y,resourceDimension,resourceDimension);
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.resource)).getScaledInstance(resourceDimension,resourceDimension,0)));
    }

    /**
     * Resource type getter.
     * @return
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Resource amount setter.
     * @param value
     */
    public void setValue(Integer value) {
        String val = "" + value.intValue();

        this.setText(val);
        this.setForeground(Color.WHITE);
    }
}
