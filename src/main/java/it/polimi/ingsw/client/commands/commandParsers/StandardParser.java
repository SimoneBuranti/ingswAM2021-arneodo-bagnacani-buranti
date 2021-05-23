package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;

public class StandardParser implements CommandParser{


    @Override
    public Command parseCommand(String commandText, ViewController viewController, View view) throws InvalidCommandException {

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

        if (prefix.equals(""))
            throw new InvalidCommandException();

        switch(prefix){
            case "exit" : {
                return new ExitCommand();
            }
            case "help" : {
                return new HelpCommand();
            }
            case "showGameboard" : {
                return new ShowGameBoardCommand(view);
            }
            case "showMarket" : {
                return new ShowMarketCommand(view);
            }
            case "showPlayer" : {

                int n = 0;
                int cont = 0;

                for(int i = 0;i<suffix.length();i++){
                    if (cont == 0 ){
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i)==' '){
                        cont++;
                        n = suffix.charAt(i+1) - '0';
                    }

                }
                if ( n<0 || n>4)
                    throw new InvalidCommandException();
                return new ShowPlayerCommand(n,viewController);

            }
            case "showDecks" : {
                return new ShowProductionDeckCommand(view);
            }
            case "showReserve" : {
                return new ShowReserveCommand(view);
            }
            default: {
                throw new InvalidCommandException();
            }
        }

    }

}
