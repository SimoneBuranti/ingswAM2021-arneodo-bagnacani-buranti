package it.polimi.ingsw.server.network.messages;

public class DoubleWhiteMarbleEffectMessage extends Message {
    private final MessageType messageType = MessageType.DOUBLEWHITEMARBLEEFFECT;

    private int whiteMarbleNumber;
@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getWhiteMarbleNumber() {
        return whiteMarbleNumber;
    }
}
