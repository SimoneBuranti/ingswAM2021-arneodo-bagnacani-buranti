package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.Server;

import java.io.IOException;

public abstract class GameController {
    protected int numberOfPlayers;
    protected Game game;
    protected Server server;

    //Client to server
    public abstract void handleMessage(ExitMessage msg, ClientController clientController);
    public abstract void handleMessage(NumberPlayerMessage msg, ClientController clientController) throws IOException, InterruptedException;
    public abstract void handleMessage(UsernameMessage msg, ClientController clientController) throws IOException, InterruptedException;


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public abstract void handleMessage(RestartAnswerMessage msg, ClientController clientController);

    /*void handleMessage(ActivateLeaderCardMessage msg);
    void handleMessage(BaseProductionOnMessage msg);
    void handleMessage(BuyProductionCardMessage msg);
    void handleMessage(DiscardLeaderCardMessage msg);
    void handleMessage(DoubleProductionOnMessage msg);
    void handleMessage(EndOfProductionMessage msg);
    void handleMessage(ExtraProductionOnMessage msg);
    void handleMessage(InitialResourcesMessage msg);
    void handleMessage(KeepLeaderCardsMessage msg);
    void handleMessage(KeepResourcesMessage msg);
    void handleMessage(ProductionOnMessage msg);
    void handleMessage(PushColumnMessage msg);
    void handleMessage(PushRowMessage msg);
    void handleMessage(WhiteMarbleChoosenResources msg);*/

}
