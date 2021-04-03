package it.polimi.ingsw;

public class Player {

    private Gameboard gameBoardOfPlayer ;


    public Player(){ gameBoardOfPlayer = new Gameboard();};


    public void addToBuffer(Resource resource){
        gameBoardOfPlayer.addToBuffer(resource);
    }
    public void faithMove() throws CallForCouncilException {
        gameBoardOfPlayer.faithMove();
    }

    public Gameboard getGameBoardOfPlayer() {
        return gameBoardOfPlayer;
    }

    public int getIndicator(){
        return gameBoardOfPlayer.getIndicator();
    }

    public void GivePlayerCard(ProductionCard productioncard, int choosenColumns) throws LevelException {

        gameBoardOfPlayer.addCardToDevelopmentBoard(productioncard,choosenColumns);
    }

}