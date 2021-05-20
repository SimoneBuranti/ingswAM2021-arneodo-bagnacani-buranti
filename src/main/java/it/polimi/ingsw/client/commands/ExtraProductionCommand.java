package it.polimi.ingsw.client.commands;


import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.Message;

public class ExtraProductionCommand extends Command {

    private ViewController viewController;

    public ExtraProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn(){

        return null;

    }

    public static String defToString(){
        return "extraProductionOn";
    }

    public String toString(){
        return "extraProductionOn";
    }

}