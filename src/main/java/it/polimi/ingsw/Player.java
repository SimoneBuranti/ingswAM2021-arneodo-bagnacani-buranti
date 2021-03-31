package it.polimi.ingsw;

public class Player {
    private Gameboard MyGameBoard = new Gameboard();

    public void addToBuffer(Resource resource){
        MyGameBoard.addToBuffer(resource);
    }

}
