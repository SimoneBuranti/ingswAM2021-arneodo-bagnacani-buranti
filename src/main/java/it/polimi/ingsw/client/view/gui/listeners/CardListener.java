package it.polimi.ingsw.client.view.gui.listeners;

import it.polimi.ingsw.client.view.gui.CardManager;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.KeepLeaderCardsMessage;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the listener of the initial leader cards that are chosen
 */
public class CardListener implements MouseListener {
    /**
     * This attribute represents the reference to the card to listen
     */
    private final LeaderCard card;
    /**
     * This attribute represents the reference to the gui
     */
    private Gui gui;
    /**
     * This attribute contains the values to send to the server
     */
    private static ArrayList<Integer> sendableArrayInt = new ArrayList<>();



    /**
     * Constructor: build a CardListener with single selection
     * @param card                  The managed card
     * @param cardManager          The card switcher to be controlled
     * @param selectable            True to enable single selection, otherwise false
     */
    public CardListener(LeaderCard card, CardManager cardManager, boolean selectable, Gui gui) {
        this.card = card;
        this.gui=gui;
    }

    /**
     * Mouse on-card-click manager: if multiple selection is enabled update the guiView, otherwise do nothing
     * @param e The mouse event
     */
    public void mouseClicked(MouseEvent e) {
        addPlayerCardToArrayList(card);
        if (gui.getReadyToSend()==2){
            (new Thread(() -> {
                try {
                gui.notifyObserver(new KeepLeaderCardsMessage(CardListener.getSendableArrayInt().get(0),CardListener.getSendableArrayInt().get(1) ));
                gui.askInitResource("Out of EDT");
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
                    })).start();
            
        }
    }

    /**
     * This method adds a leader card to the listener
     */
    private void addPlayerCardToArrayList(LeaderCard card) {
        addPlayerCardToArrayListInt(card);
    }

    /**
     * This method adds the number corresponding to the leader card to be added
     */
    private void addPlayerCardToArrayListInt(LeaderCard card) {
        for(int i=0; i<gui.getViewController().getGame().getLeaderCards().size(); i++){
            if (gui.getViewController().getGame().getLeaderCards().get(i).equals(card)){
                if (sendableArrayInt.size()==1)
                    {
                        if (!(sendableArrayInt.get(0) ==i))
                        {
                            sendableArrayInt.add(i);
                            gui.setReadyToSend();
                        }
                    }

                else
                    {
                            sendableArrayInt.add(i);
                            gui.setReadyToSend();
                    }
            }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    /**
     * @return the array list sendableArrayInt
     */
    public static ArrayList<Integer> getSendableArrayInt(){
        return sendableArrayInt;
    }

}