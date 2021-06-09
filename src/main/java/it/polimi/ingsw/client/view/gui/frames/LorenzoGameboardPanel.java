package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;

/**
 * LorenzoGameboardPanel extends the normal gameboardPanel class and it implements Lorenzo's faith path within the
 * same gameboard space.
 */
public class LorenzoGameboardPanel extends GameboardPanel{

    /**
     * Graphic parameters.
     */
    private static final int crossDimension = 35;
    private static final int[] trackX = {32,72,109,109,109,149,187,227,266,305,305,305,345,383,424,463,501,501,501,540,579,619,658,696,736};
    private static final int[] trackY = {113,113,113,74,35,35,35,35,35,35,74,113,113,113,113,113,113,74,35,35,35,35,35,35,35};

    /**
     * Black cross image path.
     */
    private String blackCrossPath = "src/main/resources/resources/punchboard/croce.png";
    /**
     * Lorenzo's indicator image.
     */
    private ImageIcon blackCrossIcon;
    /**
     * Lorenzo's indicator attribute.
     */
    private JLabel blackCrossLabel;

    /**
     * Lorenzo faith indicator value.
     */
    private int indicator;

    /**
     * Class constructor.
     * @param gui
     */
    public LorenzoGameboardPanel(Gui gui){
        super(gui);

        initBlackCrossLabel();

    }

    /**
     * This method sets the initial lorenzo's faith path features.
     */
    public void initBlackCrossLabel(){
        this.indicator = 0;

        blackCrossLabel = new JLabel();
        blackCrossIcon = new ImageIcon((Paths.getImageFromPath(blackCrossPath)).getScaledInstance(crossDimension,crossDimension,0));
        blackCrossLabel.setIcon(blackCrossIcon);
        blackCrossLabel.setSize(crossDimension,crossDimension);
        blackCrossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);

        this.add(blackCrossLabel);
    }

    /**
     * This method moves Lorenzo's indicator to the given position.
     * @param indicator
     */
    public void updateLorenzoIndicator(int indicator){
        if(indicator < 25 && indicator >-1)
            blackCrossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
        else
            blackCrossLabel.setBounds(trackX[24],trackY[24],crossDimension,crossDimension);
    }


    /**
     * This method moves Lorenzo's indicator one position at a time.
     */
    public void lorenzoMove(){
        if (indicator < 24)
            indicator++;
        else
            indicator = 0;
        blackCrossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
    }

}
