package it.polimi.ingsw.client;

import it.polimi.ingsw.messages.*;

public class ViewController implements MessageVisitor {
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
    public void visit(EndGameMessage msg) {

    }

    @Override
    public void visit(EndOfTurnMessage msg) {

    }

    @Override
    public void visit(LastTurnMessage msg) {

    }

    @Override
    public void visit(LorenzoActionMessage msg) {

    }

    @Override
    public void visit(OpponentActivateLeaderCardMessage msg) {

    }

    @Override
    public void visit(OpponentDiscardLeaderCardMessage msg) {

    }

    @Override
    public void visit(OpponentFaithMoveMessage msg) {

    }

    @Override
    public void visit(OpponentBuyProductionCardMessage msg) {

    }

    @Override
    public void visit(ReserveValueMessage msg) {

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
    public void visit(ActivateLeaderCardMessage msg) {

    }

    @Override
    public void visit(BaseProductionOnMessage msg) {

    }

    @Override
    public void visit(BuyProductionCardMessage msg) {

    }

    @Override
    public void visit(DiscardLeaderCardMessage msg) {

    }

    @Override
    public void visit(DoubleProductionOnMessage msg) {

    }

    @Override
    public void visit(EndOfProductionMessage msg) {

    }

    @Override
    public void visit(ExitMessage msg) {

    }

    @Override
    public void visit(ExtraProductionOnMessage msg) {

    }

    @Override
    public void visit(InitialResourcesMessage msg) {

    }

    @Override
    public void visit(KeepLeaderCardsMessage msg) {

    }

    @Override
    public void visit(KeepResourcesMessage msg) {

    }

    @Override
    public void visit(NumberPlayerMessage msg) {

    }

    @Override
    public void visit(ProductionOnMessage msg) {

    }

    @Override
    public void visit(PushColumnMessage msg) {

    }

    @Override
    public void visit(PushRowMessage msg) {

    }

    @Override
    public void visit(UsernameMessage msg) {

    }

    @Override
    public void visit(WhiteMarbleChoosenResourcesMessage msg) {

    }

    /*@Override
    public void visit(OkMessage msg) {

    }*/

    @Override
    public void visit(PingMessage msg) {

    }

    @Override
    public void visit(PongMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardMessage msg) {

    }

    @Override
    public void visit(DeckProductionCardConfigMessage msg) {

    }
}
