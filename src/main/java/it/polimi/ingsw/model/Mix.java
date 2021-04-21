package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * this class contains only one method to mix arrayList of generic T objects
 */
public class Mix {
    /**
     * this method takes in an arrayList of T objects and changes the order of these objects randomly
     * @param list : arrayList to mix
     * @param <T> : generic object contained in the list
     */
    public static  <T> void MIXED (ArrayList<T> list) {
        Collections.shuffle(list, new Random(4));
    }

}
