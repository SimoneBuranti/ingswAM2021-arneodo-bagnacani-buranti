package it.polimi.ingsw.client.view;

import it.polimi.ingsw.client.ViewController;
import it.polimi.ingsw.messages.*;

import java.io.IOException;

public interface View  {
    void update(String notification) throws IOException, InterruptedException;

    void setViewController(ViewController viewController);

    void askNumberOfPlayers() throws IOException, InterruptedException;

    void askNickname();

    void askRestartGame();

    void notifyError(String error);
}
