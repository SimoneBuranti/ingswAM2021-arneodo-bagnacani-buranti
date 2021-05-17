package it.polimi.ingsw.Observer;

import it.polimi.ingsw.messages.Message;

import java.io.IOException;

/**
 * Observer interface. It supports a generic method of update.
 */
public interface Observer {

    void update(Message message) throws IOException, InterruptedException;

    void updateOnlyCurrent(Message message) throws IOException, InterruptedException;

   void updateNotTheCurrent(Message message) throws IOException, InterruptedException;


    void updateOnlyObserverByNickname(Message message,String nickame) throws IOException, InterruptedException;

  void updateAllObserverLessOneByNickname(Message message,String nickame) throws IOException, InterruptedException; }