package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class FaithConfigMessage extends Message {
    private final MessageType messageType = MessageType.MYFAITHMOVECONFIG;
    private int faithConfig;
    private int currCall;


    public FaithConfigMessage(int indicator, int currCall) {
        this.faithConfig=indicator;
        this.currCall=currCall;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getFaithConfig() {
        return faithConfig;
    }

    public int getCurrCall() {
        return currCall;
    }
}
