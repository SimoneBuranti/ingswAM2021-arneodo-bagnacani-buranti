package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeepResourcesParser implements CommandParser{

    private ArrayList<Resource> resources;

    public KeepResourcesParser(ArrayList<Resource> resources) {
        this.resources = resources;
    }


    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        String prefix = "";
        String suffix = "";
        boolean found = false;
        if (commandText.length() == 0)
            throw new InvalidCommandException();

        System.out.println(this+": "+commandText);

        for(int s = 0; s <commandText.length() && !found;s++){
            if(commandText.charAt(s)!=' '){
                commandText = commandText.substring(s);
                found = true;
            }
        }

        System.out.println(this+": "+commandText);
        for (int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i) != ' '){
                prefix = prefix + commandText.charAt(i);
            } else {
                for (i++;i<commandText.length();i++)
                    suffix = suffix + commandText.charAt(i);
            }
        }

        if (prefix.equals("coin") || prefix.equals("rock") || prefix.equals("shield") || prefix.equals("servant")){

            Map<Resource,Integer> choosen = new HashMap<>();
            Map<Resource,Integer> picked = new HashMap<>();

            String word = "";
            Resource r;

            ArrayList<Resource> resources = new ArrayList<>();
            resources.add(Command.fromStringToResource(prefix));

            for (int i = 0;i<suffix.length();i++){
                if (suffix.charAt(i) != ' '){
                    word = word + commandText.charAt(i);
                } else {
                    r = Command.fromStringToResource(word);
                    if(r != null)
                        resources.add(r);
                    word = "";
                }
            }

            for(Resource k : this.resources){
                if (picked.get(k) == null)
                    picked.put(k,0);
                else
                    picked.put(k,picked.remove(k));
            }

            for(Resource k : resources){
                if (choosen.get(k) == null)
                    choosen.put(k,0);
                else
                    choosen.put(k,picked.remove(k));
            }

            for(Resource k : picked.keySet()){
                if (choosen.get(k) > picked.get(k))
                    throw new InvalidCommandException();
            }

            if (choosen.equals(picked))
                throw new InvalidCommandException();

            return new WhiteMarbleCommand(resources);
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
                    return new ShowPlayerCommand(n - 1, viewController);

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
