package it.polimi.ingsw;

public class FaithPath {

    private static final int  UNDEFINED = -1;
    private static final int PAPAL_N = 3;
    private static final int[] PAPAL_CARDS = {2,3,4};
    private static final int[] PAPAL_POS = {8,16,24};
    private static final int[] VATICAN_POS = {5,12,19};
    private static final int[] POSITION_SCORES = {0,0,0,1,1,1,2,2,2,4,4,4,6,6,6,9,9,9,12,12,12,16,16,16,20};

    private int faithIndicator;
    private final int[] papalCards;


    private int currCall;
    //private Game game;

    public FaithPath() {
        this.faithIndicator = 0;
        this.papalCards = new int[]{UNDEFINED, UNDEFINED, UNDEFINED};
        this.currCall = 0;
        //this.game = game
    }

    public FaithPath(int initPosition) {
        this.faithIndicator = initPosition;
        this.papalCards = new int[]{UNDEFINED, UNDEFINED, UNDEFINED};
        this.currCall = 0;
    }

    public int getIndicator() {

        return this.faithIndicator;
    }

    public int getCurrCall() {
        return this.currCall;
    }

    public int getPapalCard(int papalCardNumber){
        return papalCards[papalCardNumber];
    }


    public void move() throws CallForCouncilException {

        if (faithIndicator < PAPAL_POS[PAPAL_N-1])
            faithIndicator++;

        if (currCall < PAPAL_N && faithIndicator == PAPAL_POS[currCall])
            throw new CallForCouncilException();

    }


    public void setPapal() {

        if (VATICAN_POS[currCall] <= faithIndicator && faithIndicator <= PAPAL_POS[currCall]) {
            papalCards[currCall] = 1;
        } else
            papalCards[currCall] = 0;

        this.currCall++;
    }


    public int faithScore() {
        int cont = 0;

        for (int i = 0; i < PAPAL_N; i++)
            if (papalCards[i] != UNDEFINED)
                cont += papalCards[i] * PAPAL_CARDS[i];

        return cont + POSITION_SCORES[faithIndicator];
    }


}
