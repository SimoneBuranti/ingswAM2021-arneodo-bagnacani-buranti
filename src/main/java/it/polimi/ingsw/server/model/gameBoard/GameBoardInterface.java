package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Colour;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCard;

import java.util.ArrayList;
/**
 * This is the interface from which starts all the Decorator Pattern used to
 * implement the effects of the {@link LeaderCard}
 */
public abstract class GameBoardInterface {
    public abstract void setStorageExtra(Resource resource);

    public abstract void endOfProduction();

    public abstract int getIndicator();

    public abstract void  faithMove () throws CallForCouncilException, LastSpaceReachedException;

    public abstract void setPapal();

    public abstract Resource whiteExchange() throws BlockedWhiteMarbleEffectException, WhiteMarbleException;

    public abstract void extraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    public abstract void anotherExtraProductionOn(Resource resource) throws ImpossibleProductionException, CallForCouncilException, LastSpaceReachedException;

    public abstract void addToStorage(Resource resource);

    public abstract void addToStrongbox(Resource resource);

    public abstract int firstRowFree(int chosenColumn) throws FullColumnException;

    public abstract int lastRowOccupied(int chosenColumn) throws EmptyColumnException;

    public abstract void setNewProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException;

    public abstract void payResources(ArrayList<Resource> cost);

    public abstract ArrayList<Resource> availableResources();

    public abstract void seventhCardCheck() throws EndGameException;

    public abstract void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException;

    public abstract int score();

    public abstract int faithScore();

    public abstract void takeFromMarket(ArrayList<Resource> newResources) throws NotEnoughSpaceInStorageException;

    public abstract void baseProductionOn(Resource i1, Resource i2, Resource o) throws ImpossibleProductionException;

    public abstract void productionOn(int chosenColumn) throws ImpossibleProductionException, EmptyColumnException, CallForCouncilException, LastSpaceReachedException;

    public abstract void addToProductionBuffer(ArrayList<Resource> output);

    public abstract void setProductionCard(ProductionCard card, int chosenColumn);

    public abstract void addLeaderCardToGameBoard(LeaderCard leaderCard);

    public abstract int leaderCardsSize();

    public abstract LeaderCard reportLeaderCardToGameBoard(int index);

    public abstract void removeLeaderCardToGameBoard(int index);

    public abstract GameBoardInterface activationLeaderCard(GameBoardInterface gameBoard,int index) throws RequirementsException;

    public abstract int colourQuantity(Colour colour);

    public abstract int levelAndColourQuantity(Colour colour, int level);

    public abstract int resourceQuantity(Resource resource);

    public abstract int getWhiteMarbleCardActivated();

    public abstract void setWhiteMarbleCardActivated();

    public abstract int getProductionCardActivated();

    public abstract void setProductionCardActivated();

    public abstract int getReductionCardActivated();

    public abstract void setReductionCardActivated();

    public abstract int getStorageCardActivated();

    public abstract void setStorageCardActivated();

    public abstract Resource getResourceTypeFirst();

    public abstract int scoreResource();

    public abstract ArrayList<Resource> getProductionBuffer();
}
