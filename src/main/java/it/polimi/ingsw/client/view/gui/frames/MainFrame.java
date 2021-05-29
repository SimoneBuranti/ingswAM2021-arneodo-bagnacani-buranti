package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame  extends JFrame {

    public final static int northHeight = 70;
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



    public MainFrame(String title){
        /*this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);*/

        this.attached = new ArrayList<>();
        this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void initNavigationBar() {
        navigationBar = new JPanel();
        navigationBar.setBackground(new Color(199, 0, 0));
        navigationBar.setLayout(new FlowLayout());
        navigationBar.setPreferredSize(new Dimension(buttonHeight+10,buttonHeight+10));
        navigationBar.setBorder(BorderFactory.createBevelBorder(0));

        initMarketButton();
        initProdCardButton();
        initReserveButton();

        this.navigationBar.add(marketButton);
        this.navigationBar.add(prodCardButton);
        this.navigationBar.add(reserveButton);
        this.add(navigationBar,BorderLayout.NORTH);

        //---------------
        /*JPanel random = new JPanel();
        random.setBackground(Color.RED);
        random.setPreferredSize(new Dimension(buttonHeight,buttonHeight));
        random.setBorder(BorderFactory.createBevelBorder(0));*/
    }

    public void initMarketButton(){
        this.marketButton = new JButton();
        marketButton.setText("Market");
        marketButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        marketButton.addActionListener(e -> {
            this.marketFrame.changeVisibility();
        });
        //marketButton.setBorder(BorderFactory.createBevelBorder(0));
    }


    public void initProdCardButton(){
        this.prodCardButton = new JButton();
        prodCardButton.setText("Decks");
        prodCardButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        prodCardButton.addActionListener( e -> {
            this.productionDeckFrame.changeVisibility();
        });
        //prodCardButton.setBorder(BorderFactory.createBevelBorder(0));

    }

    public void initReserveButton(){
        this.reserveButton = new JButton();
        reserveButton.setText("Reserve");
        reserveButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
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


    public void initGameMode() {
        for(JPanel p : attached){
            mainPanel.remove(p);
        }
        setGeneralFeatures();
        initNavigationBar();

        marketFrame = new MarketFrame();
        productionDeckFrame = new ProductionDeckFrame();
        reserveFrame = new ReserveFrame();

        gameboardPanel = new GameboardPanel();
        gameboardPanel.setBounds(0,0,800,572);
        mainPanel.add(gameboardPanel);
        serverMessagePanel = new ServerMessagePanel();
        serverMessagePanel.setBounds(800,0,300,250);
        mainPanel.add(serverMessagePanel);
        serverMessagePanel.display("Ha un grande valore rappresentativo, essendo \n architettonicamente e artisticamente incentrato \nsul Risorgimento, il complesso processo di unità nazionale e liberazione dalla dominazione straniera portato a compimento sotto il regno di Vittorio Emanuele II di Savoia, cui il monumento è dedicato: per tale motivo il Vittoriano è considerato uno dei simboli patri italiani.");


        this.setVisible(true);
    }


    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {}

    protected void applyChangesTo(Component component){}

    protected void clear(JFrame frame){}

    protected void clear(JPanel panel){}

    public void showLabel(Message message){}

    public  void askInitResource() throws IOException, InterruptedException{}
}
