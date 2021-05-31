package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.ProductionOnMessage;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

public class PlayerInformatioFrames extends JPanel {
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


    protected ViewController viewController;


    protected JLayeredPane[] productionSpaces;
    protected BaseProductionPanel baseProductionPanel;
    protected JLabel[][] productionCards;
    protected JButton[] productionButtons;
    protected FaithPathPane faithPathPane;
    protected StoragePanel storagePanel;
    protected StrongBoxPanel strongboxPanel;

    protected LeaderCardsPanel leaderCardsPanel;


    protected Image backgroundImage;


    public PlayerInformatioFrames(ViewController viewController, ShowAllOfPlayerMessage msg){

        this.viewController = viewController;

        initGameboardPanel();

        initProductionSpaces();

        initBaseProductionSpace();

        initFaithPathPane();

        initStorage();

        initStrongBox();

        this.leaderCardsPanel=new LeaderCardsPanel();

        this.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.DARK_GRAY));

        updateStorage(msg.getStorage());

        updateStrongBox(msg.getStrongBox());

        updateIndicator(msg.getFaithIndicator());

        updateProductionSpaces(msg.getProductioncard());

        addLeaderCardsAsInt(msg.getListLeaderActivated());

        addToStorageExtraPlayerOpponent(msg.getResource1(),msg.getResource2(),msg.getHowMany1(),msg.getHowMany2());

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
        this.baseProductionPanel = new BaseProductionPanel();
        this.add(baseProductionPanel);
    }


    public void updateStorage(Map<Resource,Integer> newStorage){
        this.storagePanel.updateStorage(newStorage);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
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
