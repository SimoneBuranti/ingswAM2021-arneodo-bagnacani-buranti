package it.polimi.ingsw.model;

import java.util.*;

public class GameBoard implements GameBoardInterface{


    /**
     * developmentBoard references the production card set of the player
     */
    private final ProductionCard[][] developmentBoard;

    /**
     * leaderCards references the ArrayList containing the leader card set of the player
     */
    private final ArrayList<LeaderCard> leaderCards = new ArrayList<>();

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


    private int whiteMarbleCardActivated = 0;
    private int productionCardActivated = 0;
    private int reductionCardActivated = 0;
    private int storageCardActivated = 0;

    /**
     * GameBoard() is the standard initialising constructor
     *
     */
    public GameBoard() {
        developmentBoard = new ProductionCard[3][3];
        faithPathOfGameBoard = new FaithPath();
        strongboxOfGameBoard = new Strongbox();
        storageOfGameBoard = new Storage();
        this.productionBuffer = new ArrayList<>();

    }


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
     * This method add all the resources contained in the production buffer in the gameBoard's strongbox
     */
    public void endOfProduction() {

        for(Resource r : productionBuffer){
            strongboxOfGameBoard.addResource(r);
        }
        productionBuffer = new ArrayList<>();
    }


    /**
     * This method returns the player's faithPath position
     * @return int
     */
    public int getIndicator() {
        return faithPathOfGameBoard.getIndicator();
    }

    /**
     * This method represents a higher level interface method for faithPath move of the related player's faithPath
     * @throws CallForCouncilException
     * @throws LastSpaceReachedException
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
     * @return
     * @throws BlockedWhiteMarbleEffectException
     */
    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException, WhiteMarbleException{
        throw new BlockedWhiteMarbleEffectException();
    }

    /**
     * This method represents the first extra production upgrade due to the respective leader card activation. When it is not
     * upgraded yet a null reaction is needed. The method throws the BlockedWhiteMarbleEffectException which will be
     * handled by the caller method.
     */
    public void extraProductionOn(Resource resource){}


    /**
     * This method represents the second extra production upgrade of the respective leader card. When it is not upgraded yet
     * a null reaction is needed. The method throws the BlockedWhiteMarbleEffectException which will be handled by
     * the caller method.
     */
    public void anotherExtraProductionOn(Resource resource){}

    /**
     * Test only method: this method adds a resource to its own storage.
     * @param resource
     */
    public void addToStrongbox(Resource resource) {
        strongboxOfGameBoard.addResource(resource);
    }

    /**
     * Test only method: this method adds a resource to its own storage.
     * @param resource
     */
    public void addToStorage(Resource resource){
        storageOfGameBoard.addResource(resource);
    }

    /**
     * firstRowFree method return the first available position in the chosen column received as a parameter
     * if present; it throws the FullColumnException otherwise
     * @param chosenColumn
     * @return int
     * @throws FullColumnException
     */
    public int firstRowFree(int chosenColumn) throws FullColumnException {
        int i;
        for(i=0; i<3; i++)
            if(developmentBoard[i][chosenColumn]==null)
                return i;
        throw new FullColumnException();
    }

    /**
     * lastRowOccupied method return the top card position in the chosen column received as a parameter
     * @param chosenColumn
     * @return int
     * @throws EmptyColumnException
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
     * setNewProductionCard method receives as parameters the chosen deck and the chosen column and sets the
     * related production card in the firs available position if present; it throws the FullColumnException in the
     * chosen column is full or the Empty exception if the chosen deck is empty
     * @param deck
     * @param chosenColumn
     * @throws EmptyException
     * @throws FullColumnException
     */
    public void setNewProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException {
        developmentBoard[firstRowFree(chosenColumn)][chosenColumn]= deck.pickUpFirstCard();
    }

    /**
     * This method pays the resources needed for any action after a check on the available resources has been done
     * @param cost
     */
    public void payResources(ArrayList<Resource> cost) {
        strongboxOfGameBoard.payResources(storageOfGameBoard.payResources(cost));
    }

    /**
     * this method returns an ArrayList of resources containing the resources of both the storage and the strongbox
     * @return ArrayList
     */
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> overallResources = new ArrayList<>();
        overallResources.addAll(storageOfGameBoard.availableResources());
        overallResources.addAll(strongboxOfGameBoard.availableResources());
        return overallResources;
    }

    /**
     * This method check the total amount of production Card in the player's development board and throws a
     * EndGameException if the seventh production card sale has been successfully completed.
     * @throws EndGameException
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
     * buyProductionCard method receives as parameters a specific production card deck and the column in which the card
     * will be placed. It throws a LevelException if the deck level doesn't match the available position in the column.
     * It throws a NotEnoughResourcesException if the player cannot afford that card. Moreover, it spreads
     * EmptyException and FullColumnException.
     * @param deck
     * @param chosenColumn
     * @throws LevelException
     * @throws NotEnoughResourcesException
     * @throws EmptyException
     * @throws FullColumnException
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
     * This method return the int value of the total production card victory points
     * @return int
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
     * This method return the int value of the total leader card victory points
     * @return int
     */
    public int leaderScore(){
        int points = 0;

        for(LeaderCard lc : leaderCardsActivated)
            points+= lc.getPoints();
        return points;
    }

    /**
     * This method return the int value of the total player's victory points
     * @return int
     */
    public int score(){
        return  ((storageOfGameBoard.resourceScore() +
                strongboxOfGameBoard.resourceScore()) /5) +
                faithPathOfGameBoard.faithScore() +
                productionScore() +
                leaderScore();
    }


    /**
     * takeFromMarket() method receives a resource ArrayList as a parameter and puts them in the storage if possible; it
     * throws the NotEnoughSpaceInStorageException otherwise.
     * @param newResources
     * @throws NotEnoughSpaceInStorageException
     */
    public void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpaceInStorageException {

        if (!storageOfGameBoard.check((ArrayList<Resource>) newResources.clone())){
            throw new NotEnoughSpaceInStorageException();
        } else {
            for (Resource r : newResources) {
                storageOfGameBoard.addResource(r);
            }
        }
    }


    /**
     * baseProductionOn() method represents the gameBoard's function of standard production. It receives three
     * resource types as parameters in order to define the two chosen inputs and the chosen output. In case of lack
     * in available resources an ImpossibleProductionException is thrown.
     * @param i1
     * @param i2
     * @param o
     * @throws ImpossibleProductionException
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
     * productionOn method receives as parameter the chosen column and produces all the resources according to the
     * production card output. They are put in the production card buffer if the production attempt is correct;
     * ImpossibleProductionException or EmptyColumnException are thrown otherwise.
     * @param chosenColumn
     * @throws ImpossibleProductionException
     * @throws EmptyColumnException
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
     * This method add produced resources to gameBoard's production buffer
     */
    public void addToProductionBuffer(ArrayList<Resource> output){
        productionBuffer.addAll(output);
    }


    /**
     * Test only method : set a production card in the development board without payment
     */
    public void setProductionCard(ProductionCard card,int chosenColumn){
        int r;

        try {
            r = firstRowFree(chosenColumn);
        } catch (FullColumnException e) {
            //e.printStackTrace();
            return;
        }

        developmentBoard[r][chosenColumn] = card;
    }


    /**
     * this method add LeaderCard to GameBoard's folder of LeaderCards
     * @param leaderCard
     *
     */
    public void addLeaderCardToGameBoard(LeaderCard leaderCard){
        leaderCards.add(leaderCard);
    }


    /**
     * method only for testing
     * @return leaderCards.size()
     */
    public int leaderCardsSize(){
        return leaderCards.size();

    }


    /**
     * @param index
     * @return leaderCards.get(index)
     */
    public LeaderCard reportLeaderCardToGameBoard(int index){
        return leaderCards.get(index);
    }


    /**
     * this method need  when the player discard a leaderCard
     * @param index
     */
    public  void removeLeaderCardToGameBoard(int index){
        leaderCards.remove(index);
    }

    public void activationLeaderCard(int index){
        if(leaderCards.get(index).abilityActivation(this)){
            leaderCardsActivated.add(leaderCards.get(index));
            leaderCards.remove(index);
        }

    }

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
    @Override
    public int levelAndColourQuantity(Colour colour, int level){
        int quantity = 0;

        for(int i = 0; i < 3; i++){
            if(developmentBoard[level-1][i]!=null && developmentBoard[level-1][i].getColour() == colour)
                quantity++;
        }

        return quantity;
    }

    @Override
    public int resourceQuantity(Resource resource){
        return storageOfGameBoard.getResource(resource) + strongboxOfGameBoard.getResource(resource);
    }

    @Override
    public int getWhiteMarbleCardActivated() {
        return whiteMarbleCardActivated;
    }
    @Override
    public void setWhiteMarbleCardActivated() {
        whiteMarbleCardActivated = 1;
    }
    @Override
    public int getProductionCardActivated() {
        return productionCardActivated;
    }
    @Override
    public void setProductionCardActivated() {
        productionCardActivated = 1;
    }
    @Override
    public int getReductionCardActivated() {
        return reductionCardActivated;
    }
    @Override
    public void setReductionCardActivated() {
        reductionCardActivated = 1;
    }

    @Override
    public int getStorageCardActivated() {
        return storageCardActivated;
    }
    @Override
    public void setStorageCardActivated() {
        storageCardActivated = 1;
    }

    @Override
    public Resource getResourceTypeFirst() {
        return null;
    }


    public int scoreResource(){
        return  (int)((storageOfGameBoard.resourceScore() +
                strongboxOfGameBoard.resourceScore()) /5);
    }
}