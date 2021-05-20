package it.polimi.ingsw.server.model;

import com.google.gson.Gson;
import it.polimi.ingsw.messages.SetPapalsMessage;
import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.EndGameException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardProduction;
import it.polimi.ingsw.server.model.players.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * this class represents the game multi player
 */
public class GameMultiPlayer extends Game {

    /**
     * this attribute represents the number of player
     */
    private int numberOfPlayer;

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
    private int inkwell;

    /**
     * this attribute represents the boolean which indicates the last turn or not
     */
    private boolean lastTurn = false;


    /**
     * this attribute represents nickNameInOrder which indicates players in order, giving importance only to nickname
     */
    private ArrayList<ClientController> clientControllersInOrder = new ArrayList<>();


    /**
     * this attribute represents nickNameInOrder which indicates players in order, giving importance to player type
     */
    private ArrayList<Player> playerList = new ArrayList<>();


    /**
     * this attribute represents currentPlayerPosition on playerList
     */
    private int currentPlayerPosition = 0;
    private ArrayList<String> nickNameInOrder;

    /**
     * this is the constructor for the class
     * @param numberOfPlayer : the number of players in the game
     * @param nickName : the collection of players' nicknames
     * @param clientControllers
     */
    public GameMultiPlayer(int numberOfPlayer, ArrayList<String> nickName, Boolean newGame, ArrayList<ClientController> clientControllers) throws IOException, InterruptedException {
        super(newGame);
        if(newGame){
        this.playerList= new ArrayList<>(numberOfPlayer);
        this.numberOfPlayer=numberOfPlayer;
        inkwell=createRandomNumber(numberOfPlayer);
        clientControllersInOrder=correctOrder(clientControllers,inkwell);
        createPlayer(numberOfPlayer,clientControllersInOrder);
        currentPlayer = playerList.get(currentPlayerPosition);
        nickNameInOrder= new ArrayList<>();
        createNickNameInOrder(clientControllersInOrder);
        addObservators();
        notifyObserver(new GameTypeMessage(true));
        notifyObserver(new NicknameStartedMessage(nickNameInOrder));
        configClient();
        }
        else {
            restoreGameMultiPlayer(clientControllers);
        }
        saveInformation();
    }


    @Override
    public void configClient() throws IOException, InterruptedException {
        super.configClient();
    if (numberOfPlayer==2)
    {
        ArrayList<Integer> needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(firstPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader), firstPlayer.getNickName());

        needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(secondPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader), secondPlayer.getNickName());
    }

    else if (numberOfPlayer==3)
    {   ArrayList<Integer> needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(firstPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader), firstPlayer.getNickName());

        needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(secondPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader), secondPlayer.getNickName());

        needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(thirdPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader),thirdPlayer.getNickName());

    }
    else if (numberOfPlayer==4)
    {
        ArrayList<Integer> needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(firstPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader), firstPlayer.getNickName());

        needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(secondPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader), secondPlayer.getNickName());

        needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(thirdPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader),thirdPlayer.getNickName());

        needForLeader = new ArrayList<>();
        for (int i=0; i<4;i++)
            needForLeader.add(fourthPlayer.getPersonalLeaderCard().get(i).getKey());
        notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeader),fourthPlayer.getNickName());
    }

    //notifyToOneObserver(new YourTurnMessage());


}

    private void createNickNameInOrder(ArrayList<ClientController> clientControllers) {
        for(int i=0; i<numberOfPlayer;i++)
            nickNameInOrder.add(clientControllers.get(i).getNickname());
    }

    private void addObservators() {
        for(int i=0; i<numberOfPlayer;i++) {
            this.addObserver(clientControllersInOrder.get(i).getVirtualView());
        }
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

     */
    private void createPlayer(int numberOfPlayer,ArrayList<ClientController> clientControllersInOrder) throws IOException, InterruptedException {
       if (numberOfPlayer==2)
        {
            firstPlayer=new PlayerFirst(clientControllersInOrder.get(0).getNickname(),this,clientControllersInOrder.get(0).getVirtualView());
            secondPlayer= new PlayerSecond(clientControllersInOrder.get(1).getNickname(),this,clientControllersInOrder.get(1).getVirtualView());
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
             }

        else if (numberOfPlayer==3)
        {
            firstPlayer=new PlayerFirst(clientControllersInOrder.get(0).getNickname(),this,clientControllersInOrder.get(0).getVirtualView());
            secondPlayer= new PlayerSecond(clientControllersInOrder.get(1).getNickname(),this,clientControllersInOrder.get(1).getVirtualView());
            thirdPlayer= new PlayerThird(clientControllersInOrder.get(2).getNickname(),this,clientControllersInOrder.get(2).getVirtualView());
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
            playerList.add(thirdPlayer);
             }
       else if (numberOfPlayer==4)
        {
            firstPlayer=new PlayerFirst(clientControllersInOrder.get(0).getNickname(),this,clientControllersInOrder.get(0).getVirtualView());
            secondPlayer= new PlayerSecond(clientControllersInOrder.get(1).getNickname(),this,clientControllersInOrder.get(1).getVirtualView());
            thirdPlayer= new PlayerThird(clientControllersInOrder.get(2).getNickname(),this,clientControllersInOrder.get(2).getVirtualView());
            fourthPlayer=new PlayerFourth(clientControllersInOrder.get(3).getNickname(),this,clientControllersInOrder.get(3).getVirtualView());
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
        int cont;
        if(currentPlayerPosition == numberOfPlayer-1)
            cont = 0;
        else
            cont = currentPlayerPosition+1;

        while(!(playerList.get(cont).isConnected())){
            cont++;
            if(cont == numberOfPlayer)
                cont = 0;
            if(cont == currentPlayerPosition && !(playerList.get(cont).isConnected())){
                currentPlayer = null;
                return;
            }
        }
        currentPlayerPosition = cont;
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
    private ArrayList<ClientController> correctOrder(ArrayList<ClientController> nickName,int inkwell){

        for(int i=inkwell; i<nickName.size();i++)
            clientControllersInOrder.add(nickName.get(i));
        for(int i=0; i<inkwell;i++)
            clientControllersInOrder.add(nickName.get(i));

        return  clientControllersInOrder;
    }

    public ArrayList<String> getNickNameInOrder(){
        return nickNameInOrder;
    }

    /**
     * method called when the player discards a resource,it moves the faith indicator of all players except the one
     * passed as a parameter forward one position on the faith path.
     * If CallForCouncilException or LastSpaceReachedException is caught it calls the exceptionHandler method to handle it
     * @param player : the one who discards the resource
     */
    @Override
    public void moveEveryoneExcept(Player player) throws IOException, InterruptedException {
        for(Player p : playerList){
            if (p != player) {
                try {
                    p.faithMove();

                    notifyAllObserverLessOne(new FaithPathMessage(1));

                    notifyAllObserverLessOneByNickname(new FaithPathOpponentMessage(p.getNickName(), 1),p.getNickName());

                } catch (CallForCouncilException e1) {
                    exceptionHandler(e1);
                } catch (LastSpaceReachedException e2) {
                    exceptionHandler(e2);
                }
            }
        }
    }

    @Override
    public boolean disconnectPlayer(String nickname){
        for(Player p : playerList){
            if(p.getNickName().equals(nickname) && p.isConnected()){
                p.setConnected();
                return true;
            }
        }
        return false;
    }

    @Override
    public void connectPlayer(String nickname) throws IOException, InterruptedException {
        for(Player p : playerList){
            if(p.getNickName().equals(nickname) && !(p.isConnected())){
                p.setConnected();
                notifyOnlyOneSpecificObserver(new GameTypeMessage(true), p.getNickName());
                notifyOnlyOneSpecificObserver(new NicknameStartedMessage(nickNameInOrder), p.getNickName());
                configClientReconnected(p.getNickName());
                ArrayList<Integer> needForLeader = new ArrayList<>();
                ArrayList<Integer> needForLeader2 = new ArrayList<>();

                notifyOnlyOneSpecificObserver(new StorageConfigMessage(p.getGameBoardOfPlayer().getStorageOfGameBoard().getStorageResource()), p.getNickName());

                notifyOnlyOneSpecificObserver(new StrongboxConfigMessage(p.getGameBoardOfPlayer().getStrongboxOfGameBoard().getStrongBoxResource()), p.getNickName());


                for (int i=0; i<p.getGameBoardOfPlayer().getLeaderCards().size();i++)
                    needForLeader.add(p.getGameBoardOfPlayer().getLeaderCards().get(i).getKey());
                for (int i=0; i<p.getGameBoardOfPlayer().getLeaderCardsActivated().size();i++)
                    needForLeader2.add(p.getGameBoardOfPlayer().getLeaderCardsActivated().get(i).getKey());
                notifyOnlyOneSpecificObserver(new LeadercardconfigMessage(needForLeader,needForLeader2), p.getNickName());

                notifyOnlyOneSpecificObserver(new FaithConfigMessage(p.getGameBoardOfPlayer().getIndicator(),p.getGameBoardOfPlayer().getCurrCall()), p.getNickName());

                int[][] list = new int[3][3];
                for (int i=0; i<3;i++)
                    for (int j=0; i<3;i++)
                        if (p.getGameBoardOfPlayer().getDevelopmentBoardCell(i,j)==null)
                            list[i][j]=0;
                        else
                            list[i][j]=p.getGameBoardOfPlayer().getDevelopmentBoardCell(i,j).getKey();

                notifyOnlyOneSpecificObserver(new ProductionCardConfigMessage(list),p.getNickName());

                if(p.getGameBoardOfPlayer().getLeaderCardsActivated().size() != 0){
                    if (p.getGameBoardOfPlayer().getLeaderCardsActivated().get(0)!=null){
                        if(p.getGameBoardOfPlayer().getLeaderCardsActivated().get(0) instanceof LeaderCardProduction)
                            notifyOnlyOneSpecificObserver(new StorageExtraConfig(p.getGameBoardOfPlayer().getStorageOfGameBoard().getNumExtraFirstAvailable(),((LeaderCardProduction) p.getGameBoardOfPlayer().getLeaderCardsActivated().get(0)).getResourceProduction()), p.getNickName());
                    }
                    if(p.getGameBoardOfPlayer().getLeaderCardsActivated()!=null && p.getGameBoardOfPlayer().getLeaderCardsActivated().get(1)!=null){
                        if(p.getGameBoardOfPlayer().getLeaderCardsActivated().get(1) instanceof LeaderCardProduction)
                            notifyOnlyOneSpecificObserver(new StorageExtraDoubleConfig(p.getGameBoardOfPlayer().getStorageOfGameBoard().getNumExtraFirstAvailable(),((LeaderCardProduction) p.getGameBoardOfPlayer().getLeaderCardsActivated().get(1)).getResourceProduction()), p.getNickName());
                    }
                }
            }
        }
    }


    @Override
    public boolean checkNickname(String nickname){
        for(Player p : playerList){
            if(p.getNickName().equals(nickname) && !(p.isConnected())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int numPlayersDisconnected(){
        int num = 0;
        for(Player p : playerList){
            if(!(p.isConnected())){
                num++;
            }
        }
        return num;
    }

    /**
     * this method handles the CallForCouncilException by calling the method of all players
     * for assigning papal cards and incrementing the currCall counter
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(CallForCouncilException e) throws IOException, InterruptedException {
        for(Player p : playerList){
            p.setPapal();
        }
        notifyObserver(new SetPapalsMessage(e.getCurrCall(), e.getNickName()));
    }


    /**
     * this method handles the CallForCouncilException by calling the method of all players
     * for assigning papal cards and incrementing the currCall counter and by setting the lastTurn attribute to true
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(LastSpaceReachedException e) throws IOException, InterruptedException {
        for(Player p : playerList){
            p.setPapal();
        }
        notifyObserver(new SetPapalsMessage(e.getCurrCall(), e.getNickName()));
        lastTurn = true;
        notifyObserver(new LastTurnMessage(currentPlayer.getNickName()));
    }


    /**
     * this method handles the CallForC ouncilException by setting the lastTurn attribute to true
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(EndGameException e) throws IOException, InterruptedException {
        lastTurn = true;
        notifyObserver(new LastTurnMessage(currentPlayer.getNickName()));

    }


    /**
     * this method handles the CallForCouncilException by setting the lastTurn attribute to true
     * @param e : the exception to handle
     */
    protected void endOfLastTurn(EndGameException e) throws IOException, InterruptedException {
        endGame();
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



    /**
     * save information for a possible restart game
     */
    @Override
    public void saveInformation(){
       super.saveInformation();
        for(Player p : playerList){
            p.savePlayerInformation();
        }
        saveTypeMatch();
        saveInformationAboutTurn();
        saveInformationOfInkwel();
        saveInformationPlayerNumber();
        saveCurrentPosition();
        saveIfLastTurnOrNot();
    }



    private void saveInformationOfInkwel() { Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(inkwell);
        try {

            config = new FileWriter("src/main/resources/InformationAboutInkwell.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            } }
    }


    private void saveCurrentPosition() {
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(currentPlayerPosition);
        try {

            config = new FileWriter("src/main/resources/InformationAboutCurrentPosition.json");
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



    private void saveIfLastTurnOrNot() {
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(lastTurn);
        try {

            config = new FileWriter("src/main/resources/lastTurn.json");
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



            private void saveInformationAboutTurn() {
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(nickNameInOrder);
        try {
            config = new FileWriter("src/main/resources/InformationAboutTurn.json");
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




    /**
     * save information for a possible restart game
     */
    public void restoreGameMultiPlayer(ArrayList<ClientController> clientControllers) throws IOException, InterruptedException {
        restoreGameTurn(clientControllers);
    }


    /**
     * restore turn
     */
    public void restoreGameTurn(ArrayList<ClientController> clientControllers) throws IOException, InterruptedException {
        Gson gson=new Gson();

        try {
            nickNameInOrder = gson.fromJson(new FileReader("src/main/resources/InformationAboutTurn.json"),ArrayList.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            numberOfPlayer = gson.fromJson(new FileReader("src/main/resources/InformationAboutTurnPlayerNumber.json"),Integer.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            currentPlayerPosition= gson.fromJson(new FileReader("src/main/resources/InformationAboutCurrentPosition.json"),Integer.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
           lastTurn= gson.fromJson(new FileReader("src/main/resources/lastTurn.json"),Boolean.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.clientControllersInOrder=clientControllers;
        addObservators();
        notifyObserver(new GameTypeMessage(true));
        notifyObserver(new NicknameStartedMessage(nickNameInOrder));
        createPlayerRestore(numberOfPlayer,nickNameInOrder);
        reConfigClient();
        currentPlayer = playerList.get(currentPlayerPosition);
    }




    public void reConfigClient() throws IOException, InterruptedException {
        super.reConfigClient();
        for(Player p : playerList){

            ArrayList<Integer> needForLeaderInitial = new ArrayList<>();
            for (int i=0; i<4;i++)
                needForLeaderInitial.add(firstPlayer.getPersonalLeaderCard().get(i).getKey());
            notifyOnlyOneSpecificObserver(new UpdateInitLeaderMessage(needForLeaderInitial), p.getNickName());



            notifyOnlyOneSpecificObserver(new UpdateInitBooleanMessage(p.isInit()), p.getNickName());




            ArrayList<Integer> needForLeader = new ArrayList<>();
                ArrayList<Integer> needForLeader2 = new ArrayList<>();



                notifyOnlyOneSpecificObserver(new StorageConfigMessage(p.getGameBoardOfPlayer().getStorageOfGameBoard().getStorageResource()), p.getNickName());

                notifyOnlyOneSpecificObserver(new StrongboxConfigMessage(p.getGameBoardOfPlayer().getStrongboxOfGameBoard().getStrongBoxResource()), p.getNickName());


                for (int i=0; i<p.getGameBoardOfPlayer().getLeaderCards().size();i++)
                    needForLeader.add(p.getGameBoardOfPlayer().getLeaderCards().get(i).getKey());
                for (int i=0; i<p.getGameBoardOfPlayer().getLeaderCardsActivated().size();i++)
                    needForLeader2.add(p.getGameBoardOfPlayer().getLeaderCardsActivated().get(i).getKey());
                notifyOnlyOneSpecificObserver(new LeadercardconfigMessage(needForLeader,needForLeader2), p.getNickName());

                notifyOnlyOneSpecificObserver(new FaithConfigMessage(p.getGameBoardOfPlayer().getIndicator(),p.getGameBoardOfPlayer().getCurrCall()), p.getNickName());

            int[][] list = new int[3][3];
            for (int i=0; i<3;i++)
                for (int j=0; i<3;i++)
                    if (p.getGameBoardOfPlayer().getDevelopmentBoardCell(i,j)==null)
                        list[i][j]=0;
                    else
                        list[i][j]=p.getGameBoardOfPlayer().getDevelopmentBoardCell(i,j).getKey();

            notifyOnlyOneSpecificObserver(new ProductionCardConfigMessage(list),p.getNickName());
                if(p.getGameBoardOfPlayer().getLeaderCardsActivated().size() != 0){
                    if (p.getGameBoardOfPlayer().getLeaderCardsActivated().get(0)!=null){
                        if(p.getGameBoardOfPlayer().getLeaderCardsActivated().get(0) instanceof LeaderCardProduction)
                            notifyOnlyOneSpecificObserver(new StorageExtraConfig(p.getGameBoardOfPlayer().getStorageOfGameBoard().getNumExtraFirstAvailable(),((LeaderCardProduction) p.getGameBoardOfPlayer().getLeaderCardsActivated().get(0)).getResourceProduction()), p.getNickName());
                    }
                    if(p.getGameBoardOfPlayer().getLeaderCardsActivated()!=null && p.getGameBoardOfPlayer().getLeaderCardsActivated().get(1)!=null){
                        if(p.getGameBoardOfPlayer().getLeaderCardsActivated().get(1) instanceof LeaderCardProduction)
                            notifyOnlyOneSpecificObserver(new StorageExtraDoubleConfig(p.getGameBoardOfPlayer().getStorageOfGameBoard().getNumExtraFirstAvailable(),((LeaderCardProduction) p.getGameBoardOfPlayer().getLeaderCardsActivated().get(1)).getResourceProduction()), p.getNickName());
                    }
                }
            } }


    /**
     * this method creates all the players in the game starting from the number of players and their nicknames
     * @param numberOfPlayer : the number of players in the game
     * @param nickNameInOrder : collection of players' nicknames already sorted according to the random assignment of the inkwell
     */
    private void
    createPlayerRestore(int numberOfPlayer,ArrayList<String> nickNameInOrder){
        if (numberOfPlayer==2)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0),this,false,clientControllersInOrder.get(0).getVirtualView());
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1),this,false,clientControllersInOrder.get(1).getVirtualView());
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
        }

        else if (numberOfPlayer==3)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0),this,false,clientControllersInOrder.get(0).getVirtualView());
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1),this,false,clientControllersInOrder.get(0).getVirtualView());
            thirdPlayer= new PlayerThird(nickNameInOrder.get(2),this ,false,clientControllersInOrder.get(0).getVirtualView());
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
            playerList.add(thirdPlayer);

        }
        else if (numberOfPlayer==4)
        {
            firstPlayer=new PlayerFirst(nickNameInOrder.get(0),this,false,clientControllersInOrder.get(0).getVirtualView());
            secondPlayer= new PlayerSecond(nickNameInOrder.get(1),this ,false,clientControllersInOrder.get(0).getVirtualView());
            thirdPlayer= new PlayerThird(nickNameInOrder.get(2),this ,false,clientControllersInOrder.get(0).getVirtualView());
            fourthPlayer=new PlayerFourth(nickNameInOrder.get(3),this,false,clientControllersInOrder.get(0).getVirtualView());
            playerList.add(firstPlayer);
            playerList.add(secondPlayer);
            playerList.add(thirdPlayer);
            playerList.add(fourthPlayer);

        }

    }


    /**
     * saveInformationPlayerNumber
     */
    private void saveInformationPlayerNumber() {
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(numberOfPlayer);
        try {
            config = new FileWriter("src/main/resources/InformationAboutTurnPlayerNumber.json");
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



    /**
     * endGame method
     */
    @Override
    public void endGame() throws IOException, InterruptedException {
        notifyObserver(new EndGamePlayerWinnerMessage(theWinnerIs().getNickName()));
        FileClass.FileDestroyer();
    }


    @Override
    public synchronized void endOfTurn() throws IOException, InterruptedException {
        setCurrentPlayer();
        saveInformation();
        notifyToOneObserver(new YourTurnMessage());
        notifyAllObserverLessOne(new ChangeTurnMessage(currentPlayer.getNickName()));}

    private void saveTypeMatch() {
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(nickNameInOrder);
        try {
            config = new FileWriter("src/main/resources/MultiGame.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            } }
    }

}





