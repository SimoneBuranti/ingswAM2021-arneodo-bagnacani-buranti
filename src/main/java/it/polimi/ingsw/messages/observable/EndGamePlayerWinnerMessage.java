package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.players.Player;

public class EndGamePlayerWinnerMessage extends Message {
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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }



    public String getNickname() {
        return nickname;
    }
}
