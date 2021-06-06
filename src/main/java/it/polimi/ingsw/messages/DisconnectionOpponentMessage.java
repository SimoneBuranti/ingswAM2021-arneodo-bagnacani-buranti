package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class DisconnectionOpponentMessage extends Message{
    /**
     * message which contain the notification of a opponent disconnection
     */
    private final MessageType messageType = MessageType.DISCONNECTIONOPPONENT;



    private String string;

    public DisconnectionOpponentMessage(String player){

        this.string=player;


    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public String getNickName() {
        return string;
    }



    @Override
    public String toString(){
        return string+" " + "left the match";
    }
}
