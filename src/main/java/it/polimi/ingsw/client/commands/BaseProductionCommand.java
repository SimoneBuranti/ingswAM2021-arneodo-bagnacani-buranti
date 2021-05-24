package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.BaseProductionOnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;

import java.util.Scanner;

public class BaseProductionCommand extends Command {
    private ViewController viewController;

    public BaseProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public Message commandOn() throws AlreadyActivatedProductionException {
        if(viewController.isProductionToken(0) && viewController.isActionToken()) {
            Resource i1;
            Resource i2;
            Resource o;
            Scanner in = new Scanner(System.in);

            viewController.getGame().setProductionToken(0, false);

            return new BaseProductionOnMessage(askForInputResource(), askForInputResource(), askForOutputResource());
        }else{
            throw new AlreadyActivatedProductionException();
        }

    }

    public static String defToString(){
        return "baseProductionOn";
    }

    public String toString(){
        return defToString();
    }
}
