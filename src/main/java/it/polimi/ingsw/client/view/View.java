package it.polimi.ingsw.client.view;

import java.io.IOException;

public interface View  {
    public void update(String notification) throws IOException, InterruptedException;

}
