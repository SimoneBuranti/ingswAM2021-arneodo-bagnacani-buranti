package it.polimi.ingsw.messages;

import java.io.IOException;

public class RestartQuestionMessage extends Message{

    private final MessageType messageType = MessageType.RESTARTQUESTIONMESSAGE;

    private int lobbySize;

    public RestartQuestionMessage(int lobbySize){
        this.lobbySize = lobbySize;
    }

    public int getLobbySize() {
        return lobbySize;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
