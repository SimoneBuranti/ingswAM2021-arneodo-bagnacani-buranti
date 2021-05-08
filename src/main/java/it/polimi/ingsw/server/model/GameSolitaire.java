package it.polimi.ingsw.server.model;


import com.google.gson.Gson;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.actionMarkers.DeckActionMarker;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.colours.Violet;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.players.Player;
import it.polimi.ingsw.server.model.players.PlayerFirst;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCard;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class represents the game in solitary
 */
public class GameSolitaire extends Game{

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


    /**
     * the constructor calls the super class constructor and instantiates the attributes of the solitaire game
     */



    public GameSolitaire(String nickName, Boolean newGame) {
        super(newGame);
        if(newGame){
        this.nickNamePlayer=nickName;
        deckActionMarker = new DeckActionMarker();
        lorenzoTheMagnificent = new LorenzoTheMagnificent();
        player = new PlayerFirst(nickName);
        currentPlayer = player;}
        else
            restoreGameSolitaire();
    }

    /**
     * this method calls the super class method to buy the production card and calls the checkProductionDeck method
     * to check if all the decks of a certain colour are empty: if they are, the EndOfSolitaireGame exception is caught
     * and handled by calling the exceptionHandler method
     * @param deck : it is the production card deck from which the current player wants to buy the card
     * @param chosenColumn : the game board column in which the current player wants to place the bought card
     */
    @Override
    public void buyProductionCard(DeckProductionCard deck, int chosenColumn) throws EmptyException, FullColumnException, NotEnoughResourcesException, LevelException {

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
    public void revealAndActivateActionMarker() {
        try {
            deckActionMarker.pickUpFirstCard().actionMarkerEffect(this);
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
    public void moveBlackCrossOnce(){
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
    public void moveBlackCrossDouble(){
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
    public void mixDeckActionMarker(){
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
    public void removeProductionCard(Blue blue) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneBlu.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoBlu.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeBlu.removeOneCard();
            }
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
    public void removeProductionCard(Yellow yellow) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneYellow.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoYellow.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeYellow.removeOneCard();
            }
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
    public void removeProductionCard(Green green) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneGreen.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoGreen.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeGreen.removeOneCard();
            }
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
    public void removeProductionCard(Violet violet) throws EndOfSolitaireGame, EmptyException {
        try {
            deckProductionCardOneViolet.removeOneCard();
        } catch (EmptyException e) {
            try {
                deckProductionCardTwoViolet.removeOneCard();
            } catch (EmptyException emptyException) {
                deckProductionCardThreeViolet.removeOneCard();
            }
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
    public void moveEveryoneExcept(Player player){
        try {
            lorenzoTheMagnificent.moveBlackCross();
        } catch (CallForCouncilException e1) {
            exceptionHandler(e1);
        }catch (EndOfSolitaireGame e2) {
            exceptionHandler(e2);
        }
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
    public void connectPlayer(String nickname){
        if(player.getNickName().equals(nickname) && !(player.isConnected())){
            player.setConnected();
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
    protected void exceptionHandler(CallForCouncilException e) {
        player.setPapal();
        lorenzoTheMagnificent.setCurrCall();
    }


    /**
     * this method handles the LastSpaceReachedException by calling the player methods for assigning papal cards and
     * for calculating the final score
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(LastSpaceReachedException e) {
        player.setPapal();
        player.playerScore();
       endGame();
    }



    /**
     * this method handles the EndOfSolitaireGame exception by assigning the victory to Lorenzo the Magnificent
     * @param e : the exception to handle
     */
    @Override
    protected void exceptionHandler(EndOfSolitaireGame e) {
        System.out.println("Lorenzo the Magnificent WIN");
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
    public void activateActionMarker(ActionMarker actionMarker)  {
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




    public void  restoreGameSolitaire() {
        currentPlayer = player;
        Gson gson=new Gson();

        try {
            nickNamePlayer= gson.fromJson(new FileReader("src/main/resources/InformationAboutNickname.json"), String.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RestoreActionMarker();
        player = new PlayerFirst(nickNamePlayer);
        RestoreActionMagnific();

    }



    public void saveNickNamePlayer(){
        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(nickNamePlayer);
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            config = new FileWriter("src/main/resources/InformationAboutNickname.json");
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
    public void RestoreActionMagnific(){
        Gson gson=new Gson();
        int[] servList;

        try {
            servList = gson.fromJson(new FileReader("src/main/resources/LoriMagnific.json"),int[].class);
            lorenzoTheMagnificent=new LorenzoTheMagnificent(servList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * save information for a possible restart game
     */
    public void RestoreActionMarker(){
        Gson gson=new Gson();
        ActionMarker[] servList;
        try {
            servList= gson.fromJson(new FileReader("src/main/resources/DeckActionMarker.json"),ActionMarker[].class);
            this.deckActionMarker = new DeckActionMarker(servList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    /**
     * endGame method
     */
    @Override
    public void endGame(){
        FileClass.FileDestroyer();

    }
}
