package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

public class ClientController implements MessageVisitor {

    private final Server server;
    private final ClientHandler clientHandler;
    private Game game;
    private String nickname;
    private VirtualView virtualView;

    public ClientController(Server server, ClientHandler clientHandler) {
        this.server = server;
        this.clientHandler = clientHandler;
        this.game = null;
        this.nickname = null;
        this.virtualView = new VirtualView(clientHandler);
        game.addObserver(virtualView);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game){
        this.game = game;
        game.addObserver(virtualView);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    @Override
    public void visit(AlreadyActivatedErrorMessage msg) {}

    @Override
    public void visit(AlreadyExistingNickNameErrorMessage msg) {}

    @Override
    public void visit(AlreadyUsedLeaderCardErrorMessage msg) {}

    @Override
    public void visit(CompleteRunningMatchErrorMessage msg) {}

    @Override
    public void visit(NoNicknameMessage msg) {}

    @Override
    public void visit(NotAvailableResourcesErrorMessage msg) {}

    @Override
    public void visit(NotEnoughSpaceErrorMessage msg) {}

    @Override
    public void visit(RequirementsErrorMessage msg) {}

    @Override
    public void visit(WrongColumnErrorMessage msg) {}

    @Override
    public void visit(NotYourTurnErrorMessage msg) {}

    @Override
    public void visit(ChangeCurrentPlayerMessage msg) {}

    @Override
    public void visit(EndGameMessage msg) {}

    @Override
    public void visit(EndOfTurnMessage msg) {}

    @Override
    public void visit(LastTurnMessage msg) {}

    @Override
    public void visit(LorenzoActionMessage msg) {}

    @Override
    public void visit(OpponentActivateLeaderCardMessage msg) {}

    @Override
    public void visit(OpponentDiscardLeaderCardMessage msg) {}

    @Override
    public void visit(OpponentFaithMoveMessage msg) {}

    @Override
    public void visit(OpponentBuyProductionCardMessage msg) {}

    @Override
    public void visit(ReserveValueMessage msg) {}

    @Override
    public void visit(DoubleWhiteMarbleEffectMessage msg) {}

    @Override
    public void visit(NPlayersMessage msg) {}

    @Override
    public void visit(PickedLeaderCardsMessage msg) {}

    @Override
    public void visit(SetPapalsMessage msg) {}

    //***********************************************************************************************************


    @Override
    public void visit(ActivateLeaderCardMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(BaseProductionOnMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(BuyProductionCardMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(DiscardLeaderCardMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(DoubleProductionOnMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(EndOfProductionMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(ExitMessage msg) { server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(ExtraProductionOnMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(InitialResourcesMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(KeepLeaderCardsMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(KeepResourcesMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(NumberPlayerMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(ProductionOnMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(PushColumnMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(PushRowMessage msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(UsernameMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(WhiteMarbleChoosenResources msg) {
        //server.getGameController().handleMessage(msg);
    }

    @Override
    public void visit(OkMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(PingMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(PongMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(DeckProductionCardMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {

    }

    public VirtualView getVirtualView() {
        return virtualView;
    }
}
