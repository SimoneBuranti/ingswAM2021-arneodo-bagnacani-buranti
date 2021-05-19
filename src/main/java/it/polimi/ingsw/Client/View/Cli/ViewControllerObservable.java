package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.Message;

import java.io.IOException;

public class ViewControllerObservable {

    private ViewController observer;

    /**
     * Notifies all the current observers through the update method and passes to them a {@link Message}.
     *
     */
    protected void notifyObserver(Message message) throws IOException, InterruptedException {
        observer.update(message);
    }

    public void setObserver(ViewController observer) {
        this.observer = observer;
    }
}