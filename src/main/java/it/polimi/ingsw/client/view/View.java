package it.polimi.ingsw.client.view;

import it.polimi.ingsw.messages.Message;

import java.io.IOException;

public interface View  {
    void update(String notification) throws IOException, InterruptedException;

    void setViewController(ViewController viewController);

    void askNumberOfPlayers() throws IOException, InterruptedException;

    void askNickname() throws IOException, InterruptedException;

    void askRestartGame() throws IOException, InterruptedException;

    void myTurn();

    void showChangeCurrent(String currentNick);

    void notifyError(Message msg);
}
