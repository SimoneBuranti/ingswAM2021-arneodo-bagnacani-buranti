package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.gui.*;
import it.polimi.ingsw.client.view.gui.listeners.OpponentItemListener;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainFrameMultiPlayer extends MainFrame {

    /**
     * Graphic components panel container.
     */
    private PanelContainer container;

    /**
     * The error label displays every type of error in the initial phase of the game.
     */
    private JLabel errorLabel;

    /**
     * GameboardPanel represents an extension of the normal GameboardPanel.
     */
    private GameboardPanel gameboardPanel;

    /**
     * Current player font type.
     */
    private Font currentPlayerFont = new Font("Helvetica", Font.BOLD, 22);
    /**
     * Not current player font type.
     */
    private Font notCurrentPlayerFont = new Font("Helvetica", Font.BOLD, 18);

    /**
     * Menu panel reference.
     */
    private JPanel menuPanel;
    /**
     * Player menu bar.
     */
    private JMenuBar menuBar;
    /**
     * Player menu object.
     */
    private JMenu playerMenu;
    /**
     * Turn panel reference.
     */
    private JPanel turnPanel;
    /**
     * Players' items in menuBar.
     */
    private ArrayList<JMenuItem> players;
    /**
     * Players'nicknames.
     */
    private ArrayList<JLabel> nicknames;


    /**
     * Multi-player main frame constructor.
     * @param gui
     */
    public MainFrameMultiPlayer(Gui gui){
        super(gui);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initGameMode();
        preGameMode();
    }


    /**
     * Initial settings of player menu object.
     */
    public void initPlayerMenu() {
        Font f = new Font("Helvetica", Font.BOLD, 16);

        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        menuPanel.setLayout(null);

        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        menuBar.setBounds(0, 0, buttonWidth, buttonHeight);
        menuBar.setLayout(null);

        playerMenu = new JMenu();
        playerMenu.setText("Players");
        playerMenu.setFont(f);
        playerMenu.setBounds(0, 0, buttonWidth, buttonHeight);
        playerMenu.setBackground(new Color(0xeaf1f7));
        playerMenu.setHorizontalTextPosition(SwingConstants.CENTER);
        playerMenu.setOpaque(true);
        playerMenu.setBorder(BorderFactory.createBevelBorder(0));

        menuBar.add(playerMenu);
        menuPanel.add(menuBar);
    }

    /**
     * Initial settings of turn panel object.
     */
    public void initTurnPanel() {
        this.turnPanel = new JPanel();
        int turnPanelWidth = 0;
        Font f = new Font("Helvetica", Font.BOLD, 18);

        turnPanel.setBackground(new Color(0xeaf1f7));
        turnPanel.setLayout(new GridLayout(1, nicknames.size(), 0, 0));

        for (int i = 0; i < nicknames.size(); i++) {
            turnPanelWidth = turnPanelWidth + nicknames.get(i).getText().length();
            nicknames.get(i).setFont(f);
            nicknames.get(i).setSize(new Dimension(nicknames.get(i).getText().length() * letterOffset, buttonHeight));
            turnPanel.add(nicknames.get(i));
        }
        turnPanelWidth = turnPanelWidth*letterOffset;
        turnPanel.setPreferredSize(new Dimension(turnPanelWidth+50*nicknames.size(), buttonHeight));

        blankLabels = new JLabel[2];
        for (int i = 0; i < blankLabels.length; i++) {
            blankLabels[i] = new JLabel();
            blankLabels[i].setPreferredSize(new Dimension(80, buttonHeight));
            navigationBar.add(blankLabels[i]);
        }

        this.navigationBar.add(turnPanel);
    }

    /**
     * This method overrides the Main frame one adding setting the multi-player navigation bar.
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
        initPlayerMenu();

        this.navigationBar.add(marketButton);
        this.navigationBar.add(prodCardButton);
        this.navigationBar.add(reserveButton);
        this.navigationBar.add(menuPanel);

    }

    /**
     * The pre-game mode corresponds to the initial connection and setting phase.
     */
    public void preGameMode(){

        ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
        Image image=icon.getImage();
        background = new PBackground(image);
        this.repaint();
        background.setLayout(null);
        this.add(background);


        // Prepare the body container
        container = new PanelContainer();
        container.setBounds(230,170, 700, 400);
        background.add(container);

        this.setVisible(true);
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

        gameboardPanel = new GameboardPanel(gui);
        gameboardPanel.setBounds(0, 0, 800, 572);
        mainPanel.add(gameboardPanel);
        serverMessagePanel = new ServerMessagePanel();
        serverMessagePanel.setBounds(800, 0, 380, 275);
        mainPanel.add(serverMessagePanel);
        leaderCardsPanel = new LeaderCardsPanel(gui);
        leaderCardsPanel.setBounds(805, 280, leaderWidth, leaderHeight);
        //leaderCardsPanel.setBackground(Color.BLUE);
        //leaderCardsPanel.setOpaque(true);
        mainPanel.add(leaderCardsPanel);


        this.setVisible(false);
    }



    /**
     * Apply changes to a component
     * @param component The component
     */
    @Override
    protected void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }


    /**
     * Flush the components inside a frame
     * @param frame     The frame
     */
    @Override
    protected void clear(JFrame frame){
        frame.getContentPane().removeAll();
    }


    /**
     * Flush the components inside a panel
     * @param panel     The panel
     */
    @Override
    protected void clear(JPanel panel){
        panel.removeAll();
    }

    /**
     * This method displays a new Jlabel containing a server message at the beginning of the game.
     * @param message
     */
    @Override
    public void showLabel(Message message){

            clear(container);
            container.setLayout(new FlowLayout());
            errorLabel = new JLabel(message.toString());
            container.add(errorLabel);
            errorLabel.setLocation(475,108);
            errorLabel.setSize(100,100);
            applyChangesTo(container);


    }


    /**
     * At the beginning of the match this method shows the resources the player can choose.
     */
    @Override
    public void askInitResource()  {

            clear(container);

            if (gui.getViewController().getGame().getPosition()!=1)
            {
                ResourceManager resourceManager = new ResourceManager(container,gui);
                resourceManager.setHeading("if you are the second or the third player, you have to choose only one, instead two resources like and the fourth player:");
                resourceManager.showWhatToChoose(true);
            }
            else
            {

                container.setLayout(new FlowLayout());
                errorLabel = new JLabel("sorry, you are the first player, take a nap");
                errorLabel.setBackground(Color.WHITE);
                errorLabel.setOpaque(true);
                container.add(errorLabel);
                errorLabel.setLocation(475,108);
                errorLabel.setSize(100,100);
                (new Thread(() -> {
                    try {
                        gui.notifyObserver(new EndOfTurnMessage());
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                })).start();
                gui.switchToGameMode();
            }

            applyChangesTo(container);
    }

    /**
     * This method is not called int multi-player matches.
     * @param string
     */
    @Override
    public void showLorenzoActionPopUp(String string) {

    }

    /**
     * This method is not called int multi-player matches.
     * @param i
     */
    @Override
    public void updateLorenzoIndicator(int i) {

    }

    /**
     * This method enables the end-turn button by calling the same method in the GameboardPanel.
     */
    @Override
    public void enableEndTurnButton() {
        gameboardPanel.enableEndTurnButton();
    }

    /**
     * This method disables the end-turn button by calling the same method in the GameboardPanel instance.
     */
    @Override
    public void disableEndTurnButton() {
        gameboardPanel.disableEndTurnButton();
    }

    /**
     * This method enables the end-turn button by calling the same method in the GameboardPanel instance.
     */
    @Override
    public void activateEndOfProductionButton() {
        gameboardPanel.enableEndOfProductionButton();
    }

    /**
     * This method enables the base-production button by calling the same method in the GameboardPanel instance.
     */
    @Override
    public void enableBaseProductionButton() {
        gameboardPanel.enableBaseProductionButton();
    }

    /**
     * This method disables the end-production button by calling the same method in the GameboardPanel instance.
     */
    @Override
    public void disableEndOfProductionButton() {
        gameboardPanel.disableEndOfProductionButton();
    }

    /**
     * This method returns the overall number of activated leader cards.
     * @return
     */
    @Override
    public int howManyActivated(){
        return (gameboardPanel.howManyActivated() + leaderCardsPanel.howManyActivated());
    }

    /**
     * This method returns the overall number of activated productions.
     * @return
     */
    @Override
    public int howManyActivatedExceptBaseProduction(){
        return (gameboardPanel.howManyActivatedExceptBaseProduction() + leaderCardsPanel.howManyActivated());
    }

    /**
     * Every time a player starts the turn it is notified on the turn panel.
     * @param nick
     */
    public void setCurrentPlayer(String nick) {

        for (int i = 0; i < nicknames.size(); i++)
            if (nicknames.get(i).getText().equals(nick)) {
                nicknames.get(i).setForeground(new Color(199, 0, 0));
                nicknames.get(i).setFont(currentPlayerFont);
            }else{

                nicknames.get(i).setForeground(Color.BLACK);
                nicknames.get(i).setFont(notCurrentPlayerFont);
            }

    }

    /**
     * At the beginning of the match every player is set in the navigation bar.
     * @param players
     */
    public void setPlayers(ArrayList<String> players) {
        this.players = new ArrayList<>();
        this.nicknames = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).equals(gui.getViewController().getNickName())){
                JMenuItem newPlayerItem = new JMenuItem(players.get(i));
                newPlayerItem.addActionListener(new OpponentItemListener(gui.getViewController(),i));
                this.players.add(newPlayerItem);
            }
            this.nicknames.add(new JLabel(players.get(i)));
            this.nicknames.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            this.nicknames.get(i).setVerticalAlignment(SwingConstants.CENTER);
        }
        for(int i = 0; i<this.players.size();i++){
            this.playerMenu.add(this.players.get(i));
        }
        initTurnPanel();
    }

    /**
     * This method updates the resources in the storage by calling the same method in the GameboardPanel instance.
     * @param newStorage
     */
    public void updateStorage(Map<Resource, Integer> newStorage) {

        this.gameboardPanel.updateStorage(newStorage);

    }

    /**
     * This method updates the resources in the strongbox by calling the same method in the GameboardPanel instance.
     * @param map
     */
    public void updateStrongBox(Map<Resource,Integer> map){
        this.gameboardPanel.updateStrongBox(map);
    }

    /**
     * This method updates lorenzo's indicator by calling the same method in the GameboardPanel instance.
     * @param i
     */
    public void updateFaith(int i){
        this.gameboardPanel.faithPathPane.updateIndicator(i);
    }

    /**
     * This method initialise the leader card panel by calling th same method in LeaderCardsPanel instance.
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
     * This method discards the indicated leader card by calling th same method in the GameboardPanel instance.
     * @param bool
     */
    public void discardLeader(int bool){
        this.leaderCardsPanel.discardLeaderCard(bool);
    }

    /**
     * This method updates the production card spaces by calling th same method in the GameboardPanel instance.
     * @param gameboardListNotification
     */
    public void updateProductionCard(GameboardListNotification gameboardListNotification){
        this.gameboardPanel.updateProductionSpaces(gameboardListNotification);
    }

    /**
     * When a player press a production card deck button the put card mode is set.
     */
    @Override
    public void putCardMode() {
        gameboardPanel.putCardMode();
        leaderCardsPanel.disableProductionButtons();
    }

    /**
     * This method sets the production deck number chosen by the player by calling th same method in the GameboardPanel
     * instance.
     * @param n
     */
    @Override
    public void setChosenDeckNumber(int n) {
        gameboardPanel.setChosenDeckNumber(n);
    }

    /**
     * This method disables all the production buttons by calling the same method in the GameboardPanel and LeaderCardspanel
     * instances.
     */
    @Override
    public void disableProductionButtons() {
        gameboardPanel.disableProductionButtons();
        leaderCardsPanel.disableProductionButtons();
    }

    /**
     * This method enables all the production buttons by calling the same method in the GameboardPanel and LeaderCardspanel
     * instances and by disabling the endProduction and endTurn buttons.
     */
    @Override
    public void enableProductionButtons() {
        gameboardPanel.disableEndTurnButton();
        gameboardPanel.disableEndOfProductionButton();
        gameboardPanel.enableProductionButtons();
        leaderCardsPanel.enableProductionButtons();
    }

    /**
     * This method adds the current papal card by calling the same method in the Gameboardpanel instance.
     * @param i
     */
    public void givePapalCard(int i){
        this.gameboardPanel.givePapalcard(i);
    }

    /**
     * This method removes the current papal card by calling the same method in the Gameboardpanel instance.
     * @param i
     */
    public void removePapalCard(int i){
        this.gameboardPanel.removePapalCard(i);
    }

    /*public void showAllOfPlayer(ShowAllOfPlayerMessage msg){
        gameboardPanel.showAllOfPlayer(msg);

    }*/



}
