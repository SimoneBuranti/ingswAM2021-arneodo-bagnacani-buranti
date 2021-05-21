package it.polimi.ingsw.server.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.observer.Observable;
import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.marbles.*;
import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.productionCards.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * this class represents the game
 */
public class Game extends Observable {

    private boolean isOver;

    /**
     * this attribute represents the game market
     */
    private Market market;
    /**
     * this attribute represents the game reserve
     */
    private Reserve reserve;
    /**
     * this attribute represents the game current player
     */
    protected Player currentPlayer;
    /**
     * this attribute represents the game first level blue production card deck
     */
    protected DeckProductionCard deckProductionCardOneBlu;
    /**
     * this attribute represents the game second level blue production card deck
     */
    protected DeckProductionCard deckProductionCardTwoBlu ;
    /**
     * this attribute represents the game third level blue production card deck
     */
    protected  DeckProductionCard deckProductionCardThreeBlu ;

    /**
     * this attribute represents the game first level green production card deck
     */
    protected DeckProductionCard deckProductionCardOneGreen ;
    /**
     * this attribute represents the game second level green production card deck
     */
    protected DeckProductionCard deckProductionCardTwoGreen;
    /**
     * this attribute represents the game third level green production card deck
     */
    protected DeckProductionCard deckProductionCardThreeGreen ;

    /**
     * this attribute represents the game first level yellow production card deck
     */
    protected DeckProductionCard deckProductionCardOneYellow ;
    /**
     * this attribute represents the game second level yellow production card deck
     */
    protected DeckProductionCard deckProductionCardTwoYellow ;
    /**
     * this attribute represents the game third level yellow production card deck
     */
    protected DeckProductionCard deckProductionCardThreeYellow;

    /**
     * this attribute represents the game first level violet production card deck
     */
    protected DeckProductionCard deckProductionCardOneViolet ;
    /**
     * this attribute represents the game second level violet production card deck
     */
    protected DeckProductionCard deckProductionCardTwoViolet ;
    /**
     * this attribute represents the game third level violet production card deck
     */
    protected DeckProductionCard deckProductionCardThreeViolet ;

    protected ArrayList<DeckProductionCard> productionCardDecks;

    /**
     * this attribute represents the game leader card deck
     */
    protected DeckLeaderCard deckLeaderCard;

    /**
     * this constructor instantiates all the game attributes
     */
    public Game(Boolean newGame) throws IOException, InterruptedException {
        if (newGame)

        { market = new Market();
        reserve = new Reserve();

        productionCardDecks = new ArrayList<>();

        deckProductionCardOneBlu = new DeckProductionCardOneBlu();
        deckProductionCardTwoBlu = new DeckProductionCardTwoBlu();
        deckProductionCardThreeBlu = new DeckProductionCardThreeBlu();

        deckProductionCardOneGreen = new DeckProductionCardOneGreen();
        deckProductionCardTwoGreen = new DeckProductionCardTwoGreen();
        deckProductionCardThreeGreen = new DeckProductionCardThreeGreen();

        deckProductionCardOneViolet = new DeckProductionCardOneViolet();
        deckProductionCardTwoViolet = new DeckProductionCardTwoViolet();
        deckProductionCardThreeViolet = new DeckProductionCardThreeViolet();

        deckProductionCardOneYellow = new DeckProductionCardOneYellow();
        deckProductionCardTwoYellow = new DeckProductionCardTwoYellow();
        deckProductionCardThreeYellow = new DeckProductionCardThreeYellow();


        productionCardDecks.add(deckProductionCardOneBlu);
        productionCardDecks.add(deckProductionCardTwoBlu);
        productionCardDecks.add(deckProductionCardThreeBlu);
        productionCardDecks.add(deckProductionCardOneGreen);
        productionCardDecks.add(deckProductionCardTwoGreen);
        productionCardDecks.add(deckProductionCardThreeGreen);
        productionCardDecks.add(deckProductionCardOneViolet);
        productionCardDecks.add(deckProductionCardTwoViolet);
        productionCardDecks.add(deckProductionCardThreeViolet);
        productionCardDecks.add(deckProductionCardOneYellow);
        productionCardDecks.add(deckProductionCardTwoYellow);
        productionCardDecks.add(deckProductionCardThreeYellow);

        deckLeaderCard= new DeckLeaderCard();}
        else {
            restoreGame();
        }
        this.isOver=false;

    }

    /**
     * This getter method return the current player of the game
     * @return Player : the game current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * This getter method return the current player of the game
     * @return Player : the game current player
     */
    public String getCurrentNickname() {
        return currentPlayer.getNickName();
    }

    /**
     * this method initialises the current player resource and catches CallForCouncilException and LastSpaceReachedException.
     * When the exceptions are caught, the method calls the exceptionHandler method.
     * @param resource : initial resource of the current player
     */
    public void initResourceOfPlayer(Resource resource) throws IOException, InterruptedException {
        try {
            currentPlayer.initResource(resource);
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        }
        notifyToOneObserver(new UpdateInitResourceMessage(resource));
        notifyAllObserverLessOne(new UpdateForNotCurrentResourceMessage(resource));


    }

    /**
     * this method initialises the current player resources and catches CallForCouncilException and LastSpaceReachedException.
     * When the exceptions are caught, the method calls the exceptionHandler method.
     * @param resourceOne : first initial resource type of the current player
     * @param resourceTwo : second initial resource type of the current player
     */
    public void initResourceOfPlayer(Resource resourceOne, Resource resourceTwo) throws IOException, InterruptedException {
        try {
            currentPlayer.initResource(resourceOne, resourceTwo);
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        }
        notifyToOneObserver(new UpdateInitResourceMessage(resourceOne,resourceTwo));
        notifyAllObserverLessOne(new UpdateForNotCurrentResourceMessage(resourceOne,resourceTwo));

    }

    public DeckProductionCard deckFromDeckNumber(int deckNumber){
        for(DeckProductionCard deck : productionCardDecks)
            if(deck.getDeckNumber() == deckNumber)
                return deck;
        return null;
    }

    /**
     * this method is used to buy a production card by calling the current player method and catches LevelException,
     * NotEnoughResourcesException, EmptyException, FullColumnException and EndGameException.
     * When the exceptions are caught, the method calls the exceptionHandler method.
     * @param deck : it is the production card deck from which the current player wants to buy the card
     * @param chosenColumn : the game board column in which the current player wants to place the bought card
     */
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException, NotEnoughResourcesException, LevelException, IOException, InterruptedException {
        try {
            currentPlayer.buyProductionCard(deck,chosenColumn);
        } catch (EndGameException e) {
            exceptionHandler(e);
        }
        notifyToOneObserver(new TakeCardMessage(deck.getDeckNumber(), chosenColumn));
        notifyAllObserverLessOne(new TakeCardForNotCurrentMessage(currentPlayer,deck.getDeckNumber()));
        notifyObserver(new DeckProductionCardMessage(deck.getDeckNumber()));
    }

    /**
     * not implemented method called when the player discards a resource
     * @param player : the one who discards the resource
     */
    public void moveEveryoneExcept(Player player) throws IOException, InterruptedException { }

    /**
     * this method activates the production of the highest level card in the chosen column of the current player game board by calling the current player method
     * and catches ImpossibleProductionException, EmptyColumnException, CallForCouncilException and LastSpaceReachedException.
     * When the exceptions are caught, the method calls the exceptionHandler method.
     * @param chosenColumn : the game board column where the card the player wants to active is situated
     */
    public void productionOn(int chosenColumn, ArrayList<Resource> list, int faithMove) throws ImpossibleProductionException, EmptyColumnException, IOException, InterruptedException {
        try {

            notifyToOneObserver(new ProductionMessageForCurrentMessage(list));
            notifyAllObserverLessOne(new ProductionMessageForNotCurrentMessage(currentPlayer,list) );
            currentPlayer.productionOn(chosenColumn);
            //if (faithMove)
            {
                notifyToOneObserver(new FaithPathMessage(faithMove));
                notifyAllObserverLessOne(new FaithPathOpponentMessage(currentPlayer.getNickName(),faithMove));

            }

        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        }

    }

    /**
     * this method activates the base production by calling the current player method and catches ImpossibleProductionException.
     * When the exception is caught, the method calls the exceptionHandler method.
     * @param i1 : the first resource type of the base production input
     * @param i2 : the second resource type of the base production input
     * @param output : the resource type of the base production output
     */
    public void baseProductionOn(Resource i1, Resource i2, Resource output) throws ImpossibleProductionException, IOException, InterruptedException {
        currentPlayer.baseProductionOn(i1, i2, output);

        ArrayList<Resource> list =new ArrayList<>();
        list.add(i1);
        list.add(i2);
        notifyToOneObserver(new ProductionMessageForCurrentMessage(list) );
        notifyAllObserverLessOne(new ProductionMessageForNotCurrentMessage(currentPlayer,list) );
    }

    /**
     * this method activates the first extra production by calling the current player method
     * and catches LastSpaceReachedException, CallForCouncilException and ImpossibleProductionException.
     * When the exception is caught, the method calls the exceptionHandler method.
     * @param resource : the resource type of the first extra production output
     */
    public void extraProductionOn(Resource resource, Resource resourceLeader) throws IOException, InterruptedException {
        try {
            ArrayList<Resource> list =new ArrayList<>();
            list.add(resourceLeader);
            notifyToOneObserver(new ProductionMessageForCurrentMessage(list));
            notifyAllObserverLessOne(new ProductionMessageForNotCurrentMessage(currentPlayer, list) );
            notifyToOneObserver(new FaithPathMessage(1));
            notifyAllObserverLessOne(new FaithPathOpponentMessage(currentPlayer.getNickName(), 1));
            currentPlayer.extraProductionOn(resource);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (ImpossibleProductionException e) {
            exceptionHandler(e);
        }
    }

    /**
     * this method activates the second extra production by calling the current player method
     * and catches LastSpaceReachedException, CallForCouncilException and ImpossibleProductionException.
     * When the exception is caught, the method calls the exceptionHandler method.
     * @param resource: the resource type of the second extra production output
     */
    public void anotherExtraProductionOn(Resource resource, Resource resourceLeader) throws ImpossibleProductionException, IOException, InterruptedException {
        try {
            ArrayList<Resource> list =new ArrayList<>();
            list.add(resourceLeader);
            notifyToOneObserver(new ProductionMessageForCurrentMessage(list));
            notifyAllObserverLessOne(new ProductionMessageForNotCurrentMessage(currentPlayer, list) );
            notifyToOneObserver(new FaithPathMessage(1));
            notifyAllObserverLessOne(new FaithPathOpponentMessage(currentPlayer.getNickName(), 1));
            currentPlayer.anotherExtraProductionOn(resource);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        }
    }

    /**
     * this method activates the end of current player productions and catches CallForCouncilException and LastSpaceReachedException.
     * When the exception is caught, the method calls the exceptionHandler method.
     */
    public void endOfProduction() throws IOException, InterruptedException {

        notifyToOneObserver(new ResultOfProductionMessage(currentPlayer.getGameBoardOfPlayer().getProductionBuffer()) );
        notifyAllObserverLessOne(new ResultOfProductionForNotCurrentMessage(currentPlayer,currentPlayer.getGameBoardOfPlayer().getProductionBuffer()) );

        currentPlayer.endOfProduction();

    }

    /**
     * this method saves the leader cards in position index1 and index2 in the current player game board
     * @param index1 : the position where the first chosen leader card is
     * @param index2 : the position where the second chosen leader card is
     */
    public void saveLeaderCardChosen(int index1, int index2) throws IOException, InterruptedException {

        currentPlayer.saveLeaderCard(index1,index2);
        notifyToOneObserver(new UpdateChosenLeaderMessage(index1,index2));
    }

    /**
     * this method discards from the game board the leader card in index position
     * and catches CallForCouncilException, LastSpaceReachedException and LeaderCardsGameBoardEmptyException.
     * When the exception is caught, the method calls the exceptionHandler method.
     * @param index : the position where the leader card to be discarded is
     */
    public void discardLeaderCard(int index) throws LeaderCardsGameBoardEmptyException, IOException, InterruptedException {
        try {
            currentPlayer.discardLeaderCard(index);
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        }
        notifyToOneObserver(new DiscardLeaderForCurrentMessage(index));
        notifyAllObserverLessOne(new DiscardLeaderForNotCurrentMessage(currentPlayer));

        notifyToOneObserver(new FaithPathMessage(1));
        notifyAllObserverLessOneByNickname(new FaithPathOpponentMessage(currentPlayer.getNickName(), 1),currentPlayer.getNickName());


    }

    /**
     *  this method activates the leader card in index position in the game board
     *  and catches LeaderCardsGameBoardEmptyException.
     *  When the exception is caught, the method calls the exceptionHandler method.
     * @param index : the position where the leader card to be activated is
     */
    public void activateLeaderCard(int index) throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException {
        currentPlayer.activationLeaderCard(index);
        notifyToOneObserver(new ActivationLeaderForCurrentMessage(index));
        notifyAllObserverLessOne(new ActivationLeaderForNotCurrentMessage(currentPlayer));
    }


    /**
     * this method actives the market action by passing the row chosen by the current player
     * and catches WhiteMarbleException, CallForCouncilException and LastSpaceReachedException.
     * When the exception is caught, the method calls the exceptionHandler method.
     * @param chosenRow : the row chosen by the current player
     */
    public void pushRowInMarket(int chosenRow) throws NotEnoughSpaceInStorageException, WhiteMarbleException, IOException, InterruptedException {
        try {
            if (market.getRedInRow(chosenRow)){
                notifyToOneObserver(new FaithPathMessage(1));
                notifyAllObserverLessOneByNickname(new FaithPathOpponentMessage(currentPlayer.getNickName(), 1),currentPlayer.getNickName());
            }

            market.pushRow(chosenRow,currentPlayer);

            notifyToOneObserver(new ResultFromMarketMessage(currentPlayer.getBuffer()) );
            notifyAllObserverLessOne(new ResultFromMarketNotCurrentMessage(currentPlayer,currentPlayer.getBuffer()) );

        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        }
        notifyObserver(new ChangeMarketMessageRow(chosenRow));

    }

    /**
     * this method actives the market action by passing the column chosen by the current player
     * and catches WhiteMarbleException, CallForCouncilException and LastSpaceReachedException.
     * When the exception is caught, the method calls the exceptionHandler method.
     * @param chosenColumn : the column chosen by the current player
     */
    public void pushColumnInMarket(int chosenColumn) throws NotEnoughSpaceInStorageException, WhiteMarbleException, IOException, InterruptedException {
        try {
            if (market.getRedInColumn(chosenColumn)){
                notifyToOneObserver(new FaithPathMessage(1));
                notifyAllObserverLessOneByNickname(new FaithPathOpponentMessage(currentPlayer.getNickName(), 1),currentPlayer.getNickName());
            }
            market.pushColumn(chosenColumn,currentPlayer);
            notifyToOneObserver(new ResultFromMarketMessage(currentPlayer.getBuffer()) );
            notifyAllObserverLessOne(new ResultFromMarketNotCurrentMessage(currentPlayer,currentPlayer.getBuffer()) );
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        } catch (LastSpaceReachedException e) {
            exceptionHandler(e);
        }
        notifyObserver(new ChangeMarketMessageRow(chosenColumn));
    }

    /**
     * This method returns the overall score of the player p
     * @param p : the player whose score is to be calculated
     * @return int : the overall score of the player
     */
    public int scoreOfPlayerP(Player p){
        return p.playerScore();
    }
    

    public boolean disconnectPlayer(String nickname){
        return false;
    }

    public void connectPlayer(String nickname) throws IOException, InterruptedException {
    }

    public boolean checkNickname(String nickname){
        return false;
    }

    public int numPlayersDisconnected(){
        return 0;
    }

    /**
     * These methods handle all kinds of exceptions that come into the game
     * @param e : the exception to handle
     */

    protected void exceptionHandler(EmptyColumnException e) {
        }

    protected void exceptionHandler(LevelException e) {
    }

    protected void exceptionHandler(EmptyException e) {
    }

    protected void exceptionHandler(NotEnoughResourcesException e) {
    }

    protected void exceptionHandler(FullColumnException e) {
    }

    protected void exceptionHandler(EndGameException e) throws IOException, InterruptedException {
    }

    protected void exceptionHandler(RequirementsException e) {
    }

    protected void exceptionHandler(CallForCouncilException e) throws IOException, InterruptedException {
    }

    protected void exceptionHandler(LastSpaceReachedException e) throws IOException, InterruptedException {
    }

    protected void exceptionHandler(EndOfSolitaireGame e) throws IOException, InterruptedException {
    }

    protected void exceptionHandler(ImpossibleProductionException e) {
        //...
    }

    protected void exceptionHandler(WhiteMarbleException e){
        //...
    }


    protected void exceptionHandler(LeaderCardsGameBoardEmptyException e) {
    }



    /**
     * Test only method: getter method for the leader card deck size
     * @return int : the size of the leader card deck
     */
    public int leaderDeckSize(){
        return deckLeaderCard.size();
    }


    /**
     * Test only method: getter method for the marble in the MarketGrid cell in position i,j
     * @param i : the row where the cell is located
     * @param j : the column where the cell is located
     * @return Marble : the marble in the MarketGrid cell
     */
    public Marble getCellGridMarket(int i, int j){
        return market.getCellGrid(i,j);
    }



    /**
     * Test only method: getter method for the extra marble in the market
     * @return Marble : the current extra marble in the market
     */
    public Marble getExtraMarket(){
        return market.getExtra();
    }



    /**
     * Test only method: getter method for the marble in the index position in the InitialMarbleList
     * @param index : the position of the marble in the list
     * @return Marble : the marble in the list
     */
    public Marble getInitialMarbleListMarket(int index){
        return market.getCellInitialMarbleList(index);
    }


    /**
     * Test only method: getter method for the production card deck size
     * @param deck : production card deck
     * @return int: size of the production card deck
     */
    public int deckSize(DeckProductionCard deck){
        return deck.size();
    }

    /**
     * Getter method for the game market
     * @return Market : the game market
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Getter method for the game reserve
     * @return Reserve : the game reserve
     */
    public Reserve getReserve() {
        return reserve;
    }


    public synchronized void endOfTurn() throws IOException, InterruptedException { }





    /**
     * save information for a possible restart game
     */
    public void saveInformation(){
        market.saveInformationOfMarket();
        deckProductionCardOneBlu.saveInformationOfProductionDeck();
        deckProductionCardOneGreen.saveInformationOfProductionDeck();
        deckProductionCardOneViolet.saveInformationOfProductionDeck();
        deckProductionCardOneYellow.saveInformationOfProductionDeck();
        deckProductionCardThreeBlu.saveInformationOfProductionDeck();
        deckProductionCardThreeGreen.saveInformationOfProductionDeck();
        deckProductionCardThreeYellow.saveInformationOfProductionDeck();
        deckProductionCardThreeViolet.saveInformationOfProductionDeck();
        deckProductionCardTwoBlu.saveInformationOfProductionDeck();
        deckProductionCardTwoGreen.saveInformationOfProductionDeck();
        deckProductionCardTwoViolet.saveInformationOfProductionDeck();
        deckProductionCardTwoYellow.saveInformationOfProductionDeck();
        reserve.saveInformationOfReserve();

    }





    /**
     * save information for a possible restart game
     */
    protected void restoreGame() throws IOException, InterruptedException {

        restoreInformationOfMarket();
        restoreInformationOfProductionDeck();
        restoreInformationOfReserve();
    }

    /**
     * restore information
     */
    private void restoreInformationOfProductionDeck() throws IOException, InterruptedException {
        Gson gson=DeckProductionCard.gsonForEveryoneDeckProduction();
        ProductionCard[] deck;

        productionCardDecks = new ArrayList<>();

        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardOneBluLatest.json"), ProductionCard[].class);
            deckProductionCardOneBlu = new DeckProductionCardOneBlu(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardTwoBluLatest.json"), ProductionCard[].class);
            deckProductionCardTwoBlu = new DeckProductionCardTwoBlu(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardThreeBluLatest.json"), ProductionCard[].class);
            deckProductionCardThreeBlu = new DeckProductionCardThreeBlu(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardOneGreenLatest.json"), ProductionCard[].class);
            deckProductionCardOneGreen = new DeckProductionCardOneGreen(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardTwoGreenLatest.json"), ProductionCard[].class);
            deckProductionCardTwoGreen = new DeckProductionCardTwoGreen(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardThreeGreenLatest.json"), ProductionCard[].class);
            deckProductionCardThreeGreen = new DeckProductionCardThreeGreen(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardOneYellowLatest.json"), ProductionCard[].class);
            deckProductionCardOneYellow = new DeckProductionCardOneYellow(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardTwoYellowLatest.json"), ProductionCard[].class);
            deckProductionCardTwoYellow = new DeckProductionCardTwoYellow(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardThreeYellowLatest.json"), ProductionCard[].class);
            deckProductionCardThreeYellow = new DeckProductionCardThreeYellow(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardOneVioletLatest.json"), ProductionCard[].class);
            deckProductionCardOneViolet = new DeckProductionCardOneViolet(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardTwoVioletLatest.json"), ProductionCard[].class);
            deckProductionCardTwoViolet = new DeckProductionCardTwoViolet(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            deck = gson.fromJson(new FileReader("src/main/resources/DeckProductionCardThreeVioletLatest.json"), ProductionCard[].class);
            deckProductionCardThreeViolet = new DeckProductionCardThreeViolet(deck);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        productionCardDecks.add(deckProductionCardOneBlu);
        productionCardDecks.add(deckProductionCardTwoBlu);
        productionCardDecks.add(deckProductionCardThreeBlu);
        productionCardDecks.add(deckProductionCardOneGreen);
        productionCardDecks.add(deckProductionCardTwoGreen);
        productionCardDecks.add(deckProductionCardThreeGreen);
        productionCardDecks.add(deckProductionCardOneViolet);
        productionCardDecks.add(deckProductionCardTwoViolet);
        productionCardDecks.add(deckProductionCardThreeViolet);
        productionCardDecks.add(deckProductionCardOneYellow);
        productionCardDecks.add(deckProductionCardTwoYellow);
        productionCardDecks.add(deckProductionCardThreeYellow);
    }


    /**
     * restore information from backup
     */
    private void restoreInformationOfMarket() throws IOException, InterruptedException {

        Gson gson=Market.gsonForEveryoneMArket();

        Marble[] list;

        try {
            list = gson.fromJson(new FileReader("src/main/resources/Market.json"),Marble[].class);
            market= new Market(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



    /**
     * restore information from backup
     */
  private void restoreInformationOfReserve() throws IOException, InterruptedException {
      Gson gson=Reserve.gsonForEveryoneReserve();
        Map map;
        try {
            map = gson.fromJson(new FileReader("src/main/resources/Reserve.json"),Map.class);
            reserve= new Reserve(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
  }

    /**
     * endGame method
     */
    public void endGame() throws IOException, InterruptedException {}

    public void giveResourceFromClient(ArrayList<Resource> list) throws NotEnoughSpaceInStorageException, IOException, InterruptedException {
        currentPlayer.takeResourceFromClientToGameboard(list);
    }

    public void continueTakeFromMarketAfterChoosenWhiteMarble(ArrayList<Resource> whiteMarbleList) throws NotEnoughSpaceInStorageException {
        for(Resource r : whiteMarbleList){
            currentPlayer.addToBuffer(r);
        }

        currentPlayer.takeFromMarket();
    }


    protected void configClient() throws IOException, InterruptedException {
        notifyObserver(new DeckProductionCardConfigMessage(0,deckProductionCardOneBlu.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(1,deckProductionCardTwoBlu.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(2,deckProductionCardThreeBlu.getDeck()));

        notifyObserver(new DeckProductionCardConfigMessage(3,deckProductionCardOneGreen.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(4,deckProductionCardTwoGreen.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(5,deckProductionCardThreeGreen.getDeck()));

        notifyObserver(new DeckProductionCardConfigMessage(6,deckProductionCardOneViolet.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(7,deckProductionCardTwoViolet.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(8,deckProductionCardThreeViolet.getDeck()));

        notifyObserver(new DeckProductionCardConfigMessage(9,deckProductionCardOneYellow.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(10,deckProductionCardTwoYellow.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(11,deckProductionCardThreeYellow.getDeck()));


        notifyObserver(new ConfigurationMarketMessage(market.getInitialMarbleList()));
    }


    protected void configClientReconnected(String nickname) throws IOException, InterruptedException {
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(0,deckProductionCardOneBlu.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(1,deckProductionCardTwoBlu.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(2,deckProductionCardThreeBlu.getDeck()), nickname);

        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(3,deckProductionCardOneGreen.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(4,deckProductionCardTwoGreen.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(5,deckProductionCardThreeGreen.getDeck()), nickname);

        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(6,deckProductionCardOneViolet.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(7,deckProductionCardTwoViolet.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(8,deckProductionCardThreeViolet.getDeck()), nickname);

        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(9,deckProductionCardOneYellow.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(10,deckProductionCardTwoYellow.getDeck()), nickname);
        notifyOnlyOneSpecificObserver(new DeckProductionCardConfigMessage(11,deckProductionCardThreeYellow.getDeck()), nickname);


        notifyOnlyOneSpecificObserver(new ConfigurationMarketMessage(market.getInitialMarbleList()), nickname);
    }


    protected void reConfigClient() throws IOException, InterruptedException {
        notifyObserver(new DeckProductionCardConfigMessage(0,deckProductionCardOneBlu.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(1,deckProductionCardTwoBlu.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(2,deckProductionCardThreeBlu.getDeck()));

        notifyObserver(new DeckProductionCardConfigMessage(3,deckProductionCardOneGreen.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(4,deckProductionCardTwoGreen.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(5,deckProductionCardThreeGreen.getDeck()));

        notifyObserver(new DeckProductionCardConfigMessage(6,deckProductionCardOneViolet.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(7,deckProductionCardTwoViolet.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(8,deckProductionCardThreeViolet.getDeck()));

        notifyObserver(new DeckProductionCardConfigMessage(9,deckProductionCardOneYellow.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(10,deckProductionCardTwoYellow.getDeck()));
        notifyObserver(new DeckProductionCardConfigMessage(11,deckProductionCardThreeYellow.getDeck()));


        notifyObserver(new ConfigurationMarketMessage(market.getInitialMarbleList()));

        notifyObserver(new ReserveValueMessage(reserve.getReservePool()));
    }


    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean bool) {
        this.isOver=bool;
    }

    public void askInfoOnPlayer(int n, String nickname) throws IOException, InterruptedException {}
}
