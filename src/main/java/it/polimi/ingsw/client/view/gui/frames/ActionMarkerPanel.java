package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;

import javax.swing.*;
import java.awt.*;

/**
 * Action marker panel class.
 */
public class ActionMarkerPanel extends JPanel {

    /**
     * Graphic parameters.
     */
    private final static int markerDimension = 90;
    private final static int panelWidth = 305;
    private final static int panelHeight = 150;
    private final static int panelX = 0;
    private final static int panelY = 0;
    private final static int markerDeckLabelX = 170;
    private final static int markerDeckLabelY = 45;
    private final static int pickedMarkerLabelX = 45;
    private final static int pickedMarkerLabelY = 45;


    /**
     * Marker deck label.
     */
    private JLabel markerDeckLabel;

    /**
     * Picked marker label.
     */
    private JLabel pickedMarkerLabel;
    /**
     * Picked marker icon.
     */
    private ImageIcon pickedIcon;
    /**
     * Back image icon.
     */
    private ImageIcon backIcon;
    /**
     * Title Label.
     */
    private JLabel titleLabel;

    /**
     * Action marker constructor.
     */
    public ActionMarkerPanel(){
        super();

        initBackIcon();
        initPickedIcon();
        initMarkerDeckLabel();
        initPickedMarkerLabel();
        initTitleLabel();

        updatePickedMarkerImage("ActionMarkerProductionYellow");



        this.setLayout(null);
        this.setBackground(new Color(232,228,212));
        this.setBounds(panelX,panelY,panelWidth,panelHeight);
        this.setBorder(BorderFactory.createBevelBorder(0));
    }


    /**
     * Title label initialising method.
     */
    private void initTitleLabel() {
        this.titleLabel = new JLabel();
        titleLabel.setBounds(0,0,panelWidth,30);
        titleLabel.setText("Lorenzo the Magnificient action:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);
    }

    /**
     * Back initialising method.
     */
    public void initBackIcon(){

        this.backIcon = new ImageIcon();
        this.backIcon.setImage((Paths.getImageFromPath("src/main/resources/resources/punchboard/retro cerchi.png")).getScaledInstance(markerDimension,markerDimension,0));

    }


    /**
     * Picked action marker image initialising.
     */
    public void initPickedIcon(){
        this.pickedIcon = new ImageIcon();

    }

    /**
     * This method update the picked marker image.
     * @param actionMarker
     */
    public void updatePickedMarkerImage(String actionMarker){
        this.pickedIcon.setImage((Paths.getImageFromActionMarker(actionMarker).getScaledInstance(markerDimension,markerDimension,0)));

    }

    public void removeActionMarketDeck(){
        this.backIcon.setImage((Paths.getImageFromPath("src/main/resources/resources/punchboard/EmptyMarker.png").getScaledInstance(markerDimension,markerDimension,0)));
    }

    /**
     * Marker deck label initialising.
     */
    public void initMarkerDeckLabel(){

        this.markerDeckLabel = new JLabel();
        markerDeckLabel.setSize(markerDimension,markerDimension);
        markerDeckLabel.setBounds(markerDeckLabelX,markerDeckLabelY,markerDimension,markerDimension);
        markerDeckLabel.setIcon(this.backIcon);

        this.add(markerDeckLabel);

    }

    /**
     * Picked action marker label initialising
     */
    public void initPickedMarkerLabel(){

        this.pickedMarkerLabel = new JLabel();
        pickedMarkerLabel.setSize(markerDimension,markerDimension);
        pickedMarkerLabel.setBounds(pickedMarkerLabelX,pickedMarkerLabelY,markerDimension,markerDimension);
        pickedMarkerLabel.setIcon(this.pickedIcon);

        this.add(pickedMarkerLabel);

    }



}
