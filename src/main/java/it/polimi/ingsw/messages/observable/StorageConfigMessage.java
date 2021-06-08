package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.gameBoard.GameBoard;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageConfigMessage extends Message {
    /**
     * message which contain the information
     * for notify your light storage after game restart
     * it map of storage
     * from server to client
     */
    private final MessageType messageType = MessageType.CONFIGURATIONSTORAGE;
    private Map<Resource, Integer> resource;



    public StorageConfigMessage(Map<Resource, Integer> availableResources) {
        resource=new HashMap<>();
        this.resource=availableResources;

    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public Map<Resource, Integer> getResource() {
        return resource;
    }
}
