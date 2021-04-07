package it.polimi.ingsw;

import java.util.*;

public class Gameboard implements GameboardInterface{


    /**
     * developmentBoard references the production card set of the player
     */
    private final ProductionCard[][] developmentBoard;

    /**
     * leaderCards references the ArrayList containing the leader card set of the player
     */
    private final ArrayList<LeaderCard> leaderCards = new ArrayList<>();

    /**
     * faithPath is the private reference to the player's faith path
     */
    private final FaithPath faithPathOfGameboard;

    /**
     * storageOfGameboard is the private reference to the player's storage
     */
    private final Storage storageOfGameboard;

    /**
     * strongboxOfGameboard is the private reference to the player's strongbox
     */
    private final Strongbox strongboxOfGameboard;


    /**
     * productionBuffer contains all the resources produced by production activations
     */
    private ArrayList<Resource> productionBuffer;

    /**
     * faithPathBuffer contains all the faithPath's movements produced by production activations
     */
    private int faithPathBuffer;


    /**
     * Gameboard() is the standard initialising constructor
     *
     */
    public Gameboard() {
        developmentBoard = new ProductionCard[3][3];
        faithPathOfGameboard = new FaithPath();
        strongboxOfGameboard = new Strongbox();
        storageOfGameboard = new Storage();
        this.productionBuffer = new ArrayList<>();

    }






    /**
     * This method add all the resources contained in the production buffer in the gameboard's strongbox
     * @throws CallForCouncilException
     * @throws LastSpaceReachedException
     */
    public void endOfProduction() throws CallForCouncilException, LastSpaceReachedException {
        for(Resource r : productionBuffer){
            strongboxOfGameboard.addResource(r);
        }
        productionBuffer = new ArrayList<>();

        for(int i = 0 ; i<faithPathBuffer; i++){
            faithMove();
        }

        faithPathBuffer = 0;
    }


    /**
     * This method returns the player's faithPath position
     * @return int
     */
    public int getIndicator() {
        return faithPathOfGameboard.getIndicator();
    }

    /**
     * This method represents a higher level interface method for faithPath move of the related player's faithPath
     * @throws CallForCouncilException
     * @throws LastSpaceReachedException
     */
    public void  faithMove () throws CallForCouncilException, LastSpaceReachedException {
        faithPathOfGameboard.move();
    }


    /**
     * This method represents a higher level interface method for setPapal of the related player's faithPath
     */
    public void setPapal(){
        faithPathOfGameboard.setPapal();
    }

    /**
     * This method represents the white marble upgrade due to the respective leader card activation. When it is not
     * upgraded yet a null reaction is needed. The method throws the BlockedWhiteMarbleEffectException which will be
     * handled by the caller method.
     * @return
     * @throws BlockedWhiteMarbleEffectException
     */
    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException{
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
     * the caller mehod.
     */
    public void anotherExtraProductionOn(Resource resource){}

    /**
     * Test only method: this method adds a resource to its own storage.
     * @param resource
     */
    public void addToStrongbox(Resource resource) {
        strongboxOfGameboard.addResource(resource);
    }

    /**
     * Test only method: this method adds a resource to its own storage.
     * @param resource
     */
    public void addToStorage(Resource resource) throws UnavailableResourceException {
        storageOfGameboard.addResource(resource);
    }

    /**
     * firstRowFree method return the first available position in the choosen column received as a parameter
     * if present; it throws the FullColumnException otherwise
     * @param choosenColumn
     * @return int
     * @throws FullColumnException
     */
    public int firstRowFree(int choosenColumn) throws FullColumnException {
        int i;
        for(i=0; i<3; i++)
            if(developmentBoard[i][choosenColumn]==null)
                return i;
        throw new FullColumnException();
    }

    /**
     * lastRowOccupied method return the top card position in the choosen column received as a parameter
     * @param choosenColumn
     * @return int
     * @throws EmptyColumnException
     */
    public int lastRowOccupied(int choosenColumn) throws EmptyColumnException{
        int i=0;

        if(developmentBoard[i++][choosenColumn]==null)
            throw new EmptyColumnException();
        for(; i<3; i++)
            if(developmentBoard[i][choosenColumn]==null)
                return i-1;

        return 2;
    }

    /**
     * setnewProductionCard method receives as parameters the choosen deck and the choosen column and sets the
     * related production card in the firs available position if present; it throws the FullColumnException in the
     * choosen column is full or the Empty exception if the choosen deck is empty
     * @param deck
     * @param choosenColumn
     * @throws EmptyException
     * @throws FullColumnException
     */
    public void setNewProductionCard(DeckProductionCard deck, int choosenColumn) throws EmptyException, FullColumnException {
        developmentBoard[firstRowFree(choosenColumn)][choosenColumn]= deck.pickUpFirstCard();
    }

    /**
     * This method pays the resources needed for any action after a check on the available resources has been done
     * @param cost
     */
    public void payResources(ArrayList<Resource> cost) {
        strongboxOfGameboard.payResources(storageOfGameboard.payResources(cost));
    }

    /**
     * this method returns an ArrayList of resources containing the resources of both the storage and the strongbox
     * @return ArrayList
     */
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> overallResources = new ArrayList<>();
        overallResources.addAll(storageOfGameboard.availableResources());
        overallResources.addAll(strongboxOfGameboard.availableResources());
        return overallResources;
    }

    /**
     * This method check the total amount of production Card in the player's development board and throws a
     * EndGameException if the seventh production card sale has been succesfully completed.
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
     * @param choosenColumn
     * @throws LevelException
     * @throws NotEnoughResourcesException
     * @throws EmptyException
     * @throws FullColumnException
     */
    public void buyProductionCard(DeckProductionCard deck, int choosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        ArrayList<Resource> availableResources = availableResources();
        ArrayList<Resource> requiredResources = deck.requiredResources();

        if(deck.getLevel()!=firstRowFree(choosenColumn)+1)
            throw new LevelException();

        for(Resource resource : requiredResources)
            if (!availableResources.remove(resource))
                throw new NotEnoughResourcesException();

        payResources(requiredResources);

        setNewProductionCard(deck,choosenColumn);

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

        for(LeaderCard lc : leaderCards)
            points+= lc.getPoints();
        return points;
    }

    /**
     * This method return the int value of the total player's victory points
     * @return int
     */
    public int score(){
        return  ((storageOfGameboard.resourceScore() +
                strongboxOfGameboard.resourceScore()) /5) +
                faithPathOfGameboard.faithScore() +
                productionScore() +
                leaderScore();
    }


    /**
     * takeFromMarket() method receives a resource ArrayList as a parameter and puts them in the storage if possible; it
     * throws the NotEnoughSpeceInStorageException otherwise.
     * @param newResources
     * @throws NotEnoughSpeceInStorageException
     */
    public void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpeceInStorageException {

        if (!storageOfGameboard.check((ArrayList<Resource>) newResources.clone())){
            throw new NotEnoughSpeceInStorageException();
        } else {
            for (Resource r : newResources) {
                try {
                    storageOfGameboard.addResource(r);
                } catch (UnavailableResourceException ignored) {}
            }
        }
    }


    /**
     * baseProductionOn() method represents the gameboard's function of standard production. It receives three
     * resource types as parameters in order to defin the two choosen inputs and the choosen output. In case of lack
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

        strongboxOfGameboard.payResources(storageOfGameboard.payResources(requiredInput));
        output.add(o);

        addToProductionBuffer(output);
        //addToFaithPathBuffer(1);
    }

    /**
     * productionOn method receives as parameter the choosen column and produces all the resources according to the
     * production card output. They are put in the production card buffer if the production attempt is correct;
     * ImpossibleProductionException or EmptyColumnException are thrown otherwise.
     * @param choosenColumn
     * @throws ImpossibleProductionException
     * @throws EmptyColumnException
     */
    public void productionOn(int choosenColumn) throws ImpossibleProductionException, EmptyColumnException {
        ArrayList<Resource> available = availableResources();
        ArrayList<Resource> requiredInput;
        ArrayList<Resource> output;

        ProductionCard card = developmentBoard[lastRowOccupied(choosenColumn)][choosenColumn];

        requiredInput = card.getIn();
        output = card.getOut();

        for(Resource r : requiredInput)
            if (!available.remove(r))
                throw new ImpossibleProductionException();

        payResources(requiredInput);

        addToProductionBuffer(output);
        addToFaithPathBuffer(card.isFaithPoint());
    }

    /**
     * This method add produced resources to gameboard's production buffer
     */
    public void addToProductionBuffer(ArrayList<Resource> output){
        productionBuffer.addAll(output);
    }

    /**
     * This method add produced resources to gameboard's faith path buffer
     */
    public void addToFaithPathBuffer(int n){
        faithPathBuffer+=n;
    }

    /**
     * Test only method : set a production card in the development board without payment
     */
    public void setProductionCard(ProductionCard card,int choosenColumn){
        int r;

        try {
            r = firstRowFree(choosenColumn);
        } catch (FullColumnException e) {
            e.printStackTrace();
            return;
        }

        developmentBoard[r][choosenColumn] = card;
    }


    /**
     * this method add LeaderCard to Gameboard's folder of LeaderCards
     * @param leaderCard
     *
     */
    public void addLeaderCardToGameboard(LeaderCard leaderCard){
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
    public LeaderCard reportLeaderCardToGameboard(int index){
        return leaderCards.get(index);
    }






}