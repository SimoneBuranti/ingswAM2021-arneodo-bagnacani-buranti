package it.polimi.ingsw.messages;


public class OpponentFaithMoveMessage extends Message{
    private final MessageType messageType = MessageType.OPPONENTFAITHMOVE;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
