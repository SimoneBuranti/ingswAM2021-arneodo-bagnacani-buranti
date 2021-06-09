package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.listeners.ActivateProductionListener;
import it.polimi.ingsw.client.view.gui.listeners.PutCardButtonListener;
import it.polimi.ingsw.messages.EndOfProductionMessage;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.ProductionOnMessage;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.gameBoard.Strongbox;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Map;

public class GameboardPanel extends JPanel implements ActionListener, MouseListener {

    /**
     * Graphic parameters.
     */
    protected static final int gameboardWidth = 800;
    protected static final int gameboardHeight = 572;
    protected static final int faithPathWidth = 800;
    protected static final int faithPathHeight = 172;
    protected static final int cardWidth = 140;
    protected static final int cardHeight = 212;
    protected static final int cardOffset = 38;
    protected static final int psWidth = 144;
    protected static final int psHeight = 300;
    protected static final int[] psx = {306,460,618};
    protected final static int psy =226;

    /**
     * Gui reference.
     */
    protected Gui gui;

    /**
     * Background image of gameboard.
     */
    protected Image backgroundImage;

    protected int chosenDeckNumber;
    protected JLayeredPane[] productionSpaces;
    protected BaseProductionPanel baseProductionPanel;
    protected JLabel[][] productionCards;
    protected ProductionButton[] productionButtons;
    protected JButton endOfproductionButton;
    protected FaithPathPane faithPathPane;
    protected StoragePanel storagePanel;
    protected StrongBoxPanel strongboxPanel;
    protected JButton endTurnButton;

    public GameboardPanel(Gui gui){

        this.gui = gui;

        initGameboardPanel();

        initProductionSpaces();

        initBaseProductionSpace();

        initButtons();

        initFaithPathPane();

        initStorage();

        initStrongBox();

        this.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.DARK_GRAY));


    }


    public void setChosenDeckNumber(int n){
        this.chosenDeckNumber = n;
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

        if (productionSpaces != null){
            for(int i = 0;i<3;i++){
                if (productionSpaces[i] != null)
                    this.remove(productionSpaces[i]);
            }
        }

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
        this.endTurnButton = new JButton();
        endTurnButton.setText("End turn");
        endTurnButton.setEnabled(false);
        endTurnButton.setBounds(5,5,90,80);
        endTurnButton.addActionListener(e -> {
            endTurnButton.setEnabled(false);
            (new Thread(() -> {
                try {
                    gui.notifyObserver(new EndOfTurnMessage());
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            })).start();
        });
        endTurnButton.setBackground(new Color(199,0,0));
        this.add(endTurnButton);

        this.endOfproductionButton = new JButton();
        endOfproductionButton.setText("End Production");
        endOfproductionButton.setEnabled(false);
        endOfproductionButton.setBounds(618,160,143,20);
        endOfproductionButton.setBackground(new Color(199,0,0));
        endOfproductionButton.addActionListener(e -> {
                    endOfproductionButton.setEnabled(false);
                    gui.actionDoneMode();
            (new Thread(() -> {
                try {
                    gui.notifyObserver(new EndOfProductionMessage());
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            })).start();
        });
        this.productionButtons = new ProductionButton[3];
        this.add(endOfproductionButton);
        for (int i = 0; i<3 ; i++){
            productionButtons[i] = new ProductionButton();
            productionButtons[i].setOpaque(true);
            productionButtons[i].setBounds(326+i*157,535,100,30);
            productionButtons[i].setSize(108,20);
            productionButtons[i].setEnabled(false);
            int finalI = i;
            productionButtons[i].setText("Activate");
            //productionButtons[i].getA();
            productionButtons[i].addActionListener(new ActivateProductionListener(gui,productionButtons[i],i));

            this.add(productionButtons[i]);
        }
    }


    public void addProductionCard(int key,int column){

        CardLabel cardLabel = new CardLabel(key);

        for(int i = 0 ; i<3; i++){
            if (productionCards[i][column] == null){

                productionCards[i][column] = cardLabel;

                cardLabel.setOpaque(false);
                cardLabel.setBounds(2,12+(2-i)*(cardOffset),cardWidth,cardHeight);
                switch(i){
                    case 0: {
                        productionSpaces[column].add(cardLabel,JLayeredPane.DEFAULT_LAYER);
                        break;
                    }
                    case 1:{
                        productionSpaces[column].add(cardLabel,JLayeredPane.PALETTE_LAYER);
                        break;
                    }
                    case 2:{
                        productionSpaces[column].add(cardLabel,JLayeredPane.MODAL_LAYER);
                        break;
                    }
                }
                i = 3;
            }
        }

        productionSpaces[column].repaint();
        productionSpaces[column].repaint();

    }


    private void initStorage() {
        this.storagePanel = new StoragePanel();

        this.add(storagePanel);
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

        this.add(faithPathPane);
    }

    public void initBaseProductionSpace(){
        this.baseProductionPanel = new BaseProductionPanel(gui);

        this.add(baseProductionPanel);
    }


    public void updateStorage(Map<Resource,Integer> newStorage){
        this.storagePanel.updateStorage(newStorage);

    }

    public void updateLorenzoIndicator(int indicator){

    }

    public void lorenzoMove(){

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
        //System.out.println("You pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("You released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("You entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("You exited");
    }
    public void updateProductionSpaces(GameboardListNotification gameboardListNotification){
        initProductionSpaces();

        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                if (gameboardListNotification.getListOfFirstCard()[i][j] != null)
                    addProductionCard(gameboardListNotification.getListOfFirstCard()[i][j].getKey(),j);
            }

    }

    public void givePapalcard(int i) {
        faithPathPane.givePapalCard(i);
    }

    public void removePapalCard(int i) {
        faithPathPane.removePapalCard(i);
    }

    public void disableProductionButtons(){
        for(int i = 0; i < 3; i++){
            Gui.removeAllListeners(productionButtons[i]);
            productionButtons[i].addActionListener(new ActivateProductionListener(gui,productionButtons[i],i));
            productionButtons[i].setEnabled(false);
        }

        baseProductionPanel.disableButton();
    }

    public void enableProductionButtons(){
        for(int i = 0; i < 3; i++){
            productionButtons[i].setText("Activate");
            if (gui.getViewController().getGame().getGameBoardOfPlayer().getProductionCard(i) != null){
                productionButtons[i].setEnabled(true);
            } else {
                productionButtons[i].setEnabled(false);
            }
            productionButtons[i].setToken(true);
            Gui.removeAllListeners(productionButtons[i]);
            productionButtons[i].addActionListener(new ActivateProductionListener(gui,productionButtons[i], i));
        }

        baseProductionPanel.enableButton();
    }


    public void enableEndTurnButton(){
        this.endTurnButton.setEnabled(true);
    }

    public void enableEndOfProductionButton(){
        this.endOfproductionButton.setEnabled(true);
    }

    public void disableEndTurnButton(){

        this.endTurnButton.setEnabled(false);
    }

    public void disableEndOfProductionButton(){
        this.endOfproductionButton.setEnabled(false);
    }

    public void putCardMode(){
        for(int i = 0; i<3 ; i++){
            productionButtons[i].setText("Put here");
            ProductionCard card = gui.getViewController().getGame().getGameBoardOfPlayer().getProductionCard(i);
            if (card != null && card.getLevel() == 3){
                setEnabled(false);
            } else {
                productionButtons[i].setEnabled(true);
            }
            Gui.removeAllListeners(productionButtons[i]);
            productionButtons[i].addActionListener(new PutCardButtonListener(gui,chosenDeckNumber,i));
        }
        baseProductionPanel.disableButton();
    }

    /*public void showAllOfPlayer(ShowAllOfPlayerMessage msg) {
        new PlayerInformatioFrames(msg);
    }*/

    public void enableBaseProductionButton() {
        baseProductionPanel.enableButton();
    }

    public int howManyActivated() {
        int cont = 0;
        if(!baseProductionPanel.getProductionButton().isToken())
            cont++;
        for(int i = 0 ; i<3;i++){
            if (!productionButtons[i].isToken())
                cont++;
        }
        return cont;
    }

    public void updateStrongBox(Map<Resource, Integer> map) {
        this.strongboxPanel.updateStrongBox(map);
    }
}
