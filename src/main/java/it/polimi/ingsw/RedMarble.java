package it.polimi.ingsw;

public class RedMarble extends Marble{
    public void giveResource(Player player) throws CallForCouncilException {
        player.faithMove();
    }
}
