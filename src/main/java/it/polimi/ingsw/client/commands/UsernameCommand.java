package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.messages.*;

public class UsernameCommand extends Command {

    private String nickname;

    public UsernameCommand(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public Message commandOn(){
        return new UsernameMessage(this.nickname);
    }
}
