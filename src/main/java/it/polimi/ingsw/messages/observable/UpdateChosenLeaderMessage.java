package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;

public class UpdateChosenLeaderMessage extends Message {
    /**
     * message which contain the information
     * for notify your light model about your first chosen leader cards
     * from server to client
     */
    private final MessageType messageType = MessageType.UPDATECHOSENLEADERCARD;


    private int cardFirst;

    private int cardSec;


    public UpdateChosenLeaderMessage(int cardFirst, int cardSec){

        this.cardFirst=cardFirst;
        this.cardSec =cardSec;


    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public int getCardFirst() {
        return cardFirst;
    }

    public int getCardSec() {
        return cardSec;
    }
}
