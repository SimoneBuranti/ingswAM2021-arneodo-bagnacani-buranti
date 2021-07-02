package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.gameBoard.FaithPath;

import javax.swing.*;
import java.awt.*;

public class FaithPathPane extends JPanel {

    /**
     * Graphic parameters.
     */
    private static final int crossDimension = 35;
    private static final int papalCardDimension = 60;
    private static final int[] trackX = {32,72,109,109,109,149,187,227,266,305,305,305,345,383,424,463,501,501,501,540,579,619,658,696,736};
    private static final int[] trackY = {113,113,113,74,35,35,35,35,35,35,74,113,113,113,113,113,113,74,35,35,35,35,35,35,35};
    private static final int[] papalX = {195,392,627};
    private static final int[] papalY = {84,41,84};


    /**
     * Indicator image path.
     */
    private String crossPath = "/punchboard/croci-03.png";
    /**
     * Cross image attribute.
     */
    private ImageIcon crossIcon;
    /**
     * Cross Label attribute.
     */
    private JLabel crossLabel;
    /**
     * Papal card array.
     */
    private JLabel papalCards[];

    private int indicator;
    private int currCall;

    /**
     * FaithPathPane constructor.
     */
    public FaithPathPane(){

        initCrossLabel();

        initPapalCards();

        this.setLayout(null);
    }

    /**
     * This method sets all the initial cross label features.
     */
    public void initCrossLabel(){
        this.indicator = 0;

        crossLabel = new JLabel();
        crossIcon = new ImageIcon((Paths.getImageFromPath(crossPath)).getScaledInstance(crossDimension,crossDimension,0));
        crossLabel.setIcon(crossIcon);
        crossLabel.setSize(crossDimension,crossDimension);
        crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);

        this.add(crossLabel);
    }

    /**
     * This method sets all the initial papal card features.
     */
    public void initPapalCards(){
        this.currCall = 0;
        papalCards = new JLabel[3];

        ImageIcon papalIcon;

        for (int i = 0;i<3;i++){
            papalCards[i] = new JLabel();
            papalIcon = new ImageIcon((Paths.getPapalCardBackImageFromCurrCall(i)).getScaledInstance(papalCardDimension,papalCardDimension,0));
            papalCards[i].setIcon(papalIcon);
            papalCards[i].setBounds(papalX[i], papalY[i], papalCardDimension,papalCardDimension);
            this.add(papalCards[i]);
        }

    }


    /**
     * This method updates the faith path indicator position.
     * @param indicator
     */
    public void updateIndicator(int indicator){
        if(indicator < 25 && indicator >-1)
            crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
        else
            crossLabel.setBounds(trackX[24],trackY[24],crossDimension,crossDimension);
    }

    /**
     * This method moves the faith indicator by one position at a time.
     */
    public void move(){
        if (indicator < 24)
            indicator++;
        else
            indicator = 0;
        crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
    }

    /**
     * This method adds the current papal card image to the player's path.
     * @param currCall
     */
    public void givePapalCard(int currCall) {
        this.remove(papalCards[currCall]);
        papalCards[currCall] = new JLabel();
        ImageIcon papalIcon = new ImageIcon((Paths.getPapalCardFrontImageFromCurrCall(currCall)).getScaledInstance(papalCardDimension,papalCardDimension,0));
        papalCards[currCall].setIcon(papalIcon);
        papalCards[currCall].setBounds(papalX[currCall], papalY[currCall], papalCardDimension,papalCardDimension);
        this.add(papalCards[currCall]);
    }

    /**
     * This method removes the current papal card image from the faith path.
     * @param currCall
     */
    public void removePapalCard(int currCall){
        this.remove(papalCards[currCall]);
    }


}
