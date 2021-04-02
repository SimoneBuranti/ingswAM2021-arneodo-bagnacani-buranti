package it.polimi.ingsw;

public class Player {
    private Gameboard gameBoardOfPlayer ;
    public Player(){
       gameBoardOfPlayer = new Gameboard();};
    public void addToBuffer(Resource resource){
        gameBoardOfPlayer.addToBuffer(resource);
    }
    public void faithMove(){
        gameBoardOfPlayer.faithMove();
    }
    public int getIndicator(){
        return gameBoardOfPlayer.getIndicator();
    }

}