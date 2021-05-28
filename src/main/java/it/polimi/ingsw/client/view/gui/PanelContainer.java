package it.polimi.ingsw.client.view.gui;


import javax.swing.*;
import java.awt.*;

/**
 * A transparent panel
 */
public class PanelContainer extends JPanel {

    /**
     * Constructor: build a transparent panel
     */
    public PanelContainer() {
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        setLayout(null);
    }

    /**
     * Paint the component
     *
     * @param g The graphics
     */
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        Rectangle r = g.getClipBounds();
        g.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(g);
    }

}
