package it.polimi.ingsw;

import java.util.ArrayList;

public abstract class GameBoardDecorator implements GameBoardInterface {

    protected GameBoardInterface gameBoard;

    public GameBoardDecorator(GameBoardInterface gameBoard){
        this.gameBoard = gameBoard;
    }

    @Override
    public void setStorageExtra(Resource resource){
        gameBoard.setStorageExtra(resource);
    }

    @Override
    public void endOfProduction() throws CallForCouncilException, LastSpaceReachedException {
        gameBoard.endOfProduction();
    }

    @Override
    public int getIndicator(){
        return gameBoard.getIndicator();
    }

    @Override
    public void setPapal() {
        gameBoard.setPapal();
    }

    @Override
    public void faithMove() throws CallForCouncilException, LastSpaceReachedException {
        gameBoard.faithMove();
    }

    @Override
    public Resource whiteExchange() throws BlockedWhiteMarbleEffectException, UnavailableResourceException, WhiteMarbleException {
        return gameBoard.whiteExchange();
    }

    @Override
    public void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException {}

    @Override
    public void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException {}

    @Override
    public void addToStorage(Resource resource) throws UnavailableResourceException {
        gameBoard.addToStorage(resource);
    }

    @Override
    public void addToStrongbox(Resource resource) {
        gameBoard.addToStrongbox(resource);
    }

    @Override
    public int firstRowFree(int chosenColumn) throws FullColumnException {
        return gameBoard.firstRowFree(chosenColumn);
    }

    @Override
    public int lastRowOccupied(int chosenColumn) throws EmptyColumnException{
        return gameBoard.lastRowOccupied(chosenColumn);
    }

    @Override
    public void setNewProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException {
        gameBoard.setNewProductionCard(deck,chosenColumn);
    }

    @Override
    public void payResources(ArrayList<Resource> cost) {
        gameBoard.payResources(cost);
    }

    @Override
    public ArrayList<Resource> availableResources() {
        return gameBoard.availableResources();
    }

    @Override
    public void seventhCardCheck() throws EndGameException {
        gameBoard.seventhCardCheck();
    }

    @Override
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        gameBoard.buyProductionCard(deck,chosenColumn);
    }

    @Override
    public int score() {
        return gameBoard.score();
    }

    @Override
    public void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpaceInStorageException {
        gameBoard.takeFromMarket(newResources);
    }

    @Override
    public void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException {
        gameBoard.baseProductionOn(i1,i2,o);
    }

    @Override
    public void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException {
        gameBoard.productionOn(chosenColumn);
    }

    @Override
    public void addToProductionBuffer(ArrayList<Resource> output) {
        gameBoard.addToProductionBuffer(output);
    }

    @Override
    public void addToFaithPathBuffer(int n) {
        gameBoard.addToFaithPathBuffer(n);
    }

    @Override
    public void setProductionCard(ProductionCard card, int chosenColumn) {
        gameBoard.setProductionCard(card,chosenColumn);
    }

    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        return cost;
    }

    @Override
    public LeaderCard reportLeaderCardToGameBoard(int index) {
        return gameBoard.reportLeaderCardToGameBoard(index);
    }


    @Override
    public  void removeLeaderCardToGameBoard(int index){
        gameBoard.removeLeaderCardToGameBoard(index);
    }

    @Override
    public void addLeaderCardToGameBoard(LeaderCard leaderCard){
        gameBoard.addLeaderCardToGameBoard(leaderCard);
    }

    @Override
    public int leaderCardsSize(){
        return gameBoard.leaderCardsSize();

    }

    @Override
    public void activationLeaderCard(int index){
        gameBoard.activationLeaderCard(index);
    }

    @Override
    public int colourQuantity(Colour colour){
        return gameBoard.colourQuantity(colour);
    }

    @Override
    public int levelAndColourQuantity(Colour colour,int level){
        return gameBoard.levelAndColourQuantity(colour, level);
    }

    @Override
    public int resourceQuantity(Resource resource){
        return gameBoard.resourceQuantity(resource);
    }

    @Override
    public int getWhiteMarbleCardActivated() {
        return gameBoard.getWhiteMarbleCardActivated();
    }
    @Override
    public void setWhiteMarbleCardActivated() {
        gameBoard.setWhiteMarbleCardActivated();
    }
    @Override
    public int getProductionCardActivated() {
        return gameBoard.getProductionCardActivated();
    }
    @Override
    public void setProductionCardActivated() {
        gameBoard.setProductionCardActivated();
    }
    @Override
    public int getReductionCardActivated() {
        return gameBoard.getReductionCardActivated();
    }
    @Override
    public void setReductionCardActivated() {
        gameBoard.setReductionCardActivated();
    }
    @Override
    public int getStorageCardActivated() {
        return gameBoard.getStorageCardActivated();
    }
    @Override
    public void setStorageCardActivated() {
        gameBoard.setStorageCardActivated();
    }
    @Override
    public Resource getResourceTypeFirst() {
        return null;
    }
}
