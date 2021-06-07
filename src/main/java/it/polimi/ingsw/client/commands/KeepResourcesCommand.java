package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.commandParsers.MyTurnParser;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.KeepResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class KeepResourcesCommand extends Command{

    /**
     * Resource arrayList.
     */
    private ArrayList<Resource> resources;

    /**
     * Cli reference.
     */
    private Cli cli;

    /**
     * Class constructor
     * @param resources
     * @param cli
     */
    public KeepResourcesCommand(ArrayList<Resource> resources,Cli cli) {
        this.cli = cli;
        this.resources = resources;
    }

    /**
     * This commandOn method changes the current parser in a MyTurnParser and returns a KeepResourcesMessage instance.
     * @return
     * @throws SpentTokenException
     * @throws InvalidCommandException
     * @throws AlreadyActivatedProductionException
     * @throws NoMessageReturnException
     */
    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException {
        //System.out.println("Sono qui a");
        this.cli.changeCommandParser(new MyTurnParser());
        //System.out.println("Sono qui b, resources: "+resources);
        return new KeepResourcesMessage(resources);
    }

    /**
     * Resources arraylist getter
     * @return
     */
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
