package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.ProductionOnMessage;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

/**
 * PlayerInformationFrames class represents the opponents' gameboard frame. This is displayed whenever
 * the player press the corresponding menu item.
 */
public class PlayerInformationFrames extends JFrame {

    /**
     * Graphic parameters.
     */
    protected final static int frameWidth= 1190;
    protected final static int frameHeight = 615;
    protected static final int gameboardWidth = 800;
    protected static final int gameboardHeight = 572;
    protected static final int faithPathWidth = 800;
    protected static final int faithPathHeight = 172;
    public final static int leaderWidth = 370;
    public final static int leaderHeight = 290;
    protected static final int cardWidth = 140;
    protected static final int cardHeight = 212;
    protected static final int cardOffset = 38;
    protected static final int psWidth = 144;
    protected static final int psHeight = 300;
    protected static final int[] psx = {306,460,618};
    protected final static int psy =226;

    /**
     * Main panel with background image.
     */
    private PBackground mainPanel;

    /**
     * Production space array. These spaces contain production card images.
     */
    protected JLayeredPane[] productionSpaces;

    /**
     * Production card matrix. It contains current references to the player cards.
     */
    protected JLabel[][] productionCards;

    /**
     * Opponent's faith path panel
     */
    protected FaithPathPane faithPathPane;

    /**
     * Opponent's storage panel.
     */
    protected StoragePanel storagePanel;

    /**
     * Opponent's strongbox panel.
     */
    protected StrongBoxPanel strongboxPanel;

    /**
     * Opponent's leader card panel.
     */
    protected LeaderCardsPanel leaderCardsPanel;
    /**
     * Opponent's nickname.
     */
    private String nickName;

    /**
     * Background image attribute.
     */
    protected Image backgroundImage;


    /**
     * PlayerInformationFrames constructor.
     * @param nickName
     */
    public PlayerInformationFrames(String nickName){
        super();

        this.nickName = nickName;
        this.mainPanel = new PBackground();
        this.mainPanel.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.DARK_GRAY));
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocation(200,220);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(frameWidth,frameHeight);
        this.leaderCardsPanel=new LeaderCardsPanel();
        this.leaderCardsPanel.setBounds(805, 280, leaderWidth, leaderHeight);
        //leaderCardsPanel.setBackground(Color.BLUE);
        //leaderCardsPanel.setOpaque(true);
        this.add(leaderCardsPanel);

        this.setTitle(this.nickName + "'s Gameboard");

        initGameboardPanel();

        initProductionSpaces();


        initFaithPathPane();

        initStorage();

        initStrongBox();


        this.add(mainPanel);

    }

    /**
     * When this method is called it shows every updated opponent's gameboard features.
     * @param msg
     */
    public void showOpponent(ShowAllOfPlayerMessage msg){
        updateStorage(msg.getStorage());

        updateStrongBox(msg.getStrongBox());

        updateIndicator(msg.getFaithIndicator());

        updateProductionSpaces(msg.getProductioncard());

        addLeaderCardsAsInt(msg.getListLeaderActivated());

        addToStorageExtraPlayerOpponent(msg.getResource1(),msg.getResource2(),msg.getHowMany1(),msg.getHowMany2());

        for(int i = 0; i < 3; i++){
            if(msg.getPapalCards()[i] == 1)
                givePapalcard(i);
            else if(msg.getPapalCards()[i] == 0)
                faithPathPane.removePapalCard(i);
        }

        visibilityOn();
    }

    /**
     * Opponent's nickname getter.
     * @return
     */
    public String getNickName(){
        return this.nickName;
    }


    /**
     * This method turns the frame visibility off.
     */
    public void visibilityOff(){
        this.setVisible(false);
    }

    /**
     * This method turns the frame visibility on.
     */
    public void visibilityOn(){
        this.setVisible(true);

        this.paintComponents(this.getGraphics());
        this.repaint();

        this.setVisible(true);
    }

    /**
     * Initial gameboard panel settings.
     */
    public void initGameboardPanel(){
        Image image = Toolkit.getDefaultToolkit().createImage("src/main/resources/resources/board/opponent board.png");
        this.backgroundImage = image.getScaledInstance(gameboardWidth,gameboardHeight,0);

        this.mainPanel.setSize(800,gameboardHeight);
        this.mainPanel.setBounds(0,0,gameboardWidth,gameboardHeight);
        this.mainPanel.setLayout(null);
        this.mainPanel.setVisible(true);
        this.mainPanel.setImage(backgroundImage);
    }

    /**
     * Initialisation of production spaces.
     */
    public void initProductionSpaces(){

        if (productionSpaces != null){
            for(int i = 0;i<3;i++){
                if (productionSpaces[i] != null)
                    this.mainPanel.remove(productionSpaces[i]);
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
            this.mainPanel.add(productionSpaces[i]);

        }

    }


    /**
     * Given the card key and the column, the corresponding image is displayed on the production panel.
     * @param key
     * @param column
     */
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

    /**
     * Initialisation of storage panel.
     */
    private void initStorage() {
        this.storagePanel = new StoragePanel();

        this.mainPanel.add(storagePanel);
    }

    /**
     * Initialisation of strongbox panel.
     */
    private void initStrongBox() {
        this.strongboxPanel = new StrongBoxPanel();
        this.mainPanel.add(strongboxPanel);
    }

    /**
     * Initialisation of faith path panel.
     */
    private void initFaithPathPane() {
        this.faithPathPane = new FaithPathPane();
        faithPathPane.setOpaque(false);
        faithPathPane.setSize(faithPathWidth,faithPathHeight);
        faithPathPane.setBounds(0,0,faithPathWidth,faithPathHeight);
        this.mainPanel.add(faithPathPane);
    }


    /**
     * This method updates the
     * @param newStorage
     */
    public void updateStorage(Map<Resource,Integer> newStorage){
        this.storagePanel.updateStorage(newStorage);
    }



    public void updateProductionSpaces(GameboardListNotification gameboardListNotification){
        initProductionSpaces();
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                if (gameboardListNotification.getListOfFirstCard()[i][j]!=null)
                    addProductionCard(gameboardListNotification.getListOfFirstCard()[i][j].getKey(),j);

            }

    }

    /**
     * When notified this method adds the corresponding papal card to the faith path.
     * @param i
     */
    public void givePapalcard(int i) {
        faithPathPane.givePapalCard(i);

    }

    /**
     * This method updates production card spaces.
     * @param prod
     */
    public void updateProductionSpaces(int[][] prod){
        initProductionSpaces();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if (prod[i][j]!=0)
                    addProductionCard(prod[i][j],j);
            }
        }
    }

    /**
     * The given resources are displayed on the strongbox panel.
     * @param newStorage
     */
    public void updateStrongBox(Map<Resource,Integer> newStorage){
        this.strongboxPanel.updateStrongBox(newStorage);
    }

    /**
     * Update opponent's faith path indicator.
     * @param i
     */
    public void updateIndicator(int i){
        this.faithPathPane.updateIndicator(i);
    }

    /**
     * This method adds leader cards to opponent's information frame.
     * @param arrayList
     */
    public void addLeaderCardsAsInt(ArrayList<Integer> arrayList){
        leaderCardsPanel.addLeaderCardsAsInt(arrayList,true);
    }

    /**
     * When an opponent activates an extra-storage-leader card this added to the frame.
     * @param resource1
     * @param resource2
     * @param howMany1
     * @param howMany2
     */
    public void addToStorageExtraPlayerOpponent(Resource resource1,
                                               Resource resource2,
                                               int howMany1,
                                               int howMany2){
        leaderCardsPanel.addToStorageExtraPlayerOpponent(resource1,resource2,howMany1,howMany2);

    }


}
