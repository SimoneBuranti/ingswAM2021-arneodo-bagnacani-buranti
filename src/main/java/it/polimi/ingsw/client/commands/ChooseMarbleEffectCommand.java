package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.ViewController;

public class ChooseMarbleEffectCommand {

    private ViewController viewController;

    public ChooseMarbleEffectCommand(ViewController viewController) {
        this.viewController = viewController;
    }

    public static String defToString(){
        return "exit";
    }
}
