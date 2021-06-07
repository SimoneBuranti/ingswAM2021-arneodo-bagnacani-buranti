package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;

public class HelpCommand extends Command{

    /**
     * Grid offset value.
     */
    private static final int space = 25;

    /**
     * This is the list of commands to be displayed when an exit command is parsed. It provides the correct command
     * structure.
     */
    private final String[] commands = {

            HelpCommand.defToString(),

            ProductionCommand.defToString(),
            BaseProductionCommand.defToString(),
            ExtraProductionCommand.defToString(),
            EndOfProductionCommand.defToString(),

            BuyActionCommand.defToString(),

            MarketActionCommand.defToString(),

            LeaderCardActionCommand.defToString(),

            EndOfTurnCommand.defToString(),

            ExitCommand.defToString(),

            KeepResourcesCommand.defToString(),
            WhiteMarbleCommand.defToString(),

            ShowGameBoardCommand.defToString(),
            ShowMarketCommand.defToString(),
            ShowPlayerCommand.defToString(),
            ShowProductionDeckCommand.defToString(),
            ShowReserveCommand.defToString(),


        };


    /**
     * The commandOn displays the list of accepted command formats. This command throws a NoMessageReturnException
     * as no return message is needed.
     * @return none
     * @throws NoMessageReturnException
     */
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
