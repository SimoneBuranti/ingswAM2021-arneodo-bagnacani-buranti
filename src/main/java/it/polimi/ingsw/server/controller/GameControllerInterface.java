package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.messages.*;

public interface GameControllerInterface {

    //Client to server
    void handleMessage(ActivateLeaderCardMessage msg);
    void handleMessage(BaseProductionOnMessage msg);
    void handleMessage(BuyProductionCardMessage msg);
    void handleMessage(DiscardLeaderCardMessage msg);
    void handleMessage(DoubleProductionOnMessage msg);
    void handleMessage(EndOfProductionMessage msg);
    void handleMessage(ExitMessage msg);
    void handleMessage(ExtraProductionOnMessage msg);
    void handleMessage(InitialResourcesMessage msg);
    void handleMessage(KeepLeaderCardsMessage msg);
    void handleMessage(KeepResourcesMessage msg);
    void handleMessage(NumberPlayerMessage msg);
    void handleMessage(ProductionOnMessage msg);
    void handleMessage(PushColumnMessage msg);
    void handleMessage(PushRowMessage msg);
    void handleMessage(UsernameMessage msg);
    void handleMessage(WhiteMarbleChoosenResources msg);

    //General messages
    void handleMessage(OkMessage msg);
    void handleMessage(PingMessage msg);
    void handleMessage(PongMessage msg);

    void refreshStatus();
}
