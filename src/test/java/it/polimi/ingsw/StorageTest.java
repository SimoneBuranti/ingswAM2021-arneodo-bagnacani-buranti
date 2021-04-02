package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class StorageTest {

    /**
     * Check of the correct initialisation of the values
     */
    @Test
    @DisplayName("Constructor Test")
    public void constructorTest() {
        Storage storage = new Storage();

        assertEquals(0, storage.getResource(Resource.COIN));
        assertEquals(0, storage.getResource(Resource.ROCK));
        assertEquals(0, storage.getResource(Resource.SERVANT));
        assertEquals(0, storage.getResource(Resource.SHIELD));
    }

    /**
     * Check of the correct behavior of addResource for each resource type
     */
    @Test
    @DisplayName("addResource Test")
    public void addResourceTest() {
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        assertEquals(0, storage.getResource(Resource.COIN));
        assertEquals(0, storage.getResource(Resource.ROCK));
        assertEquals(0, storage.getResource(Resource.SERVANT));
        assertEquals(0, storage.getResource(Resource.SHIELD));

        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1,storage.getResource(Resource.COIN));
        assertEquals(27, Reserve.getAmountOf(Resource.COIN));

        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2,storage.getResource(Resource.ROCK));
        assertEquals(26, Reserve.getAmountOf(Resource.ROCK));

        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3,storage.getResource(Resource.SHIELD));
        assertEquals(25, Reserve.getAmountOf(Resource.SHIELD));

        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4,storage.getResource(Resource.SERVANT));
        assertEquals(24, Reserve.getAmountOf(Resource.SERVANT));
    }

    /**
     * Check of the correct behavior of addResource for each resource type with
     * unavailable resources in reserve pool
     */
    @Test
    @DisplayName("addResource with unavailable resource Test")
    public void addResourceUnavailableTest() {
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        for (int i = 0; i < 28 ; i++){
            try {
                storage.addResource(Resource.COIN);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,storage.getResource(Resource.COIN));
            assertEquals(27-i, Reserve.getAmountOf(Resource.COIN));

            try {
                storage.addResource(Resource.ROCK);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,storage.getResource(Resource.ROCK));
            assertEquals(27-i, Reserve.getAmountOf(Resource.ROCK));

            try {
                storage.addResource(Resource.SHIELD);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,storage.getResource(Resource.SHIELD));
            assertEquals(27-i, Reserve.getAmountOf(Resource.SHIELD));

            try {
                storage.addResource(Resource.SERVANT);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,storage.getResource(Resource.SERVANT));
            assertEquals(27-i, Reserve.getAmountOf(Resource.SERVANT));

        }
        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,storage.getResource(Resource.COIN));
        assertEquals(0, Reserve.getAmountOf(Resource.COIN));

        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,storage.getResource(Resource.ROCK));
        assertEquals(0, Reserve.getAmountOf(Resource.ROCK));

        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,storage.getResource(Resource.SERVANT));
        assertEquals(0, Reserve.getAmountOf(Resource.SERVANT));

        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,storage.getResource(Resource.SHIELD));
        assertEquals(0, Reserve.getAmountOf(Resource.SHIELD));

    }

    /**
     *Check of the correct behavior of useResource for each resource type with
     *available or unavailable resources
     */
    @Test
    @DisplayName("useResource Test")
    public void useResourceTest() {
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2,storage.getResource(Resource.COIN));
        assertEquals(26, Reserve.getAmountOf(Resource.COIN));

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1,storage.getResource(Resource.COIN));
        assertEquals(27, Reserve.getAmountOf(Resource.COIN));

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.COIN));
        assertEquals(28, Reserve.getAmountOf(Resource.COIN));

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.COIN));
        assertEquals(28, Reserve.getAmountOf(Resource.COIN));

        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2,storage.getResource(Resource.ROCK));
        assertEquals(26, Reserve.getAmountOf(Resource.ROCK));

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.ROCK));
        assertEquals(28, Reserve.getAmountOf(Resource.ROCK));

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.ROCK));
        assertEquals(28, Reserve.getAmountOf(Resource.ROCK));

        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.SHIELD));
        assertEquals(28, Reserve.getAmountOf(Resource.SHIELD));

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.SHIELD));
        assertEquals(28, Reserve.getAmountOf(Resource.SHIELD));

        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4,storage.getResource(Resource.SERVANT));
        assertEquals(24, Reserve.getAmountOf(Resource.SERVANT));

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.SERVANT));
        assertEquals(28, Reserve.getAmountOf(Resource.SERVANT));

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,storage.getResource(Resource.SERVANT));
        assertEquals(28, Reserve.getAmountOf(Resource.SERVANT));
    }


    /**
     * Check of the correct behavior of the method check
     */
    @Test
    @DisplayName("check Test")
    public void checkTest(){
        Storage storage = new Storage();
        ArrayList<Resource> list = new ArrayList<>();
        Reserve reserve = new Reserve();


        assertTrue(storage.check(list));

        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        list.add(Resource.SHIELD);
        assertFalse(storage.check(list));

        list.remove(Resource.SHIELD);
        assertTrue(storage.check(list));

        list.add(Resource.SERVANT);
        assertTrue(storage.check(list));

        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertTrue(storage.check(list));

        list.add(Resource.SHIELD);
        assertFalse(storage.check(list));

        list.remove(Resource.SHIELD);
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertFalse(storage.check(list));

        list.remove(Resource.SERVANT);
        list.add(Resource.COIN);
        assertTrue(storage.check(list));

        list.add(Resource.ROCK);
        assertFalse(storage.check(list));

        list.remove(Resource.ROCK);
        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertFalse(storage.check(list));

        list.remove(Resource.COIN);
        list.add(Resource.SERVANT);
        assertFalse(storage.check(list));

        list.remove(Resource.SERVANT);
        list.remove(Resource.SERVANT);
        assertTrue(storage.check(list));

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertTrue(storage.check(list));

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertTrue(storage.check(list));

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertTrue(storage.check(list));

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertTrue(storage.check(list));


    }

    /**
     * Check of the correct behavior of the method discard
     */
    @Test
    @DisplayName("discard Test")
    public void discardTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        try {
            storage.discard(Resource.COIN);
        } catch (discardException e) {
            e.printStackTrace();
        }
        assertEquals(29, Reserve.getAmountOf(Resource.COIN));

        try {
            storage.discard(Resource.ROCK);
        } catch (discardException e) {
            e.printStackTrace();
        }
        try {
            storage.discard(Resource.SERVANT);
        } catch (discardException e) {
            e.printStackTrace();
        }
        try {
            storage.discard(Resource.SHIELD);
        } catch (discardException e) {
            e.printStackTrace();
        }
        assertEquals(29, Reserve.getAmountOf(Resource.ROCK));
        assertEquals(29, Reserve.getAmountOf(Resource.SERVANT));
        assertEquals(29, Reserve.getAmountOf(Resource.SHIELD));

        try {
            storage.discard(Resource.COIN);
        } catch (discardException e) {
            e.printStackTrace();
        }
        try {
            storage.discard(Resource.COIN);
        } catch (discardException e) {
            e.printStackTrace();
        }
        try {
            storage.discard(Resource.COIN);
        } catch (discardException e) {
            e.printStackTrace();
        }
        assertEquals(32, Reserve.getAmountOf(Resource.COIN));
    }


    /**
     * Check of the correct return of the method resourceScore
     */
    @Test
    @DisplayName("resourceScore Test")
    public void resourceScoreTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        assertEquals(0, storage.resourceScore());

        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1, storage.resourceScore());

        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, storage.resourceScore());

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2, storage.resourceScore());

        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(5, storage.resourceScore());

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, storage.resourceScore());

        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(7, storage.resourceScore());

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(6, storage.resourceScore());

        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(5, storage.resourceScore());

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4, storage.resourceScore());

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, storage.resourceScore());

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2, storage.resourceScore());

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1, storage.resourceScore());

        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0, storage.resourceScore());

        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0, storage.resourceScore());
    }

    /**
     * Check of the correct return of the method getStorageResource
     */
    @Test
    @DisplayName("getStorageResource Test")
    public void getStorageResourceTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();
        Map<Resource,Integer> map = new HashMap<Resource, Integer>();

        map.put(Resource.COIN, 0);
        map.put(Resource.ROCK, 0);
        map.put(Resource.SHIELD, 0);
        map.put(Resource.SERVANT, 0);
        assertEquals(map,storage.getStorageResource());

        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        map.put(Resource.SHIELD, 1);
        assertEquals(map,storage.getStorageResource());

        try {
            storage.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storage.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        map.put(Resource.COIN, 3);
        map.put(Resource.ROCK,2);
        map.put(Resource.SHIELD,2);
        map.put(Resource.SERVANT,1);
        assertEquals(map,storage.getStorageResource());

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        map.put(Resource.COIN,2);
        assertEquals(map,storage.getStorageResource());

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        map.put(Resource.COIN, 1);
        map.put(Resource.ROCK,1);
        map.put(Resource.SHIELD,1);
        assertEquals(map,storage.getStorageResource());

        try{
            storage.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try{
            storage.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try{
            storage.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try{
            storage.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        map.put(Resource.COIN, 0);
        map.put(Resource.ROCK,0);
        map.put(Resource.SHIELD,0);
        map.put(Resource.SERVANT,0);
        assertEquals(map,storage.getStorageResource());


    }
}