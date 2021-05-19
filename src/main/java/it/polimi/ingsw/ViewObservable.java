package it.polimi.ingsw;

import it.polimi.ingsw.View;
import it.polimi.ingsw.messages.Message;

import java.io.IOException;

public class ViewObservable {


    private View observer;

    /**
     * Notifies all the current observers through the update method and passes to them a {@link Message}.
     *
     */
    protected void notifyObserver(String notification) throws IOException, InterruptedException {
            observer.update(notification);
         }

    public void setObserver(View observer) {
        this.observer = observer;
    }
}
