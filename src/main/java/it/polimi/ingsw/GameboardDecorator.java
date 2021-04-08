package it.polimi.ingsw;

import java.util.ArrayList;

public abstract class GameboardDecorator implements GameboardInterface {

    protected GameboardInterface gameboard;

    public GameboardDecorator(GameboardInterface gameboard){
        this.gameboard = gameboard;
    }

    @Override
    public void endOfProduction() throws CallForCouncilException, LastSpaceReachedException {
        gameboard.endOfProduction();
    }

    @Override
    public int getIndicator(){
        return gameboard.getIndicator();
    }

    @Override
    public void setPapal() {
        gameboard.setPapal();
    }

    @Override
    public void faithMove() throws CallForCouncilException, LastSpaceReachedException {
        gameboard.faithMove();
    }

    @Override
    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException, UnavailableResourceException {
        return gameboard.whiteExchange();
    }

    @Override
    public void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException {}

    @Override
    public void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException {}

    @Override
    public void addToStorage(Resource resource) throws UnavailableResourceException {
        gameboard.addToStorage(resource);
    }

    @Override
    public void addToStrongbox(Resource resource) {
        gameboard.addToStrongbox(resource);
    }

    @Override
    public int firstRowFree(int choosenColumn) throws FullColumnException {
        return gameboard.firstRowFree(choosenColumn);
    }

    @Override
    public int lastRowOccupied(int choosenColumn) throws EmptyColumnException{
        return gameboard.lastRowOccupied(choosenColumn);
    }

    @Override
    public void setNewProductionCard(DeckProductionCard deck, int choosenColumn) throws EmptyException, FullColumnException {
        gameboard.setNewProductionCard(deck,choosenColumn);
    }

    @Override
    public void payResources(ArrayList<Resource> cost) {
        gameboard.payResources(cost);
    }

    @Override
    public ArrayList<Resource> availableResources() {
        return gameboard.availableResources();
    }

    @Override
    public void seventhCardCheck() throws EndGameException {
        gameboard.seventhCardCheck();
    }

    @Override
    public void buyProductionCard(DeckProductionCard deck, int choosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        gameboard.buyProductionCard(deck,choosenColumn);
    }

    @Override
    public int score() {
        return gameboard.score();
    }

    @Override
    public void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpeceInStorageException {
        gameboard.takeFromMarket(newResources);
    }

    @Override
    public void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException {
        gameboard.baseProductionOn(i1,i2,o);
    }

    @Override
    public void productionOn(int choosenColumn) throws ImpossibleProductionException, EmptyColumnException {
        gameboard.productionOn(choosenColumn);
    }

    @Override
    public void addToProductionBuffer(ArrayList<Resource> output) {
        gameboard.addToProductionBuffer(output);
    }

    @Override
    public void addToFaithPathBuffer(int n) {
        gameboard.addToFaithPathBuffer(n);
    }

    @Override
    public void setProductionCard(ProductionCard card, int choosenColumn) {
        gameboard.setProductionCard(card,choosenColumn);
    }

    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        return cost;
    }

    @Override
    public LeaderCard reportLeaderCardToGameboard(int index) {
        return null;
    }


    @Override
    public  void removeLeaderCardToGameboard(int index){

    }
}
