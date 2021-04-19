package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Player {
    private boolean connected;
    private final GameBoardInterface gameBoardOfPlayer ;
    private final String nickName;
    private int score;
    private ArrayList<LeaderCard> personalLeaderCard;
    private ArrayList<Resource> buffer;
    private Game game;




    public Player(String nickName, Game game){
        buffer= new ArrayList<>();
        gameBoardOfPlayer = new GameBoard();
        personalLeaderCard=new ArrayList<>(4);
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        personalLeaderCard.add(DeckLeaderCard.arrangeDeckLeaderCards());
        this.nickName = nickName;
        this.game = game;
    }


    /**
     * method which  add the chosen to leaderCards in gameBoard
     * @param firstIndex
     * @param secondIndex
     */
    public void saveLeaderCard(int firstIndex, int secondIndex){
        for (int i=0; i<4;i++) {
            if (i == firstIndex || i == secondIndex)
                gameBoardOfPlayer.addLeaderCardToGameBoard(personalLeaderCard.get(i));
        }}


    /**
     * @throws CallForCouncilException from faithPath, match is finished
     */
    public void faithMove() throws CallForCouncilException, LastSpaceReachedException {
        gameBoardOfPlayer.faithMove();
    }


    /**
     * from gameBoard
     * @return gameBoardOfPlayer
     */
    public GameBoardInterface getGameBoardOfPlayer() {
        return gameBoardOfPlayer;
    }

    /**
     * from faithPath
     * @return gameBoardOfPlayer.getIndicator()
     */
    public int getIndicator(){
        return gameBoardOfPlayer.getIndicator();
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
    public int personalLeaderCardSize(){
         return personalLeaderCard.size();
    }




    /**
     * methods null, specified only in child classes
     *
     */
    public void initResource(Resource resource) throws CallForCouncilException, LastSpaceReachedException {}
    public void initResource(Resource resourceOne,Resource resourceTwo) throws CallForCouncilException, LastSpaceReachedException {}

    //public void EndOfTurn(){}


    /**
     * method which returns leader card at index position of personalLeaderCard, just for test
     * @param index
     * @return personalLeaderCard.get(index)
     */
    public LeaderCard getCardFromPersonalLeaderCard(int index){

        return  personalLeaderCard.get(index);
    }


    /**
     * this method need  when the player discard a leaderCard, and give player one faithPoint
     * @param index
     */
   public void discardLeaderCard(int index) throws CallForCouncilException, LastSpaceReachedException, LeaderCardsGameBoardEmptyException {
        if(getGameBoardOfPlayer().leaderCardsSize()==1){
            getGameBoardOfPlayer().removeLeaderCardToGameBoard(0);
            getGameBoardOfPlayer().faithMove();}

        else if (getGameBoardOfPlayer().leaderCardsSize()==2)
        {getGameBoardOfPlayer().removeLeaderCardToGameBoard(index);
        getGameBoardOfPlayer().faithMove();
        }
        else
           throw new LeaderCardsGameBoardEmptyException();

   }



   public void activationLeaderCard(int index) throws LeaderCardsGameBoardEmptyException {
       if(getGameBoardOfPlayer().leaderCardsSize() > 0)
           getGameBoardOfPlayer().activationLeaderCard(index);
       else
           throw new LeaderCardsGameBoardEmptyException();
   }

    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        gameBoardOfPlayer.buyProductionCard(deck,chosenColumn);
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
            gameBoardOfPlayer.takeFromMarket((ArrayList<Resource>)buffer.clone());
            buffer = new ArrayList<>();
        } catch (NotEnoughSpaceInStorageException e) {
            //discardResource(buffer.remove(resource));
            
        }
    }

    public void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException, CallForCouncilException, LastSpaceReachedException {
        gameBoardOfPlayer.productionOn(chosenColumn);
    }

    public void baseProductionOn(Resource i1,Resource i2,Resource o) throws ImpossibleProductionException {
        gameBoardOfPlayer.baseProductionOn(i1,i2,o);
    }

    public void extraProductionOn(Resource resource) throws LastSpaceReachedException, CallForCouncilException, ImpossibleProductionException {
       gameBoardOfPlayer.extraProductionOn(resource);
    }

    public void anotherExtraProductionOn(Resource resource) throws LastSpaceReachedException, CallForCouncilException, ImpossibleProductionException {
       gameBoardOfPlayer.anotherExtraProductionOn(resource);
    }

    public void endOfProduction() throws CallForCouncilException, LastSpaceReachedException {
       gameBoardOfPlayer.endOfProduction();
    }

    public int playerScore(){
        return gameBoardOfPlayer.score();
    }

    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException, WhiteMarbleException {
        return gameBoardOfPlayer.whiteExchange();
    }


    public void addToBuffer(Resource resource){
            buffer.add(resource);
    }


}