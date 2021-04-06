package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoActionMarketTest {

    /**
     * test about the reception of cardproduction in gameboard
     */
    @Test
    public void correctionOfCall() throws LevelException, EmptyException {
        ArrayList<String> nickname =new ArrayList<String>(1);
        nickname.add("ale");
        Game game= new GameMultiPlayer(1,nickname);

        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer)game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoBlu,1);
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
        ArrayList<String> nickname =new ArrayList<String>(1);
        nickname.add("ale");

        Game game= new GameMultiPlayer(1,nickname);

        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }
        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(0,0 ).getLevel()==1);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(1,0 ).getLevel()==2);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(2,1 ) .getLevel()==3);
}






    /**
     * calls from different players(2)
     */
    @Test
    public void twoPlayersOfCallMoreDeck() throws LevelException, EmptyException {
        ArrayList<String> nickname =new ArrayList<String>(2);
        nickname.add("ale");
        nickname.add("ali");
        Game game= new GameMultiPlayer(2,nickname);

        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardOneGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }
        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(0,0 ).getLevel()==1);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(1,0 ).getLevel()==2);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(0),game.deckProductionCardThreeGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).getPlayerFromList(0).getGameBoardOfPlayer().getCellDevelopmentBoard(2,1 ) .getLevel()==3);





        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardOneBlu,1);
        assertTrue(((GameMultiPlayer) game).getPlayerFromList(1).getGameBoardOfPlayer().getCellDevelopmentBoard(0,1 ) instanceof ProductionCard);
        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardTwoBlu,1);
        Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardThreeBlu,1);


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardOneBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardThreeBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardTwoBlu,1);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }


        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardOneGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }
        assertTrue(((GameMultiPlayer) game).getPlayerFromList(1).getGameBoardOfPlayer().getCellDevelopmentBoard(0,0 ).getLevel()==1);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardTwoGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).getPlayerFromList(1).getGameBoardOfPlayer().getCellDevelopmentBoard(1,0 ).getLevel()==2);

        try {
            Game.DoActionMarket(((GameMultiPlayer) game).getPlayerFromList(1),game.deckProductionCardThreeGreen,0);
        } catch (LevelException e)
        {
            System.out.println();
        }

        assertTrue(((GameMultiPlayer) game).getPlayerFromList(1).getGameBoardOfPlayer().getCellDevelopmentBoard(2,1 ) .getLevel()==3);
    
    
    
    
    
    
    
    
    
    }}