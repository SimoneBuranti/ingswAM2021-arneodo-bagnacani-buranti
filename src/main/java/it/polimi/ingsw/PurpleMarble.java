package it.polimi.ingsw;

public class PurpleMarble extends Marble{


    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.SERVANT);


    }
}
