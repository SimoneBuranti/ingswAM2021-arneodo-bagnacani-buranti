package it.polimi.ingsw;

public class YellowMarble extends Marble{


    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.COIN);


    }
}
