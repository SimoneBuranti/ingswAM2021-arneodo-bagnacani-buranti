package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.gui.*;
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

    private Gui gui;
    private PanelContainer container;
    private JLabel errorLabel;
    private GameboardPanel gameboardPanel;

    private Font currentPlayerFont = new Font("Helvetica", Font.BOLD, 22);
    private JPanel menuPanel;
    private JMenuBar menuBar;
    private JMenu playerMenu;
    private JPanel turnPanel;
    private ArrayList<JMenuItem> players;
    private ArrayList<JLabel> nicknames;


    public MainFrameMultiPlayer(Gui gui,String title) {
        super(title, gui);
        this.gui = gui;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(475, 208);
        this.setSize(820, 420);

        this.setResizable(true);
        ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
        Image image = icon.getImage();
        JPanel background = new PBackground(image);
        this.repaint();
        background.setLayout(null);
        this.add(background);
        //mainFrame.add(errorText);

        // Prepare the body container
        container = new PanelContainer();
        container.setBounds(50, 35, 700, 400);
        background.add(container);

        this.setVisible(true);
    }

    public MainFrameMultiPlayer(Gui gui){
        super(gui);
        this.gui=gui;

        initGameMode();
    }



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
        turnPanelWidth *= letterOffset;
        turnPanel.setPreferredSize(new Dimension(turnPanelWidth, buttonHeight));

        blankLabels = new JLabel[2];
        for (int i = 0; i < blankLabels.length; i++) {
            blankLabels[i] = new JLabel();
            blankLabels[i].setPreferredSize(new Dimension(80, buttonHeight));
            navigationBar.add(blankLabels[i]);
        }

        this.navigationBar.add(turnPanel);
    }


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
        this.add(navigationBar, BorderLayout.NORTH);

        //---------------
        /*JPanel random = new JPanel();
        random.setBackground(Color.RED);
        random.setPreferredSize(new Dimension(buttonHeight,buttonHeight));
        random.setBorder(BorderFactory.createBevelBorder(0));*/
    }


    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {


            clear(container);

            CardManager cardManager = new CardManager(container,gui);
            cardManager.setHeading("Choose two cards:");
            cardManager.showWhatToChoose(true);

            applyChangesTo(container);
    }


    public void initGameMode() {
        for (JPanel p : attached) {
            mainPanel.remove(p);
        }
        setGeneralFeatures();
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


    @Override
    public void askInitResource()  {

            clear(container);

            if (gui.getViewController().getGame().getPosition()!=1)
            {
                ResourceManager resourceManager = new ResourceManager(container,gui);
                resourceManager.setHeading("if you are the second player, you have to choose only one, instead two resource like the third and the fourth player:");
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
                gui.powerToMainFrame();
            }

            applyChangesTo(container);
    }

    @Override
    public void showLorenzoActionPopUp(String string) {

    }

    @Override
    public void updateLorenzoIndicator(int i) {

    }

    @Override
    public void enableEndTurnButton() {
        gameboardPanel.enableEndTurnButton();
    }

    @Override
    public void disableEndTurnButton() {
        gameboardPanel.disableEndTurnButton();
    }

    @Override
    public void activateEndOfProductionButton() {
        gameboardPanel.enableEndOfProductionButton();
    }

    @Override
    public void enableBaseProductionButton() {
        gameboardPanel.enableBaseProductionButton();
    }

    @Override
    public void disableEndOfProductionButton() {
        gameboardPanel.disableEndOfProductionButton();
    }

    @Override
    public int howManyActivated(){
        return (gameboardPanel.howManyActivated() + leaderCardsPanel.howManyActivated());
    }


    public void setCurrentPlayer(String nick) {

        for (int i = 0; i < nicknames.size(); i++)
            if (nicknames.get(i).getText().equals(nick)) {
                nicknames.get(i).setForeground(new Color(199, 0, 0));
                nicknames.get(i).setFont(currentPlayerFont);
            }

    }
    public void setPlayers(ArrayList<String> players) {
        this.players = new ArrayList<>();
        this.nicknames = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {

            this.players.add(new JMenuItem(players.get(i)));
            this.playerMenu.add(this.players.get(i));
            this.nicknames.add(new JLabel(players.get(i)));
            this.nicknames.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            this.nicknames.get(i).setVerticalAlignment(SwingConstants.CENTER);
        }
        initTurnPanel();
    }

    public void updateStorage(Map<Resource, Integer> newStorage) {

        this.gameboardPanel.updateStorage(newStorage);

    }

    public void getStrongBox(Map<Resource,Integer> map){
        this.gameboardPanel.strongboxPanel.updateStrongBox(map);

    }

    public void updateFaith(int i){
        this.gameboardPanel.faithPathPane.updateIndicator(i);

    }

    public void initLeader(ArrayList<LeaderCard> arrayList, boolean bool){
        this.leaderCardsPanel.addLeaderCards(arrayList,bool);
    }
    public void activateLeader(int key, int index){
        this.leaderCardsPanel.activatedLeaderCard(key, index);
    }
    public void discardLeader(int bool){
        this.leaderCardsPanel.discardLeaderCard(bool);
    }

    public void updateProductionCard(GameboardListNotification gameboardListNotification){
        this.gameboardPanel.updateProductionSpaces(gameboardListNotification);
    }

    @Override
    public void putCardMode() {
        gameboardPanel.putCardMode();
    }

    @Override
    public void setChosenDeckNumber(int n) {
        gameboardPanel.setChosenDeckNumber(n);
    }

    @Override
    public void disableProductionButtons() {
        gameboardPanel.disableProductionButtons();
        leaderCardsPanel.disableProductionButtons();
    }

    @Override
    public void enableProductionButtons() {
        gameboardPanel.disableEndTurnButton();
        gameboardPanel.disableEndOfProductionButton();
        gameboardPanel.enableProductionButtons();
        leaderCardsPanel.enableProductionButtons();
    }

    public void givePapalCard(int i){
        this.gameboardPanel.givePapalcard(i);
    }

    public void removePapalCard(int i){
        this.gameboardPanel.removePapalCard(i);
    }

    public void showAllOfPlayer(ShowAllOfPlayerMessage msg){
        gameboardPanel.showAllOfPlayer(msg);

    }



}
