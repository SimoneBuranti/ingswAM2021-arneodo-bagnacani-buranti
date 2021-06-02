package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MainFrame  extends JFrame {

    public final static int northHeight = 70;
    public final static int frameWidth = 1195;
    public final static int frameHeigth = 679;
    public final static int frameX = 230;
    public final static int frameY = 160;
    public final static int buttonWidth = 100;
    public final static int buttonHeight = 60;
    public final static int leaderWidth = 370;
    public final static int leaderHeight = 290;
    public final static int letterOffset = 10;

    protected Gui gui;

    protected ServerMessagePanel serverMessagePanel;
    protected LeaderCardsPanel leaderCardsPanel;


    protected ReserveFrame reserveFrame;
    protected MarketFrame marketFrame;
    protected ProductionDeckFrame productionDeckFrame;

    protected JPanel mainPanel;
    protected JPanel navigationBar;
    protected JButton marketButton;
    protected JButton prodCardButton;
    protected JButton reserveButton;

    protected ArrayList<JPanel> attached;
    protected JLabel[] blankLabels;




    public MainFrame(String string,Gui gui){
        super(string);
        this.gui=gui;

     /*   this.attached = new ArrayList<>();
        this.setLocation(frameX, frameY);
        this.setSize(frameWidth, frameHeigth);
        this.setResizable(false);*/

    }


    public MainFrame(Gui gui){
        super();
        this.gui=gui;

        this.setTitle("Master of Renaissance");
        this.attached = new ArrayList<>();
        this.setLocation(frameX, frameY);
        this.setSize(frameWidth, frameHeigth);
        this.setResizable(false);
        this.setVisible(false);

        initGameMode();
    }



    /*public MainFrame(String title) {
        //this.setLocation(frameX,frameY);
        //this.setSize(frameWidth,frameHeigth);

        this.attached = new ArrayList<>();
        this.setLocation(frameX, frameY);
        this.setSize(frameWidth, frameHeigth);
        this.setResizable(true);
        this.setVisible(true);
    }*/






    public void initMarketButton() {
        this.marketButton = new JButton();
        marketButton.setText("Market");
        Font f = new Font("Helvetica", Font.BOLD, 16);
        marketButton.setFont(f);
        marketButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        marketButton.setBackground(new Color(0xeaf1f7));
        marketButton.addActionListener(e -> {
            this.marketFrame.changeVisibility();
        });
        //marketButton.setBorder(BorderFactory.createBevelBorder(0));
    }


    public void initProdCardButton() {
        this.prodCardButton = new JButton();
        prodCardButton.setText("Decks");
        Font f = new Font("Helvetica", Font.BOLD, 16);
        prodCardButton.setFont(f);
        prodCardButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        prodCardButton.setBackground(new Color(0xeaf1f7));
        prodCardButton.addActionListener(e -> {
            this.productionDeckFrame.changeVisibility();
        });
        //prodCardButton.setBorder(BorderFactory.createBevelBorder(0));

    }

    public void initReserveButton() {
        this.reserveButton = new JButton();
        reserveButton.setText("Reserve");
        Font f = new Font("Helvetica", Font.BOLD, 16);
        reserveButton.setFont(f);
        reserveButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        reserveButton.setBackground(new Color(0xeaf1f7));
        reserveButton.addActionListener(e -> {
            reserveFrame.changeVisibility();
            reserveFrame.paintComponents(reserveFrame.getGraphics());
        });
        //reserveButton.setBorder(BorderFactory.createBevelBorder(0));

    }




    public void setGeneralFeatures() {

        this.setLayout(new BorderLayout());
        this.mainPanel = new JPanel();
        this.add(mainPanel);
        mainPanel.setLayout(null);

    }
    public abstract void getStrongBox(Map<Resource, Integer> map);

    public abstract void updateFaith(int i);
    public abstract void initLeader(ArrayList<LeaderCard> arrayList, boolean bool);
    public abstract void activateLeader(int key, int index);
    public abstract void discardLeader(int bool);



    public void initGameMode() {}

    /*public void initGameMode() {
        for (JPanel p : attached) {
            mainPanel.remove(p);
        }
        setGeneralFeatures();
        initNavigationBar();

        marketFrame = new MarketFrame();
        productionDeckFrame = new ProductionDeckFrame();
        reserveFrame = new ReserveFrame();

        gameboardPanel = new LorenzoGameboardPanel();
        gameboardPanel.setBounds(0, 0, 800, 572);
        mainPanel.add(gameboardPanel);
        serverMessagePanel = new ServerMessagePanel();
        serverMessagePanel.setBounds(800, 0, 380, 275);
        mainPanel.add(serverMessagePanel);
        leaderCardsPanel = new LeaderCardsPanel();
        leaderCardsPanel.setBounds(805, 280, leaderWidth, leaderHeight);
        leaderCardsPanel.setBackground(Color.BLUE);
        leaderCardsPanel.setOpaque(true);
        mainPanel.add(leaderCardsPanel);

        actionMarkerPanel = new ActionMarkerPanel();
        serverMessagePanel.display("Ha un grande valore rappresentativo, essendo \n architettonicamente e artisticamente incentrato \nsul Risorgimento, il complesso processo di unità nazionale e liberazione dalla dominazione straniera portato a compimento sotto il regno di Vittorio Emanuele II di Savoia, cui il monumento è dedicato: per tale motivo il Vittoriano è considerato uno dei simboli patri italiani.");


        this.setVisible(true);
    }*/





    public void addToExtraStorage(int position, Resource resourceType, int quantity) {
        leaderCardsPanel.addToStorageExtra(position, resourceType, quantity);
    }

    public abstract void updateStorage(Map<Resource, Integer> newStorage);


    public void showPopUp(Message message){

        JOptionPane.showMessageDialog(this,message.toString(),message.getMessageType().toString(),
                JOptionPane.WARNING_MESSAGE);;

    }
    public void showPopUp(String string){
        JOptionPane.showMessageDialog(this,string,"Network Error",JOptionPane.WARNING_MESSAGE);
    }



    public void marblePossibilityPopUp(int n, ArrayList<Resource> whiteMarbleResourceTypes){

            ArrayList<WhiteMarbleLabel> whiteMarbleLabels = new ArrayList<>();
            ArrayList<Resource> buffer = new ArrayList<>();
            JDialog dialog =new JDialog();
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dialog.setLocation(600, 400);
            dialog.setSize(450, 200);
            dialog.getContentPane().setBackground(new Color(232,228,212));

            dialog.setLayout(new FlowLayout());

            JLabel text1 = new JLabel("you've got " + n + " white marbles, ");
            text1.setSize(350, 20);
            text1.setBounds(5,5,350,20);
            dialog.add(text1);
            JLabel text2 = new JLabel("for each of them you must choose a resource");
            text2.setSize(350, 20);
            text2.setBounds(5,25,350,20);
            dialog.add(text2);
            for(int i = 0; i < n; i++) {
                WhiteMarbleLabel whiteMarble = new WhiteMarbleLabel(70 * i, 60, whiteMarbleResourceTypes);
                whiteMarble.setSize(40, 40);
                whiteMarble.setBounds(70 * i, 60, 40, 40);
                dialog.add(whiteMarble);
                whiteMarbleLabels.add(whiteMarble);
            }

            JButton enterButton;

            enterButton= new JButton("enter");
            enterButton.setBackground(new Color(232,228,212));
            enterButton.setSize(new Dimension(60,60));
            enterButton.setBounds(200, 60, 60,60);

            dialog.add(enterButton);

            enterButton.addActionListener(eNO -> {
                (new Thread(() -> {
                    try {
                        for(WhiteMarbleLabel whiteMarble : whiteMarbleLabels)
                            buffer.add(whiteMarble.getResource());
                        System.out.println(buffer);
                        gui.notifyObserver(new WhiteMarbleChoosenResourcesMessage(buffer));
                    } catch (IOException | InterruptedException e1) {
                        e1.printStackTrace();
                    }
                })).start();
                dialog.dispose();

            });

            dialog.setVisible(true);

    }
    public abstract void updateProductionCard(GameboardListNotification gameboardListNotification);

    public void  fullStoragePopUp(NotEnoughSpaceErrorMessage message){
            ArrayList<Resource> buffer = new ArrayList<>();
            JDialog dialog =new JDialog();
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dialog.setLocation(600, 400);
            dialog.setSize(550, 200);
            dialog.getContentPane().setBackground(new Color(232,228,212));

            dialog.setLayout(new FlowLayout());

            JLabel text1 = new JLabel("you don't have enough storage space,");
            text1.setSize(350, 20);
            text1.setBounds(5,5,350,20);
            dialog.add(text1);
            JLabel text2 = new JLabel("choose which resources to keep and press enter");
            text2.setSize(350, 20);
            text2.setBounds(5,25,350,20);
            dialog.add(text2);
            for(int i = 0; i < message.getReources().size(); i++){
                ResourceButton resourceButton = new ResourceButton(message.getReources().get(i));
                resourceButton.setSize(40,40);
                resourceButton.setBounds(50*i, 60, 40, 40);
                dialog.add(resourceButton);
                resourceButton.addActionListener(e -> {
                    buffer.add(resourceButton.getResource());
                    resourceButton.setEnabled(false);
                });
            }

            JButton enterButton;

            enterButton= new JButton("enter");
            enterButton.setBackground(new Color(232,228,212));
            enterButton.setSize(new Dimension(60,60));
            enterButton.setBounds(200, 60, 60,60);

            dialog.add(enterButton);

            enterButton.addActionListener(eNO -> {
                (new Thread(() -> {
                    try {
                        gui.notifyObserver(new KeepResourcesMessage(buffer));
                    } catch (IOException | InterruptedException e1) {
                        e1.printStackTrace();
                    }
                })).start();
                dialog.dispose();

            });

            dialog.setVisible(true);
    }


    public void disableMarketButtons(){
        marketFrame.removeButton();
    }

    public void enableMarketButtons(){
        marketFrame.enableButton();
    }

    public void disableDeckButtons(){
        productionDeckFrame.disableButtons();
    }

    public void enableDeckButtons(){
        productionDeckFrame.enableButtons();
    }

    public abstract void putCardMode();

    public abstract void setChosenDeckNumber(int n);

    public void disableLeaderButtons(){
        leaderCardsPanel.disableButtons();
    }

    public void enableLeaderButtons() {
        leaderCardsPanel.enableButtons();
    }



    public abstract void disableProductionButtons();

    public abstract void enableProductionButtons();



    public MarketFrame getMarketFrame() {
        return marketFrame;
    }

    public ReserveFrame getReserveFrame(){
        return reserveFrame;
    }

    public ProductionDeckFrame getProductionDeckFrame(){
        return productionDeckFrame;
    }

    public void setPlayers(ArrayList<String> arrayList){}

    public abstract void givePapalCard(int i);

    public abstract void removePapalCard(int i);



    public  void setCurrentPlayer(String currentNick){}


    public abstract void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    protected abstract void applyChangesTo(Component component);

    protected abstract void clear(JFrame frame);

    protected abstract void clear(JPanel panel);

    public abstract void showLabel(Message message);

    public abstract void askInitResource();

    public void displayString(String string){
        serverMessagePanel.display(string);
    }

    public abstract void showLorenzoActionPopUp(String string);

    public abstract void updateLorenzoIndicator(int i);

    public void showAllOfPlayer(ShowAllOfPlayerMessage msg){
    }

    public abstract void enableEndTurnButton();

    public abstract void disableEndTurnButton();

    public abstract void activateEndOfProductionButton();

    public abstract void enableBaseProductionButton();

    public abstract void disableEndOfProductionButton();

    public abstract int howManyActivated();
}




