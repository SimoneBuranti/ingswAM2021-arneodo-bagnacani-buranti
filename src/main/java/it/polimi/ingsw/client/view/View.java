package it.polimi.ingsw.client.view;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface View  {

    void startView();

    void update(String notification) throws IOException, InterruptedException;

    void setViewController(ViewController viewController);

    void askNumberOfPlayers() throws IOException, InterruptedException;

    void askNickname() throws IOException, InterruptedException;

    void askRestartGame() throws IOException, InterruptedException;

    void showChangeCurrent(String currentNick);

    void yourTurn();

    void notifyError(Message msg);

    void showPlayersOrder(ArrayList<String> nickName);

    void showLastTurn(String nickName);

    void showLobby(int playersInLobby, int playerInGame);

    void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    void showCallForCouncil(String nickname, int papalCard);

    void showStartGame();

    void showRestartMessage();

    void showPlayerInfo(ShowAllOfPlayerMessage msg);

    void askInitResource() throws IOException, InterruptedException;

    void showGameBoardProductionCards(ProductionCard[][] productionCards);

    void showMarketGrid(Marble[][] grid);

    void showMarketExtra(Marble extra);

    void showResourceMap(Map<Resource, Integer> map);

    void showFaithIndicator(int pos);

    void showDeckProductionCards(ArrayList<ProductionCard> productionCards);
}