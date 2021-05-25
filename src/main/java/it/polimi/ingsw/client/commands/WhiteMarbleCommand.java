package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.commandParsers.MyTurnParser;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.*;

import java.util.ArrayList;

public class WhiteMarbleCommand extends Command {

    private ArrayList<Resource> resources;
    private Cli cli;

    public WhiteMarbleCommand(ArrayList<Resource> resources,Cli cli) {
        this.resources = resources;
        this.cli = cli;
    }


    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException {
        cli.changeCommandParser(new MyTurnParser());

        return new WhiteMarbleChoosenResourcesMessage(resources);
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
