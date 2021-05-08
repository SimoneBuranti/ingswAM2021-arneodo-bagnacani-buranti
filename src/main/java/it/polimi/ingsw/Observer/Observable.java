package it.polimi.ingsw.Observer;

import it.polimi.ingsw.messages.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable class that can be observed by implementing the {@link Observer} interface and registering as listener.
 */
public class Observable {

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
     * Removes an observer.
     *
     * @param obs the observer to be removed.
     */
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Notifies all the current observers through the update method and passes to them a {@link Message}.
     *
     * @param message the message to be passed to the observers.
     */
    protected void notifyObserver(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Notifies the observer through the update method and passes message
     *
     * @param message the message to be passed to the observer.
     * @param observer the message to be passed to the observer.
     */

    protected void notifyToOneObserver(Message message, Observer observer) {
        observer.update(message);

    }













}