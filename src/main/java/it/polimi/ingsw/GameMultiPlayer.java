package it.polimi.ingsw;

import java.util.ArrayList;
/**
 * this class represents the game multiPlayer
 */

public class GameMultiPlayer extends Game {
    private int numberOfPlayer;
    private Player currentPlayer;
    PlayerFirst firstPlayer;
    PlayerSecond secondPlayer;
    PlayerThird thirdPlayer;
    PlayerFourth fourthPlayer;
    private int calamaio;
    private ArrayList<String> nickNameInOrder= new ArrayList<>();




    private ArrayList<Player> playerList;

    /**
     * this is the constructor for the class
     * @param numberOfPlayer
     */
    public GameMultiPlayer(int numberOfPlayer, ArrayList<String> nickName){
        super();
        this.playerList= new ArrayList<Player>();
        this.numberOfPlayer=numberOfPlayer;
        calamaio=createRandomNumber(numberOfPlayer);
        nickNameInOrder=correctOrder(nickName,calamaio);
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
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0));
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1));
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
        }

        else if (numberOfPlayer==3)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0));
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1));
            thirdPlayer= new PlayerThird(nickNameInOrder.get(2));
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
            playerList.add(thirdPlayer);



        }
       else if (numberOfPlayer==4)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0));
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1));
            thirdPlayer= new PlayerThird(nickNameInOrder.get(2));
            fourthPlayer=new PlayerFourth(nickNameInOrder.get(3));
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


    public Player getPlayerFromList(int index){
        return playerList.get(index);
    }


    public int createRandomNumber(int numberOfPlayer){
        int n = (int) (Math.random() * (numberOfPlayer));
        return n;
    }


    private ArrayList<String> correctOrder(ArrayList<String> nickName,int calamaio){

        for(int i=calamaio; i<nickName.size();i++)
                nickNameInOrder.add(nickName.get(i));
        for(int i=0; i<calamaio;i++)
            nickNameInOrder.add(nickName.get(i));

        return  nickNameInOrder;}



}
