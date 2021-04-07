package it.polimi.ingsw;
/**
 * class for redMarble, only 1 object instantiated in Market
 */
public class RedMarble extends Marble{
    /**
     * @param player
     *  player FaithIndicator move of one position
     * @throws CallForCouncilException, exception thrown from Faithpath, game is finished
     */
    public void giveResource(Player player) throws CallForCouncilException {
        player.faithMove();
    }
}
