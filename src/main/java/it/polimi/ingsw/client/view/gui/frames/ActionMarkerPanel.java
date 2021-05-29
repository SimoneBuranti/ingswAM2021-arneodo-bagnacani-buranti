package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;

import javax.swing.*;
import java.awt.*;

public class ActionMarkerPanel extends JPanel {

    private final static int markerDimension = 90;
    private final static int panelWidth = 300;
    private final static int panelHeight = 150;
    private final static int panelX = 800;
    private final static int panelY = 250;
    private final static int markerDeckLabelX = 170;
    private final static int markerDeckLabelY = 45;
    private final static int pickedMarkerLabelX = 45;
    private final static int pickedMarkerLabelY = 45;




    private JLabel markerDeckLabel;
    private JLabel pickedMarkerLabel;
    private ImageIcon pickedIcon;
    private ImageIcon backIcon;
    private JLabel titleLabel;

    public ActionMarkerPanel(){
        super();

        initBackIcon();
        initPickedIcon();
        initMarkerDeckLabel();
        initPickedMarkerLabel();
        initTitleLabel();

        updatePickedMarkerImage("ActionMarkerProductionYellow");

        removeActionMarketDeck();

        this.setLayout(null);
        this.setBounds(panelX,panelY,panelWidth,panelHeight);
        this.setBorder(BorderFactory.createBevelBorder(0));
    }

    private void initTitleLabel() {
        this.titleLabel = new JLabel();
        titleLabel.setBounds(0,0,panelWidth,30);
        titleLabel.setText("Lorenzo the Magnificient action:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);
    }


    public void initBackIcon(){

        this.backIcon = new ImageIcon();
        this.backIcon.setImage((Paths.getImageFromPath("src/main/resources/resources/punchboard/retro cerchi.png")).getScaledInstance(markerDimension,markerDimension,0));

    }


    public void initPickedIcon(){
        this.pickedIcon = new ImageIcon();

    }

    public void updatePickedMarkerImage(String actionMarker){
        this.pickedIcon.setImage((Paths.getImageFromActionMarker(actionMarker).getScaledInstance(markerDimension,markerDimension,0)));

    }

    public void removeActionMarketDeck(){
        this.backIcon.setImage((Paths.getImageFromPath("src/main/resources/resources/punchboard/EmptyMarker.png").getScaledInstance(markerDimension,markerDimension,0)));
    }

    public void initMarkerDeckLabel(){

        this.markerDeckLabel = new JLabel();
        markerDeckLabel.setSize(markerDimension,markerDimension);
        markerDeckLabel.setBounds(markerDeckLabelX,markerDeckLabelY,markerDimension,markerDimension);
        markerDeckLabel.setIcon(this.backIcon);

        this.add(markerDeckLabel);

    }


    public void initPickedMarkerLabel(){

        this.pickedMarkerLabel = new JLabel();
        pickedMarkerLabel.setSize(markerDimension,markerDimension);
        pickedMarkerLabel.setBounds(pickedMarkerLabelX,pickedMarkerLabelY,markerDimension,markerDimension);
        pickedMarkerLabel.setIcon(this.pickedIcon);

        this.add(pickedMarkerLabel);

    }



}
