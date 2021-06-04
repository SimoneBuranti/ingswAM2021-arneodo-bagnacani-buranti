package it.polimi.ingsw.client.view.gui;

import javax.swing.*;
import java.awt.*;

/**
 * A customized panel with a background image
 */
public class PBackground extends JPanel {
    Image image;

    /**
     * Constructor: build a customized panel with a background image
     *
     * @param image The background image
     */
    public PBackground(Image image) {
        this.image = image;
        setBackground(new Color(0,0,0,0));
    }

    public PBackground() {
        setOpaque(false);
    }

    public void setImage(Image background){
        this.image = background;
    }
    /**
     * Paint the component
     *
     * @param g The graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}