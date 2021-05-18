package it.polimi.ingsw.Client.View;

import it.polimi.ingsw.Client.View.LigtModelNotification.Notification;
import it.polimi.ingsw.messages.Message;

import java.io.IOException;

public interface View  {
    public void update(String notification) throws IOException, InterruptedException;

}
