package it.polimi.ingsw;

import it.polimi.ingsw.Client.SocketClient;
import it.polimi.ingsw.messages.NumberPlayerMessage;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.GameSolitaire;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReserveTest {
    public static void main(String[] args) throws IOException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("ii");



       /* GameSolitaire gameMultiPlayer1 =new GameSolitaire( "nickname",true);
        gameMultiPlayer1.saveInformation();

        GameSolitaire gameMultiPlayer2 =new GameSolitaire( "nickname",false);*/


        GameMultiPlayer gameMultiPlayer3 =new GameMultiPlayer(2,nickname,true);
        gameMultiPlayer3.saveInformation();

        GameMultiPlayer gameMultiPlayer4 =new GameMultiPlayer( 2,nickname,false);



    }
}
