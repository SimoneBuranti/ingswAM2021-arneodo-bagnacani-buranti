package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.ExitMessage;
import it.polimi.ingsw.messages.Message;

public class ExitCommand extends Command {


    /**
     * This method can always be called and it returns an ExitMessage instance.
     * @return
     * @throws SpentTokenException
     */
    public Message commandOn() throws SpentTokenException {
        return new ExitMessage();
    }



    public static String defToString(){
        return "exit";
    }

    public String toString(){
        return defToString();
    }
}
