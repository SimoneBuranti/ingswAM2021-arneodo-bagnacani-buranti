package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.EndGameException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.players.*;

import java.util.ArrayList;
/**
 * this class represents the game multi player
 */
public class GameMultiPlayer extends Game {

    /**
     * this attribute represents the number of player
     */
    private final int numberOfPlayer;

    /**
     * this attribute represents the first player
     */
    PlayerFirst firstPlayer;
    /**
     * this attribute represents the second player
     */
    PlayerSecond secondPlayer;
    /**
     * this attribute represents the third player
     */
    PlayerThird thirdPlayer;
    /**
     * this attribute represents the fourth player
     */
    PlayerFourth fourthPlayer;

    /**
     * this attribute represents the inkwell given to the first player in intestate
     */
    private final int inkwell;

    /**
     * this attribute represents the boolean which indicates the last turn or not
     */
    private boolean lastTurn = false;


    /**
     * this attribute represents nickNameInOrder which indicates players in order, giving importance only to nickname
     */
    private ArrayList<String> nickNameInOrder = new ArrayList<>();


    /**
     * this attribute represents nickNameInOrder which indicates players in order, giving importance to player type
     */
    private ArrayList<Player> playerList = new ArrayList<>();


    /**
     * this attribute represents currentPlayerPosition on playerList
     */
    private int currentPlayerPosition = 0;

    /**
     * this is the constructor for the class
     * @param numberOfPlayer : the number of players in the game
     * @param nickName : the collection of players' nicknames
     */
    public GameMultiPlayer(int numberOfPlayer, ArrayList<String> nickName){
        super();
        this.playerList= new ArrayList<>();
        this.numberOfPlayer=numberOfPlayer;
        inkwell=createRandomNumber(numberOfPlayer);
        nickNameInOrder=correctOrder(nickName,inkwell);
        createPlayer(numberOfPlayer,nickNameInOrder);
        currentPlayer = playerList.get(currentPlayerPosition);
    }

    /**
     * this method returns the number of participant in the game
     */
    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    /**
     * this method creates all the players in the game starting from the number of players and their nicknames
     * @param numberOfPlayer : the number of players in the game
     * @param nickNameInOrder : collection of players' nicknames already sorted according to the random assignment of the inkwell
     */
    private void createPlayer(int numberOfPlayer,ArrayList<String> nickNameInOrder){
       if (numberOfPlayer==2)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0), this);
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1), this);
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
        }

        else if (numberOfPlayer==3)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0),this);
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1),this);
            thirdPlayer= new PlayerThird(nickNameInOrder.get(2),this);
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
            playerList.add(thirdPlayer);

        }
       else if (numberOfPlayer==4)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0),this);
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1),this);
            thirdPlayer= new PlayerThird(nickNameInOrder.get(2),this);
            fourthPlayer=new PlayerFourth(nickNameInOrder.get(3),this);
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
            playerList.add(thirdPlayer);
            playerList.add(fourthPlayer);

        }

    }


    /**
     * this method sets the new current player at the end of old current player turn
     */
    public void setCurrentPlayer() {
        if(currentPlayerPosition == numberOfPlayer-1)
            currentPlayerPosition = 0;
        else
            currentPlayerPosition += 1;

        currentPlayer = playerList.get(currentPlayerPosition);
    }


    /**
     * this method returns the player at index position
     * @param index : the position in the playerList
     * @return Player : the player at index position
     */
    public Player getPlayerFromList(int index){
        return playerList.get(index);
    }


    /**
     * this method returns a random number between zero and the number of players that is assigned to the inkwell in the constructor
     * @param numberOfPlayer : the number of players in the game
     * @return int : the position of the player with the inkwell in the list of nicknames to sort
     */
    public int createRandomNumber(int numberOfPlayer){
        return (int) (Math.random() * (numberOfPlayer));
    }


    /**
     * this method returns the player's nicknameList in order according to the value of the inkwell
     * @param nickName : the list of nickNames to sort
     * @param inkwell : the position in the list to be sorted of the first player on the sorted list
     * @return ArrayList<String> : ordered list of nickNames
     */
    private ArrayList<String> correctOrder(ArrayList<String> nickName,int inkwell){

        for(int i=inkwell; i<nickName.size();i++)
                nickNameInOrder.add(nickName.get(i));
        for(int i=0; i<inkwell;i++)
            nickNameInOrder.add(nickName.get(i));

        return  nickNameInOrder;}

    /**
     * method called when the player discards a resource,it moves the faith indicator of all players except the one
     * passed as a parameter forward one position on the faith path.
     * If CallForCouncilException or LastSpaceReachedException is caught it calls the exceptionHandler method to handle it
     * @param player : the one who discards the resource
     */
    @Override
    public void moveEveryoneExcept(Player player){
        for(Player p : playerList){
            if (p != player) {
                try {
                    p.faithMove();
                } catch (CallForCouncilException e1) {
                    exceptionHandler(e1);
                } catch (LastSpaceReachedException e2) {
                    exceptionHandler(e2);
                }
            }
        }
    }


    /**
     * this method handles the CallForCouncilException by calling the method of all players
     * for assigning papal cards and incrementing the currCall counter
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(CallForCouncilException e) {
        for(Player p : playerList){
            p.setPapal();
        }
    }


    /**
     * this method handles the CallForCouncilException by calling the method of all players
     * for assigning papal cards and incrementing the currCall counter and by setting the lastTurn attribute to true
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(LastSpaceReachedException e) {
        for(Player p : playerList){
            p.setPapal();
        }

        lastTurn = true;
    }


    /**
     * this method handles the CallForCouncilException by setting the lastTurn attribute to true
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(EndGameException e) {
        lastTurn = true;
    }


    /**
     * method called when the game is over, it calculates the score of all players and returns the winner
     * @return Player : the player with the highest score
     */
    public Player theWinnerIs(){
        Player playerWinner;
        playerWinner=playerList.get(0);
        for(Player p : playerList){
            if(p.playerScore()>playerWinner.playerScore() && !p.equals(playerList.get(0)))
                playerWinner=p;
            else if(p.playerScore()==playerWinner.playerScore() && p.getGameBoardOfPlayer().scoreResource()>playerWinner.getGameBoardOfPlayer().scoreResource() && !p.equals(playerList.get(0)))
                playerWinner=p;
        }
        return playerWinner;
    }

}