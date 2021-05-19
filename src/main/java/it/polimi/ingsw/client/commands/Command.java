package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;

public abstract class Command {


    public static Command parseCommand(String commandText, ViewController viewController) throws InvalidCommandException {

        String prefix = "";
        String suffix = "";

        for (int i = 0;i<commandText.length();i++){
            if (commandText.charAt(i) != ' '){
                prefix = prefix + commandText.charAt(i);
            } else {
                for (i++;i<commandText.length();i++)
                    suffix = suffix + commandText.charAt(i);
            }
        }

        //System.out.println(prefix);
        if (prefix == null)
            throw new InvalidCommandException();

        switch(prefix){

            case "market": {
                char rc = 'c';
                int n = 0;
                int cont = 0;

                for(int i = 0;i<suffix.length();i++){
                    if (cont == 0 && (suffix.charAt(i) == 'r' || suffix.charAt(i)=='c')){
                        rc = suffix.charAt(i);
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i)==' '){
                        cont++;
                        n = suffix.charAt(i+1) - '0';
                    }

                }
                if (cont != 2 || n<1 || n>3)
                    throw new InvalidCommandException();
                return new MarketActionCommand(rc,n,viewController);
            }
            case "" : {

            }
            default : {
                throw new InvalidCommandException();
            }
        }

    }


}
