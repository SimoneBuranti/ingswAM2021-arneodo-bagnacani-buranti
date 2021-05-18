package it.polimi.ingsw.server.model;

import com.google.gson.Gson;
import it.polimi.ingsw.observer.Observable;
import it.polimi.ingsw.messages.observable.LorenzoTheMagnificentConfigMessage;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class represents the faith indicator of Lorenzo the magnificent for the game in solitary
 */
public class LorenzoTheMagnificent extends Observable {
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
     */
    public LorenzoTheMagnificent() {
        this.faithIndicator = 0;
        this.currCall = 0;
    }

    /**
     *  this method increases the faithIndicator counter by one and
     *  if the counter is located on the current papal space the method throws an CallForCouncilException
     *  if instead the counter is located on the last papal space it throws an EndOfSolitaireGame,
     *  which means that the player has lost
     * @throws CallForCouncilException : the exception that is thrown when the player reaches a papal space in the faithPath
     * @throws EndOfSolitaireGame : the exception which is thrown when the black cross reaches the last papal space and
     *                               and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void moveBlackCross() throws CallForCouncilException, EndOfSolitaireGame{
        faithIndicator++;

        if (currCall < PAPAL_N-1 && faithIndicator == PAPAL_POS[currCall] )
            throw new CallForCouncilException();
        else if(currCall == PAPAL_N-1 && faithIndicator == PAPAL_POS[currCall])
            throw new EndOfSolitaireGame();

    }

    /**
     * this method increases the currCall counter by one
     */
    public void setCurrCall(){
        currCall++;
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


    /**
     * save information for a possible restart game
     */
    public void saveInformationOfLorenzo(){
        Gson gson=new Gson();
        ArrayList<Integer> servList = new ArrayList<>(2);
        servList.add(faithIndicator);
        servList.add(currCall);
        FileWriter config = null;
        String jsonStrin = gson.toJson(servList);
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            config = new FileWriter("src/main/resources/LoriMagnific.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            } } }




    public LorenzoTheMagnificent(int[] list) throws IOException, InterruptedException {
        faithIndicator=list[0];
        currCall=list[1];
        notifyObserver(new LorenzoTheMagnificentConfigMessage(faithIndicator));
    }








}

