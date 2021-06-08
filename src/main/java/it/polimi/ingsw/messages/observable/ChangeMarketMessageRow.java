package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class ChangeMarketMessageRow extends Message {
    /**
     * message which contain the information
     * for notify your light model and opponent light model about changes on market
     * after market action (row push)
     * from server to client
     */
    private final MessageType messageType = MessageType.CHANGEMARKETMESSAGEROW;
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
