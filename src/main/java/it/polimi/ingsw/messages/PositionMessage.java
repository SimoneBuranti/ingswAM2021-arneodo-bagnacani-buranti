package it.polimi.ingsw.messages;

import java.io.IOException;

public class PositionMessage extends Message {

    private int pos;

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.POSITION;

    public PositionMessage(int position) {
        this.pos = position;
    }

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }



    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
