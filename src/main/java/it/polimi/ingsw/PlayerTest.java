package it.polimi.ingsw;

import it.polimi.ingsw.server.model.GameMultiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerTest {public static void main(String[] args) throws IOException, InterruptedException {

    ArrayList<String> nickname =new ArrayList<>(2);
    nickname.add("aa");
    nickname.add("bb");
    FileWriter cofiguration = null;

    GameMultiPlayer gameMultiPlayer =new GameMultiPlayer(2, nickname,true);

    gameMultiPlayer.getPlayerFromList(0).savePlayerInformation();
}
}
