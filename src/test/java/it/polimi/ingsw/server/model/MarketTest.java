package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.marbles.*;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * test class about Market
 */
public class MarketTest {
    /**
     * test on creation of Market(Grid) with mixed functionality
     */
    @Test
    public void initializationOfGridMarket() throws IOException, InterruptedException {

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);


        assertTrue(!( game.getCellGridMarket(0, 0) instanceof RedMarble) ||
        !(game.getCellGridMarket(0, 1) instanceof YellowMarble)||
        !( game.getCellGridMarket(0, 2) instanceof YellowMarble)||
        !( game.getCellGridMarket(0, 3) instanceof BluMarble)||
        !( game.getCellGridMarket(1, 0) instanceof BluMarble)||
        !( game.getCellGridMarket(1, 1) instanceof GreyMarble)||
        !( game.getCellGridMarket(1, 2) instanceof GreyMarble)||
        !( game.getCellGridMarket(1, 3) instanceof PurpleMarble)||
        !( game.getCellGridMarket(2, 0) instanceof PurpleMarble)||
        !( game.getCellGridMarket(2, 1) instanceof WhiteMarble)||
        !( game.getCellGridMarket(2, 2) instanceof WhiteMarble)||
        !( game.getCellGridMarket(2, 3) instanceof WhiteMarble));
    }



    /**
     * test on creation of Market(Extra) with mixed functionality
     */
    /*@Test
    public void initializationOfExtraMarket() throws IOException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);

        assertTrue(!( game.getExtraMarket() instanceof RedMarble) ||
                (game.getExtraMarket() instanceof YellowMarble)||
                ( game.getExtraMarket() instanceof YellowMarble)||
                ( game.getExtraMarket() instanceof BluMarble)||
                ( game.getExtraMarket() instanceof BluMarble)||
                ( game.getExtraMarket() instanceof GreyMarble)||
                ( game.getExtraMarket() instanceof GreyMarble)||
                ( game.getExtraMarket() instanceof PurpleMarble)||
                ( game.getExtraMarket() instanceof PurpleMarble)||
                ( game.getExtraMarket() instanceof WhiteMarble)||
                ( game.getExtraMarket() instanceof WhiteMarble)||
                ( game.getExtraMarket() instanceof WhiteMarble));
    }*/


    /*/*
     * test about the calls pushRow from Game
     * test controls if draw marble are shift in right way
     */
   /* @Test
   /* public void PushRowsOfMarket() throws IOException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);


        assertTrue(( game.getCellGridMarket(0, 0) instanceof RedMarble) ||
                (game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                (game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble));

        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(3));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));


    }




    /**
     * test about the circularity of pushRow
     *
     */
  /*  @Test
/*public void PushRowsOfMarketCycling() throws IOException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);
        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));

        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(0));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(1));

        game.setCurrentPlayer();
        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(1));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(2));

        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(2));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(3));

        game.setCurrentPlayer();
        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(3));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
    }


    /**
     * test about the PushColumn
     * test controls if draw marble are shift in right way
     */
   /* @Test
  /*  public void PushColumnsOfMarket() throws IOException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);


        assertTrue(( game.getCellGridMarket(0, 0) instanceof RedMarble) ||
                (game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble));

        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
        try {
            game.pushColumnInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));


    }*/


    /**
     * test about the circularity of PushColumn
     *
     */
  /*  @Test
    public void PushColumnsOfMarketCycling() throws IOException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();
        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname,true, clientControllers);

        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
        try {
            game.pushColumnInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));

        game.setCurrentPlayer();
        try {
            game.pushColumnInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(4));

        game.setCurrentPlayer();
        try {
            game.pushColumnInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(8));

        game.setCurrentPlayer();
        try {
            game.pushColumnInMarket(0);
        } catch (NotEnoughSpaceInStorageException e) {
            e.printStackTrace();
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));

    }*/}

