package it.polimi.ingsw.messages;

import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.messages.observable.LeadercardconfigMessage;

import java.io.IOException;

public interface MessageVisitor {
    //Error messages
    void visit(AlreadyActivatedErrorMessage msg);
    void visit(AlreadyExistingNickNameErrorMessage msg);
    void visit(AlreadyUsedLeaderCardErrorMessage msg);
    void visit(CompleteRunningMatchErrorMessage msg);
    void visit(NoNicknameMessage msg);
    void visit(NotAvailableResourcesErrorMessage msg);
    void visit(NotEnoughSpaceErrorMessage msg);
    void visit(RequirementsErrorMessage msg);
    void visit(WrongColumnErrorMessage msg);
    void visit(NotYourTurnErrorMessage msg);
    void visit(BootingLobbyErrorMessage msg);

    //Server to client
    void visit(RestartQuestionMessage msg);
    void visit(ChangeCurrentPlayerMessage msg);

    void visit(EndOfTurnMessage msg);
    void visit(LastTurnMessage msg);

    void visit(ReserveValueMessage msg);
    void visit(DoubleWhiteMarbleEffectMessage msg);
    void visit(NPlayersMessage msg);
    void visit(PickedLeaderCardsMessage msg);
    void visit(SetPapalsMessage msg);

    //Client to server
    void visit(RestartAnswerMessage msg);
    void visit(ActivateLeaderCardMessage msg) throws IOException, InterruptedException;
    void visit(BaseProductionOnMessage msg) throws IOException, InterruptedException;
    void visit(BuyProductionCardMessage msg) throws IOException, InterruptedException;
    void visit(DiscardLeaderCardMessage msg) throws IOException, InterruptedException;
    void visit(DoubleProductionOnMessage msg) throws IOException, InterruptedException;
    void visit(EndOfProductionMessage msg) throws IOException, InterruptedException;
    void visit(ExitMessage msg);
    void visit(ExtraProductionOnMessage msg) throws IOException, InterruptedException;
    void visit(InitialResourcesMessage msg) throws IOException, InterruptedException;
    void visit(KeepLeaderCardsMessage msg) throws IOException, InterruptedException;
    void visit(KeepResourcesMessage msg) throws IOException, InterruptedException;
    void visit(NumberPlayerMessage msg) throws IOException, InterruptedException;
    void visit(ProductionOnMessage msg) throws IOException, InterruptedException;
    void visit(PushColumnMessage msg) throws IOException, InterruptedException;
    void visit(PushRowMessage msg) throws IOException, InterruptedException;
    void visit(UsernameMessage msg) throws IOException, InterruptedException;
    void visit(WhiteMarbleChoosenResourcesMessage msg) throws IOException, InterruptedException;

    //General messages
    void visit(PingMessage msg);
    void visit(PongMessage msg);
    void visit(OkMessage msg);


    //Observer
    void visit(NicknameStartedMessage msg);
    void visit(UpdateForNotCurrentResourceMessage msg);
    void visit(UpdateInitResourceMessage msg);
    void visit(UpdateInitLeaderMessage msg);
    void visit(UpdateChosenLeaderMessage msg);

    void visit(DeckProductionCardMessage msg);
    void visit(DeckProductionCardConfigMessage msg);
    void visit(TakeCardMessage msg);
    void visit(TakeCardForNotCurrentMessage msg);

    void visit(ConfigurationMarketMessage msg);
    void visit(ChangeMarketMessageColumn msg);
    void visit(ChangeMarketMessageRow msg);
    void visit(ResultFromMarketMessage msg);
    void visit(ResultFromMarketNotCurrentMessage msg);


    void visit(MagnificentWinMessage msg);
    void visit(LorenzoTheMagnificentConfigMessage msg);
    void visit(MyVictoryMessage msg);


    void visit(UseActionMarkerMessage msg);


    void visit(ProductionMessageForNotCurrentMessage msg);
    void visit(ProductionMessageForCurrentMessage msg);
    void visit(ResultOfProductionMessage msg);
    void visit(ResultForProductionForNotCurrentMessage msg);


    void visit(ActivationLeaderForNotCurrentMessage msg);
    void visit(ActivationLeaderForCurrentMessage msg);
    void visit(DiscardLeaderForNotCurrentMessage msg);
    void visit(DiscardLeaderForCurrentMessage msg);

    void visit(FaithPathMessage msg);
    void visit(FaithPathOpponentMessage msg);

    void visit(EndGamePlayerWinnerMessage msg);

    void visit(StorageConfigMessage msg);
    void visit(StrongboxConfigMessage msg);
    void visit(LeadercardconfigMessage msg);
    void visit(StorageExtraConfig msg);
    void visit(StorageExtraDoubleConfig msg);
    void visit(FaithConfigMessage msg);
    void visit(ProductionCardConfigMessage msg);












}
