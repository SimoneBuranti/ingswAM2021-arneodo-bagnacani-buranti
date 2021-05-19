package it.polimi.ingsw;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NotEnoughSpaceErrorMessage;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.io.SyncFailedException;
import java.util.ArrayList;

public class AppForFileDeck {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("aa");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        nickname.add("bb");
        GameMultiPlayer gameMultiPlayer=new GameMultiPlayer(2,nickname,true, clientControllers);*/


      //  GameSolitaire gameSolitaire= new GameSolitaire("aa",true);

        ArrayList<Resource> resource = new ArrayList<>();
        resource.add(Resource.COIN);
        resource.add(Resource.ROCK);
        resource.add(Resource.SERVANT);
        resource.add(Resource.SHIELD);

        Message msg = new NotEnoughSpaceErrorMessage(resource);

        System.out.println(msg.toString());


    }


    }

