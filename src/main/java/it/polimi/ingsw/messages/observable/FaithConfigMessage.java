package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class FaithConfigMessage extends Message {
    /**
     * message which contain the information
     * for notify your light faith path after game restart
     * it includes the indicator but also te currCall value
     * from server to client
     */
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
