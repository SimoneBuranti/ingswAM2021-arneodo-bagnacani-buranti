package it.polimi.ingsw.client.lightModel;

/**
 * This class represent the indicator of Lorenzo the Magnificent of the light model
 */
public class LightLorenzoTheMagnificent {
    /**
     * faithIndicator is the black cross current position on faithPath
     */
    private int faithIndicator;

    /**
     * this constructor initializes faithIndicator to zero
     */
    public LightLorenzoTheMagnificent() {
        this.faithIndicator = 0;
    }

    /**
     * this constructor initializes faithIndicator to the number passed as a parameter
     */
    public void setLightLorenzoTheMagnificent(int faithIndicator) {
        this.faithIndicator = faithIndicator;
    }

    /**
     *  this method increases the faithIndicator counter by one
     */
    public void moveBlackCross(){
        faithIndicator++;
    }

    /**
     *  this method increases the faithIndicator counter by two
     */
    public void moveBlackCrossDouble(){
        faithIndicator += 2;
    }

    /**
     * getter of the faith indicator of Lorenzo the magnificent
     * @return int : faithIndicator counter
     */
    public int getFaithIndicator(){
        return faithIndicator;
    }

}
