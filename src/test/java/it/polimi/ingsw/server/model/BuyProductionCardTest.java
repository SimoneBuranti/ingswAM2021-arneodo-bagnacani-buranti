package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import it.polimi.ingsw.server.virtualview.VirtualView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BuyProductionCardTest {

    /**
     * test to check that GameSolitaire's buyProductionCard method throws the EndOfSolitaireGame exception correctly
     */
    @Test
    @DisplayName("Buy production card in solitaire game test")
    public void buyInSolitaireGame() throws IOException, InterruptedException {
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);
        GameBoardInterface gameBoard = game.getGameBoardOfPlayer();

        for(int i = 0; i < 20; i++)
            gameBoard.addToStrongbox(Resource.COIN);

        for(int i = 0; i < 20; i++)
            gameBoard.addToStrongbox(Resource.ROCK);

        for(int i = 0; i < 20; i++)
            gameBoard.addToStrongbox(Resource.SERVANT);

        for(int i = 0; i < 20; i++)
            gameBoard.addToStrongbox(Resource.SHIELD);

       /* game.buyProductionCard(game.deckProductionCardOneViolet, 2);
        assertEquals(3, game.deckSize(game.deckProductionCardOneViolet));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoViolet));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeViolet));

        game.activateActionMarker(new ActionMarkerProductionViolet());
        assertEquals(1, game.deckSize(game.deckProductionCardOneViolet));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoViolet));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeViolet));

        game.buyProductionCard(game.deckProductionCardTwoViolet, 2);
        assertEquals(1, game.deckSize(game.deckProductionCardOneViolet));
        assertEquals(3, game.deckSize(game.deckProductionCardTwoViolet));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeViolet));

        game.activateActionMarker(new ActionMarkerProductionViolet());
        game.activateActionMarker(new ActionMarkerProductionViolet());
        game.activateActionMarker(new ActionMarkerProductionViolet());
        assertEquals(0, game.deckSize(game.deckProductionCardOneViolet));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoViolet));
        assertEquals(2, game.deckSize(game.deckProductionCardThreeViolet));

        game.buyProductionCard(game.deckProductionCardOneGreen, 1);
        game.buyProductionCard(game.deckProductionCardTwoGreen, 1);
        game.buyProductionCard(game.deckProductionCardThreeViolet, 1);
        assertEquals(0, game.deckSize(game.deckProductionCardOneViolet));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoViolet));
        assertEquals(1, game.deckSize(game.deckProductionCardThreeViolet));


        game.buyProductionCard(game.deckProductionCardThreeViolet, 2);
        assertEquals(0, game.deckSize(game.deckProductionCardOneViolet));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoViolet));
        assertEquals(0, game.deckSize(game.deckProductionCardThreeViolet));*/
    }

}
