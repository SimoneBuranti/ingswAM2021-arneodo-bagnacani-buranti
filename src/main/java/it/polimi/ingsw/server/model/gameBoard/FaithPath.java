package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;

/**
 * This class represents the faith track of a player's personal board
 */
public class FaithPath {

    /**
     * UNDEFINED is the conventional int value for unassigned papal card
     */
    private static final int  UNDEFINED = -1;

    /**
     * PAPAL_N represents how many papal positions there are in the faith path
     */
    private static final int PAPAL_N = 3;

    /**
     * PAPAL_CARDS contains papal cards scores
     */
    private static final int[] PAPAL_CARDS = {2,3,4};

    /**
     * PAPAL_POS indicates papal events checkpoints in the path
     */
    private static final int[] PAPAL_POS = {8,16,24};

    /**
     * VATICAN_POS indicates the first vatican space position for each vatican space
     */
    private static final int[] VATICAN_POS = {5,12,19};

    /**
     * POSITION_SCORES collects the path score for each position
     */
    private static final int[] POSITION_SCORES = {0,0,0,1,1,1,2,2,2,4,4,4,6,6,6,9,9,9,12,12,12,16,16,16,20};

    /**
     * faithIndicator is the player current position on faithPath
     */
    private int faithIndicator;

    /**
     * papalCards shows which cards have been gained by the player
     */
    private final int[] papalCards;

    /**
     * currCall represents the common actual vatican event in the match
     */
    private int currCall;

    /**
     * Constructor for standard faithPath state
     */
    public FaithPath() {
        this.faithIndicator = 0;
        this.papalCards = new int[]{UNDEFINED, UNDEFINED, UNDEFINED};
        this.currCall = 0;
    }

    /**
     * This method increases faithIndicator counter one at a time within faithPath length restrictions
     * If the player moves on a papal event checkpoint position a CallForCouncilException is thrown
     * and it will be handled by Game which will manage papal cards of each player
     * If the papal event checkpoint reached is the last a LastSpaceReachedException is thrown
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     */
    public void move() throws CallForCouncilException, LastSpaceReachedException {

        if (faithIndicator < PAPAL_POS[PAPAL_N-1])
            faithIndicator++;

        if (currCall < (PAPAL_N-1) && faithIndicator == PAPAL_POS[currCall])
            throw new CallForCouncilException();
        else if ( currCall == PAPAL_N-1 && faithIndicator == PAPAL_POS[currCall])
            throw new LastSpaceReachedException();
    }


    /**
     * This method checks the current position compared with the current vatican space
     * and the related papal cards will be assigned or not depending on player position
     * It also increases the currCall attribute
     */
    public void setPapal() {

        if (VATICAN_POS[currCall] <= faithIndicator) {
            papalCards[currCall] = 1;
        } else
            papalCards[currCall] = 0;

        this.currCall++;
    }

    /**
     * This method returns the overall faithPath score (at any time of the game)
     * @return int : the overall faithPath score
     */
    public int faithScore() {
        int cont = 0;

        for (int i = 0; i < PAPAL_N; i++)
            if (papalCards[i] != UNDEFINED)
                cont += papalCards[i] * PAPAL_CARDS[i];

        return cont + POSITION_SCORES[faithIndicator];
    }

    /**
     * Test only method: getter method for the current position of the faithIndicator
     * @return int : current position of the faithIndicator
     */
    public int getIndicator() {
        return this.faithIndicator;
    }

    /**
     * Test only method: getter method for the currCall attribute
     * @return int : the current value of the currCall attribute
     */
    public int getCurrCall() {
        return this.currCall;
    }

    /**
     * Test only method: getter method to show if the papal card in papalCardNumber position has been gained or not
     * @param papalCardNumber : the position of the papal card
     * @return int : 1 if the card has been gained, 0 if the card has not been gained, -1 if no player has reached the papal space
     */
    public int getPapalCard(int papalCardNumber){
        return papalCards[papalCardNumber];
    }

}
