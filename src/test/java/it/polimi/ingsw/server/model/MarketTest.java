package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.exceptions.NotEnoughSpaceInStorageException;
import it.polimi.ingsw.server.model.exceptions.WhiteMarbleException;
import it.polimi.ingsw.server.model.marbles.*;
import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.players.PlayerFirst;
import it.polimi.ingsw.server.model.players.PlayerSecond;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import it.polimi.ingsw.server.virtualview.VirtualView;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        Server server = new Server();
        ClientHandler clientHandler1 = new ClientHandler(server);
        ClientController clientController = new ClientController(server, clientHandler1);

        ClientHandler clientHandler2 = new ClientHandler(server);
        ClientController clientController2 = new ClientController(server, clientHandler2);

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game = new GameMultiPlayer(2, nickname, true, clientControllers);


        assertTrue(!(game.getCellGridMarket(0, 0) instanceof RedMarble) ||
                !(game.getCellGridMarket(0, 1) instanceof YellowMarble) ||
                !(game.getCellGridMarket(0, 2) instanceof YellowMarble) ||
                !(game.getCellGridMarket(0, 3) instanceof BluMarble) ||
                !(game.getCellGridMarket(1, 0) instanceof BluMarble) ||
                !(game.getCellGridMarket(1, 1) instanceof GreyMarble) ||
                !(game.getCellGridMarket(1, 2) instanceof GreyMarble) ||
                !(game.getCellGridMarket(1, 3) instanceof PurpleMarble) ||
                !(game.getCellGridMarket(2, 0) instanceof PurpleMarble) ||
                !(game.getCellGridMarket(2, 1) instanceof WhiteMarble) ||
                !(game.getCellGridMarket(2, 2) instanceof WhiteMarble) ||
                !(game.getCellGridMarket(2, 3) instanceof WhiteMarble));
        FileClass.FileDestroyer();
    }


    /**
     * test on creation of Market(Extra) with mixed functionality
     */
    @Test
    public void initializationOfExtraMarket() throws IOException, InterruptedException {

        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server = new Server();
        ClientHandler clientHandler1 = new ClientHandler(server);
        ClientController clientController = new ClientController(server, clientHandler1);

        ClientHandler clientHandler2 = new ClientHandler(server);
        ClientController clientController2 = new ClientController(server, clientHandler2);

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game = new GameMultiPlayer(2, nickname, true, clientControllers);

        assertTrue((game.getExtraMarket() instanceof RedMarble) ||
                (game.getExtraMarket() instanceof YellowMarble) ||
                (game.getExtraMarket() instanceof YellowMarble) ||
                (game.getExtraMarket() instanceof BluMarble) ||
                (game.getExtraMarket() instanceof BluMarble) ||
                (game.getExtraMarket() instanceof GreyMarble) ||
                (game.getExtraMarket() instanceof GreyMarble) ||
                (game.getExtraMarket() instanceof PurpleMarble) ||
                (game.getExtraMarket() instanceof PurpleMarble) ||
                (game.getExtraMarket() instanceof WhiteMarble) ||
                (game.getExtraMarket() instanceof WhiteMarble) ||
                (game.getExtraMarket() instanceof WhiteMarble));
        FileClass.FileDestroyer();
    }


    /**
     * test on market push row
     */
    @Test
    public void MarketPushRowTest() throws IOException, InterruptedException {

        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server = new Server();
        ClientHandler clientHandler1 = new ClientHandler(server);
        ClientController clientController = new ClientController(server, clientHandler1);

        ClientHandler clientHandler2 = new ClientHandler(server);
        ClientController clientController2 = new ClientController(server, clientHandler2);

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game = new GameMultiPlayer(2, nickname, true, clientControllers);
        server.setGame(game);

        Marble marble = game.getExtraMarket();
        Marble marble1 = game.getCellGridMarket(0,0);
        try {
            game.pushRowInMarket(0);
        } catch (NotEnoughSpaceInStorageException | WhiteMarbleException e) {
            e.printStackTrace();
        }

        assertEquals(marble.getColour(), game.getCellGridMarket(0,3).getColour());
        assertEquals(marble1.getColour(), game.getExtraMarket().getColour());
        FileClass.FileDestroyer();
    }

    /**
     * test on market push row
     */
    @Test
    public void MarketPushColumnTest() throws IOException, InterruptedException {

        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server = new Server();
        ClientHandler clientHandler1 = new ClientHandler(server);
        ClientController clientController = new ClientController(server, clientHandler1);

        ClientHandler clientHandler2 = new ClientHandler(server);
        ClientController clientController2 = new ClientController(server, clientHandler2);

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game = new GameMultiPlayer(2, nickname, true, clientControllers);
        server.setGame(game);

        Marble marble = game.getExtraMarket();
        Marble marble1 = game.getCellGridMarket(0,0);
        try {
            game.pushColumnInMarket(0);
        } catch (NotEnoughSpaceInStorageException | WhiteMarbleException e) {
            e.printStackTrace();
        }

        assertEquals(marble.getColour(), game.getCellGridMarket(2,0).getColour());
        assertEquals(marble1.getColour(), game.getExtraMarket().getColour());
        FileClass.FileDestroyer();
    }

    /**
     * test on give resource
     */
    @Test
    public void GiveResourceTest() throws IOException, InterruptedException {

        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server = new Server();
        ClientHandler clientHandler1 = new ClientHandler(server);
        ClientController clientController = new ClientController(server, clientHandler1);

        ClientHandler clientHandler2 = new ClientHandler(server);
        ClientController clientController2 = new ClientController(server, clientHandler2);

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("ali");
        clientController2.setNickname("ale");
        GameMultiPlayer game = new GameMultiPlayer(2, nickname, true, clientControllers);
        server.setGame(game);

        Player player = new PlayerFirst("ali", game, new VirtualView(clientController));

        Marble blueMarble = new BluMarble();
        Marble greyMarble = new GreyMarble();
        Marble purpleMarble = new PurpleMarble();
        Marble yellowMarble = new YellowMarble();

        assertEquals(blueMarble.getColour(), "blue");
        assertEquals(greyMarble.getColour(), "grey");
        assertEquals(purpleMarble.getColour(), "purple");
        assertEquals(yellowMarble.getColour(), "yellow");

        try {
            blueMarble.giveResource(player);
        } catch (CallForCouncilException | LastSpaceReachedException | WhiteMarbleException ignored) {
        }
        int n = 0;
        for(int i = 0; i < player.getBuffer().size(); i++){
            if(player.getBuffer().get(i) == Resource.SHIELD)
                n++;
        }
        assertEquals(1, n);

        try {
            greyMarble.giveResource(player);
        } catch (CallForCouncilException | LastSpaceReachedException | WhiteMarbleException ignored) {
        }
        int n1 = 0;
        for(int i = 0; i < player.getBuffer().size(); i++){
            if(player.getBuffer().get(i) == Resource.ROCK)
                n1++;
        }
        assertEquals(1, n1);

        try {
            purpleMarble.giveResource(player);
        } catch (CallForCouncilException | LastSpaceReachedException | WhiteMarbleException ignored) {
        }
        int n2 = 0;
        for(int i = 0; i < player.getBuffer().size(); i++){
            if(player.getBuffer().get(i) == Resource.SERVANT)
                n2++;
        }
        assertEquals(1, n2);

        try {
            yellowMarble.giveResource(player);
        } catch (CallForCouncilException | LastSpaceReachedException | WhiteMarbleException ignored) {
        }
        int n3 = 0;
        for(int i = 0; i < player.getBuffer().size(); i++){
            if(player.getBuffer().get(i) == Resource.COIN)
                n3++;
        }
        assertEquals(1, n3);

        FileClass.FileDestroyer();
    }


}

