package it.polimi.ingsw.messages;

import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.messages.observable.LeadercardconfigMessage;

import java.io.IOException;

public interface MessageVisitor {
    //Error messages
    void visit(AlreadyActivatedErrorMessage msg) throws IOException, InterruptedException;
    void visit(AlreadyExistingNickNameErrorMessage msg) throws IOException, InterruptedException;
    void visit(AlreadyUsedLeaderCardErrorMessage msg) throws IOException, InterruptedException;
    void visit(CompleteRunningMatchErrorMessage msg);
    void visit(NoNicknameMessage msg) throws IOException, InterruptedException;
    void visit(NotAvailableResourcesErrorMessage msg) throws IOException, InterruptedException;
    void visit(NotEnoughSpaceErrorMessage msg);
    void visit(RequirementsErrorMessage msg);
    void visit(WrongColumnErrorMessage msg);
    void visit(NotYourTurnErrorMessage msg);
    void visit(BootingLobbyErrorMessage msg);

    //Server to client
    void visit(RestartQuestionMessage msg) throws IOException, InterruptedException;
    void visit(ChangeCurrentPlayerMessage msg);

    void visit(EndOfTurnMessage msg) throws IOException, InterruptedException;
    void visit(LastTurnMessage msg);

    void visit(ReserveValueMessage msg) throws IOException, InterruptedException;
    void visit(DoubleWhiteMarbleEffectMessage msg);
    void visit(NPlayersMessage msg) throws IOException, InterruptedException;
    void visit(PickedLeaderCardsMessage msg);


    //Client to server
    void visit(RestartAnswerMessage msg) throws IOException, InterruptedException;
    void visit(ActivateLeaderCardMessage msg) throws IOException, InterruptedException;
    void visit(BaseProductionOnMessage msg) throws IOException, InterruptedException;
    void visit(BuyProductionCardMessage msg) throws IOException, InterruptedException;
    void visit(DiscardLeaderCardMessage msg) throws IOException, InterruptedException;
    void visit(DoubleProductionOnMessage msg) throws IOException, InterruptedException;
    void visit(EndOfProductionMessage msg) throws IOException, InterruptedException;
    void visit(ExitMessage msg) throws IOException, InterruptedException;
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
    void visit(UpdateForNotCurrentResourceMessage msg) throws IOException, InterruptedException;
    void visit(UpdateInitResourceMessage msg) throws IOException, InterruptedException;
    void visit(UpdateInitLeaderMessage msg);
    void visit(UpdateChosenLeaderMessage msg);

    void visit(DeckProductionCardMessage msg) throws IOException, InterruptedException;
    void visit(DeckProductionCardConfigMessage msg) throws IOException, InterruptedException;
    void visit(TakeCardMessage msg);
    void visit(TakeCardForNotCurrentMessage msg);

    void visit(ConfigurationMarketMessage msg) throws IOException, InterruptedException;
    void visit(ChangeMarketMessageColumn msg) throws IOException, InterruptedException;
    void visit(ChangeMarketMessageRow msg) throws IOException, InterruptedException;
    void visit(ResultFromMarketMessage msg) throws IOException, InterruptedException;
    void visit(ResultFromMarketNotCurrentMessage msg) throws IOException, InterruptedException;


    void visit(MagnificentWinMessage msg);
    void visit(LorenzoTheMagnificentConfigMessage msg);
    void visit(MyVictoryMessage msg);


    void visit(UseActionMarkerMessage msg);


    void visit(ProductionMessageForNotCurrentMessage msg) throws IOException, InterruptedException;
    void visit(ProductionMessageForCurrentMessage msg) throws IOException, InterruptedException;
    void visit(ResultOfProductionMessage msg) throws IOException, InterruptedException;
    void visit(ResultOfProductionForNotCurrentMessage msg) throws IOException, InterruptedException;


    void visit(ActivationLeaderForNotCurrentMessage msg);
    void visit(ActivationLeaderForCurrentMessage msg) throws IOException, InterruptedException;
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

    void visit(LorenzoMoveMessage msg);

    void visit(YourTurnMessage msg);

    void visit(ChangeTurnMessage msg);

    void visit(GameTypeMessage msg) throws IOException, InterruptedException;

    void visit(SetPapalsMessage msg) throws IOException, InterruptedException;

    void visit(UpdateInitBooleanMessage msg);


    void visit(AskInformationMessage askInformationmessage) throws IOException, InterruptedException;

    void visit(NoPlayersErrorMessage noPlayersErrorMessage);

    void visit(ShowAllOfPlayerMessage showAllOfPlayerMessage);
}
