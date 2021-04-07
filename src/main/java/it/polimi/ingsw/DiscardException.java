package it.polimi.ingsw;

public class DiscardException extends Exception {
    private Player player;


    public DiscardException(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    /*public void setPlayer(Player player) {
        this.player = player;
    }*/
}
