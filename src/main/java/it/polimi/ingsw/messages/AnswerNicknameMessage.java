package it.polimi.ingsw.messages;

import java.io.IOException;

public class AnswerNicknameMessage extends Message{
    /**
 * type of message
 */
private final MessageType messageType=MessageType.USERNAMEANSWER;

    private String username;

    public AnswerNicknameMessage(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
