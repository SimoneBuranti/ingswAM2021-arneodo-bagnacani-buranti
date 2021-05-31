package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.ligtModelNotification.GameboardListNotification;
import it.polimi.ingsw.client.view.gui.*;
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


    public MainFrameMultiPlayer(Gui gui,String title){
        super(title,gui);
        this.gui=gui;
        SwingUtilities.invokeLater(() -> {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocation(475,208);
            this.setSize(820,420);

            this.setResizable(true);
            ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
            Image image=icon.getImage();
            JPanel background = new PBackground(image);
            this.repaint();
            background.setLayout(null);
            this.add(background);
            //mainFrame.add(errorText);

            // Prepare the body container
            container = new PanelContainer();
            container.setBounds(50,35, 700, 400);
            background.add(container);

            this.setVisible(true);

        });}

    public MainFrameMultiPlayer(Gui gui){
        super(gui);
        this.gui=gui;

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

        SwingUtilities.invokeLater(() -> {
            clear(container);

            CardManager cardManager = new CardManager(container,gui);
            cardManager.setHeading("Choose two cards:");
            cardManager.showWhatToChoose(true);

            applyChangesTo(container);
        });

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


    @Override
    public void askInitResource() throws IOException, InterruptedException {

        SwingUtilities.invokeLater(() -> {
            clear(container);

            if (gui.getViewController().getGame().getPosition()!=1)
            {
                ResourceManager resourceManager = new ResourceManager(container,gui);
                resourceManager.setHeading("Choose two cards:");
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
            }

            applyChangesTo(container);
        });
    }

    @Override
    public void showLorenzoActionPopUp(String string) {

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
    public void activateLeader(int arrayList, int bool){
        this.leaderCardsPanel.activatedLeaderCard(arrayList,bool);
    }
    public void discardLeader(int bool){
        this.leaderCardsPanel.discardLeaderCard(bool);
    }

    public void updateProductionCard(GameboardListNotification gameboardListNotification){
        this.gameboardPanel.updateProductionSpaces(gameboardListNotification);
    }

    @Override
    public void putCardMode(int deckKey) {
        gameboardPanel.putCardMode(deckKey);
    }

    public void callForCouncil(int i){
        this.gameboardPanel.givePapalcard(i);
    }

    public void showAllOfPlayer(ShowAllOfPlayerMessage msg){
        gameboardPanel.showAllOfPlayer(msg);

    }



}
