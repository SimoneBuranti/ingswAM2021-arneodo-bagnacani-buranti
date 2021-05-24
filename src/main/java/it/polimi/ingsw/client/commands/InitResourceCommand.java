package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.InitialResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class InitResourceCommand extends Command{


    private ArrayList<Resource> initResources;

    public InitResourceCommand(ArrayList<Resource> resources) {
        this.initResources=resources;
    }

    public ArrayList<Resource> getResources() {
        return initResources;
    }

    @Override
    public Message commandOn(){
        return new InitialResourcesMessage(initResources);
    }
}
