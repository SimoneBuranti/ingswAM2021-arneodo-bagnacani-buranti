package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NotEnoughSpaceErrorMessage;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MainFrame  extends JFrame {


    public final static int frameWidth = 1115;
    public final static int frameHeigth = 668;
    public final static int frameX = 250;
    public final static int frameY = 160;
    public final static int buttonWidth = 100;
    public final static int buttonHeight = 60;


    protected GameboardPanel gameboardPanel;
    protected ServerMessagePanel serverMessagePanel;
    //protected LEADERCARDSPACE

    protected ReserveFrame reserveFrame;
    protected MarketFrame marketFrame;
    protected ProductionDeckFrame productionDeckFrame;

    protected JPanel mainPanel;

    protected JPanel navigationBar;
    protected JButton marketButton;
    protected JButton prodCardButton;
    protected JButton reserveButton;
    protected JMenu playerMenu;
    protected JPanel turnPanel;
    protected ArrayList<JMenuItem> players;
    protected ArrayList<JLabel> nicknames;
    protected ArrayList<JPanel> attached;
    protected Gui gui;

    public MainFrame(String string,Gui gui){
        super(string);
        this.gui=gui;
    }


    public MainFrame(Gui gui){
        super();
        this.gui=gui;
        setGeneralFeatures();
        initNavigationBar();
        initGameMode();
    }

    public void showMarket(){
        marketFrame=new MarketFrame();
    }
    public void showReserve(){
        reserveFrame=new ReserveFrame();
    }
    public void showProductionDeckFrame(){
        productionDeckFrame= new ProductionDeckFrame();
    }

    public void initNavigationBar() {
        this.navigationBar = new JPanel();
        navigationBar.setBackground(new Color(199, 0, 0));
        this.setLayout(new FlowLayout());

        initMarketButton();
        initProdCardButton();
        initReserveButton();

    }

    public void initMarketButton(){
        this.marketButton = new JButton();
        marketButton.setText("Market");
        marketButton.setSize(buttonWidth,buttonHeight);
        marketButton.setBorder(BorderFactory.createBevelBorder(3));
        marketButton.addActionListener(e -> {
            showMarket();
        });

    }


    public void initProdCardButton(){
        this.prodCardButton = new JButton();
        prodCardButton.setText("Production cards");
        prodCardButton.setSize(buttonWidth,buttonHeight);
        prodCardButton.setBorder(BorderFactory.createBevelBorder(3));
        prodCardButton.addActionListener(e -> {
            showProductionDeckFrame();
        });


    }

    public void initReserveButton(){
        this.reserveButton = new JButton();
        reserveButton.setText("Reserve");
        reserveButton.setSize(buttonWidth,buttonHeight);
        reserveButton.setBorder(BorderFactory.createBevelBorder(3));
        reserveButton.addActionListener(e -> {
            showReserve();
        });
    }



    public void setGeneralFeatures() {
        this.attached = new ArrayList<>();

        this.setBackground(new Color(6, 8, 118));
        this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);

        this.setLayout(new BorderLayout());
    }


    private void initGameMode() {}

    public void showPopUp(Message message){

        JOptionPane.showMessageDialog(this,message.toString(),message.getMessageType().toString(),
                JOptionPane.WARNING_MESSAGE);;

    }
    public void showPopUp(String string){
        JOptionPane.showMessageDialog(this,string,"Network Error",JOptionPane.WARNING_MESSAGE);
    }
    public abstract void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    protected abstract void applyChangesTo(Component component);

    protected abstract void clear(JFrame frame);

    protected abstract void clear(JPanel panel);

    public abstract void showLabel(Message message);

    public abstract void askInitResource() throws IOException, InterruptedException;


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

    public MarketFrame getMarketFrame() {
        return marketFrame;
    }

    public ReserveFrame getReserveFrame(){
        return reserveFrame;
    }

    public ProductionDeckFrame getProductionDeckFrame(){
        return productionDeckFrame;
    }
}
