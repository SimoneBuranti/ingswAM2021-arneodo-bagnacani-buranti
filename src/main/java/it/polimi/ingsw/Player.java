package it.polimi.ingsw;

public class Player {
    private boolean connected;
    private Gameboard gameBoardOfPlayer ;
    private String nickName;
    private int score;


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

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    /**
     *method for return score
     *
     */
    public int getScore(){
        return score;
    }




    /**
     * methods null for the first player
     *
     */
    public void initResource(){}
    public void initResource(Resource resource) throws UnavailableResourceException, CallForCouncilException {}
    public void initResource(Resource resourceOne,Resource resourceTwo) throws UnavailableResourceException, CallForCouncilException {}

    public void EndOfTurn(){

    }


}