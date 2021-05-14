package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

public class FaithPathOpponentMessage extends Message {
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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
