package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private final static int frameWidth = 1115;
    private final static int frameHeigth = 668;
    private final static int frameX = 250;
    private final static int frameY = 160;
    private final static int buttonWidth = 100;
    private final static int buttonHeight = 60;

    private GameboardPanel gameboardPanel;
    private JPanel navigationBar;
    private JButton marketButton;
    private JButton prodCardButton;
    private JButton reserveButton;
    private JMenu playerMenu;
    private JLabel turnLabel;
    private ArrayList<JMenuItem> players;

    private ArrayList<JPanel> attached;


    public MainFrame(){
        super();

        setGeneralFeatures();
        initNavigationBar();

        initGameMode();


    }


    public void setPlayers(ArrayList<String> players) {
        this.players = new ArrayList<>();
        for(int i = 0;i<players.size(); i++){
            this.players.add(new JMenuItem(players.get(i)));
            this.playerMenu.add(this.players.get(i));
        }

    }

    private void initNavigationBar() {
        this.navigationBar = new JPanel();
        navigationBar.setBackground(new Color(199, 0, 0));
        this.setLayout(new FlowLayout());

    }

    private void initMarketButton(){
        this.marketButton = new JButton();
        marketButton.setText("Market");
        marketButton.setSize(buttonWidth,buttonHeight);
        marketButton.setBorder(BorderFactory.createBevelBorder(3));

    }


    private void initProdCardButton(){
        this.marketButton = new JButton();
        marketButton.setText("Production cards");
        marketButton.setSize(buttonWidth,buttonHeight);
        marketButton.setBorder(BorderFactory.createBevelBorder(3));

    }

    private void initReserveButton(){
        this.marketButton = new JButton();
        marketButton.setText("Reserve");
        marketButton.setSize(buttonWidth,buttonHeight);
        marketButton.setBorder(BorderFactory.createBevelBorder(3));

    }

    private void initPlayerMenu(){
        this.playerMenu = new JMenu();
        playerMenu.setText("Players");
        playerMenu.setSize(buttonWidth,buttonHeight);
        playerMenu.setBorder(BorderFactory.createBevelBorder(3));
    }

    private void setGeneralFeatures() {
        this.attached = new ArrayList<>();
        this.setBackground(new Color(6, 8, 118, 181));
        this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);

        this.setLayout(new BorderLayout());
    }


    private void initGameMode() {

    }


}
