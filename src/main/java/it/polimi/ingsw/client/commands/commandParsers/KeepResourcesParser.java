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

    private ArrayList<Resource> choosableResources;

    public KeepResourcesParser(ArrayList<Resource> resources) {
        this.choosableResources = resources;
    }


    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        String prefix = "";
        String suffix = "";
        boolean found = false;

        if (commandText.length() == 0)
            throw new InvalidCommandException();
        commandText = Command.deleteInitSpaces(commandText);

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

            ArrayList<Resource> localResources = new ArrayList<>();
            localResources.add(Command.fromStringToResource(prefix));

            Map<Resource,Integer> chosen = new HashMap<>();
            Map<Resource,Integer> picked = new HashMap<>();
            chosen.put(Resource.COIN,0);
            chosen.put(Resource.ROCK,0);
            chosen.put(Resource.SHIELD,0);
            chosen.put(Resource.SERVANT,0);

            picked.put(Resource.COIN,0);
            picked.put(Resource.ROCK,0);
            picked.put(Resource.SHIELD,0);
            picked.put(Resource.SERVANT,0);

            Resource r;
            String word = "";
            for (int i = 0;i<suffix.length();i++){
                if (suffix.charAt(i) != ' '){
                    word = word + suffix.charAt(i);
                } else {
                    r = Command.fromStringToResource(word);
                    if(r != null)
                        localResources.add(r);
                    word = "";
                }
            }
            r = Command.fromStringToResource(word);
            if(r != null)
                localResources.add(r);

            for(Resource k : this.choosableResources){
                    picked.put(k,picked.remove(k)+1);
            }
            for(Resource k : localResources){
                    chosen.put(k,chosen.remove(k)+1);
            }

            for(Resource k : picked.keySet()){
                if (chosen.get(k) > picked.get(k))
                    throw new InvalidCommandException();
            }

            if (chosen.equals(picked))
                throw new InvalidCommandException();
            return new KeepResourcesCommand(localResources);
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
