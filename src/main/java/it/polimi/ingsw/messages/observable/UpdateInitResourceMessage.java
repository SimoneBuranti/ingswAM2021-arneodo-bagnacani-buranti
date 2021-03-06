package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;

public class UpdateInitResourceMessage extends Message {
    /**
     * message which contain the information
     * for notify your light model about your first chosen resource
     * from server to client
     */
    private final MessageType messageType = MessageType.UPDATEINITRESOURCE;


    private Resource r1;

    private Resource r2;


    public UpdateInitResourceMessage(Resource r1, Resource r2){

        this.r1=r1;
        this.r2 =r2;


    }
    public UpdateInitResourceMessage(Resource r1){

        this.r1=r1;

    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public Resource getR1() {
        return r1;
    }

    public Resource getR2() {
        return r2;
    }
}
