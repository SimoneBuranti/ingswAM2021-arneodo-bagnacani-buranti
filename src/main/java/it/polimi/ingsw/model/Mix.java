package it.polimi.ingsw.model;

/**
 * @author bagna
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * method shuffles object
 */

public class Mix {
    public static  <T> void MIXED (ArrayList<T> List) {
        Collections.shuffle(List, new Random(4));
    }

}
