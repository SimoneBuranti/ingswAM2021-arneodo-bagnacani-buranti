package it.polimi.ingsw.client.ligtModelNotification;

import it.polimi.ingsw.messages.observable.PapalCardsConfigMessage;

public interface NotificatorVisitor {

    void visit(DeckListNotification deckListNotification);

    void visit(GameboardListNotification gameboardListNotification);

    void visit(LeaderListCardNotification leaderListCardNotification);

    void visit(StorageNotification storageNotification);

    void visit(StrongboxNotification strongboxNotification);

    void visit(ReserveNotification reserveNotification);

    void visit(MarketNotification marketNotification);

    void visit(ExtraMarketNotification extraMarketNotification);

    void visit(FaithPathNotification faithPathNotification);

    void visit(InitLeaderNotification initLeaderNotification);

    void visit(ActivateLeaderNotification activateLeaderNotification);

    void visit(DiscardLeaderNotification discardLeaderNotification);

    void visit(PapalCardsConfigNotification papalCardsConfigNotification);
}
