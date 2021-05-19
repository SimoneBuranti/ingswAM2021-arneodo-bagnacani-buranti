package it.polimi.ingsw.messages;

public class CompleteRunningMatchErrorMessage extends Message{
    /**
     * type of message
     */
    private final MessageType messageType=MessageType.COMPLETERUNNINGMATCHERROR;


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString(){
        return "Sorry, the game is full!";
    }
}
