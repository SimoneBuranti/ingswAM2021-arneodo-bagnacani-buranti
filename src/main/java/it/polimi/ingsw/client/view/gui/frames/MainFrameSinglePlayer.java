package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.gui.*;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainFrameSinglePlayer extends MainFrame{

    /**
     * Graphic parameters
     */
    private final static int actionPanelWidth = 305;
    private final static int actionPanelHeight = 150;

    /**
     * Graphic panel container.
     */
    private PanelContainer container;
    /**
     * Action marker panel shows Lorenzo The Magnificent actions in single player mode.
     */
    protected ActionMarkerPanel actionMarkerPanel;
    /**
     * The error label displays every type of error in the initial phase of the game.
     */
    private JLabel errorLabel;

    /**
     * LorenzoGameboardPanel represents an extension of the normal GameboardPanel.
     */
    private LorenzoGameboardPanel lorenzoGameboardPanel;
    /**
     * Game connection parameter.
     */
    private int readyToSend=0;

    /**
     * Single-player main frame constructor.
     * @param gui
     */
    public MainFrameSinglePlayer(Gui gui){
        super(gui);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initGameMode();
        pregameMode();

    }

    /**
     * This method overrides the Main frame one adding setting the single-player navigation bar.
     */
    public void initNavigationBar() {
        navigationBar = new JPanel();
        navigationBar.setBackground(new Color(199, 0, 0));
        navigationBar.setLayout(new FlowLayout());
        navigationBar.setPreferredSize(new Dimension(buttonHeight + 10, buttonHeight + 10));
        navigationBar.setBorder(BorderFactory.createBevelBorder(0));

        initMarketButton();
        initProdCardButton();
        initReserveButton();

        this.navigationBar.add(marketButton);
        this.navigationBar.add(prodCardButton);
        this.navigationBar.add(reserveButton);


    }

    /**
     * This method is called whenever a storage notification occurs.
     * @param newStorage
     */
    public void updateStorage(Map<Resource, Integer> newStorage) {
        this.lorenzoGameboardPanel.updateStorage(newStorage);

    }

    /**
     * The pre-game mode corresponds to the initial connection and setting phase.
     */
    public void pregameMode(){

        ImageIcon icon = new ImageIcon(getClass().getResource("/title.jpg"));
        Image image=icon.getImage();
        background = new PBackground(image);
        this.repaint();
        background.setLayout(null);
        this.add(background);

        container = new PanelContainer();
        container.setBounds(230,170, 700, 400);
        background.add(container);

        this.setVisible(true);
    }

    /**
     * After the initial pre-game mode the real game mode is casted.
     */
    public void initGameMode() {

        for (JPanel p : attached) {
            mainPanel.remove(p);
        }
        mainPanel.setLayout(null);


        initNavigationBar();

        marketFrame = new MarketFrame(gui);
        productionDeckFrame = new ProductionDeckFrame(gui);
        reserveFrame = new ReserveFrame();

        lorenzoGameboardPanel = new LorenzoGameboardPanel(gui);
        lorenzoGameboardPanel.setBounds(0, 0, 800, 572);
        mainPanel.add(lorenzoGameboardPanel);
        serverMessagePanel = new ServerMessagePanel();
        serverMessagePanel.setBounds(800, 0, 380, 275);
        mainPanel.add(serverMessagePanel);
        leaderCardsPanel = new LeaderCardsPanel(gui);
        leaderCardsPanel.setBounds(805, 280, leaderWidth, leaderHeight);

        mainPanel.add(leaderCardsPanel);

        actionMarkerPanel = new ActionMarkerPanel();


        this.setVisible(false);
    }


    /**
     * A pop-up is shown whenever Lorenzo The Magnificent does an action.
     * @param actionMarker
     */
    public void showLorenzoActionPopUp(String actionMarker) {
        JDialog dialog = new JDialog();
        dialog.setLocation(600, 430);
        dialog.setLayout(null);
        actionMarkerPanel.updatePickedMarkerImage(actionMarker);
        dialog.add(actionMarkerPanel);
        dialog.setSize(actionPanelWidth + 10, actionPanelHeight + 35);
        actionMarkerPanel.setVisible(true);
        dialog.setVisible(true);
    }

    /**
     * Lorenzo's indicator update; the specific method of LorenzoGameboardPanel is called.
     * @param i
     */
    @Override
    public void updateLorenzoIndicator(int i) {
        lorenzoGameboardPanel.updateLorenzoIndicator(i);
    }


    /**
     * This method enables the end-turn button by calling the same method in the LorenzoGameboardPanel.
     */
    @Override
    public void enableEndTurnButton() {
        lorenzoGameboardPanel.enableEndTurnButton();
    }

    /**
     * This method disables the end-turn button by calling the same method in the LorenzoGameboardPanel instance.
     */
    @Override
    public void disableEndTurnButton() {
        lorenzoGameboardPanel.disableEndTurnButton();
    }

    /**
     * This method enables the end-turn button by calling the same method in the LorenzoGameboardPanel instance.
     */
    @Override
    public void activateEndOfProductionButton() {
        lorenzoGameboardPanel.enableEndOfProductionButton();
    }

    /**
     * This method enables the base-production button by calling the same method in the LorenzoGameboardPanel instance.
     */
    @Override
    public void enableBaseProductionButton() {
        lorenzoGameboardPanel.enableBaseProductionButton();
    }


    /**
     * This method disables the end-production button by calling the same method in the LorenzoGameboardPanel instance.
     */
    @Override
    public void disableEndOfProductionButton() {
        lorenzoGameboardPanel.disableEndOfProductionButton();
    }

    /**
     * This method disables the production button by calling the same method in the LorenzoGameboardPanel instance.
     */
    @Override
    public void disableProductionButtons() {
        lorenzoGameboardPanel.disableProductionButtons();
        leaderCardsPanel.disableProductionButtons();
    }

    /**
     * This method enables the production button by calling the same method in the LorenzoGameboardPanel instance.
     */
    @Override
    public void enableProductionButtons() {
        lorenzoGameboardPanel.disableEndTurnButton();
        lorenzoGameboardPanel.disableEndOfProductionButton();
        lorenzoGameboardPanel.enableProductionButtons();
        leaderCardsPanel.enableProductionButtons();
    }


    /**
     * At the beginning of the match this method shows the leader cards the player can choose.
     * @param leaderCards
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {


            clear(container);

            CardManager cardManager = new CardManager(container,gui);
            cardManager.setHeading("Choose two cards:");
            cardManager.showWhatToChoose(true);

            applyChangesTo(container);

    }

    /**
     * Apply changes to a component
     * @param component The component
     */
    @Override
    public void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }


    /**
     * Flush the components inside a frame
     * @param frame     The frame
     */
    @Override
    public void clear(JFrame frame){
        frame.getContentPane().removeAll();
    }


    /**
     * Flush the components inside a panel
     * @param panel     The panel
     */
    @Override
    public void clear(JPanel panel){
        panel.removeAll();
    }


    /**
     * This method displays a new Jlabel containing a server message at the beginning of the game.
     * @param message
     */
    @Override
    public void showLabel(Message message){
        SwingUtilities.invokeLater(() -> {
            clear(container);
            container.setLayout(new FlowLayout());
            errorLabel = new JLabel(message.toString());
            container.add(errorLabel);
            errorLabel.setLocation(475,108);
            errorLabel.setSize(100,100);
            applyChangesTo(container);

        });
    }

    /**
     * At the beginning of the match this method shows the resources the player can choose.
     */
    @Override
    public void askInitResource() {
        (new Thread(() -> {
            try {
                gui.notifyObserver(new EndOfTurnMessage());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        })).start();
        gui.switchToGameMode();
    }


    /**
     * This method updates the resources in the strongbox by callling the same method in the LorenoGameboardPanel instance.
     * @param map
     */
    public void updateStrongBox(Map<Resource,Integer> map){
        this.lorenzoGameboardPanel.updateStrongBox(map);

    }

    /**
     * This method updates lorenzo's indicator by calling the same method in the LorenoGameboardPanel instance.
     * @param i
     */
    public void updateFaith(int i){
        this.lorenzoGameboardPanel.faithPathPane.updateIndicator(i);
    }

    /**
     * This method initialise the leader card panel by calling th same method inthe  LeaderCardsPanel instance.
     * @param arrayList
     * @param bool
     */
    public void initLeader(ArrayList<LeaderCard> arrayList, boolean bool){
        this.leaderCardsPanel.addLeaderCards(arrayList,bool);
    }

    /**
     * This method activates the indicated leader card by calling th same method in LeaderCardsPanel instance.
     * @param key
     * @param index
     */
    public void activateLeader(int key, int index){
        this.leaderCardsPanel.activatedLeaderCard(key, index);
    }

    /**
     * This method discards the indicated leader card by calling th same method in LeaderCardsPanel instance.
     * @param bool
     */
    public void discardLeader(int bool){
        this.leaderCardsPanel.discardLeaderCard(bool);
    }

    /**
     * This method updates the production card spaces by calling th same method in the LorenzoGameboardPanel instance.
     * @param gameboardListNotification
     */
    public void updateProductionCard(GameboardListNotification gameboardListNotification){
        this.lorenzoGameboardPanel.updateProductionSpaces(gameboardListNotification);
    }

    @Override
    public int howManyActivatedExceptBaseProduction() {
        return (lorenzoGameboardPanel.howManyActivatedExceptBaseProduction() + leaderCardsPanel.howManyActivated());
    }


    /**
     * This method sets the production deck number chosen by the player by calling the same method in the LorenzoGameboardPanel
     * instance.
     * @param n
     */
    @Override
    public void setChosenDeckNumber(int n) {
        lorenzoGameboardPanel.setChosenDeckNumber(n);
    }

    /**
     * When a player press a production card deck button the put card mode is set.
     */
    @Override
    public void putCardMode() {
        lorenzoGameboardPanel.putCardMode();
        leaderCardsPanel.disableProductionButtons();
    }

    /**
     * This method adds the current papal card by calling the same method in the LorenzoGameboardpanel instance.
     * @param i
     */
    public void givePapalCard(int i){
        this.lorenzoGameboardPanel.givePapalcard(i);
    }

    /**
     * This method removes the current papal card by calling the same method in the LorenzoGameboardpanel instance.
     * @param i
     */
    public void removePapalCard(int i){
        this.lorenzoGameboardPanel.removePapalCard(i);
    }

    /**
     * This method returns the overall number of activated leader cards.
     * @return
     */
    @Override
    public int howManyActivated(){
        return (lorenzoGameboardPanel.howManyActivated() + leaderCardsPanel.howManyActivated());
    }

}
