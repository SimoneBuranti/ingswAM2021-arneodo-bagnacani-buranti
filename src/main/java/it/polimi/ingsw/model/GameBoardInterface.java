package it.polimi.ingsw.model;

import java.util.ArrayList;

public interface GameBoardInterface {
    void setStorageExtra(Resource resource);

    void endOfProduction();

    int getIndicator();

    void  faithMove () throws CallForCouncilException, LastSpaceReachedException;

    void setPapal();

    Resource whiteExchange() throws BlockedWhiteMarbleEffectException, WhiteMarbleException;

    void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    void addToStorage(Resource resource);

    void addToStrongbox(Resource resource);

    int firstRowFree(int chosenColumn) throws FullColumnException;

    int lastRowOccupied(int chosenColumn) throws EmptyColumnException;

    void setNewProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException;

    void payResources(ArrayList<Resource> cost);

    ArrayList<Resource> availableResources();

    void seventhCardCheck() throws EndGameException;

    void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException;

    int score();

    int faithScore();

    void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpaceInStorageException;

    void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException;

    void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException, CallForCouncilException, LastSpaceReachedException;

    void addToProductionBuffer(ArrayList<Resource> output);

    void setProductionCard(ProductionCard card,int chosenColumn);

    void addLeaderCardToGameBoard(LeaderCard leaderCard);

   int leaderCardsSize();

   LeaderCard reportLeaderCardToGameBoard(int index);


    void removeLeaderCardToGameBoard(int index);

    void activationLeaderCard(int index);

    int colourQuantity(Colour colour);

    int levelAndColourQuantity(Colour colour, int level);

    int resourceQuantity(Resource resource);

    int getWhiteMarbleCardActivated();

    void setWhiteMarbleCardActivated();

    int getProductionCardActivated();

    void setProductionCardActivated();

    int getReductionCardActivated();

    void setReductionCardActivated();

    int getStorageCardActivated();

    void setStorageCardActivated();

    Resource getResourceTypeFirst();

    public int scoreResource();
}
