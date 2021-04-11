package it.polimi.ingsw.model;
import it.polimi.ingsw.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MixTest {
    /**
     * test about the functionality of marble list
     */
    @Test
    public void TestAboutOnlyListMarble()
    {
        ArrayList<Marble> List = new ArrayList<Marble>(13);

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
        assertTrue( List.get(0).equals(redOne));
        assertTrue( List.get(1).equals(yellowFirst));
        assertTrue( List.get(2).equals(yellowSecond));
        assertTrue( List.get(3).equals(bluFirst));
        assertTrue( List.get(4).equals(bluSecond));
    }

    /**
     * test about the existence of the old element
     */
    @Test
    public void FindElement()
    {
        ArrayList<Marble> List = new ArrayList<Marble>(4);

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
        ArrayList<Integer> List = new ArrayList<Integer>(4);

        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);

        assertTrue( List.get(0).equals(1));
        assertTrue( List.get(1).equals(2));
        assertTrue( List.get(2).equals(3));
        assertTrue( List.get(3).equals(4));

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
        assertTrue( List.get(4).equals(5));


        Mix.MIXED(List);
        assertNotEquals(5, List.get(4));

        Mix.MIXED(List);
        List.add(6);
        assertTrue( List.get(5).equals(6));
        assertNotEquals(5, List.get(4));













    }

}