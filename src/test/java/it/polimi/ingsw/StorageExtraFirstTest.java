package it.polimi.ingsw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageExtraFirstTest {

    /**
     * Check of the correct initialisation of the values
     */
    @Test
    @DisplayName("Constructor Test")
    public void constructorTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraFirst storageExtra = new StorageExtraFirst(Resource.COIN, storage.getStorageResource());

        assertEquals(Resource.COIN, storageExtra.getFirstResourceType());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2,storageExtra.getResource(Resource.COIN));
        assertEquals(2,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));


    }


    /**
     * Check of the correct behavior of addResource for the type of resource of the first extra storage
     */
    @Test
    @DisplayName("addResource Test")
    public void addResourceTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraFirst storageExtra = new StorageExtraFirst(Resource.COIN, storage.getStorageResource());

        assertEquals(2,storageExtra.getResource(Resource.COIN));
        assertEquals(2,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));

        storageExtra.addResource(Resource.SHIELD);

        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);

        assertEquals(3, storageExtra.getResource(Resource.COIN));
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);

        assertEquals(4, storageExtra.getResource(Resource.COIN));
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        assertEquals(5, storageExtra.getResource(Resource.COIN));
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
    }


    /**
     *Check of the correct behavior of useResource for the type of resource of the first extra storage
     */
    @Test
    @DisplayName("useResource Test")
    public void useResourceTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraFirst storageExtra = new StorageExtraFirst(Resource.COIN, storage.getStorageResource());

        try {
            storageExtra.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(0, storageExtra.getResource(Resource.SERVANT));

        try {
            storageExtra.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(0, storageExtra.getResource(Resource.SERVANT));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(1,storageExtra.getResource(Resource.COIN));
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.COIN);
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2,storageExtra.getResource(Resource.COIN));
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(1,storageExtra.getResource(Resource.COIN));
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());

    }

    /**
     * Check of the correct behavior of the method check with the type of resource of the first extra storage
     */
    @Test
    @DisplayName("check Test")
    public void checkTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();
        ArrayList<Resource> list = new ArrayList<>();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraFirst storageExtra = new StorageExtraFirst(Resource.COIN, storage.getStorageResource());

        assertTrue(storageExtra.check(list));

        list.add(Resource.SHIELD);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.SHIELD);
        list.add(Resource.ROCK);
        assertTrue(storageExtra.check(list));

        list.add(Resource.ROCK);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.ROCK);
        list.add(Resource.SERVANT);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.SERVANT);
        list.add(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.ROCK);
        assertTrue(storageExtra.check(list));

        list.add(Resource.SERVANT);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.SERVANT);
        list.remove(Resource.COIN);
        list.remove(Resource.COIN);
        list.remove(Resource.COIN);
        storageExtra.addResource(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        list.add(Resource.COIN);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.remove(Resource.COIN);
        storageExtra.addResource(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.ROCK);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.COIN);
        assertTrue(storageExtra.check(list));
    }

    /**
     * Check of the correct return of the method getResource
     */
    @Test
    @DisplayName("getResource Test")
    public void getResourceTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraFirst storageExtra = new StorageExtraFirst(Resource.COIN, storage.getStorageResource());

        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getResource(Resource.COIN));
        assertEquals(2, storageExtra.getResource(Resource.ROCK));
        assertEquals(1, storageExtra.getResource(Resource.SERVANT));
        assertEquals(0, storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);
        assertEquals(3, storageExtra.getResource(Resource.COIN));
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        assertEquals(4, storageExtra.getResource(Resource.COIN));
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        assertEquals(5, storageExtra.getResource(Resource.COIN));
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.SHIELD);
        assertEquals(1, storageExtra.getResource(Resource.SHIELD));

    }

    /**
     * Check of the correct return of the method resourceScore
     */
    @Test
    @DisplayName("resourceScore Test")
    public void resourceScoreTest(){
        Storage storage = new Storage();
        Reserve reserve = new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraFirst storageExtra = new StorageExtraFirst(Resource.COIN, storage.getStorageResource());

        assertEquals(5, storageExtra.resourceScore());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        assertEquals(6, storageExtra.resourceScore());
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        assertEquals(7, storageExtra.resourceScore());
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.COIN);
        assertEquals(8, storageExtra.resourceScore());
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());

        storageExtra.addResource(Resource.SHIELD);
        storageExtra.addResource(Resource.SHIELD);
        storageExtra.addResource(Resource.SERVANT);
        storageExtra.addResource(Resource.ROCK);
        assertEquals(12, storageExtra.resourceScore());

    }

}
