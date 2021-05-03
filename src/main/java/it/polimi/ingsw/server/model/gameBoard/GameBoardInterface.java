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

    void setProductionCard(ProductionCard card, int chosenColumn);

    void addLeaderCardToGameBoard(LeaderCard leaderCard);

   int leaderCardsSize();

   LeaderCard reportLeaderCardToGameBoard(int index);


    void removeLeaderCardToGameBoard(int index);

    GameBoardInterface activationLeaderCard(GameBoardInterface gameBoard,int index) throws RequirementsException;

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

    int scoreResource();
}
