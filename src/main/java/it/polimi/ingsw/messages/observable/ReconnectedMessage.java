package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class ReconnectedMessage extends Message {
    /**
     * message which contain the information
     * for notify players view about reconnection of opponent
     * after old disconnection
     * from server to client
     */
    private final MessageType messageType = MessageType.RECONNECTIONOPPONENT;



    private String string;

    public ReconnectedMessage(String player){

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
        return string+" " + " came back ";
    }
}
