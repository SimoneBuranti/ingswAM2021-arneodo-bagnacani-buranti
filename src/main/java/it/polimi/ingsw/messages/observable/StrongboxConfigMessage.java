package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StrongboxConfigMessage extends Message {
    /**
     * message which contain the information
     * for notify your light strongbox after game restart
     * it map of strongbox
     * from server to client
     */
    private final MessageType messageType = MessageType.CONFIGURATIONSTRONGBOX;




    private Map<Resource, Integer> strongBoxResource;



    public StrongboxConfigMessage(Map<Resource, Integer> strongBoxResource) {
        this.strongBoxResource=new HashMap<>();
        this.strongBoxResource=strongBoxResource;
    }


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public Map<Resource, Integer> getStrongBoxResource() {
        return strongBoxResource;
    }
}
