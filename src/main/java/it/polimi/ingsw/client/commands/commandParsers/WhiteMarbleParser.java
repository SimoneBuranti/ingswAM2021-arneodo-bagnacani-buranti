package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

public class WhiteMarbleParser implements CommandParser {

    private int numberOfWhiteMarbles;

    private ArrayList<Resource> possibleResources;

    public WhiteMarbleParser(int numberOfWhiteMarbles, ArrayList<Resource> possibleResources) {
        this.numberOfWhiteMarbles = numberOfWhiteMarbles;
        this.possibleResources = possibleResources;
    }

    @Override
    public Command parseCommand(String commandText, ViewController viewController, View view) throws InvalidCommandException {

        String word = "";
        Resource resource;

        ArrayList<Resource> resources = new ArrayList<>();

        if (commandText.length() == 0)
            throw new InvalidCommandException();

        for (int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i) != ' '){
                word = word + commandText.charAt(i);
            } else {
                resource = Command.fromStringToResource(word);
                if(resource != null )
                    for(Resource r : possibleResources)
                        if (r== resource)
                            resources.add(r);
                word = "";
            }
        }

        if (resources.size() != numberOfWhiteMarbles)
            throw new InvalidCommandException();

        return new WhiteMarbleCommand(resources);
    }
}
