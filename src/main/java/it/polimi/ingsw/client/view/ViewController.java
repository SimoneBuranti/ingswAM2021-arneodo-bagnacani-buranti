package it.polimi.ingsw.client.view;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.lightModel.LightGame;
import it.polimi.ingsw.client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;

import java.io.IOException;

/**
 * This class represents the client side controller, it manages the messages that come from the server and it is the observer
 * of the view
 */
public class ViewController implements MessageVisitor, ViewObserver {
    /**
     * This attribute represents the socket of the client
     */
    private SocketClient socketClient;
    /**
     * This attribute represents the game of the light model
     */
    private LightGame game ;
    /**
     * This attribute represents the nickname of the player
     */
    private String nickName = null;
    /**
     * This attribute represents the view, the class that shows the game on screen
     */
    private final View view;

    /**
     * Constructor of the class
     * @param view : the view to which the controller is associated
     */
    public ViewController(View view) {
        this.view=view;
    }

    /**
     * This method returns the game
     */
    public LightGame getGame() {
        return this.game;
    }

    /**
     * Constructor of the class
     * @param socketClient : the socket to which the controller is associated
     * @param view : the view to which the controller is associated
     */
    public ViewController(SocketClient socketClient, View view){
        this.socketClient = socketClient;
        this.view=view;
        this.view.setViewController(this);
    }


    /**
     * This method sets the game attribute with a LightGame if the boolean is true, with a LightGameSolitaire otherwise
     * @param multiOrNot : a boolean that indicates if the game is multiplayer
     */
    public void setGame(boolean multiOrNot) throws IOException, InterruptedException {
        if(multiOrNot)
            this.game=new LightGame(nickName);
        else
            this.game=new LightGameSolitaire(nickName);
        game.setObserver(view);
    }

    /**
     * This method sets the player's nickname
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * This method returns the player's nickname
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method sends a message to the server
     * @param msg : the message to be sent
     */
    public void sendMessage(Message msg) {
        socketClient.sendMessage(msg);
    }

    /**
     * This method returns the value of the game attribute isActionToken
     * @return true if an action has been activated, false otherwise
     */
    public boolean isActionToken() {
        return game.isActionToken();
    }

    /**
     * This method sets the value of the game attribute isActionToken
     */
    public void setActionToken(boolean flag){
        game.setActionToken(flag);
    }

    /**
     * This method returns the value of position n of the game attribute isProductionToken
     * @param n : the position of the value
     * @return true if production at position n has been activated, false otherwise
     */
    public boolean isProductionToken(int n) {
        return game.isProductionToken(n);
    }

    /**
     * @return true if at least one production has been activated, false otherwise
     */
    public boolean isProductionMode(){
        return game.isProductionMode();
    }

    /**
     * This method resets the value of all vector productionTokens booleans to true
     */
    public void resetProductionTokens() {
        game.resetProductionTokens();
    }

    /**
     * This method resets the value of the last production activated in the productionTokens vector
     */
    public void resetLastProduction() {
        game.resetLastProduction();
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(AlreadyActivatedErrorMessage msg) {
        view.notifyError(msg);
    }

    /**
     * This method calls view method to show error message and view method to ask the username
     */
    @Override
    public void visit(AlreadyExistingNickNameErrorMessage msg) throws IOException, InterruptedException {
        view.notifyError(msg);
        view.askNickname();
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(AlreadyUsedLeaderCardErrorMessage msg) {
        view.notifyError(msg);
    }

    /**
     * This method calls view method to show error message and disconnects the client
     */
    @Override
    public void visit(CompleteRunningMatchErrorMessage msg) {
        view.notifyError(msg);
    }

    /**
     * This method calls view method to show error message and view method to ask the username
     */
    @Override
    public void visit(NoNicknameMessage msg) throws IOException, InterruptedException {
        view.notifyError(msg);
        view.askNickname();
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(NotAvailableResourcesErrorMessage msg) {
        view.notifyError(msg);

    }

    /**
     * This method calls view method to make the player choose the resources to hold when his storage does not have
     * enough space
     */
    @Override
    public void visit(NotEnoughSpaceErrorMessage msg) {
        view.showSpaceError(msg);
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(RequirementsErrorMessage msg) {
        view.notifyError(msg);

    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(WrongColumnErrorMessage msg) {
        view.notifyError(msg);
    }

    @Override
    public void visit(NotYourTurnErrorMessage msg)
    {
        view.notifyError(msg);
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(BootingLobbyErrorMessage msg) {
        view.notifyError(msg);
    }

    /**
     * This method calls the view method to ask if the player wants to continue the game if the message attribute is zero,
     * it calls the view method to show the player to put the previous name and the view method to ask the username otherwise
     */
    @Override
    public void visit(RestartQuestionMessage msg) throws IOException, InterruptedException {
        if(msg.getLobbySize() == 0)
            view.askRestartGame();
        else {
            view.showRestartMessage();
            view.askNickname();
        }

    }


    @Override
    public void visit(EndOfTurnMessage msg) {
    }

    /**
     * This method calls view method to show the last round notification
     */
    @Override
    public void visit(LastTurnMessage msg) {
        view.showLastTurn(msg.getNickname());

    }


    /**
     * This method calls the game method to set the reserve values
     */
    @Override
    public void visit(ReserveValueMessage msg) throws IOException, InterruptedException {
        game.setReserve(msg.getReserve());
    }

    /**
     * This method calls the view methods to show the message error and the method to make the player choose which
     * resources to get from the white marbles (if the player has activated two white marble leader cards)
     */
    @Override
    public void visit(DoubleWhiteMarbleEffectMessage msg) {
        view.notifyError(msg);
        view.showWhiteMarbleResources(msg.getWhiteMarbleNumber(),game.getWhiteMarbleResourceTypes());
    }

    /**
     * This method calls the view method to ask the number of players if the message attribute is -1,
     * it calls the view method to show the lobby otherwise
     */
    @Override
    public void visit(NPlayersMessage msg) throws IOException, InterruptedException {
        if (msg.getnOfPlayers() == -1){
            view.askNumberOfPlayers();
        } else {
            if(msg.getnOfPlayers() < msg.getLobbySize())
                view.showLobby(msg.getnOfPlayers(), msg.getLobbySize());
        }
    }

    /**
     * This method calls the view method to ask the player which cards he wants to hold
     */
    @Override
    public void visit(PickedLeaderCardsMessage msg) throws IOException, InterruptedException {
        view.askLeaderCardToKeep(game.getLeaderCards());
    }

    /**
     * This method calls the game method to sets the papal card in the current position and the view method
     * to show the call for council message
     */
    @Override
    public void visit(SetPapalsMessage msg) {

        game.setPapalCard(msg.getPapalCard());
        view.showCallForCouncil(msg.getNickname(), msg.getPapalCard());
    }

    /**
     * This method sets the initial values of initResource and initLeader game attributes
     */
    @Override
    public void visit(UpdateInitBooleanMessage msg) {
        System.out.println(msg.isInitResource() + " " + msg.isInitLeader());
        game.setInitResource(msg.isInitResource());
        game.setInitLeader(msg.isInitLeader());


        view.checkThreadRestart();
    }

    @Override
    public void visit(AskInformationMessage msg) {

    }


    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(NoPlayersErrorMessage msg) {
        view.notifyError(msg);
    }

    /**
     * This method calls the view method to show the game board of an opponent
     */
    @Override
    public void visit(ShowAllOfPlayerMessage msg) {
        view.showPlayerInfo(msg);
    }

    /**
     * This method calls the game method to set the player's position
     */
    @Override
    public void visit(PositionMessage msg) {
        game.setPosition(msg.getPos());
    }


    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(BaseProductionErrorMessage msg) {
        view.notifyError(msg);
    }

    /**
     * This method calls the game method to set the player's initial papal cards values
     */
    @Override
    public void visit(PapalCardsConfigMessage papalCardsConfigMessage) {
        game.setPapalCards(papalCardsConfigMessage.getPapalCards());
    }

    @Override
    public void visit(GameEndedMessage gameEndedMessage) {
        view.notifyError(gameEndedMessage);
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(DisconnectionOpponentMessage disconnectionOpponentMessage) {
        view.notifyError(disconnectionOpponentMessage);
    }

    /**
     * This method calls view method to show error message
     */
    @Override
    public void visit(ReconnectedMessage reconnectedMessage) {
        view.notifyError(reconnectedMessage);
    }

    @Override
    public void visit(RestartAnswerMessage msg) {}

    @Override
    public void visit(ActivateLeaderCardMessage msg) {}

    @Override
    public void visit(BaseProductionOnMessage msg) {}

    @Override
    public void visit(BuyProductionCardMessage msg) {}

    @Override
    public void visit(DiscardLeaderCardMessage msg) {}

    @Override
    public void visit(DoubleProductionOnMessage msg) {}

    @Override
    public void visit(EndOfProductionMessage msg) {}

    @Override
    public void visit(ExitMessage msg) {}

    @Override
    public void visit(ExtraProductionOnMessage msg) {}

    @Override
    public void visit(InitialResourcesMessage msg) {}

    @Override
    public void visit(KeepLeaderCardsMessage msg) {}

    @Override
    public void visit(KeepResourcesMessage msg) {}

    @Override
    public void visit(NumberPlayerMessage msg) {}

    @Override
    public void visit(ProductionOnMessage msg) {}

    @Override
    public void visit(PushColumnMessage msg) {}

    @Override
    public void visit(PushRowMessage msg) {}

    /**
     * This method calls the view method to ask the username
     */
    @Override
    public void visit(UsernameMessage msg) throws IOException, InterruptedException {
        view.askNickname();
    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) {}

    /**
     * This method responds to ping message with a pong message
     */
    @Override
    public void visit(PingMessage msg) {
        socketClient.setCheckServer(true);
        socketClient.sendMessage(new PongMessage());
    }

    @Override
    public void visit(PongMessage msg) {}

    /**
     * This method calls the view method to show the players round
     */
    @Override
    public void visit(NicknameStartedMessage msg) {
        view.showPlayersOrder(msg.getNickname());
    }

    /**
     * This method removes the resources from the reserve of the game and calls the view method to show an opponent action
     */
    @Override
    public void visit(UpdateForNotCurrentResourceMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getR1(), 1);
        if(msg.getR2() != null)
            game.useResourceReserve(msg.getR2(), 1);
        view.showOpponentAction(msg);
    }

    /**
     * This method adds the resources to the storage and removes them from the reserve
     */
    @Override
    public void visit(UpdateInitResourceMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getR1(),1);
        game.addStorage(msg.getR1(), 1);
        if(msg.getR2() != null) {
            game.useResourceReserve(msg.getR2(),1);
            game.addStorage(msg.getR2(), 1);
        }
    }

    /**
     * This method adds the initial leader cards passed in the message
     */
    @Override
    public void visit(UpdateInitLeaderMessage msg) {
        try {
            game.addLeaderCard(msg.getLeaderCards());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to set the chosen leader cards
     */
    @Override
    public void visit(UpdateChosenLeaderMessage msg) {
        try {
            game.setLeaderPersonal(msg.getCardFirst(),msg.getCardSec());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to remove one card from the deck passed in the message
     */
    @Override
    public void visit(DeckProductionCardMessage msg) throws IOException, InterruptedException {
        game.removeOneProductionCard(msg.getNumberDeck());
    }

    /**
     * This method calls the game method to set the production decks and calls the game method configInit if all
     * the decks have been set
     */
    @Override
    public void visit(DeckProductionCardConfigMessage msg) throws IOException, InterruptedException {
        game.setDeckProductionCard(msg.getNumberDeck(), msg.getDeck());
        if(game.isEachDeckConfig()) {
            game.configInit();
        }

    }

    /**
     * This method calls the game method to buy a production card
     */
    @Override
    public void visit(TakeCardMessage msg) {
        try {
            game.buyProductionCard(msg.getNumberDeck(), msg.getColumn());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to buy a production card from an opposing player and calls the view method
     * to show an opponent action
     */
    @Override
    public void visit(TakeCardForNotCurrentMessage msg) {
        try {
            game.buyProductionCardOpponent(msg.getNumberDeck());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        view.showOpponentAction(msg);

    }

    /**
     * This method calls the game method to sets the market
     */
    @Override
    public void visit(ConfigurationMarketMessage msg) throws IOException, InterruptedException {
        game.setMarket(msg.getMarbleList());
    }

    /**
     * This method calls the game method to push a column of the market
     */
    @Override
    public void visit(ChangeMarketMessageColumn msg) throws IOException, InterruptedException {
        game.pushColumn(msg.getColumn());
    }

    /**
     * This method calls the game method to push a column of the market
     */
    @Override
    public void visit(ChangeMarketMessageRow msg) throws IOException, InterruptedException {
        game.pushRow(msg.getRow());
    }

    /**
     * This method adds the resources to the storage and removes them from the reserve
     */
    @Override
    public void visit(ResultFromMarketMessage msg) throws IOException, InterruptedException {
        game.addStorage(msg.getResource());
        game.useResourceReserve(msg.getResource());
    }

    /**
     * This method removes the resources from the reserve and calls the view method to show an opponent action
     */
    @Override
    public void visit(ResultFromMarketNotCurrentMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getResource());
        view.showOpponentAction(msg);
    }

    /**
     * This method calls the view method to show that Lorenzo the Magnificent is the winner
     */
    @Override
    public void visit(MagnificentWinMessage msg) {
        view.lorenzoWin();
    }

    /**
     * This method calls the game method to sets the initial black cross position
     */
    @Override
    public void visit(LorenzoTheMagnificentConfigMessage msg) {
        game.setLorenzoTheMagnificent(msg.getFaithIndicator());
    }

    /**
     * This method calls the view method to show that the player is the winner and to show his score
     */
    @Override
    public void visit(MyVictoryMessage msg) {
        view.youWin(msg.getScore());
    }

    /**
     * This method calls the game method to activate the effect of the action marker and it calls the view method
     * to show the action marker
     */
    @Override
    public void visit(UseActionMarkerMessage msg) {
        try {
            game.actionMarkerEffect(msg.getActionType());
            view.showActionMarker(msg.getActionType());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds the resources to the reserve and calls the view method to show an opponent action
     */
    @Override
    public void visit(ProductionMessageForNotCurrentMessage msg) throws IOException, InterruptedException {
        view.showOpponentAction(msg);
        game.addResourceReserve(msg.getResource());
    }

    /**
     * This method calls the game method to pay the resources and calls the game method to add the resources to the reserve
     */
    @Override
    public void visit(ProductionMessageForCurrentMessage msg) throws IOException, InterruptedException {
        game.addResourceReserve(msg.getResource());
        game.payResourcesProduction(msg.getResource());
    }


    /**
     * This method removes the resources from the reserve and add them to the storage
     */
    @Override
    public void visit(ResultOfProductionMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getResource());
        game.addStrongbox(msg.getResource());
    }

    /**
     * This method removes the resources from the reserve and calls the view method to show an opponent action
     */
    @Override
    public void visit(ResultOfProductionForNotCurrentMessage msg) throws IOException, InterruptedException {
        view.showOpponentAction(msg);
        game.useResourceReserve(msg.getResource());
    }

    /**
     * This method calls the view method to show an opponent action
     */
    @Override
    public void visit(ActivationLeaderForNotCurrentMessage msg) {
        view.showOpponentAction(msg);

    }

    /**
     * This method calls the game method to activate a leader card
     */
    @Override
    public void visit(ActivationLeaderForCurrentMessage msg) throws IOException, InterruptedException {
        game.activateLeaderCard(msg.getIndex());
    }

    /**
     * This method calls the view method to show an opponent action
     */
    @Override
    public void visit(DiscardLeaderForNotCurrentMessage msg) {
        view.showOpponentAction(msg);

    }

    /**
     * This method calls the game method to discard a leader card
     */
    @Override
    public void visit(DiscardLeaderForCurrentMessage msg) {
        try {
            game.discardLeaderCard(msg.getIndex());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to move the faith indicator
     */
    @Override
    public void visit(FaithPathMessage msg) {
        try {
            game.faithMove(msg.getFaithmove());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the view method to show an opponent action
     */
    @Override
    public void visit(FaithPathOpponentMessage msg) {
        view.showOpponentAction(msg);

    }

    /**
     * This method calls the view controller to show the winner of the game
     */
    @Override
    public void visit(EndGamePlayerWinnerMessage msg) {
        view.showWinner(msg.getNickname());

    }

    /**
     * This method calls the game method to set the initial storage
     */
    @Override
    public void visit(StorageConfigMessage msg) {
        try {
            game.addStorage(msg.getResource());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calls the game method to set the initial strongbox
     */
    @Override
    public void visit(StrongboxConfigMessage msg) {
        try {
            game.addStrongbox(msg.getStrongBoxResource());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calls the game method to set the initial leader cards, both activated and not
     */
    @Override
    public void visit(LeadercardconfigMessage msg) {
        try {
            game.addLeaderCard(msg.getNotActivated());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            game.addLeaderCardActivated( msg.getActivated());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to set the initial first extra storage
     */
    @Override
    public void visit(StorageExtraConfig msg) {
        try {
            game.addStorage(msg.getResourceProduction(), 2-msg.getQuantityIn());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to set the initial second extra storage
     */
    @Override
    public void visit(StorageExtraDoubleConfig msg) {
        try {
            game.addStorage(msg.getResourceProduction(), 2-msg.getQuantityIn());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calls the game method to set the initial player's faith path
     */
    @Override
    public void visit(FaithConfigMessage msg) {
        try {
            game.setFaithPath(msg.getFaithConfig(), msg.getCurrCall());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calls the game method to set the initial player's production cards
     */
    @Override
    public void visit(ProductionCardConfigMessage msg) {
        try {
            game.setProductionCardGameBoard(msg.getListOwnProductioncard());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calls the game method to move the black cross
     */
    @Override
    public void visit(LorenzoMoveMessage msg) {
        game.moveBlackCross();
    }

    /**
     * This method warns the player that it is his turn and sets all the correct values for the turn.
     * If the player still has to choose the initial cards or the initial resources it calls the view
     * method that asks for them.
     */
    @Override
    public void visit(YourTurnMessage msg) throws IOException, InterruptedException {
        if (!game.isInitLeader() && !game.isInitResource())
        {
            view.yourTurn();
            view.askLeaderCardToKeep(game.getLeaderCards());
            game.setInitResource(true);
        }
        else if(game.isInitLeader() && !game.isInitResource() && game.getPosition()!=1)
        {
            view.askInitResource();
            game.setInitResource(true);
            view.yourTurn();
            view.askInitResource();
            game.setInitResource(true);
        }
        else
        {
            view.yourTurn();
        }
        game.setActionToken(true);
        game.resetProductionTokens();
    }

    /**
     * This method calls the view method to show the new current player
     */
    @Override
    public void visit(ChangeTurnMessage msg) {
        view.showChangeCurrent(msg.getNickName());
    }

    /**
     * This method calls the method to sets the game and calls the view method to show that the game has started
     */
    @Override
    public void visit(GameTypeMessage msg) throws IOException, InterruptedException {
        setGame(msg.isMultiOrNot());
        view.showStartGame(msg);
    }


    /**
     * This method sends a message to the server when it receives an update from the view
     */
    @Override
    public void update(Message message) throws IOException, InterruptedException {
        socketClient.sendMessage(message);
    }

    /**
     * This method calls the view method to show that the server crashed
     */
    public void sayDisconnect() {
        view.sayDisconnect();
    }
}
