package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.commandParsers.MyTurnParser;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.*;

import java.util.ArrayList;

/**
 * This parser is used when a player has two different white-marble effect cleader cards.
 */
public class WhiteMarbleCommand extends Command {

    /**
     * This attribute contains the possible resources.
     */
    private ArrayList<Resource> resources;

    /**
     * Cli reference.
     */
    private Cli cli;

    public WhiteMarbleCommand(ArrayList<Resource> resources,Cli cli) {
        this.resources = resources;
        this.cli = cli;
    }

    /**
     * This method set the normal turn parser and return a WhiteMarbleChoosenResourcesMessage.
     * @return
     * @throws SpentTokenException
     * @throws InvalidCommandException
     * @throws AlreadyActivatedProductionException
     * @throws NoMessageReturnException
     */
    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException {
        cli.changeCommandParser(new MyTurnParser());

        return new WhiteMarbleChoosenResourcesMessage(resources);
    }

    /**
     * Possible resource getter.
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
