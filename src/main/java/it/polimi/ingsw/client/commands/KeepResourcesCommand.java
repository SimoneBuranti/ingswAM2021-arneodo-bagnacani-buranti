package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class KeepResourcesCommand extends Command{

    private ArrayList<Resource> resources;

    public KeepResourcesCommand(ArrayList<Resource> resources) {
        this.resources = resources;
    }


    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException {
        return new KeepResourcesMessage(resources);
    }


    public static String defToString(){
        return "[ResourceType] [ResourceType] .. ";
    }

    public String toString(){
        return resources.toString();
    }
}
