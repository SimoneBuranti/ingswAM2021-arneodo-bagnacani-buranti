package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.Resource;

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


            case "baseProductionOn" : {
                return new BaseProductionCommand(viewController);
            }
            case "buy" : {
                int column = 0;
                int deckNumber = 0;
                int cont = 0;

                for(int i = 0;i<suffix.length();i++){
                    if (cont == 0 && (suffix.charAt(i) == 'b' || suffix.charAt(i)=='g' || suffix.charAt(i)=='y' || suffix.charAt(i)=='v')){
                        deckNumber = suffix.charAt(i+1) - '0';
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i)==' '){
                        cont++;
                        column = suffix.charAt(i+1) - '0';
                    }

                }

                if (cont != 3 || deckNumber<1 || deckNumber>12 || column<1 || column>3)
                    throw new InvalidCommandException();
                return new BuyActionCommand(deckNumber,column, viewController);
            }
            case "endProduction" : {
                return new EndOfProductionCommand(viewController);
            }
            case "endTurn" : {
                return new EndOfTurnCommand(viewController);
            }
            case "exit" : {
                return new ExitCommand();
            }
            case "extraProductionOn" : {
                return new ExtraProductionCommand(viewController);
            }
            case "help" : {
                return new HelpCommand();
            }
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
            case "leader" : {
                char ad = 'a';
                int n = 0;
                int cont = 0;

                for(int i = 0;i<suffix.length();i++){
                    if (cont == 0 && (suffix.charAt(i) == 'x' || suffix.charAt(i)=='a')){
                        ad = suffix.charAt(i);
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i)==' '){
                        cont++;
                        n = suffix.charAt(i+1) - '0';
                    }

                }

                if (cont != 2 || n<0 || n>1)
                    throw new InvalidCommandException();
                return new MarketActionCommand(ad,n,viewController);
            }
            case "productionOn" : {
                return new ProductionCommand(viewController);
            }
            default: {
                throw new InvalidCommandException();
            }
        }

    }

    public Message commandOn() throws SpentTokenException, InvalidCommandException {
        return null;
    }

    public static String defToString(){
        return "";
    }

    public static Resource fromStringToResource(String resource){
        switch (resource) {
            case "coin":
                return Resource.COIN;
            case "rock":
                return Resource.ROCK;
            case "shield":
                return Resource.SHIELD;
            case "servant":
                return Resource.SERVANT;
            default :
                return null;
        }
    }

    public String toString(){
        return defToString();
    }


}
