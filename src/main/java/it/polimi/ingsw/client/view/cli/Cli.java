package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightLeaderCards;
import it.polimi.ingsw.client.lightModel.productionCards.LightProductionCards;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;

    private Scanner input = new Scanner(System.in);


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

    public void readCommand(){

        (new Thread( () -> {
                                try {
                                    Message msg = (Command.parseCommand(input.nextLine(),this.viewController)).commandOn();
                                    if (msg != null) {
                                        this.notifyObserver(msg);
                                    } else
                                        readCommand();
                                } catch (InvalidCommandException e) {
                                    System.out.println("Invalid command, type 'help' to check the command list");
                                    readCommand();
                                } catch (SpentTokenException e) {
                                    System.out.println("Impossible request, you have already done an action");
                                    readCommand();
                                } catch (AlreadyActivatedProductionException e) {
                                    System.out.println("Impossible request, you have already activated this production");
                                    readCommand();
                                } catch (InterruptedException | IOException e) {
                                    e.printStackTrace();
                                }
        }
                    )
        ).start();

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
        
        int spaces = 42;
        System.out.println("Production card decks:" );

        System.out.print("               green" +
                "                                    blue" +
                "                                    yellow" +
                "                                    violet\n");

        for(int i = 0;i<3;i++){
            System.out.println("\nLevel "+(3-i)+":");

            System.out.print("        ");
            for(int z = 0; z < 4; z++) {
                for (int k = 0; k < spaces; k++) {
                    System.out.print("-");
                }
            }
            System.out.println("");

            //---------------------------

            System.out.print("        ");
            showCostProductionCard(deckListNotification, 5, i);
            showCostProductionCard(deckListNotification, 2, i);
            showCostProductionCard(deckListNotification, 8, i);
            showCostProductionCard(deckListNotification, 11, i);

            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            showInputProductionCard(deckListNotification, 5, i);
            showInputProductionCard(deckListNotification, 2, i);
            showInputProductionCard(deckListNotification, 8, i);
            showInputProductionCard(deckListNotification, 11, i);

            System.out.print("|");
                System.out.println("");
            //-------------------------------------------------
            System.out.print("        ");
            showOutputProductionCard(deckListNotification, 5, i);
            showOutputProductionCard(deckListNotification, 2, i);
            showOutputProductionCard(deckListNotification, 8, i);
            showOutputProductionCard(deckListNotification, 11, i);

            System.out.print("|");
            System.out.println("");
            //-----------------------------------------
            System.out.print("        ");

            showFaithPointProductionCard(deckListNotification, 5, i);
            showFaithPointProductionCard(deckListNotification, 2, i);
            showFaithPointProductionCard(deckListNotification, 8, i);
            showFaithPointProductionCard(deckListNotification, 11, i);

            System.out.print("|");
            System.out.println("");
            //---------------------------------------
            System.out.print("        ");

            showVictoryPointProductionCard(deckListNotification, 5, i);
            showVictoryPointProductionCard(deckListNotification, 2, i);
            showVictoryPointProductionCard(deckListNotification, 8, i);
            showVictoryPointProductionCard(deckListNotification, 11, i);

            System.out.print("|");
            System.out.println("");

            //----------------------------------
            System.out.print("        ");

            for(int z = 0; z < 4; z++) {
                for (int k = 0; k < spaces; k++) {
                    System.out.print("-");
                }
            }

            System.out.println("");

        }
    }

    public void showCostProductionCard(DeckListNotification deckListNotification, int numDeck, int i){
        int spaces = 42;
        String temp = "| c= " + deckListNotification.getListOfFirstCard().get(numDeck-i).getCost();
        int chars = temp.length();
        System.out.print(temp);
        for(int k = 0;k<spaces-chars;k++){
            System.out.print(" ");
        }
    }

    public void showInputProductionCard(DeckListNotification deckListNotification, int numDeck, int i){
        int spaces = 42;
        String temp = "| i= " + deckListNotification.getListOfFirstCard().get(numDeck-i).getIn().toString();
        int chars = temp.length();
        System.out.print(temp);
        for(int k = 0;k<spaces-chars;k++){
            System.out.print(" ");
        }
    }

    public void showOutputProductionCard(DeckListNotification deckListNotification, int numDeck, int i){
        int spaces = 42;
        String temp = "| o= " + deckListNotification.getListOfFirstCard().get(numDeck-i).getOut().toString();
        int chars = temp.length();
        System.out.print(temp);
        for(int k = 0;k<spaces-chars;k++){
            System.out.print(" ");
        }
    }

    public void showFaithPointProductionCard(DeckListNotification deckListNotification, int numDeck, int i){
        int spaces = 42;
        String temp = "| faith points= " + deckListNotification.getListOfFirstCard().get(numDeck-i).isFaithPoint();
        int chars = temp.length();
        System.out.print(temp);
        for(int k = 0;k<spaces-chars;k++){
            System.out.print(" ");
        }
    }

    public void showVictoryPointProductionCard(DeckListNotification deckListNotification, int numDeck, int i){
        int spaces = 42;
        String temp = "| victory points= " + deckListNotification.getListOfFirstCard().get(numDeck-i).getPoints();
        int chars = temp.length();
        System.out.print(temp);
        for(int k = 0;k<spaces-chars;k++){
            System.out.print(" ");
        }
    }

    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        int spaces = 50;
        System.out.println("Production cards of your game board:" );

        //-----------------------------------
        System.out.print("        ");
        for(int i = 0; i < 3; i++){
            for (int k = 0; k < spaces; k++) {
                System.out.print("-");
            }
        }

        System.out.println("");

        //---------------------------
        for(int i = 0 ; i < 3; i++) {
            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showLevelProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showColourProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showCostProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showInputProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showOutputProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showFaithPointProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            for(int j = 0; j < 3; j++){
                showVictoryPointProductionCard(gameboardListNotification, i, j);
            }
            System.out.print("|");
            System.out.println("");

            System.out.print("        ");
            for(int z = 0; z < 3; z++){
                for (int k = 0; k < spaces; k++) {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }

    public void showLevelProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| level= " + gameboardListNotification.getListOfFirstCard()[i][j].getLevel();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
    }

    public void showColourProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| colour= " + gameboardListNotification.getListOfFirstCard()[i][j].getColour().getColour();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
    }

    public void showCostProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| cost= " + gameboardListNotification.getListOfFirstCard()[i][j].getCost().toString();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
    }

    public void showInputProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| i= " + gameboardListNotification.getListOfFirstCard()[i][j].getIn().toString();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
    }

    public void showOutputProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| o= " + gameboardListNotification.getListOfFirstCard()[i][j].getOut().toString();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
    }

    public void showFaithPointProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| faith points= " + gameboardListNotification.getListOfFirstCard()[i][j].isFaithPoint();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
    }

    public void showVictoryPointProductionCard(GameboardListNotification gameboardListNotification, int i, int j){
        int spaces = 50;
        String temp;
        int chars;
        if (gameboardListNotification.getListOfFirstCard()[i][j] != null) {
            temp = "| victory points= " + gameboardListNotification.getListOfFirstCard()[i][j].getPoints();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        } else {
            temp = "| ";
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
        }
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
            System.out.print("        ");
            System.out.println("--------------------------------------------------------------------------------------------");

            System.out.print("        ");
            System.out.println( i+1 + " leader card");

            System.out.print("        ");
            System.out.println(leaderCards.get(i).getRequirements().toString());

            System.out.print("        ");
            System.out.println(leaderCards.get(i).toString());

            System.out.print("        ");
            System.out.print("Victory points: ");
            System.out.println(leaderCards.get(i).getPoints());
        }
        System.out.print("        ");
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    @Override
    public void visit(StorageNotification storageNotification) {
        System.out.println("Your storage now contains: " + storageNotification.getMap());
    }

    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        System.out.println("Your strongbox now contains: " + strongboxNotification.getMap());
    }

    @Override
    public void visit(ReserveNotification reserveNotification) {
        System.out.println("The reserve now contains: " + reserveNotification.getMap());
    }

    @Override
    public void visit(MarketNotification marketNotification) {
        int spaces = 10;
        int chars;
        String temp;
        System.out.println("The market now is: ");

        //-----------------------------------
        System.out.print("        ");

        for(int i = 0; i < 4; i++){
            for (int k = 0; k < spaces; k++) {
                System.out.print("-");
            }
        }

        System.out.println("");

        //---------------------------

        for (int i = 0; i < 3; i++) {
            System.out.print("        ");

            for(int j = 0; j < 4; j++){
                temp = "| " + marketNotification.getList()[i][j].getColour();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            System.out.print("|");

            System.out.println("");
        }

        System.out.print("        ");

        for(int i = 0; i < 4; i++){
            for (int k = 0; k < spaces; k++) {
                System.out.print("-");
            }
        }

        System.out.println("");

    }

    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        System.out.println("The extra marble of the market now is: " + extraMarketNotification.getMarble().getColour());
    }

    @Override
    public void visit(ActivateNotification activateNotification) {

    }

    @Override
    public void visit(FaithPathNotification faithPathNotification) {
        System.out.println("Your faith indicator position in the faith track is: " + faithPathNotification.getI());
    }


    @Override
    public void notifyError(Message msg) {
        System.out.println(msg.toString());
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException {
        int nOfPlayers;
        System.out.println("How many players? [1...4]");
        while (input.hasNext()){
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

        }
    }


    @Override
    public void askNickname() throws IOException, InterruptedException {
        String nickname;
        System.out.println("What's your username?");
        if (input.hasNextLine()){
            nickname =input.nextLine();
            viewController.setNickName(nickname);
            notifyObserver(new UsernameMessage(nickname));
        }
    }
    @Override
    public void askRestartGame() throws IOException, InterruptedException {
        String answer;
        System.out.println("Do you want to resume the previous match? [yes / no]");
        while (input.hasNextLine()){
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
        }
    }
    @Override
    public void yourTurn() {

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
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards){
        System.out.println("Please choose 2 from the following leader cards to keep in your game board : ");
        showLeaderCards(leaderCards);
    }
    @Override
    public void showCallForCouncil(String nickname, int papalCard){
        if(papalCard == 0){
            System.out.println("Player " + nickname + "activated the report in the Vatican : sorry, you didn't get the papal favor card");
        }else if (papalCard == 1){
            System.out.println("Player " + nickname + "activated the report in the Vatican : you got the papal favor card!");
        }
    }

    @Override
    public void showStartGame() {
        System.out.println("The game has started!");
    }

    @Override
    public void showRestartMessage() {
        System.out.println("Enter your username of the previous game to resume the match...");
    }

    @Override
    public void showPlayerInfo(ShowAllOfPlayerMessage msg) {
        System.out.println(msg.getNickname());
        System.out.println(msg.isConnected());
        int[][] productioncard=msg.getProductioncard();
        for (int i=0; i<3;i++)
            for (int j=0; i<3;i++)
                if (productioncard[i][j]==0)
                    System.out.println("");
                else
                    System.out.println(LightProductionCards.productionCardByKey(productioncard[i][j]));
        ArrayList<Integer> listLeaderActivated=msg.getListLeaderActivated();
        for (int i=0; i<listLeaderActivated.size();i++)
            System.out.println(LightLeaderCards.leaderCardByKey(listLeaderActivated.get(i)));

        System.out.println(msg.getStrongBox());
        System.out.println(msg.getStorage());
        System.out.println(msg.getFaithIndicator());
    }

    @Override
    public void askInitResource() {

    }
}