package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.lightModel.ViewObservable;
import  it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.client.view.ligtModelNotification.*;

import java.io.IOException;

public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;


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

    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException {

    }

    @Override
    public void askNickname() {

    }

    @Override
    public void askRestartGame() {

    }

    @Override
    public void notifyError(String error) {

    }
}
