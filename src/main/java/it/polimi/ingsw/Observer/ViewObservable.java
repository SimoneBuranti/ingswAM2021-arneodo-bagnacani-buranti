package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Client.View.View;
import it.polimi.ingsw.messages.Message;

import java.io.IOException;

public class ViewObservable {


    private View observer;

    /**
     * Notifies all the current observers through the update method and passes to them a {@link Message}.
     *
     */


    public void setObserver(View observer) {
        this.observer = observer;
    }
}
