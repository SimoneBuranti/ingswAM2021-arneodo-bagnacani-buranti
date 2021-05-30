package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;

public class LorenzoGameboardPanel extends GameboardPanel{

    private static final int crossDimension = 35;
    private static final int[] trackX = {32,72,109,109,109,149,187,227,266,305,305,305,345,383,424,463,501,501,501,540,579,619,658,696,736};
    private static final int[] trackY = {113,113,113,74,35,35,35,35,35,35,74,113,113,113,113,113,113,74,35,35,35,35,35,35,35};

    private String blackCrossPath = "src/main/resources/resources/punchboard/croce.png";
    private ImageIcon blackCrossIcon;
    private JLabel blackCrossLabel;

    private int indicator;

    public LorenzoGameboardPanel(){
        super();

        initBlackCrossLabel();

        //move button Lorenzo--------
        JButton lorenzoButton = new JButton();
        lorenzoButton.setSize(20,20);
        lorenzoButton.addActionListener(e -> {
            this.lorenzoMove();
        });
        lorenzoButton.setBounds(20,0,20,20);
        faithPathPane.add(lorenzoButton);

    }


    public void initBlackCrossLabel(){
        this.indicator = 0;

        blackCrossLabel = new JLabel();
        blackCrossIcon = new ImageIcon((Paths.getImageFromPath(blackCrossPath)).getScaledInstance(crossDimension,crossDimension,0));
        blackCrossLabel.setIcon(blackCrossIcon);
        blackCrossLabel.setSize(crossDimension,crossDimension);
        blackCrossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);

        this.add(blackCrossLabel);
    }

    public void updateLorenzoIndicator(int indicator){
        blackCrossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
    }


    public void lorenzoMove(){
        if (indicator < 24)
            indicator++;
        else
            indicator = 0;
        blackCrossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);
    }


}
