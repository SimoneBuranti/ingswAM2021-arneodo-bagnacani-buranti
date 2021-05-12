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
        super();
        currentPlayer = new LightPlayer(nickname);
        lorenzoTheMagnificent = new LightLorenzoTheMagnificent();
        actionMarkerDeck = new LightActionMarkerDeck();
    }

    @Override
    public void setLorenzoTheMagnificent(int faithIndicator){
        lorenzoTheMagnificent.setLightLorenzoTheMagnificent(faithIndicator);
    }

    @Override
    public void setFaithPath(String nickname, int faithIndicator, int currCall){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.setFaithPath(faithIndicator, currCall);
        }
    }

    @Override
    public void setProductionCardGameBoard(String nickname, ProductionCard[][] productionCards){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.setProductionCards(productionCards);
        }
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
    public void addLeaderCard(String nickname, LeaderCard leaderCard){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addLeaderCard(leaderCard);
        }
    }

    @Override
    public void addLeaderCard(String nickname, ArrayList<LeaderCard> leaderCard){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addLeaderCard(leaderCard);
        }
    }

    @Override
    public void addLeaderCardActivated(String nickname, ArrayList<LeaderCard> leaderCard){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addLeaderCardActivated(leaderCard);
        }
    }

    @Override
    public void activateLeaderCard(String nickname, LeaderCard leaderCard){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.activateLeaderCard(leaderCard);
        }
    }

    @Override
    public void activateLeaderCard(String nickname, int index){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.activateLeaderCard(index);
        }
    }

    @Override
    public void discardLeaderCard(String nickname, LeaderCard leaderCard){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.discardLeaderCard(leaderCard);
        }
    }

    @Override
    public void discardLeaderCard(String nickname, int index){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.discardLeaderCard(index);
        }
    }

    @Override
    public void faithMove(String nickname){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.moveFaithIndicator();
        }
    }

    @Override
    public void buyProductionCard(String nickname, int deckNumber, int chosenColumn){
        if(nickname.equals(currentPlayer.getNickName())){
            for(LightDeckProductionCard deck : listOfDeck){
                if(deck.getNumberDeck() == deckNumber)
                    currentPlayer.addProductionCard(chosenColumn, deck.pickUpFirstCard());
            }
        }
    }

    @Override
    public void payResourcesProduction(String nickname, Map<Resource, Integer> map){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.payResourcesProduction(map);
        }
    }

    @Override
    public void setPapalCards(int currCall){
        currentPlayer.setPapal(currCall);
    }

    @Override
    public void addStorage(String nickname, Map<Resource, Integer> map){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addResourceStorage(map);
        }
    }

    @Override
    public void addStorage(String nickname, Resource resource, int quantity){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addResourceStorage(resource, quantity);
        }
    }

    @Override
    public void addStorage(String nickname, ArrayList<Resource> list){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addResourceStorage(list);
        }
    }

    @Override
    public void removeStorage(String nickname, Map<Resource, Integer> map){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.removeResourceStorage(map);
        }
    }

    @Override
    public void removeStorage(String nickname, Resource resource, int quantity){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.removeResourceStorage(resource, quantity);
        }
    }

    @Override
    public void addStrongbox(String nickname, Map<Resource, Integer> map){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addResourceStrongbox(map);
        }
    }

    @Override
    public void addStrongbox(String nickname, ArrayList<Resource> list){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addResourceStrongbox(list);
        }
    }

    @Override
    public void addStrongbox(String nickname, Resource resource, int quantity){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.addResourceStrongbox(resource, quantity);
        }
    }

    @Override
    public void removeStrongbox(String nickname, Map<Resource, Integer> map){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.removeResourceStrongbox(map);
        }
    }

    @Override
    public void removeStrongbox(String nickname, Resource resource, int quantity){
        if(nickname.equals(currentPlayer.getNickName())){
            currentPlayer.removeResourceStrongbox(resource, quantity);
        }
    }
}
