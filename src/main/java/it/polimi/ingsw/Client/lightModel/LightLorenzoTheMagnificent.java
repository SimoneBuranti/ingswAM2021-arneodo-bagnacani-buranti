package it.polimi.ingsw.Client.lightModel;

public class LightLorenzoTheMagnificent {
    /**
     * faithIndicator is the black cross current position on faithPath
     */
    private int faithIndicator;

    /**
     * this constructor initializes faithIndicator and currCall attributes to zero
     */
    public LightLorenzoTheMagnificent() {
        this.faithIndicator = 0;
    }

    public void setLightLorenzoTheMagnificent(int faithIndicator) {
        this.faithIndicator = faithIndicator;
    }

    /**
     *  this method increases the faithIndicator counter by one and
     *  if the counter is located on the current papal space the method throws an CallForCouncilException
     *  if instead the counter is located on the last papal space it throws an EndOfSolitaireGame,
     *  which means that the player has lost
     */
    public void moveBlackCross(){
        faithIndicator++;
    }

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
