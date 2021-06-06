package it.polimi.ingsw.messages;

import java.io.IOException;

public class AskInformationMessage extends Message {
    /**
     * message which contain the information request to know about the selected player
     */
    private final MessageType messageType=MessageType.ASKINFO;
    private int n;
    public AskInformationMessage(int numberPlayer) {
       this.n=numberPlayer;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getN() {
        return n;
    }
}
