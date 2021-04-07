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


    /**
     * @param resource
     * method which add resource to buffer from market
     */
    public void addToBuffer(Resource resource){
        gameBoardOfPlayer.addToBuffer(resource);
    }


    /**
     * @throws CallForCouncilException from faithPath, match is finished
     */
    public void faithMove() throws CallForCouncilException {
        gameBoardOfPlayer.faithMove();
    }


    /**
     * from gameboard
     * @return gameBoardOfPlayer
     */
    public Gameboard getGameBoardOfPlayer() {
        return gameBoardOfPlayer;
    }

    /**
     * from faithPath
     * @return gameBoardOfPlayer.getIndicator()
     */
    public int getIndicator(){
        return gameBoardOfPlayer.getIndicator();
    }


    /**
     * method which receives card from deckcardprodcution and pass it to Gameboard
     * @param productioncard
     * @param choosenColumns
     * @throws LevelException fromm gameboard, player can't take this level of card, or place it in choosencolumns
     */
    public void GivePlayerCard(ProductionCard productioncard, int choosenColumns) throws LevelException {

        gameBoardOfPlayer.addCardToDevelopmentBoard(productioncard,choosenColumns);
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }



    /**
     * @return nickName of player
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * set nickname to player
     * @param nickName
     */
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
     * methods null, specified only in child classes
     *
     */
    public void initResource(){}
    public void initResource(Resource resource) throws UnavailableResourceException, CallForCouncilException {}
    public void initResource(Resource resourceOne,Resource resourceTwo) throws UnavailableResourceException, CallForCouncilException {}

    public void EndOfTurn(){

    }


    /**
     * method which returns leader card at index position of personalLeaderCard, just for test
     * @param index
     * @return personalLeaderCard.get(index)
     */
    public LeaderCard getCardFromPersonalLeaderCard(int index){

        return  personalLeaderCard.get(index);
    }

}