package it.polimi.ingsw;

import java.util.ArrayList;

public class Player {
    private boolean connected;
    private GameboardInterface gameBoardOfPlayer ;
    private String nickName;
    private int score;
    private ArrayList<LeaderCard> personalLeaderCard;
    private ArrayList<Resource> buffer;
    private Game game;




    public Player(String nickName){
        gameBoardOfPlayer = new Gameboard();
        personalLeaderCard=new ArrayList<LeaderCard>(4);
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        setNickName(nickName);

    };

    public Player(Game game){
        this.game = game;
        gameBoardOfPlayer = new Gameboard();
        personalLeaderCard=new ArrayList<LeaderCard>(4);
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        setNickName(nickName);

    };


    /**
     * method which  add the chosen to leaderCards in gameboard
     * @param firstIndex
     * @param secondIndex
     */
    public void discardLeaderCard(int firstIndex, int secondIndex){
        for (int i=0; i<4;i++) {
            if (i == firstIndex || i == secondIndex)
                gameBoardOfPlayer.addLeaderCardToGameboard(personalLeaderCard.get(i));
        }}


    /**
     * @throws CallForCouncilException from faithPath, match is finished
     */
    public void faithMove() throws CallForCouncilException, LastSpaceReachedException {
        gameBoardOfPlayer.faithMove();
    }


    /**
     * from gameboard
     * @return gameBoardOfPlayer
     */
    public GameboardInterface getGameBoardOfPlayer() {
        return gameBoardOfPlayer;
    }

    /**
     * from faithPath
     * @return gameBoardOfPlayer.getIndicator()
     */
    public int getIndicator(){
        return gameBoardOfPlayer.getIndicator();
    }


    public void addResourceToStorage(Resource resource){
        try {
            gameBoardOfPlayer.addToStorage(resource);
        } catch (UnavailableResourceException ignored) {}
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
     * method for testing
     * @return return personalLeaderCard.size()
     */
    public int personalLeaderCardsize(){
         return personalLeaderCard.size();
    }




    /**
     * methods null, specified only in child classes
     *
     */
    public void initResource(){}
    public void initResource(Resource resource) throws UnavailableResourceException, CallForCouncilException, LastSpaceReachedException {}
    public void initResource(Resource resourceOne,Resource resourceTwo) throws UnavailableResourceException, CallForCouncilException, LastSpaceReachedException {}

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

    public void buyProductionCard(DeckProductionCard deck, int choosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        gameBoardOfPlayer.buyProductionCard(deck,choosenColumn);
    }

    public void setPapal(){
        gameBoardOfPlayer.setPapal();
    }

    public void discardResource(Resource resource){
        Reserve.addResource(resource);
        game.moveEveryoneExcept(this);
    }


    public void takeFromMarket() {
        Resource resource;

        try {
            gameBoardOfPlayer.takeFromMarket((ArrayList<Resource>) buffer.clone());
            buffer = new ArrayList<>();
        } catch (NotEnoughSpeceInStorageException e) {
            //discardResource(buffer.remove(resource));
            takeFromMarket();
        }
    }

    public void productionOn(int choosenColumn) throws ImpossibleProductionException, EmptyColumnException {
        gameBoardOfPlayer.productionOn(choosenColumn);
    }

    public void baseProductionOn(Resource i1,Resource i2,Resource o) throws ImpossibleProductionException {
        gameBoardOfPlayer.baseProductionOn(i1,i2,o);
    }

    public int playerScore(){
        return gameBoardOfPlayer.score();
    }

    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException, UnavailableResourceException {
        return gameBoardOfPlayer.whiteExchange();
    }


    public void addToBuffer(Resource resource){
        buffer.add(resource);
    }

    /*
     * method which receives card from deckcardprodcution and pass it to Gameboard
     * @param productioncard
     * @param choosenColumns
     * @throws LevelException fromm gameboard, player can't take this level of card, or place it in choosencolumns

    public void GivePlayerCard(ProductionCard productioncard, int choosenColumns) throws LevelException {
        gameBoardOfPlayer.addCardToDevelopmentBoard(productioncard,choosenColumns);
    }*/

    /*
      @param resource
      method which add resource to buffer from market

    public void addToBuffer(Resource resource){
        gameBoardOfPlayer.addToBuffer(resource);
    }*/


}