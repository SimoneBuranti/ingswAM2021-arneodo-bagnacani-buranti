package it.polimi.ingsw.Observer;

import it.polimi.ingsw.messages.Message;

/**
 * Observer interface. It supports a generic method of update.
 */
public interface Observer {

    void update(Message message);

    void updateOnlyCurrent(Message message);

    public void updateNotTheCurrent(Message message);


}