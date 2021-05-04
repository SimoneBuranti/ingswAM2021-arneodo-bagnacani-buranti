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



        GameSolitaire gameMultiPlayer =new GameSolitaire( "nickname");
        gameMultiPlayer.saveInformation(); }
}
