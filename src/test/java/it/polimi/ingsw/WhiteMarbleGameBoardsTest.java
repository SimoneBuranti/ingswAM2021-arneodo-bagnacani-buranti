package it.polimi.ingsw;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class WhiteMarbleGameBoardsTest {

    @Test
    @DisplayName("whiteExchangeTest0 - simple test")
    public void whiteExchangeTest0() {
        WhiteMarble whiteMarble = new WhiteMarble();
        Player player = new Player("SIMOSIMO" , new Game());

        try {
            whiteMarble.giveResource(player);
        } catch (WhiteMarbleException e) {
            e.printStackTrace();
        }

    }


}