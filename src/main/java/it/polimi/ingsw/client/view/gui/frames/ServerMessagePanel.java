package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

/**
 * ServerMessagePanel main aim is to show every kind of server textual message in order to give information to the player.
 */
public class ServerMessagePanel extends JPanel {

    /**
     * Graphic parameters.
     */
    private final static int n = 8;
    private final static int messageWidth = 380;
    private final static int messageHeight = 275;

    /**
     * ServerMessagePanel background image.
     */
    private Image backgroundImage;
    /**
     * Text label array.
     */
    private JLabel[] textLabels;
    /**
     * Text label container.
     */
    private JPanel lineBox;

    /**
     * Class constructor.
     */
    public ServerMessagePanel(){
        super();
        this.lineBox = new JPanel();
        this.lineBox.setBounds(45,35,280,200);
        this.lineBox.setSize(280,200);
        this.lineBox.setLayout(new GridLayout(n, 1, 0,0));
        this.add(lineBox);
        this.lineBox.setBackground(new Color(232,228,212));

        this.backgroundImage = (Paths.getImageFromPath("src/main/resources/resources/board/pergamena.png")).getScaledInstance(messageWidth,messageHeight,0);

        this.setLayout(null);

        this.textLabels = new JLabel[n];

        for(int i = 0;i<n;i++){
            this.textLabels[i] = new JLabel();
            this.textLabels[i].setSize(280,25);
            this.textLabels[i].setBackground(new Color(232,228,212));
            this.lineBox.add(this.textLabels[i]);
            this.textLabels[i].setOpaque(true);
        }
    }

    /**
     * Given a message as a parameter this method shows its text.
     * @param message
     */
    public void display(String message){
        int i,cont;
        String line;
        int offset;

        if ( message.length() % 40 == 0)
            offset = message.length() / 40;
        else
            offset = (message.length() / 40) +1;

        for (i = n-1; i>=offset;i--){
            line = this.textLabels[i].getText();
            this.textLabels[i].setText(this.textLabels[i-offset].getText());
            this.textLabels[i-offset].setText(line);
        }

        line = "";
        for(i = 0,cont = 0;i<n && cont<message.length();i++,cont++){
            for (int k =0;k<40 && cont<message.length();k++){
                line = line + message.charAt(cont);
                cont++;
            }
            cont--;
            this.textLabels[i].setText(line);
            line = "";
        }
        /*line = "";
        for(;i<n;i++){
            this.textLabels[i].setText(line);
        }*/

    }

    /**
     * This method clean up each text label. Usually called before a new message or after the endTurn message.
     */
    public void refreshMessagePanel(){
        for(int i = 0;i<n ;i++){
            this.textLabels[i].setText("");
        }
    }

    /**
     * Override of the paintComponent method to paint a background image.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

    }
}
