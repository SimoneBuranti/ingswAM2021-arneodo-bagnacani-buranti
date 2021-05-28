package it.polimi.ingsw.client.view.gui;

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
    private final CardManager cardManager;
    private boolean multipleSelection;
    private boolean singleSelection;
    private int numCards;
    private List<LeaderCard> chosenCards;
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
        this.multipleSelection = true;
        this.singleSelection = false;
        this.card = card;
        this.cardManager = cardManager;
        this.chosenCards = chosenCards;
        this.numCards = numCards;
        this.gui=gui;

    }

    /**
     * Constructor: build a CardListener with single selection
     * @param card                  The managed card
     * @param cardManager          The card switcher to be controlled
     * @param selectable            True to enable single selection, otherwise false
     */
    public CardListener(LeaderCard card, CardManager cardManager, boolean selectable, Gui gui) {
        this.multipleSelection = false;
        this.singleSelection = selectable;
        this.card = card;
        this.cardManager = cardManager;
        this.gui=gui;
    }

    /**
     * Mouse on-card-click manager: if multiple selection is enabled update the guiView, otherwise
     * if single selection is enabled update the guiView, otherwise do nothing
     * @param e The mouse event
     */
    public void mouseClicked(MouseEvent e) {
                addPlayerCardToArrayList(card);
                gui.setReadyToSend();
        if (gui.getReadyToSend()==2)
            try {
                gui.notifyObserver(new KeepLeaderCardsMessage(CardListener.getSendableArrayInt().get(0),CardListener.getSendableArrayInt().get(1) ));
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
    }

    private void addPlayerCardToArrayList(LeaderCard card) {
        addPlayerCardToArrayListInt(card);
    }

    private void addPlayerCardToArrayListInt(LeaderCard card) {
        for(int i=0; i<gui.getViewController().getGame().getGameBoardOfPlayer().getLeaderCards().size(); i++)
            if (gui.getViewController().getGame().getGameBoardOfPlayer().getLeaderCards().get(i).equals(card))
                sendableArrayInt.add(i);
    }


    /**
     * Mouse on-card-press manager: same as on-card-click
     * @param e The mouse event
     */
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
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