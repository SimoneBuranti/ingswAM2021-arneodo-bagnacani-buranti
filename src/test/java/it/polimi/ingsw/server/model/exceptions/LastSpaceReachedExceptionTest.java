package it.polimi.ingsw.server.model.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastSpaceReachedExceptionTest {

    @Test
    void overallTest() {
        LastSpaceReachedException e = new LastSpaceReachedException();

        assertEquals(e.getNickName(),null);
        assertEquals(e.getCurrCall(),0);
        e.setCurrCall(4);
        e.setNickName("Leone cane fifone");
        assertEquals("Leone cane fifone",e.getNickName());
        assertEquals(4,e.getCurrCall());

    }

}