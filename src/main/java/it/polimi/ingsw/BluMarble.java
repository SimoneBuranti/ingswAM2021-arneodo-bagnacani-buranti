package it.polimi.ingsw;

public class BluMarble extends Marble{

    public void giveResource(Player player) {
        try {
            Reserve.getResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }
        player.addToBuffer(Resource.SHIELD);


        }
    }

