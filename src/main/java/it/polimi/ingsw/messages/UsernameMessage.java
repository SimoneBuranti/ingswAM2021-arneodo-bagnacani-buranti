package it.polimi.ingsw.messages;

import java.io.IOException;

public class UsernameMessage extends Message{
    /**
 *message for say the username from client to server
 */
private final MessageType messageType=MessageType.USERNAME;

    private String username;

    public UsernameMessage(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
