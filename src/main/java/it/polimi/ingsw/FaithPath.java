package it.polimi.ingsw;

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
     *@return FaithPath
     */
    public FaithPath() {
        this.faithIndicator = 0;
        this.papalCards = new int[]{UNDEFINED, UNDEFINED, UNDEFINED};
        this.currCall = 0;
    }

    /**
     * Specific constructor for third and fourth players
     *@return FaithPath
     */
    public FaithPath(int initPosition) {
        this.faithIndicator = initPosition;
        this.papalCards = new int[]{UNDEFINED, UNDEFINED, UNDEFINED};
        this.currCall = 0;
    }

    /**
     * getter for tests
     * @return int
     */
    public int getIndicator() {
        return this.faithIndicator;
    }

    /**
     * getter for tests
     * @return int
     */
    public int getCurrCall() {
        return this.currCall;
    }

    /**
     * getter for tests
     * @return int
     */
    public int getPapalCard(int papalCardNumber){
        return papalCards[papalCardNumber];
    }


    /**
     * move() method increases faithIndicator counter one at a time within faithPath length restrictions
     * If the player moves on a papal event checkpoint position a CallForCouncilException is thrown
     * and it will be handled by Game which will manage papal cards of each player
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
     * setPapal() checks the current position compared with the current vatican space
     * and the related papal cards will be assigned or not depending on player position
     */
    public void setPapal() {

        if (VATICAN_POS[currCall] <= faithIndicator && faithIndicator <= PAPAL_POS[currCall]) {
            papalCards[currCall] = 1;
        } else
            papalCards[currCall] = 0;

        this.currCall++;
    }

    /**
     * faithScore() returns the overall faithPath score (at any time of the game)
     * @return int
     */
    public int faithScore() {
        int cont = 0;

        for (int i = 0; i < PAPAL_N; i++)
            if (papalCards[i] != UNDEFINED)
                cont += papalCards[i] * PAPAL_CARDS[i];

        return cont + POSITION_SCORES[faithIndicator];
    }


}
