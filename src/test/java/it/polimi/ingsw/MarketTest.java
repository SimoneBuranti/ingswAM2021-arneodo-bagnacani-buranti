package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketTest {
    /**
     * test on creation of Market(Grid) with mixed functionality
     */
    @Test
    public void InizializationOfGridMarket()
    {


        Market VariableMarket= new Market();
        Player player = new Player("ale");

        assertTrue(!( VariableMarket.getCellGrid(0, 0) instanceof RedMarble) ||
        !(VariableMarket.getCellGrid(0, 1) instanceof YellowMarble)||
        !( VariableMarket.getCellGrid(0, 2) instanceof YellowMarble)||
        !( VariableMarket.getCellGrid(0, 3) instanceof BluMarble)||
        !( VariableMarket.getCellGrid(1, 0) instanceof BluMarble)||
        !( VariableMarket.getCellGrid(1, 1) instanceof GreyMarble)||
        !( VariableMarket.getCellGrid(1, 2) instanceof GreyMarble)||
        !( VariableMarket.getCellGrid(1, 3) instanceof PurpleMarble)||
        !( VariableMarket.getCellGrid(2, 0) instanceof PurpleMarble)||
        !( VariableMarket.getCellGrid(2, 1) instanceof WhiteMarble)||
        !( VariableMarket.getCellGrid(2, 2) instanceof WhiteMarble)||
        !( VariableMarket.getCellGrid(2, 3) instanceof WhiteMarble));
    }



    /**
     * test on creation of Market(Extra) with mixed functionality
     */
    @Test
    public void InizializationOfExtraMarket()
    {
        Market VariableMarket= new Market();
        Player player = new Player("ale");

        assertTrue(!( VariableMarket.getExtra() instanceof RedMarble) ||
                (VariableMarket.getExtra() instanceof YellowMarble)||
                ( VariableMarket.getExtra() instanceof YellowMarble)||
                ( VariableMarket.getExtra() instanceof BluMarble)||
                ( VariableMarket.getExtra() instanceof BluMarble)||
                ( VariableMarket.getExtra() instanceof GreyMarble)||
                ( VariableMarket.getExtra() instanceof GreyMarble)||
                ( VariableMarket.getExtra() instanceof PurpleMarble)||
                ( VariableMarket.getExtra() instanceof PurpleMarble)||
                ( VariableMarket.getExtra() instanceof WhiteMarble)||
                ( VariableMarket.getExtra() instanceof WhiteMarble)||
                ( VariableMarket.getExtra() instanceof WhiteMarble));
    }


    /**
     * test about the pushRow
     */
    @Test
    public void PushRowsOfMarket() throws CallForCouncilException, LastSpaceReachedException {
        Market VariableMarket= new Market();
        Player player = new Player("ale");


        assertTrue(( VariableMarket.getCellGrid(0, 0) instanceof RedMarble) ||
                (VariableMarket.getCellGrid(0, 0) instanceof YellowMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof YellowMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof BluMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof BluMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof GreyMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof GreyMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof PurpleMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof PurpleMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof WhiteMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof WhiteMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof WhiteMarble));

        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
        assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(1)));
        assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(2)));
        assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(3)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(12)));
        VariableMarket.PushRow(0,player);
        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(1)));
        assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(2)));
        assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(3)));
        assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(12)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(0)));


    }




    /**
     * test about the circularity of pushRow
     *
     */
    @Test
public void PushRowsOfMarketCycling() throws CallForCouncilException, LastSpaceReachedException {
        Market VariableMarket= new Market();
       Player player = new Player("ale");
       VariableMarket.PushRow(0,player);
       assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(1)));
       assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(2)));
       assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(3)));
       assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(12)));
       assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(0)));

       VariableMarket.PushRow(0,player);
       assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(2)));
       assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(3)));
       assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(12)));
       assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(0)));
       assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(1)));

       VariableMarket.PushRow(0,player);
       assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(3)));
       assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(12)));
       assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(0)));
       assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(1)));
       assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(2)));

       VariableMarket.PushRow(0,player);
       assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(12)));
       assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(0)));
       assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(1)));
       assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(2)));
       assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(3)));

       VariableMarket.PushRow(0,player);
       assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
       assertTrue(VariableMarket.getCellGrid(0, 1).equals(VariableMarket.getCellInitialMarbleList(1)));
       assertTrue(VariableMarket.getCellGrid(0, 2).equals(VariableMarket.getCellInitialMarbleList(2)));
       assertTrue(VariableMarket.getCellGrid(0, 3).equals(VariableMarket.getCellInitialMarbleList(3)));
       assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(12)));
    }


    /**
     * test about the PushColumn
     */
    @Test
    public void PushColumnsOfMarket() throws CallForCouncilException, LastSpaceReachedException {
        Market VariableMarket= new Market();
        Player player = new Player("ale");


        assertTrue(( VariableMarket.getCellGrid(0, 0) instanceof RedMarble) ||
                (VariableMarket.getCellGrid(0, 0) instanceof YellowMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof YellowMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof BluMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof BluMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof GreyMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof GreyMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof PurpleMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof PurpleMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof WhiteMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof WhiteMarble)||
                ( VariableMarket.getCellGrid(0, 0) instanceof WhiteMarble));

        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(4)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(8)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(12)));
        VariableMarket.PushColumn(0,player);
        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(4)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(8)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(12)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(0)));


    }


    /**
     * test about the circularity of PushColumn
     *
     */
    @Test
    public void PushColumnsOfMarketCycling() throws CallForCouncilException, LastSpaceReachedException {
        Market VariableMarket= new Market();
    Player player = new Player("ale");

        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(4)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(8)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(12)));
        VariableMarket.PushColumn(0,player);
        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(4)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(8)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(12)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(0)));

        VariableMarket.PushColumn(0,player);
        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(8)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(12)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(4)));

        VariableMarket.PushColumn(0,player);
        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(12)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(4)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(8)));

        VariableMarket.PushColumn(0,player);
        assertTrue(VariableMarket.getCellGrid(0, 0).equals(VariableMarket.getCellInitialMarbleList(0)));
        assertTrue(VariableMarket.getCellGrid(1, 0).equals(VariableMarket.getCellInitialMarbleList(4)));
        assertTrue(VariableMarket.getCellGrid(2, 0).equals(VariableMarket.getCellInitialMarbleList(8)));
        assertTrue(VariableMarket.getExtra().equals(VariableMarket.getCellInitialMarbleList(12)));

    }}

