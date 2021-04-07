package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ActionMarkerTest {


    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     */
    @Test
    @DisplayName("Action Marker Production Cards Test")
    public void actionMarkerBlueTest(){
        ActionMarkerProductionBlue actionMarker = new ActionMarkerProductionBlue();
        GameSolitaire game = new GameSolitaire("Ali");
        DeckProductionCardOneBlu deckProductionCardOneBlu = new DeckProductionCardOneBlu();
        DeckProductionCardTwoBlu deckProductionCardTwoBlu = new DeckProductionCardTwoBlu();
        DeckProductionCardThreeBlu deckProductionCardThreeBlu = new DeckProductionCardThreeBlu();

        assertEquals(4, game.deckSize(deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.deckSize(deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(2, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(2, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(0, game.deckSize(deckProductionCardThreeBlu));
    }

    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     * considering the case in which some production cards are bought by the player
     */
    @Test
    @DisplayName("Action Marker Production Cards Complete Test")
    public void actionMarkerBlueCompleteTest() throws EndOfSolitaireGame {
        ActionMarkerProductionBlue actionMarker = new ActionMarkerProductionBlue();
        GameSolitaire game = new GameSolitaire("Ali");
        DeckProductionCardOneBlu deckProductionCardOneBlu = new DeckProductionCardOneBlu();
        DeckProductionCardTwoBlu deckProductionCardTwoBlu = new DeckProductionCardTwoBlu();
        DeckProductionCardThreeBlu deckProductionCardThreeBlu = new DeckProductionCardThreeBlu();

        assertEquals(4, game.deckSize(deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.deckSize(deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        DeckProductionCardOneBlu.removeOneCard();

        assertEquals(1, game.deckSize(deckProductionCardOneBlu));
        assertEquals(4, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(3, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));

        DeckProductionCardOneBlu.removeOneCard();
        game.activateActionMarker(actionMarker);

        assertEquals(0, game.deckSize(deckProductionCardOneBlu));
        assertEquals(0, game.deckSize(deckProductionCardTwoBlu));
        assertEquals(4, game.deckSize(deckProductionCardThreeBlu));
    }


    /**
     * Check of the correct behavior of the action marker that moves the black cross forward one spaces and shuffles the action marker deck
     */
    @Test
    @DisplayName("Action Marker Black Cross Once Test")
    public void ActionMarkerCrossOnceTest(){
        ActionMarkerForCrossOnce actionMarker = new ActionMarkerForCrossOnce();
        GameSolitaire game = new GameSolitaire("Ali");

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
        GameSolitaire game = new GameSolitaire("Ali");

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
