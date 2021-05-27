package it.polimi.ingsw.client.view.gui;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NotEnoughSpaceErrorMessage;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.marbles.Marble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Gui extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;
    private RestartFrame restartFrame;
    private JFrame mainFrame;

    public Gui() {
        mainFrame=new JFrame();
        startView();
    }



    @Override
    public void startView() {
        SwingUtilities.invokeLater(() -> {
            mainFrame.setLocation(475,208);
            mainFrame.setSize(820,420);
            mainFrame.setLayout(new FlowLayout());

            mainFrame.setTitle("Master of Renaissance");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setResizable(false);

            ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
            Image image = icon.getImage();
            icon.setImage(image.getScaledInstance(820, 462, 0));
            JLabel background = new JLabel(icon);
            background.setBounds(0, 0, 820, 462);
            mainFrame.add(background);
            mainFrame.setVisible(true);
        });}

    @Override
    public void update(String notification) throws IOException, InterruptedException {

    }

    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException { }

    @Override
    public void askNickname() throws IOException, InterruptedException {

    }

    @Override
    public void askRestartGame() throws IOException, InterruptedException {

    }

    @Override
    public void showChangeCurrent(String currentNick) {

    }

    @Override
    public void yourTurn() {

    }

    @Override
    public void notifyError(Message msg) {

    }

    @Override
    public void showPlayersOrder(ArrayList<String> nickName) {

    }

    @Override
    public void showLastTurn(String nickName) {

    }

    @Override
    public void showLobby(int playersInLobby, int playerInGame) {

    }

    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {

    }

    @Override
    public void showCallForCouncil(String nickname, int papalCard) {

    }

    @Override
    public void showStartGame() {

    }

    @Override
    public void showRestartMessage() {

    }

    @Override
    public void showPlayerInfo(ShowAllOfPlayerMessage msg) {

    }

    @Override
    public void askInitResource() throws IOException, InterruptedException {

    }

    @Override
    public void showGameBoardProductionCards(ProductionCard[][] productionCards) {

    }

    @Override
    public void showMarketGrid(Marble[][] grid) {

    }

    @Override
    public void showMarketExtra(Marble extra) {

    }

    @Override
    public void showFaithIndicator(int pos) {

    }

    @Override
    public void showDeckProductionCards(ArrayList<ProductionCard> productionCards) {

    }

    @Override
    public void showGameBoardOfPlayer() {

    }

    @Override
    public void showProductionDecks() {

    }

    @Override
    public void showReserve() {

    }

    @Override
    public void showMarket() {

    }

    @Override
    public void showWhiteMarbleResources(int n, ArrayList<Resource> whiteMarbleResourceTypes) {

    }

    @Override
    public void showSpaceError(NotEnoughSpaceErrorMessage msg) {

    }

    @Override
    public void checkThreadRestart() {

    }

    @Override
    public void showActionMarker(String actionType) {

    }

    @Override
    public void youWin(int score) {

    }

    @Override
    public void lorenzoWin() {

    }

    @Override
    public void showWinner(String nickname) {

    }

    @Override
    public void showOpponentAction(Message msg) {

    }

    @Override
    public void sayDisconnect() {

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
    public void visit(FaithPathNotification faithPathNotification) {

    }
}
