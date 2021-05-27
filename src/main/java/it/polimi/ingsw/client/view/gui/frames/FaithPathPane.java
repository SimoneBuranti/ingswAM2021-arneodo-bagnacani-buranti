package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.server.model.gameBoard.FaithPath;

import javax.swing.*;
import java.awt.*;

public class FaithPathPane extends JPanel {

    private static final int crossDimension = 35;
    private static final int[] trackX = {32,72,109,109,109,149,187,227,266,305,305,305,345,383,424,463,501,501,501,540,579,619,658,696,736};
    private static final int[] trackY = {113,113,113,74,35,35,35,35,35,35,74,113,113,113,113,113,113,74,35,35,35,35,35,35,35};

    private String crossPath = "src/main/resources/resources/punchboard/croce.png";
    private Image crossImage;
    private JLabel crossLabel;

    private int indicator;

    public FaithPathPane(){
        this.indicator = 0;

        crossImage = Paths.getImageFromPath(crossPath).getScaledInstance(crossDimension,crossDimension,0);
        ImageIcon crossImageIcon = new ImageIcon(crossImage);
        crossLabel = new JLabel();
        crossLabel.setIcon(crossImageIcon);
        crossLabel.setOpaque(true);
        crossLabel.setBackground(Color.RED);
        crossLabel.setSize(crossDimension,crossDimension);
        crossLabel.setBounds(trackX[indicator],trackY[indicator],crossDimension,crossDimension);


        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.add(crossLabel);

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

}
