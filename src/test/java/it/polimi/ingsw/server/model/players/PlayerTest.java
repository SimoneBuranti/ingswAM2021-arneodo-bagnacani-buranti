package it.polimi.ingsw.server.model.players;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.virtualview.VirtualView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    /*
    Game game;
    VirtualView virtualView;
    ViewController viewController;
    String playerNick = "Spiderman";



    @Test
    @BeforeEach
    public void initTest(){
        viewController = new ViewController();
        game = new GameSolitaire(playerNick,true,);
    }*/

    @Test
    public void PlayerTest0(){
        Player player = new Player(null,null,null);
        int[] vec;
        ArrayList<Resource> buffer;

        player.setInitResource(false);
        player.setInitLeader(false);
        buffer = player.getBuffer();
        vec = player.getPapalCards();
        assertEquals(vec.length,3);


        try {
            player.initResource(Resource.COIN);
        } catch (CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        try {
            player.initResource(Resource.COIN,Resource.COIN);
        } catch (CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        player.addToBuffer(Resource.COIN);
        player.addToBuffer(Resource.ROCK);
        player.addToBuffer(Resource.ROCK);
        try {
            player.takeResourceFromClientToGameboard(buffer);
        } catch (IOException | NotEnoughSpaceInStorageException | InterruptedException e) {
            e.printStackTrace();
        }

        player.savePlayerInformation();

        try {
            player.anotherExtraProductionOn(Resource.COIN);
        } catch (LastSpaceReachedException | CallForCouncilException | ImpossibleProductionException e) {
            e.printStackTrace();
        }

        try {
            player.baseProductionOn(Resource.COIN,Resource.COIN,Resource.COIN);
        } catch (ImpossibleProductionException e) {
            e.printStackTrace();
        }

        try {
            player.productionOn(0);
        } catch (ImpossibleProductionException | EmptyColumnException | CallForCouncilException | LastSpaceReachedException e) {
            e.printStackTrace();
        }

        player.endOfProduction();

        try {
            player.takeFromMarket();
        } catch (NotEnoughSpaceInStorageException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



}