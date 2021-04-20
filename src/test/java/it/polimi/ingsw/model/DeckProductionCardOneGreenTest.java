package it.polimi.ingsw.model;

import org.junit.jupiter.api.*;

import java.util.*;

/**
 * test class about DeckProductionCardOneGreen
 */
class DeckProductionCardOneGreenTest {

    /**
     * test about requiredResourcesTest
     */
    @Test
    @DisplayName("requiredResourcesTest -")
    public void requiredResourcesTest(){
        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        ArrayList<Resource> cost = deck.requiredResources();


    }

}