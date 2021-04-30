package it.polimi.ingsw.server.network.messages;


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
}
