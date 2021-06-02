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
 * The mouse event manager for the card switcher
 */
public class CardListener implements MouseListener {
    private final LeaderCard card;
    private Gui gui;
    private ArrayList<LeaderCard> sendableArray = new ArrayList<>();
    private static ArrayList<Integer> sendableArrayInt = new ArrayList<>();

    /**
     * Constructor: build a CardListener with multiple selection enabled
     *
     * @param card         The managed card
     * @param chosenCards  The chosen cards
     * @param cardManager The card switcher to be controlled
     * @param numCards     The number of cards to be selected
     */
    public CardListener(LeaderCard card, CardManager cardManager, List<LeaderCard> chosenCards, int numCards, Gui gui) {

        this.card = card;
        this.gui=gui;

    }

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
     * Mouse on-card-click manager: if multiple selection is enabled update the guiView, otherwise
     * if single selection is enabled update the guiView, otherwise do nothing
     * @param e The mouse event
     */
    public void mouseClicked(MouseEvent e) {
        addPlayerCardToArrayList(card);
        if (gui.getReadyToSend()==2){
            (new Thread(() -> {
                try {
                gui.notifyObserver(new KeepLeaderCardsMessage(CardListener.getSendableArrayInt().get(0),CardListener.getSendableArrayInt().get(1) ));
                gui.askInitResource();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
                    })).start();}
    }

    private void addPlayerCardToArrayList(LeaderCard card) {
        addPlayerCardToArrayListInt(card);
    }

    private void addPlayerCardToArrayListInt(LeaderCard card) {
        for(int i=0; i<gui.getViewController().getGame().getGameBoardOfPlayer().getLeaderCards().size(); i++){
            if (gui.getViewController().getGame().getGameBoardOfPlayer().getLeaderCards().get(i).equals(card)){
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


    /**
     * Mouse on-card-press manager: same as on-card-click
     * @param e The mouse event
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Do nothing
     * @param e The mouse event
     */
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public static ArrayList<Integer> getSendableArrayInt(){
        return sendableArrayInt;
    }

}