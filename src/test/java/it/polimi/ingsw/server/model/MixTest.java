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



   

}