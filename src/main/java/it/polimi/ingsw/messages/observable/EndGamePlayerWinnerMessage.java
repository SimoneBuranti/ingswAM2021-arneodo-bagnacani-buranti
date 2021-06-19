package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;
import java.util.Map;

public class EndGamePlayerWinnerMessage extends Message {
    /**
     * message which contain the information
     * for notify opponent view and current views abbout the winner nickname
     * after end game
     * from server to client
     */
    private final MessageType messageType = MessageType.ENDGAMEWINNER;
   private String nickname;
   private Map<String, Integer> scoreOfPlayers;

    public EndGamePlayerWinnerMessage(String nickname, Map<String,Integer> map){
        this.nickname=nickname;
        this.scoreOfPlayers = map;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public Map<String, Integer> getScoreOfPlayers() {
        return scoreOfPlayers;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString(){
        return "The winner is: "+getNickname() + " \n The scores of the players are: " + scoreOfPlayers;
    }
}
