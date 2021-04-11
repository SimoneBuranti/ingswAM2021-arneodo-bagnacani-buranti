package it.polimi.ingsw.model;

import it.polimi.ingsw.model.DeckProductionCardOneGreen;
import it.polimi.ingsw.model.Resource;
import org.junit.jupiter.api.*;

import java.util.*;


class DeckProductionCardOneGreenTest {


    @Test
    @DisplayName("requiredResourcesTest -")
    public void requiredResourcesTest(){
        DeckProductionCardOneGreen deck = new DeckProductionCardOneGreen();
        ArrayList<Resource> cost = deck.requiredResources();




    }

}