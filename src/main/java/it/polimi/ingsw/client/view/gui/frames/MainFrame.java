package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainFrame  extends JFrame {

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
    private final static int actionPanelWidth = 305;
    private final static int actionPanelHeight = 150;

    protected GameboardPanel gameboardPanel;
    protected ServerMessagePanel serverMessagePanel;
    protected LeaderCardsPanel leaderCardsPanel;
    protected ActionMarkerPanel actionMarkerPanel;
    //protected LEADERCARDSPACE

    protected ReserveFrame reserveFrame;
    protected MarketFrame marketFrame;
    protected ProductionDeckFrame productionDeckFrame;

    protected JPanel menuPanel;
    protected JMenuBar menuBar;
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
    protected JLabel[] blankLabels;
    private Font currentPlayerFont =new Font("Helvetica", Font.BOLD, 22);;


    public MainFrame(String title){
        /*this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);*/

        this.attached = new ArrayList<>();
        this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);
        this.setResizable(true);
        this.setVisible(true);
    }
    public MainFrame(Gui gui){
        /*this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);*/

        this.attached = new ArrayList<>();
        this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);
        this.setResizable(false);
        this.setVisible(true);
    }
    public MainFrame(String title, Gui gui){
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
        initPlayerMenu();

        this.navigationBar.add(marketButton);
        this.navigationBar.add(prodCardButton);
        this.navigationBar.add(reserveButton);
        this.navigationBar.add(menuPanel);
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
        Font f = new Font("Helvetica", Font.BOLD, 16);
        marketButton.setFont(f);
        marketButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        marketButton.setBackground(new Color(0xeaf1f7));
        marketButton.addActionListener(e -> {
            this.marketFrame.changeVisibility();
        });
        //marketButton.setBorder(BorderFactory.createBevelBorder(0));
    }


    public void initProdCardButton(){
        this.prodCardButton = new JButton();
        prodCardButton.setText("Decks");
        Font f = new Font("Helvetica", Font.BOLD, 16);
        prodCardButton.setFont(f);
        prodCardButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        prodCardButton.setBackground(new Color(0xeaf1f7));
        prodCardButton.addActionListener( e -> {
            this.productionDeckFrame.changeVisibility();
        });
        //prodCardButton.setBorder(BorderFactory.createBevelBorder(0));

    }

    public void initReserveButton(){
        this.reserveButton = new JButton();
        reserveButton.setText("Reserve");
        Font f = new Font("Helvetica", Font.BOLD, 16);
        reserveButton.setFont(f);
        reserveButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        reserveButton.setBackground(new Color(0xeaf1f7));
        reserveButton.addActionListener(e -> {
            reserveFrame.changeVisibility();
        });
        //reserveButton.setBorder(BorderFactory.createBevelBorder(0));

    }

    public void initPlayerMenu(){
        Font f = new Font("Helvetica", Font.BOLD, 16);

        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        menuPanel.setLayout(null);

        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        menuBar.setBounds(0,0,buttonWidth,buttonHeight);
        menuBar.setLayout(null);

        playerMenu = new JMenu();
        playerMenu.setText("Players");
        playerMenu.setFont(f);
        playerMenu.setBounds(0,0,buttonWidth,buttonHeight);
        playerMenu.setBackground(new Color(0xeaf1f7));
        playerMenu.setHorizontalTextPosition(SwingConstants.CENTER);
        playerMenu.setOpaque(true);
        playerMenu.setBorder(BorderFactory.createBevelBorder(0));

        menuBar.add(playerMenu);
        menuPanel.add(menuBar);
    }

    public void initTurnPanel(){
        this.turnPanel = new JPanel();
        int turnPanelWidth = 0;
        Font f = new Font("Helvetica", Font.BOLD, 18);
        turnPanel.setBackground(new Color(0xeaf1f7));
        turnPanel.setLayout(new GridLayout(1,nicknames.size(),0,0));
        for(int i = 0;i<nicknames.size();i++){
            turnPanelWidth = turnPanelWidth + nicknames.get(i).getText().length();
            nicknames.get(i).setFont(f);
            nicknames.get(i).setSize(new Dimension(nicknames.get(i).getText().length()*letterOffset,buttonHeight));
            turnPanel.add(nicknames.get(i));
        }
        turnPanelWidth *= letterOffset;
        turnPanel.setPreferredSize(new Dimension(turnPanelWidth,buttonHeight));

        blankLabels = new JLabel[2];
        for(int i = 0;i<blankLabels.length;i++){
            blankLabels[i] = new JLabel();
            blankLabels[i].setPreferredSize(new Dimension(80,buttonHeight));
            navigationBar.add(blankLabels[i]);
        }

        this.navigationBar.add(turnPanel);
    }


    public void setGeneralFeatures() {

        this.setLayout(new BorderLayout());
        this.mainPanel = new JPanel();
        this.add(mainPanel);
        mainPanel.setLayout(null);

    }

    public void setPlayers(ArrayList<String> players) {
        this.players = new ArrayList<>();
        this.nicknames = new ArrayList<>();
        for(int i = 0;i<players.size(); i++){

            this.players.add(new JMenuItem(players.get(i)));
            this.playerMenu.add(this.players.get(i));
            this.nicknames.add(new JLabel(players.get(i)));
            this.nicknames.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            this.nicknames.get(i).setVerticalAlignment(SwingConstants.CENTER);
        }
        initTurnPanel();
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

        gameboardPanel = new LorenzoGameboardPanel();
        gameboardPanel.setBounds(0,0,800,572);
        mainPanel.add(gameboardPanel);
        serverMessagePanel = new ServerMessagePanel();
        serverMessagePanel.setBounds(800,0,380,275);
        mainPanel.add(serverMessagePanel);
        leaderCardsPanel = new LeaderCardsPanel();
        leaderCardsPanel.setBounds(805, 280, leaderWidth, leaderHeight);
        leaderCardsPanel.setBackground(Color.BLUE);
        leaderCardsPanel.setOpaque(true);
        mainPanel.add(leaderCardsPanel);

        actionMarkerPanel = new ActionMarkerPanel();
        serverMessagePanel.display("Ha un grande valore rappresentativo, essendo \n architettonicamente e artisticamente incentrato \nsul Risorgimento, il complesso processo di unità nazionale e liberazione dalla dominazione straniera portato a compimento sotto il regno di Vittorio Emanuele II di Savoia, cui il monumento è dedicato: per tale motivo il Vittoriano è considerato uno dei simboli patri italiani.");


        this.setVisible(true);
    }

    public void setCurrentPlayer(String nick){

        for(int i = 0; i<nicknames.size();i++)
            if(nicknames.get(i).getText().equals(nick)){
                nicknames.get(i).setForeground(new Color(199, 0, 0));
                nicknames.get(i).setFont(currentPlayerFont);
            }

    }

    public void showLorenzoActionPopUp(String actionMarker){
        JDialog dialog = new JDialog();
        dialog.setLocation(600,430);
        dialog.setLayout(null);
        actionMarkerPanel.updatePickedMarkerImage(actionMarker);
        dialog.add(actionMarkerPanel);
        dialog.setSize(actionPanelWidth+10,actionPanelHeight+35);
        actionMarkerPanel.setVisible(true);
        dialog.setVisible(true);
    }

    public void addToExtraStorage(int position, Resource resourceType,int quantity){
        leaderCardsPanel.addToStorageExtra( position, resourceType, quantity);
    }

    public void updateStorage(Map<Resource,Integer> newStorage){

        this.gameboardPanel.updateStorage(newStorage);

    }


    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {}

    protected void applyChangesTo(Component component){}

    protected void clear(JFrame frame){}

    protected void clear(JPanel panel){}

    public void showLabel(Message message){}

    public  void askInitResource() throws IOException, InterruptedException{}
}
