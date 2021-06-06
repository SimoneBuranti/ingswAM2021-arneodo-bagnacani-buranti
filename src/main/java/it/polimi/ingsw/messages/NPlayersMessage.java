package it.polimi.ingsw.messages;

import java.io.IOException;

public class NPlayersMessage extends Message {

    private int nOfPlayers;
    private int lobbySize;

    /**
     * message which contain the information for new and old connected for
     * missing user number from server to client
     */
    private final MessageType messageType=MessageType.MESSAGEFORNPLAYERS;

    public NPlayersMessage(int nOfPlayers,int lobbySize){
        this.nOfPlayers = nOfPlayers;
        this.lobbySize = lobbySize;
    }

    public NPlayersMessage(int nOfPlayers){
        this.nOfPlayers = nOfPlayers;
        this.lobbySize = 0;
    }


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getLobbySize() {
        return lobbySize;
    }

    public int getnOfPlayers() {
        return nOfPlayers;
    }

    public void setnOfPlayers(int nOfPlayers) {
        this.nOfPlayers = nOfPlayers;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
