package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ReservePanel extends JPanel {

    private static final int reserveWidth = 180;
    private static final int reserveHeight = 150;
    private static final int reserveX = 25;
    private static final int reserveY = 422;
    private static final int reserveDimension = 35;


    private ResourceLabel coinLabel;
    private ResourceLabel rockLabel;
    private ResourceLabel shieldLabel;
    private ResourceLabel servantLabel;

    public ReservePanel() {
        super();

        this.setLayout(new GridLayout(2,2,2,2));

        ResourceLabel coinLabel = new ResourceLabel(0,0,reserveDimension, Resource.COIN);
        coinLabel.setValue(0);
        ResourceLabel rockLabel = new ResourceLabel(0,0,reserveDimension, Resource.ROCK);
        rockLabel.setValue(0);
        ResourceLabel shieldLabel = new ResourceLabel(0,0,reserveDimension, Resource.SHIELD);
        shieldLabel.setValue(0);
        ResourceLabel servantLabel = new ResourceLabel(0,0,reserveDimension, Resource.SERVANT);
        servantLabel.setValue(0);

        this.add(coinLabel);
        this.add(rockLabel);
        this.add(shieldLabel);
        this.add(servantLabel);

        this.setOpaque(false);
        this.setBounds(reserveX,reserveY,reserveWidth,reserveHeight);
    }

    public void updateReserve(Map<Resource,Integer> strongBox){
        coinLabel.setValue(strongBox.get(Resource.COIN));
        rockLabel.setValue(strongBox.get(Resource.COIN));
        shieldLabel.setValue(strongBox.get(Resource.COIN));
        servantLabel.setValue(strongBox.get(Resource.COIN));
    }
}
