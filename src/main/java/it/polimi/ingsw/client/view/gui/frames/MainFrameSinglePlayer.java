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


    private final static int actionPanelWidth = 305;
    private final static int actionPanelHeight = 150;

    private PanelContainer container;
    protected ActionMarkerPanel actionMarkerPanel;
    private JLabel errorLabel;
    private Gui gui;

    private LorenzoGameboardPanel lorenzoGameboardPanel;
    private int readyToSend=0;

    public MainFrameSinglePlayer(Gui gui){
        super(gui);
        this.gui=gui;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGameMode();
    }

    public MainFrameSinglePlayer(Gui gui,String title){
        super(title,gui);
        this.gui=gui;

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

        this.navigationBar.add(marketButton);
        this.navigationBar.add(prodCardButton);
        this.navigationBar.add(reserveButton);
        this.add(navigationBar, BorderLayout.NORTH);

        //---------------
        /*JPanel random = new JPanel();
        random.setBackground(Color.RED);
        random.setPreferredSize(new Dimension(buttonHeight,buttonHeight));
        random.setBorder(BorderFactory.createBevelBorder(0));*/
    }

    public void updateStorage(Map<Resource, Integer> newStorage) {
        this.lorenzoGameboardPanel.updateStorage(newStorage);

    }

    public void initGameMode() {
        for (JPanel p : attached) {
            mainPanel.remove(p);
        }
        //setGeneralFeatures();
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
        //leaderCardsPanel.setBackground(Color.BLUE);
        //leaderCardsPanel.setOpaque(true);
        mainPanel.add(leaderCardsPanel);

        actionMarkerPanel = new ActionMarkerPanel();


        this.setVisible(false);
    }



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

    @Override
    public void updateLorenzoIndicator(int i) {
        lorenzoGameboardPanel.updateLorenzoIndicator(i);
    }

    @Override
    public void enableEndTurnButton() {
        lorenzoGameboardPanel.enableEndTurnButton();
    }

    @Override
    public void disableEndTurnButton() {
        lorenzoGameboardPanel.disableEndTurnButton();
    }

    @Override
    public void activateEndOfProductionButton() {
        lorenzoGameboardPanel.enableEndOfProductionButton();
    }

    @Override
    public void enableBaseProductionButton() {
        lorenzoGameboardPanel.enableBaseProductionButton();
    }

    @Override
    public void disableEndOfProductionButton() {
        lorenzoGameboardPanel.disableEndOfProductionButton();
    }


    @Override
    public void disableProductionButtons() {
        lorenzoGameboardPanel.disableProductionButtons();
        leaderCardsPanel.disableProductionButtons();
    }

    @Override
    public void enableProductionButtons() {
        lorenzoGameboardPanel.disableEndTurnButton();
        lorenzoGameboardPanel.disableEndOfProductionButton();
        lorenzoGameboardPanel.enableProductionButtons();
        leaderCardsPanel.enableProductionButtons();
    }


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
    public void askInitResource() {
        (new Thread(() -> {
            try {
                gui.notifyObserver(new EndOfTurnMessage());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        })).start();
        gui.powerToMainFrame();
    }

    public void getStrongBox(Map<Resource,Integer> map){
        this.lorenzoGameboardPanel.updateStrongBox(map);

    }

    public void updateFaith(int i){
        this.lorenzoGameboardPanel.faithPathPane.updateIndicator(i);


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
        this.lorenzoGameboardPanel.updateProductionSpaces(gameboardListNotification);
    }

    @Override
    public void setChosenDeckNumber(int n) {
        lorenzoGameboardPanel.setChosenDeckNumber(n);
    }

    @Override
    public void putCardMode() {
        lorenzoGameboardPanel.putCardMode();
        leaderCardsPanel.disableProductionButtons();
    }

    public void givePapalCard(int i){
        this.lorenzoGameboardPanel.givePapalcard(i);
    }

    public void removePapalCard(int i){
        this.lorenzoGameboardPanel.removePapalCard(i);
    }

    @Override
    public int howManyActivated(){
        return (lorenzoGameboardPanel.howManyActivated() + leaderCardsPanel.howManyActivated());
    }

}
