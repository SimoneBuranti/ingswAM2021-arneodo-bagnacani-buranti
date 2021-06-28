package it.polimi.ingsw.server.model;


import com.google.gson.Gson;
import it.polimi.ingsw.messages.PositionMessage;
import it.polimi.ingsw.messages.SetPapalsMessage;
import it.polimi.ingsw.messages.observable.*;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.actionMarkers.DeckActionMarker;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.colours.Violet;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.leaderCards.DeckLeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardProduction;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardStorage;
import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.players.PlayerFirst;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCard;
import it.polimi.ingsw.server.virtualview.VirtualView;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represents the game in solitary
 */
public class GameSolitaire extends Game {

    /**
     * this attribute represents the action marker deck of the game
     */
    DeckActionMarker deckActionMarker;
    /**
     * this attribute represents the opponent of the player Lorenzo the magnificent
     */
    LorenzoTheMagnificent lorenzoTheMagnificent;
    /**
     * this attribute represents the player of the game
     */
    Player player;

    private String nickNamePlayer;

    private ClientController clientController;

    private boolean isFirstTurn = true;


    /**
     * the constructor calls the super class constructor and instantiates the attributes of the solitaire game
     */

    private VirtualView virtualView;

    public GameSolitaire(String nickName, Boolean newGame,ClientController clientController) throws IOException, InterruptedException {
        super(newGame);
        if(newGame){
            this.nickNamePlayer=nickName;
            this.clientController=clientController;
            deckActionMarker = new DeckActionMarker();
            lorenzoTheMagnificent = new LorenzoTheMagnificent();
            player = new PlayerFirst(nickName,this, clientController.getVirtualView());
            currentPlayer = player;
            this.addObserver(clientController.getVirtualView());
            notifyObserver(new GameTypeMessage(false));
            configClient();
            ArrayList<Integer> needForLeaderInitial = new ArrayList<>();
            for (int i=0; i<4;i++)
                needForLeaderInitial.add(player.getPersonalLeaderCard().get(i).getKey());
            notifyObserver(new UpdateInitLeaderMessage(needForLeaderInitial));
        }
        else
        {
            restoreGameSolitaire(clientController);
        }

        saveInformation();
        notifyObserver(new PositionMessage(1));
        notifyObserver(new YourTurnMessage());
    }


    /**
     * this method calls the super class method to buy the production card and calls the checkProductionDeck method
     * to check if all the decks of a certain colour are empty: if they are, the EndOfSolitaireGame exception is caught
     * and handled by calling the exceptionHandler method
     * @param deck : it is the production card deck from which the current player wants to buy the card
     * @param chosenColumn : the game board column in which the current player wants to place the bought card
     */
    @Override
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException, NotEnoughResourcesException, LevelException, IOException, InterruptedException {

        super.buyProductionCard(deck, chosenColumn);

        try {
            checkProductionDeck();
        } catch (EndOfSolitaireGame e) {
            exceptionHandler(e);
        }
    }


    /**
     * this method takes the first action marker of the deck and applies its effect and catches EmptyException and EndOfSolitaireGame.
     * When the exceptions are caught, the method calls the exceptionHandler method.
     */
    public void revealAndActivateActionMarker() throws IOException, InterruptedException {
        try {
            notifyObserver(new UseActionMarkerMessage(deckActionMarker.showFirst().getType()));
            deckActionMarker.pickUpFirstCard().actionMarkerEffect(this);
            notifyObserver(new YourTurnMessage());
        } catch (EmptyException e) {
            exceptionHandler(e);
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            exceptionHandler(endOfSolitaireGame);
        }

    }


    /**
     * this method calls the Lorenzo the magnificent method to move the black cross,
     * if CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     */
    public void moveBlackCrossOnce() throws IOException, InterruptedException {
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        }catch(EndOfSolitaireGame endOfSolitaireGame){
            exceptionHandler(endOfSolitaireGame);
        }
    }

    /**
     * this method calls the Lorenzo the magnificent method to move the black cross twice,
     * if CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     */
    public void moveBlackCrossDouble() throws IOException, InterruptedException {
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        }catch(EndOfSolitaireGame endOfSolitaireGame){
            exceptionHandler(endOfSolitaireGame);
        }

        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e) {
            exceptionHandler(e);
        }catch(EndOfSolitaireGame endOfSolitaireGame){
            exceptionHandler(endOfSolitaireGame);
        }
    }

    /**
     * this method calls the action marker deck method to mix action markers
     */
    public void mixDeckActionMarker() throws IOException, InterruptedException {
        deckActionMarker.mixDeck();
    }

    /**
     * this method removes a blue production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three blue decks are empty.
     * @param blue : the colour of the decks
     * @throws EndOfSolitaireGame: the exception which is thrown when all the blue production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the level three deck
     */
    public void removeProductionCard(Blue blue) throws EndOfSolitaireGame, EmptyException, IOException, InterruptedException {
        try {
            deckProductionCardOneBlu.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoBlu.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeBlu.removeOneCard();
            } catch (InterruptedException | IOException interruptedException) {
                interruptedException.printStackTrace();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * this method removes a yellow production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three yellow decks are empty.
     * @param yellow : the colour of the decks
     * @throws EndOfSolitaireGame: the exception which is thrown when all the yellow production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the level three deck
     */
    public void removeProductionCard(Yellow yellow) throws EndOfSolitaireGame, EmptyException, IOException, InterruptedException {
        try {
            deckProductionCardOneYellow.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoYellow.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeYellow.removeOneCard();
            } catch (InterruptedException | IOException interruptedException) {
                interruptedException.printStackTrace();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * this method removes a green production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three green decks are empty.
     * @param green : the colour of the decks
     * @throws EndOfSolitaireGame: the exception which is thrown when all the green production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the level three deck
     */
    public void removeProductionCard(Green green) throws EndOfSolitaireGame, EmptyException, IOException, InterruptedException {
        try {
            deckProductionCardOneGreen.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoGreen.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeGreen.removeOneCard();
            } catch (InterruptedException | IOException interruptedException) {
                interruptedException.printStackTrace();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
    /**
     * this method removes a violet production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three violet decks are empty.
     * @param violet : the colour of the decks
     * @throws EndOfSolitaireGame : the exception which is thrown when all the violet production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     * @throws EmptyException : the exception which is thrown when there are no more cards left in the level three deck
     */
    public void removeProductionCard(Violet violet) throws EndOfSolitaireGame, EmptyException, IOException, InterruptedException {
        try {
            deckProductionCardOneViolet.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoViolet.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeViolet.removeOneCard();
            } catch (InterruptedException | IOException interruptedException) {
                interruptedException.printStackTrace();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method checks if there is a colour for which all decks are empty, if so it spreads the EndOfSolitaireGame exception
     * @throws EndOfSolitaireGame : the exception which is thrown when all decks of a certain color are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void checkProductionDeck() throws EndOfSolitaireGame {
        checkProductionDeck(new Blue());
        checkProductionDeck(new Green());
        checkProductionDeck(new Yellow());
        checkProductionDeck(new Violet());
    }

    /**
     * this method throws an EndOfSolitaireGame exception if all blue decks are empty
     * @param blue : the colour of the decks
     * @throws EndOfSolitaireGame : the exception which is thrown when all the blue production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void checkProductionDeck(Blue blue) throws EndOfSolitaireGame {
        if(deckProductionCardOneBlu.size() == 0 && deckProductionCardTwoBlu.size() == 0 && deckProductionCardThreeBlu.size() == 0)
            throw new EndOfSolitaireGame();
    }
    /**
     * this method throws an EndOfSolitaireGame exception if all green decks are empty
     * @param green : the colour of the decks
     * @throws EndOfSolitaireGame : the exception which is thrown when all the green production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void checkProductionDeck(Green green) throws EndOfSolitaireGame {
        if(deckProductionCardOneGreen.size() == 0 && deckProductionCardTwoGreen.size() == 0 && deckProductionCardThreeGreen.size() == 0)
            throw new EndOfSolitaireGame();
    }
    /**
     * this method throws an EndOfSolitaireGame exception if all yellow decks are empty
     * @param yellow : the colour of the decks
     * @throws EndOfSolitaireGame : the exception which is thrown when all the yellow production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void checkProductionDeck(Yellow yellow) throws EndOfSolitaireGame {
        if(deckProductionCardOneYellow.size() == 0 && deckProductionCardTwoYellow.size() == 0 && deckProductionCardThreeYellow.size() == 0)
            throw new EndOfSolitaireGame();
    }
    /**
     * this method throws an EndOfSolitaireGame exception if all violet decks are empty
     * @param violet : the colour of the decks
     * @throws EndOfSolitaireGame : the exception which is thrown when all the violet production cards decks are empty
     *                              and states that the solitaire game is over and the winner is Lorenzo The Magnificent
     */
    public void checkProductionDeck(Violet violet) throws EndOfSolitaireGame {
        if(deckProductionCardOneViolet.size() == 0 && deckProductionCardTwoViolet.size() == 0 && deckProductionCardThreeViolet.size() == 0)
            throw new EndOfSolitaireGame();
    }


    /**
     * method called when the player discards a resource, it moves the black cross forward one position.
     * If CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     * @param player : the one who discards the resource
     */
    @Override
    public void moveEveryoneExcept(Player player) throws IOException, InterruptedException {
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e1) {
            exceptionHandler(e1);
        }catch (EndOfSolitaireGame e2) {
            exceptionHandler(e2);
        }

        notifyObserver(new LorenzoMoveMessage());
    }

    @Override
    public boolean disconnectPlayer(String nickname){
        if(player.isConnected()){
            player.setConnected();
            return true;
        }else
            return false;
    }

    @Override
    public void connectPlayer(String nickname) throws IOException, InterruptedException{
        this.deckLeaderCard=new DeckLeaderCard();
        if(player.getNickName().equals(nickname) && !(player.isConnected())) {
            player.setConnected();
            notifyObserver(new GameTypeMessage(false));
            this.reConfigClient();
        }
    }


    @Override
    public boolean checkNickname(String nickname){
        if(player.getNickName().equals(nickname) && !(player.isConnected())){
            return true;
        }
        return false;
    }

    @Override
    public int numPlayersDisconnected(){
        int num = 0;
        if(!(player.isConnected())){
            num++;
        }
        return num;
    }




    /**
     * this method handles the CallForCouncilException by calling the player and Lorenzo the Magnificent methods
     * for assigning papal cards and incrementing the currCall counter
     * @param e : the exception to handle
     */
    @Override
    public void exceptionHandler(CallForCouncilException e) throws IOException, InterruptedException {
        player.setPapal();
        lorenzoTheMagnificent.setCurrCall();

        notifyObserver(new SetPapalsMessage(player.getPapalCard(e.getCurrCall()), e.getNickName()));
    }


    /**
     * this method handles the LastSpaceReachedException by calling the player methods for assigning papal cards and
     * for calculating the final score
     * @param e : the exception to handle
     */
    @Override
    public void exceptionHandler(LastSpaceReachedException e) throws IOException, InterruptedException {
        player.setPapal();

        notifyObserver(new SetPapalsMessage(player.getPapalCard(e.getCurrCall()), e.getNickName()));
        notifyObserver(new MyVictoryMessage(player.playerScore()));
        endGame();
    }



    /**
     * this method handles the EndOfSolitaireGame exception by assigning the victory to Lorenzo the Magnificent
     * @param e : the exception to handle
     */
    @Override
    public void exceptionHandler(EndOfSolitaireGame e) throws IOException, InterruptedException {
        notifyObserver(new MagnificentWinMessage());
        endGame();
    }

    @Override
    public void exceptionHandler(EndGameException e) throws IOException, InterruptedException {
        notifyObserver(new MyVictoryMessage(player.playerScore()));
        endGame();
    }

    /**
     * Only test method : getter method for the player's game board
     * @return GameBoardInterface : the game board of the player
     */
    public GameBoardInterface getGameBoardOfPlayer(){
        return player.getGameBoardOfPlayer();
    }


    /**
     * Only test method : it applies the effect of the action marker passed as a parameter and catches EmptyException and EndOfSolitaireGame
     * @param actionMarker : action marker whose effect to activate
     */
    public void activateActionMarker(ActionMarker actionMarker) throws IOException, InterruptedException {
        try {
            actionMarker.actionMarkerEffect(this);
        } catch (EmptyException e) {
            exceptionHandler(e);
        } catch (EndOfSolitaireGame endOfSolitaireGame) {
            exceptionHandler(endOfSolitaireGame);
        }
    }

    /**
     * Only test method: it returns the first action marker of the deck
     * @return ActionMarker : the first action marker of the deck
     */
    public ActionMarker showFirst(){
        return deckActionMarker.showFirst();
    }

    /**
     * Only test method : it returns the black cross current position on faithPath
     * @return int : the black cross current position on faithPath
     */
    public int getLorenzoFaithIndicator(){
        return lorenzoTheMagnificent.getFaithIndicator();
    }



    /**
     * save information for a possible restart game
     */
    @Override
    public void saveInformation(){
       super.saveInformation();

       player.savePlayerInformation();
        deckActionMarker.saveInformationOfActionMarker();
        lorenzoTheMagnificent.saveInformationOfLorenzo();
        saveNickNamePlayer();
    }


    /**
     * this metod restore te game after total disconnection or server crashing
     * @param clientController
     * @throws IOException
     * @throws InterruptedException
     */
    public void  restoreGameSolitaire(ClientController clientController) throws IOException, InterruptedException {

        Gson gson=new Gson();
        ArrayList<String> strings= new ArrayList<>();
        try {
            strings= gson.fromJson(new FileReader("fileConfiguration/InformationAboutNickname.json"), ArrayList.class);

            nickNamePlayer=strings.get(0);
        RestoreActionMarker();
        player = new PlayerFirst(nickNamePlayer,this,false,clientController.getVirtualView());
        currentPlayer = player;
        this.addObserver(clientController.getVirtualView());

        notifyObserver(new GameTypeMessage(false));

        RestoreActionMagnific();

        reConfigClient();


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    }

    /**
     * method for saveNickNamePlayer
     */
    public void saveNickNamePlayer(){
        Gson gson = new Gson();

        FileWriter config = null;
        ArrayList<String> strings= new ArrayList<>();
        strings.add(nickNamePlayer);
        String jsonStrin = gson.toJson(strings,ArrayList.class);
        try {
            config = new FileWriter("fileConfiguration/InformationAboutTurn.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            config = new FileWriter("fileConfiguration/InformationAboutNickname.json");
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


    /**
     * restore magnific game
     */
    public void RestoreActionMagnific() throws IOException, InterruptedException {
        Gson gson=new Gson();
        int[] servList;


        try {
           servList = gson.fromJson(new FileReader("fileConfiguration/LoriMagnific.json"),int[].class);
            lorenzoTheMagnificent=new LorenzoTheMagnificent(servList);
            notifyObserver(new LorenzoTheMagnificentConfigMessage(getLorenzoFaithIndicator()));
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
    }

    /**
     * save information for a possible restart game
     */
    public void RestoreActionMarker() throws IOException, InterruptedException {
        System.out.println("qui restore ak 1");
        Gson gson= DeckActionMarker.DeckActionMarkerSaving();
        ActionMarker[] servList;
        try {
           servList= gson.fromJson(new FileReader("fileConfiguration/DeckActionMarker.json"),ActionMarker[].class);
            this.deckActionMarker = new DeckActionMarker(servList);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        System.out.println("qui restore ak 2");
    }
    /**
     * this metod restore player after total disconnection or server crashing
     * @throws IOException
     * @throws InterruptedException
     */
    public void reConfigClient() throws IOException, InterruptedException {
        super.configClient();
        boolean extraStorage = false;
        notifyObserver(new UpdateInitBooleanMessage(player.isInitResource(),player.isInitLeader()));
        if(!player.isInitLeader()){
            ArrayList<Integer> needForLeaderInitial = new ArrayList<>();
            for (int i=0; i<4;i++){

                needForLeaderInitial.add(player.getPersonalLeaderCard().get(i).getKey());
            }
            notifyObserver(new UpdateInitLeaderMessage(needForLeaderInitial));}
        else{
            isFirstTurn = false;
            ArrayList<Integer> needForLeader = new ArrayList<>();
            ArrayList<Integer> needForLeader2 = new ArrayList<>();

            for (int i=0; i<player.getGameBoardOfPlayer().getLeaderCards().size();i++)
                needForLeader.add(player.getGameBoardOfPlayer().getLeaderCards().get(i).getKey());

            for (int i=0; i<player.getGameBoardOfPlayer().getLeaderCardsActivated().size();i++)
                needForLeader2.add(player.getGameBoardOfPlayer().getLeaderCardsActivated().get(i).getKey());
            notifyObserver(new LeadercardconfigMessage(needForLeader,needForLeader2));

            notifyObserver(new StorageConfigMessage(player.getGameBoardOfPlayer().getStorageOfGameBoard().getStorageResource()));

            notifyObserver(new StrongboxConfigMessage(player.getGameBoardOfPlayer().getStrongboxOfGameBoard().getStrongBoxResource()));



            notifyObserver(new FaithConfigMessage(player.getGameBoardOfPlayer().getIndicator(),player.getGameBoardOfPlayer().getCurrCall()));

            notifyObserver(new PapalCardsConfigMessage(player.getPapalCards()));
            int[][] list = new int[3][3];
            for (int i=0; i<3;i++){
                for (int j=0; j<3;j++){
                    if (player.getGameBoardOfPlayer().getDevelopmentBoardCell(i,j)==null)
                        list[i][j]=0;
                    else
                        list[i][j]=player.getGameBoardOfPlayer().getDevelopmentBoardCell(i,j).getKey();}}

            notifyObserver(new ProductionCardConfigMessage(list));

            if(player.getGameBoardOfPlayer().getLeaderCardsActivated().size()>0){

                if(player.getGameBoardOfPlayer().getLeaderCardsActivated().get(0) instanceof LeaderCardStorage){
                    extraStorage = true;
                    notifyObserver(new StorageExtraConfig(player.getGameBoardOfPlayer().getStorageOfGameBoard().getNumExtraFirstAvailable(),player.getGameBoardOfPlayer().getLeaderCardsActivated().get(0).getResourceEffect()));
                }
            }

            if(player.getGameBoardOfPlayer().getLeaderCardsActivated().size()>1){
                if(player.getGameBoardOfPlayer().getLeaderCardsActivated().get(1) instanceof LeaderCardStorage)
                    if(extraStorage)
                        notifyObserver(new StorageExtraDoubleConfig(player.getGameBoardOfPlayer().getStorageOfGameBoard().getNUmExtraSecondAvailable(),player.getGameBoardOfPlayer().getLeaderCardsActivated().get(1).getResourceEffect()));
                    else
                        notifyObserver(new StorageExtraDoubleConfig(player.getGameBoardOfPlayer().getStorageOfGameBoard().getNumExtraFirstAvailable(),player.getGameBoardOfPlayer().getLeaderCardsActivated().get(1).getResourceEffect()));
            }

        }

        Map<Resource, Integer> map = playerResources();
        this.reserve.removeResources(map);
        notifyObserver(new ReserveValueMessage(map));
    }

    /**
     * endGame method
     */
    @Override
    public void endGame(){
        FileClass.FileDestroyer();
        setOver(true);
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(null,ArrayList.class);
        try {
            config = new FileWriter("fileConfiguration/InformationAboutTurn.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void endOfTurn() throws IOException, InterruptedException {
        if(isFirstTurn){
            isFirstTurn = false;
            notifyObserver(new YourTurnMessage());
        }else if(!isOver){
            revealAndActivateActionMarker();
        }
        saveInformation();
    }

    /**
     * @return from the resource of the player, this method restore the old reserve
     */
    public Map<Resource, Integer> playerResources(){
        Map<Resource, Integer> map = new HashMap();

        int coin = player.getGameBoardOfPlayer().getStorageOfGameBoard().getResource(Resource.COIN) + player.getGameBoardOfPlayer().getStrongboxOfGameBoard().getResource(Resource.COIN);
        int rock = player.getGameBoardOfPlayer().getStorageOfGameBoard().getResource(Resource.ROCK) + player.getGameBoardOfPlayer().getStrongboxOfGameBoard().getResource(Resource.ROCK);
        int servant = player.getGameBoardOfPlayer().getStorageOfGameBoard().getResource(Resource.SERVANT) + player.getGameBoardOfPlayer().getStrongboxOfGameBoard().getResource(Resource.SERVANT);
        int shield = player.getGameBoardOfPlayer().getStorageOfGameBoard().getResource(Resource.SHIELD) + player.getGameBoardOfPlayer().getStrongboxOfGameBoard().getResource(Resource.SHIELD);

        map.put(Resource.COIN, coin);
        map.put(Resource.ROCK, rock);
        map.put(Resource.SERVANT, servant);
        map.put(Resource.SHIELD, shield);

        return map;

    }

}
