package it.polimi.ingsw.lightModel.lightGameBoard;


public class LightFaithPath {
    /**
     * UNDEFINED is the conventional int value for unassigned papal card
     */
    private static final int  UNDEFINED = -1;

    /**
     * VATICAN_POS indicates the first vatican space position for each vatican space
     */
    private static final int[] VATICAN_POS = {5,12,19};

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
    public LightFaithPath() {
        this.faithIndicator = 0;
        this.papalCards = new int[]{UNDEFINED, UNDEFINED, UNDEFINED};
        this.currCall = 0;
    }

    public void setFaithPath(int faithIndicator, int currCall){
        this.faithIndicator = faithIndicator;
        this.currCall = currCall;
    }

    /**
     * This method increases faithIndicator counter one at a time within faithPath length restrictions
     * If the player moves on a papal event checkpoint position a CallForCouncilException is thrown
     * and it will be handled by Game which will manage papal cards of each player
     */
    public void move(int pos){
        faithIndicator = faithIndicator + pos;
    }


    /**
     * This method checks the current position compared with the current vatican space
     * and the related papal cards will be assigned or not depending on player position
     * It also increases the currCall attribute
     */
    public void setPapal(int currCall) {

        if (VATICAN_POS[currCall] <= faithIndicator) {
            papalCards[currCall] = 1;
        } else
            papalCards[currCall] = 0;

        this.currCall = currCall + 1;
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
