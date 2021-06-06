package it.polimi.ingsw.messages;

public class BootingLobbyErrorMessage extends Message{
    /**
     * message which contain the information of waited match
     * is message from server to client when user
     * are waited to join in game
     */
    private final MessageType messageType = MessageType.BOOTINGLOBBYERROR;

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "Initial lobby waiting for creation, please wait a few moments...";
    }
}
