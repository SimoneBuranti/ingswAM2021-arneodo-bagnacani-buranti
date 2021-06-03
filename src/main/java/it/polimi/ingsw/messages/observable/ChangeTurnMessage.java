package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class ChangeTurnMessage extends Message {
   private String nickName;
    public ChangeTurnMessage(String nickName) {
        this.nickName=nickName;
    }

    private final MessageType messageType = MessageType.CHANGETURN;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public String getNickName() {
        return nickName;
    }
}
