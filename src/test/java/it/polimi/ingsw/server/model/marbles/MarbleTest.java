package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.GameSolitaire;
import it.polimi.ingsw.server.model.players.PlayerFirst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarbleTest {

    @Test
    public void baseMarbleTest(){
        Marble marble = new Marble();

        assertEquals(marble.getColour(),null);
    }


}