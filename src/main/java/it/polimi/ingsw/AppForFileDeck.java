package it.polimi.ingsw;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.GameSolitaire;

import java.io.IOException;
import java.util.ArrayList;

public class AppForFileDeck {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("aa");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        nickname.add("bb");
        GameMultiPlayer gameMultiPlayer=new GameMultiPlayer(2,nickname,true, clientControllers);


      //  GameSolitaire gameSolitaire= new GameSolitaire("aa",true);

    }


    }

