package it.polimi.ingsw.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test class about StorageExtraSecond
 */
public class StorageExtraSecondTest {

    /**
     * Check of the correct initialisation of the values
     */
    @Test
    @DisplayName("Constructor Test")
    public void constructorTest(){
        Storage storage = new Storage();
        new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraSecond storageExtra = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);


        assertEquals(Resource.COIN, storageExtra.getFirstResourceType());
        assertEquals(Resource.ROCK, storageExtra.getSecondResourceType());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(2,storageExtra.getResource(Resource.COIN));
        assertEquals(2,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        StorageExtraFirst storageExtra1 = new StorageExtraFirst(Resource.SHIELD, storage.getStorageResource());

        storageExtra1.addResource(Resource.SHIELD);
        assertEquals(1, storageExtra1.getNumExtraFirstAvailable());

        StorageExtraSecond storageExtra2 = new StorageExtraSecond(Resource.SHIELD, Resource.SERVANT, storage.getStorageResource(), 1);

        assertEquals(Resource.SHIELD, storageExtra2.getFirstResourceType());
        assertEquals(Resource.SERVANT, storageExtra2.getSecondResourceType());
        assertEquals(1, storageExtra2.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra2.getNUmExtraSecondAvailable());
        assertEquals(2,storageExtra2.getResource(Resource.COIN));
        assertEquals(2,storageExtra2.getResource(Resource.ROCK));
        assertEquals(1,storageExtra2.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra2.getResource(Resource.SHIELD));

        storageExtra1.addResource(Resource.SHIELD);
        assertEquals(0, storageExtra1.getNumExtraFirstAvailable());


        StorageExtraSecond storageExtra3 = new StorageExtraSecond(Resource.SHIELD, Resource.SERVANT, storage.getStorageResource(), 0);

        assertEquals(Resource.SHIELD, storageExtra3.getFirstResourceType());
        assertEquals(Resource.SERVANT, storageExtra3.getSecondResourceType());
        assertEquals(0, storageExtra3.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra3.getNUmExtraSecondAvailable());
        assertEquals(2,storageExtra3.getResource(Resource.COIN));
        assertEquals(2,storageExtra3.getResource(Resource.ROCK));
        assertEquals(1,storageExtra3.getResource(Resource.SERVANT));
        assertEquals(2,storageExtra3.getResource(Resource.SHIELD));
    }


    /**
     * Check of the correct behavior of addResource for the type of resource of the first extra storage and of the second extra storage
     */
    @Test
    @DisplayName("addResource Test")
    public void addResourceTest(){
        Storage storage = new Storage();
        new Reserve();


        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraSecond storageExtra = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);

        storageExtra.addResource(Resource.SHIELD);

        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(1,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);

        assertEquals(1, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(2,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(3,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(4,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.ROCK);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(1, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(4,storageExtra.getResource(Resource.COIN));
        assertEquals(2,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.ROCK);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(4,storageExtra.getResource(Resource.COIN));
        assertEquals(3,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.ROCK);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(4,storageExtra.getResource(Resource.COIN));
        assertEquals(4,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(1,storageExtra.getResource(Resource.SHIELD));
    }

    /**
     *Check of the correct behavior of useResource for the type of resource of the first extra storage and of the second extra storage
     */
    @Test
    @DisplayName("useResource Test")
    public void useResourceTest(){
        Storage storage = new Storage();
        new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraSecond storageExtra = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(0,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(0,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.ROCK);
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(3,storageExtra.getResource(Resource.COIN));
        assertEquals(3,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(2,storageExtra.getResource(Resource.COIN));
        assertEquals(3,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(1,storageExtra.getResource(Resource.COIN));
        assertEquals(3,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(3,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(1, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(2,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(1,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(0,storageExtra.getResource(Resource.ROCK));
        assertEquals(1,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(0,storageExtra.getResource(Resource.ROCK));
        assertEquals(0,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(0,storageExtra.getResource(Resource.COIN));
        assertEquals(0,storageExtra.getResource(Resource.ROCK));
        assertEquals(0,storageExtra.getResource(Resource.SERVANT));
        assertEquals(0,storageExtra.getResource(Resource.SHIELD));
    }


    /**
     * Check of the correct behavior of the method check with the type of resource of the first extra storage and of the second extra storage
     */
    @Test
    @DisplayName("check Test")
    public void checkTest(){
        Storage storage = new Storage();
        new Reserve();
        ArrayList<Resource> list = new ArrayList<>();
        ArrayList<Resource> list1 = new ArrayList<>();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraSecond storageExtra = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);

        assertTrue(storageExtra.check(list));

        list.add(Resource.SHIELD);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.SHIELD);
        list.add(Resource.COIN);
        list.add(Resource.COIN);
        list.add(Resource.ROCK);
        list.add(Resource.ROCK);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        list.add(Resource.ROCK);
        list.add(Resource.SERVANT);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.SERVANT);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.ROCK);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.ROCK);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.COIN);
        list.remove(Resource.COIN);
        list.remove(Resource.ROCK);
        list.remove(Resource.ROCK);
        list.remove(Resource.ROCK);
        list.add(Resource.SERVANT);
        list.add(Resource.SERVANT);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        list.add(Resource.COIN);
        assertTrue(storageExtra.check(list));

        list.add(Resource.COIN);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.COIN);
        list.add(Resource.ROCK);
        assertFalse(storageExtra.check(list));

        list.remove(Resource.COIN);
        assertTrue(storageExtra.check(list));

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);

        StorageExtraSecond storageExtra1 = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);

        assertTrue(storageExtra1.check(list1));

        list1.add(Resource.COIN);
        list1.add(Resource.COIN);
        list1.add(Resource.ROCK);
        list1.add(Resource.ROCK);
        assertTrue(storageExtra1.check(list1));

        list1.add(Resource.ROCK);
        assertFalse(storageExtra1.check(list1));

        list1.remove(Resource.ROCK);
        list1.add(Resource.SHIELD);
        assertFalse(storageExtra1.check(list1));
    }


    /**
     * Check of the correct return of the method getResource
     */
    @Test
    @DisplayName("getResource Test")
    public void getResourceTest(){
        Storage storage = new Storage();
        new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraSecond storageExtra = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);

        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(1, storageExtra.getResource(Resource.COIN));
        assertEquals(1, storageExtra.getResource(Resource.ROCK));
        assertEquals(1, storageExtra.getResource(Resource.SERVANT));
        assertEquals(0, storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.SHIELD);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(3, storageExtra.getResource(Resource.COIN));
        assertEquals(3, storageExtra.getResource(Resource.ROCK));
        assertEquals(1, storageExtra.getResource(Resource.SERVANT));
        assertEquals(1, storageExtra.getResource(Resource.SHIELD));

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.SERVANT);
        storageExtra.addResource(Resource.SHIELD);

        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(4, storageExtra.getResource(Resource.COIN));
        assertEquals(4, storageExtra.getResource(Resource.ROCK));
        assertEquals(2, storageExtra.getResource(Resource.SERVANT));
        assertEquals(2, storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());
        assertEquals(1, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(3, storageExtra.getResource(Resource.COIN));
        assertEquals(3, storageExtra.getResource(Resource.ROCK));
        assertEquals(2, storageExtra.getResource(Resource.SERVANT));
        assertEquals(2, storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(2, storageExtra.getResource(Resource.COIN));
        assertEquals(2, storageExtra.getResource(Resource.ROCK));
        assertEquals(2, storageExtra.getResource(Resource.SERVANT));
        assertEquals(2, storageExtra.getResource(Resource.SHIELD));

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());
        assertEquals(1, storageExtra.getResource(Resource.COIN));
        assertEquals(1, storageExtra.getResource(Resource.ROCK));
        assertEquals(2, storageExtra.getResource(Resource.SERVANT));
        assertEquals(2, storageExtra.getResource(Resource.SHIELD));
    }

    /**
     * Check of the correct return of the method resourceScore
     */
    @Test
    @DisplayName("resourceScore Test")
    public void resourceScoreTest(){
        Storage storage = new Storage();
        new Reserve();

        storage.addResource(Resource.COIN);
        storage.addResource(Resource.ROCK);
        storage.addResource(Resource.SERVANT);

        StorageExtraSecond storageExtra = new StorageExtraSecond(Resource.COIN, Resource.ROCK, storage.getStorageResource(), 2);

        assertEquals(3, storageExtra.resourceScore());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());

        storageExtra.addResource(Resource.SHIELD);
        assertEquals(4, storageExtra.resourceScore());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.SHIELD);
        assertEquals(7, storageExtra.resourceScore());
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());
        assertEquals(1, storageExtra.getNUmExtraSecondAvailable());

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.ROCK);
        assertEquals(9, storageExtra.resourceScore());
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());

        storageExtra.addResource(Resource.COIN);
        storageExtra.addResource(Resource.ROCK);
        storageExtra.addResource(Resource.SHIELD);
        storageExtra.addResource(Resource.SERVANT);

        assertEquals(13, storageExtra.resourceScore());
        assertEquals(0, storageExtra.getNumExtraFirstAvailable());
        assertEquals(0, storageExtra.getNUmExtraSecondAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(11, storageExtra.resourceScore());
        assertEquals(1, storageExtra.getNumExtraFirstAvailable());
        assertEquals(1, storageExtra.getNUmExtraSecondAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(9, storageExtra.resourceScore());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(5, storageExtra.resourceScore());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());

        try {
            storageExtra.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            storageExtra.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(5, storageExtra.resourceScore());
        assertEquals(2, storageExtra.getNumExtraFirstAvailable());
        assertEquals(2, storageExtra.getNUmExtraSecondAvailable());

        try {
            storageExtra.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        assertEquals(4, storageExtra.resourceScore());
    }
}
