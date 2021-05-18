package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class GameTypeMessage extends Message {
 private boolean multiOrNot;
 public GameTypeMessage(boolean multiOrNot){
     this.multiOrNot=multiOrNot;

 }

    private final MessageType messageType = MessageType.GAMETYPE;
    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public boolean isMultiOrNot() {
        return multiOrNot;
    }
}
