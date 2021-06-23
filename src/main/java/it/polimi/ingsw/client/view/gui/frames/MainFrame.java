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

    /**
     * Graphic parameters.
     */
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

    /**
     * Player's Gui reference.
     */
    protected Gui gui;

    /**
     * Reference to the server communication panel.
     */
    protected ServerMessagePanel serverMessagePanel;

    /**
     * Reference to the leader cards panel.
     */
    protected LeaderCardsPanel leaderCardsPanel;


    /**
     * Reference to the reserve frame.
     */
    protected ReserveFrame reserveFrame;

    /**
     * Reference to the market frame.
     */
    protected MarketFrame marketFrame;

    /**
     * Reference to the production-deck frame.
     */
    protected ProductionDeckFrame productionDeckFrame;

    /**
     * Main panel contains is the main component container in main frame.
     */
    protected JPanel mainPanel;
    /**
     * Navigation bar, this component contains all the frame buttons, turn information labels and opponents menu.
     */
    protected JPanel navigationBar;
    /**
     * Market button shows or hides the market frame.
     */
    protected JButton marketButton;
    /**
     * Production-card button shows or hides the production-card frame.
     */
    protected JButton prodCardButton;
    /**
     * Reserve button shows or hides the reserve frame.
     */
    protected JButton reserveButton;
    /**
     * Background panel contains the background image beside other graphic components.
     */
    protected JPanel background;

    /**
     * The main aim of attached attribute is to keep a reference to all the components attached to the main panel so that it is possible
     * to remove them whenever required.
     */
    protected ArrayList<JPanel> attached;
    /**
     * Blank labels are used only for layout purposes.
     */
    protected JLabel[] blankLabels;


    /**
     * Main frame constructor.
     * @param gui
     */
    public MainFrame(Gui gui){
        super();
        this.gui=gui;

        this.mainPanel = new JPanel();
        this.setTitle("Master of Renaissance");
        this.attached = new ArrayList<>();
        this.setLocation(frameX, frameY);
        this.setSize(frameWidth, frameHeigth);
        this.setResizable(false);
        this.setVisible(false);

    }


    /**
     * SwitchToGameMode() changes the game environment to the real game after initial settings.
     */
    public void switchToGameMode(){

        this.remove(background);
        background = null;
        this.setLayout(new BorderLayout());
        this.add(navigationBar, BorderLayout.NORTH);
        this.add(mainPanel);

        this.paintComponents(this.getGraphics());
        this.paintComponents(this.getGraphics());

    }


    /**
     * Initial settings of market button.
     */
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

    }

    /**
     * Initial settings of production card button.
     */
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


    }

    /**
     * Initial settings of reserve button.
     */
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


    }


    /**
     * Returns true if background panel is not initialised.
     * @return
     */
    public boolean isBackGroundNull() {
        if (background == null)
            return true;
        return false;
    }

    /**
     * Updates server messages on the paper image.
     */
    public void refreshMessagePanel() {
        this.serverMessagePanel.refreshMessagePanel();
    }


    /**
     * When called it adds new resources to extra storages.
     * @param position
     * @param resourceType
     * @param quantity
     */
    public void addToExtraStorage(int position, Resource resourceType, int quantity) {
        leaderCardsPanel.addToStorageExtra(position, resourceType, quantity);
    }

    /**
     * Shows a server high-priority message on a pop-up.
     * @param message
     */
    public void showPopUp(Message message){

        JOptionPane.showMessageDialog(this,message.toString(),message.getMessageType().toString(),
                JOptionPane.WARNING_MESSAGE);;

    }

    /**
     * Shows a server high-priority message string on a pop-up.
     * @param string
     */
    public void showPopUp(String string){
        JOptionPane.showMessageDialog(this,string,"Network Error",JOptionPane.WARNING_MESSAGE);
    }


    /**
     * When a player has activated two white-marble-effect leader cards and get new white marbles from the market
     * this pop-up let them choose the resource types they want.
     * @param n
     * @param whiteMarbleResourceTypes
     */
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
                        gui.notifyObserver(new WhiteMarbleChoosenResourcesMessage(buffer));
                    } catch (IOException | InterruptedException e1) {
                        e1.printStackTrace();
                    }
                })).start();
                dialog.dispose();
                enableEndTurnButton();
            });

            dialog.setVisible(true);

    }


    /**
     * When a player gets new resources from the market and there is not enough space in storage this pop-up is
     * displayed so that they can choose which resources to keep.
     * @param message
     */
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
                enableEndTurnButton();

            });

            dialog.setVisible(true);
    }

    /**
     * This method displayes a string on the message panel.
     * @param string
     */
    public void displayString(String string){
        serverMessagePanel.display(string);
    }

    /**
     * Disables all the market buttons.
     */
    public void disableMarketButtons(){
        marketFrame.removeButton();
    }

    /**
     * Enables all the market buttons.
     */
    public void enableMarketButtons(){
        marketFrame.enableButton();
    }

    /**
     * Disables all the deck buttons.
     */
    public void disableDeckButtons(){
        productionDeckFrame.disableButtons();
    }

    /**
     * Enables all the deck buttons.
     */
    public void enableDeckButtons(){
        productionDeckFrame.enableButtons();
    }

    /**
     * Disable all the leader card buttons.
     */
    public void disableLeaderButtons(){
        leaderCardsPanel.disableButtons();
    }

    /**
     * Enable all the leader card buttons.
     */
    public void enableLeaderButtons() {
        leaderCardsPanel.enableButtons();
    }

    /**
     * Returns the marketFrame reference.
     * @return
     */
    public MarketFrame getMarketFrame() {
        return marketFrame;
    }

    /**
     * Returns the reserveFrame reference.
     * @return
     */
    public ReserveFrame getReserveFrame(){
        return reserveFrame;
    }

    /**
     * Returns the productionDecksFrame reference.
     * @return
     */
    public ProductionDeckFrame getProductionDeckFrame(){
        return productionDeckFrame;
    }




    /**
     * Abstract methods are implemented in subtypes of MainFrame because they require different behaviour.
     */

    public abstract void updateStrongBox(Map<Resource, Integer> map);

    public abstract void updateFaith(int i);

    public abstract void initLeader(ArrayList<LeaderCard> arrayList, boolean bool);

    public abstract void activateLeader(int key, int index);

    public abstract void discardLeader(int bool);

    public abstract void initGameMode();

    public abstract void updateStorage(Map<Resource, Integer> newStorage);

    public abstract void disableProductionButtons();

    public abstract void enableProductionButtons();

    public abstract void putCardMode();

    public abstract void setChosenDeckNumber(int n);

    public void setPlayers(ArrayList<String> arrayList){}

    public abstract void givePapalCard(int i);

    public abstract void removePapalCard(int i);

    public void setCurrentPlayer(String currentNick){}

    public abstract void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    protected abstract void applyChangesTo(Component component);

    protected abstract void clear(JFrame frame);

    protected abstract void clear(JPanel panel);

    public abstract void showLabel(Message message);

    public abstract void askInitResource();

    public void showLorenzoActionPopUp(String string){}

    public abstract void updateLorenzoIndicator(int i);


    public abstract void enableEndTurnButton();

    public abstract void disableEndTurnButton();

    public abstract void activateEndOfProductionButton();

    public abstract void enableBaseProductionButton();

    public abstract void disableEndOfProductionButton();

    public abstract int howManyActivated();

    public abstract void updateProductionCard(GameboardListNotification gameboardListNotification);

    public abstract  int howManyActivatedExceptBaseProduction();

}




