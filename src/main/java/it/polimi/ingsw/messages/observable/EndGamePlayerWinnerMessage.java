package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class EndGamePlayerWinnerMessage extends Message {
    /**
     * message which contain the information
     * for notify opponent view and current views abbout the winner nickname
     * after end game
     * from server to client
     */
    private final MessageType messageType = MessageType.ENDGAMEWINNER;
   private String nickname;

    public EndGamePlayerWinnerMessage(String nickname){
        this.nickname=nickname;
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

    @Override
    public String toString(){
        return "the winner is: "+getNickname();
    }
}
