package it.polimi.ingsw.client.view;

import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;

    private Scanner input = new Scanner(System.in);


    /*public Cli(){

    }*/


    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    @Override
    public void update(String notification) throws IOException, InterruptedException {
        Notification parsedMsg = Notification.deserialize(notification);
        parsedMsg.accept(this);
    }

    @Override
    public void visit(DeckListNotification deckListNotification) {

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


    public String readCommand(){
        (new Thread()).start();
        return null;
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
        System.out.println("There are " + playersInLobby + "players in the lobby out of " + playerInGame +
                ", waiting for the missing players to start the game");
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
}