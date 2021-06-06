package it.polimi.ingsw.messages;

public class RequirementsErrorMessage extends Message {
    /**
     * message error of Requirements from server to client
     * due to activation leader card error
     */
    private final MessageType messageType = MessageType.REQUIREMENTSERROR;
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
        return "Sorry, you don't meet the requirements to activate the leader card.";
    }
}
