package it.polimi.ingsw.server.network.messages;

public class KeepLeaderCardsMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.KEEPLEADERCARDS;

    private int[] chosenLeaderCards;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }


    public int[] getChosenLeaderCards() {
        return chosenLeaderCards;
    }

    public void setChosenLeaderCards(int[] chosenLeaderCards) {
        this.chosenLeaderCards = chosenLeaderCards;
    }
}
