package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.SpentTokenException;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;

    private Scanner input = new Scanner(System.in);

    //private final static int offset = 20;


    /*public Cli(){

    }*/


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
                                } catch (InterruptedException | IOException e) {
                                    e.printStackTrace();
                                } catch (SpentTokenException e) {
                                    System.out.println("Impossible request, you have already done an action");
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

        System.out.println("Production card decks:" );

        System.out.print("                              green                                            blue                                         yellow                                       violet");
        System.out.println("Level 3:   cost = " + deckListNotification.getListOfFirstCard().get(5).getCost() + "         cost =" +deckListNotification.getListOfFirstCard().get(2).getCost() + "                   cost =" +deckListNotification.getListOfFirstCard().get(8).getCost() + "                   cost = " + deckListNotification.getListOfFirstCard().get(11).getCost());
        System.out.println("           production input = " + deckListNotification.getListOfFirstCard().get(5).getIn() + "                        production input =" +deckListNotification.getListOfFirstCard().get(2).getIn() +"                   production input =" +deckListNotification.getListOfFirstCard().get(8).getIn() + "                   production input = " + deckListNotification.getListOfFirstCard().get(11).getIn());
        System.out.println("           production output = " + deckListNotification.getListOfFirstCard().get(5).getOut() + "                            production output =" +deckListNotification.getListOfFirstCard().get(2).getOut() +"                   production output =" +deckListNotification.getListOfFirstCard().get(8).getOut() + "                   production output = " + deckListNotification.getListOfFirstCard().get(11).getOut());
        System.out.println("           faith points = " + deckListNotification.getListOfFirstCard().get(5).isFaithPoint() + "                                         faith points =" +deckListNotification.getListOfFirstCard().get(2).isFaithPoint() +"                   faith points =" +deckListNotification.getListOfFirstCard().get(8).isFaithPoint() + "                   faith points = " + deckListNotification.getListOfFirstCard().get(11).isFaithPoint());
        System.out.println("           victory points = " + deckListNotification.getListOfFirstCard().get(5).getPoints() + "                                   victory points =" +deckListNotification.getListOfFirstCard().get(2).getPoints() +"                   victory points =" +deckListNotification.getListOfFirstCard().get(8).getPoints() + "                   victory points = " + deckListNotification.getListOfFirstCard().get(11).getPoints());
        //System.out.println(deckListNotification.getListOfFirstCard());
    }

    @Override
    public void visit(GameboardListNotification gameboardListNotification) {

    }

    @Override
    public void visit(LeaderListCardNotification leaderListCardNotification) {

    }

    @Override
    public void visit(StorageNotification storageNotification) {

    }

    @Override
    public void visit(StrongboxNotification strongboxNotification) {

    }

    @Override
    public void visit(ReserveNotification reserveNotification) {

    }

    @Override
    public void visit(MarketNotification marketNotification) {

    }

    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {

    }

    @Override
    public void visit(ActivateNotification activateNotification) {

    }

    @Override
    public void visit(FaithPathNotification faithPathNotification) {

    }


    @Override
    public void notifyError(Message msg) {
        System.out.println(msg.toString());
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException {
        int nOfPlayers;
        System.out.println("How many players? [1...4]");
        while (input.hasNextInt()){
            nOfPlayers =input.nextInt();
            if (nOfPlayers > 0 && nOfPlayers < 5){
                notifyObserver(new NumberPlayerMessage(nOfPlayers));
                if(nOfPlayers > 1)
                    System.out.println("Please wait for the missing players to start the game...");
                return;
            } else {
                System.out.println("Invalid number of players, try with a number between 1 and 4");
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
        System.out.println("Please choose 2 from the following leader cards to keep in your game board : " + leaderCards);
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
}