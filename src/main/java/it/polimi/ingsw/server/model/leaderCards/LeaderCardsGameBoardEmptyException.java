package it.polimi.ingsw.server.model.leaderCards;

/**
 * This exception is thrown when there are no unactivated leader cards on a player's board
 * and the player wants to discard or activate a leader card
 */
public class LeaderCardsGameBoardEmptyException extends Exception {
}
