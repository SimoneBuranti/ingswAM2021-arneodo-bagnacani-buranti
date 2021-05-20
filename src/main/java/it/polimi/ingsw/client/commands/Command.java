package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.*;

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
            case "baseProductionOn" : {
                return new BaseProductionCommand();
            }
            case "productionOn" : {
                return new ProductionCommand();
            }
            case "extraProductionOn" : {
                return new ExtraProductionCommand();
            }
            case "buy" : {
                char colour = 'b';
                int level = 0;
                int cont = 0;

                for(int i = 0;i<suffix.length();i++){
                    if (cont == 0 && (suffix.charAt(i) == 'b' || suffix.charAt(i)=='g' || suffix.charAt(i)=='y' || suffix.charAt(i)=='v')){
                        colour = suffix.charAt(i);
                        cont++;
                    } else if (cont == 1 && suffix.charAt(i)==' '){
                        cont++;
                        level = suffix.charAt(i+1) - '0';
                    }

                }

                if (cont != 2 || level<1 || level>3)
                    throw new InvalidCommandException();
                return new BuyActionCommand(colour,level);
            }
            case "help" : {

            }
            default: {
                throw new InvalidCommandException();
            }
        }

    }

    public static void commandOn(Message msg){}

    public static String defToString(){
        return "";
    }


}
