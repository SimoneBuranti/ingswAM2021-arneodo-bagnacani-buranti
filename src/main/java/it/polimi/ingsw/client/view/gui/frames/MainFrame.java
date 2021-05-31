package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NotEnoughSpaceErrorMessage;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
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
    public final static int frameHeigth = 673;
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
    public abstract void activateLeader(int arrayList, int bool);
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


        SwingUtilities.invokeLater(() -> {
            int howManyC=0;
            int howManyR=0;
            int howManyS=0;
            int howManyV=0;
            int howManyChoosen=0;

            ArrayList<Resource> arrayList=new ArrayList<>(whiteMarbleResourceTypes.size());
            for (Resource resource: whiteMarbleResourceTypes)
            {
                if (resource.equals(Resource.COIN))
                    howManyR++;
                else if (resource.equals(Resource.ROCK))
                    howManyC++;
                else if (resource.equals(Resource.SERVANT))
                    howManyV++;
                else if (resource.equals(Resource.SHIELD))
                    howManyS++;
            }
            JButton coinButton;
            JButton servantButton;
            JButton shieldButton;
            JButton rockButton;
            JButton enterButton;

            JDialog dialog =new JDialog();

            dialog.setLayout(new FlowLayout());

            if (howManyC>0){
                coinButton= new JButton("COIN");
                coinButton.setSize(new Dimension(50,50));
                dialog.add(coinButton);
                coinButton.addActionListener(eNO -> {
                    if (howManyChoosen<= n){
                        arrayList.add(Resource.COIN);}

                });}

            if (howManyV>0){
                servantButton= new JButton("SERVANT");
                servantButton.setSize(new Dimension(50,50));
                dialog.add(servantButton);

                servantButton.addActionListener(eYES -> {
                    if (howManyChoosen>=n){
                        arrayList.add(Resource.COIN);
                    }
                });}

            if(howManyS>0){
                shieldButton= new JButton("SHIELD");
                shieldButton.setSize(new Dimension(50,50));
                dialog.add(shieldButton);

                shieldButton.addActionListener(eNO -> {
                    if (howManyChoosen>=n){
                        arrayList.add(Resource.COIN);
                    }
                });
            }

            if(howManyR>0){
                rockButton= new JButton("ROCK");
                rockButton.setSize(new Dimension(50,50));
                dialog.add(rockButton);
                rockButton.addActionListener(eONe -> {
                    if (howManyChoosen>=n){
                        arrayList.add(Resource.COIN);
                    }
                });}

            enterButton= new JButton("4");
            enterButton.setSize(new Dimension(60,60));


            dialog.add(enterButton);



            enterButton.addActionListener(eNO -> {
                try {
                    gui.notifyObserver(new WhiteMarbleChoosenResourcesMessage(arrayList));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        });



    }
    public abstract void updateProductionCard(GameboardListNotification gameboardListNotification);

    public void  fullStoragePopUp(NotEnoughSpaceErrorMessage message){

        SwingUtilities.invokeLater(() -> {
            int howManyC=0;
            int howManyR=0;
            int howManyS=0;
            int howManyV=0;
            AtomicInteger howManyCP= new AtomicInteger();
            AtomicInteger howManyRP= new AtomicInteger();
            AtomicInteger howManySP= new AtomicInteger();
            AtomicInteger howManyVP= new AtomicInteger();
            ArrayList<Resource> arrayList=new ArrayList<>(message.getReources().size());
            for (Resource resource: message.getReources())
            {
                if (resource.equals(Resource.COIN))
                    howManyR++;
                else if (resource.equals(Resource.ROCK))
                    howManyC++;
                else if (resource.equals(Resource.SERVANT))
                    howManyV++;
                else if (resource.equals(Resource.SHIELD))
                    howManyS++;
            }
            JButton coinButton;
            JButton servantButton;
            JButton shieldButton;
            JButton rockButton;
            JButton enterButton;

            JDialog dialog =new JDialog();

            dialog.setLayout(new FlowLayout());

            coinButton= new JButton("COIN");
            coinButton.setSize(new Dimension(50,50));

            servantButton= new JButton("SERVANT");
            servantButton.setSize(new Dimension(50,50));

            shieldButton= new JButton("SHIELD");
            shieldButton.setSize(new Dimension(50,50));

            rockButton= new JButton("ROCK");
            rockButton.setSize(new Dimension(50,50));

            enterButton= new JButton("4");
            enterButton.setSize(new Dimension(60,60));

            dialog.add(coinButton);
            dialog.add(rockButton);
            dialog.add(servantButton);
            dialog.add(shieldButton);
            dialog.add(enterButton);


            int finalHowManyR = howManyR;
            rockButton.addActionListener(eONe -> {
                if (howManyRP.get() != finalHowManyR){
                    arrayList.add(Resource.COIN);
                    howManyRP.getAndIncrement();
                }
            });
            int finalHowManyC = howManyC;
            coinButton.addActionListener(eNO -> {
                if (howManyCP.get() != finalHowManyC){
                    arrayList.add(Resource.COIN);
                    howManyCP.getAndIncrement();}
            });
            int finalHowManyV = howManyV;
            servantButton.addActionListener(eYES -> {
                if (howManyVP.get() != finalHowManyV){
                    arrayList.add(Resource.COIN);
                    howManyVP.getAndIncrement();}
            });
            int finalHowManyS = howManyS;
            shieldButton.addActionListener(eNO -> {
                if (howManySP.get() != finalHowManyS){
                    arrayList.add(Resource.COIN);
                    howManySP.getAndIncrement();}
            });
            enterButton.addActionListener(eNO -> {
                try {
                    gui.notifyObserver(new KeepResourcesMessage(arrayList));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }); }


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

    public abstract void putCardMode(int deckKey);

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

    public abstract void callForCouncil(int i);



    public  void setCurrentPlayer(String currentNick){}


    public abstract void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    protected abstract void applyChangesTo(Component component);

    protected abstract void clear(JFrame frame);

    protected abstract void clear(JPanel panel);

    public abstract void showLabel(Message message);

    public abstract void askInitResource() throws IOException, InterruptedException;

    public void displayString(String string){
        serverMessagePanel.display(string);
    }

    public abstract void showLorenzoActionPopUp(String string);

    public void showAllOfPlayer(ShowAllOfPlayerMessage msg){
    }

    public abstract void enableEndTurnButton();

    public abstract void disableEndTurnButton();

    public abstract void activateEndOfProductionButton();
}




