package it.polimi.ingsw;

import java.util.ArrayList;

public interface GameBoardInterface {
    void setStorageExtra(Resource resource);

    void endOfProduction() throws CallForCouncilException, LastSpaceReachedException;

    int getIndicator();

    void  faithMove () throws CallForCouncilException, LastSpaceReachedException;

    void setPapal();

    Resource whiteExchange() throws BlockedWhiteMarbleEffectException, UnavailableResourceException, WhiteMarbleException;

    void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    void addToStorage(Resource resource) throws UnavailableResourceException;

    void addToStrongbox(Resource resource);

    int firstRowFree(int chosenColumn) throws FullColumnException;

    int lastRowOccupied(int chosenColumn) throws EmptyColumnException;

    void setNewProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException;

    void payResources(ArrayList<Resource> cost);

    ArrayList<Resource> availableResources();

    void seventhCardCheck() throws EndGameException;

    void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException;

    int score();

    void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpaceInStorageException;

    void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException;

    void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException;

    void addToProductionBuffer(ArrayList<Resource> output);

    void addToFaithPathBuffer(int n);

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
}
