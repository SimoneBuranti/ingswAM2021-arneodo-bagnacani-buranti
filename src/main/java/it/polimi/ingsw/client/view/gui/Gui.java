package it.polimi.ingsw.client.view.gui;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.client.view.gui.frames.*;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardStorage;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the GUI and it implements view interface.
 * It changes the frame when it receives updates from the light model or messages from the server
 */
public class Gui extends ViewControllerObservable implements View, NotificatorVisitor {

    /**
     * This attribute represents the width of the frame
     */
    public static final int initFrameWidth = 700;
    /**
     * This attribute represents the height of the frame
     */
    public static final int initFrameHeight = 420;
    /**
     * This attribute represents the position of the frame
     */
    public static final int initFrameX = 450;
    /**
     * This attribute represents the position of the frame
     */
    public static final int initFrameY = 208;

    /**
     * This attribute represents the controller of the view
     */
    private ViewController viewController;

    /**
     * This attribute represents the initial frame
     */
    private JFrame mainFrame;
    /**
     * This attribute is the component container of the mainFrame
     */
    private PanelContainer container;

    /**
     * This attribute is a button with "yes" text
     */
    private JButton yesButton;
    /**
     * This attribute is a button with "no" text
     */
    private JButton noButton ;
    /**
     * This attribute is a button with "enter" text
     */
    private JButton enterButton ;

    /**
     * This attribute represents the frame of the game
     */
    private MainFrame mainFrameOfGame;

    /**
     * This attribute is true if the game is multiplayer
     */
    private Boolean isMultiOrNot;

    /**
     * This attribute contains the frames of opponent players
     */
    protected PlayerInformationFrames[] playerInformationFrames;

    /**
     * This attribute is a button with "1" text
     */
    private JButton oneButton;
    /**
     * This attribute is a button with "2" text
     */
    private JButton twoButton ;
    /**
     * This attribute is a button with "3" text
     */
    private JButton threeButton;
    /**
     * This attribute is a button with "4" text
     */
    private JButton fourButton ;

    /**
     * This attribute contains a lobby message
     */
    private JLabel lobbyLabel;

    /**
     * This attribute contains an error message
     */
    private JLabel errorLabel;

    /**
     * This attribute contains a value to check if the listener is ready to send a message to the server
     */
    private int readyToSend=0;

    /**
     * This attribute is true if the player wants to resume the game
     */
    private boolean chosenResumeGame;

    /**
     * This attribute is true if the player has made an action
     */
    private boolean isActionDoneMode;

    /**
     * This attribute is true if the player has yet to choose the initial leader cards and the initial resources
     */
    private boolean isRestartMode = false;


    /**
     * This method sets the initial frame
     */
    @Override
    public void startView() {
        SwingUtilities.invokeLater(() -> {

            mainFrame = new JFrame("Masters Of Renaissance");
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.setLocation(450,208);
            mainFrame.setSize(820,420);

            mainFrame.setResizable(true);



            ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
            Image image=icon.getImage();
            JPanel background = new PBackground(image);
            mainFrame.repaint();
            background.setLayout(null);
            mainFrame.add(background);

            // Prepare the body container
            container = new PanelContainer();
            container.setBounds(0,0, 820, 420);
            background.add(container);

            mainFrame.setVisible(true);

        });
    }

    /**
     * This method deserializes the light model notification
     */
    @Override
    public void update(String notification) throws IOException, InterruptedException {
        Notification parsedMsg = Notification.deserialize(notification);
        parsedMsg.accept(this);
    }

    /**
     * This method sets the viewController attribute and adds it to the observers
     * @param viewController : the cli observer
     */
    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    /**
     * @return the controller of the view
     */
    public ViewController getViewController(){
        return this.viewController;
    }

    /**
     * This method asks the player how many he wants to play with by showing the right components in the frame and notifies the observer
     * of the player's response
     */
    @Override
    public void askNumberOfPlayers(){
        SwingUtilities.invokeLater(() -> {

            clear(container);

            container.setLayout(new FlowLayout());

            JLabel questionLabel= new JLabel("How many players?");
            questionLabel.setOpaque(true);
            questionLabel.setBackground(Color.WHITE);
            questionLabel.setBorder(BorderFactory.createBevelBorder(0));

            oneButton= new JButton("1");
            oneButton.setSize(new Dimension(10,5));

            twoButton= new JButton("2");
            twoButton.setSize(new Dimension(10,5));

            threeButton= new JButton("3");
            threeButton.setSize(new Dimension(10,5));

            fourButton= new JButton("4");
            fourButton.setSize(new Dimension(10,5));

            container.add(questionLabel);
            container.add(oneButton);
            container.add(twoButton);
            container.add(threeButton);
            container.add(fourButton);


            this.oneButton.addActionListener(eONe -> {
                (new Thread(() -> {
                    sendNumberPlayersResponse(1);
                })).start();

            });
            this.twoButton.addActionListener(eNO -> {
                (new Thread(() -> {
                    sendNumberPlayersResponse(2);
                })).start();
            });
            this.threeButton.addActionListener(eYES -> {
                (new Thread(() -> {
                    sendNumberPlayersResponse(3);
                })).start();
            });
            this.fourButton.addActionListener(eNO -> {
                (new Thread(() -> {
                    sendNumberPlayersResponse(4);
                })).start();
                });
            applyChangesTo(container);
        });
    }

    /**
     * This method sends the response of the previous question to the observer
     * @param n : the number of players
     */
    public void sendNumberPlayersResponse(int n){
        try {
            notifyObserver(new NumberPlayerMessage(n)); }
        catch (IOException | InterruptedException ioException) { ioException.printStackTrace();}
        if(n > 1)
            showLabel();
    }


    /**
     * This method shows the player to wait for the other players
     */
    public void showLabel(){
        SwingUtilities.invokeLater(() -> {

            clear(container);
            container.setLayout(new FlowLayout());
            lobbyLabel = new JLabel("Please wait for the missing players to start the game...");
            lobbyLabel.setOpaque(true);
            lobbyLabel.setBackground(Color.WHITE);
            lobbyLabel.setBorder(BorderFactory.createBevelBorder(0));
            container.add(lobbyLabel);
            applyChangesTo(container);
        });
    }

    /**
     * This method asks the player its username by showing the right components in the frame and notifies the observer
     * of the player's response
     */
    @Override
    public void askNickname(){
        SwingUtilities.invokeLater(() -> {
            //clear(container);


            container.setLayout(new FlowLayout());

            if (chosenResumeGame){
                JLabel adviceLabel = new JLabel("Insert your previous nickname to resume the match");
                adviceLabel.setOpaque(true);
                adviceLabel.setBackground(Color.WHITE);
                adviceLabel.setBorder(BorderFactory.createBevelBorder(0));
                container.add(adviceLabel);
            }

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
                        container.remove(textField);
                        container.remove(enterButton);
                        this.viewController.setNickName(nickname);
                    (new Thread(() -> {
                        sendUsernameResponse(nickname);
                    })).start();
                }
            })).start());

            applyChangesTo(container);
        });
    }

    /**
     * This method sends the response of the previous question to the observer
     * @param nickname : the player's username
     */
    public void sendUsernameResponse(String nickname){
        try {
            notifyObserver(new UsernameMessage(nickname));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method asks the player if he wants to resume the game by showing the right components in the frame
     * and notifies the observer of the player's response
     */
    @Override
    public void askRestartGame(){
        SwingUtilities.invokeLater(() -> {

            clear(container);

            container.setLayout(new FlowLayout());
            JLabel restartQuestion = new JLabel("Do you want restart the previous match?");
            restartQuestion.setOpaque(true);
            restartQuestion.setBackground(Color.WHITE);
            restartQuestion.setBorder(BorderFactory.createBevelBorder(0));

            yesButton= new JButton("yes");
            yesButton.setSize(new Dimension(50,10));


            noButton= new JButton("no");
            noButton.setSize(new Dimension(50,10));
            container.add(restartQuestion);
            container.add(noButton);
            container.add(yesButton);
            this.yesButton.addActionListener(eYES -> {

                        container.remove(yesButton);
                        container.remove(restartQuestion);
                        container.remove(noButton);
                        chosenResumeGame = true;
                (new Thread(() -> {
                    sendRestartResponse(true);
                })).start();

                   });
               this.noButton.addActionListener(eNO -> {

                        container.remove(yesButton);
                        container.remove(restartQuestion);
                        container.remove(noButton);
                        chosenResumeGame = false;
                           (new Thread(() -> {
                               sendRestartResponse(false);
                           })).start();}

                   );
            applyChangesTo(container);
        });


    }

    /**
     * This method sends the response of the previous question to the observer
     * @param bool : true if the player wants to resume the previous game
     */
    public void sendRestartResponse(boolean bool){
        try {
            notifyObserver(new RestartAnswerMessage(bool));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * This method shows the current player
     */
    @Override
    public void showChangeCurrent(String currentNick) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.setCurrentPlayer(currentNick);
            mainFrameOfGame.refreshMessagePanel();
            disableAllButtons();
            applyChangesTo(mainFrameOfGame);

        });
    }

    /**
     * This method switch the frame from pre game mode to game mode
     */
    public void switchToGameMode(){
            if (!mainFrameOfGame.isBackGroundNull()) {
                mainFrameOfGame.switchToGameMode();
                mainFrameOfGame.paintComponents(mainFrameOfGame.getGraphics());
                mainFrameOfGame.paintComponents(mainFrameOfGame.getGraphics());
            }
    }

    /**
     * This method shows the current player and enables all the player's buttons
     */
    @Override
    public void yourTurn() {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.setCurrentPlayer(viewController.getNickName());
            enableAllAction();
            mainFrameOfGame.refreshMessagePanel();
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows an error message
     */
    @Override
    public void notifyError(Message msg) {

        if (msg instanceof NoNicknameMessage || msg instanceof BootingLobbyErrorMessage
                || msg instanceof AlreadyExistingNickNameErrorMessage || msg instanceof CompleteRunningMatchErrorMessage
                || msg instanceof GameEndedMessage){
            SwingUtilities.invokeLater(() -> {
                showLabel(msg.toString());
                applyChangesTo(mainFrame);
            });
        }else {
            SwingUtilities.invokeLater(() -> {

                mainFrameOfGame.displayString(msg.toString());

                if (msg instanceof NotAvailableResourcesErrorMessage) {
                    enableAllAction();
                }

                if (msg instanceof WrongColumnErrorMessage) {
                    mainFrameOfGame.putCardMode();
                }

                if (msg instanceof RequirementsErrorMessage) {
                    mainFrameOfGame.enableLeaderButtons();
                }

                if (msg instanceof BaseProductionErrorMessage) {
                    mainFrameOfGame.enableBaseProductionButton();
                    if (howManyActivated() < 2)
                        enableAllAction();
                }
                applyChangesTo(mainFrameOfGame);

            });
        }

    }

    /**
     * This method shows the players round
     */
    @Override
    public void showPlayersOrder(ArrayList<String> nickName) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.setPlayers(nickName);
            applyChangesTo(mainFrameOfGame);
            this.playerInformationFrames = new PlayerInformationFrames[nickName.size()];
            for ( int i=0;i<nickName.size();i++){
                playerInformationFrames[i] = new PlayerInformationFrames(nickName.get(i));
            }
        });

    }

    /**
     * This method shows the last turn message
     */
    @Override
    public void showLastTurn(String nickName) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.displayString("last turn ");
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the server lobby
     * @param playersInLobby : the actual number of players
     * @param playerInGame : the number of players of the game
     */
    @Override
    public void showLobby(int playersInLobby, int playerInGame) {
        SwingUtilities.invokeLater(() -> {

            clear(container);
            container.setLayout(new FlowLayout());

            lobbyLabel = new JLabel("There are " + playersInLobby + " players in the lobby out of " + playerInGame +", waiting for the missing players to start the game...");
            lobbyLabel.setOpaque(true);
            lobbyLabel.setBackground(Color.WHITE);
            lobbyLabel.setBorder(BorderFactory.createBevelBorder(0));

            container.add(lobbyLabel);

            mainFrame.setVisible(true);
            applyChangesTo(container);
        });
    }

    /**
     * This method asks the player to choose two leader cards
     */
    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) {
        SwingUtilities.invokeLater(() -> {
            try {
                mainFrameOfGame.askLeaderCardToKeep(leaderCards);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * This method shows the call for council message and gives to the player the papal card if he got it
     * @param nickname : the name of the player who activated the papal card
     * @param papalCard : the value of the current papal card
     */
    @Override
    public void showCallForCouncil(String nickname, int papalCard) {
        SwingUtilities.invokeLater(() -> {
            if (papalCard==1)
                mainFrameOfGame.givePapalCard(viewController.getGame().getGameBoardOfPlayer().getCurrCall()-1);
            else
                mainFrameOfGame.removePapalCard(viewController.getGame().getGameBoardOfPlayer().getCurrCall()-1);
            applyChangesTo(mainFrameOfGame);

        });


    }

    /**
     * This method initialises the game frame
     */
    @Override
    public void showStartGame(GameTypeMessage msg) {
        SwingUtilities.invokeLater(() -> {

            mainFrame.dispose();
            if (msg.isMultiOrNot()) {
                mainFrameOfGame = new MainFrameMultiPlayer(this);
            } else {
                mainFrameOfGame = new MainFrameSinglePlayer(this);
            }

            isMultiOrNot = msg.isMultiOrNot();

            if (isRestartMode) {
                switchToGameMode();
                isRestartMode = false;
            }

        });
    }

    /**
     * This method shows the player to put the name he had in the previous game
     */
    @Override
    public void showRestartMessage() {
        SwingUtilities.invokeLater(() -> {
            showLabel("Enter your username of the previous game to resume the match...");
            applyChangesTo(mainFrame);
        });
    }

    /**
     * This method asks the player to choose the initial resources
     */
    @Override
    public void askInitResource(){

        SwingUtilities.invokeLater( () -> {
            mainFrameOfGame.askInitResource();
        });

    }

    /**
     * This method asks the player to choose the initial resources
     */
    public void askInitResource(String outOfEDT){

        mainFrameOfGame.askInitResource();

    }


    @Override
    public void showGameBoardProductionCards(ProductionCard[][] productionCards) {}

    @Override
    public void showMarketGrid(Marble[][] grid) {}

    @Override
    public void showMarketExtra(Marble extra) { }

    @Override
    public void showFaithIndicator(int pos) {}

    @Override
    public void showDeckProductionCards(ArrayList<ProductionCard> productionCards) {}

    @Override
    public void showGameBoardOfPlayer() {}

    @Override
    public void showProductionDecks() {}

    @Override
    public void showReserve() {}

    @Override
    public void showMarket() {}

    /**
     * This method asks the player to choose which resources to get from the white marbles with a pop up
     * @param n : the number of white marbles
     * @param whiteMarbleResourceTypes : the types of resources with which the white marble can be exchanged
     */
    @Override
    public void showWhiteMarbleResources(int n, ArrayList<Resource> whiteMarbleResourceTypes) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.marblePossibilityPopUp(n,whiteMarbleResourceTypes);
            mainFrameOfGame.disableEndTurnButton();
            applyChangesTo(mainFrameOfGame);

        });
    }

    /**
     * This method asks the player to choose the resources to hold when his storage does not have
     * enough space with a pop up
     */
    @Override
    public void showSpaceError(NotEnoughSpaceErrorMessage msg) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.fullStoragePopUp(msg);
            mainFrameOfGame.disableEndTurnButton();
            applyChangesTo(mainFrameOfGame);

        });
    }


    /**
     * This method sets the correct value to the isRestartMode attribute
     */
    @Override
    public void checkThreadRestart() {
        if (viewController.getGame().isInitResource() ||
                (!viewController.getGame().isInitResource() && viewController.getGame().getPosition() == 1)){
            isRestartMode = true;
        }
    }

    /**
     * This method shows the effect of the revealed action marker with a pop up
     */
    @Override
    public void showActionMarker(String actionType) {
        SwingUtilities.invokeLater(()-> {
            mainFrameOfGame.showLorenzoActionPopUp(actionType);
            applyChangesTo(mainFrameOfGame);
        });

    }

    /**
     * This method shows the player that he is the winner with a pop up
     * @param score : the player's score
     */
    @Override
    public void youWin(int score) {
        SwingUtilities.invokeLater(() -> {
            disableAllButtons();
            mainFrameOfGame.showPopUp(new MyVictoryMessage(score));
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the player that the Lorenzo the Magnificent is the winner with a pop up
     */
    @Override
    public void lorenzoWin() {
        SwingUtilities.invokeLater(() -> {
            disableAllButtons();
            mainFrameOfGame.showPopUp(new MagnificentWinMessage());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the player the winner with a pop up
     */
    @Override
    public void showWinner(String nickname, Map<String, Integer> scoreOfPlayers) {
        SwingUtilities.invokeLater(() -> {
            disableAllButtons();
            mainFrameOfGame.showPopUp(new EndGamePlayerWinnerMessage(nickname, scoreOfPlayers));
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the player the action of another player
     */
    @Override
    public void showOpponentAction(Message msg) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.displayString(msg.toString());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the player that the server is crashed with a pop up
     */
    @Override
    public void sayDisconnect() {


            if(mainFrameOfGame != null) {
                mainFrameOfGame.showPopUp("server is crashed, you i've been disconnected");
                applyChangesTo(mainFrameOfGame);
            }else{
                JOptionPane.showMessageDialog(mainFrame,"server is crashed, you i've been disconnected","Network Error",JOptionPane.WARNING_MESSAGE);
                applyChangesTo(mainFrame);
            }

    }

    /**
     * This method shows the production card decks received with a notification
     */
    @Override
    public void visit(DeckListNotification deckListNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getProductionDeckFrame().addDecks(deckListNotification.getListOfFirstCard());
            applyChangesTo(mainFrameOfGame);

        });
    }

    /**
     * This method shows the player's production cards received with a notification
     */
    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.updateProductionCard(gameboardListNotification);
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void visit(LeaderListCardNotification leaderListCardNotification){}

    /**
     * This method shows the player's storage received with a notification
     */
    @Override
    public void visit(StorageNotification storageNotification) {
        SwingUtilities.invokeLater(() -> {
            HashMap<Resource,Integer> resources;
            ArrayList<LeaderCard> activated = viewController.getGame().getLeaderCardActivated();
            ArrayList<Resource> extraTypes = new ArrayList<>();
            ArrayList<Integer> cardPositions = new ArrayList<>();
            resources = (HashMap<Resource, Integer>) storageNotification.getMap();

            for(int i = 0; i<activated.size();i++){
                if (activated.get(i) instanceof LeaderCardStorage){
                    extraTypes.add(activated.get(i).getResourceEffect());
                    cardPositions.add(i);
                }
            }

            for(Resource r : resources.keySet()){
                for (int i = 0; i<extraTypes.size();i++){
                    if(extraTypes.get(i) == r){
                        if (resources.get(r)>2){
                            mainFrameOfGame.addToExtraStorage(cardPositions.get(i),r,2);
                            resources.put(r,resources.remove(r)-2);
                        } else {
                            mainFrameOfGame.addToExtraStorage(cardPositions.get(i),r,resources.get(r));
                            resources.put(r,0);
                        }
                    }
                }
            }

            mainFrameOfGame.updateStorage(resources);
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the player's strongbox received with a notification
     */
    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.updateStrongBox(strongboxNotification.getMap());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the reserve received with a notification
     */
    @Override
    public void visit(ReserveNotification reserveNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getReserveFrame().updateReserve(reserveNotification.getMap());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the market grid received with a notification
     */
    @Override
    public void visit(MarketNotification marketNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getMarketFrame().setMarbleGrid(marketNotification.getList());
            applyChangesTo(mainFrameOfGame);
        });

    }

    /**
     * This method shows the market extra marble received with a notification
     */
    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getMarketFrame().setMarbleExtra(extraMarketNotification.getMarble());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * This method shows the player's faith indicator or Lorenzo's indicator received with a notification
     */
    @Override
    public void visit(FaithPathNotification faithPathNotification) {
        SwingUtilities.invokeLater(() -> {
        if(!faithPathNotification.isLorenzo())
            mainFrameOfGame.updateFaith(faithPathNotification.getI());
        else
            mainFrameOfGame.updateLorenzoIndicator(faithPathNotification.getI());
            applyChangesTo(mainFrameOfGame);

        });
    }

    /**
     * This method shows the player's initial leader cards received with a notification
     */
    @Override
    public void visit(InitLeaderNotification initLeaderNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.initLeader(initLeaderNotification.getListOfFirstCard(), initLeaderNotification.isActivated());
            applyChangesTo(mainFrameOfGame);

        });
    }

    /**
     * This method shows the activation of a leader card received with a notification
     */
    @Override
    public void visit(ActivateLeaderNotification activateLeaderNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.activateLeader(activateLeaderNotification.getKey(), activateLeaderNotification.getNewIndex());
            applyChangesTo(mainFrameOfGame);

        });
    }

    /**
     * This method shows the discarding of a leader card received with a notification
     */
    @Override
    public void visit(DiscardLeaderNotification discardLeaderNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.discardLeader(discardLeaderNotification.getIndex());
            applyChangesTo(mainFrameOfGame);

        });


    }

    /**
     * This method shows the player's papal cards initial configuration received with a notification
     */
    @Override
    public void visit(PapalCardsConfigNotification papalCardsConfigNotification) {
        SwingUtilities.invokeLater(() -> {
            for (int i=0; i<3;i++){
                if(papalCardsConfigNotification.getPapalCards()[i] == 0){
                    mainFrameOfGame.removePapalCard(i);
                }else if (papalCardsConfigNotification.getPapalCards()[i] == 1){
                    mainFrameOfGame.givePapalCard(i);
                }
            }
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void visit(LorenzoNotification lorenzoNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.updateLorenzoIndicator(lorenzoNotification.getI());
            applyChangesTo(mainFrameOfGame);

        });
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
     * Flush the components inside a panel
     * @param panel     The panel
     */
    private void clear(JPanel panel){
        panel.removeAll();
    }

    /**
     * This method shows a text label
     * @param text : the text to show
     */
    public void showLabel(String text){

            clear(container);
            container.setLayout(new FlowLayout());
            errorLabel = new JLabel(text);
            container.add(errorLabel);
            errorLabel.setLocation(475,108);
            errorLabel.setSize(100,100);
            errorLabel.setOpaque(true);
            errorLabel.setBackground(Color.WHITE);
            errorLabel.setBorder(BorderFactory.createBevelBorder(0));
            applyChangesTo(container);


    }

    /**
     * This method increases readyToSend attribute
     */
    public void setReadyToSend() {
        this.readyToSend++;
    }


    /**
     * @return readyToSend value
     */
    public int getReadyToSend() {
        return readyToSend;

  

    }

    /**
     * This method disables all buttons except those of the productions
     */
    public void disableAllExceptProductions() {

            mainFrameOfGame.disableMarketButtons();
            mainFrameOfGame.disableDeckButtons();
            mainFrameOfGame.disableLeaderButtons();
            mainFrameOfGame.activateEndOfProductionButton();
            applyChangesTo(mainFrameOfGame);

    }

    /**
     * This method disables all buttons and activates buttons to choose the game board column
     */
    public void putProdCardMode() {

            mainFrameOfGame.disableMarketButtons();
            mainFrameOfGame.disableLeaderButtons();
            mainFrameOfGame.disableDeckButtons();
            mainFrameOfGame.putCardMode();
            applyChangesTo(mainFrameOfGame);


    }

    /**
     * @return true if the player has made an action, false otherwise
     */
    public boolean isActionDoneMode(){
        return isActionDoneMode;
    }

    /**
     * This method disables all action buttons and activates leader card and end turn buttons
     */
    public void actionDoneMode() {

            isActionDoneMode = true;
            mainFrameOfGame.disableMarketButtons();
            mainFrameOfGame.disableDeckButtons();
            mainFrameOfGame.disableProductionButtons();
            mainFrameOfGame.enableLeaderButtons();
            mainFrameOfGame.enableEndTurnButton();

            applyChangesTo(mainFrameOfGame);

    }

    /**
     * This method activates all action buttons and leader card buttons
     */
    public void enableAllAction() {

            isActionDoneMode = false;
            mainFrameOfGame.enableMarketButtons();
            mainFrameOfGame.enableDeckButtons();
            mainFrameOfGame.enableProductionButtons();
            mainFrameOfGame.enableLeaderButtons();
            applyChangesTo(mainFrameOfGame);



    }

    /**
     * This method disables all action and leader buttons
     */
    public void disableAllButtons(){
        mainFrameOfGame.disableMarketButtons();
        mainFrameOfGame.disableDeckButtons();
        mainFrameOfGame.disableProductionButtons();
        mainFrameOfGame.disableLeaderButtons();
        applyChangesTo(mainFrameOfGame);
    }

    /**
     * This method shows an opponent's game board
     */
    public void showPlayerInfo(ShowAllOfPlayerMessage msg){
        SwingUtilities.invokeLater(() -> {

            for(PlayerInformationFrames frame : playerInformationFrames){
                if(frame.getNickName().equals(msg.getNickname())){
                    frame.showOpponent(msg);
                    frame.paintComponents(frame.getGraphics());
                    //frame.paintComponents(frame.getGraphics());
                }

            }
        });
    }

    /**
     * This method sets the chosen deck number
     * @param key : the number of the deck
     */
    public void setChosenDeckNumber(int key) {
        mainFrameOfGame.setChosenDeckNumber(key);
    }

    /**
     * This method removes all listener of the button passed as a parameter
     */
    public static void removeAllListeners(JButton button) {
        ActionListener[] listenerList;
        listenerList = button.getActionListeners();

        for(int i = 0;i< listenerList.length; i++){
            button.removeActionListener(listenerList[i]);
        }
    }

    /**
     * @return the number of productions activated
     */
    public int howManyActivated() {
        return mainFrameOfGame.howManyActivated();
    }


}
