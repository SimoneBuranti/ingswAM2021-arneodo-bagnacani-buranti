package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class ReserveTest {

    @Test
    @DisplayName("Constructor Test")
    public void constructorTest() {

        assertEquals(Reserve.getAmountOf(Resource.COIN),28);
        assertEquals(Reserve.getAmountOf(Resource.ROCK),28);
        assertEquals(Reserve.getAmountOf(Resource.SHIELD),28);
        assertEquals(Reserve.getAmountOf(Resource.SERVANT),28);
    }

    @Test
    @DisplayName("addResource Test: simple test")
    public void addResourceTest() {

        Reserve.addResource(Resource.COIN);
        Reserve.addResource(Resource.COIN);
        Reserve.addResource(Resource.COIN);
        assertEquals(Reserve.getAmountOf(Resource.COIN),31);

        Reserve.addResource(Resource.ROCK);
        Reserve.addResource(Resource.ROCK);
        assertEquals(Reserve.getAmountOf(Resource.ROCK),30);

        Reserve.addResource(Resource.SHIELD);
        assertEquals(Reserve.getAmountOf(Resource.SHIELD),29);

        assertEquals(Reserve.getAmountOf(Resource.SERVANT),28);
    }

    @Test
    @DisplayName("getResourceTest: complete test")
    public void getResource() {

        for (int i = 0; i<28 ; i++) {
            try{
                Reserve.getResource(Resource.COIN);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.COIN),27-i);

            try{
                Reserve.getResource(Resource.ROCK);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.ROCK),27-i);

            try{
                Reserve.getResource(Resource.SHIELD);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.SHIELD),27-i);

            try{
                Reserve.getResource(Resource.SERVANT);
            } catch (UnavailableResourceException e) {
                e.printStackTrace();
            }
            assertEquals(Reserve.getAmountOf(Resource.SERVANT),27-i);

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