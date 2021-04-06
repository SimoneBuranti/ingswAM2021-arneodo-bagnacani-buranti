package it.polimi.ingsw;

import java.util.ArrayList;

public class Player {
    private boolean connected;
    private Gameboard gameBoardOfPlayer ;
    private String nickName;
    private int score;
    private ArrayList<LeaderCard> personalLeaderCard;




    public Player(String nickName){
        gameBoardOfPlayer = new Gameboard();
        personalLeaderCard=new ArrayList<LeaderCard>(4);
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        setNickName(nickName);

    };


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

    private void setNickName(String nickName) {
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


    public LeaderCard getCardFromPersonalLeaderCard(int index){

        return  personalLeaderCard.get(index);
    }

}