package it.polimi.ingsw.messages;

public class NPlayersMessage extends Message {

    private int nOfPlayers;
    /**
    * type of message
    */
    private final MessageType messageType=MessageType.MESSAGEFORNPLAYERS;

    public NPlayersMessage(int nOfPlayers){
        this.nOfPlayers = nOfPlayers;
    }


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getMissPlayer() {
        return nOfPlayers;
    }

    public void setMissPlayer(int nOfPlayers) {
        this.nOfPlayers = nOfPlayers;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
