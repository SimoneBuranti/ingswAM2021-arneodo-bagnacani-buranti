package it.polimi.ingsw.messages;

import java.io.IOException;

public class NumberPlayerMessage extends Message {

    private int nOfPlayers;


    /**
     * message which contain the information of the answer to number player question from client to server
     */
    private final MessageType messageType=MessageType.PLAYERNUMBER;

    public NumberPlayerMessage(int nOfPlayers) {
        this.nOfPlayers = nOfPlayers;
    }

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

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
