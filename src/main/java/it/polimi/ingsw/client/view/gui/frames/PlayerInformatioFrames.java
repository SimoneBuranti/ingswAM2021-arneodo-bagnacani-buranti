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

public class PlayerInformatioFrames extends JFrame {
    protected final static int frameWidth= 1190;
    protected final static int frameHeight = 600;
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

    private PBackground mainPanel;

    protected JLayeredPane[] productionSpaces;
    protected JLabel[][] productionCards;
    protected FaithPathPane faithPathPane;
    protected StoragePanel storagePanel;
    protected StrongBoxPanel strongboxPanel;

    protected LeaderCardsPanel leaderCardsPanel;
    private String nickName;

    protected Image backgroundImage;


    public PlayerInformatioFrames(String nickName){
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

        this.setTitle(this.nickName + "'s Gameboard");

        initGameboardPanel();

        initProductionSpaces();


        initFaithPathPane();

        initStorage();

        initStrongBox();


        this.add(mainPanel);

    }

    public void showOpponent(ShowAllOfPlayerMessage msg){
        updateStorage(msg.getStorage());

        updateStrongBox(msg.getStrongBox());

        updateIndicator(msg.getFaithIndicator());

        updateProductionSpaces(msg.getProductioncard());

        addLeaderCardsAsInt(msg.getListLeaderActivated());

        addToStorageExtraPlayerOpponent(msg.getResource1(),msg.getResource2(),msg.getHowMany1(),msg.getHowMany2());

        visibilityOn();
    }

    public String getNickName(){
        return this.nickName;
    }

    public void visibilityOff(){
        this.setVisible(false);
    }

    public void visibilityOn(){
        this.setVisible(true);
        this.paintComponents(this.getGraphics());
        this.paintComponents(this.getGraphics());
    }

    public void initGameboardPanel(){
        Image image = Toolkit.getDefaultToolkit().createImage("src/main/resources/resources/board/opponent board.png");
        this.backgroundImage = image.getScaledInstance(gameboardWidth,gameboardHeight,0);

        this.mainPanel.setSize(800,gameboardHeight);
        this.mainPanel.setBounds(0,0,gameboardWidth,gameboardHeight);
        this.mainPanel.setLayout(null);
        this.mainPanel.setVisible(true);
        this.mainPanel.setImage(backgroundImage);
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
            this.mainPanel.add(productionSpaces[i]);

        }

    }




    public void addProductionCard(int key,int column){

        CardLabel cardLabel = new CardLabel(key);

        for(int i = 0 ; i<3; i++){
            if (productionCards[i][column] == null){

                productionCards[i][column] = cardLabel;

                cardLabel.setOpaque(true);
                cardLabel.setBounds(2,12+(2-i)*(cardOffset),cardWidth,cardHeight);
                productionSpaces[column].add(cardLabel,Integer.valueOf(i));

                i = 3;
            }
        }
    }


    private void initStorage() {
        this.storagePanel = new StoragePanel();

        this.mainPanel.add(storagePanel);
    }

    private void initStrongBox() {
        this.strongboxPanel = new StrongBoxPanel();
        this.mainPanel.add(strongboxPanel);
    }

    private void initFaithPathPane() {
        this.faithPathPane = new FaithPathPane();
        faithPathPane.setOpaque(false);
        faithPathPane.setSize(faithPathWidth,faithPathHeight);
        faithPathPane.setBounds(0,0,faithPathWidth,faithPathHeight);
        this.mainPanel.add(faithPathPane);
    }



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

    public void givePapalcard(int i) {
        faithPathPane.givePapalCard(i);

    }

    public void updateProductionSpaces(int[][] prod){
        initProductionSpaces();
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                if (prod[i][j]!=0)
                    addProductionCard(prod[i][j],j);

            } }

    public void updateStrongBox(Map<Resource,Integer> newStorage){
        this.strongboxPanel.updateStrongBox(newStorage);
    }


    public void updateIndicator(int i){
        this.faithPathPane.updateIndicator(i);
    }

    public void addLeaderCardsAsInt(ArrayList<Integer> arrayList){
        leaderCardsPanel.addLeaderCardsAsInt(arrayList,true);
    }

    public void addToStorageExtraPlayerOpponent(Resource resource1,
                                               Resource resource2,
                                               int howMany1,
                                               int howMany2){
        leaderCardsPanel.addToStorageExtraPlayerOpponent(resource1,resource2,howMany1,howMany2);

    }


}
