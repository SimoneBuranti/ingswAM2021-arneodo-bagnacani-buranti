package it.polimi.ingsw;

import java.util.ArrayList;
/**
 * this class represents the game multiPlayer
 */

public class GameMultiPlayer extends Game {
    private int numberOfPlayer;
    Player currentPlayer;

    private ArrayList<Player> playerList;

    /**
     * this is the constructor for the class
     * @param numberOfPlayer
     */
    public GameMultiPlayer(int numberOfPlayer){

        this.numberOfPlayer=numberOfPlayer;
        playerList = new ArrayList<Player>();
        createPlayer(numberOfPlayer); }
    /**
     * method which return number of participant in game
     */

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }
    /**
     * this is the constructor for the players
     * @param numberOfPlayer
     *
     */

    private void createPlayer(int numberOfPlayer){
        if (numberOfPlayer==1) {
            playerFirst = new PlayerFirst();
            playerList.add(playerFirst);

        }
        else if (numberOfPlayer==2)
        {
            playerFirst= new PlayerFirst();
            playerSecond=new PlayerSecond();
            playerList.add(playerFirst);
            playerList.add(playerSecond);
        }
        else if (numberOfPlayer==3)
        {
            playerFirst= new PlayerFirst();
            playerSecond=new PlayerSecond();
            playerThird= new PlayerThird();
            playerList.add(playerFirst);
            playerList.add(playerSecond);
            playerList.add(playerThird);

        }
        else
        {
            playerFirst= new PlayerFirst();
            playerSecond=new PlayerSecond();
            playerThird= new PlayerThird();
            playerFourth= new PlayerFourth();
            playerList.add(playerFirst);
            playerList.add(playerSecond);
            playerList.add(playerThird);
            playerList.add(playerFourth);
        }}








}
