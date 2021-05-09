package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;

import java.io.IOException;

public class GameControllerLobby extends GameController {

    private int lobbySize;

    public GameControllerLobby(int lobbySize) {
        this.lobbySize = lobbySize;
    }


    @Override
    public void handleMessage(ExitMessage msg, ClientController clientController) {
        try {
            clientController.getClientHandler().disconnect();
            server.removePlayerToLobby(clientController.getNickname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleMessage(NumberPlayerMessage msg, ClientController clientController) {
        //unreachable
    }

    @Override
    public void handleMessage(UsernameMessage msg, ClientController clientController) {
        if (server.addPlayerToLobby(msg.getUsername())){
            clientController.setNickname(msg.getUsername());
            clientController.getClientHandler().sendMessage(new NPlayersMessage(server.getLobbySize()));
        } else {
            clientController.getClientHandler().sendMessage(new AlreadyExistingNickNameErrorMessage());
        }

        if(lobbySize == server.getLobbySize()){
            server.setGameController(new GameControllerMultiplayer());
            server.initNewMultiplayerGame();
        }
    }

    @Override
    public void handleMessage(RestartAnswerMessage msg, ClientController clientController) {
        //unreachable
    }


   /* @Override
    public void handleMessage(ActivateLeaderCardMessage msg) {

    }

    @Override
    public void handleMessage(BaseProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(BuyProductionCardMessage msg) {

    }

    @Override
    public void handleMessage(DiscardLeaderCardMessage msg) {

    }

    @Override
    public void handleMessage(DoubleProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(EndOfProductionMessage msg) {

    }*/


   /* @Override
    public void handleMessage(ExtraProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(InitialResourcesMessage msg) {

    }

    @Override
    public void handleMessage(KeepLeaderCardsMessage msg) {

    }

    @Override
    public void handleMessage(KeepResourcesMessage msg) {

    }*/


   /* @Override
    public void handleMessage(ProductionOnMessage msg) {

    }

    @Override
    public void handleMessage(PushColumnMessage msg) {

    }

    @Override
    public void handleMessage(PushRowMessage msg) {

    }*/


   /* @Override
    public void handleMessage(WhiteMarbleChoosenResources msg) {

    }*/

}
