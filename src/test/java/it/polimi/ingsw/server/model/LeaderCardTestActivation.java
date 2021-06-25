package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.LeaderCardsGameBoardEmptyException;
import it.polimi.ingsw.server.model.exceptions.RequirementsException;
import it.polimi.ingsw.server.model.gameBoard.*;
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

import static org.junit.jupiter.api.Assertions.*;

class LeaderCardTestActivation {
    /**
     * Check of the correct activation of a reduction leader card
     */
    @Test
    @DisplayName("Activate Reduction Card Test")
    public void activateReductionCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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

        Colour yellow = new Yellow();
        Colour violet = new Violet();

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
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ReductionGameBoard);




        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a reduction leader card double
     */
    @Test
    @DisplayName("Activate Reduction Card Double Test")
    public void activateReductionDoubleCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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

        Colour yellow = new Yellow();
        Colour violet = new Violet();

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN,4);
        LeaderCard leaderCardFive= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN,4);

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
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ReductionGameBoard);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(0), leaderCardFour);

        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFive);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ReductionGameBoardDouble);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(1), leaderCardFive);

        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a production leader card
     */
    @Test
    @DisplayName("Activate Production Card Test")
    public void activateProductionCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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
        Colour yellow = new Yellow();

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);

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


        Map<Resource,Integer> blueFive =new HashMap<>();
        blueFive.put(Resource.COIN, 4);
        blueFive.put(Resource.ROCK, 0);
        blueFive.put(Resource.SERVANT, 0);
        blueFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFiveIn =new HashMap<>() ;
        blueFiveIn.put(Resource.COIN, 0);
        blueFiveIn.put(Resource.ROCK, 0);
        blueFiveIn.put(Resource.SERVANT, 1);
        blueFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFiveOut =new HashMap<>();
        blueFiveOut.put(Resource.COIN, 0);
        blueFiveOut.put(Resource.ROCK, 0);
        blueFiveOut.put(Resource.SERVANT, 0);
        blueFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyOne =new ProductionCard(blueFive, blueFiveIn, blueFiveOut, 5, 2, blue,2,5);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardTwo);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardTwentyFive, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardFortyOne, 0);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ProductionGameBoard);

        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a production leader card double
     */
    @Test
    @DisplayName("Activate Production Card Double Test")
    public void activateProductionDoubleCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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
        Colour yellow = new Yellow();

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);
        LeaderCard leaderCardThree= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);

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


        Map<Resource,Integer> blueFive =new HashMap<>();
        blueFive.put(Resource.COIN, 4);
        blueFive.put(Resource.ROCK, 0);
        blueFive.put(Resource.SERVANT, 0);
        blueFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFiveIn =new HashMap<>() ;
        blueFiveIn.put(Resource.COIN, 0);
        blueFiveIn.put(Resource.ROCK, 0);
        blueFiveIn.put(Resource.SERVANT, 1);
        blueFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFiveOut =new HashMap<>();
        blueFiveOut.put(Resource.COIN, 0);
        blueFiveOut.put(Resource.ROCK, 0);
        blueFiveOut.put(Resource.SERVANT, 0);
        blueFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyOne =new ProductionCard(blueFive, blueFiveIn, blueFiveOut, 5, 2, blue,2,5);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardTwo);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardTwentyFive, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardFortyOne, 0);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ProductionGameBoard);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(0), leaderCardTwo);

        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardThree);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ProductionGameBoardDouble);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(1), leaderCardThree);
        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a white marble leader card
     */
    @Test
    @DisplayName("Activate White Marble Card Test")
    public void activateWhiteMarbleCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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

        Colour green = new Green();
        Colour violet = new Violet();

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);

        Map<Resource,Integer> violetOne =new HashMap<>();
        violetOne.put(Resource.COIN, 0);
        violetOne.put(Resource.ROCK, 0);
        violetOne.put(Resource.SERVANT, 2);
        violetOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneIn=new HashMap<>() ;
        violetOneIn.put(Resource.COIN, 0);
        violetOneIn.put(Resource.ROCK, 1);
        violetOneIn.put(Resource.SERVANT, 0);
        violetOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneOut=new HashMap<>();
        violetOneOut.put(Resource.COIN, 0);
        violetOneOut.put(Resource.ROCK, 0);
        violetOneOut.put(Resource.SERVANT, 0);
        violetOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1,25);


        Map<Resource,Integer> greenFive =new HashMap<>();
        greenFive.put(Resource.COIN, 0);
        greenFive.put(Resource.ROCK, 0);
        greenFive.put(Resource.SERVANT, 0);
        greenFive.put(Resource.SHIELD, 4);
        Map<Resource,Integer> greenFiveIn =new HashMap<>() ;
        greenFiveIn.put(Resource.COIN, 0);
        greenFiveIn.put(Resource.ROCK, 1);
        greenFiveIn.put(Resource.SERVANT, 0);
        greenFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenFiveOut =new HashMap<>();
        greenFiveOut.put(Resource.COIN, 0);
        greenFiveOut.put(Resource.ROCK, 0);
        greenFiveOut.put(Resource.SERVANT, 0);
        greenFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardSeventeen =new ProductionCard(greenFive, greenFiveIn, greenFiveOut, 5, 2, green,2,17 );

        Map<Resource,Integer> violetTwo =new HashMap<>();
        violetTwo.put(Resource.COIN, 1);
        violetTwo.put(Resource.ROCK, 0);
        violetTwo.put(Resource.SERVANT, 1);
        violetTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetTwoIn=new HashMap<>() ;
        violetTwoIn.put(Resource.COIN, 1);
        violetTwoIn.put(Resource.ROCK, 0);
        violetTwoIn.put(Resource.SERVANT, 0);
        violetTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTwoOut=new HashMap<>();
        violetTwoOut.put(Resource.COIN, 0);
        violetTwoOut.put(Resource.ROCK, 0);
        violetTwoOut.put(Resource.SERVANT, 0);
        violetTwoOut.put(Resource.SHIELD, 1);
        ProductionCard cardTwo =new ProductionCard(violetTwo,violetTwoIn,violetTwoOut, 2, 1, violet, 0, 26);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardThree);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardOne, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardSeventeen, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardTwo, 1);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof WhiteMarbleGameBoard);

        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a white marble leader card double
     */
    @Test
    @DisplayName("Activate Double White Marble Card Test")
    public void activateDoubleWhiteMarbleCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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

        Colour green = new Green();
        Colour violet = new Violet();

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);
        LeaderCard leaderCardFour= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);

        Map<Resource,Integer> violetOne =new HashMap<>();
        violetOne.put(Resource.COIN, 0);
        violetOne.put(Resource.ROCK, 0);
        violetOne.put(Resource.SERVANT, 2);
        violetOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneIn=new HashMap<>() ;
        violetOneIn.put(Resource.COIN, 0);
        violetOneIn.put(Resource.ROCK, 1);
        violetOneIn.put(Resource.SERVANT, 0);
        violetOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetOneOut=new HashMap<>();
        violetOneOut.put(Resource.COIN, 0);
        violetOneOut.put(Resource.ROCK, 0);
        violetOneOut.put(Resource.SERVANT, 0);
        violetOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1,25);


        Map<Resource,Integer> greenFive =new HashMap<>();
        greenFive.put(Resource.COIN, 0);
        greenFive.put(Resource.ROCK, 0);
        greenFive.put(Resource.SERVANT, 0);
        greenFive.put(Resource.SHIELD, 4);
        Map<Resource,Integer> greenFiveIn =new HashMap<>() ;
        greenFiveIn.put(Resource.COIN, 0);
        greenFiveIn.put(Resource.ROCK, 1);
        greenFiveIn.put(Resource.SERVANT, 0);
        greenFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenFiveOut =new HashMap<>();
        greenFiveOut.put(Resource.COIN, 0);
        greenFiveOut.put(Resource.ROCK, 0);
        greenFiveOut.put(Resource.SERVANT, 0);
        greenFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardSeventeen =new ProductionCard(greenFive, greenFiveIn, greenFiveOut, 5, 2, green,2,17 );

        Map<Resource,Integer> violetTwo =new HashMap<>();
        violetTwo.put(Resource.COIN, 1);
        violetTwo.put(Resource.ROCK, 0);
        violetTwo.put(Resource.SERVANT, 1);
        violetTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetTwoIn=new HashMap<>() ;
        violetTwoIn.put(Resource.COIN, 1);
        violetTwoIn.put(Resource.ROCK, 0);
        violetTwoIn.put(Resource.SERVANT, 0);
        violetTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTwoOut=new HashMap<>();
        violetTwoOut.put(Resource.COIN, 0);
        violetTwoOut.put(Resource.ROCK, 0);
        violetTwoOut.put(Resource.SERVANT, 0);
        violetTwoOut.put(Resource.SHIELD, 1);
        ProductionCard cardTwo =new ProductionCard(violetTwo,violetTwoIn,violetTwoOut, 2, 1, violet, 0, 26);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardThree);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardOne, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardSeventeen, 0);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardTwo, 1);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof WhiteMarbleGameBoard);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(0), leaderCardThree);

        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFour);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof WhiteMarbleGameBoardDouble);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(1), leaderCardFour);

        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a storage leader card
     */
    @Test
    @DisplayName("Activate Storage Card Test")
    public void activateStorageCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);

        for(int i = 0; i < 5; i++)
            gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addToStrongbox(Resource.COIN);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardOne);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getStorageOfGameBoard() instanceof StorageExtraFirst);

        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct activation of a storage leader card double
     */
    @Test
    @DisplayName("Activate Double Storage Card Test")
    public void activateDoubleStorageCard() throws RequirementsException, LeaderCardsGameBoardEmptyException, IOException, InterruptedException, IOException {
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

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);
        LeaderCard leaderCardTwo= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);

        for(int i = 0; i < 5; i++)
            gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addToStrongbox(Resource.COIN);


        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardOne);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getStorageOfGameBoard() instanceof StorageExtraFirst);

        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(0), leaderCardOne);

        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardTwo);
        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        assertTrue(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getStorageOfGameBoard() instanceof StorageExtraSecond);
        assertEquals(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getLeaderCardsActivated().get(1), leaderCardTwo);

        FileClass.FileDestroyer();
    }

    /**
     * Check of the correct behaviour when the player doesn't have the requirements to activate the card
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

        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardOne);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardTwo);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardThree);
        gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFour);

        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(0);
        }catch (RequirementsException ignored ){
        }

        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(1);
        }catch (RequirementsException ignored ){
        }

        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(2);
        }catch (RequirementsException ignored ){
        }

        try {
            gameMultiPlayer.getPlayerFromList(0).activationLeaderCard(3);
        }catch (RequirementsException ignored ){
        }

        assertFalse(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ReductionGameBoard);
        assertFalse(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof ProductionGameBoard);
        assertFalse(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer() instanceof WhiteMarbleGameBoard);
        assertFalse(gameMultiPlayer.getPlayerFromList(0).getGameBoardOfPlayer().getStorageOfGameBoard() instanceof StorageExtraFirst);

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

    /**
     * Check of the correct behavior of the leader card classes
     */
    @Test
    @DisplayName("Leader Card Test")
    public void LeaderCardTest(){
        Colour blue = new Blue();
        Colour green = new Green();
        Colour yellow = new Yellow();
        Colour violet = new Violet();

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);

        assertEquals(requirementsOne , leaderCardOne.getRequirements());
        assertEquals(1 , leaderCardOne.getKey());
        assertEquals(Resource.ROCK, leaderCardOne.getResourceEffect());
        assertEquals(3, leaderCardOne.getPoints());
        assertEquals("Ability: an extra storage where you can put 2 " + Resource.ROCK, leaderCardOne.toString());

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);

        assertEquals(requirementsFive , leaderCardTwo.getRequirements());
        assertEquals(2 , leaderCardTwo.getKey());
        assertEquals(Resource.SERVANT, leaderCardTwo.getResourceEffect());
        assertEquals(4, leaderCardTwo.getPoints());
        assertEquals("Ability: extra production with input = 1 " + Resource.SERVANT + ", output = 1 resource of your choice and 1 faith point", leaderCardTwo.toString());

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);

        assertEquals(requirementsTen , leaderCardThree.getRequirements());
        assertEquals(3 , leaderCardThree.getKey());
        assertEquals(Resource.COIN, leaderCardThree.getResourceEffect());
        assertEquals(5, leaderCardThree.getPoints());
        assertEquals("Ability: white marble exchange with " + Resource.COIN + " resource", leaderCardThree.toString());

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN,4);

        assertEquals(requirementsFifteen , leaderCardFour.getRequirements());
        assertEquals(4 , leaderCardFour.getKey());
        assertEquals(Resource.COIN, leaderCardFour.getResourceEffect());
        assertEquals(3, leaderCardFour.getPoints());
        assertEquals("Ability: you can subtract a " + Resource.COIN + " from the cost of production cards", leaderCardFour.toString());
    }

}
