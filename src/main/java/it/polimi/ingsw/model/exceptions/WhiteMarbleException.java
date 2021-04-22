package it.polimi.ingsw.model.exceptions;

/**
 * This exception is thrown when a player has activated two white marble-type leader cards
 * and has obtained white marbles from the market
 */
public class WhiteMarbleException extends Exception {
    /**
     * This attribute indicates the number of WhiteMarbleException thrown during a market action
     */
    int n;

    /**
     * This constructor initializes the n attribute to the value passed as a parameter
     * @param n : the initial value of n
     */
    public WhiteMarbleException(int n){
        this.n = n;
    }

    /**
     * This method increases the n attribute
     */
    public void increase() {
        n++;
    }

    /**
     * This method return the value of the n attribute
     * @return int : the value of the n attribute
     */
    public int getN(){
        return n;
    }
}
