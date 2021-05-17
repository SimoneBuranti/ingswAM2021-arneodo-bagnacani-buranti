package it.polimi.ingsw.Client;

import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.Client.lightModel.LightGameMultiPlayer;
import it.polimi.ingsw.Client.lightModel.LightGameSolitaire;
import it.polimi.ingsw.Client.View.View;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;

public class ViewController implements MessageVisitor {
    private final SocketClient socketClient;
    private LightGame game ;
    private String nickName = null;
    private View view;


    public ViewController(SocketClient socketClient, View view){
        this.socketClient = socketClient;
        this.view=view;
    }


    public void setGame(boolean multiOrNot){
        if(multiOrNot)
            this.game=new LightGameMultiPlayer(nickName);
        else
            this.game=new LightGameSolitaire(nickName);
        game.setObserver(view);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public void visit(AlreadyActivatedErrorMessage msg) {
    }

    @Override
    public void visit(AlreadyExistingNickNameErrorMessage msg) {
    }

    @Override
    public void visit(AlreadyUsedLeaderCardErrorMessage msg) {

    }

    @Override
    public void visit(CompleteRunningMatchErrorMessage msg) {

    }

    @Override
    public void visit(NoNicknameMessage msg) {

    }

    @Override
    public void visit(NotAvailableResourcesErrorMessage msg) {

    }

    @Override
    public void visit(NotEnoughSpaceErrorMessage msg) {

    }

    @Override
    public void visit(RequirementsErrorMessage msg) {

    }

    @Override
    public void visit(WrongColumnErrorMessage msg) {

    }

    @Override
    public void visit(NotYourTurnErrorMessage msg) {

    }

    @Override
    public void visit(BootingLobbyErrorMessage msg) {

    }

    @Override
    public void visit(RestartQuestionMessage msg) {

    }

    @Override
    public void visit(ChangeCurrentPlayerMessage msg) {
        game.setCurrentPlayer(msg.getNickname());
    }



    @Override
    public void visit(EndOfTurnMessage msg) {

    }

    @Override
    public void visit(LastTurnMessage msg) {

    }


    @Override
    public void visit(ReserveValueMessage msg) {
        game.setReserve(msg.getReserve());
    }

    @Override
    public void visit(DoubleWhiteMarbleEffectMessage msg) {

    }

    @Override
    public void visit(NPlayersMessage msg) {

    }

    @Override
    public void visit(PickedLeaderCardsMessage msg) {

    }

    @Override
    public void visit(SetPapalsMessage msg) {
        game.setPapalCards(msg.getCurrCall());
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
    public void visit(UsernameMessage msg) {

    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) {

    }

    @Override
    public void visit(PingMessage msg) {
        socketClient.sendMessage(new PongMessage());
    }

    @Override
    public void visit(PongMessage msg) {

    }

    @Override
    public void visit(OkMessage msg) {

    }

    @Override
    public void visit(NicknameStartedMessage msg) {
        System.out.println(msg.getMessageType()+" : "+ msg.getNickname());
        game.setPlayersInOrder(msg.getNickname());
    }

    @Override
    public void visit(UpdateForNotCurrentResourceMessage msg) {
        game.useResourceReserve(msg.getR1(), 1);
        if(msg.getR2() != null)
            game.useResourceReserve(msg.getR2(), 1);
    }

    @Override
    public void visit(UpdateInitResourceMessage msg) {
        game.useResourceReserve(msg.getR1(),1);
        game.addStorage(msg.getR1(), 1);
        if(msg.getR2() != null) {
            game.useResourceReserve(msg.getR2(),1);
            game.addStorage(msg.getR2(), 1);
        }
    }

    @Override
    public void visit(UpdateInitLeaderMessage msg) {
        System.out.println(msg.getMessageType()+" : "+ msg.getLeaderCards());
        game.addLeaderCard(msg.getLeaderCards());
    }

    @Override
    public void visit(UpdateChosenLeaderMessage msg) {
        for(int i = 0; i < 4; i++){
            if(i != msg.getCardFirst() && i != msg.getCardSec());
                game.discardLeaderCard(i);
        }
    }

    @Override
    public void visit(DeckProductionCardMessage msg) {
        game.removeOneProductionCard(msg.getNumberDeck());
    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {
        System.out.println(msg.getMessageType()+" : "+ msg.getDeck());
        game.setDeckProductionCard(msg.getNumberDeck(), msg.getDeck());
    }

    @Override
    public void visit(TakeCardMessage msg) {
        game.buyProductionCard(msg.getNumberDeck(), msg.getColumn());
    }

    @Override
    public void visit(TakeCardForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ConfigurationMarketMessage msg) {
        System.out.println(msg.getMessageType()+" : "+ msg.getMarbleList());
        game.setMarket(msg.getMarbleList());
    }

    @Override
    public void visit(ChangeMarketMessageColumn msg) {
        game.pushColumn(msg.getColumn());
    }

    @Override
    public void visit(ChangeMarketMessageRow msg) {
        game.pushRow(msg.getRow());
    }

    @Override
    public void visit(ResultFromMarketMessage msg) {
        game.addStorage(msg.getResource());
        game.useResourceReserve(msg.getResource());
    }


    @Override
    public void visit(ResultFromMarketNotCurrentMessage msg) {
        game.useResourceReserve(msg.getResource());
    }



    @Override
    public void visit(MagnificentWinMessage msg) {

    }

    @Override
    public void visit(LorenzoTheMagnificentConfigMessage msg) {
        game.setLorenzoTheMagnificent(msg.getFaithIndicator());
    }

    @Override
    public void visit(MyVictoryMessage msg) {

    }


    @Override
    public void visit(UseActionMarkerMessage msg) {
        game.actionMarkerEffect(msg.getActionType());
    }


    @Override
    public void visit(ProductionMessageForNotCurrentMessage msg) {

        game.addResourceReserve(msg.getResource());
    }

    @Override
    public void visit(ProductionMessageForCurrentMessage msg) {

        game.addResourceReserve(msg.getResource());
        game.payResourcesProduction(msg.getResource());
    }

    @Override
    public void visit(ResultOfProductionMessage msg) {

        game.useResourceReserve(msg.getResource());
        game.addStrongbox(msg.getResource());
    }

    @Override
    public void visit(ResultOfProductionForNotCurrentMessage msg) {

        game.useResourceReserve(msg.getResource());
    }

    @Override
    public void visit(ActivationLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ActivationLeaderForCurrentMessage msg) {
        game.activateLeaderCard(msg.getIndex());
    }

    @Override
    public void visit(DiscardLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderForCurrentMessage msg) {
        game.discardLeaderCard(msg.getIndex());
    }

    @Override
    public void visit(FaithPathMessage msg) {
        game.faithMove(msg.getFaithmove());
    }

    @Override
    public void visit(FaithPathOpponentMessage msg) {

    }



    @Override
    public void visit(EndGamePlayerWinnerMessage msg) {

    }

    @Override
    public void visit(StorageConfigMessage msg) {
        game.addStorage(msg.getResource());
    }

    @Override
    public void visit(StrongboxConfigMessage msg) {
        game.addStorage(msg.getStrongBoxResource());
    }

    @Override
    public void visit(LeadercardconfigMessage msg) {
       game.addLeaderCard(msg.getNotActivated());
       game.addLeaderCardActivated( msg.getActivated());
    }

    @Override
    public void visit(StorageExtraConfig msg) {
        game.addStrongbox(msg.getResourceProduction(), 2-msg.getQuantityIn());
    }

    @Override
    public void visit(StorageExtraDoubleConfig msg) {
        game.addStrongbox(msg.getResourceProduction(), 2-msg.getQuantityIn());
    }

    @Override
    public void visit(FaithConfigMessage msg) {
        game.setFaithPath(msg.getFaithConfig(), msg.getCurrCall());
    }

    @Override
    public void visit(ProductionCardConfigMessage msg) {
        game.setProductionCardGameBoard(msg.getListOwnProductioncard());
    }

    @Override
    public void visit(LorenzoMoveMessage msg) {
        game.moveBlackCrossOnce();
    }

    @Override
    public void visit(YourTurnMessage msg) {

    }

    @Override
    public void visit(ChangeTurnMessage msg) {

    }

    @Override
    public void visit(GameTypeMessage msg) {
        setGame(msg.isMultiOrNot());
    }


}
