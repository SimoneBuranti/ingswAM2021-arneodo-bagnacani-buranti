package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;

public class HelpCommand extends Command{

    private static final int space = 25;

    private final String[] commands = { BaseProductionCommand.defToString(),
                                        ProductionCommand.defToString(),
                                        ExtraProductionCommand.defToString(),
                                        EndOfProductionCommand.defToString(),
                                        BuyActionCommand.defToString(),
                                        MarketActionCommand.defToString(),
                                        LeaderCardActionCommand.defToString(),
                                        EndOfTurnCommand.defToString(),
                                        HelpCommand.defToString(),
                                        ShowMarketCommand.defToString(),
                                        ShowReserveCommand.defToString(),
                                        ShowGameBoardCommand.defToString(),
                                        ShowPlayerCommand.defToString(),
                                        ExitCommand.defToString(),
                                        };


    public Message commandOn() throws NoMessageReturnException {
        for (int i = 0; i < commands.length ;i++){
            if (i%4==0){
                System.out.println("");
            }
            System.out.print(commands[i]);
            for(int j = 0;j<(space-commands[i].length());j++)
                System.out.print(" ");
        }
        System.out.println("");
        throw new NoMessageReturnException();
    }

    public static String defToString(){
        return "help";
    }

    public String toString(){
        return defToString();
    }

}
