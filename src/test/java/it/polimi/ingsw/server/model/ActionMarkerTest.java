package it.polimi.ingsw.server.model;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerForCrossDouble;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerForCrossOnce;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerProductionBlue;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/**
 * test class about ActionMarkerTest
 */
public class ActionMarkerTest {


    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     */
    @Test
    @DisplayName("Action Marker Production Cards Test")
    public void actionMarkerBlueTest(){
        GameSolitaire game = new GameSolitaire("Ali",true);
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
    public void actionMarkerBlueCompleteTest() throws EndOfSolitaireGame {

        GameSolitaire game = new GameSolitaire("Ali",true);
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
     * Check of the correct behavior of the action marker that moves the black cross forward one spaces and shuffles the action marker deck
     */
    @Test
    @DisplayName("Action Marker Black Cross Once Test")
    public void ActionMarkerCrossOnceTest(){
        ActionMarkerForCrossOnce actionMarker = new ActionMarkerForCrossOnce();
        GameSolitaire game = new GameSolitaire("Ali",true);

        ActionMarker actionMarker1 = game.showFirst();
        assertEquals(0, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);

        assertEquals(1, game.getLorenzoFaithIndicator());
        assertNotEquals(actionMarker1, game.showFirst());

        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(2, game.getLorenzoFaithIndicator());
        assertNotEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(8, game.getLorenzoFaithIndicator());
        assertNotEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(16, game.getLorenzoFaithIndicator());
        assertNotEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(24, game.getLorenzoFaithIndicator());
        assertNotEquals(actionMarker1, game.showFirst());

    }

    /**
     * Check of the correct behavior of the action marker that moves the black cross forward by two spaces
     */
    @Test
    @DisplayName("Action Marker Black Cross Double Test")
    public void ActionMarkerCrossDoubleTest(){
        ActionMarkerForCrossDouble actionMarker = new ActionMarkerForCrossDouble();
        GameSolitaire game = new GameSolitaire("Ali",true);

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
