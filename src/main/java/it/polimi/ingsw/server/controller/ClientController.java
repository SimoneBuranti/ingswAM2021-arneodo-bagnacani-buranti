package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.exceptions.LeaderCardsGameBoardEmptyException;
import it.polimi.ingsw.server.network.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.IOException;

public class ClientController implements MessageVisitor {

    private final Server server;
    private final ClientHandler clientHandler;
    private VirtualView virtualView;
    private Game game;
    private String nickname;

    public ClientController(Server server, ClientHandler clientHandler) {
        this.server = server;
        this.clientHandler = clientHandler;
        this.virtualView = new VirtualView(this);
        this.game = null;
        this.nickname = null;
    }

    public void restoreClientController(ClientController clientController){

        this.setNickname(clientController.getNickname());
        this.virtualView=clientController.getVirtualView();
        this.virtualView.setClientController(this);
        this.game=clientController.getGame();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public String getNickname() {
        return nickname;
    }

    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean turnCheck(){
        return nickname.equals(game.getCurrentNickname());
    }

    public VirtualView getVirtualView() {
        return virtualView;
    }



    //---------------------------- From Server to Client ---------------------------------------

    @Override
    public void visit(AlreadyActivatedErrorMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(AlreadyExistingNickNameErrorMessage msg) {
    }

    @Override
    public void visit(AlreadyUsedLeaderCardErrorMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(CompleteRunningMatchErrorMessage msg) {
    }

    @Override
    public void visit(NoNicknameMessage msg) {

    }

    @Override
    public void visit(NotAvailableResourcesErrorMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(NotEnoughSpaceErrorMessage msg) {

    }

    @Override
    public void visit(RequirementsErrorMessage msg) {}

    @Override
    public void visit(WrongColumnErrorMessage msg) {}

    @Override
    public void visit(NotYourTurnErrorMessage msg) {}

    @Override
    public void visit(BootingLobbyErrorMessage msg) { }

    @Override
    public void visit(RestartQuestionMessage msg) { }


    @Override
    public void visit(EndOfTurnMessage msg) throws IOException, InterruptedException {
        if(turnCheck()) {
            game.endOfTurn();
        }
        else
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
    }

    @Override
    public void visit(LastTurnMessage msg) {}




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

    @Override
    public void visit(UpdateInitBooleanMessage msg) {

    }

    @Override
    public void visit(AskInformationMessage askInformationmessage) throws IOException, InterruptedException {
        server.getGame().askInfoOnPlayer(askInformationmessage.getN(),clientHandler.getClientController().getNickname());
    }

    @Override
    public void visit(NoPlayersErrorMessage noPlayersErrorMessage) {

    }

    @Override
    public void visit(ShowAllOfPlayerMessage showAllOfPlayerMessage) {

    }

    @Override
    public void visit(PositionMessage positionMessage) {

    }

    @Override
    public void visit(BaseProductionErrorMessage baseProductionErrorMessage) {

    }

    @Override
    public void visit(PapalCardsConfigMessage papalCardsConfigMessage) {

    }

    @Override
    public void visit(DisconnectionOpponentMessage disconnectionOpponentMessage) {

    }

    @Override
    public void visit(ReconnectedMessage reconnectedMessage) {

    }

    //***********************************************************************************************************


    //---------------------------Game Controller Handled------------------------------------------------
    @Override
    public void visit(ExitMessage msg) throws IOException, InterruptedException {
        if (!turnCheck())
            server.getGameController().handleMessage(msg, this);
        else{
            server.getGame().endOfTurn();
            server.getGameController().handleMessage(msg, this);
        }
    }

    @Override
    public void visit(NumberPlayerMessage msg) throws IOException, InterruptedException {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(UsernameMessage msg) throws IOException, InterruptedException {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(RestartAnswerMessage msg) throws IOException, InterruptedException { server.getGameController().handleMessage(msg, this); }


    @Override
    public void visit(ActivateLeaderCardMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.activateLeaderCard(msg.getCardNumber());
            } catch (RequirementsException e) {
                clientHandler.sendMessage(new RequirementsErrorMessage());
            } catch (LeaderCardsGameBoardEmptyException e) {
                clientHandler.sendMessage(new AlreadyActivatedErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }


    @Override
    public void visit(BaseProductionOnMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.baseProductionOn(msg.getFirstInputResource(),msg.getSecondInputResource(),msg.getOutputResource());
            } catch (ImpossibleProductionException e) {
                clientHandler.sendMessage(new BaseProductionErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(BuyProductionCardMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.buyProductionCard(game.deckFromDeckNumber(msg.getDeckNumber()),msg.getColumnNumber());
            } catch (EmptyException | FullColumnException | LevelException e) {
                clientHandler.sendMessage(new WrongColumnErrorMessage());
            } catch (NotEnoughResourcesException e) {
                clientHandler.sendMessage(new NotAvailableResourcesErrorMessage());
            }

        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(DiscardLeaderCardMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.discardLeaderCard(msg.getCardNumber());
            } catch (LeaderCardsGameBoardEmptyException e) {
                clientHandler.sendMessage(new AlreadyActivatedErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }

    }

    @Override
    public void visit(DoubleProductionOnMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.anotherExtraProductionOn(msg.getOutputResource(),msg.getResourceLeader());
            } catch (ImpossibleProductionException e) {
                clientHandler.sendMessage(new NotAvailableResourcesErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(EndOfProductionMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            game.endOfProduction();
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(ExtraProductionOnMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.extraProductionOn(msg.getOutputResource(),msg.getResourceLeader());
            } catch (ImpossibleProductionException e) {
                clientHandler.sendMessage(new NotAvailableResourcesErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(InitialResourcesMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            if(msg.getResources().size()==1){
                game.initResourceOfPlayer(msg.getResources().get(0));
            } else {
                game.initResourceOfPlayer((msg.getResources().get(0)),msg.getResources().get(1));
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(KeepLeaderCardsMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            game.saveLeaderCardChosen(msg.getChosenLeaderCards()[0],msg.getChosenLeaderCards()[1]);
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(ProductionOnMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.productionOn(msg.getColumnNumber());
            } catch (ImpossibleProductionException e) {
                clientHandler.sendMessage(new NotAvailableResourcesErrorMessage());
            } catch (EmptyColumnException e) {
                clientHandler.sendMessage(new WrongColumnErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(PushColumnMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.pushColumnInMarket(msg.getColumnNumber());
            } catch (NotEnoughSpaceInStorageException e) {
                clientHandler.sendMessage(new NotEnoughSpaceErrorMessage(e.getResources()));
                game.notifyFromClientControllerColumn(msg.getColumnNumber());
            } catch (WhiteMarbleException e) {
                clientHandler.sendMessage(new DoubleWhiteMarbleEffectMessage(e.getN()));
                game.notifyFromClientControllerColumn(msg.getColumnNumber());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(PushRowMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.pushRowInMarket(msg.getRowNumber());
            } catch (NotEnoughSpaceInStorageException e) {
                clientHandler.sendMessage(new NotEnoughSpaceErrorMessage(e.getResources()));
                game.notifyFromClientControllerRow(msg.getRowNumber());
            } catch (WhiteMarbleException e) {
                clientHandler.sendMessage(new DoubleWhiteMarbleEffectMessage(e.getN()));
                game.notifyFromClientControllerRow(msg.getRowNumber());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }

    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.continueTakeFromMarketAfterChoosenWhiteMarble(msg.getChoosenResources());
            } catch (NotEnoughSpaceInStorageException e) {
                clientHandler.sendMessage(new NotEnoughSpaceErrorMessage(e.getResources()));
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(KeepResourcesMessage msg) throws IOException, InterruptedException {
        if (turnCheck()){
            try {
                game.giveResourceFromClient(msg.getChoosenResources());
            } catch (NotEnoughSpaceInStorageException e) {
                clientHandler.sendMessage(new NotEnoughSpaceErrorMessage(e.getResources()));
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }



    @Override
    public void visit(PingMessage msg) {

    }

    @Override
    public void visit(PongMessage msg) {
        clientHandler.setPongo(true);
    }

    @Override
    public void visit(OkMessage msg) {

    }

    @Override
    public void visit(UpdateChosenLeaderMessage msg) {

    }

    @Override
    public void visit(NicknameStartedMessage msg) {
        
    }

    @Override
    public void visit(UpdateForNotCurrentResourceMessage msg) {

    }

    @Override
    public void visit(UpdateInitResourceMessage msg) {

    }

    @Override
    public void visit(UpdateInitLeaderMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {

    }

    @Override
    public void visit(TakeCardMessage msg) {

    }

    @Override
    public void visit(TakeCardForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ConfigurationMarketMessage msg) {

    }

    @Override
    public void visit(ChangeMarketMessageColumn msg) {

    }

    @Override
    public void visit(ChangeMarketMessageRow msg) {

    }

    @Override
    public void visit(ResultFromMarketMessage msg) {

    }

    @Override
    public void visit(ResultFromMarketNotCurrentMessage msg) {

    }

    @Override
    public void visit(MagnificentWinMessage msg) {

    }

    @Override
    public void visit(LorenzoTheMagnificentConfigMessage msg) {

    }

    @Override
    public void visit(MyVictoryMessage msg) {

    }

    @Override
    public void visit(UseActionMarkerMessage msg) {

    }

    @Override
    public void visit(ProductionMessageForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ProductionMessageForCurrentMessage msg) {

    }

    @Override
    public void visit(ResultOfProductionMessage msg) {

    }

    @Override
    public void visit(ResultOfProductionForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ActivationLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ActivationLeaderForCurrentMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderForCurrentMessage msg) {

    }

    @Override
    public void visit(FaithPathMessage msg) {

    }

    @Override
    public void visit(FaithPathOpponentMessage msg) {

    }

    @Override
    public void visit(EndGamePlayerWinnerMessage msg) {

    }

    @Override
    public void visit(StorageConfigMessage msg) {

    }

    @Override
    public void visit(StrongboxConfigMessage msg) {

    }

    @Override
    public void visit(LeadercardconfigMessage msg) {

    }

    @Override
    public void visit(StorageExtraConfig msg) {

    }

    @Override
    public void visit(StorageExtraDoubleConfig msg) {

    }

    @Override
    public void visit(FaithConfigMessage msg) {

    }

    @Override
    public void visit(ProductionCardConfigMessage msg) {

    }

    @Override
    public void visit(LorenzoMoveMessage msg) {

    }

    @Override
    public void visit(YourTurnMessage msg) {

    }

    @Override
    public void visit(ChangeTurnMessage msg) {

    }

    @Override
    public void visit(GameTypeMessage msg) {

    }


}


//-----------------------------Client Controller Handled ------------------------------------------------------

    /*
        if (turnCheck()){

        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
     */

//***********************************************************************************************************