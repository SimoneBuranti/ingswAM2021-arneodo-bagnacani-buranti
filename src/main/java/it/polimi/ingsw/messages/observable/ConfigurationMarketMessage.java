package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.marbles.Marble;

import java.io.IOException;
import java.util.ArrayList;

public class ConfigurationMarketMessage extends Message {


    private final MessageType messageType = MessageType.CONFIGURATIONMARKET;



    private ArrayList<Marble> marbleList;


    public ConfigurationMarketMessage(ArrayList<Marble> list ){
        this.marbleList=new ArrayList();
        this.marbleList=list;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public ArrayList<Marble> getMarbleList() {
        return marbleList;
    }




}
