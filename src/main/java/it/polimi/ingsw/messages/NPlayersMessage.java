package it.polimi.ingsw.messages;

public class NPlayersMessage extends Message {

    private int missPlayer;
    /**
 * type of message
 */
private final MessageType messageType=MessageType.MESSAGEFORNPLAYERS;




    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getMissPlayer() {
        return missPlayer;
    }

    public void setMissPlayer(int missPlayer) {
        this.missPlayer = missPlayer;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
