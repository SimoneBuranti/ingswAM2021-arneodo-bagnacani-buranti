package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class HowManyPlayersCommand extends Command{

    /**
     * Number of players attribute.
     */
    private int nOfPlayers;

    /**
     * Class constructor.
     * @param nOfPlayers
     */
    public HowManyPlayersCommand(int nOfPlayers) {
        this.nOfPlayers = nOfPlayers;
    }

    /**
     * Number of players getter.
     * @return
     */
    public int getnOfPlayers() {
        return nOfPlayers;
    }

    /**
     * This commandOn method return a NumberPlayerMessage.
     * @return
     */
    @Override
    public Message commandOn(){

        if(nOfPlayers > 1)
            System.out.println("Please wait the missing players to start the game ...");

        return new NumberPlayerMessage(this.nOfPlayers);
    }
}
