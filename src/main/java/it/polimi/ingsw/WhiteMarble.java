package it.polimi.ingsw;
/**
 * class for whiteMarble, only 4 objects instantiated in Market
 */
public class WhiteMarble extends Marble{


    public void giveResource(Player player) {
        try{
            player.addToBuffer(player.whiteExchange());
        } catch (BlockedWhiteMarbleEffectException | UnavailableResourceException ignored) {}

    }

}
