package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoActionMarketTest {

    /**
     * test about the reception of cardproduction in gameboard
     */
    @Test
    public void correctionOfCall() throws LevelException, EmptyException {
        Game game= new GameMultiPlayer(1);

        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer)game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


    }






    /**
     * test about the reception of cardproduction in gameboard with more deck
     */
    @Test
    public void correctionOfCallMoreDeck() throws LevelException, EmptyException {
        Game game= new GameMultiPlayer(1);

        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }
        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(0,0 ).getLevel()==1);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(1,0 ).getLevel()==2);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(2,1 ) .getLevel()==3);
}






    /**
     * calls from different players(2)
     */
    @Test
    public void twoPlayersOfCallMoreDeck() throws LevelException, EmptyException {
        Game game= new GameMultiPlayer(2);

        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardOneGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }
        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(0,0 ).getLevel()==1);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(1,0 ).getLevel()==2);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerFirst,game.deckProductionCardThreeGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).playerFirst.getGameBoardOfPlayer().getCellDevelopmentBoard(2,1 ) .getLevel()==3);





        Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer) game).playerSecond.getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardOneGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }
        assertTrue(((GameMultiPlayer) game).playerSecond.getGameBoardOfPlayer().getCellDevelopmentBoard(0,0 ).getLevel()==1);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).playerSecond.getGameBoardOfPlayer().getCellDevelopmentBoard(1,0 ).getLevel()==2);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).playerSecond,game.deckProductionCardThreeGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).playerSecond.getGameBoardOfPlayer().getCellDevelopmentBoard(2,1 ) .getLevel()==3);
    
    
    
    
    
    
    
    
    
    }}