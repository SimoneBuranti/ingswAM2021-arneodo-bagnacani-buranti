package it.polimi.ingsw.messages;

import java.io.IOException;

public class RestartAnswerMessage extends Message{
    private final MessageType messageType = MessageType.RESTARTANSWERMESSAGE;

    private boolean answer;

    public RestartAnswerMessage(boolean answer) {
        this.answer = answer;
    }

    public boolean getAnswer() {
        return answer;
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
