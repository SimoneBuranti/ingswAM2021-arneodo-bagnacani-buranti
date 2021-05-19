package it.polimi.ingsw.messages;

public class SetPapalsMessage extends Message{
    private final MessageType messageType = MessageType.SETPAPALS;
    private int currCall;
    private String nickname;

    public SetPapalsMessage(int currCall, String nickname){
        this.currCall = currCall;
        this.nickname = nickname;
    }

    public int getCurrCall() {
        return currCall;
    }

    public String getNickname() {
        return nickname;
    }

    public void setCurrCall(int currCall) {
        this.currCall = currCall;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
