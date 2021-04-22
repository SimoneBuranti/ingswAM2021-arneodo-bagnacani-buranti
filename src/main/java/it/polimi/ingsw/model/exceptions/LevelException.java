package it.polimi.ingsw.model.exceptions;

/**
 * This exception is thrown when a player wants to buy a production card
 * but the first free position in the chosen column of the board does not coincide with the level of the card
 */
public class LevelException extends Exception {
}
