package it.polimi.ingsw.model;

/**
 * this class represents the white marble
 */
public class WhiteMarble extends Marble{



    public void giveResource(Player player) throws WhiteMarbleException {
        try{
            player.addToBuffer(player.whiteExchange());
        } catch (BlockedWhiteMarbleEffectException ignored) {}

    }

}
