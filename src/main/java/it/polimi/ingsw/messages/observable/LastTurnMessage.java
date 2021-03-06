package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class LastTurnMessage extends Message {
    /**
     * message which contain the information
     * for notify all players for the last turn
     * due to last turn exception
     * from server to client
     */
    private final MessageType messageType = MessageType.LASTTURN;

    private String nickname;

    public LastTurnMessage(String nickName){
        this.nickname = nickName;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public String getNickname() {
        return nickname;
    }
}