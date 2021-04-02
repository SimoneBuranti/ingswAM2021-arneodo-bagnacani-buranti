package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StrongboxTest {
    /**
     * Check of the correct initialisation of the values
     */
    @Test
    @DisplayName("Constructor Test")
    public void constructorTest() {
        Strongbox strongbox = new Strongbox();

        assertEquals(0, strongbox.getResource(Resource.COIN));
        assertEquals(0, strongbox.getResource(Resource.ROCK));
        assertEquals(0, strongbox.getResource(Resource.SERVANT));
        assertEquals(0, strongbox.getResource(Resource.SHIELD));
    }

    /**
     * Check of the correct behavior of addResource for each resource type
     */
    @Test
    @DisplayName("addResource Test")
    public void addResourceTest() {
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        assertEquals(0, strongbox.getResource(Resource.COIN));
        assertEquals(0, strongbox.getResource(Resource.ROCK));
        assertEquals(0, strongbox.getResource(Resource.SERVANT));
        assertEquals(0, strongbox.getResource(Resource.SHIELD));

        try {
            strongbox.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1,strongbox.getResource(Resource.COIN));
        assertEquals(27, Reserve.getAmountOf(Resource.COIN));

        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2,strongbox.getResource(Resource.ROCK));
        assertEquals(26, Reserve.getAmountOf(Resource.ROCK));

        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3,strongbox.getResource(Resource.SHIELD));
        assertEquals(25, Reserve.getAmountOf(Resource.SHIELD));

        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4,strongbox.getResource(Resource.SERVANT));
        assertEquals(24, Reserve.getAmountOf(Resource.SERVANT));
    }

    /**
     * Check of the correct behavior of addResource for each resource type with
     * unavailable resources in reserve pool
     */
    @Test
    @DisplayName("addResource with unavailable resource Test")
    public void addResourceUnavailableTest() {
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        for (int i = 0; i < 28 ; i++){
            try {
                strongbox.addResource(Resource.COIN);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,strongbox.getResource(Resource.COIN));
            assertEquals(27-i, Reserve.getAmountOf(Resource.COIN));

            try {
                strongbox.addResource(Resource.ROCK);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,strongbox.getResource(Resource.ROCK));
            assertEquals(27-i, Reserve.getAmountOf(Resource.ROCK));

            try {
                strongbox.addResource(Resource.SHIELD);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,strongbox.getResource(Resource.SHIELD));
            assertEquals(27-i, Reserve.getAmountOf(Resource.SHIELD));

            try {
                strongbox.addResource(Resource.SERVANT);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }

            assertEquals(1+i,strongbox.getResource(Resource.SERVANT));
            assertEquals(27-i, Reserve.getAmountOf(Resource.SERVANT));

        }
        try {
            strongbox.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,strongbox.getResource(Resource.COIN));
        assertEquals(0, Reserve.getAmountOf(Resource.COIN));

        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,strongbox.getResource(Resource.ROCK));
        assertEquals(0, Reserve.getAmountOf(Resource.ROCK));

        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,strongbox.getResource(Resource.SERVANT));
        assertEquals(0, Reserve.getAmountOf(Resource.SERVANT));

        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(28,strongbox.getResource(Resource.SHIELD));
        assertEquals(0, Reserve.getAmountOf(Resource.SHIELD));

    }

    /**
     *Check of the correct behavior of useResource for each resource type with
     *available and unavailable resources
     */
    @Test
    @DisplayName("useResource Test")
    public void useResourceTest() {
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        try {
            strongbox.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2,strongbox.getResource(Resource.COIN));
        assertEquals(26, Reserve.getAmountOf(Resource.COIN));

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1,strongbox.getResource(Resource.COIN));
        assertEquals(27, Reserve.getAmountOf(Resource.COIN));

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.COIN));
        assertEquals(28, Reserve.getAmountOf(Resource.COIN));

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.COIN));
        assertEquals(28, Reserve.getAmountOf(Resource.COIN));

        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2,strongbox.getResource(Resource.ROCK));
        assertEquals(26, Reserve.getAmountOf(Resource.ROCK));

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.ROCK));
        assertEquals(28, Reserve.getAmountOf(Resource.ROCK));

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.ROCK));
        assertEquals(28, Reserve.getAmountOf(Resource.ROCK));

        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SHIELD));
        assertEquals(28, Reserve.getAmountOf(Resource.SHIELD));

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SHIELD));
        assertEquals(28, Reserve.getAmountOf(Resource.SHIELD));

        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4,strongbox.getResource(Resource.SERVANT));
        assertEquals(24, Reserve.getAmountOf(Resource.SERVANT));

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SERVANT));
        assertEquals(28, Reserve.getAmountOf(Resource.SERVANT));

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SERVANT));
        assertEquals(28, Reserve.getAmountOf(Resource.SERVANT));
    }

    /**
     * Check of the correct return of the method resourceScore
     */
    @Test
    @DisplayName("resourceScore Test")
    public void resourceScoreTest(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        assertEquals(0, strongbox.resourceScore());

        try {
            strongbox.addResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1, strongbox.resourceScore());

        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2, strongbox.resourceScore());

        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(5, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, strongbox.resourceScore());

        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        try {
            strongbox.addResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(7, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(6, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(5, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0, strongbox.resourceScore());
    }

}
