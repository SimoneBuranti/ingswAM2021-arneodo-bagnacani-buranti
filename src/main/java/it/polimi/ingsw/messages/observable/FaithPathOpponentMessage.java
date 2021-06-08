package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class FaithPathOpponentMessage extends Message {
    /**
     * message which contain the information
     * for notify opponent light faith path of server model changes
     * from server to client
     */
    private final MessageType messageType = MessageType.OPPONENTFAITHPATHMOVE;
    private String nickname;
    private int faithMove;

    public FaithPathOpponentMessage(String nickname, int faithMove){
    this.nickname=nickname;
    this.faithMove=faithMove;
}
    public String getNickname() {
        return nickname;
    }



    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public String toString(){
        return nickname +" moved ahead of " + faithMove + " positions in the faith path.";
    }
}
