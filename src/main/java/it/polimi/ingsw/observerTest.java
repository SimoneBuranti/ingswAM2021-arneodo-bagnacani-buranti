package it.polimi.ingsw;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.GameMultiPlayer;

import java.io.IOException;
import java.util.ArrayList;

public class observerTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("ii");

        GameMultiPlayer gameMultiPlayer3 = new GameMultiPlayer(2, nickname, true, clientControllers);
    }
}

