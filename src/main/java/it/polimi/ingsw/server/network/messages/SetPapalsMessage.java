package it.polimi.ingsw.server.network.messages;

public class SetPapalsMessage extends Message{
    private final MessageType messageType = MessageType.SETPAPALS;
    private int currCall;

    public int getCurrCall() {
        return currCall;
    }

    public void setCurrCall(int currCall) {
        this.currCall = currCall;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
