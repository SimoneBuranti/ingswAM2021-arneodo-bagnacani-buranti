package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.ProductionOnMessage;
import it.polimi.ingsw.server.model.gameBoard.Strongbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameboardPanel extends JPanel implements ActionListener, MouseListener {

    private static final int gameboardWidth = 800;
    private static final int gameboardHeight = 572;
    private static final int faithPathWidth = 800;
    private static final int faithPathHeight = 172;
    private static final int cardWidth = 140;
    private static final int cardHeight = 212;
    private static final int cardOffset = 38;
    private static final int psWidth = 144;
    private static final int psHeight = 300;
    private static final int[] psx = {306,460,618};
    private final static int psy =226;


    private ViewController viewController;


    private Image backgroundImage;

    private JLayeredPane[] productionSpaces;
    private BaseProductionPanel baseProductionPanel;
    private JLabel[][] productionCards;
    private JButton[] productionButtons;
    private FaithPathPane faithPathPane;
    private StrongBoxPanel strongboxPanel;


    public GameboardPanel(){

        this.viewController = viewController;

        initGameboardPanel();

        initProductionSpaces();

        initBaseProductionSpace();

        initButtons();

        initFaithPathPane();

        initStorage();

        initStrongBox();


        addProductionCard(1,0);
        addProductionCard(8,0);
        addProductionCard(12,0);

        addProductionCard(13,1);
        addProductionCard(20,1);

        addProductionCard(26,2);
    }



    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
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

            //productionSpaces[i].setBackground(Color.WHITE);
            productionSpaces[i].setOpaque(false);
            add(productionSpaces[i]);

        }

    }


    public void initButtons() {
        this.productionButtons = new JButton[3];

        for (int i = 0; i<3 ; i++){

            productionButtons[i] = new JButton();
            productionButtons[i].setOpaque(true);
            productionButtons[i].setBounds(326+i*157,535,100,30);
            productionButtons[i].setSize(108,20);
            productionButtons[i].setEnabled(false);
            int finalI = i;
            productionButtons[i].addActionListener(e -> {
                productionButtons[finalI].setEnabled(false);
                viewController.sendMessage(new ProductionOnMessage(finalI));
            });

            this.add(productionButtons[i]);
        }
    }


    public void addProductionCard(int key,int column){

        CardLabel cardLabel = new CardLabel(key);

        for(int i = 0 ; i<3; i++){
            if (productionCards[i][column] == null){

                if (i == 0)
                    productionButtons[column].setEnabled(true);

                productionCards[i][column] = cardLabel;

                cardLabel.setOpaque(true);
                cardLabel.setBounds(2,12+(2-i)*(cardOffset),cardWidth,cardHeight);
                productionSpaces[column].add(cardLabel,Integer.valueOf(i));

                i = 3;
            }
        }
    }


    private void initStorage() {

    }

    private void initStrongBox() {
        this.strongboxPanel = new StrongBoxPanel();
        this.add(strongboxPanel);
    }

    private void initFaithPathPane() {
        this.faithPathPane = new FaithPathPane();
        faithPathPane.setOpaque(false);
        faithPathPane.setSize(faithPathWidth,faithPathHeight);
        faithPathPane.setBounds(0,0,faithPathWidth,faithPathHeight);

        //move button--------
        JButton moveButton = new JButton();
        moveButton.setSize(20,20);
        moveButton.addActionListener(e -> {
            faithPathPane.move();
        });
        moveButton.setBounds(20,20,20,20);
        faithPathPane.add(moveButton);

        //addPapal button--------
        JButton papalButton = new JButton();
        papalButton.setSize(20,20);
        papalButton.addActionListener(e -> {
            this.faithPathPane.addPapal();
            this.repaint();
        });
        papalButton.setBounds(20,50,20,20);
        faithPathPane.add(papalButton);

        this.add(faithPathPane);
    }

    public void initBaseProductionSpace(){
        this.baseProductionPanel = new BaseProductionPanel();

        this.add(baseProductionPanel);
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
