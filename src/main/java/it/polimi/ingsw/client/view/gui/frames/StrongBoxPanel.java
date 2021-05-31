package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StrongBoxPanel extends JPanel {

    private static final int strongBoxWidth = 130;
    private static final int strongBoxHeight = 108;
    private static final int strongBoxX = 25;
    private static final int strongBoxY = 422;
    private static final int resourceDimension = 35;


    private ResourceLabel coinLabel;
    private ResourceLabel rockLabel;
    private ResourceLabel shieldLabel;
    private ResourceLabel servantLabel;

    public StrongBoxPanel() {

        this.setLayout(new GridLayout(2,2,2,2));

        coinLabel = new ResourceLabel(0,0,resourceDimension, Resource.COIN);
        coinLabel.setValue(0);
        rockLabel = new ResourceLabel(0,0,resourceDimension, Resource.ROCK);
        rockLabel.setValue(0);
        shieldLabel = new ResourceLabel(0,0,resourceDimension, Resource.SHIELD);
        shieldLabel.setValue(0);
        servantLabel = new ResourceLabel(0,0,resourceDimension, Resource.SERVANT);
        servantLabel.setValue(0);

        this.add(coinLabel);
        this.add(rockLabel);
        this.add(shieldLabel);
        this.add(servantLabel);

        this.setOpaque(false);
        this.setBounds(strongBoxX,strongBoxY,strongBoxWidth,strongBoxHeight);
    }

    public void updateStrongBox(Map<Resource,Integer> strongBox){
        coinLabel.setValue(strongBox.get(Resource.COIN));
        rockLabel.setValue(strongBox.get(Resource.COIN));
        shieldLabel.setValue(strongBox.get(Resource.COIN));
        servantLabel.setValue(strongBox.get(Resource.COIN));
    }
}
