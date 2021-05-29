package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MainFrame  extends JFrame {



    private GameboardPanel gameboardPanel;


    public MainFrame(String title){
        super(title);

    }


    public abstract void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException;

    protected abstract void applyChangesTo(Component component);

    protected abstract void clear(JFrame frame);

    protected abstract void clear(JPanel panel);

    public abstract void showLabel(Message message);

    public abstract void askInitResource() throws IOException, InterruptedException;
}
