package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.commandParsers.StandardParser;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.InitialResourcesMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class InitResourceCommand extends Command{


    private Cli cli;
    private ArrayList<Resource> initResources;

    public InitResourceCommand(ArrayList<Resource> resources,Cli cli) {
        this.initResources = new ArrayList<>();
        this.cli = cli;
        this.initResources=resources;
    }

    public ArrayList<Resource> getResources() {
        return initResources;
    }

    @Override
    public Message commandOn() throws EndAfterThisException {
        throw new EndAfterThisException(new InitialResourcesMessage(initResources));
    }
}
