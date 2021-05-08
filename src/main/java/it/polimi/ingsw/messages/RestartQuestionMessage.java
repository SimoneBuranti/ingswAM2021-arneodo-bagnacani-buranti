package it.polimi.ingsw.messages;

public class RestartQuestionMessage extends Message{

    private final MessageType messageType = MessageType.RESTARTQUESTIONMESSAGE;


    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
