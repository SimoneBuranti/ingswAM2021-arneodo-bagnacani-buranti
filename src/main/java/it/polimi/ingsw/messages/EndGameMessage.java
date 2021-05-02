package it.polimi.ingsw.messages;

import java.util.Map;

public class EndGameMessage extends Message{
    private final MessageType messageType = MessageType.ENDGAME;
    private Map<String, Integer> scoreOfPlayers;

    public Map<String, Integer> getScoreOfPlayers() {
        return scoreOfPlayers;
    }

    public void setScoreOfPlayers(Map<String, Integer> scoreOfPlayers) {
        this.scoreOfPlayers = scoreOfPlayers;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
