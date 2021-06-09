package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StrongBoxPanel extends JPanel {

    /**
     * Graphic parameters.
     */
    private static final int strongBoxWidth = 130;
    private static final int strongBoxHeight = 108;
    private static final int strongBoxX = 25;
    private static final int strongBoxY = 422;
    private static final int resourceDimension = 35;

    /**
     * Resource type labels.
     */
    private ResourceLabel coinLabel;
    private ResourceLabel rockLabel;
    private ResourceLabel shieldLabel;
    private ResourceLabel servantLabel;

    /**
     * Strongbox panel constructor.
     */
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

    /**
     * Updates strongbox amount of resources.
     * @param strongBox
     */
    public void updateStrongBox(Map<Resource,Integer> strongBox){
        coinLabel.setValue(strongBox.get(Resource.COIN));
        rockLabel.setValue(strongBox.get(Resource.ROCK));
        shieldLabel.setValue(strongBox.get(Resource.SHIELD));
        servantLabel.setValue(strongBox.get(Resource.SERVANT));
        this.repaint();
    }
}
