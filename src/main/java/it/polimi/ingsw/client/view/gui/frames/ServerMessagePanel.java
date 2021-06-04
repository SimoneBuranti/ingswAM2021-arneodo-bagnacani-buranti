package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Paths;

import javax.swing.*;
import java.awt.*;

public class ServerMessagePanel extends JPanel {

    private final static int n = 8;
    private final static int messageWidth = 380;
    private final static int messageHeight = 275;


    private Image backgroundImage;
    private JLabel[] textLabels;
    private JPanel lineBox;

    public ServerMessagePanel(){
        super();
        this.lineBox = new JPanel();
        this.lineBox.setBounds(45,35,280,200);
        this.lineBox.setSize(280,200);
        this.lineBox.setLayout(new GridLayout(n, 1, 0,0));
        this.add(lineBox);
        this.lineBox.setBackground(new Color(232,228,212));

        this.backgroundImage = (Paths.getImageFromPath("src/main/resources/resources/board/pergamena.png")).getScaledInstance(messageWidth,messageHeight,0);
        //this.setBounds(800,70,messageWidth,messageHeight);
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

    public void display(String message){
        int i,cont;
        String line ="";
        boolean end = false;

        for(i = 0,cont = 0;i<n && cont<message.length();i++,cont++){
            for (int k =0;k<40 && cont<message.length();k++){
                line = line + message.charAt(cont);
                cont++;
            }
            cont--;
            this.textLabels[i].setText(line);
            line = "";
        }
        line = "";
        for(;i<n;i++){
            this.textLabels[i].setText(line);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

    }
}
