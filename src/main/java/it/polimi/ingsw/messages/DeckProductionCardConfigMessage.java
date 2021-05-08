package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;

public class DeckProductionCardConfigMessage extends Message{


    private final MessageType messageType = MessageType.DECKPRODUCTIONCARD;

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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public int getNumberDeck() {
        return NumberDeck;
    }



    public ArrayList<Integer> Deck() {
        return deck;
    }

}
