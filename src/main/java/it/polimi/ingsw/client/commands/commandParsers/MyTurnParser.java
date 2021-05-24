package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;

public class MyTurnParser implements CommandParser {
    @Override
    public Command parseCommand(String commandText, ViewController viewController, Cli cli) throws InvalidCommandException {

        String prefix = "";
        String suffix = "";

        System.out.println(this+": "+commandText);

        for (int i = 0; i < commandText.length(); i++) {
            if (commandText.charAt(i) != ' ') {
                prefix = prefix + commandText.charAt(i);
            } else {
                for (i++; i<commandText.length();i++)
                    suffix = suffix + commandText.charAt(i);
            }
        }

        //System.out.println(prefix);

        if (prefix.equals(""))
            throw new InvalidCommandException();

        switch (prefix) {

            case "baseProductionOn": {
                return new BaseProductionCommand(viewController);
            }
            case "buy": {
                int column = 0;
                int temp;
                int deckNumber = 0;
                boolean found = false;

                for(int s = 0; s <suffix.length() && !found;s++){
                    if(suffix.charAt(s)!=' '){
                        suffix = suffix.substring(s);
                        found = true;
                    }
                }
                found = false;
                for (int i = 0; i < suffix.length() && !found; i++) {
                    if (suffix.charAt(i)!=' '){
                        temp = suffix.charAt(i) -'0';
                        if (temp <0 || temp > 9)
                            throw new InvalidCommandException();
                        deckNumber = temp + deckNumber*10;
                    } else{
                        suffix = suffix.substring(i);
                        found = true;
                    }
                }
                found = false;
                for(int s = 0; s <suffix.length() && !found;s++){
                    if(suffix.charAt(s)!=' '){
                        suffix = suffix.substring(s);
                        found = true;
                    }
                }
                found = false;
                for (int i = 0; i < suffix.length() && !found; i++) {
                    if (suffix.charAt(i)!=' '){
                        temp = suffix.charAt(i) -'0';
                        if (temp <1 || temp > 3)
                            throw new InvalidCommandException();
                        column = temp;
                        found = true;
                    }
                }
                if( deckNumber <1 || deckNumber >12 || column >3 || column<1)
                    throw new InvalidCommandException();
                return new BuyActionCommand(deckNumber-1, column-1, viewController);
            }
            case "endProduction": {
                return new EndOfProductionCommand(viewController);
            }
            case "endTurn": {
                return new EndOfTurnCommand(cli,viewController);
            }
            case "exit": {
                return new ExitCommand();
            }
            case "extraProductionOn": {
                return new ExtraProductionCommand(viewController);
            }
            case "help": {
                return new HelpCommand();
            }
            case "leader": {
                char ad = 'a';
                int n = 0;
                int cont = 0;

                for (int i = 0; i < suffix.length(); i++) {
                    if (cont == 0 && (suffix.charAt(i) == 'x' || suffix.charAt(i) == 'a')) {
                        ad = suffix.charAt(i);
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i) == ' ') {
                        cont++;
                        n = suffix.charAt(i + 1) - '0';
                    }

                }
                n--;
                if (cont != 2 || n < 0 || n > 1)
                    throw new InvalidCommandException();
                return new LeaderCardActionCommand(ad, n, viewController);
            }
            case "market": {
                char rc = 'c';
                int n = 0;
                int cont = 0;
                boolean found = false;

                for (int i = 0; i < suffix.length() && !found; i++) {
                    if ((suffix.charAt(i) == 'r' || suffix.charAt(i) == 'c')) {
                        rc = suffix.charAt(i);
                        found = true;

                        suffix = suffix.substring(i+1);
                    }
                }
                found = false;
                for (int i = 0; i < suffix.length() && !found; i++) {
                    n = suffix.charAt(i) - '0';
                    if ((n < 10 && n >=0)) {
                        found = true;
                        suffix = suffix.substring(i+1);
                    }
                }

                n--;
                if (rc == 'c' && (n < 0 || n >3)) {
                    throw new InvalidCommandException();
                }
                if (rc == 'r' && (n < 0 || n >2)) {
                    throw new InvalidCommandException();
                }
                System.out.println(prefix + " " + suffix + " "+ rc+n);
                return new MarketActionCommand(rc, n, viewController);
            }
            case "productionOn": {
                return new ProductionCommand(viewController);
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
