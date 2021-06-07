package it.polimi.ingsw.client.lightModel;


import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.lightModel.lightActionMarkers.LightActionMarkerDeck;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.colours.Violet;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;


/**
 * This class represent the solitaire game of the light model
 */
public class LightGameSolitaire extends LightGame{

    /**
     *  This attribute represents the black cross of Lorenzo the Magnificent
     */
    private final LightLorenzoTheMagnificent lorenzoTheMagnificent;
    /**
     * This attribute represent the deck of action markers
     */
    private final LightActionMarkerDeck actionMarkerDeck;

    /**
     * Constructor of solitaire game
     * @param nickname : username of the player
     */
    public LightGameSolitaire(String nickname) throws IOException, InterruptedException {
        super(nickname);
        lorenzoTheMagnificent = new LightLorenzoTheMagnificent();
        actionMarkerDeck = new LightActionMarkerDeck();
    }

    /**
     * This method sets the faith indicator of Lorenzo the Magnificent and notifies the observer the position of the black cross
     * @param faithIndicator : the position of the black cross
     */
    @Override
    public void setLorenzoTheMagnificent(int faithIndicator){
        lorenzoTheMagnificent.setLightLorenzoTheMagnificent(faithIndicator);
        try {
            notifyObserver(new FaithPathNotification(faithIndicator, true).serialize());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method activates the effect of the type of action marker passed as a parameter
     * @param actionMarkerType : the type of action marker
     */
    @Override
    public void actionMarkerEffect(String actionMarkerType) throws IOException, InterruptedException {
        actionMarkerDeck.actionMarkerEffect(actionMarkerType, this);
    }


    /**
     * this method calls the Lorenzo the magnificent method to move the black cross and notifies the observer
     */
    @Override
    public void moveBlackCrossOnce(){
        lorenzoTheMagnificent.moveBlackCross();
        try {
            notifyObserver((new FaithPathNotification(lorenzoTheMagnificent.getFaithIndicator(),true).serialize()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method calls the Lorenzo the magnificent method to move the black cross twice and notifies the observer
     */
    public void moveBlackCrossDouble(){
        lorenzoTheMagnificent.moveBlackCrossDouble();
        try {
            notifyObserver((new FaithPathNotification(lorenzoTheMagnificent.getFaithIndicator(),true).serialize()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method removes two blue production cards due to action marker effect starting from the level one deck up
     * to the level three deck.
     * @param blue : the colour of the decks
     */
    public void removeProductionCard(Blue blue) throws IOException, InterruptedException {
        for(int i = 0; i < 2; i++) {
            if (!deckProductionCardOneBlu.isEmpty())
                deckProductionCardOneBlu.removeOneCard();
            else if (!deckProductionCardTwoBlu.isEmpty())
                deckProductionCardTwoBlu.removeOneCard();
            else
                deckProductionCardThreeBlu.removeOneCard();
        }

        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }
    /**
     * this method removes two yellow production cards due to action marker effect starting from the level one deck up
     * to the level three deck.
     * @param yellow : the colour of the decks
     */
    public void removeProductionCard(Yellow yellow) throws IOException, InterruptedException {
        for(int i = 0; i < 2; i++) {
            if (!deckProductionCardOneYellow.isEmpty())
                deckProductionCardOneYellow.removeOneCard();
            else if (!deckProductionCardTwoYellow.isEmpty())
                deckProductionCardTwoYellow.removeOneCard();
            else
                deckProductionCardThreeYellow.removeOneCard();
        }
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }
    /**
     * this method removes two green production cards due to action marker effect starting from the level one deck up
     * to the level three deck.
     * @param green : the colour of the decks
     */
    public void removeProductionCard(Green green) throws IOException, InterruptedException {
        for(int i = 0; i < 2; i++) {
            if (!deckProductionCardOneGreen.isEmpty())
                deckProductionCardOneGreen.removeOneCard();
            else if (!deckProductionCardTwoGreen.isEmpty())
                deckProductionCardTwoGreen.removeOneCard();
            else
                deckProductionCardThreeGreen.removeOneCard();
        }

        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }
    /**
     * this method removes two violet production cards due to action marker effect starting from the level one deck up
     * to the level three deck.
     * @param violet : the colour of the decks
     */
    public void removeProductionCard(Violet violet) throws IOException, InterruptedException {
        for(int i = 0; i < 2; i++) {
            if (!deckProductionCardOneViolet.isEmpty())
                deckProductionCardOneViolet.removeOneCard();
            else if (!deckProductionCardTwoViolet.isEmpty())
                deckProductionCardTwoViolet.removeOneCard();
            else
                deckProductionCardThreeViolet.removeOneCard();
        }
        ArrayList<ProductionCard> list=deckNotification();
        notifyObserver(new DeckListNotification(list).serialize());
    }

    /**
     * This method returns the current position of the black cross
     * @return int : the black cross position
     */
    @Override
    public int getLorenzoPosition(){
        return lorenzoTheMagnificent.getFaithIndicator();
    }
}
