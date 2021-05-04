package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;

public abstract class GameControllerInterface {
    protected int numberOfPlayers;

    //Client to server
    public abstract void handleMessage(ExitMessage msg);
    public abstract void handleMessage(NumberPlayerMessage msg);
    public abstract void handleMessage(UsernameMessage msg);

    //General messages
    public abstract void handleMessage(OkMessage msg);
    public abstract void handleMessage(PingMessage msg);
    public abstract void handleMessage(PongMessage msg);

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

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



    public abstract void refreshStatus();
}
