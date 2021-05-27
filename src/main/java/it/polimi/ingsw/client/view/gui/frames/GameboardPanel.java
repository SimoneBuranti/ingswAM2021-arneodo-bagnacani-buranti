package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameboardPanel extends JPanel implements ActionListener, MouseListener {

    private static final int gameboardWidth = 800;
    private static final int gameboardHeight = 572;
    private static final int cardWidth = 140;
    private static final int cardHeight = 212;
    private static final int cardOffset = 38;
    private static final int psWidth = 144;
    private static final int psHeight = 300;
    private static final int[] psx = {306,460,618};
    private final static int psy =226;


    private Image backgroundImage;

    private JLayeredPane[] productionSpaces;
    private JLabel[][] productionCards;

    public GameboardPanel(){

        initGameboardPanel();

        initProductionSpaces();


    }

    public void initGameboardPanel(){
        Image image = Toolkit.getDefaultToolkit().createImage("src/main/resources/resources/board/Masters of Renaissance_PlayerBoard (11_2020)-1.png");
        this.backgroundImage = image.getScaledInstance(gameboardWidth,gameboardHeight,0);

        this.setSize(gameboardWidth,gameboardHeight);
        this.setBounds(0,0,gameboardWidth,gameboardHeight);
        this.setLayout(null);
        this.addMouseListener(this);
        this.setVisible(true);
    }

    public void initProductionSpaces(){

        productionSpaces = new JLayeredPane[3];
        productionCards = new JLabel[3][3];
        for(int i = 0;i<3;i++){
            productionSpaces[i] = new JLayeredPane();

            productionSpaces[i].setSize(psWidth,psHeight);
            productionSpaces[i].setBounds(psx[i],psy,psWidth,psHeight);

            productionSpaces[i].setBackground(Color.WHITE);
            productionSpaces[i].setOpaque(true);
            add(productionSpaces[i]);

        }

    }


    public void addProductionCard(int key,int column){




    }


















    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX()+" "+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
