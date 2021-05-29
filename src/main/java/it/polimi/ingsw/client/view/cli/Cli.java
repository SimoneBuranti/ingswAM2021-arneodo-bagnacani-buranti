package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.commands.commandParsers.*;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightLeaderCards;
import it.polimi.ingsw.client.lightModel.productionCards.LightProductionCards;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NotEnoughSpaceErrorMessage;
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

public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {

    private ViewController viewController;

    private CommandParser commandParser;

    private Scanner input = new Scanner(System.in);

    public static final Resource[] resourceTypes = {Resource.COIN,Resource.ROCK,Resource.SHIELD,Resource.SERVANT};

    public Cli() {
        this.commandParser = new ExitOnlyParser();
        commandThread();
    }

    public static int readInt() throws NotIntException {
        Scanner in = new Scanner(System.in);
        String input;
        input = in.nextLine();
        int n = 0;
        for (int i = 0; i<input.length();i++){
            if(input.charAt(i) - '0' >9)
                throw new NotIntException();
            n*=10;
            n+= input.charAt(i) - '0';
        }

        return n;
    }

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
                                            //System.out.println(e.getExtraMessage());
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

    public void changeCommandParser(CommandParser commandParser){
        this.commandParser = commandParser;
    }



    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    @Override
    public void startView() {
        System.out.println("Welcome to MASTERS OF THE RENAISSANCE!");
    }

    @Override
    public void update(String notification) throws IOException, InterruptedException {
        Notification parsedMsg = Notification.deserialize(notification);
        parsedMsg.accept(this);
    }

    @Override
    public void visit(DeckListNotification deckListNotification) {
        showDeckProductionCards(deckListNotification.getListOfFirstCard());

    }

    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        System.out.println("Production cards of your game board:" );
        showGameBoardProductionCards(gameboardListNotification.getListOfFirstCard());
    }


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

    @Override
    public void visit(StorageNotification storageNotification) {
        System.out.println("Your storage now contains: ");
        showResourceBox(storageNotification.getMap());
    }

    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        System.out.println("Your strongbox now contains: ");
        showResourceBox(strongboxNotification.getMap());
    }

    @Override
    public void visit(ReserveNotification reserveNotification) {
        System.out.println("The reserve now contains: ");
        showResourceBox(reserveNotification.getMap());
    }

    @Override
    public void visit(MarketNotification marketNotification) {
        System.out.println("The market now is: ");
        showMarketGrid(marketNotification.getList());
    }

    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        System.out.print("The extra marble of the market now is: ");
        showMarketExtra(extraMarketNotification.getMarble());
    }

    @Override
    public void visit(FaithPathNotification faithPathNotification) {
        //if (faithPathNotification.isLorenzo())
        //    System.out.println("Lorenzo's position in the faith track is: ");
       // else
            System.out.println("Your faith indicator position in the faith track is: ");

        showFaithIndicator(faithPathNotification.getI());
    }


    @Override
    public void notifyError(Message msg) {
        System.out.println(msg.toString());
        /*if(msg.getMessageType() == MessageType.ALREADYEXISTINGNICKNAMEERROR || msg.getMessageType() == MessageType.NICKNAMENOTFOUNDERROR){
            try {
                askNickname();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException {
        int nOfPlayers;
        System.out.println("How many players? [1...4]");

        changeCommandParser(new HowManyPlayerParser());
        /*while (input.hasNext()){
            if(input.hasNextInt()) {
                nOfPlayers = input.nextInt();
                if (nOfPlayers > 0 && nOfPlayers < 5) {
                    notifyObserver(new NumberPlayerMessage(nOfPlayers));
                    if (nOfPlayers > 1)
                        System.out.println("Please wait for the missing players to start the game...");
                    return;
                } else {
                    System.out.println("Invalid number of players, try with a number between 1 and 4");
                }
            }else if(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println("Invalid command of players, try with a number between 1 and 4");
            }

        }*/
    }


    @Override
    public void askNickname() throws IOException, InterruptedException {
        String nickname;
        System.out.println("What's your username?");

        changeCommandParser(new NickNameParser());
        /*if (input.hasNextLine()){
            nickname =input.nextLine();
            viewController.setNickName(nickname);
            notifyObserver(new UsernameMessage(nickname));
        }*/
    }
    @Override
    public void askRestartGame() throws IOException, InterruptedException {
        String answer;
        changeCommandParser(new ResumeGameParser());

        System.out.println("Do you want to resume the previous match? [yes / no]");

        /*while (input.hasNextLine()){
            answer =input.nextLine();
            if (answer.equals("yes")){
                notifyObserver(new RestartAnswerMessage(true));
                return;
            } else if (answer.equals("no")){
                notifyObserver(new RestartAnswerMessage(false));
                return;
            } else {
                System.out.println("Invalid command, try again");
            }
        }*/
    }
    @Override
    public void yourTurn() {
        changeCommandParser(new MyTurnParser());
        System.out.println("It's your turn");
    }

    @Override
    public void showChangeCurrent(String currentNick) {
        System.out.println("Current player: "+currentNick);
    }

    @Override
    public void showPlayersOrder(ArrayList<String> nickName){
        System.out.println("The players round is : " + nickName);
    }

    @Override
    public void showLastTurn(String nickName){
        System.out.println("Player " + nickName + " activated the last turn round");
    }
    @Override
    public void showLobby(int playersInLobby, int playerInGame){
        System.out.println("There are " + playersInLobby + " players in the lobby out of " + playerInGame +
                ", waiting for the missing players to start the game...");
    }
    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards)  throws IOException, InterruptedException {

        int contOne =0;
        int contSecond=0;
        int cont=0;

        changeCommandParser(new InitLeaderCardParser());
        System.out.println("Please choose 2 from the following leader cards to keep in your game board [card1 card2]: ");
        showLeaderCards(leaderCards);
        /*while (input.hasNext()){

            if(input.hasNextInt()) {
                cont++;
                if (cont == 2)
                {
                    contSecond = input.nextInt() - 1;
                    if (contSecond>4 || contSecond<0)
                        System.out.println("Invalid command, try again");
                    notifyObserver(new KeepLeaderCardsMessage(contOne,contSecond));
                    String line = input.nextLine();
                    return;
                }
                else
                {   contOne = input.nextInt() - 1;
                    if (contOne>4 || contOne<0)
                        System.out.println("Invalid command, try again");
                    //String line = input.nextLine();
                }
            }
            else if(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println("Invalid command for keep leader card");
            }
        }*/
    }


    @Override
    public void showCallForCouncil(String nickname, int papalCard){
        if(papalCard == 0){
            System.out.println(nickname + " activated the report in the Vatican : sorry, you didn't get the papal favor card");
        }else if (papalCard == 1){
            System.out.println(nickname + " activated the report in the Vatican : you got the papal favor card!");
        }
    }

    @Override
    public void showStartGame(GameTypeMessage msg) {
        System.out.println("The game has started!");
        this.commandParser = new StandardParser();
    }

    @Override
    public void showRestartMessage() {
        System.out.println("Enter your username of the previous game to resume the match...");
    }

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

    @Override
    public void checkThreadRestart(){
        if (viewController.getGame().isInitResource()){
            changeCommandParser(new StandardParser());
        }
    }

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

    @Override
    public void youWin(int score) {
        System.out.println("YOU WIN !!!");
        System.out.println("Your score is : " + score);
        changeCommandParser(new StandardParser());
    }

    @Override
    public void lorenzoWin() {
        System.out.println("YOU LOSE :(");
        changeCommandParser(new StandardParser());
    }

    @Override
    public void showWinner(String nickname) {
        System.out.println("The winner is : " + nickname);
        changeCommandParser(new StandardParser());
    }

    @Override
    public void showOpponentAction(Message msg) {
        System.out.println(msg.toString());
    }

    @Override
    public void sayDisconnect() {
        System.out.println(" Server is crashed, please try again after few minutes");
    }

    @Override
    public void askInitResource() throws IOException, InterruptedException {
        Resource msg=null;
        Resource msg2=null;
        String s=null;
        int count=0;


        ArrayList<Resource> resources=new ArrayList<>();
        int cont=0;
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

        /*else if(viewController.getGame().getPosition()==2)
        {
            System.out.println(" hey " + viewController.getNickName() +" please say me your favourite resource ");
            while (input.hasNextLine())
            {
                s=input.nextLine();
                if ((Command.fromStringToResource(s) instanceof Resource))
                {   msg = (Command.fromStringToResource(s));
                    resources.add(msg);
                    notifyObserver(new InitialResourcesMessage(resources));
                    notifyObserver(new EndOfTurnMessage());
                    changeCommandParser(new StandardParser());
                    commandThread();
                    return;
                }
                else
                { System.out.println("Invalid resource ,**** try again"); }
            }
        }
        else {
            System.out.println("hey " + viewController.getNickName() +" please say me two resource for be happy, after first press enter");
            while (input.hasNextLine())
            {
                s=input.nextLine();
                if (Command.fromStringToResource(s) instanceof Resource)
                {
                    msg = (Command.fromStringToResource(s));
                    resources.add(msg);
                    cont++;
                    if (cont==2)
                    {
                        notifyObserver(new InitialResourcesMessage(resources));
                        notifyObserver(new EndOfTurnMessage());
                        changeCommandParser(new StandardParser());
                        commandThread();
                        return;
                    }
                }
                else
                { System.out.println("Invalid resource, try again"); }
            } }*/
    }



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

    @Override
    public void showMarketExtra(Marble extra) {
        System.out.println(extra.getColour());
    }

    @Override
    public void showProductionDecks(){
        ArrayList<ProductionCard> deckList = viewController.getGame().deckNotification();
        showDeckProductionCards(deckList);
    }

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

    public void showNumDeck(int numDeck, int spaces){
        String temp;
        int chars;
        temp = "| deck number = " + numDeck;
        chars = temp.length();
        System.out.print(temp);
        printSpaces(spaces - chars);
    }

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


    public void showReserve(){
        showResourceBox(viewController.getGame().getReserve());
    }

    @Override
    public void showMarket() {
        System.out.println("Market grid:");
        showMarketGrid(viewController.getGame().getMarketGrid());
        System.out.print("Extra marble: ");
        showMarketExtra(viewController.getGame().getMarketExtra());
    }

    @Override
    public void showWhiteMarbleResources(int n,ArrayList<Resource> whiteMarbleResourceTypes) {
        System.out.println("You can exchange white marbles with "+ whiteMarbleResourceTypes);
        changeCommandParser(new WhiteMarbleParser(n,whiteMarbleResourceTypes));
    }

    @Override
    public void showSpaceError(NotEnoughSpaceErrorMessage msg) {
        System.out.println(msg.toString());
        changeCommandParser(new KeepResourcesParser(msg.getReources()));
    }

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

    public void printSpaces(int n){
        for(int i=0;i<n;i++)
            System.out.print(" ");
    }

    public void printDash(int n){
        for(int i=0;i<n;i++)
            System.out.print("-");
    }

}