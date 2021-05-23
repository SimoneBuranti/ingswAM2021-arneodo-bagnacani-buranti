package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.WhiteMarbleCommand;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
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
    public Command parseCommand(String commandText, ViewController viewController, View view) throws InvalidCommandException {

        Map<Resource,Integer> choosen = new HashMap<>();
        Map<Resource,Integer> picked = new HashMap<>();

        String word = "";
        Resource r;

        ArrayList<Resource> resources = new ArrayList<>();

        if (commandText.length() == 0)
            throw new InvalidCommandException();

        for (int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i) != ' '){
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
    }
}
