package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.Message;

public class ProductionCommand extends Command {


    private ViewController viewController;

    public ProductionCommand(ViewController viewController) {
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