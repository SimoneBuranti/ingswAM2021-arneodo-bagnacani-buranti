package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class ChangeMarketMessageRow extends Message {
    private final MessageType messageType = MessageType.CHANGEMARKETMESSAGECOLUMN;
    private int row;
    public ChangeMarketMessageRow(int row){
        this.row =row;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public int getRow() {
        return row;
    }
}
