package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;

public class MyTurnParser implements CommandParser {
    @Override
    public Command parseCommand(String commandText, ViewController viewController, View view) throws InvalidCommandException {
        String prefix = "";
        String suffix = "";

        for (int i = 0; i < commandText.length(); i++) {
            if (commandText.charAt(i) != ' ') {
                prefix = prefix + commandText.charAt(i);
            } else {
                for (i++; i < commandText.length(); i++)
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
                int deckNumber = 0;
                int cont = 0;

                for (int i = 0; i < suffix.length(); i++) {
                    if (cont == 0 && (suffix.charAt(i) == 'b' || suffix.charAt(i) == 'g' || suffix.charAt(i) == 'y' || suffix.charAt(i) == 'v')) {
                        deckNumber = suffix.charAt(i + 1) - '0';
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i) == ' ') {
                        cont++;
                        column = suffix.charAt(i + 1) - '0';
                    }

                }

                if (cont != 3 || deckNumber < 1 || deckNumber > 12 || column < 1 || column > 3)
                    throw new InvalidCommandException();
                return new BuyActionCommand(deckNumber, column, viewController);
            }
            case "endProduction": {
                return new EndOfProductionCommand(viewController);
            }
            case "endTurn": {
                return new EndOfTurnCommand(viewController);
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

                if (cont != 2 || n < 0 || n > 1)
                    throw new InvalidCommandException();
                return new MarketActionCommand(ad, n, viewController);
            }
            case "market": {
                char rc = 'c';
                int n = 0;
                int cont = 0;

                for (int i = 0; i < suffix.length(); i++) {
                    if (cont == 0 && (suffix.charAt(i) == 'r' || suffix.charAt(i) == 'c')) {
                        rc = suffix.charAt(i);
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i) == ' ') {
                        cont++;
                        n = suffix.charAt(i + 1) - '0';
                    }

                }
                if (cont != 2 || n < 1 || n > 3)
                    throw new InvalidCommandException();
                return new MarketActionCommand(rc, n, viewController);
            }
            case "productionOn": {
                return new ProductionCommand(viewController);
            }
            case "showGameboard": {
                return new ShowGameBoardCommand(view);
            }
            case "showMarket": {
                return new ShowMarketCommand(view);
            }
            case "showPlayer": {

                int n = 0;
                int cont = 0;

                for (int i = 0; i < suffix.length(); i++) {
                    if (cont == 0) {
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i) == ' ') {
                        cont++;
                        n = suffix.charAt(i + 1) - '0';
                    }

                }
                if (n < 0 || n > 4)
                    throw new InvalidCommandException();
                return new ShowPlayerCommand(n, viewController);

            }
            case "showDecks": {
                return new ShowProductionDeckCommand(view);
            }
            case "showReserve": {
                return new ShowReserveCommand(view);
            }
            default: {
                throw new InvalidCommandException();
            }
        }
    }
}
