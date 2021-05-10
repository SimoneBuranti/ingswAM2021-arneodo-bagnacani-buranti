package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.DeckProductionCardConfigMessage;
import it.polimi.ingsw.messages.observable.DeckProductionCardMessage;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.exceptions.LeaderCardsGameBoardEmptyException;
import it.polimi.ingsw.server.network.*;
import it.polimi.ingsw.server.virtualview.VirtualView;

public class ClientController implements MessageVisitor {

    private final Server server;
    private final ClientHandler clientHandler;
    private VirtualView virtualView;
    private Game game;
    private String nickname;

    public ClientController(Server server, ClientHandler clientHandler) {
        this.server = server;
        this.clientHandler = clientHandler;
        this.game = null;
        this.nickname = null;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game){
        this.game = game;
        this.virtualView = new VirtualView(this,game);
        game.addObserver(virtualView);
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

    //---------------------------- From Server to Client ---------------------------------------

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
    public void visit(BootingLobbyErrorMessage msg) {
    }

    @Override
    public void visit(RestartQuestionMessage msg) {
    }

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


    //---------------------------Game Controller Handled------------------------------------------------
    @Override
    public void visit(ExitMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(NumberPlayerMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(UsernameMessage msg) {
        server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(RestartAnswerMessage msg) { server.getGameController().handleMessage(msg, this); }


    //-----------------------------Client Controller Handled ------------------------------------------------------

    /*
        if (turnCheck()){

        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
     */

    //***********************************************************************************************************


    @Override
    public void visit(ActivateLeaderCardMessage msg) {
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
    public void visit(BaseProductionOnMessage msg) {
        if (turnCheck()){
            try {
                game.baseProductionOn(msg.getFirstInputResource(),msg.getSecondInputResource(),msg.getOutputResource());
            } catch (ImpossibleProductionException e) {
                clientHandler.sendMessage(new NotAvailableResourcesErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(BuyProductionCardMessage msg) {
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
    public void visit(DiscardLeaderCardMessage msg) {
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
    public void visit(DoubleProductionOnMessage msg) {
        if (turnCheck()){
            try {
                game.anotherExtraProductionOn(msg.getOutputResource());
            } catch (ImpossibleProductionException e) {
                clientHandler.sendMessage(new NotAvailableResourcesErrorMessage());
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(EndOfProductionMessage msg) {
        if (turnCheck()){
            game.endOfProduction();
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(ExtraProductionOnMessage msg) {
        if (turnCheck()){
            game.extraProductionOn(msg.getOutputResource());
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(InitialResourcesMessage msg) {
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
    public void visit(KeepLeaderCardsMessage msg) {
        if (turnCheck()){
            game.saveLeaderCardChosen(msg.getChosenLeaderCards()[0],msg.getChosenLeaderCards()[1]);
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(ProductionOnMessage msg) {
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
    public void visit(PushColumnMessage msg) {
        if (turnCheck()){
            try {
                game.pushColumnInMarket(msg.getColumnNumber());
            } catch (NotEnoughSpaceInStorageException e) {
                clientHandler.sendMessage(new NotEnoughSpaceErrorMessage(e.getResources()));
            } catch (WhiteMarbleException e) {
                clientHandler.sendMessage(new DoubleWhiteMarbleEffectMessage(e.getN()));
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(PushRowMessage msg) {
        if (turnCheck()){
            try {
                game.pushColumnInMarket(msg.getRowNumber());
            } catch (NotEnoughSpaceInStorageException e) {
                clientHandler.sendMessage(new NotEnoughSpaceErrorMessage(e.getResources()));
            } catch (WhiteMarbleException e) {
                clientHandler.sendMessage(new DoubleWhiteMarbleEffectMessage(e.getN()));
            }
        } else {
            clientHandler.sendMessage(new NotYourTurnErrorMessage());
        }
    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) {
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
    public void visit(KeepResourcesMessage msg) {
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
        //server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(PongMessage msg) {
        //server.getGameController().handleMessage(msg, this);
    }

    @Override
    public void visit(OkMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {

    }
}
