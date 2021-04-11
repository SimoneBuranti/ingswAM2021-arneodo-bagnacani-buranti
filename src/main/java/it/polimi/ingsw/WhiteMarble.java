package it.polimi.ingsw;
/**
 * class for whiteMarble, only 4 objects instantiated in Market
 */
public class WhiteMarble extends Marble{


    public void giveResource(Player player) throws WhiteMarbleException {
        try{
            player.addToBuffer(player.whiteExchange());
        } catch (BlockedWhiteMarbleEffectException ignored) {}

    }

}
