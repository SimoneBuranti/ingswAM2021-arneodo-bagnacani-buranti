package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.UnavailableResourceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * test class about Reserve
 */
class ReserveTest {


    /**
     * Correct initialisation values check
     */
    @Test
    @DisplayName("Constructor Test")
    public void constructorTest() {
        new Reserve();

        assertEquals(Reserve.getAmountOf(Resource.COIN),100);
        assertEquals(Reserve.getAmountOf(Resource.ROCK),100);
        assertEquals(Reserve.getAmountOf(Resource.SHIELD),100);
        assertEquals(Reserve.getAmountOf(Resource.SERVANT),100);
    }

    /**
     * Correct add for each resource type check
     */
    @Test
    @DisplayName("addResource Test: simple test")
    public void addResourceTest() {
        new Reserve();

        Reserve.addResource(Resource.COIN);
        Reserve.addResource(Resource.COIN);
        Reserve.addResource(Resource.COIN);
        assertEquals(Reserve.getAmountOf(Resource.COIN),103);

        Reserve.addResource(Resource.ROCK);
        Reserve.addResource(Resource.ROCK);
        assertEquals(Reserve.getAmountOf(Resource.ROCK),102);

        Reserve.addResource(Resource.SHIELD);
        assertEquals(Reserve.getAmountOf(Resource.SHIELD),101);

        assertEquals(Reserve.getAmountOf(Resource.SERVANT),100);
    }

    /**
     * Correct get resource behaviour check for each resource type either with
     * available or unavailable resources
     */
    @Test
    @DisplayName("getResourceTest: complete test")
    public void getResource() {
        new Reserve();

        for (int i = 0; i<100 ; i++) {
            try{
                Reserve.getResource(Resource.COIN);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.COIN),99-i);

            try{
                Reserve.getResource(Resource.ROCK);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.ROCK),99-i);

            try{
                Reserve.getResource(Resource.SHIELD);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.SHIELD),99-i);

            try{
                Reserve.getResource(Resource.SERVANT);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.SERVANT),99-i);

        }

        try{
            Reserve.getResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            System.out.println("Unavailable resource " + Resource.COIN + " in reserve pool\n");
        }
        assertEquals(Reserve.getAmountOf(Resource.COIN),0);
        try{
            Reserve.getResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            System.out.println("Unavailable resource " + Resource.COIN + " in reserve pool\n");
        }
        assertEquals(Reserve.getAmountOf(Resource.COIN),0);


        try{
            Reserve.getResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            System.out.println("Unavailable resource " + Resource.ROCK + " in reserve pool\n");
        }
        assertEquals(Reserve.getAmountOf(Resource.ROCK),0);

        try{
            Reserve.getResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            System.out.println("Unavailable resource " + Resource.SHIELD + " in reserve pool\n");
        }
        assertEquals(Reserve.getAmountOf(Resource.SHIELD),0);

        try{
            Reserve.getResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            System.out.println("Unavailable resource " + Resource.SERVANT + " in reserve pool\n");
        }
        assertEquals(Reserve.getAmountOf(Resource.SERVANT),0);


    }


}