package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.BaseProductionOnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;

import java.util.Scanner;

/**
 * When a base-production command is recognised the commandOn() method is called.
 */

public class BaseProductionCommand extends Command {

    /**
     * Attribute for the viewController reference.
     */
    private ViewController viewController;

    public BaseProductionCommand(ViewController viewController) {
        this.viewController = viewController;
    }


    /**
     * When the commandOn() method is called it checks the local production flag, if it is available it returns a
     * BaseProductionOnMessage; otherwise it throws an AlreadyActivatedProductionException.
     * @return BaseProductionOnMessage
     * @throws AlreadyActivatedProductionException
     */
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
