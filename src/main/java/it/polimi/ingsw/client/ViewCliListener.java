package it.polimi.ingsw.client;

import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.*;

import java.io.IOException;

public class ViewCliListener implements ViewObserver, MessageVisitor {


    public void update(String string) throws IOException, InterruptedException {
        Message parsedMsg = Message.deserialize(string);
        parsedMsg.accept(this);
    }

    @Override
    public void update(Message message) throws IOException, InterruptedException {

    }

    @Override
    public void visit(AlreadyActivatedErrorMessage msg) {

    }

    @Override
    public void visit(AlreadyExistingNickNameErrorMessage msg) {

    }

    @Override
    public void visit(AlreadyUsedLeaderCardErrorMessage msg) {

    }

    @Override
    public void visit(CompleteRunningMatchErrorMessage msg) {

    }

    @Override
    public void visit(NoNicknameMessage msg) {

    }

    @Override
    public void visit(NotAvailableResourcesErrorMessage msg) {

    }

    @Override
    public void visit(NotEnoughSpaceErrorMessage msg) {

    }

    @Override
    public void visit(RequirementsErrorMessage msg) {

    }

    @Override
    public void visit(WrongColumnErrorMessage msg) {

    }

    @Override
    public void visit(NotYourTurnErrorMessage msg) {

    }

    @Override
    public void visit(BootingLobbyErrorMessage msg) {

    }

    @Override
    public void visit(RestartQuestionMessage msg) {

    }

    @Override
    public void visit(ChangeCurrentPlayerMessage msg) {

    }

    @Override
    public void visit(EndOfTurnMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(LastTurnMessage msg) {

    }

    @Override
    public void visit(ReserveValueMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(DoubleWhiteMarbleEffectMessage msg) {

    }

    @Override
    public void visit(NPlayersMessage msg) {

    }

    @Override
    public void visit(PickedLeaderCardsMessage msg) {

    }

    @Override
    public void visit(SetPapalsMessage msg) {

    }

    @Override
    public void visit(RestartAnswerMessage msg) {

    }

    @Override
    public void visit(ActivateLeaderCardMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(BaseProductionOnMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(BuyProductionCardMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(DiscardLeaderCardMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(DoubleProductionOnMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(EndOfProductionMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ExitMessage msg) {

    }

    @Override
    public void visit(ExtraProductionOnMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(InitialResourcesMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(KeepLeaderCardsMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(KeepResourcesMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(NumberPlayerMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ProductionOnMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(PushColumnMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(PushRowMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(UsernameMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(PingMessage msg) {

    }

    @Override
    public void visit(PongMessage msg) {

    }

    @Override
    public void visit(OkMessage msg) {

    }

    @Override
    public void visit(NicknameStartedMessage msg) {

    }

    @Override
    public void visit(UpdateForNotCurrentResourceMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(UpdateInitResourceMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(UpdateInitLeaderMessage msg) {

    }

    @Override
    public void visit(UpdateChosenLeaderMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {

    }

    @Override
    public void visit(TakeCardMessage msg) {

    }

    @Override
    public void visit(TakeCardForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ConfigurationMarketMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ChangeMarketMessageColumn msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ChangeMarketMessageRow msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ResultFromMarketMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ResultFromMarketNotCurrentMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(MagnificentWinMessage msg) {

    }

    @Override
    public void visit(LorenzoTheMagnificentConfigMessage msg) {

    }

    @Override
    public void visit(MyVictoryMessage msg) {

    }

    @Override
    public void visit(UseActionMarkerMessage msg) {

    }

    @Override
    public void visit(ProductionMessageForNotCurrentMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ProductionMessageForCurrentMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ResultOfProductionMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ResultOfProductionForNotCurrentMessage msg) throws IOException, InterruptedException {

    }

    @Override
    public void visit(ActivationLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(ActivationLeaderForCurrentMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderForNotCurrentMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderForCurrentMessage msg) {

    }

    @Override
    public void visit(FaithPathMessage msg) {

    }

    @Override
    public void visit(FaithPathOpponentMessage msg) {

    }

    @Override
    public void visit(EndGamePlayerWinnerMessage msg) {

    }

    @Override
    public void visit(StorageConfigMessage msg) {

    }

    @Override
    public void visit(StrongboxConfigMessage msg) {

    }

    @Override
    public void visit(LeadercardconfigMessage msg) {

    }

    @Override
    public void visit(StorageExtraConfig msg) {

    }

    @Override
    public void visit(StorageExtraDoubleConfig msg) {

    }

    @Override
    public void visit(FaithConfigMessage msg) {

    }

    @Override
    public void visit(ProductionCardConfigMessage msg) {

    }

    @Override
    public void visit(LorenzoMoveMessage msg) {

    }

    @Override
    public void visit(YourTurnMessage msg) {

    }

    @Override
    public void visit(ChangeTurnMessage msg) {

    }

    @Override
    public void visit(GameTypeMessage msg) throws IOException, InterruptedException {

    }
}
