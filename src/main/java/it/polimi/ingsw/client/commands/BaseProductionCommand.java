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

    public Message commandOn(){
        Resource i1;
        Resource i2;
        Resource o;
        Scanner in = new Scanner(System.in);

        System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
        System.out.println("First input resource type: ");
        while ((i1 = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }
        System.out.println("Second input resource type: ");
        while ((i2 = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }
        System.out.println("Output resource type: ");
        while ((o = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }

        viewController.getGame().setProductionToken(0,false);

        return new BaseProductionOnMessage(i1,i2,o);

    }

    public static String defToString(){
        return "extraProductionOn";
    }

    public String toString(){
        return defToString();
    }
}
