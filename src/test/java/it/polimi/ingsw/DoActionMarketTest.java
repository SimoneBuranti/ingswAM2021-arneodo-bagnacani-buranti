package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoActionMarketTest {

    /**
     * test about the reception of cardproduction in gameboard
     */
    @Test
    public void correctionOfCall() throws LevelException, EmptyException {
        Game game= new Game();

        Game.DoActionMarket(game.player,game.deckProductionCardOneBlu,1);
        assertTrue(game.player.getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(game.player,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(game.player,game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(game.player,game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(game.player,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(game.player,game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(game.player,game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


    }}