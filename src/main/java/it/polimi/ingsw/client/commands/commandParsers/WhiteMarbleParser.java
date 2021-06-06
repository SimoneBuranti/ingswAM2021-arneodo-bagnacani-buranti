package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.WhiteMarbleChoosenResourcesMessage;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WhiteMarbleParser implements CommandParser {

    private int numberOfWhiteMarbles;

    private ArrayList<Resource> possibleResources;

    public WhiteMarbleParser(int numberOfWhiteMarbles, ArrayList<Resource> possibleResources) {
        this.numberOfWhiteMarbles = numberOfWhiteMarbles;
        this.possibleResources = possibleResources;
    }

    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        System.out.println(this+": "+commandText);
        String word = "";
        Resource resource;
        String prefix = "";
        String suffix = "";
        boolean found = false;
        ArrayList<Resource> resources = new ArrayList<>();

        if (commandText.length() == 0)
            throw new InvalidCommandException();

        commandText = Command.deleteInitSpaces(commandText);

        for (int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i) != ' '){
                prefix = prefix + commandText.charAt(i);
            } else {
                for (i++;i<commandText.length();i++)
                    suffix = suffix + commandText.charAt(i);
            }
        }

        if (prefix.equals("coin") || prefix.equals("rock") || prefix.equals("shield") || prefix.equals("servant")){

            resource = Command.fromStringToResource(prefix);
            resources.add(resource);

            for (int i = 0;i<suffix.length();i++){
                if (suffix.charAt(i) != ' '){
                    word = word + suffix.charAt(i);
                } else {
                    resource = Command.fromStringToResource(word);
                    if(resource != null )
                        for(Resource r : possibleResources)
                            if (r == resource)
                                resources.add(resource);
                    word = "";
                }
            }
            resource = Command.fromStringToResource(word);
            if(resource != null )
                for(Resource r : possibleResources)
                    if (r == resource)
                        resources.add(resource);

            if (resources.size() != numberOfWhiteMarbles){
                throw new InvalidCommandException();
            }
            return new WhiteMarbleCommand(resources,cli);
        } else {
            switch (prefix) {
                case "exit": {
                    return new ExitCommand();
                }
                case "help": {
                    return new HelpCommand();
                }
                case "showGameboard": {
                    return new ShowGameBoardCommand(cli);
                }
                case "showMarket": {
                    return new ShowMarketCommand(cli);
                }
                case "showPlayer": {

                    int n = 0;
                    int temp;
                    found = false;

                    for (int i = 0; i < suffix.length() && !found; i++) {
                        if (suffix.charAt(i) != ' ') {
                            temp = suffix.charAt(i) - '0';
                            if (temp < 0 || temp > 9)
                                throw new InvalidCommandException();
                            n = temp;
                            found = true;
                        }

                    }
                    if (n < 1 || n > 4)
                        throw new InvalidCommandException();
                    return new ShowPlayerCommand(n, viewController);

                }
                case "showProductionDecks": {
                    return new ShowProductionDeckCommand(cli);
                }
                case "showReserve": {
                    return new ShowReserveCommand(cli);
                }
                default: {
                    throw new InvalidCommandException();
                }
            }
        }
    }
}
