package it.polimi.ingsw;

import java.util.ArrayList;
/**
 * this class represents the game multiPlayer
 */

public class GameMultiPlayer extends Game {
    private final int numberOfPlayer;
    PlayerFirst firstPlayer;
    PlayerSecond secondPlayer;
    PlayerThird thirdPlayer;
    PlayerFourth fourthPlayer;
    private final int inkwell;
    private boolean lastTurn = false;
    private ArrayList<String> nickNameInOrder = new ArrayList<>();
    private ArrayList<Player> playerList = new ArrayList<>();

    /**
     * this is the constructor for the class
     * @param numberOfPlayer
     */
    public GameMultiPlayer(int numberOfPlayer, ArrayList<String> nickName){
        super();
        this.playerList= new ArrayList<>();
        this.numberOfPlayer=numberOfPlayer;
        inkwell=createRandomNumber(numberOfPlayer);
        nickNameInOrder=correctOrder(nickName,inkwell);
        createPlayer(numberOfPlayer,nickNameInOrder);

    }

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
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    /**
     * method which return the player at index position
     * @param index
     * @return playerList.get(index)
     */
    public Player getPlayerFromList(int index){
        return playerList.get(index);
    }


    /**
     * @param numberOfPlayer
     * @return n = (int) (Math.random() * (numberOfPlayer) a random number from 0 to numberOfPlayer -1
     */
    public int createRandomNumber(int numberOfPlayer){
        return (int) (Math.random() * (numberOfPlayer));
    }


    /**
     * method which return the nicknameList of player in order
     * @param nickName
     * @param inkwell
     * @return nickNameInOrder
     */
    private ArrayList<String> correctOrder(ArrayList<String> nickName,int inkwell){

        for(int i=inkwell; i<nickName.size();i++)
                nickNameInOrder.add(nickName.get(i));
        for(int i=0; i<inkwell;i++)
            nickNameInOrder.add(nickName.get(i));

        return  nickNameInOrder;}

    /**
     * method called when one of the players discard Resources
     * @param player
     *
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

    @Override
    protected void exceptionHandler(CallForCouncilException e) {
        for(Player p : playerList){
            p.setPapal();
        }
    }

    @Override
    protected void exceptionHandler(LastSpaceReachedException e) {
        for(Player p : playerList){
            p.setPapal();
        }

        lastTurn = true;
    }

    @Override
    protected void exceptionHandler(EndGameException e) {
        lastTurn = true;
    }


    /**
     * method called when game is finished
     * @return playerWinner
     */
    public Player theWinnerIs(){
        Player playerWinner;
        playerWinner=playerList.get(0);
        for(Player p : playerList){
            if(p.getScore()>playerWinner.getScore() && !p.equals(playerList.get(0)))
                playerWinner=p;
            else if(p.getScore()==playerWinner.getScore() && p.getGameBoardOfPlayer().scoreResource()>playerWinner.getGameBoardOfPlayer().scoreResource() && !p.equals(playerList.get(0)))
                playerWinner=p;
        }
        return playerWinner;
    }

}
