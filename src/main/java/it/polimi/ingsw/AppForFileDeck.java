package it.polimi.ingsw;

import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.GameSolitaire;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AppForFileDeck {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("bb");
        GameMultiPlayer gameMultiPlayer=new GameMultiPlayer(2,nickname,true);


        GameSolitaire gameSolitaire= new GameSolitaire("aa",true);

    }


    }

