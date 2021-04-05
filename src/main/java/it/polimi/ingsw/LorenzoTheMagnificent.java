package it.polimi.ingsw;

/**
 * this class represents the faith indicator of Lorenzo the magnificent for the game in solitary
 */
public class LorenzoTheMagnificent{
    /**
     * PAPAL_N represents how many papal positions there are in the faith path
     */
    private static final int PAPAL_N = 3;
    /**
     * PAPAL_POS indicates papal events checkpoints in the path
     */
    private static final int[] PAPAL_POS = {8,16,24};
    /**
     * faithIndicator is the black cross current position on faithPath
     */
    private int faithIndicator;
    /**
     * currCall represents the common actual vatican event in the match
     */
    private int currCall;


    /**
     * this constructor initializes faithIndicator and currCall attributes to zero
     *@return FaithPath
     */
    public LorenzoTheMagnificent() {
        this.faithIndicator = 0;
        this.currCall = 0;
    }

    /**
     * this method increases the faithIndicator counter by one and
     * if the counter is located on the current papal space the method throws an CallForCouncilException
     * @throws CallForCouncilException
     */
    public void moveBlackCross() throws CallForCouncilException{
        faithIndicator++;
        if (currCall < PAPAL_N && faithIndicator == PAPAL_POS[currCall])
            throw new CallForCouncilException();
    }

    /**
     * this method increases the currCall counter by one and
     * if the counter is equal to the PAPAL_N attribute the method throws an EndOfSolitaireGame exception
     * @throws EndOfSolitaireGame
     */
    public void setCurrCall() throws EndOfSolitaireGame {
        currCall++;
        if(currCall == PAPAL_N)
            throw new EndOfSolitaireGame();
    }

    /**
     * getter of the faith indicator of Lorenzo the magnificent
     * @return int : faithIndicator counter
     */
    public int getFaithIndicator(){
        return faithIndicator;
    }

    /**
     * getter of the current papal space
     * @return int : currCall counter
     */
    public int getCurrCall() {
        return currCall;
    }
}
