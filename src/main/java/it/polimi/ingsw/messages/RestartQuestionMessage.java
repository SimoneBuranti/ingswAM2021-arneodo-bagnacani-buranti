package it.polimi.ingsw.messages;

import java.io.IOException;

public class RestartQuestionMessage extends Message{

    private final MessageType messageType = MessageType.RESTARTQUESTIONMESSAGE;


    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
