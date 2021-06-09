package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.commands.commandParsers.*;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightLeaderCards;
import it.polimi.ingsw.client.lightModel.productionCards.LightProductionCards;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.GameTypeMessage;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class represents the CLI and it implements view interface.
 * It reads the player's input from System.in and shows video elements of the game and messages to the player
 */
public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {

    /**
     * This attribute represents the controller of the view
     */
    private ViewController viewController;

    /**
     * This attribute represents the parser of the player's commands and it changes dynamically depending on what
     * the player can write
     */
    private CommandParser commandParser;

    /**
     * This attribute reads the player's input
     */
    private Scanner input = new Scanner(System.in);

    /**
     * This attribute contains all resource types
     */
    public static final Resource[] resourceTypes = {Resource.COIN,Resource.ROCK,Resource.SHIELD,Resource.SERVANT};


    /**
     * Class constructor. The player can only write an exit command.
     */
    public Cli() {
        this.commandParser = new ExitOnlyParser();
        commandThread();
    }

    /**
     * This method reads the player's commands and sends them to the command parser and
     * it handles exceptions that can be launched
     */
    public void commandThread(){

        (new Thread( () -> {
                            String commandText;
                            while(true){
                                try {
                                    commandText = input.nextLine();
                                    this.notifyObserver((commandParser.parseCommand(commandText,this.viewController,this).commandOn()));
                                } catch (InvalidCommandException e) {
                                    System.out.println("Invalid command, type 'help' to check the command list");
                                } catch (SpentTokenException e) {
                                    System.out.println("Impossible request, you have already done an action");
                                } catch (AlreadyActivatedProductionException e) {
                                    System.out.println("Impossible request, you have already activated this production");
                                } catch (InterruptedException | IOException e) {
                                    e.printStackTrace();
                                } catch (EndAfterThisException e) {
                                    try {
                                        notifyObserver(e.getExtraMessage());
                                        notifyObserver(new EndOfTurnMessage());
                                    } catch (IOException | InterruptedException ioException) {
                                        ioException.printStackTrace();
                                    }
                                    changeCommandParser(new StandardParser());
                                } catch (NoMessageReturnException ignored) {
                                } catch (InitLeaderCardsException e) {
                                    viewController.getGame().setInitLeader(true);
                                    try {
                                        notifyObserver(e.getInitLeaderCardsMessage());
                                        askInitResource();
                                    } catch (IOException | InterruptedException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                            }

                        }
                    )
        ).start();

    }

    /**
     * This method changes the dynamic type of the command parser
     * @param commandParser : the dynamic type of the command parser
     */
    public void changeCommandParser(CommandParser commandParser){
        this.commandParser = commandParser;
    }


    /**
     * This method sets the viewController attribute and adds it to the observers
     * @param viewController : the cli observer
     */
    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    /**
     * This method shows the initial message
     */
    @Override
    public void startView() {
        System.out.println("Welcome to MASTERS OF THE RENAISSANCE!");
    }

    /**
     * This method deserializes the light model notification
     */
    @Override
    public void update(String notification) throws IOException, InterruptedException {
        Notification parsedMsg = Notification.deserialize(notification);
        parsedMsg.accept(this);
    }

    /**
     * This method calls the method to show the production card decks received with a notification
     */
    @Override
    public void visit(DeckListNotification deckListNotification) {
        showDeckProductionCards(deckListNotification.getListOfFirstCard());

    }

    /**
     * This method calls the method to show the player's production cards received with a notification
     */
    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        System.out.println("Production cards of your game board:" );
        showGameBoardProductionCards(gameboardListNotification.getListOfFirstCard());
    }

    /**
     * This method calls the method to show the player's leader cards received with a notification
     */
    @Override
    public void visit(LeaderListCardNotification leaderListCardNotification) {
        if(leaderListCardNotification.isActivated())
            System.out.println("The leader cards you activated: ");
        else
            System.out.println("The leader cards you can activate or discard: ");

        if(leaderListCardNotification.getListOfFirstCard().size() > 0){
            showLeaderCards(leaderListCardNotification.getListOfFirstCard());
        }

    }

    /**
     * This method shows the player's leader cards
     */
    public void showLeaderCards(ArrayList<LeaderCard> leaderCards){
        for(int i = 0; i < leaderCards.size(); i++){
            printSpaces(8);
            printDash(92);
            System.out.println();

            printSpaces(8);
            System.out.println( i+1 + " leader card");

            printSpaces(8);
            System.out.println(leaderCards.get(i).getRequirements().toString());

            printSpaces(8);
            System.out.println(leaderCards.get(i).toString());

            printSpaces(8);
            System.out.print("Victory points: ");
            System.out.println(leaderCards.get(i).getPoints());
        }
        if(leaderCards.size() > 0) {
            printSpaces(8);
            printDash(92);
            System.out.println();
        }
    }

    /**
     * This method calls the method to show the player's storage received with a notification
     */
    @Override
    public void visit(StorageNotification storageNotification) {
        System.out.println("Your storage now contains: ");
        showResourceBox(storageNotification.getMap());
    }

    /**
     * This method calls the method to show the player's strongbox received with a notification
     */
    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        System.out.println("Your strongbox now contains: ");
        showResourceBox(strongboxNotification.getMap());
    }

    /**
     * This method calls the method to show the reserve received with a notification
     */
    @Override
    public void visit(ReserveNotification reserveNotification) {
        System.out.println("The reserve now contains: ");
        showResourceBox(reserveNotification.getMap());
    }

    /**
     * This method calls the method to show the market grid received with a notification
     */
    @Override
    public void visit(MarketNotification marketNotification) {
        System.out.println("The market now is: ");
        showMarketGrid(marketNotification.getList());
    }

    /**
     * This method calls the method to show the market extra marble received with a notification
     */
    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        System.out.print("The extra marble of the market now is: ");
        showMarketExtra(extraMarketNotification.getMarble());
    }

    /**
     * This method calls the method to show the player's faith indicator received with a notification
     */
    @Override
    public void visit(FaithPathNotification faithPathNotification) {
        if(!faithPathNotification.isLorenzo())
            System.out.println("Your faith indicator position in the faith track is: ");

        showFaithIndicator(faithPathNotification.getI());
    }

    @Override
    public void visit(InitLeaderNotification initLeaderNotification) {
        //gui method
    }

    @Override
    public void visit(ActivateLeaderNotification activateLeaderNotification) {
       //gui method
    }

    @Override
    public void visit(DiscardLeaderNotification discardLeaderNotification) {
        //gui method
    }

    /**
     * This method shows the player's papal cards initial configuration received with a notification
     */
    @Override
    public void visit(PapalCardsConfigNotification papalCardsConfigNotification) {
        for (int i=0; i<3;i++){
            if(papalCardsConfigNotification.getPapalCards()[i] == 0){
                System.out.println("you didn't get the papal favor card " + i+1);
            }else if (papalCardsConfigNotification.getPapalCards()[i] == 1){
                System.out.println("you've got the papal favor card " + (i+1) + " !");
            }
        }
    }

    /**
     * This method shows an error message
     */
    @Override
    public void notifyError(Message msg) {
        System.out.println(msg.toString());
        if(msg instanceof NotAvailableResourcesErrorMessage) {
            if(viewController.isActionToken()) {
                viewController.resetLastProduction();
            }else {
                viewController.setActionToken(false);
            }
        }else if (msg instanceof WrongColumnErrorMessage || msg instanceof BaseProductionErrorMessage)
            viewController.resetLastProduction();

    }

    /**
     * This method asks the player how many he wants to play with and sets the right command parser
     */
    @Override
    public void askNumberOfPlayers() {
        System.out.println("How many players? [1...4]");

        changeCommandParser(new HowManyPlayerParser());

    }

    /**
     * This method asks the player its username and sets the right command parser
     */
    @Override
    public void askNickname() {
        System.out.println("What's your username?");

        changeCommandParser(new NickNameParser());

    }

    /**
     * This method asks the player if he wants to resume the game and sets the right command parser
     */
    @Override
    public void askRestartGame(){
        changeCommandParser(new ResumeGameParser());

        System.out.println("Do you want to resume the previous match? [yes / no]");

    }

    /**
     * This method shows your turn message and sets the right command parser
     */
    @Override
    public void yourTurn() {
        changeCommandParser(new MyTurnParser());
        System.out.println("It's your turn");
    }

    /**
     * This method shows the current player
     */
    @Override
    public void showChangeCurrent(String currentNick) {
        System.out.println("Current player: "+currentNick);
    }

    /**
     * This method shows the players round
     */
    @Override
    public void showPlayersOrder(ArrayList<String> nickName){
        System.out.println("The players round is : " + nickName);
    }

    /**
     * This method shows the last turn message
     */
    @Override
    public void showLastTurn(String nickName){
        System.out.println("Player " + nickName + " activated the last turn round");
    }

    /**
     * This method shows the server lobby
     * @param playersInLobby : the actual number of players
     * @param playerInGame : the number of players of the game
     */
    @Override
    public void showLobby(int playersInLobby, int playerInGame){
        System.out.println("There are " + playersInLobby + " players in the lobby out of " + playerInGame +
                ", waiting for the missing players to start the game...");
    }

    /**
     * This method asks the player to choose two leader cards and sets the right command parser
     */
    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards){
        changeCommandParser(new InitLeaderCardParser());
        System.out.println("Please choose 2 from the following leader cards to keep in your game board [card1 card2]: ");
        showLeaderCards(leaderCards);

    }

    /**
     * This method shows the call for council message and tells the player whether or not he got the papal card
     * @param nickname : the name of the player who activated the papal card
     * @param papalCard : the value of the current papal card
     */
    @Override
    public void showCallForCouncil(String nickname, int papalCard){
        if(papalCard == 0){
            System.out.println(nickname + " activated the report in the Vatican : sorry, you didn't get the papal favor card");
        }else if (papalCard == 1){
            System.out.println(nickname + " activated the report in the Vatican : you got the papal favor card!");
        }
    }

    /**
     * This method shows that the game has started and sets the right command parser
     */
    @Override
    public void showStartGame(GameTypeMessage msg) {
        System.out.println("The game has started!");
        this.commandParser = new StandardParser();
    }

    /**
     * This method shows the player to put the name he had in the previous game
     */
    @Override
    public void showRestartMessage() {
        System.out.println("Enter your username of the previous game to resume the match...");
    }

    /**
     * This method shows an opponent's game board
     */
    @Override
    public void showPlayerInfo(ShowAllOfPlayerMessage msg) {
        System.out.println("Player" + msg.getNickname() + "game board information : ");
        if(msg.isConnected())
            System.out.println("the player is connected to the game");
        else
            System.out.println("the player is NOT connected to the game");

        System.out.println("> production cards : ");
        ProductionCard[][] gameBoardProductionCards = new ProductionCard[3][3];

        for (int i=0; i<3;i++)
            for (int j=0; i<3;i++)
                if (msg.getProductioncard()[i][j]==0)
                    gameBoardProductionCards[i][j] = null;
                else
                    gameBoardProductionCards[i][j] = LightProductionCards.productionCardByKey(msg.getProductioncard()[i][j]);

        showGameBoardProductionCards(gameBoardProductionCards);

        System.out.println("> leader cards activated : ");
        ArrayList<LeaderCard> leaderCards = new ArrayList<>();
        for (int i=0; i<msg.getListLeaderActivated().size();i++)
            leaderCards.add(LightLeaderCards.leaderCardByKey(msg.getListLeaderActivated().get(i)));
        showLeaderCards(leaderCards);

        System.out.println("> strongbox : ");
        showResourceBox(msg.getStrongBox());
        System.out.println("> storage : ");
        showResourceBox(msg.getStorage());
        System.out.println("> faith indicator : ");
        showFaithIndicator(msg.getFaithIndicator());
    }

    /**
     * This method sets the right command parser
     */
    @Override
    public void checkThreadRestart(){
        if (viewController.getGame().isInitResource()){
            changeCommandParser(new StandardParser());
        }
    }

    /**
     * This method shows the effect of the revealed action marker
     */
    @Override
    public void showActionMarker(String actionType) {
        System.out.print("Lorenzo the Magnificent ");
        switch (actionType) {
            case "ActionMarkerProductionYellow":{
                System.out.println("has picked two cards from yellow production decks.");
                return;
            }
            case "ActionMarkerProductionBlue":{
                System.out.println("has picked two cards from blue production decks.");
                return;
            }
            case "ActionMarkerProductionGreen":{
                System.out.println("has picked two cards from green production decks.");
                return;
            }
            case "ActionMarkerProductionViolet":{
                System.out.println("has picked two cards from violet production decks.");
                return;
            }
            case "ActionMarkerForCrossDouble":{
                System.out.println("has moved by two position in the faith path.");
                showFaithIndicator(viewController.getGame().getLorenzoPosition());
                return;
            }
            case "ActionMarkerForCrossOnce":{
                System.out.println("has moved by one position in the faith path.");
                showFaithIndicator(viewController.getGame().getLorenzoPosition());
                return;
            }
        }
    }

    /**
     * This method shows the player that he is the winner and sets the right command parser
     * @param score : the player's score
     */
    @Override
    public void youWin(int score) {
        System.out.println("YOU WIN !!!");
        System.out.println("Your score is : " + score);
        changeCommandParser(new StandardParser());
    }

    /**
     * This method shows the player that the Lorenzo the Magnificent is the winner and sets the right command parser
     */
    @Override
    public void lorenzoWin() {
        System.out.println("YOU LOSE :(");
        changeCommandParser(new StandardParser());
    }

    /**
     * This method shows the player the winner and sets the right command parser
     */
    @Override
    public void showWinner(String nickname) {
        System.out.println("The winner is : " + nickname);
        changeCommandParser(new StandardParser());
    }

    /**
     * This method shows the player the action of another player
     */
    @Override
    public void showOpponentAction(Message msg) {
        System.out.println(msg.toString());
    }

    /**
     * This method shows the player that the server is crashed
     */
    @Override
    public void sayDisconnect() {
        System.out.println(" Server is crashed, please try again after few minutes");
    }

    /**
     * This method asks the player to choose the initial resources and sets the right command parser
     */
    @Override
    public void askInitResource() throws IOException, InterruptedException {
        System.out.println("for resource [coin,rock,servant,shield]");
        if(viewController.getGame().getPosition()==1){
            System.out.println("hey my Lord you can't take any init resource");
            notifyObserver(new EndOfTurnMessage());
            changeCommandParser(new StandardParser());
        }
        else if(viewController.getGame().getPosition()==2)
        {
            System.out.println(" hey " + viewController.getNickName() +" please say me your favourite resource ");
            changeCommandParser(new InitResourceParser(1));
        }
        else {
            System.out.println("hey " + viewController.getNickName() +" please say me two resource for be happy, after first press enter");
            changeCommandParser(new InitResourceParser(2));
        }
    }


    /**
     * This method shows game board's production cards
     */
    @Override
    public void showGameBoardProductionCards(ProductionCard[][] productionCards) {
        int spaces = 50;
        int n = 8;

        System.out.print("                          column 1" +
                "                                            column 2" +
                "                                            column 3\n");

        printSpaces(n);
        printDash(spaces * 3);

        System.out.println();

        //---------------------------
        for(int i = 0 ; i < 3; i++) {
            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showLevelProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showColourProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showCostProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showInputProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showOutputProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showFaithPointProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            for(int j = 0; j < 3; j++){
                showVictoryPointProductionCard(productionCards[i][j], spaces);
            }
            System.out.print("|");
            System.out.println();

            printSpaces(n);
            printDash(spaces * 3);
            System.out.println();
        }
    }

    /**
     * This method shows the market grid
     */
    @Override
    public void showMarketGrid(Marble[][] grid) {
        int spaces = 10;
        int n = 8;
        int chars;
        String temp;

        printSpaces(12);
        for(int j = 0; j < 4; j++){
            temp = "c " + (j+1);
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
        System.out.println();


        printSpaces(n);
        printDash(spaces * 4);
        System.out.println();


        for (int i = 0; i < 3; i++) {
            temp = "r " + (i +1);
            chars = temp.length();
            System.out.print(temp);
            printSpaces(n - chars);
            for(int j = 0; j < 4; j++){
                temp = "| " + grid[i][j].getColour();
                chars = temp.length();
                System.out.print(temp);
                printSpaces(spaces - chars);
            }

            System.out.print("|");

            System.out.println();
        }


        printSpaces(n);
        printDash(spaces * 4);

        System.out.println();
    }

    /**
     * This method shows the extra marble
     */
    @Override
    public void showMarketExtra(Marble extra) {
        System.out.println(extra.getColour());
    }

    /**
     * This method calls the method to show production decks
     */
    @Override
    public void showProductionDecks(){
        ArrayList<ProductionCard> deckList = viewController.getGame().deckNotification();
        showDeckProductionCards(deckList);
    }

    /**
     * This method shows game board's faith path
     */
    @Override
    public void showFaithIndicator(int pos) {
        int cornerOffset = 10;

        // first line--------------------
        printSpaces(cornerOffset);
        printSpaces(2);
        for(int i = 4;i<10;i++){
            if(pos==i)
                System.out.print((char) 165);
            else
                System.out.print("0");
        }
        printSpaces(4);
        for(int i = 18;i<25;i++){
            if(pos==i)
                System.out.print((char) 165);
            else
                System.out.print("0");
        }
        System.out.println("");

        //second line-------------

        printSpaces(cornerOffset);
        printSpaces(2);
        if(pos==3)
            System.out.print((char) 165);
        else
            System.out.print("0");
        printSpaces(4);
        if(pos==10)
            System.out.print((char) 165);
        else
            System.out.print("0");
        printSpaces(4);
        if(pos==17)
            System.out.print((char) 165);
        else
            System.out.print("0");
        System.out.println("");

        // third line ---------------

        printSpaces(cornerOffset);
        for(int i = 0;i<3;i++){
            if(pos==i)
                System.out.print((char) 165);
            else
                System.out.print("0");
        }
        printSpaces(4);
        for(int i = 11;i<17;i++){
            if(pos==i)
                System.out.print((char) 165);
            else
                System.out.print("0");
        }
        System.out.println("");
    }


    /**
     * This method shows the production card decks
     */
    @Override
    public void showDeckProductionCards(ArrayList<ProductionCard> productionCards) {
        int spaces = 42;
        int n = 8;
        int numDeck = 1;
        System.out.println("Production card decks:" );

        System.out.print("               green" +
                "                                    blue" +
                "                                    yellow" +
                "                                    violet\n");

        for(int i = 0;i<3;i++){
            System.out.println("\nLevel "+(3-i)+":");

            printSpaces(n);
            printDash(spaces * 4);
            System.out.println();

            printSpaces(n);
            for(int j = 0; j < 4; j++) {
                showNumDeck(numDeck, spaces);
                numDeck++;
            }

            System.out.print("|");
            System.out.println();

            //---------------------------

            printSpaces(n);
            showCostProductionCard(productionCards.get(5-i), spaces);
            showCostProductionCard(productionCards.get(2-i), spaces);
            showCostProductionCard(productionCards.get(8-i), spaces);
            showCostProductionCard(productionCards.get(11-i), spaces);

            System.out.print("|");
            System.out.println();

            //-----------------------------------

            printSpaces(n);
            showInputProductionCard(productionCards.get(5-i), spaces);
            showInputProductionCard(productionCards.get(2-i), spaces);
            showInputProductionCard(productionCards.get(8-i), spaces);
            showInputProductionCard(productionCards.get(11-i), spaces);

            System.out.print("|");
            System.out.println();
            //-------------------------------------------------
            printSpaces(n);
            showOutputProductionCard(productionCards.get(5-i), spaces);
            showOutputProductionCard(productionCards.get(2-i), spaces);
            showOutputProductionCard(productionCards.get(8-i), spaces);
            showOutputProductionCard(productionCards.get(11-i), spaces);

            System.out.print("|");
            System.out.println();
            //-----------------------------------------
            printSpaces(n);

            showFaithPointProductionCard(productionCards.get(5-i), spaces);
            showFaithPointProductionCard(productionCards.get(2-i), spaces);
            showFaithPointProductionCard(productionCards.get(8-i), spaces);
            showFaithPointProductionCard(productionCards.get(11-i), spaces);

            System.out.print("|");
            System.out.println();
            //---------------------------------------
            printSpaces(n);

            showVictoryPointProductionCard(productionCards.get(5-i), spaces);
            showVictoryPointProductionCard(productionCards.get(2-i), spaces);
            showVictoryPointProductionCard(productionCards.get(8-i), spaces);
            showVictoryPointProductionCard(productionCards.get(11-i), spaces);

            System.out.print("|");
            System.out.println();

            //----------------------------------
            printSpaces(n);

            printDash(spaces * 4);

            System.out.println();

        }
    }

    /**
     * This method shows the number of the deck
     */
    public void showNumDeck(int numDeck, int spaces){
        String temp;
        int chars;
        temp = "| deck number = " + numDeck;
        chars = temp.length();
        System.out.print(temp);
        printSpaces(spaces - chars);
    }

    /**
     * This method shows the level of the production card
     */
    public void showLevelProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| level= " + productionCard.getLevel();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the color of the production card
     */
    public void showColourProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| colour= " + productionCard.getColour().getColour();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the cost of the production card
     */
    public void showCostProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| c= " + productionCard.getCost().toString();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the production input of the production card
     */
    public void showInputProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| i= " + productionCard.getIn().toString();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the production output of the production card
     */
    public void showOutputProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| o= " + productionCard.getOut().toString();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the faith points of the production card
     */
    public void showFaithPointProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| faith points= " + productionCard.isFaithPoint();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the victory points of the production card
     */
    public void showVictoryPointProductionCard(ProductionCard productionCard, int spaces){
        String temp;
        int chars;
        if (productionCard != null) {
            temp = "| victory points= " + productionCard.getPoints();
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            printSpaces(spaces - chars);
        }
    }

    /**
     * This method shows the player's game board
     */
    @Override
    public void showGameBoardOfPlayer() {

        System.out.println("Your FaithPath:");
        showFaithIndicator(viewController.getGame().getFaithIndicator());
        System.out.println("Your Production cards:");
        showGameBoardProductionCards(viewController.getGame().getProductionCards());

        System.out.println("Your Storage:");
        showResourceBox(viewController.getGame().getStorage());
        System.out.println("Your Strongbox:");
        showResourceBox(viewController.getGame().getStrongbox());

        System.out.println("Your Activated LeaderCards:");
        showLeaderCards(viewController.getGame().getLeaderCardActivated());
        System.out.println("Your Inactive LeaderCards:");
        showLeaderCards(viewController.getGame().getLeaderCards());

    }


    /**
     * This method calls the method to show the reserve
     */
    public void showReserve(){
        showResourceBox(viewController.getGame().getReserve());
    }

    /**
     * This method calls the methods to show the market
     */
    @Override
    public void showMarket() {
        System.out.println("Market grid:");
        showMarketGrid(viewController.getGame().getMarketGrid());
        System.out.print("Extra marble: ");
        showMarketExtra(viewController.getGame().getMarketExtra());
    }

    /**
     * This method asks the player to choose which resources to get from the white marbles and sets the right command parser
     * @param n : the number of white marbles
     * @param whiteMarbleResourceTypes : the types of resources with which the white marble can be exchanged
     */
    @Override
    public void showWhiteMarbleResources(int n,ArrayList<Resource> whiteMarbleResourceTypes) {
        System.out.println("You can exchange white marbles with "+ whiteMarbleResourceTypes);
        changeCommandParser(new WhiteMarbleParser(n,whiteMarbleResourceTypes));
    }

    /**
     * This method asks the player to choose the resources to hold when his storage does not have
     * enough space and sets the right command parser
     */
    @Override
    public void showSpaceError(NotEnoughSpaceErrorMessage msg) {
        System.out.println(msg.toString());
        changeCommandParser(new KeepResourcesParser(msg.getReources()));
    }

    /**
     * This method shows the map passed as a parameter
     * @param resourceBox : the resource map to show
     */
    public void showResourceBox(Map<Resource,Integer> resourceBox) {

        int n = 10;

        printSpaces(n);
        System.out.print("+----------+----------+----------+----------+\n");
        printSpaces(n);
        for(int i = 0; i< resourceTypes.length;i++){
            System.out.print("|"+resourceTypes[i]);
            printSpaces(n-resourceTypes[i].toString().length());
        }
        System.out.println("|");
        printSpaces(n);
        System.out.print("|----------|----------|----------|----------|\n");
        printSpaces(n);
        for(int i = 0; i< resourceTypes.length;i++){
            System.out.print("|"+resourceBox.get(resourceTypes[i]));
            printSpaces(n-resourceBox.get(resourceTypes[i]).toString().length());
        }
        System.out.println("|");
        printSpaces(n);
        System.out.print("+----------+----------+----------+----------+\n");

    }

    /**
     * This method prints n spaces
     */
    public void printSpaces(int n){
        for(int i=0;i<n;i++)
            System.out.print(" ");
    }

    /**
     * This method prints n dashes
     */
    public void printDash(int n){
        for(int i=0;i<n;i++)
            System.out.print("-");
    }

}