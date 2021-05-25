package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.commandParsers.MyTurnParser;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class KeepResourcesCommand extends Command{

    private ArrayList<Resource> resources;
    private Cli cli;
    public KeepResourcesCommand(ArrayList<Resource> resources,Cli cli) {
        this.cli = cli;
        this.resources = resources;
    }


    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException {
        System.out.println("Sono qui a");
        this.cli.changeCommandParser(new MyTurnParser());
        System.out.println("Sono qui b, resources: "+resources);
        return new KeepResourcesMessage(resources);
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public static String defToString(){
        return "[ResourceType] [ResourceType] .. ";
    }

    public String toString(){
        return resources.toString();
    }
}
