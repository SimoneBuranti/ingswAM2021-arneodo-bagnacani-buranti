package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class LorenzoTheMagnificentConfigMessage extends Message {

    private final MessageType messageType = MessageType.LORENZOCONFIG;




    private int faithIndicator;


    public LorenzoTheMagnificentConfigMessage(int faithIndicator){

        this.faithIndicator =faithIndicator;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }



    public int getFaithIndicator() {
        return faithIndicator;
    }


}
