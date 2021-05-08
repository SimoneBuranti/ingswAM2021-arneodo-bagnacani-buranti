package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCard;

import java.util.*;

/**
 * This class represents a player's personal board and can be decorated with any {@link GameBoardDecorator}
 */
public class GameBoard extends GameBoardInterface{

    /**
     * developmentBoard references the production card set of the player
     */
    private final ProductionCard[][] developmentBoard;

    /**
     * leaderCards references the ArrayList containing the player's set of leader cards to activate or discard
     */
    private final ArrayList<LeaderCard> leaderCards = new ArrayList<>();

    /**
     * leaderCardsActivated references the ArrayList containing the activated leader card set of the player
     */
    private final ArrayList<LeaderCard> leaderCardsActivated = new ArrayList<>();

    /**
     * faithPath is the private reference to the player's faith path
     */
    private final FaithPath faithPathOfGameBoard;

    /**
     * storageOfGameBoard is the private reference to the player's storage
     */
    private Storage storageOfGameBoard;

    /**
     * strongboxOfGameBoard is the private reference to the player's strongbox
     */
    private final Strongbox strongboxOfGameBoard;

    /**
     * productionBuffer contains all the resources produced by production activations
     */
    private ArrayList<Resource> productionBuffer;

    /**
     * whiteMarbleCardActivated specifies whether or not a white marble-type leader card has been activated
     */
    private int whiteMarbleCardActivated = 0;
    /**
     * productionCardActivated specifies whether or not a production-type leader card has been activated
     */
    private int productionCardActivated = 0;
    /**
     * reductionCardActivated specifies whether or not a reduction-type leader card has been activated
     */
    private int reductionCardActivated = 0;
    /**
     * storageCardActivated specifies whether or not a storage-type leader card has been activated
     */
    private int storageCardActivated = 0;

    /**
     * The standard initialising constructor
     */
    public GameBoard() {
        developmentBoard = new ProductionCard[3][3];
        faithPathOfGameBoard = new FaithPath();
        strongboxOfGameBoard = new Strongbox();
        storageOfGameBoard = new Storage();
        this.productionBuffer = new ArrayList<>();

    }


    /**
     * this method changes the board storage to StorageExtraFirst if the first storage-type leader card has been activated,
     * to StorageExtraSecond if the second storage-type leader card has been activated
     * @param resource : the resource type of the first or second extra storage
     */
    @Override
    public void setStorageExtra(Resource resource){
        Map<Resource, Integer> map = storageOfGameBoard.getStorageResource();
        if(getStorageCardActivated() == 0)
            this.storageOfGameBoard = new StorageExtraFirst(resource, map);
        else{
            Resource firstResource = storageOfGameBoard.getFirstResourceType();
            int numFirst = storageOfGameBoard.getNumExtraFirstAvailable();
            this.storageOfGameBoard = new StorageExtraSecond(firstResource, resource, map, numFirst);
        }
    }

    /**
     * This method adds all the resources contained in the production buffer in the gameBoard's strongbox
     */
    public void endOfProduction() {

        for(Resource r : productionBuffer){
            strongboxOfGameBoard.addResource(r);
        }
        productionBuffer = new ArrayList<>();
    }


    /**
     * This method returns the player's faithPath position
     * @return int : the current position of player's faith indicator
     */
    public int getIndicator() {
        return faithPathOfGameBoard.getIndicator();
    }

    /**
     * This method represents a higher level interface method for faithPath move of the related player's faithPath
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void  faithMove () throws CallForCouncilException, LastSpaceReachedException {
        faithPathOfGameBoard.move();
    }


    /**
     * This method represents a higher level interface method for setPapal of the related player's faithPath
     */
    public void setPapal(){
        faithPathOfGameBoard.setPapal();
    }

    /**
     * This method represents the white marble upgrade due to the respective leader card activation. When it is not
     * upgraded yet a null reaction is needed. The method throws the BlockedWhiteMarbleEffectException which will be
     * handled by the caller method.
     * @return Resource : the type of resource to take with the white marble
     * @throws BlockedWhiteMarbleEffectException : the exception which is thrown when there are no white marble-type leader cards activated
     */
    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException{
        throw new BlockedWhiteMarbleEffectException();
    }

    /**
     * This method represents the first extra production upgrade due to the respective leader card activation.
     * When it is not upgraded yet a null reaction is needed. The method throws the ImpossibleProductionException
     * which will be handled by the caller method.
     * @throws ImpossibleProductionException : the exception which is thrown when there are no production-type leader cards activated
     */
    public void extraProductionOn(Resource resource) throws ImpossibleProductionException {
        throw new ImpossibleProductionException();
    }


    /**
     * This method represents the second extra production upgrade of the respective leader card activation.
     * When it is not upgraded yet a null reaction is needed.  The method throws the ImpossibleProductionException
     * which will be handled by the caller method.
     * @throws ImpossibleProductionException : the exception which is thrown when there are no two production-type leader cards activated
     */
    public void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException {
        throw new ImpossibleProductionException();
    }

    /**
     * This method returns the first available position in the chosen column received as a parameter if present,
     *  otherwise it throws the FullColumnException
     * @param chosenColumn : the column to check
     * @return int : the first available position in the chosen column
     * @throws FullColumnException : the exception which is thrown when all the rows of the chosen column are occupied
     */
    public int firstRowFree(int chosenColumn) throws FullColumnException {
        int i;
        for(i=0; i<3; i++)
            if(developmentBoard[i][chosenColumn]==null)
                return i;
        throw new FullColumnException();
    }

    /**
     * This method returns the top card position in the chosen column received as a parameter
     * @param chosenColumn : the column to check
     * @return int : the top card position in the chosen column
     * @throws EmptyColumnException : the exception which is thrown when there are no cards in the chosen column
     */
    public int lastRowOccupied(int chosenColumn) throws EmptyColumnException{
        int i=0;

        if(developmentBoard[i++][chosenColumn]==null)
            throw new EmptyColumnException();
        for(; i<3; i++)
            if(developmentBoard[i][chosenColumn]==null)
                return i-1;

        return 2;
    }

    /**
     * This method receives as parameters the chosen deck and the chosen column and sets the top production card
     * of the chosen deck in the first available position in the chosen column if present;
     * it throws the FullColumnException if the chosen column is full or the EmptyException if the chosen deck is empty
     * @param deck : the deck from which to draw the card
     * @param chosenColumn : the column in which to put the card
     * @throws EmptyException : the exception which is thrown when there are no cards in the deck
     * @throws FullColumnException : the exception which is thrown when all the rows of the chosen column are occupied
     */
    public void setNewProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException {
        developmentBoard[firstRowFree(chosenColumn)][chosenColumn]= deck.pickUpFirstCard();
    }

    /**
     * This method pays the resources needed for any action after a check on the available resources has been done
     * @param cost : the resources to be paid
     */
    public void payResources(ArrayList<Resource> cost) {
        strongboxOfGameBoard.payResources(storageOfGameBoard.payResources(cost));
    }

    /**
     * This method returns an ArrayList of resources containing the resources of both the storage and the strongbox
     * @return ArrayList<Resource> : collection of all the resources contained in the storage and in the strongbox
     */
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> overallResources = new ArrayList<>();
        overallResources.addAll(storageOfGameBoard.availableResources());
        overallResources.addAll(strongboxOfGameBoard.availableResources());
        return overallResources;
    }

    /**
     * This method checks the total amount of production Card in the player's development board and throws a
     * EndGameException if the seventh production card sale has been successfully completed.
     * @throws EndGameException : the exception which is thrown when there are seven card in the player's development board
     */
    public void seventhCardCheck() throws EndGameException {
        int cont=0;

        for (int i = 0 ; i<3; i++){
            for(int j = 0; j<3; j++ ){
                if (developmentBoard[i][j] != null)
                    cont++;
            }
        }
        if (cont == 7)
            throw new EndGameException();
    }

    /**
     * This method receives as parameters a specific production card deck and the column in which the card
     * will be placed. It throws a LevelException if the deck level doesn't match the available position in the column.
     * It throws a NotEnoughResourcesException if the player cannot afford that card. Moreover, it spreads
     * EmptyException,FullColumnException and EndGameException.
     * @param deck : the deck from which to draw the card
     * @param chosenColumn : the column in which to put the card
     * @throws LevelException : the exception which is thrown when the deck level doesn't match the available position in the column
     * @throws NotEnoughResourcesException : the exception which is thrown when the player cannot afford that card
     * @throws EmptyException : the exception which is thrown when there are no cards in the deck
     * @throws FullColumnException : the exception which is thrown when all the rows of the chosen column are occupied
     * @throws EndGameException : the exception which is thrown when there are seven card in the player's development board
     */
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        ArrayList<Resource> availableResources = availableResources();
        ArrayList<Resource> requiredResources = deck.requiredResources();

        if(deck.size() == 0)
            throw new EmptyException();
        if(deck.getLevel()!=firstRowFree(chosenColumn)+1)
            throw new LevelException();

        for(Resource resource : requiredResources)
            if (!availableResources.remove(resource))
                throw new NotEnoughResourcesException();

        payResources(requiredResources);

        setNewProductionCard(deck,chosenColumn);

        seventhCardCheck();
    }


    /**
     * This method returns the int value of the total production card victory points
     * @return int : the total production card victory points
     */
    public int productionScore(){
        int points = 0;

        for(int i=0;i<3;i++){
            for(int j = 0; j<3;j++){
                if (developmentBoard[i][j]!=null){
                    points+= developmentBoard[i][j].getPoints();
                }
            }
        }
        return points;
    }

    /**
     * This method returns the int value of the total leader card victory points
     * @return int : the total leader card victory points
     */
    public int leaderScore(){
        int points = 0;

        for(LeaderCard lc : leaderCardsActivated)
            points+= lc.getPoints();
        return points;
    }

    /**
     * This method returns the int value of the total player's victory points
     * @return int : the total player's victory points
     */
    public int score(){
        return  ((storageOfGameBoard.resourceScore() +
                strongboxOfGameBoard.resourceScore()) /5) +
                faithPathOfGameBoard.faithScore() +
                productionScore() +
                leaderScore();
    }


    /**
     * this method receives a resource ArrayList as a parameter and puts them in the storage if possible;
     * otherwise it throws the NotEnoughSpaceInStorageException.
     * @param newResources : collection of all resources obtained from the market
     * @throws NotEnoughSpaceInStorageException : the exception which is thrown when there is no space for all the resources in the storage
     */
    public void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpaceInStorageException {

        if (!storageOfGameBoard.check((ArrayList<Resource>) newResources.clone())){
            throw new NotEnoughSpaceInStorageException((ArrayList<Resource>) newResources.clone());
        } else {
            for (Resource r : newResources) {
                storageOfGameBoard.addResource(r);
            }
        }
    }


    /**
     * This method represents the gameBoard's function of standard production. It receives three
     * resource types as parameters in order to define the two chosen inputs and the chosen output. In case of lack
     * in available resources an ImpossibleProductionException is thrown.
     * @param i1 : the first resource type of the base production input
     * @param i2 : the second resource type of the base production input
     * @param o : the resource type of the base production output
     * @throws ImpossibleProductionException : the exception which is thrown when not all input resources are not available
     */
    public void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException {
        ArrayList<Resource> available = availableResources();
        ArrayList<Resource> requiredInput = new ArrayList<>();
        ArrayList<Resource> output = new ArrayList<>();
        requiredInput.add(i1);
        requiredInput.add(i2);

        for(Resource r : requiredInput){
            if (!available.remove(r))
                throw new ImpossibleProductionException();
        }

        strongboxOfGameBoard.payResources(storageOfGameBoard.payResources(requiredInput));
        output.add(o);

        addToProductionBuffer(output);
    }

    /**
     * This method receives as parameter the chosen column and produces all the resources according to the
     * production card output. They are put in the production card buffer if the production attempt is correct;
     * otherwise ImpossibleProductionException or EmptyColumnException are thrown.
     * Moreover, it spreads CallForCouncilException and LastSpaceReachedException.
     * @param chosenColumn : the column containing the card whose production the player wants to activate
     * @throws ImpossibleProductionException : the exception which is thrown when not all input resources are not available
     * @throws EmptyColumnException : the exception which is thrown when there are no cards in the deck
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException, CallForCouncilException, LastSpaceReachedException {
        ArrayList<Resource> available = availableResources();
        ArrayList<Resource> requiredInput;
        ArrayList<Resource> output;
        int callForCouncil = 0;
        int lastSpaceReached = 0;

        ProductionCard card = developmentBoard[lastRowOccupied(chosenColumn)][chosenColumn];

        requiredInput = card.getIn();
        output = card.getOut();

        for(Resource r : requiredInput)
            if (!available.remove(r))
                throw new ImpossibleProductionException();

        payResources(requiredInput);

        addToProductionBuffer(output);
        for(int i = 0; i < card.isFaithPoint(); i++) {
            try {
                faithMove();
            } catch (CallForCouncilException e) {
                callForCouncil = 1;
            } catch (LastSpaceReachedException e) {
                lastSpaceReached = 1;
            }
        }

        if(callForCouncil == 1)
            throw new CallForCouncilException();
        else if(lastSpaceReached == 1)
            throw new LastSpaceReachedException();
    }

    /**
     * This method adds produced resources to gameBoard's production buffer
     * @param output : the collection of resources to add to the buffer
     */
    public void addToProductionBuffer(ArrayList<Resource> output){
        productionBuffer.addAll(output);
    }

    /**
     * this method adds leaderCard to GameBoard's folder of LeaderCards
     * @param leaderCard : the card to add to the list
     *
     */
    public void addLeaderCardToGameBoard(LeaderCard leaderCard){
        leaderCards.add(leaderCard);
    }


    /**
     * This method returns the leader card in index position in the leaderCards list
     * @param index : the position of the leader card in the list
     * @return LeaderCard : the leader card to position index in the leaderCards list
     */
    public LeaderCard reportLeaderCardToGameBoard(int index){
        return leaderCards.get(index);
    }


    /**
     * This method removes the leader card in index position from the leaderCards list
     * @param index : the position of the leader card in the list
     */
    public  void removeLeaderCardToGameBoard(int index){
        leaderCards.remove(index);
    }

    /**
     * This method activates the leader card in index position in the leaderCards list and
     * after adding it to the leaderCardsActivated list removes it from the leaderCards list
     * @param index : the position of the leader card in the list
     */
    public GameBoardInterface activationLeaderCard(GameBoardInterface gameBoard,int index) throws RequirementsException {
        GameBoardInterface newGameBoard;
        newGameBoard = leaderCards.get(index).abilityActivation(gameBoard);
        leaderCardsActivated.add(leaderCards.get(index));
        leaderCards.remove(index);

        return newGameBoard;
    }

    /**
     * This method returns the number of cards in the developmentBoard of the color passed as a parameter
     * @param colour : the colour of the production card
     * @return : the number of cards of the colour passed as a parameter
     */
    @Override
    public int colourQuantity(Colour colour){
        int quantity = 0;

        for(int i=0;i<3;i++){
            for(int j = 0; j<3;j++){
                if (developmentBoard[i][j]!=null && developmentBoard[i][j].getColour() == colour){
                    quantity++;
                }
            }
        }

        return quantity;
    }

    /**
     * This method returns the number of cards in developmentBoard of the color and level passed as a parameter
     * @param colour : the colour of the production card
     * @param level : the level of the production card
     * @return int : the number of cards of the colour and level passed as a parameter
     */
    @Override
    public int levelAndColourQuantity(Colour colour, int level){
        int quantity = 0;

        for(int i = 0; i < 3; i++){
            if(developmentBoard[level-1][i]!=null && developmentBoard[level-1][i].getColour() == colour)
                quantity++;
        }

        return quantity;
    }

    /**
     * This method returns the number of resources of the resource type passed as a parameter
     * that the board has in the storage and in the strongbox
     * @param resource : the resource type
     * @return int : the number of resources in the storage and in the strongbox
     */
    @Override
    public int resourceQuantity(Resource resource){
        return storageOfGameBoard.getResource(resource) + strongboxOfGameBoard.getResource(resource);
    }

    /**
     * Getter method for whiteMarbleCardActivated attribute
     * @return int : the value of whiteMarbleCardActivated
     */
    @Override
    public int getWhiteMarbleCardActivated() {
        return whiteMarbleCardActivated;
    }

    /**
     * This method sets whiteMarbleCardActivated attribute to 1 when
     * the first white marble-type leader card has been activated
     */
    @Override
    public void setWhiteMarbleCardActivated() {
        whiteMarbleCardActivated = 1;
    }

    /**
     * Getter method for productionCardActivated attribute
     * @return int : the value of productionCardActivated
     */
    @Override
    public int getProductionCardActivated() {
        return productionCardActivated;
    }

    /**
     * This method sets productionCardActivated attribute to 1 when
     * the first production-type leader card has been activated
     */
    @Override
    public void setProductionCardActivated() {
        productionCardActivated = 1;
    }

    /**
     * Getter method for reductionCardActivated attribute
     * @return int : the value of reductionCardActivated
     */
    @Override
    public int getReductionCardActivated() {
        return reductionCardActivated;
    }

    /**
     * This method sets reductionCardActivated attribute to 1 when
     * the first reduction-type leader card has been activated
     */
    @Override
    public void setReductionCardActivated() {
        reductionCardActivated = 1;
    }

    /**
     * Getter method for storageCardActivated attribute
     * @return int : the value of storageCardActivated
     */
    @Override
    public int getStorageCardActivated() {
        return storageCardActivated;
    }

    /**
     * This method sets storageCardActivated attribute to 1 when
     * the first storage-type leader card has been activated
     */
    @Override
    public void setStorageCardActivated() {
        storageCardActivated = 1;
    }

    /**
     * This method returns the resource type of the first activated leader card
     * When no leader cards have been activated yet a null reaction is needed.
     * @return Resource : the resource type of the first activated leader card
     */
    @Override
    public Resource getResourceTypeFirst() {
        return null;
    }

    /**
     * this method returns the total score of the storage and strongbox
     * @return int : the total score of the storage and strongbox
     */
    public int scoreResource(){
        return  ((storageOfGameBoard.resourceScore() +
                strongboxOfGameBoard.resourceScore()) /5);
    }


    /**
     * Test only method: this method adds a resource to its own storage.
     * @param resource : the resource to add in the strongbox
     */
    public void addToStrongbox(Resource resource) {
        strongboxOfGameBoard.addResource(resource);
    }

    /**
     * Test only method: this method adds a resource to its own storage.
     * @param resource : the resource to add in the storage
     */
    public void addToStorage(Resource resource){
        storageOfGameBoard.addResource(resource);
    }

    /**
     * Test only method: getter method for the total score of the faith path.
     * @return int : the overall faithPath score
     */
    public int faithScore(){
        return faithPathOfGameBoard.faithScore();
    }

    /**
     * Test only method : set a production card in the development board without payment
     */
    public void setProductionCard(ProductionCard card,int chosenColumn){
        int r;

        try {
            r = firstRowFree(chosenColumn);
        } catch (FullColumnException e) {
            return;
        }

        developmentBoard[r][chosenColumn] = card;
    }

    /**
     * Test only method : getter method for the leaderCards list size
     * @return int : the size of the leaderCards list
     */
    public int leaderCardsSize(){
        return leaderCards.size();
    }
}