package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.*;

public class UsernameCommand extends Command {

    /**
     * Attribute for the player's nickname.
     */
    private String nickname;

    /**
     * Attribute for the view controller reference.
     */
    private ViewController viewController;

    public UsernameCommand(String nickname,ViewController viewController) {
        this.nickname = nickname;
        this.viewController = viewController;
    }

    /**
     * Nickname getter
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This command set the stored nickname and returns an UsernameMessage instance.
     * @return
     */
    @Override
    public Message commandOn(){
        viewController.setNickName(this.nickname);
        return new UsernameMessage(this.nickname);
    }
}
