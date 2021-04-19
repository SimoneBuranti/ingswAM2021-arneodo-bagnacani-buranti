package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketTest {
    /**
     * test on creation of Market(Grid) with mixed functionality
     */
    @Test
    public void initializationOfGridMarket()
    {


        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);


        assertTrue(!( game.getCellGridMarket(0, 0) instanceof RedMarble) ||
        !(game.getCellGridMarket(0, 1) instanceof YellowMarble)||
        !( game.getCellGridMarket(0, 2) instanceof YellowMarble)||
        !( game.getCellGridMarket(0, 3) instanceof BluMarble)||
        !( game.getCellGridMarket(1, 0) instanceof BluMarble)||
        !( game.getCellGridMarket(1, 1) instanceof GreyMarble)||
        !( game.getCellGridMarket(1, 2) instanceof GreyMarble)||
        !( game.getCellGridMarket(1, 3) instanceof PurpleMarble)||
        !( game.getCellGridMarket(2, 0) instanceof PurpleMarble)||
        !( game.getCellGridMarket(2, 1) instanceof WhiteMarble)||
        !( game.getCellGridMarket(2, 2) instanceof WhiteMarble)||
        !( game.getCellGridMarket(2, 3) instanceof WhiteMarble));
    }



    /**
     * test on creation of Market(Extra) with mixed functionality
     */
    @Test
    public void initializationOfExtraMarket()
    {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);

        assertTrue(!( game.getExtraMarket() instanceof RedMarble) ||
                (game.getExtraMarket() instanceof YellowMarble)||
                ( game.getExtraMarket() instanceof YellowMarble)||
                ( game.getExtraMarket() instanceof BluMarble)||
                ( game.getExtraMarket() instanceof BluMarble)||
                ( game.getExtraMarket() instanceof GreyMarble)||
                ( game.getExtraMarket() instanceof GreyMarble)||
                ( game.getExtraMarket() instanceof PurpleMarble)||
                ( game.getExtraMarket() instanceof PurpleMarble)||
                ( game.getExtraMarket() instanceof WhiteMarble)||
                ( game.getExtraMarket() instanceof WhiteMarble)||
                ( game.getExtraMarket() instanceof WhiteMarble));
    }


    /**
     * test about the pushRow
     */
    @Test
    public void PushRowsOfMarket(){

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);


        assertTrue(( game.getCellGridMarket(0, 0) instanceof RedMarble) ||
                (game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                (game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble));

        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(3));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
        game.pushRowInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));


    }




    /**
     * test about the circularity of pushRow
     *
     */
    @Test
public void PushRowsOfMarketCycling() {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);
        game.pushRowInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));

        game.pushRowInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(0));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(1));

        game.setCurrentPlayer();
        game.pushRowInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(3));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(1));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(2));

        game.pushRowInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(2));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(3));

        game.setCurrentPlayer();
        game.pushRowInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(0, 1), game.getInitialMarbleListMarket(1));
        assertEquals(game.getCellGridMarket(0, 2), game.getInitialMarbleListMarket(2));
        assertEquals(game.getCellGridMarket(0, 3), game.getInitialMarbleListMarket(3));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
    }


    /**
     * test about the PushColumn
     */
    @Test
    public void PushColumnsOfMarket(){

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);


        assertTrue(( game.getCellGridMarket(0, 0) instanceof RedMarble) ||
                (game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof YellowMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof BluMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof GreyMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof PurpleMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble)||
                ( game.getCellGridMarket(0, 0) instanceof WhiteMarble));

        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
        game.pushColumnInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));


    }


    /**
     * test about the circularity of PushColumn
     *
     */
    @Test
    public void PushColumnsOfMarketCycling(){

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("ale");
        nickname.add("ali");
        GameMultiPlayer game= new GameMultiPlayer(2,nickname);

        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));
        game.pushColumnInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(0));

        game.setCurrentPlayer();
        game.pushColumnInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(4));

        game.setCurrentPlayer();
        game.pushColumnInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(12));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(8));

        game.setCurrentPlayer();
        game.pushColumnInMarket(0);
        assertEquals(game.getCellGridMarket(0, 0), game.getInitialMarbleListMarket(0));
        assertEquals(game.getCellGridMarket(1, 0), game.getInitialMarbleListMarket(4));
        assertEquals(game.getCellGridMarket(2, 0), game.getInitialMarbleListMarket(8));
        assertEquals(game.getExtraMarket(), game.getInitialMarbleListMarket(12));

    }}

