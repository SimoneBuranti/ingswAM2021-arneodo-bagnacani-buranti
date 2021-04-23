package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.marbles.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test class about Mix
 */
public class MixTest {
    /**
     * test about the functionality of marble list
     */
    @Test
    public void TestAboutOnlyListMarble()
    {
        ArrayList<Marble> List = new ArrayList<>(13);

        RedMarble redOne = new RedMarble();
        List.add(redOne);
        YellowMarble yellowFirst = new YellowMarble();
        List.add(yellowFirst);
        YellowMarble yellowSecond = new YellowMarble();
        List.add(yellowSecond);
        BluMarble bluFirst = new BluMarble();
        List.add(bluFirst);
        BluMarble bluSecond = new BluMarble();
        List.add(bluSecond);
        GreyMarble greyFirst = new GreyMarble();
        List.add(greyFirst);
        GreyMarble greySecond = new GreyMarble();
        List.add(greySecond);
        PurpleMarble purpleFirst = new PurpleMarble();
        List.add(purpleFirst);
        PurpleMarble purpleSecond = new PurpleMarble();
        List.add(purpleSecond);
        WhiteMarble whiteFirst = new WhiteMarble();
        List.add(whiteFirst);
        WhiteMarble whiteSecond = new WhiteMarble();
        List.add(whiteSecond);
        WhiteMarble whiteThird = new WhiteMarble();
        List.add(whiteThird);
        WhiteMarble whiteFourth = new WhiteMarble();
        List.add(whiteFourth);
        assertEquals(List.get(0), redOne);
        assertEquals(List.get(1), yellowFirst);
        assertEquals(List.get(2), yellowSecond);
        assertEquals(List.get(3), bluFirst);
        assertEquals(List.get(4), bluSecond);
    }

    /**
     * test about the existence of the old element
     */
    @Test
    public void FindElement()
    {
        ArrayList<Marble> List = new ArrayList<>(4);

        RedMarble redOne = new RedMarble();
        List.add(redOne);
        YellowMarble yellowFirst = new YellowMarble();
        List.add(yellowFirst);
        YellowMarble yellowSecond = new YellowMarble();
        List.add(yellowSecond);
        BluMarble bluFirst = new BluMarble();
        List.add(bluFirst);
        Mix.MIXED(List);

        assertTrue( List.get(0).equals(redOne) ||
        List.get(1).equals(redOne) ||
        List.get(2).equals(redOne) ||
        List.get(3).equals(redOne));

        assertTrue( List.get(0).equals(yellowFirst) ||
                List.get(1).equals(yellowFirst) ||
                List.get(2).equals(yellowFirst) ||
                List.get(3).equals(yellowFirst));


        assertTrue( List.get(0).equals(bluFirst) ||
                List.get(1).equals(bluFirst) ||
                List.get(2).equals(bluFirst) ||
                List.get(3).equals(bluFirst));

        assertTrue( List.get(0).equals(yellowSecond) ||
                List.get(1).equals(yellowSecond) ||
                List.get(2).equals(yellowSecond) ||
                List.get(3).equals(yellowSecond));


    }



    /**
     * Try if the functionality of mixed works also with a list of Integer
     */
    @Test
    public void TryWhitAnotherType()
    {
        ArrayList<Integer> List = new ArrayList<>(4);

        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);

        assertEquals(1, (int) List.get(0));
        assertEquals(2, (int) List.get(1));
        assertEquals(3, (int) List.get(2));
        assertEquals(4, (int) List.get(3));

        Mix.MIXED(List);

        assertTrue( List.get(0).equals(1) ||
                List.get(1).equals(1) ||
                List.get(2).equals(1) ||
                List.get(3).equals(1));

        assertTrue( List.get(0).equals(2) ||
                List.get(1).equals(2) ||
                List.get(2).equals(2) ||
                List.get(3).equals(2));


        assertTrue( List.get(0).equals(3) ||
                List.get(1).equals(3) ||
                List.get(2).equals(3) ||
                List.get(3).equals(3));

        assertTrue( List.get(0).equals(4) ||
                List.get(1).equals(4) ||
                List.get(2).equals(4) ||
                List.get(3).equals(4));

        List.add(5);
        assertEquals(5, (int) List.get(4));


        Mix.MIXED(List);
        assertNotEquals(5, List.get(4));

        Mix.MIXED(List);
        List.add(6);
        assertEquals(6, (int) List.get(5));
        assertNotEquals(5, List.get(4));













    }

}