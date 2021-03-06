package it.polimi.ingsw.observer;

import it.polimi.ingsw.messages.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Observable class that can be observed by implementing the {@link Observer} interface and registering as listener.
 */
public class Observable {

    /**
     * list of observer of game
     */
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer.
     *
     * @param obs the observer to be added.
     */
    public void addObserver(Observer obs) {
        observers.add(obs);
    }


    /**
     * Notifies all the current observers through the update method and passes to them a {@link Message}.
     *
     * @param message the message to be passed to the observers.
     */
    protected void notifyObserver(Message message) throws IOException, InterruptedException {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Notifies the observer through the update method and passes message
     *
     * @param message the message to be passed to the observer.
     */

    protected void notifyToOneObserver(Message message) throws IOException, InterruptedException {
        for (Observer observer : observers) {
            observer.updateOnlyCurrent(message);
        }
    }


    /**
     * Notifies the observer through the update method and passes message
     *
     * @param message the message to be passed to the observer.
     */

    protected void notifyAllObserverLessOne(Message message) throws IOException, InterruptedException {
        for (Observer observer : observers) {
            observer.updateNotTheCurrent(message);
        }
    }


    /**
     * Notifies the observer through the update method and passes message
     *  @param message the message to be passed to the observer.
     *
     */

    protected void notifyOnlyOneSpecificObserver(Message message, String nickname) throws IOException, InterruptedException {
        for (Observer observer : observers) {
            observer.updateOnlyObserverByNickname(message,nickname);
        }
    }


    /**
     * Notifies the observer through the update method and passes message
     *
     * @param message the message to be passed to the observer.
     */

    protected void notifyAllObserverLessOneByNickname(Message message,String nickname) throws IOException, InterruptedException {
        for (Observer observer : observers) {
            observer.updateAllObserverLessOneByNickname(message,nickname);
        }
    }










}