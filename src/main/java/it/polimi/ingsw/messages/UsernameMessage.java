package it.polimi.ingsw.messages;

public class UsernameMessage extends Message{

    /**
 * type of message
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

    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
