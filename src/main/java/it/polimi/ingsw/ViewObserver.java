package it.polimi.ingsw;

import it.polimi.ingsw.messages.Message;

import java.io.IOException;

public interface ViewObserver {
    void update(Message message) throws IOException, InterruptedException;
}
