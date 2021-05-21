package it.polimi.ingsw.client.view;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.lightModel.LightGame;
import it.polimi.ingsw.client.lightModel.LightGameMultiPlayer;
import it.polimi.ingsw.client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;

import java.io.IOException;

public class ViewController implements MessageVisitor, ViewObserver {
    private final SocketClient socketClient;
    private LightGame game ;
    private String nickName = null;
    private View view;

    public LightGame getGame() {
        return game;
    }

    public ViewController(SocketClient socketClient, View view){
        this.socketClient = socketClient;
        this.view=view;
        this.view.setViewController(this);
    }


    public void setGame(boolean multiOrNot) throws IOException, InterruptedException {
        if(multiOrNot)
            this.game=new LightGameMultiPlayer(nickName);
        else
            this.game=new LightGameSolitaire(nickName);
        game.setObserver(view);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void sendMessage(Message msg) {
        socketClient.sendMessage(msg);
    }

    public boolean isActionToken() {
        return game.isActionToken();
    }

    public void setActionToken(boolean flag){
        game.setActionToken(flag);
    }


    @Override
    public void visit(AlreadyActivatedErrorMessage msg) {
        view.notifyError(msg);
    }

    @Override
    public void visit(AlreadyExistingNickNameErrorMessage msg) throws IOException, InterruptedException {
        view.notifyError(msg);
        view.askNickname();
    }

    @Override
    public void visit(AlreadyUsedLeaderCardErrorMessage msg) {
        view.notifyError(msg);
    }

    @Override
    public void visit(CompleteRunningMatchErrorMessage msg) {
        view.notifyError(msg);
        try {
            socketClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void visit(NoNicknameMessage msg) throws IOException, InterruptedException {
        view.notifyError(msg);
        view.askNickname();
    }

    @Override
    public void visit(NotAvailableResourcesErrorMessage msg) {
        view.notifyError(msg);

    }

    @Override
    public void visit(NotEnoughSpaceErrorMessage msg) {
        view.notifyError(msg);

    }

    @Override
    public void visit(RequirementsErrorMessage msg) {
        view.notifyError(msg);

    }

    @Override
    public void visit(WrongColumnErrorMessage msg) {
        view.notifyError(msg);
    }

    @Override
    public void visit(NotYourTurnErrorMessage msg) {
        view.notifyError(msg);

    }

    @Override
    public void visit(BootingLobbyErrorMessage msg) {
        view.notifyError(msg);

    }

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
    public void visit(ChangeCurrentPlayerMessage msg) {
        game.setCurrentPlayer(msg.getNickname());
        view.showChangeCurrent(msg.getNickname());
    }



    @Override
    public void visit(EndOfTurnMessage msg) {


    }

    @Override
    public void visit(LastTurnMessage msg) {
        view.showLastTurn(msg.getNickname());

    }


    @Override
    public void visit(ReserveValueMessage msg) throws IOException, InterruptedException {
        game.setReserve(msg.getReserve());
    }

    @Override
    public void visit(DoubleWhiteMarbleEffectMessage msg) {

    }

    @Override
    public void visit(NPlayersMessage msg) throws IOException, InterruptedException {
        if (msg.getnOfPlayers() == -1){
            view.askNumberOfPlayers();
        } else {
            if(msg.getnOfPlayers() < msg.getLobbySize())
                view.showLobby(msg.getnOfPlayers(), msg.getLobbySize());
        }
    }

    @Override
    public void visit(PickedLeaderCardsMessage msg) {
        view.askLeaderCardToKeep(game.getLeaderCards());
    }

    @Override
    public void visit(SetPapalsMessage msg) {

        game.setPapalCards(msg.getCurrCall());

        view.showCallForCouncil(msg.getNickname(), game.getPapalCard(msg.getCurrCall()));
    }

    @Override
    public void visit(UpdateInitBooleanMessage msg) {
        game.setInitLeader(msg.isInitResource());
    }

    @Override
    public void visit(AskInformationMessage msg) {

    }

    @Override
    public void visit(NoPlayersErrorMessage msg) {
        view.notifyError(msg);
    }

    @Override
    public void visit(ShowAllOfPlayerMessage msg) {
        view.showPlayerInfo(msg);

    }

    @Override
    public void visit(RestartAnswerMessage msg) {

    }



    @Override
    public void visit(ActivateLeaderCardMessage msg) {

    }

    @Override
    public void visit(BaseProductionOnMessage msg) {

    }

    @Override
    public void visit(BuyProductionCardMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderCardMessage msg) {

    }

    @Override
    public void visit(DoubleProductionOnMessage msg) {

    }

    @Override
    public void visit(EndOfProductionMessage msg) {

    }

    @Override
    public void visit(ExitMessage msg) {

    }

    @Override
    public void visit(ExtraProductionOnMessage msg) {

    }

    @Override
    public void visit(InitialResourcesMessage msg) {

    }

    @Override
    public void visit(KeepLeaderCardsMessage msg) {

    }

    @Override
    public void visit(KeepResourcesMessage msg) {

    }

    @Override
    public void visit(NumberPlayerMessage msg) {

    }

    @Override
    public void visit(ProductionOnMessage msg) {

    }

    @Override
    public void visit(PushColumnMessage msg) {

    }

    @Override
    public void visit(PushRowMessage msg) {

    }

    @Override
    public void visit(UsernameMessage msg) throws IOException, InterruptedException {
        view.askNickname();
    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) {

    }

    @Override
    public void visit(PingMessage msg) {
        socketClient.sendMessage(new PongMessage());
    }

    @Override
    public void visit(PongMessage msg) {}

    @Override
    public void visit(OkMessage msg) {}

    @Override
    public void visit(NicknameStartedMessage msg) {
        game.setPlayersInOrder(msg.getNickname());
        view.showPlayersOrder(msg.getNickname());
    }

    @Override
    public void visit(UpdateForNotCurrentResourceMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getR1(), 1);
        if(msg.getR2() != null)
            game.useResourceReserve(msg.getR2(), 1);
    }

    @Override
    public void visit(UpdateInitResourceMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getR1(),1);
        game.addStorage(msg.getR1(), 1);
        if(msg.getR2() != null) {
            game.useResourceReserve(msg.getR2(),1);
            game.addStorage(msg.getR2(), 1);
        }
    }

    @Override
    public void visit(UpdateInitLeaderMessage msg) {
        try {
            game.addLeaderCard(msg.getLeaderCards());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(UpdateChosenLeaderMessage msg) {
        for(int i = 0; i < 4; i++){
            if(i != msg.getCardFirst() && i != msg.getCardSec());
            try {
                game.discardLeaderCard(i);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void visit(DeckProductionCardMessage msg) throws IOException, InterruptedException {
        game.removeOneProductionCard(msg.getNumberDeck());
    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) throws IOException, InterruptedException {
        game.setDeckProductionCard(msg.getNumberDeck(), msg.getDeck());
        if(game.isEachDeckFull())
            game.configInit();
    }

    @Override
    public void visit(TakeCardMessage msg) {
        try {
            game.buyProductionCard(msg.getNumberDeck(), msg.getColumn());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(TakeCardForNotCurrentMessage msg) {
        // visit.takeCardProductionOfAnotherPlayer();

    }

    @Override
    public void visit(ConfigurationMarketMessage msg) throws IOException, InterruptedException {
        game.setMarket(msg.getMarbleList());
    }

    @Override
    public void visit(ChangeMarketMessageColumn msg) throws IOException, InterruptedException {
        game.pushColumn(msg.getColumn());
    }

    @Override
    public void visit(ChangeMarketMessageRow msg) throws IOException, InterruptedException {
        game.pushRow(msg.getRow());
    }

    @Override
    public void visit(ResultFromMarketMessage msg) throws IOException, InterruptedException {
        game.addStorage(msg.getResource());
        game.useResourceReserve(msg.getResource());
    }


    @Override
    public void visit(ResultFromMarketNotCurrentMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getResource());
    }


    @Override
    public void visit(MagnificentWinMessage msg) {
        // view.magnificentWin();
    }

    @Override
    public void visit(LorenzoTheMagnificentConfigMessage msg) {
        game.setLorenzoTheMagnificent(msg.getFaithIndicator());
    }

    @Override
    public void visit(MyVictoryMessage msg) {
        // view.YouWin();

    }


    @Override
    public void visit(UseActionMarkerMessage msg) {
        try {
            game.actionMarkerEffect(msg.getActionType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void visit(ProductionMessageForNotCurrentMessage msg) throws IOException, InterruptedException {
        // visit.negativeProductionOfAnotherPlayer();
        game.addResourceReserve(msg.getResource());
    }

    @Override
    public void visit(ProductionMessageForCurrentMessage msg) throws IOException, InterruptedException {
        game.addResourceReserve(msg.getResource());
        game.payResourcesProduction(msg.getResource());
    }


    @Override
    public void visit(ResultOfProductionMessage msg) throws IOException, InterruptedException {
        game.useResourceReserve(msg.getResource());
        game.addStrongbox(msg.getResource());
    }

    @Override
    public void visit(ResultOfProductionForNotCurrentMessage msg) throws IOException, InterruptedException {
        // visit.positiveProductionOfAnotherPlayer();
        game.useResourceReserve(msg.getResource());
    }

    @Override
    public void visit(ActivationLeaderForNotCurrentMessage msg) {
        // visit.leaderActivationOfAnotherPlayer();

    }

    @Override
    public void visit(ActivationLeaderForCurrentMessage msg) throws IOException, InterruptedException {

        game.activateLeaderCard(msg.getIndex());
    }

    @Override
    public void visit(DiscardLeaderForNotCurrentMessage msg) {
        // visit.leaderDiscardOfAnotherPlayer();

    }

    @Override
    public void visit(DiscardLeaderForCurrentMessage msg) {
        try {
            game.discardLeaderCard(msg.getIndex());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(FaithPathMessage msg) {
        try {
            game.faithMove(msg.getFaithmove());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(FaithPathOpponentMessage msg) {
        // visit.faithMoveOfAnotherPlayer();

    }



    @Override
    public void visit(EndGamePlayerWinnerMessage msg) {
        // visit.showWinner();

    }

    @Override
    public void visit(StorageConfigMessage msg) {
        try {
            game.addStorage(msg.getResource());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(StrongboxConfigMessage msg) {
        try {
            game.addStrongbox(msg.getStrongBoxResource());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(LeadercardconfigMessage msg) {
        try {
            game.addLeaderCard(msg.getNotActivated());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            game.addLeaderCardActivated( msg.getActivated());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(StorageExtraConfig msg) {
        try {
            game.addStrongbox(msg.getResourceProduction(), 2-msg.getQuantityIn());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(StorageExtraDoubleConfig msg) {
        try {
            game.addStrongbox(msg.getResourceProduction(), 2-msg.getQuantityIn());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(FaithConfigMessage msg) {
        try {
            game.setFaithPath(msg.getFaithConfig(), msg.getCurrCall());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(ProductionCardConfigMessage msg) {
        try {
            game.setProductionCardGameBoard(msg.getListOwnProductioncard());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(LorenzoMoveMessage msg) {
        game.moveBlackCrossOnce();
    }

    @Override
    public void visit(YourTurnMessage msg) {
        if (!game.isInitLeader() && !game.isInitResource()) {
            view.yourTurn();
            view.askLeaderCardToKeep(null);
            game.setInitLeader(true);
            view.askInitResource();
            game.setInitResource(true);
        }
        else if(game.isInitLeader()&&!game.isInitResource()){
            view.yourTurn();
            view.askInitResource();
            game.setInitResource(true);
        }
        else
            view.yourTurn(); }

    @Override
    public void visit(ChangeTurnMessage msg) {

    }

    @Override
    public void visit(GameTypeMessage msg) throws IOException, InterruptedException {
        setGame(msg.isMultiOrNot());
        view.showStartGame();
    }



    @Override
    public void update(Message message) throws IOException, InterruptedException {
        socketClient.sendMessage(message);
    }

    /*public int getDeckNumberFormColourAndLevel(char c, int level) {

        return game.getDeckNumberFormColourAndLevel(c,level);
    }*/
}
