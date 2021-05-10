package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

public class FaithPathOpponentMessage extends Message {
    private final MessageType messageType = MessageType.OPPONENTFAITHPATHMOVE;
    private String nickname;

    public FaithPathForNotCurrentMessage(String nickname){
    this.nickname=nickname;
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
