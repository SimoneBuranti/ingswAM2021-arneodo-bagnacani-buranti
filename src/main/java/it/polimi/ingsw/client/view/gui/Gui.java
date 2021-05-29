package it.polimi.ingsw.client.view.gui;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Gui extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;
    private RestartFrame restartFrame;
    private JFrame mainFrame;
    private PanelContainer container;

    private JButton submitButton;
    private JButton yesButton;
    private JButton noButton ;
    private JButton enterButton ;





    private JButton oneButton;
    private JButton twoButton ;
    private JButton threeButton;
    private JButton fourButton ;

    private JLabel lobbyLabel;

    private JLabel errorLabel;
    
    private int readyToSend=0;




    @Override
    public void startView() {
        SwingUtilities.invokeLater(() -> {


            mainFrame = new JFrame("Masters Of Renaissance");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocation(475,208);
            mainFrame.setSize(820,420);

            mainFrame.setResizable(true);



            ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
            Image image=icon.getImage();
            JPanel background = new PBackground(image);
          mainFrame.repaint();
            background.setLayout(null);
            mainFrame.add(background);
            //mainFrame.add(errorText);

            // Prepare the body container
            container = new PanelContainer();
            container.setBounds(0,0, 820, 420);
            background.add(container);

            mainFrame.setVisible(true);

        });}

    @Override
    public void update(String notification) throws IOException, InterruptedException { }

    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    public ViewController getViewController(){
        return this.viewController;
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException {
        SwingUtilities.invokeLater(() -> {

            clear(container);

            container.setLayout(new FlowLayout());

            submitButton= new JButton("How many players?");
            submitButton.setSize(new Dimension(300,100));

            oneButton= new JButton("1");
            oneButton.setSize(new Dimension(10,5));

            twoButton= new JButton("2");
            twoButton.setSize(new Dimension(10,5));

            threeButton= new JButton("3");
            threeButton.setSize(new Dimension(10,5));

            fourButton= new JButton("4");
            fourButton.setSize(new Dimension(10,5));

            container.add(submitButton);
            container.add(oneButton);
            container.add(twoButton);
            container.add(threeButton);
            container.add(fourButton);


            this.oneButton.addActionListener(eONe -> {
                sendNumberPlayersResponse(1);});
            this.twoButton.addActionListener(eNO -> {
                sendNumberPlayersResponse(2);});
            this.threeButton.addActionListener(eYES -> {
                sendNumberPlayersResponse(3);});
            this.fourButton.addActionListener(eNO -> {
                sendNumberPlayersResponse(4);});

            applyChangesTo(container);
        }); }

    public void sendNumberPlayersResponse(int n){
        try {
            notifyObserver(new NumberPlayerMessage(n)); }
        catch (IOException | InterruptedException ioException) { ioException.printStackTrace();}
        if(n > 1)
            showLabel();
    }


    public void showLabel(){
        SwingUtilities.invokeLater(() -> {

            clear(container);
            container.setLayout(new FlowLayout());
            lobbyLabel = new JLabel("Please wait for the missing players to start the game...");
            container.add(lobbyLabel);
            applyChangesTo(container);
        });
    }

    @Override
    public void askNickname() throws IOException, InterruptedException {
        SwingUtilities.invokeLater(() -> {
            //clear(container);


            container.setLayout(new FlowLayout());

            TextField textField= new TextField();
            textField.setText("");
            textField.setEditable(true);
            textField.setPreferredSize(new Dimension(100,20));

            enterButton= new JButton("enter");
            enterButton.setSize(new Dimension(50,20));

            container.add(enterButton);
            container.add(textField);

            this.enterButton.addActionListener(eENTER->(new Thread(() -> {
                String nickname = textField.getText();
                if(nickname.length() > 0){
                    try {
                        container.remove(textField);
                        container.remove(enterButton);
                        notifyObserver(new UsernameMessage(nickname));
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();
                    }
                }
            })).start());

            applyChangesTo(container);
        });}



    @Override
    public void askRestartGame() throws IOException, InterruptedException {
        SwingUtilities.invokeLater(() -> {

            clear(container);

            container.setLayout(new FlowLayout());
            submitButton= new JButton("Do you want restart the previous match?");
            submitButton.setSize(new Dimension(200,100));

            yesButton= new JButton("yes");
            yesButton.setSize(new Dimension(50,10));


                noButton= new JButton("no");
            noButton.setSize(new Dimension(50,10));
            container.add(submitButton);
            container.add(noButton);
            container.add(yesButton);
            this.yesButton.addActionListener(eYES -> {
                    try {
                        container.remove(yesButton);
                        container.remove(submitButton);
                        container.remove(noButton);
                        notifyObserver(new RestartAnswerMessage(true));
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();}});
               this.noButton.addActionListener(eNO -> {
                    try {
                        container.remove(yesButton);
                        container.remove(submitButton);
                        container.remove(noButton);
                        notifyObserver(new RestartAnswerMessage(false));
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace(); }});
            applyChangesTo(container);
        });


    }



    @Override
    public void showChangeCurrent(String currentNick) {
        /// messaggi pergamena

    }

    @Override
    public void yourTurn() {
        /// messaggi pergamena

    }

    @Override
    public void notifyError(Message msg) {


        // differenzio errori
        showLabel(msg);
        /*if (msg.getMessageType().equals(MessageType.NICKNAMENOTFOUNDERROR) || msg.getMessageType().equals(MessageType.NICKNAMENOTFOUNDERROR) ) {
            try {
                askNickname();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }

    @Override
    public void showPlayersOrder(ArrayList<String> nickName) {
        // lascio a simo


    }

    @Override
    public void showLastTurn(String nickName) {
        // pergamena

    }


    @Override
    public void showLobby(int playersInLobby, int playerInGame) {
        SwingUtilities.invokeLater(() -> {

            clear(container);
            container.setLayout(new FlowLayout());

            lobbyLabel = new JLabel("There are " + playersInLobby + " players in the lobby out of " + playerInGame +", waiting for the missing players to start the game...");


            container.add(lobbyLabel);

            mainFrame.setVisible(true);
            applyChangesTo(container);
        });
    }

    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {

        SwingUtilities.invokeLater(() -> {
            clear(container);

            CardManager cardManager = new CardManager(container,this);
            cardManager.setHeading("Choose two cards:");
            cardManager.showWhatToChoose(true);

            applyChangesTo(container);
        });



    }

    @Override
    public void showCallForCouncil(String nickname, int papalCard) {
        // fatto su gameboard

    }

    @Override
    public void showStartGame() {}

    @Override
    public void showRestartMessage() {
        // initial ask name
    }

    @Override
    public void showPlayerInfo(ShowAllOfPlayerMessage msg) {
        // new frame
    }

    @Override
    public void askInitResource() throws IOException, InterruptedException {

        SwingUtilities.invokeLater(() -> {
            clear(container);

            if (this.getViewController().getGame().getPosition()!=1)
            {
                ResourceManager resourceManager = new ResourceManager(container,this);
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
        });}

    @Override
    public void showGameBoardProductionCards(ProductionCard[][] productionCards) {}

    @Override
    public void showMarketGrid(Marble[][] grid) {}

    @Override
    public void showMarketExtra(Marble extra) { }

    @Override
    public void showFaithIndicator(int pos) {
        // presente

    }

    @Override
    public void showDeckProductionCards(ArrayList<ProductionCard> productionCards) {
        // new frame

    }

    @Override
    public void showGameBoardOfPlayer() {
        // presente

    }

    @Override
    public void showProductionDecks() {
        // presente

    }

    @Override
    public void showReserve() {
        // new frame

    }

    @Override
    public void showMarket() {
        // new frame market

    }

    @Override
    public void showWhiteMarbleResources(int n, ArrayList<Resource> whiteMarbleResourceTypes) {
        // pop up

    }

    @Override
    public void showSpaceError(NotEnoughSpaceErrorMessage msg) {
        // pop up

    }

    @Override
    public void checkThreadRestart() {
        // nothing

    }

    @Override
    public void showActionMarker(String actionType) {
        // fa simo

    }

    @Override
    public void youWin(int score) {
        // pop up

    }

    @Override
    public void lorenzoWin() {
        // pop up

    }

    @Override
    public void showWinner(String nickname) {
        // pop up

    }

    @Override
    public void showOpponentAction(Message msg) {
        // pergamena

    }

    @Override
    public void sayDisconnect() {
        // pop up

    }

    @Override
    public void visit(DeckListNotification deckListNotification) {
        // metodi relativi a classe


    }

    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(LeaderListCardNotification leaderListCardNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(StorageNotification storageNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(ReserveNotification reserveNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(MarketNotification marketNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        // metodi relativi a classe

    }

    @Override
    public void visit(FaithPathNotification faithPathNotification) {
        // metodi relativi a classe

    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getYesButton() {
        return yesButton;
    }

    public JButton getNoButton() {
        return noButton;
    }


    /**
     * Apply changes to a component
     * @param component The component
     */
    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }


    /**
     * Flush the components inside a frame
     * @param frame     The frame
     */
    private void clear(JFrame frame){
        frame.getContentPane().removeAll();
    }


    /**
     * Flush the components inside a panel
     * @param panel     The panel
     */
    private void clear(JPanel panel){
        panel.removeAll();
    }


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


    public void setReadyToSend() {
        this.readyToSend++;
    }
    
    
    public int getReadyToSend() {
        return readyToSend;

   /* public void printCards(List<LeaderCard> chosenCards, int numCards) {
        if (numCards == chosenCards.size()) {
           /* (new Thread(() -> {
                showLoading();
                serverHandler.sendGameCards(chosenCards);
            })).start();
        } else {
            SwingUtilities.invokeLater(() -> {
                clear(bodyContainer);

                CardManager cardSwitcher= new CardManager(bodyContainer,this);
                cardSwitcher.setHeading("Choose " + (numCards - chosenCards.size()) + " card" + (numCards - chosenCards.size() > 1 ? "s" : "") + " between these:");
                cardSwitcher.showSwitcher(chosenCards,numCards);
                cardSwitcher.showCardDetails();

                applyChangesTo(bodyContainer);
            });
        }
    }*/

    }public void showLoading () {
    }}
