package it.polimi.ingsw;

import java.util.ArrayList;

public interface GameboardInterface {

    void endOfProduction() throws CallForCouncilException, LastSpaceReachedException;

    int getIndicator();

    void  faithMove () throws CallForCouncilException, LastSpaceReachedException;

    void setPapal();

    Resource whiteExchange() throws BlockedWhiteMarbleEffectException, UnavailableResourceException;

    void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    void addToStorage(Resource resource) throws UnavailableResourceException;

    void addToStrongbox(Resource resource);

    int firstRowFree(int choosenColumn) throws FullColumnException;

    int lastRowOccupied(int choosenColumn) throws EmptyColumnException;

    void setNewProductionCard(DeckProductionCard deck, int choosenColumn) throws EmptyException, FullColumnException;

    void payResources(ArrayList<Resource> cost);

    ArrayList<Resource> availableResources();

    void seventhCardCheck() throws EndGameException;

    void buyProductionCard(DeckProductionCard deck, int choosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException;

    int score();

    void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpeceInStorageException;

    void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException;

    void productionOn(int choosenColumn) throws ImpossibleProductionException, EmptyColumnException;

    void addToProductionBuffer(ArrayList<Resource> output);

    void addToFaithPathBuffer(int n);

    void setProductionCard(ProductionCard card,int choosenColumn);

    void addLeaderCardToGameboard(LeaderCard leaderCard);

   int leaderCardsSize();

   LeaderCard reportLeaderCardToGameboard(int index);


    void removeLeaderCardToGameboard(int index);




}
