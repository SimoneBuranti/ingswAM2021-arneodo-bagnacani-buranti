package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;

public class ResourceLabel extends JLabel{

    protected Resource resource;

    private int resourceDimension;

    public ResourceLabel(int x,int y,int dimension,Resource resource){
        this.resourceDimension = dimension;
        this.resource = resource;
        this.setSize(resourceDimension,resourceDimension);
        this.setBounds(x,y,resourceDimension,resourceDimension);
        this.setIcon(new ImageIcon((Paths.getImageFromResource(this.resource)).getScaledInstance(resourceDimension,resourceDimension,0)));
    }

    public Resource getResource() {
        return resource;
    }

    public void setValue(Integer value) {
        String val = "" + value.intValue();

        this.setText(val);
        this.setForeground(Color.WHITE);
    }
}
