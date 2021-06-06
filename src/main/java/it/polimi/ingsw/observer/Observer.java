package it.polimi.ingsw.observer;

import it.polimi.ingsw.messages.Message;

import java.io.IOException;

/**
 * Observer interface. It supports a generic method of update.
 */
public interface Observer {

    /**
     * used for all observer
     * @param message
     * @throws IOException
     * @throws InterruptedException
     */
    void update(Message message) throws IOException, InterruptedException;
    /**
     * used for only for current observer
     * @param message
     * @throws IOException
     * @throws InterruptedException
     */
    void updateOnlyCurrent(Message message) throws IOException, InterruptedException;


    /**
     * used for all observer less the current
     * @param message
     * @throws IOException
     * @throws InterruptedException
     */
   void updateNotTheCurrent(Message message) throws IOException, InterruptedException;

    /**
     * used for all observer filtering by nickname
     * @param message
     * @throws IOException
     * @throws InterruptedException
     */
    void updateOnlyObserverByNickname(Message message,String nickame) throws IOException, InterruptedException;

    /**
     * used for all observer less one filtering by nickname
     * @param message
     * @throws IOException
     * @throws InterruptedException
     */
  void updateAllObserverLessOneByNickname(Message message,String nickame) throws IOException, InterruptedException; }