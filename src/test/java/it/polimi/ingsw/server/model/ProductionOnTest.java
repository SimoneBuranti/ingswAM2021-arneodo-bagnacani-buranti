package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;
import it.polimi.ingsw.server.model.colours.Violet;
import it.polimi.ingsw.server.model.colours.Yellow;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.gameBoard.GameBoard;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.gameBoard.ProductionGameBoard;
import it.polimi.ingsw.server.model.gameBoard.ProductionGameBoardDouble;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * test class about ProductionOn
 */
public class ProductionOnTest {
    /**
     * test about BaseProductionOnTest called directly on gameBoard
     *input resources only from storage
     */
    @Test
    @DisplayName("baseProductionOn test: input resources only from storage")
    public void baseProductionOnTest() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        ArrayList<Resource> list = new ArrayList<>();
        list.add(Resource.COIN);
        list.add(Resource.COIN);
        list.add(Resource.SHIELD);
        list.add(Resource.SHIELD);
        list.add(Resource.SHIELD);
        list.add(Resource.SERVANT);
        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException ignored) {}

        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SHIELD, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.SERVANT, Resource.SHIELD, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SERVANT, Resource.SHIELD);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SHIELD, Resource.SERVANT);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SHIELD, Resource.SERVANT);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));

        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(2, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));

    }

    /**
     * test about BaseProductionOnTest called directly on gameBoard
     * input resources from storage and strongbox
     */
    @Test
    @DisplayName("baseProductionOn test: input resources from storage and strongbox")
    public void baseProductionOnSecondTest() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        ArrayList<Resource> list = new ArrayList<>();
        list.add(Resource.COIN);
        list.add(Resource.COIN);
        list.add(Resource.SHIELD);
        list.add(Resource.SHIELD);
        list.add(Resource.SHIELD);
        list.add(Resource.SERVANT);
        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException ignored) {}
        for(int i = 0; i < 5; i++){
            gameBoard.addToStrongbox(Resource.SERVANT);
        }
        for(int i = 0; i < 5; i++){
            gameBoard.addToStrongbox(Resource.SHIELD);
        }
        gameBoard.addToStrongbox(Resource.ROCK);
        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(8, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(6, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.ROCK, Resource.SHIELD, Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(7, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(6, gameBoard.resourceQuantity(Resource.SERVANT));

        gameBoard.endOfProduction();

        assertEquals(3, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(7, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(6, gameBoard.resourceQuantity(Resource.SERVANT));


        list.remove(Resource.COIN);
        list.remove(Resource.SHIELD);
        list.remove(Resource.SHIELD);
        list.remove(Resource.SHIELD);
        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException e) {
            System.out.println("Not enough space in storage");
        }
        assertEquals(3, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(7, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(6, gameBoard.resourceQuantity(Resource.SERVANT));

        list.remove(Resource.SERVANT);
        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException e) {
            System.out.println("Not enough space in storage");
        }
        assertEquals(4, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(7, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(6, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SHIELD, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.SHIELD, Resource.SERVANT, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SHIELD, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.SHIELD, Resource.SERVANT, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.SHIELD, Resource.ROCK, Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.SERVANT, Resource.COIN, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SERVANT));

        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(5, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SERVANT));

        list.remove(Resource.COIN);
        list.add(Resource.SERVANT);
        list.add(Resource.SERVANT);
        list.add(Resource.SERVANT);
        list.add(Resource.ROCK);
        list.add(Resource.ROCK);
        list.add(Resource.SHIELD);
        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException e) {
            System.out.println("Not enough space in storage");
        }
        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(7, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(4, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(6, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.SERVANT, Resource.SERVANT, Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.SHIELD, Resource.ROCK, Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.ROCK, Resource.ROCK, Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        try {
            gameBoard.baseProductionOn(Resource.SERVANT, Resource.ROCK, Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        gameBoard.endOfProduction();

        assertEquals(5, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(3, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SERVANT));
    }
    /**
     * test about BaseProductionOnTest called directly on gameBoard
     * testing "not enough resources in reserve"
     *
     */
    @Test
    @DisplayName("baseProductionOn test: not enough resources in reserve")
    public void baseProductionOnThirdTest() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        for(int i = 0; i < 99; i++){
            gameBoard.addToStrongbox(Resource.ROCK);
        }
        gameBoard.addToStrongbox(Resource.COIN);
        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.SHIELD);
        gameBoard.addToStrongbox(Resource.SHIELD);

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(99, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.SHIELD, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(100, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));

        try {
            gameBoard.baseProductionOn(Resource.SERVANT, Resource.SHIELD, Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }
        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(100, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
    }


    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "no production card in the gameBoard"
     *
     */
    @Test
    @DisplayName("productionOn test: no production card in the gameBoard")
    public void productionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
    }


    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "productionOn test: first level production card"
     *
     */

    @Test
    @DisplayName("productionOn test: first level production card")
    public void productionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        ArrayList<Resource> list = new ArrayList<>();
        list.add(Resource.COIN);
        list.add(Resource.SHIELD);

        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException e) {
            System.out.println("Not enough space in storage");
        }

        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, new Violet(), 1,1);

        gameBoard.setProductionCard(cardOne, 0);

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(0, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(2, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());
    }



    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "productionOn test: second level production card"
     *
     */
    @Test
    @DisplayName("productionOn test: second level production card")
    public void productionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        ArrayList<Resource> list = new ArrayList<>();
        list.add(Resource.COIN);
        list.add(Resource.SHIELD);
        list.add(Resource.SERVANT);
        list.add(Resource.SERVANT);

        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException e) {
            System.out.println("Not enough space in storage");
        }

        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, new Violet(), 1,1);
        gameBoard.setProductionCard(cardOne, 0);

        Map<Resource,Integer> blueSeven =new HashMap<>();
        blueSeven.put(Resource.COIN, 5);
        blueSeven.put(Resource.ROCK, 0);
        blueSeven.put(Resource.SERVANT, 0);
        blueSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenIn =new HashMap<>() ;
        blueSevenIn.put(Resource.COIN, 0);
        blueSevenIn.put(Resource.ROCK, 0);
        blueSevenIn.put(Resource.SERVANT, 2);
        blueSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenOut =new HashMap<>();
        blueSevenOut.put(Resource.COIN, 0);
        blueSevenOut.put(Resource.ROCK, 0);
        blueSevenOut.put(Resource.SERVANT, 0);
        blueSevenOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwo =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, new Blue(), 2,2);
        gameBoard.setProductionCard(cardTwo, 0);

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(0, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());
    }



    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "productionOn test: third level production card"
     *
     */
    @Test
    @DisplayName("productionOn test: third level production card")
    public void productionOnTest3() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, new Violet(), 1,1);
        gameBoard.setProductionCard(cardOne, 0);

        Map<Resource,Integer> blueSeven =new HashMap<>();
        blueSeven.put(Resource.COIN, 5);
        blueSeven.put(Resource.ROCK, 0);
        blueSeven.put(Resource.SERVANT, 0);
        blueSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenIn =new HashMap<>() ;
        blueSevenIn.put(Resource.COIN, 0);
        blueSevenIn.put(Resource.ROCK, 0);
        blueSevenIn.put(Resource.SERVANT, 2);
        blueSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenOut =new HashMap<>();
        blueSevenOut.put(Resource.COIN, 0);
        blueSevenOut.put(Resource.ROCK, 0);
        blueSevenOut.put(Resource.SERVANT, 0);
        blueSevenOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwo =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, new Blue(), 2,2);
        gameBoard.setProductionCard(cardTwo, 0);

        Map<Resource,Integer> greenTen =new HashMap<>();
        greenTen.put(Resource.COIN, 0);
        greenTen.put(Resource.ROCK, 0);
        greenTen.put(Resource.SERVANT, 2);
        greenTen.put(Resource.SHIELD, 5);
        Map<Resource,Integer> greenTenIn =new HashMap<>() ;
        greenTenIn.put(Resource.COIN, 1);
        greenTenIn.put(Resource.ROCK, 0);
        greenTenIn.put(Resource.SERVANT, 1);
        greenTenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTenOut =new HashMap<>();
        greenTenOut.put(Resource.COIN, 0);
        greenTenOut.put(Resource.ROCK, 2);
        greenTenOut.put(Resource.SERVANT, 0);
        greenTenOut.put(Resource.SHIELD, 2);
        ProductionCard cardThree =new ProductionCard(greenTen, greenTenIn, greenTenOut, 10, 3, new Green(), 1,3);
        gameBoard.setProductionCard(cardThree, 0);

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(0, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(2, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());
    }





    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "productionOn test: callForCouncilException"
     *
     */
    @Test
    @DisplayName("productionOn test: callForCouncilException")
    public void productionOnTest4() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.SERVANT);

        try {
            for(int i = 0; i < 7; i++)
                gameBoard.faithMove();
        } catch (CallForCouncilException | LastSpaceReachedException ignored) {}

        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, new Violet(), 1,1);
        gameBoard.setProductionCard(cardOne, 0);

        Map<Resource,Integer> blueSeven =new HashMap<>();
        blueSeven.put(Resource.COIN, 5);
        blueSeven.put(Resource.ROCK, 0);
        blueSeven.put(Resource.SERVANT, 0);
        blueSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenIn =new HashMap<>() ;
        blueSevenIn.put(Resource.COIN, 0);
        blueSevenIn.put(Resource.ROCK, 0);
        blueSevenIn.put(Resource.SERVANT, 2);
        blueSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenOut =new HashMap<>();
        blueSevenOut.put(Resource.COIN, 0);
        blueSevenOut.put(Resource.ROCK, 0);
        blueSevenOut.put(Resource.SERVANT, 0);
        blueSevenOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwo =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, new Blue(), 2,2);
        gameBoard.setProductionCard(cardTwo, 0);

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(7, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(9, gameBoard.getIndicator());


        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(9, gameBoard.getIndicator());
        assertEquals(6, gameBoard.faithScore());
    }


    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "lastSpaceReachedException"
     *
     */
    @Test
    @DisplayName("productionOn test: lastSpaceReachedException")
    public void productionOnTest5() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.SERVANT);

        for(int i = 0; i < 23; i++)
            try{
                gameBoard.faithMove();
            }catch(CallForCouncilException e){
                gameBoard.setPapal();
            }catch(LastSpaceReachedException ignored){}


        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, new Violet(), 1,1);
        gameBoard.setProductionCard(cardOne, 0);

        Map<Resource,Integer> blueSeven =new HashMap<>();
        blueSeven.put(Resource.COIN, 5);
        blueSeven.put(Resource.ROCK, 0);
        blueSeven.put(Resource.SERVANT, 0);
        blueSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenIn =new HashMap<>() ;
        blueSevenIn.put(Resource.COIN, 0);
        blueSevenIn.put(Resource.ROCK, 0);
        blueSevenIn.put(Resource.SERVANT, 2);
        blueSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenOut =new HashMap<>();
        blueSevenOut.put(Resource.COIN, 0);
        blueSevenOut.put(Resource.ROCK, 0);
        blueSevenOut.put(Resource.SERVANT, 0);
        blueSevenOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwo =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, new Blue(), 2,2);
        gameBoard.setProductionCard(cardTwo, 0);

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(23, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(24, gameBoard.getIndicator());


        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(24, gameBoard.getIndicator());
    }


    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "without ProductionGameBoard""
     *
     */
    @Test
    @DisplayName("extraProductionOn test: without ProductionGameBoard")
    public void extraProductionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        try {
            gameBoard.extraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(0, gameBoard.getIndicator());
    }
    /**
     * test about ProductionOnTest called directly on gameBoard
     * testing "with ProductionGameBoard""
     *
     */
    @Test
    @DisplayName("extraProductionOn test: with ProductionGameBoard")
    public void extraProductionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoard(gameBoard, Resource.COIN);

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        try {
            gameBoard.extraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());
    }

    /**
     * test about extraProductionOn called directly on gameBoard
     * testing "call for council exception"
     *
     */
    @Test
    @DisplayName("extraProductionOn test: call for council exception")
    public void extraProductionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoard(gameBoard, Resource.COIN);

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        try {
            for(int i = 0; i < 7; i++)
                gameBoard.faithMove();
        } catch (CallForCouncilException | LastSpaceReachedException ignored) {}

        try {
            gameBoard.extraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(8, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(8, gameBoard.getIndicator());
    }



    /**
     * test about extraProductionOn called directly on gameBoard
     * testing "last space reached exception"
     *
     */
    @Test
    @DisplayName("extraProductionOn test: last space reached exception")
    public void extraProductionOnTest3() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoard(gameBoard, Resource.COIN);

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        for(int i = 0; i < 23; i++)
            try{
                gameBoard.faithMove();
            }catch(CallForCouncilException e){
                gameBoard.setPapal();
            }catch(LastSpaceReachedException ignored){}

        try {
            gameBoard.extraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(24, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(24, gameBoard.getIndicator());
    }


    /**
     * test about anotherExtraProductionOn  called directly on gameBoard
     * testing "without ProductionGameBoardDouble"
     *
     */
    @Test
    @DisplayName("anotherExtraProductionOn test: without ProductionGameBoardDouble")
    public void anotherExtraProductionOnTest0() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        try {
            gameBoard.anotherExtraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(0, gameBoard.getIndicator());
    }
    /**
     * test about anotherExtraProductionOn  called directly on gameBoard
     * testing "with ProductionGameBoardDouble"
     *
     */
    @Test
    @DisplayName("anotherExtraProductionOn test: with ProductionGameBoardDouble")
    public void anotherExtraProductionOnTest1() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoardDouble(gameBoard, Resource.COIN, Resource.SERVANT);

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        try {
            gameBoard.anotherExtraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(1, gameBoard.getIndicator());


        try {
            gameBoard.extraProductionOn(Resource.SHIELD);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        gameBoard.endOfProduction();
        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());
    }

    /**
     * test about anotherExtraProductionOn  called directly on gameBoard
     * testing "call for council exception"
     *
     */

    @Test
    @DisplayName("anotherExtraProductionOn test: call for council exception")
    public void anotherExtraProductionOnTest2() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoardDouble(gameBoard, Resource.COIN, Resource.SERVANT);

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        try {
            for(int i = 0; i < 7; i++)
                gameBoard.faithMove();
        } catch (CallForCouncilException | LastSpaceReachedException ignored) {}

        try {
            gameBoard.anotherExtraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(8, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(8, gameBoard.getIndicator());
    }

    /**
     * test about anotherExtraProductionOn  called directly on gameBoard
     * testing "last space reached exception"
     *
     */
    @Test
    @DisplayName("anotherExtraProductionOn test: last space reached exception")
    public void anotherExtraProductionOnTest3() {
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoardDouble(gameBoard, Resource.COIN, Resource.SERVANT);

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.COIN);

        for(int i = 0; i < 23; i++)
            try{
                gameBoard.faithMove();
            }catch(CallForCouncilException e){
                gameBoard.setPapal();
            }catch(LastSpaceReachedException ignored){}

        try {
            gameBoard.anotherExtraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(24, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(24, gameBoard.getIndicator());
    }
    /**
     * test about all type of productions called directly on gameBoard
     *
     */
    @Test
    @DisplayName("All productions")
    public void allProductionTest(){
        GameBoardInterface gameBoard = new GameBoard();
        new Reserve();
        gameBoard = new ProductionGameBoardDouble(gameBoard, Resource.COIN, Resource.SERVANT);
        ArrayList<Resource> list = new ArrayList<>();
        list.add(Resource.COIN);
        list.add(Resource.COIN);
        list.add(Resource.SERVANT);
        list.add(Resource.SERVANT);
        list.add(Resource.SERVANT);
        list.add(Resource.ROCK);
        try {
            gameBoard.takeFromMarket(list);
        } catch (NotEnoughSpaceInStorageException ignored) {}

        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.SERVANT);
        gameBoard.addToStrongbox(Resource.SHIELD);
        gameBoard.addToStrongbox(Resource.SHIELD);

        Map<Resource,Integer> violetFour =new HashMap<>();
        violetFour.put(Resource.COIN, 0);
        violetFour.put(Resource.ROCK, 2);
        violetFour.put(Resource.SERVANT, 2);
        violetFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFourIn=new HashMap<>() ;
        violetFourIn.put(Resource.COIN, 1);
        violetFourIn.put(Resource.ROCK, 0);
        violetFourIn.put(Resource.SERVANT, 0);
        violetFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetFourOut=new HashMap<>();
        violetFourOut.put(Resource.COIN, 0);
        violetFourOut.put(Resource.ROCK, 2);
        violetFourOut.put(Resource.SERVANT, 0);
        violetFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, new Violet(), 1,1);
        gameBoard.setProductionCard(cardOne, 0);

        Map<Resource,Integer> blueSeven =new HashMap<>();
        blueSeven.put(Resource.COIN, 5);
        blueSeven.put(Resource.ROCK, 0);
        blueSeven.put(Resource.SERVANT, 0);
        blueSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenIn =new HashMap<>() ;
        blueSevenIn.put(Resource.COIN, 0);
        blueSevenIn.put(Resource.ROCK, 0);
        blueSevenIn.put(Resource.SERVANT, 2);
        blueSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSevenOut =new HashMap<>();
        blueSevenOut.put(Resource.COIN, 0);
        blueSevenOut.put(Resource.ROCK, 0);
        blueSevenOut.put(Resource.SERVANT, 0);
        blueSevenOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwo =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, new Blue(), 2,2);
        gameBoard.setProductionCard(cardTwo, 0);

        Map<Resource,Integer> yellowThree =new HashMap<>();
        yellowThree.put(Resource.COIN, 0);
        yellowThree.put(Resource.ROCK, 3);
        yellowThree.put(Resource.SERVANT, 0);
        yellowThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowThreeIn =new HashMap<>() ;
        yellowThreeIn.put(Resource.COIN, 0);
        yellowThreeIn.put(Resource.ROCK, 0);
        yellowThreeIn.put(Resource.SERVANT, 2);
        yellowThreeIn.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowThreeOut =new HashMap<>();
        yellowThreeOut.put(Resource.COIN, 1);
        yellowThreeOut.put(Resource.ROCK, 1);
        yellowThreeOut.put(Resource.SERVANT, 1);
        yellowThreeOut.put(Resource.SHIELD, 0);
        ProductionCard cardThree =new ProductionCard(yellowThree, yellowThreeIn, yellowThreeOut, 3, 1, new Yellow(), 0,3);
        gameBoard.setProductionCard(cardThree, 2);


        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(5, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(0, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(1);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(2);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(1, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());

        try {
            gameBoard.baseProductionOn(Resource.COIN, Resource.ROCK, Resource.SERVANT);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        }

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(2, gameBoard.getIndicator());

        try {
            gameBoard.extraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(3, gameBoard.getIndicator());

        try {
            gameBoard.anotherExtraProductionOn(Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }

        assertEquals(0, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(0, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(0, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(4, gameBoard.getIndicator());

        gameBoard.endOfProduction();

        assertEquals(2, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(2, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(4, gameBoard.getIndicator());

        try {
            gameBoard.extraProductionOn(Resource.SERVANT);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        try {
            gameBoard.extraProductionOn(Resource.SERVANT);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        try {
            gameBoard.anotherExtraProductionOn(Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(2, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(2, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(3, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(7, gameBoard.getIndicator());

        try {
            gameBoard.productionOn(0);
        } catch (ImpossibleProductionException e) {
            System.out.println("Impossible to make this production, try with another");
        } catch (EmptyColumnException e) {
            System.out.println("No cards in this column, try with another");
        }  catch (CallForCouncilException e) {
            System.out.println("Call for council");
            gameBoard.setPapal();
        } catch (LastSpaceReachedException e) {
            System.out.println("Last space of faith path");
            gameBoard.setPapal();
        }
        gameBoard.endOfProduction();

        assertEquals(1, gameBoard.resourceQuantity(Resource.COIN));
        assertEquals(2, gameBoard.resourceQuantity(Resource.ROCK));
        assertEquals(4, gameBoard.resourceQuantity(Resource.SHIELD));
        assertEquals(1, gameBoard.resourceQuantity(Resource.SERVANT));
        assertEquals(9, gameBoard.getIndicator());
    }

}
