package it.polimi.ingsw.client.view.gui;

import javax.swing.*;
import java.awt.*;

/**
 * A transparent button with an image
 */
public class SensibleButton extends JButton {

    /**
     * Constructor: build a transparent button with an image
     *
     * @param image The image of the button
     */
    public SensibleButton(Image image) {
        super(new ImageIcon(image));
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }


}