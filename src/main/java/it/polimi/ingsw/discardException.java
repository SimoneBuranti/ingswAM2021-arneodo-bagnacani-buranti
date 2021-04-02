package it.polimi.ingsw;

public class discardException extends Exception {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
