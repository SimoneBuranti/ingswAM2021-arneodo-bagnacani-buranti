package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.ExitMessage;
import it.polimi.ingsw.messages.Message;

public class ExitCommand extends Command {


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
