package it.polimi.ingsw.messages;

public class CompleteRunningMatchErrorMessage extends Message{
    /**
     * message which contain the information of complete match
     * is a error message from server to client when user
     * tries to connected to match
     * but game is full and complete
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
