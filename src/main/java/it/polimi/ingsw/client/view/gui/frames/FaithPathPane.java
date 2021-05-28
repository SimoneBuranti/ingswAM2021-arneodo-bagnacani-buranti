package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.gameBoard.FaithPath;

import javax.swing.*;
import java.awt.*;

public class FaithPathPane extends JPanel {

    private static final int crossDimension = 35;
    private static final int papalCardDimension = 60;
    private static final int[] trackX = {32,72,109,109,109,149,187,227,266,305,305,305,345,383,424,463,501,501,501,540,579,619,658,696,736};
    private static final int[] trackY = {113,113,113,74,35,35,35,35,35,35,74,113,113,113,113,113,113,74,35,35,35,35,35,35,35};
    private static final int[] papalX = {195,392,627};
    private static final int[] papalY = {84,41,84};


    private String crossPath = "src/main/resources/resources/punchboard/croce.png";
    private ImageIcon crossIcon;
    private JLabel crossLabel;
    private JLabel papalCards[];

    private int indicator;
    private int currCall;

    public FaithPathPane(){

        initCrossLabel();

        initPapalCards();

        this.setLayout(null);
    }


    public void initCrossLabel(){
        this.indicator = 0;

        crossLabel = new JLabel();
        crossIcon = new ImageIcon((Paths.getImageFromPath(crossPath)).getScaledInstance(crossDimension,crossDimension,0));
        crossLabel.setIcon(crossIcon);
        crossLabel.setSize(crossDimension,crossDimension);
        crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);

        this.add(crossLabel);
    }

    public void initPapalCards(){
        this.currCall = 0;
        papalCards = new JLabel[3];

        ImageIcon papalIcon;

        for (int i = 0;i<3;i++){
            papalCards[i] = new JLabel();
            papalIcon = new ImageIcon((Paths.getPapalCardImageFromCurrCall(i)).getScaledInstance(papalCardDimension,papalCardDimension,0));
            papalCards[i].setIcon(papalIcon);
            papalCards[i].setBounds(papalX[i], papalY[i], papalCardDimension,papalCardDimension);

        }

    }



    public void updateIndicator(int indicator){
        crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
    }

    public void move(){
        if (indicator < 24)
            indicator++;
        else
            indicator = 0;
        crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
    }


    public void givePapalCard(int currCall) {
        this.add(papalCards[currCall]);
    }

    public void addPapal() {
        this.add(papalCards[currCall]);

        if(currCall == 2)
            currCall =0;
        else
            currCall++;
    }

}
