package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NumberPlayerMessage;

public class HowManyPlayersCommand extends Command{

    private int nOfPlayers;

    public HowManyPlayersCommand(int nOfPlayers) {
        this.nOfPlayers = nOfPlayers;
    }

    public int getnOfPlayers() {
        return nOfPlayers;
    }

    @Override
    public Message commandOn(){
        return new NumberPlayerMessage(this.nOfPlayers);
    }
}
