package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameMultiPlayerTest {

    @Test
    public void setCurrentPlayerTest() throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>();
        nickname.add("Ali");
        nickname.add("Simo");
        nickname.add("Ale");
        GameMultiPlayer game = new GameMultiPlayer(3, nickname, true);

        nickname = new ArrayList<>();
        nickname = game.getNickNameInOrder();
        for(String nick : nickname){
            System.out.println(nick);
        }
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());


        game.disconnectPlayer("Simo");

        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());


        game.disconnectPlayer("Ale");

        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());

        game.disconnectPlayer("Ali");

        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());
        game.setCurrentPlayer();
        if(game.getCurrentPlayer() != null)
            System.out.println(game.getCurrentPlayer().getNickName());
        else
            System.out.println(game.getCurrentPlayer());




    }
}
