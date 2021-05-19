package it.polimi.ingsw.client.view;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;

public interface View  {
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

    void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards);

    void showCallForCouncil(String nickname, int papalCard);
}