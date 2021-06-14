package it.polimi.ingsw.messages;

public class GameEndedMessage extends Message {
    /**
 * message which contain the information of ended match
 * is message from server to client when user
 * is trying to reconnected to the match, but it is ended
 */
private final MessageType messageType = MessageType.GAMEERROREND;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "sorry, end game, please try after few minutes";
    }
}
