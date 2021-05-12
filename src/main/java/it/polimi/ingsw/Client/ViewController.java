package it.polimi.ingsw.Client;

import it.polimi.ingsw.Client.lightModel.LightGame;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.server.model.Resource;

import java.util.HashMap;
import java.util.Map;

public class ViewController implements MessageVisitor {
    private final SocketClient socketClient;
    private LightGame game = null;
    private String nickName = null;
    private Map<Resource, Integer> resourceMap = new HashMap<>();

    public ViewController(SocketClient socketClient){
        this.socketClient = socketClient;

    }

    public void setGame(LightGame game){
        this.game = game;
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
        game.setCurrentPlayer();
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
        game.setPlayers(msg.getNickname());
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
        game.addStorage(nickName, msg.getR1(), 1);
        if(msg.getR2() != null) {
            game.useResourceReserve(msg.getR2(),1);
            game.addStorage(nickName, msg.getR2(), 1);
        }
    }

    @Override
    public void visit(UpdateInitLeaderMessage msg) {
        game.addLeaderCard(nickName, msg.getLeaderCards());
    }

    @Override
    public void visit(UpdateChosenLeaderMessage msg) {
        for(int i = 0; i < 4; i++){
            if(i != msg.getCardFirst() && i != msg.getCardSec());
                game.discardLeaderCard(nickName, i);
        }
    }

    @Override
    public void visit(DeckProductionCardMessage msg) {
        game.removeOneProductionCard(msg.getNumberDeck());
    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {
        game.setDeckProductionCard(msg.getNumberDeck(), msg.getDeck());
    }

    @Override
    public void visit(TakeCardMessage msg) {
        game.buyProductionCard(nickName, msg.getNumberDeck(), msg.getColumn());
    }

    @Override
    public void visit(TakeCardForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ConfigurationMarketMessage msg) {
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
        resourceMap.put(Resource.COIN, msg.getCoins());
        resourceMap.put(Resource.ROCK, msg.getRock());
        resourceMap.put(Resource.SERVANT, msg.getServant());
        resourceMap.put(Resource.SHIELD, msg.getShield());

        game.addStorage(nickName, resourceMap);
        game.useResourceReserve(resourceMap);
    }


    @Override
    public void visit(ResultFromMarketNotCurrentMessage msg) {
        resourceMap.put(Resource.COIN, msg.getCoins());
        resourceMap.put(Resource.ROCK, msg.getRock());
        resourceMap.put(Resource.SERVANT, msg.getServant());
        resourceMap.put(Resource.SHIELD, msg.getShield());
        game.useResourceReserve(resourceMap);
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
        game.useActionMarker();
    }


    @Override
    public void visit(ProductionMessageForNotCurrentMessage msg) {
        resourceMap.put(Resource.COIN, msg.getCoins());
        resourceMap.put(Resource.ROCK, msg.getRock());
        resourceMap.put(Resource.SERVANT, msg.getServant());
        resourceMap.put(Resource.SHIELD, msg.getShield());

        game.addResourceReserve(resourceMap);
    }

    @Override
    public void visit(ProductionMessageForCurrentMessage msg) {
        resourceMap.put(Resource.COIN, msg.getCoins());
        resourceMap.put(Resource.ROCK, msg.getRock());
        resourceMap.put(Resource.SERVANT, msg.getServant());
        resourceMap.put(Resource.SHIELD, msg.getShield());

        game.addResourceReserve(resourceMap);
        game.payResourcesProduction(nickName, resourceMap);
    }

    @Override
    public void visit(ResultOfProductionMessage msg) {
        resourceMap.put(Resource.COIN, msg.getCoins());
        resourceMap.put(Resource.ROCK, msg.getRock());
        resourceMap.put(Resource.SERVANT, msg.getServant());
        resourceMap.put(Resource.SHIELD, msg.getShield());

        game.useResourceReserve(resourceMap);
        game.addStrongbox(nickName, resourceMap);
    }

    @Override
    public void visit(ResultForProductionForNotCurrentMessage msg) {
        resourceMap.put(Resource.COIN, msg.getCoins());
        resourceMap.put(Resource.ROCK, msg.getRock());
        resourceMap.put(Resource.SERVANT, msg.getServant());
        resourceMap.put(Resource.SHIELD, msg.getShield());

        game.useResourceReserve(resourceMap);
    }

    @Override
    public void visit(ActivationLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ActivationLeaderForCurrentMessage msg) {
        game.activateLeaderCard(nickName, msg.getIndex());
    }

    @Override
    public void visit(DiscardLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderForCurrentMessage msg) {
        game.discardLeaderCard(nickName, msg.getIndex());
    }

    @Override
    public void visit(FaithPathMessage msg) {
        game.faithMove(nickName);
    }

    @Override
    public void visit(FaithPathOpponentMessage msg) {

    }



    @Override
    public void visit(EndGamePlayerWinnerMessage msg) {

    }

    @Override
    public void visit(StorageConfigMessage msg) {
        game.addStorage(nickName, msg.getResource());
    }

    @Override
    public void visit(StrongboxConfigMessage msg) {
        game.addStorage(nickName, msg.getStrongBoxResource());
    }

    @Override
    public void visit(LeadercardconfigMessage msg) {
        game.addLeaderCard(nickName, msg.getNotActivated());
        game.addLeaderCardActivated(nickName, msg.getActivated());
    }

    @Override
    public void visit(StorageExtraConfig msg) {
        game.addStrongbox(nickName, msg.getResourceProduction(), 2-msg.getQuantityIn());
    }

    @Override
    public void visit(StorageExtraDoubleConfig msg) {
        game.addStrongbox(nickName, msg.getResourceProduction(), 2-msg.getQuantityIn());
    }

    @Override
    public void visit(FaithConfigMessage msg) {
        game.setFaithPath(nickName, msg.getFaithConfig(), msg.getCurrCall());
    }

    @Override
    public void visit(ProductionCardConfigMessage msg) {
        game.setProductionCardGameBoard(nickName, msg.getListOwnProductioncard());
    }


}
