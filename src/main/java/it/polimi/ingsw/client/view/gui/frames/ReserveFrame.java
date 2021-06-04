package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ReserveFrame extends JFrame {

    private final static int reserveX = 10;
    private final static int reserveY = 20;
    private final static int reserveWidth = 400;
    private final static int reserveHeight = 100;

    private ReservePanel reservePanel;
    private boolean visible;
    private Map<Resource,Integer> resources;


    public ReserveFrame() {
        super();
        this.setSize(reserveWidth,reserveHeight);
        this.setLocation(reserveX,reserveY);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Reserve");
        this.setAlwaysOnTop(true);

        resources = new HashMap<>();
        resources.put(Resource.COIN,0);
        resources.put(Resource.ROCK,0);
        resources.put(Resource.SHIELD,0);
        resources.put(Resource.SERVANT,0);

        reservePanel = new ReservePanel();
        this.add(reservePanel);
        updateReserve(this.resources);

        visible = false;
        this.setVisible(visible);
    }

    public void changeVisibility(){
        this.visible = !visible;
        this.setVisible(visible);
        this.paintComponents(this.getGraphics());
        this.paintComponents(this.getGraphics());
    };

    public void updateReserve(Map<Resource,Integer> reserve){
        reservePanel.updateReserve(reserve);
    }

}
