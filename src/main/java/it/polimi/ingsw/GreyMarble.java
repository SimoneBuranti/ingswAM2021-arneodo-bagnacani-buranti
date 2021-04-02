package it.polimi.ingsw;

public class GreyMarble extends Marble{


    public void giveResource(Player player)  {

        try {
            Reserve.getResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.ROCK);


    }
}
