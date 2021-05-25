package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.*;

public class UsernameCommand extends Command {

    private String nickname;
    private ViewController viewController;

    public UsernameCommand(String nickname,ViewController viewController) {
        this.nickname = nickname;
        this.viewController = viewController;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public Message commandOn(){
        viewController.setNickName(this.nickname);
        return new UsernameMessage(this.nickname);
    }
}
