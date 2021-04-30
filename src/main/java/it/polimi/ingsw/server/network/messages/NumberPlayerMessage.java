package it.polimi.ingsw.server.network.messages;

public class NumberPlayerMessage extends Message {

    private int nOfPlayers;

    /**
     * type of message
     */
    private final MessageType messageType=MessageType.PLAYERNUMBER;
    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getnOfPlayers() {
        return nOfPlayers;
    }

    public void setnOfPlayers(int nOfPlayers) {
        this.nOfPlayers = nOfPlayers;
    }
}
