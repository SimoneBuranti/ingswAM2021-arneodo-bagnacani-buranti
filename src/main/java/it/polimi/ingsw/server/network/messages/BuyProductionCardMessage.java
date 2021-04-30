package it.polimi.ingsw.server.network.messages;

public class BuyProductionCardMessage extends Message{
    private final MessageType messageType = MessageType.BUYPRODUCTIONCARD;
    private int deckNumber;

    public int getDeckNumber() {
        return deckNumber;
    }

    public void setDeckNumber(int deckNumber){
        this.deckNumber = deckNumber;
    }
}
