package it.polimi.ingsw.client.ligtModelNotification;

/**
 * This interface contains the visit method of each notification to be implemented in the visitor classes (Cli and Gui)
 */
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

    void visit(LorenzoNotification lorenzoNotification);
}
