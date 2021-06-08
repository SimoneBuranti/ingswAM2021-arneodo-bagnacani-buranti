package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;

public class DeckProductionCardConfigMessage extends Message {

    /**
     * message which contain the information
     * for configure light model deck at restart or simple start game
     * it includes te list of production card in right order bby key
     * it includes also the deck number
     * from server to client
     */
    private final MessageType messageType = MessageType.DECKPRODUCTIONCARDCONFIG;

    private int NumberDeck;

    private ArrayList<Integer> deck=new ArrayList();


    public DeckProductionCardConfigMessage(int numberDeck, ArrayList<Integer> list ){
        this.NumberDeck=numberDeck;
        this.deck=new ArrayList();
        this.deck=list;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getNumberDeck() {
        return NumberDeck;
    }

    public ArrayList<Integer> getDeck() {
        return deck;
    }

}
