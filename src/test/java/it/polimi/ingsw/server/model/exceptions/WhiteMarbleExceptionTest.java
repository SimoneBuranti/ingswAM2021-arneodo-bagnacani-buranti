package it.polimi.ingsw.server.model.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMarbleExceptionTest {


    @Test
    public void overall(){
        WhiteMarbleException w = new WhiteMarbleException(5);

        assertEquals(5,w.getN());
        w.increase();
        assertEquals(6,w.getN());
    }
}