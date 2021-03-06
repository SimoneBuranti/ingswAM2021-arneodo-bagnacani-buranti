package it.polimi.ingsw.client.view.gui.frames;


import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ReservePanel extends JPanel {

    /**
     * Reserve panel graphic parameters.
     */
    private static final int reserveWidth = 400;
    private static final int reserveHeight = 100;
    private static final int reserveX = 0;
    private static final int reserveY = 0;
    private static final int reserveDimension = 40;

    /**
     * Reserve image attribute.
     */
    private Image reserveImage;

    /**
     * Resource type labels.
     */
    private ResourceLabel coinLabel;
    private ResourceLabel rockLabel;
    private ResourceLabel shieldLabel;
    private ResourceLabel servantLabel;

    /**
     * Reserve panel constructor.
     */
    public ReservePanel() {
        super();

        this.setLayout(new FlowLayout(SwingConstants.CENTER,30,15));
        reserveImage = (Paths.getImageFromPath("/punchboard/reserve.png"))
                .getScaledInstance(reserveWidth,reserveHeight,0);


        coinLabel = new ResourceLabel(0,0,reserveDimension, Resource.COIN);
        coinLabel.setValue(0);
        coinLabel.setBounds(20,10,reserveDimension,reserveDimension);
        rockLabel = new ResourceLabel(0,0,reserveDimension, Resource.ROCK);
        rockLabel.setValue(0);
        rockLabel.setBounds(100,10,reserveDimension,reserveDimension);
        shieldLabel = new ResourceLabel(0,0,reserveDimension, Resource.SHIELD);
        shieldLabel.setValue(0);
        shieldLabel.setBounds(180,10,reserveDimension,reserveDimension);
        servantLabel = new ResourceLabel(0,0,reserveDimension, Resource.SERVANT);
        servantLabel.setValue(0);
        servantLabel.setBounds(260,10,reserveDimension,reserveDimension);

        this.add(coinLabel);
        this.add(rockLabel);
        this.add(shieldLabel);
        this.add(servantLabel);

        this.setOpaque(false);
        this.setBounds(reserveX,reserveY,reserveWidth,reserveHeight);
    }

    /**
     * For each resource type a new value is set.
     * @param reserve
     */
    public void updateReserve(Map<Resource,Integer> reserve){
        coinLabel.setValue(reserve.get(Resource.COIN));
        rockLabel.setValue(reserve.get(Resource.ROCK));
        shieldLabel.setValue(reserve.get(Resource.SHIELD));
        servantLabel.setValue(reserve.get(Resource.SERVANT));
        this.repaint();
    }

    /**
     * Overriding method to display a background image.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(reserveImage, 0, 0, null);

    }
}
