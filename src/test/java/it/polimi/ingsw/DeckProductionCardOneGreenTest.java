package it.polimi.ingsw;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class DeckProductionCardOneGreenTest {


    @Test
    @DisplayName("requiredResourcesTest -")
    public void requiredResourcesTest(){
        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        ArrayList<Resource> cost = deck.requiredResources();




    }

}