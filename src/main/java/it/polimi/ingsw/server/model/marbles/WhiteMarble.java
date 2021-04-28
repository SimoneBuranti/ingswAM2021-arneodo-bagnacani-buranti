package it.polimi.ingsw.server.model.marbles;

import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.exceptions.WhiteMarbleException;
import it.polimi.ingsw.server.model.exceptions.BlockedWhiteMarbleEffectException;

/**
 * this class represents the white marble
 */
public class WhiteMarble extends Marble {

    /**
     * colour marble
     */
    private String colour= "white";


    @Override
    public String getColour() {
        return colour;
    }
    /**
     * this method adds the resource specified by the whiteExchange method to the player's buffer
     * if the player has activated a white marble leader card, otherwise it does nothing.
     * Additionally, the method spreads the WhiteMarbleException.
     * @param player : the one that has bought from the market
     * @throws WhiteMarbleException : the exception which is thrown when a player has activated two white marble-type leader cards
     */
    public void giveResource(Player player) throws WhiteMarbleException {
        try{
            player.addToBuffer(player.whiteExchange());
        } catch (BlockedWhiteMarbleEffectException ignored) {}

    }

}
