package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ReserveFrame extends JFrame {

    /**
     * Reserve graphic parameters.
     */
    private final static int reserveX = 10;
    private final static int reserveY = 20;
    private final static int reserveWidth = 400;
    private final static int reserveHeight = 100;

    /**
     * Reserve panel reference.
     */
    private ReservePanel reservePanel;

    /**
     * Frame visibility attribute.
     */
    private boolean visible;
    /**
     * Reserve resources.
     */
    private Map<Resource,Integer> resources;


    /**
     * Reserve frame constructor.
     */
    public ReserveFrame() {
        super();
        this.setSize(reserveWidth,reserveHeight);
        this.setLocation(reserveX,reserveY);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Reserve");
        this.setAlwaysOnTop(true);

        resources = new HashMap<>();
        resources.put(Resource.COIN,100);
        resources.put(Resource.ROCK,100);
        resources.put(Resource.SHIELD,100);
        resources.put(Resource.SERVANT,100);

        reservePanel = new ReservePanel();
        this.add(reservePanel);
        updateReserve(this.resources);

        visible = false;
        this.setVisible(visible);
    }

    /**
     * Change visibility to the frame.
     */
    public void changeVisibility(){
        this.visible = !visible;
        this.setVisible(visible);
        this.paintComponents(this.getGraphics());
        this.paintComponents(this.getGraphics());
    };

    /**
     * UpdateReserve method displays new reserve resources.
     * @param reserve
     */
    public void updateReserve(Map<Resource,Integer> reserve){
        reservePanel.updateReserve(reserve);
    }

}
