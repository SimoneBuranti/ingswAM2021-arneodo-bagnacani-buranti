package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MainFrame  extends JFrame {


    public final static int frameWidth = 1115;
    public final static int frameHeigth = 668;
    public final static int frameX = 250;
    public final static int frameY = 160;
    public final static int buttonWidth = 100;
    public final static int buttonHeight = 60;


    protected GameboardPanel gameboardPanel;
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
        setGeneralFeatures();
        initNavigationBar();

        initGameMode();
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

    }


    public void initProdCardButton(){
        this.marketButton = new JButton();
        marketButton.setText("Production cards");
        marketButton.setSize(buttonWidth,buttonHeight);
        marketButton.setBorder(BorderFactory.createBevelBorder(3));

    }

    public void initReserveButton(){
        this.marketButton = new JButton();
        marketButton.setText("Reserve");
        marketButton.setSize(buttonWidth,buttonHeight);
        marketButton.setBorder(BorderFactory.createBevelBorder(3));

    }



    public void setGeneralFeatures() {
        this.attached = new ArrayList<>();

        this.setBackground(new Color(6, 8, 118));
        this.setLocation(frameX,frameY);
        this.setSize(frameWidth,frameHeigth);

        this.setLayout(new BorderLayout());
    }


    private void initGameMode() {

    }


    public abstract void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    protected abstract void applyChangesTo(Component component);

    protected abstract void clear(JFrame frame);

    protected abstract void clear(JPanel panel);

    public abstract void showLabel(Message message);

    public abstract void askInitResource() throws IOException, InterruptedException;
}
