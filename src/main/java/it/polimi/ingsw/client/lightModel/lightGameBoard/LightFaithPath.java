package it.polimi.ingsw.client.lightModel.lightGameBoard;

/**
 * This class represents the faith path of the light model
 */
public class LightFaithPath {
    /**
     * UNDEFINED is the conventional int value for unassigned papal card
     */
    private static final int  UNDEFINED = -1;

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

    /**
     * This method sets the initial values of the faithIndicator and currCall attributes
     * @param faithIndicator : value of the faith indicator
     * @param currCall : value of the currCall indicator
     */
    public void setFaithPath(int faithIndicator, int currCall){
        this.faithIndicator = faithIndicator;
        this.currCall = currCall;
    }

    /**
     * This method moves the player's faith indicator to pos positions
     * @param pos : the number of positions to move forward the indicator
     */
    public void move(int pos){
        faithIndicator = faithIndicator + pos;
    }


    /**
     * This method sets the value of the papal card in the current position with the value passed as a parameter
     * and increases the currCall attribute
     * @param papalCard : the value to set
     */
    public void setPapal(int papalCard) {
        papalCards[currCall] = papalCard;
        currCall++;
    }

    /**
     * Getter method for the current position of the faithIndicator
     * @return int : current position of the faithIndicator
     */
    public int getIndicator() {
        return this.faithIndicator;
    }

    /**
     * Getter method for the currCall attribute
     * @return int : the current value of the currCall attribute
     */
    public int getCurrCall() {
        return this.currCall;
    }


    /**
     * This method returns the value of the papal card in papalCardNumber position
     * @param papalCardNumber : the position of the papal card
     * @return int : the value of the papal card
     */
    public int getPapalCard(int papalCardNumber){
        return papalCards[papalCardNumber];
    }


    /**
     * This method returns the values of the player's papal cards
     * @return int[] : the values of the player's papal cards
     */

    public int[] getPapalCards(){
        return papalCards;
    }


    /**
     * This method sets the initial values of the player's papal cards
     * @param papalCards : the initial values of the player's papal cards
     */
    public void setPapalCards(int[] papalCards) {
        int i = 0;
        while(i < 3){
            this.papalCards[i] = papalCards[i];
            i++;
        }
    }
}
