package it.polimi.ingsw.messages;

import java.io.IOException;

public class KeepLeaderCardsMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.KEEPLEADERCARDS;

    private int[] chosenLeaderCards= new int[2];

    public KeepLeaderCardsMessage(int contOne, int contSecond) {
        chosenLeaderCards[0]=contOne;
        chosenLeaderCards[1]=contSecond;

    }


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

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
