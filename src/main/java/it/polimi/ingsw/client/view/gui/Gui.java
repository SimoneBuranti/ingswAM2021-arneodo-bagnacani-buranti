package it.polimi.ingsw.client.view.gui;
import it.polimi.ingsw.client.commands.commandParsers.StandardParser;
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

public class Gui extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;
    private JFrame mainFrame;
    private PanelContainer container;

    private JButton submitButton;
    private JButton yesButton;
    private JButton noButton ;
    private JButton enterButton ;

    private MainFrame mainFrameOfGame;

    private Boolean isMultiOrNot;

    protected PlayerInformatioFrames playerInformatioFrames;

    private JButton oneButton;
    private JButton twoButton ;
    private JButton threeButton;
    private JButton fourButton ;

    private JLabel lobbyLabel;

    private JLabel errorLabel;
    
    private int readyToSend=0;

    private boolean chosenResumeGame;

    private boolean isActionDoneMode;
    private boolean isRestartMode = false;


    @Override
    public void startView() {
        SwingUtilities.invokeLater(() -> {


            mainFrame = new JFrame("Masters Of Renaissance");
            mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public void update(String notification) throws IOException, InterruptedException {
        Notification parsedMsg = Notification.deserialize(notification);
        parsedMsg.accept(this);
    }
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
                    (new Thread(() -> {
                        sendUsernameResponse(nickname);
                    })).start();
                }
            })).start());

            applyChangesTo(container);
        });}

    public void sendUsernameResponse(String nickname){
        try {
            notifyObserver(new UsernameMessage(nickname));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



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

                        container.remove(yesButton);
                        container.remove(submitButton);
                        container.remove(noButton);
                        chosenResumeGame = true;
                (new Thread(() -> {
                    sendRestartResponse(true);
                })).start();

                   });
               this.noButton.addActionListener(eNO -> {

                        container.remove(yesButton);
                        container.remove(submitButton);
                        container.remove(noButton);
                        chosenResumeGame = false;
                           (new Thread(() -> {
                               sendRestartResponse(false);
                           })).start();}

                   );
            applyChangesTo(container);
        });


    }

    public void sendRestartResponse(boolean bool){
        try {
            notifyObserver(new RestartAnswerMessage(bool));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





    @Override
    public void showChangeCurrent(String currentNick) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.setCurrentPlayer(currentNick);
            disableAllButtons();
            applyChangesTo(mainFrameOfGame);

        });
    }

    public void switchToGameMode(){
        //SwingUtilities.invokeLater(() -> {
            if (!mainFrameOfGame.isBackGroundNull()) {
                mainFrameOfGame.switchToGameMode();
                mainFrameOfGame.paintComponents(mainFrameOfGame.getGraphics());
                mainFrameOfGame.paintComponents(mainFrameOfGame.getGraphics());
            }
            //applyChangesTo(mainFrameOfGame);

        //});

    }

    @Override
    public void yourTurn() {
        SwingUtilities.invokeLater(() -> {
            /*if (isRestartMode) {
                switchToGameMode();
                isRestartMode = false;
            }*/
            mainFrameOfGame.setCurrentPlayer(viewController.getNickName());
            enableAllAction();
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void notifyError(Message msg) {

        if (msg instanceof NoNicknameMessage || msg instanceof BootingLobbyErrorMessage
                || msg instanceof AlreadyExistingNickNameErrorMessage || msg instanceof CompleteRunningMatchErrorMessage){
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
    @Override
    public void showPlayersOrder(ArrayList<String> nickName) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.setPlayers(nickName);
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void showLastTurn(String nickName) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.displayString("last turn ");
            applyChangesTo(mainFrameOfGame);

        });

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
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) {
        SwingUtilities.invokeLater(() -> {
            try {
                mainFrameOfGame.askLeaderCardToKeep(leaderCards);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

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

    @Override
    public void showStartGame(GameTypeMessage msg) {
        SwingUtilities.invokeLater(() -> {

            mainFrame.dispose();
            if (msg.isMultiOrNot() == true) {
                /*if (!viewController.getGame().isInitResource() || !viewController.getGame().isInitLeader()) {
                    mainFrameOfPreGame = new MainFrameMultiPlayer(this, "your board");
                }*/
                mainFrameOfGame = new MainFrameMultiPlayer(this);
            } else {

                /*if (!viewController.getGame().isInitResource() || !viewController.getGame().isInitLeader()) {
                    mainFrameOfPreGame = new MainFrameSinglePlayer(this, "your board");
                }*/
                mainFrameOfGame = new MainFrameSinglePlayer(this);

            }


            isMultiOrNot = msg.isMultiOrNot();

            if (isRestartMode) {
                switchToGameMode();
                isRestartMode = false;
            }
            //System.out.println("sono dentro all'edt e ho istanziato cazzi e mazzi");

        });}

    @Override
    public void showRestartMessage() {
        SwingUtilities.invokeLater(() -> {
            showLabel("Enter your username of the previous game to resume the match...");
            applyChangesTo(mainFrame);
        });
    }


    @Override
    public void askInitResource(){

        SwingUtilities.invokeLater( () -> {
            mainFrameOfGame.askInitResource();
        });

    }

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

    @Override
    public void showWhiteMarbleResources(int n, ArrayList<Resource> whiteMarbleResourceTypes) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.marblePossibilityPopUp(n,whiteMarbleResourceTypes);
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void showSpaceError(NotEnoughSpaceErrorMessage msg) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.fullStoragePopUp(msg);
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void checkThreadRestart() {
        if (viewController.getGame().isInitResource()){
            isRestartMode = true;
        }
    }

    @Override
    public void showActionMarker(String actionType) {
        SwingUtilities.invokeLater(()-> {
            mainFrameOfGame.showLorenzoActionPopUp(actionType);
            applyChangesTo(mainFrameOfGame);
        });

    }

    @Override
    public void youWin(int score) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.showPopUp(new MyVictoryMessage(score));
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void lorenzoWin() {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.showPopUp(new MagnificentWinMessage());
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void showWinner(String nickname) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.showPopUp(new EndGamePlayerWinnerMessage(nickname));
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void showOpponentAction(Message msg) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.displayString(msg.toString());
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void sayDisconnect() {

        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.showPopUp("server is crashed, you i've been disconnected");
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void visit(DeckListNotification deckListNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getProductionDeckFrame().addDecks(deckListNotification.getListOfFirstCard());
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.updateProductionCard(gameboardListNotification);
            applyChangesTo(mainFrameOfGame);

        });

    }

    @Override
    public void visit(LeaderListCardNotification leaderListCardNotification){
    }

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
     * @param strongboxNotification
     */
    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.updateStrongBox(strongboxNotification.getMap());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * @param reserveNotification
     */
    @Override
    public void visit(ReserveNotification reserveNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getReserveFrame().updateReserve(reserveNotification.getMap());
            applyChangesTo(mainFrameOfGame);

        });

    }

    /**
     * @param marketNotification
     */
    @Override
    public void visit(MarketNotification marketNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getMarketFrame().setMarbleGrid(marketNotification.getList());
            applyChangesTo(mainFrameOfGame);
        });

    }

    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.getMarketFrame().setMarbleExtra(extraMarketNotification.getMarble());
            applyChangesTo(mainFrameOfGame);

        });

    }

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

    @Override
    public void visit(InitLeaderNotification initLeaderNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.initLeader(initLeaderNotification.getListOfFirstCard(), initLeaderNotification.isActivated());
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void visit(ActivateLeaderNotification activateLeaderNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.activateLeader(activateLeaderNotification.getKey(), activateLeaderNotification.getNewIndex());
            applyChangesTo(mainFrameOfGame);

        });
    }

    @Override
    public void visit(DiscardLeaderNotification discardLeaderNotification) {
        SwingUtilities.invokeLater(() -> {
            mainFrameOfGame.discardLeader(discardLeaderNotification.getIndex());
            applyChangesTo(mainFrameOfGame);

        });


    }

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


    public void showLabel(String text){

            clear(container);
            container.setLayout(new FlowLayout());
            errorLabel = new JLabel(text);
            container.add(errorLabel);
            errorLabel.setLocation(475,108);
            errorLabel.setSize(100,100);
            applyChangesTo(container);


    }


    public void setReadyToSend() {
        this.readyToSend++;
    }

    
    
    public int getReadyToSend() {
        return readyToSend;

  

    }

    public void showLoading () { }


    public void powerToMainFrame()
    {
        SwingUtilities.invokeLater(()-> {

            mainFrameOfGame.switchToGameMode();
            mainFrameOfGame.paintComponents(mainFrameOfGame.getGraphics());
            mainFrameOfGame.paintComponents(mainFrameOfGame.getGraphics());

        });


    }


    public void disableAllExceptProductions() {

            mainFrameOfGame.disableMarketButtons();
            mainFrameOfGame.disableDeckButtons();
            mainFrameOfGame.disableLeaderButtons();
            mainFrameOfGame.activateEndOfProductionButton();
            applyChangesTo(mainFrameOfGame);

    }

    public void putProdCardMode() {

            mainFrameOfGame.disableMarketButtons();
            mainFrameOfGame.disableLeaderButtons();
            mainFrameOfGame.disableDeckButtons();
            mainFrameOfGame.putCardMode();
            applyChangesTo(mainFrameOfGame);


    }

    public boolean isActionDoneMode(){
        return isActionDoneMode;
    }

    public void actionDoneMode() {

            isActionDoneMode = true;
            mainFrameOfGame.disableMarketButtons();
            mainFrameOfGame.disableDeckButtons();
            mainFrameOfGame.disableProductionButtons();
            mainFrameOfGame.enableLeaderButtons();
            mainFrameOfGame.enableEndTurnButton();

            applyChangesTo(mainFrameOfGame);

    }

    public void enableAllAction() {

            isActionDoneMode = false;
            mainFrameOfGame.enableMarketButtons();
            mainFrameOfGame.enableDeckButtons();
            mainFrameOfGame.enableProductionButtons();
            mainFrameOfGame.enableLeaderButtons();
            applyChangesTo(mainFrameOfGame);



    }

    public void disableAllButtons(){
        mainFrameOfGame.disableMarketButtons();
        mainFrameOfGame.disableDeckButtons();
        mainFrameOfGame.disableProductionButtons();
        mainFrameOfGame.disableLeaderButtons();
        applyChangesTo(mainFrameOfGame);
    }


    public void showPlayerInfo(ShowAllOfPlayerMessage msg){
        this.playerInformatioFrames= new PlayerInformatioFrames(msg);
    }

    public void setChosenDeckNumber(int key) {
        mainFrameOfGame.setChosenDeckNumber(key);
    }

    public static void removeAllListeners(JButton button) {
        ActionListener[] listenerList;
        listenerList = button.getActionListeners();

        for(int i = 0;i< listenerList.length; i++){
            button.removeActionListener(listenerList[i]);
        }
    }

    public int howManyActivated() {
        return mainFrameOfGame.howManyActivated();
    }


}
