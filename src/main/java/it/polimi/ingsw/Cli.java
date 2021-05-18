package it.polimi.ingsw;

import it.polimi.ingsw.ligtModelNotification.*;
import it.polimi.ingsw.messages.*;

import java.io.IOException;
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


    public void askRestartGame() throws IOException, InterruptedException {
        String answer;
        System.out.println("Do you want to resume the previous match? [yes / no]");
        while (input.hasNextLine()){
            answer =input.nextLine();
            if (answer == "yes"){
                notifyObserver(new RestartAnswerMessage(true));
                return;
            } else if (answer == "no"){
                notifyObserver(new RestartAnswerMessage(false));
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    @Override
    public void notifyError(String error) {

    }


    public void askNumberOfPlayers() throws IOException, InterruptedException {
        int nOfPlayers;
        System.out.println("How many players? [1 .. 4]");
        while (input.hasNextInt()){
            nOfPlayers =input.nextInt();
            if (nOfPlayers == 1){
                viewController.setGame(false);
                notifyObserver(new NumberPlayerMessage(nOfPlayers));
                return;
            } else if ( nOfPlayers <5 && nOfPlayers>1){
                viewController.setGame(true);
                notifyObserver(new NumberPlayerMessage(nOfPlayers));
                return;
            } else {
                System.out.println("Invalid number of players");
            }
        }
    }



    public void askNickname() throws IOException, InterruptedException {
        String nickname;
        System.out.println("What's your nickname?");
        if (input.hasNextLine()){
            nickname =input.nextLine();
            viewController.setNickName(nickname);
            notifyObserver(new UsernameMessage(nickname));
        }
    }
}