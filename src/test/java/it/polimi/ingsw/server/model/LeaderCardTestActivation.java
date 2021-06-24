package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.LeaderCardsGameBoardEmptyException;
import it.polimi.ingsw.server.model.exceptions.RequirementsException;
import it.polimi.ingsw.server.model.gameBoard.ReductionGameBoard;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import it.polimi.ingsw.server.model.requirements.*;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeaderCardTestActivation {
    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     */
    @Test
    @DisplayName("Activate Test")
    public void activate() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("bb");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();

        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("simo");
        clientController2.setNickname("ali");
        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(2, nickname,true, clientControllers);

        Colour blue = new Blue();
        Colour green = new Green();
        Colour yellow = new Yellow();
        Colour violet = new Violet();

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN,4);
        Map<Resource, Integer> yellowOne = new HashMap<>();
        yellowOne.put(Resource.COIN, 0);
        yellowOne.put(Resource.ROCK, 2);
        yellowOne.put(Resource.SERVANT, 0);
        yellowOne.put(Resource.SHIELD, 0);
        Map<Resource, Integer> yellowOneIn = new HashMap<>();
        yellowOneIn.put(Resource.COIN, 0);
        yellowOneIn.put(Resource.ROCK, 0);
        yellowOneIn.put(Resource.SERVANT, 1);
        yellowOneIn.put(Resource.SHIELD, 0);
        Map<Resource, Integer> yellowOneOut = new HashMap<>();
        yellowOneOut.put(Resource.COIN, 0);
        yellowOneOut.put(Resource.ROCK, 0);
        yellowOneOut.put(Resource.SERVANT, 0);
        yellowOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyFive = new ProductionCard(yellowOne, yellowOneIn, yellowOneOut, 1, 1, yellow, 1, 1);


        Map<Resource, Integer> violetOne = new HashMap<>();
        violetOne.put(Resource.COIN, 0);
        violetOne.put(Resource.ROCK, 0);
        violetOne.put(Resource.SERVANT, 2);
        violetOne.put(Resource.SHIELD, 0);
        Map<Resource, Integer> violetOneIn = new HashMap<>();
        violetOneIn.put(Resource.COIN, 0);
        violetOneIn.put(Resource.ROCK, 1);
        violetOneIn.put(Resource.SERVANT, 0);
        violetOneIn.put(Resource.SHIELD, 0);
        Map<Resource, Integer> violetOneOut = new HashMap<>();
        violetOneOut.put(Resource.COIN, 0);
        violetOneOut.put(Resource.ROCK, 0);
        violetOneOut.put(Resource.SERVANT, 0);
        violetOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne = new ProductionCard(violetOne, violetOneIn, violetOneOut, 1, 1, violet, 1, 1);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFour);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardOne, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardTwentyFive, 1);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException e ){
            new RequirementsException();
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ReductionGameBoard);




        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct behavior of the action marker that discards two production cards from level one deck up to level three deck
     */
    @Test
    @DisplayName("Activate Error Test")
    public void activateError() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("bb");

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        Server server= new Server();

        ClientHandler clientHandler1= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler1) ;

        ClientHandler clientHandler2= new ClientHandler(server);
        ClientController clientController2= new ClientController(server,clientHandler2) ;

        clientControllers.add(clientController);
        clientControllers.add(clientController2);

        clientController.setNickname("simo");
        clientController2.setNickname("ali");
        GameMultiPlayer gameMultiPlayer = new GameMultiPlayer(2, nickname,true, clientControllers);

        Colour blue = new Blue();
        Colour green = new Green();
        Colour yellow = new Yellow();
        Colour violet = new Violet();

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN,4);
        Map<Resource, Integer> yellowOne = new HashMap<>();
        yellowOne.put(Resource.COIN, 0);
        yellowOne.put(Resource.ROCK, 2);
        yellowOne.put(Resource.SERVANT, 0);
        yellowOne.put(Resource.SHIELD, 0);
        Map<Resource, Integer> yellowOneIn = new HashMap<>();
        yellowOneIn.put(Resource.COIN, 0);
        yellowOneIn.put(Resource.ROCK, 0);
        yellowOneIn.put(Resource.SERVANT, 1);
        yellowOneIn.put(Resource.SHIELD, 0);
        Map<Resource, Integer> yellowOneOut = new HashMap<>();
        yellowOneOut.put(Resource.COIN, 0);
        yellowOneOut.put(Resource.ROCK, 0);
        yellowOneOut.put(Resource.SERVANT, 0);
        yellowOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyFive = new ProductionCard(yellowOne, yellowOneIn, yellowOneOut, 1, 1, yellow, 1, 1);


        Map<Resource, Integer> violetOne = new HashMap<>();
        violetOne.put(Resource.COIN, 0);
        violetOne.put(Resource.ROCK, 0);
        violetOne.put(Resource.SERVANT, 2);
        violetOne.put(Resource.SHIELD, 0);
        Map<Resource, Integer> violetOneIn = new HashMap<>();
        violetOneIn.put(Resource.COIN, 0);
        violetOneIn.put(Resource.ROCK, 1);
        violetOneIn.put(Resource.SERVANT, 0);
        violetOneIn.put(Resource.SHIELD, 0);
        Map<Resource, Integer> violetOneOut = new HashMap<>();
        violetOneOut.put(Resource.COIN, 0);
        violetOneOut.put(Resource.ROCK, 0);
        violetOneOut.put(Resource.SERVANT, 0);
        violetOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne = new ProductionCard(violetOne, violetOneIn, violetOneOut, 1, 1, violet, 1, 1);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFour);

        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException e ){
            new RequirementsException();
        }

        assertTrue(!(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ReductionGameBoard));




        FileClass.FileDestroyer();
    }



    /**
     * Check of the correct behavior of the requirements classes
     */
    @Test
    @DisplayName("Requirements Test")
    public void RequirementsTest(){
        Colour blue = new Blue();
        Colour green = new Green();
        Colour yellow = new Yellow();
        Colour violet = new Violet();

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);

        Requirements requirementsTwo= new SecondLevelRequirement(blue);

        Requirements requirementsThree= new ThreeFlagsTwoColourRequirement(violet,green);

        Requirements requirementsFour= new TwoFlagsTwoColourRequirement(yellow,violet);

        assertEquals(Resource.COIN, requirementsOne.getResourceRequirement());
        assertEquals(null, requirementsOne.getColourDoubleRequirement());
        assertEquals(null, requirementsOne.getColourFirstRequirement());
        assertEquals(null, requirementsOne.getColourRequirement());
        assertEquals(null, requirementsOne.getColourSecondRequirement());
        assertEquals(null, requirementsOne.getColourSingleRequirement());
        assertEquals("Requirements : 5 " + Resource.COIN, requirementsOne.toString());


        assertEquals(null, requirementsTwo.getResourceRequirement());
        assertEquals(null, requirementsTwo.getColourDoubleRequirement());
        assertEquals(null, requirementsTwo.getColourFirstRequirement());
        assertEquals(blue, requirementsTwo.getColourRequirement());
        assertEquals(null, requirementsTwo.getColourSecondRequirement());
        assertEquals(null, requirementsTwo.getColourSingleRequirement());
        assertEquals("Requirements : 1 second level " + blue.getColour() + " production card", requirementsTwo.toString());

        assertEquals(null, requirementsThree.getResourceRequirement());
        assertEquals(violet, requirementsThree.getColourDoubleRequirement());
        assertEquals(null, requirementsThree.getColourFirstRequirement());
        assertEquals(null, requirementsThree.getColourRequirement());
        assertEquals(null, requirementsThree.getColourSecondRequirement());
        assertEquals(green, requirementsThree.getColourSingleRequirement());
        assertEquals("Requirements : 1 " + green.getColour() + " and 2 " + violet.getColour() + " production cards", requirementsThree.toString());

        assertEquals(null, requirementsFour.getResourceRequirement());
        assertEquals(null, requirementsFour.getColourDoubleRequirement());
        assertEquals(yellow, requirementsFour.getColourFirstRequirement());
        assertEquals(null, requirementsFour.getColourRequirement());
        assertEquals(violet, requirementsFour.getColourSecondRequirement());
        assertEquals(null, requirementsFour.getColourSingleRequirement());
        assertEquals("Requirements : 1 " + yellow.getColour() + " and 1 " + violet.getColour() + " production cards", requirementsFour.toString());
    }

}
