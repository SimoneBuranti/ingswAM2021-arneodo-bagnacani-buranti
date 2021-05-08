package it.polimi.ingsw.messages;

public class RestartAnswerMessage extends Message{
    private final MessageType messageType = MessageType.RESTARTANSWERMESSAGE;

    private String answer;

    public RestartAnswerMessage(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
