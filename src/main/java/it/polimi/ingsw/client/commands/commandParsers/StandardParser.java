package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class StandardParser implements CommandParser{


    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        String prefix = "";
        String suffix = "";

        System.out.println(this+": "+commandText);
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
                return new ShowGameBoardCommand(cli);
            }
            case "showMarket" : {
                return new ShowMarketCommand(cli);
            }
            case "showPlayer" : {

                int n = 0;
                int temp;
                boolean found = false;

                for (int i = 0; i < suffix.length() && !found; i++) {
                    if ( suffix.charAt(i) != ' '){
                        temp = suffix.charAt(i) -'0';
                        if (temp < 0 || temp > 9)
                            throw new InvalidCommandException();
                        n = temp;
                        found = true;
                    }

                }
                if (n < 1 || n > 4)
                    throw new InvalidCommandException();
                return new ShowPlayerCommand(n-1, viewController);

            }
            case "showProductionDecks" : {
                return new ShowProductionDeckCommand(cli);
            }
            case "showReserve" : {
                return new ShowReserveCommand(cli);
            }
            default: {
                throw new InvalidCommandException();
            }
        }

    }

}
