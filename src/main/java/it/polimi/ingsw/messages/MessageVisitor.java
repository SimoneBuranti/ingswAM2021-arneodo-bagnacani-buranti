package it.polimi.ingsw.messages;

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
    void visit(EndGameMessage msg);
    void visit(EndOfTurnMessage msg);
    void visit(LastTurnMessage msg);
    void visit(LorenzoActionMessage msg);
    void visit(OpponentActivateLeaderCardMessage msg);
    void visit(OpponentDiscardLeaderCardMessage msg);
    void visit(OpponentFaithMoveMessage msg);
    void visit(OpponentBuyProductionCardMessage msg);
    void visit(ReserveValueMessage msg);
    void visit(DoubleWhiteMarbleEffectMessage msg);
    void visit(NPlayersMessage msg);
    void visit(PickedLeaderCardsMessage msg);
    void visit(SetPapalsMessage msg);

    //Client to server
    void visit(RestartAnswerMessage msg);
    void visit(ActivateLeaderCardMessage msg);
    void visit(BaseProductionOnMessage msg);
    void visit(BuyProductionCardMessage msg);
    void visit(DiscardLeaderCardMessage msg);
    void visit(DoubleProductionOnMessage msg);
    void visit(EndOfProductionMessage msg);
    void visit(ExitMessage msg);
    void visit(ExtraProductionOnMessage msg);
    void visit(InitialResourcesMessage msg);
    void visit(KeepLeaderCardsMessage msg);
    void visit(KeepResourcesMessage msg);
    void visit(NumberPlayerMessage msg);
    void visit(ProductionOnMessage msg);
    void visit(PushColumnMessage msg);
    void visit(PushRowMessage msg);
    void visit(UsernameMessage msg);
    void visit(WhiteMarbleChoosenResourcesMessage msg);

    //General messages
    void visit(PingMessage msg);
    void visit(PongMessage msg);
    void visit(OkMessage msg);


    //Observer
    void visit(DeckProductionCardMessage msg);
    void visit(DeckProductionCardConfigMessage msg);

}
