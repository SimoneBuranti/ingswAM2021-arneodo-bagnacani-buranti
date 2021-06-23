package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.FullColumnException;
import it.polimi.ingsw.server.model.exceptions.LevelException;
import it.polimi.ingsw.server.model.exceptions.NotEnoughResourcesException;
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


        try {
            game.buyProductionCard(game.deckFromDeckNumber(4),1 );
        } catch (EmptyException e) {
            e.printStackTrace();
        } catch (FullColumnException e) {
            e.printStackTrace();
        } catch (NotEnoughResourcesException e) {
            e.printStackTrace();
        } catch (LevelException e) {
            e.printStackTrace();
        }
        FileClass.FileDestroyer();
    }

}
