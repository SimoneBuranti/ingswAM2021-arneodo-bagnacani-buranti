package it.polimi.ingsw.Client.lightModel;


import it.polimi.ingsw.Client.lightModel.lightActionMarkers.LightActionMarkerDeck;
import it.polimi.ingsw.Client.lightModel.productionCards.LightDeckProductionCard;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.colours.Violet;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;
import java.util.Map;

public class LightGameSolitaire extends LightGame{

    private final LightLorenzoTheMagnificent lorenzoTheMagnificent;
    private final LightActionMarkerDeck actionMarkerDeck;

    public LightGameSolitaire(String nickname){
        super(nickname);
        lorenzoTheMagnificent = new LightLorenzoTheMagnificent();
        actionMarkerDeck = new LightActionMarkerDeck();
    }

    @Override
    public void setLorenzoTheMagnificent(int faithIndicator){
        lorenzoTheMagnificent.setLightLorenzoTheMagnificent(faithIndicator);
    }

    @Override
    public void setFaithPath(int faithIndicator, int currCall){
        gameBoardOfPlayer.setFaithPath(faithIndicator, currCall);
    }

    @Override
    public void setProductionCardGameBoard(int[][] productionCards){
        gameBoardOfPlayer.setProductionCards(productionCards);
    }

    @Override
    public void actionMarkerEffect(String actionMarkerType){
        actionMarkerDeck.actionMarkerEffect(actionMarkerType, this);
    }


    /**
     * this method calls the Lorenzo the magnificent method to move the black cross,
     * if CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     */
    @Override
    public void moveBlackCrossOnce(){
        lorenzoTheMagnificent.moveBlackCross();
    }

    /**
     * this method calls the Lorenzo the magnificent method to move the black cross twice,
     * if CallForCouncilException or EndOfSolitaireGame is caught it calls the exceptionHandler method to handle it
     */
    public void moveBlackCrossDouble(){
        lorenzoTheMagnificent.moveBlackCrossDouble();
    }

    /**
     * this method removes a blue production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three blue decks are empty.
     * @param blue : the colour of the decks
     */
    public void removeProductionCard(Blue blue){
        if(!deckProductionCardOneBlu.isEmpty())
            deckProductionCardOneBlu.removeOneCard();
        else if(!deckProductionCardTwoBlu.isEmpty())
            deckProductionCardTwoBlu.removeOneCard();
        else
            deckProductionCardThreeBlu.removeOneCard();
    }
    /**
     * this method removes a yellow production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three yellow decks are empty.
     * @param yellow : the colour of the decks
     */
    public void removeProductionCard(Yellow yellow){
        if(!deckProductionCardOneYellow.isEmpty())
            deckProductionCardOneYellow.removeOneCard();
        else if(!deckProductionCardTwoYellow.isEmpty())
            deckProductionCardTwoYellow.removeOneCard();
        else
            deckProductionCardThreeYellow.removeOneCard();
    }
    /**
     * this method removes a green production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three green decks are empty.
     * @param green : the colour of the decks
     */
    public void removeProductionCard(Green green){
        if(!deckProductionCardOneGreen.isEmpty())
            deckProductionCardOneGreen.removeOneCard();
        else if(!deckProductionCardTwoGreen.isEmpty())
            deckProductionCardTwoGreen.removeOneCard();
        else
            deckProductionCardThreeGreen.removeOneCard();
    }
    /**
     * this method removes a violet production card due to action marker effect starting from the level one deck up
     * to the level three deck. It spreads the EndOfSolitaireGame exception if all three violet decks are empty.
     * @param violet : the colour of the decks
     */
    public void removeProductionCard(Violet violet){
        if(!deckProductionCardOneViolet.isEmpty())
            deckProductionCardOneViolet.removeOneCard();
        else if(!deckProductionCardTwoViolet.isEmpty())
            deckProductionCardTwoViolet.removeOneCard();
        else
            deckProductionCardThreeViolet.removeOneCard();
    }

    @Override
    public void addLeaderCard(ArrayList<Integer> leaderCardKeys){
        gameBoardOfPlayer.addLeaderCard(leaderCardKeys);
    }

    @Override
    public void addLeaderCardActivated(ArrayList<Integer> leaderCardKeys){
        gameBoardOfPlayer.addLeaderCardActivated(leaderCardKeys);
    }


    @Override
    public void activateLeaderCard(int index){
        gameBoardOfPlayer.activateLeaderCard(index);
    }

    @Override
    public void discardLeaderCard(int index){
        gameBoardOfPlayer.discardLeaderCard(index);
    }

    @Override
    public void faithMove(int pos){
        gameBoardOfPlayer.moveFaithIndicator(pos);
    }

    @Override
    public void buyProductionCard(int deckNumber, int chosenColumn){
        for(LightDeckProductionCard deck : listOfDeck){
            if(deck.getNumberDeck() == deckNumber)
                gameBoardOfPlayer.addProductionCard(chosenColumn, deck.pickUpFirstCard());
        }
    }

    @Override
    public void payResourcesProduction(ArrayList<Resource> list){
        gameBoardOfPlayer.payResourcesProduction(list);
    }

    @Override
    public void setPapalCards(int currCall){
        gameBoardOfPlayer.setPapal(currCall);
    }

    @Override
    public void addStorage(Map<Resource, Integer> map){
        gameBoardOfPlayer.addResourceStorage(map);
    }

    @Override
    public void addStorage(Resource resource, int quantity){
        gameBoardOfPlayer.addResourceStorage(resource, quantity);
    }

    @Override
    public void addStorage( ArrayList<Resource> list){
        gameBoardOfPlayer.addResourceStorage(list);
    }

    @Override
    public void removeStorage(Map<Resource, Integer> map){
        gameBoardOfPlayer.removeResourceStorage(map);
    }

    @Override
    public void removeStorage(Resource resource, int quantity){
        gameBoardOfPlayer.removeResourceStorage(resource, quantity);
    }

    @Override
    public void addStrongbox(Map<Resource, Integer> map){
        gameBoardOfPlayer.addResourceStrongbox(map);
    }

    @Override
    public void addStrongbox(ArrayList<Resource> list){
        gameBoardOfPlayer.addResourceStrongbox(list);
    }

    @Override
    public void addStrongbox(Resource resource, int quantity){
        gameBoardOfPlayer.addResourceStrongbox(resource, quantity);
    }

    @Override
    public void removeStrongbox(Map<Resource, Integer> map){
        gameBoardOfPlayer.removeResourceStrongbox(map);
    }

    @Override
    public void removeStrongbox(Resource resource, int quantity){
        gameBoardOfPlayer.removeResourceStrongbox(resource, quantity);
    }
}
