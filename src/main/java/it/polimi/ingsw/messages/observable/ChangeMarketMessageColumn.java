package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.marbles.Marble;

import java.util.ArrayList;

public class ChangeMarketMessageColumn extends Message {
    private final MessageType messageType = MessageType.CHANGEMARKETMESSAGECOLUMN;
private int column;
    public ChangeMarketMessageColumn(int column){
        this.column=column;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public int getColumn() {
        return column;
    }
}
