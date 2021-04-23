package it.polimi.ingsw.server.model.players;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoard;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.leaderCards.DeckLeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardsGameBoardEmptyException;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCard;

import java.util.ArrayList;

/**
 * this class represents the player of the game
 */
public class Player {
    /**
     * this attribute indicates whether the player is logged in or not
     */
    private boolean connected;
    /**
     * this attribute is the player's personal game board
     */
    private final GameBoardInterface gameBoardOfPlayer ;
    /**
     * this attribute is the player's nickname
     */
    private final String nickName;
    /**
     * this attribute is a collection of the player's starting leader cards
     */
    private final ArrayList<LeaderCard> personalLeaderCard;
    /**
     * this attribute is a collection of the resources taken from the market
     */
    private ArrayList<Resource> buffer;
    /**
     * this attribute is the reference to the game the player is playing
     */
    private final Game game;


    /**
     * constructor that initializes the player's attributes and assigns the player four leader cards from the common deck
     * @param nickName : the nickname chosen by the player
     * @param game : the game the player is playing
     */
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
        this.connected = true;
    }


    /**
     * this method adds the leader cards in position firstIndex and secondIndex in the personalLeaderCard list to the game board
     * @param firstIndex : the position in the list of the first chosen leader card
     * @param secondIndex : the position in the list of the second chosen leader card
     */
    public void saveLeaderCard(int firstIndex, int secondIndex){
        for (int i=0; i<4;i++) {
            if (i == firstIndex || i == secondIndex)
                gameBoardOfPlayer.addLeaderCardToGameBoard(personalLeaderCard.get(i));
        }
    }

    /**
     * this method calls the game board method to move the player's faith indicator in the faith path
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void faithMove() throws CallForCouncilException, LastSpaceReachedException {
        gameBoardOfPlayer.faithMove();
    }

    /**
     * Getter method for the player's game board
     * @return GameBoardInterface : the player's game board
     */
    public GameBoardInterface getGameBoardOfPlayer() {
        return gameBoardOfPlayer;
    }

    /**
     * Getter method for the position of the player's faith indicator that calls the game board method
     * @return int : the position of the player's faith indicator
     */
    public int getIndicator(){
        return gameBoardOfPlayer.getIndicator();
    }

    /**
     * Getter method to know if the player is connected or disconnected
     * @return boolean : the value of the connected attribute
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * this method changes the value of the connected attribute : if it was set to true it sets it to false and vice versa
     */
    public void setConnected() {
        connected = !connected;
    }

    /**
     * Getter method for the nickName of the player
     * @return String : the player nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * method not implemented for resource initialization
     */
    public void initResource(Resource resource) throws CallForCouncilException, LastSpaceReachedException {}
    /**
     * method not implemented for resources initialization
     */
    public void initResource(Resource resourceOne,Resource resourceTwo) throws CallForCouncilException, LastSpaceReachedException {}

    /**
     * this method discards the leader card in index position from the player's board and moves the faith indicator forward
     * one position, if there is no card in that position it throws an LeaderCardsGameBoardEmptyException
     * @param index : the position of the leader card to be discarded
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     * @throws LeaderCardsGameBoardEmptyException : the exception which is thrown when there is no leader card in the position
     *                                              passed as a parameter
     */
   public void discardLeaderCard(int index) throws CallForCouncilException, LastSpaceReachedException, LeaderCardsGameBoardEmptyException {
        if (index < getGameBoardOfPlayer().leaderCardsSize()) {
            getGameBoardOfPlayer().removeLeaderCardToGameBoard(index);
            getGameBoardOfPlayer().faithMove();
        }else
           throw new LeaderCardsGameBoardEmptyException();
   }

    /**
     * this method activates the leader card in index position on the player's board,
     * if there is no card in that position it throws an LeaderCardsGameBoardEmptyException
     * @param index : the position of the leader card to be activated
     * @throws LeaderCardsGameBoardEmptyException : the exception which is thrown when there is no leader card in the position
     *                                              passed as a parameter
     */
   public void activationLeaderCard(int index) throws LeaderCardsGameBoardEmptyException {
       if(index < getGameBoardOfPlayer().leaderCardsSize())
           getGameBoardOfPlayer().activationLeaderCard(index);
       else
           throw new LeaderCardsGameBoardEmptyException();
   }

    /**
     * this method calls the game board method to buy a production card
     * @param deck : the deck from which to draw the card
     * @param chosenColumn : the column in which to put the card
     * @throws LevelException : the exception which is thrown when the deck level doesn't match the available position in the column
     * @throws NotEnoughResourcesException : the exception which is thrown when the player cannot afford that card
     * @throws EmptyException : the exception which is thrown when there are no cards in the deck
     * @throws FullColumnException : the exception which is thrown when all the rows of the chosen column are occupied
     * @throws EndGameException : the exception which is thrown when there are seven card in the player's development board
     */
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        gameBoardOfPlayer.buyProductionCard(deck,chosenColumn);
    }

    /**
     * this method calls the game board method to assign papal cards to the player
     */
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

    /**
     * this method calls the game board method to activate the production of the highest level card
     * that is in the column passed as a parameter
     *  Moreover, it spreads all the exceptions
     * @param chosenColumn : the column containing the card whose production the player wants to activate
     * @throws ImpossibleProductionException : the exception which is thrown when not all input resources are not available
     * @throws EmptyColumnException : the exception which is thrown when there are no cards in the deck
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal
     */
    public void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException, CallForCouncilException, LastSpaceReachedException {
        gameBoardOfPlayer.productionOn(chosenColumn);
    }

    /**
     * this method calls the game board method to activate the base production
     * @param i1 : the first resource type of the base production input
     * @param i2 : the second resource type of the base production input
     * @param o : the resource type of the base production output
     * @throws ImpossibleProductionException : the exception which is thrown when not all input resources are not available
     */
    public void baseProductionOn(Resource i1,Resource i2,Resource o) throws ImpossibleProductionException {
        gameBoardOfPlayer.baseProductionOn(i1,i2,o);
    }

    /**
     * this method calls the game board method to activate the extra production
     * @param resource : the resource type of the extra production output
     * @throws ImpossibleProductionException : the exception which is thrown when the input resource is not available
     *                                         or there are no production-type leader card activated
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void extraProductionOn(Resource resource) throws LastSpaceReachedException, CallForCouncilException, ImpossibleProductionException {
       gameBoardOfPlayer.extraProductionOn(resource);
    }

    /**
     * this method calls the game board method to activate the another extra production
     * @param resource : the resource type of the extra production output
     * @throws ImpossibleProductionException : the exception which is thrown when the input resource is not available
     *                                         or there are no two production-type leader card activated
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void anotherExtraProductionOn(Resource resource) throws LastSpaceReachedException, CallForCouncilException, ImpossibleProductionException {
       gameBoardOfPlayer.anotherExtraProductionOn(resource);
    }

    /**
     * this method calls the game board method to end the action of the productions
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void endOfProduction() throws CallForCouncilException, LastSpaceReachedException {
       gameBoardOfPlayer.endOfProduction();
    }

    /**
     * this method calls the game board method to calculate the final score of the player
     * @return int : the amount of victory points of the player
     */
    public int playerScore(){
        return gameBoardOfPlayer.score();
    }

    /**
     * this method calls the game board method to return the type of resource to be exchanged with the white marble
     * @return Resource : the type of resource to be exchanged with the white marble
     * @throws BlockedWhiteMarbleEffectException : the exception which is thrown when there are no white marble-type leader cards activated
     * @throws WhiteMarbleException : the exception which is thrown when a player has activated two white marble-type leader cards
     */
    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException, WhiteMarbleException {
        return gameBoardOfPlayer.whiteExchange();
    }

    /**
     * this method adds the resource passed as a parameter to the buffer
     * @param resource : the type of resource to add
     */
    public void addToBuffer(Resource resource){
            buffer.add(resource);
    }


    /**
     * Test only method : getter method for the personalLeaderCard list size
     * @return int : personalLeaderCard list size
     */
    public int personalLeaderCardSize(){
        return personalLeaderCard.size();
    }

    /**
     * Test only method : getter method for the leader card in position index in the personalLeaderCard list
     * @param index : the position in the list of the leader card
     * @return LeaderCard : the leader card in position index in the personalLeaderCard list
     */
    public LeaderCard getCardFromPersonalLeaderCard(int index){
        return  personalLeaderCard.get(index);
    }
}