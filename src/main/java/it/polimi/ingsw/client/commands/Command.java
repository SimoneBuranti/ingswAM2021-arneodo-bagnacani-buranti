package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;

import java.util.Scanner;

public abstract class Command {


    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException, EndAfterThisException {
        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "";
    }

    public static Resource fromStringToResource(String resource){
        //resource.toLowerCase();
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

    public static Resource askForOutputResource(){
        Scanner in = new Scanner(System.in);
        Resource o;
        System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
        System.out.println("Output resource type: ");
        while ((o = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }
        return o;
    }

    public static Resource askForInputResource(){
        Scanner in = new Scanner(System.in);
        Resource i;
        System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
        System.out.println("Input resource type: ");
        while ((i = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }
        return i;
    }

    public static String deleteInitSpaces(String word){
        for(int s = 0; s <word.length();s++){
            if(word.charAt(s)!=' '){
                return word.substring(s);
            }
        }
        return "";
    }

    public static int fromStringToInt(String number){
        int n = 0;

        for(int i = 0;i<number.length();i++){
            n*=10;
            n+= number.charAt(0) -'0';
        }
        return n;
    }

    public String toString(){
        return defToString();
    }

}


/*public static Command parseCommand(String commandText, ViewController viewController,View view) throws InvalidCommandException {

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
            case "productionOn" : {
                return new ProductionCommand(viewController);
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

    }*/