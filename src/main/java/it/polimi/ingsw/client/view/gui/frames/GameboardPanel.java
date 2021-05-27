package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;
import java.awt.*;

public class GameboardPanel extends JPanel {

    private Image backgroundImage;






    public GameboardPanel(){

        backgroundImage = Toolkit.getDefaultToolkit().createImage("resources/board/Masters of Renaissance_PlayerBoard (11_2020)-1.png");



        this.setOpaque(true);
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setOpaque(false);
        g.drawImage(backgroundImage, 0, 0, null);
        super.paintComponent(g);
    }

}
