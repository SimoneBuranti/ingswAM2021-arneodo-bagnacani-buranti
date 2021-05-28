package it.polimi.ingsw.server.model;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerForCrossDouble;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerProductionBlue;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import it.polimi.ingsw.server.virtualview.VirtualView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * test class about ActionMarkerTest
 */
public class ActionMarkerTest {


    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     */
    @Test
    @DisplayName("Action Marker Production Cards Test")
    public void actionMarkerBlueTest() throws IOException, InterruptedException {
      //  GameSolitaire game = new GameSolitaire("Ali",true);
        ActionMarker actionMarker= new ActionMarkerProductionBlue();


        /*assertEquals(4, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));
        game.activateActionMarker(actionMarker);


        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(2, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));
        game.activateActionMarker(actionMarker);



        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);



        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(2, game.deckSize(game.deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);



        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(0, game.deckSize(game.deckProductionCardThreeBlu));*/
    }

    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     * considering the case in which some production cards are bought by the player
     */
    @Test
    @DisplayName("Action Marker Production Cards Complete Test")
    public void actionMarkerBlueCompleteTest() throws EndOfSolitaireGame, IOException, InterruptedException {

     //   GameSolitaire game = new GameSolitaire("Ali",true);
        ActionMarker actionMarker= new ActionMarkerProductionBlue();



    /*    assertEquals(4, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);


        assertEquals(2, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));


        try {
            game.deckProductionCardOneBlu.removeOneCard();
        } catch (EmptyException e) {
            e.printStackTrace();
        }

        assertEquals(1, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(3, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));

        try {
            game.deckProductionCardTwoBlu.removeOneCard();
        } catch (EmptyException e) {
            e.printStackTrace();
        }
        game.activateActionMarker(actionMarker);


        assertEquals(0, game.deckSize(game.deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(game.deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(game.deckProductionCardThreeBlu));*/
    }


    /**
     * Check of the correct behavior of the action marker that moves the black cross forward by two spaces
     */
    @Test
    @DisplayName("Action Marker Black Cross Double Test")
    public void ActionMarkerCrossDoubleTest() throws IOException, InterruptedException {
        ActionMarkerForCrossDouble actionMarker = new ActionMarkerForCrossDouble();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        ActionMarker actionMarker1;
        actionMarker1 = game.showFirst();
        assertEquals(0, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(4, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(8, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(16, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(24, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

    }
}
