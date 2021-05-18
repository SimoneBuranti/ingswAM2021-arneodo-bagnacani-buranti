package it.polimi.ingsw.Client.View.LigtModelNotification;

public interface NotificatorVisitor {

    void visit(DeckListNotification deckListNotification);

    void visit(GameboardListNotification gameboardListNotification);

    void visit(LeaderListCardNotification leaderListCardNotification);

    void visit(StorageNotification storageNotification);

    void visit(StrongboxNotification strongboxNotification);

    void visit(ReserveNotification reserveNotification);

    void visit(MarketNotification marketNotification);

    void visit(ExtraMarketNotification extraMarketNotification);

    void visit(ActivateNotification activateNotification);

    void visit(FaithPathNotification faithPathNotification);
}
