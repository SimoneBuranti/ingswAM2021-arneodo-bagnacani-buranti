package it.polimi.ingsw;

import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCardTwoYellow;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReserveTest {
    public static void main(String[] args) throws IOException, RequirementsException, LeaderCardsGameBoardEmptyException, EmptyException, FullColumnException, EndGameException, NotEnoughResourcesException, LevelException, InterruptedException {

        ArrayList<String> nickname =new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("ii");


       /* GameSolitaire gameMultiPlayer1 =new GameSolitaire( "nickname",true);
        gameMultiPlayer1.saveInformation();

        GameSolitaire gameMultiPlayer2 =new GameSolitaire( "nickname",false);*/

        ArrayList<ClientController> clientControllers = new ArrayList<>();
        GameMultiPlayer gameMultiPlayer3 =new GameMultiPlayer(2,nickname,true, clientControllers);

        Colour blue =new Blue();
        Colour green =new Green();
        Colour yellow =new Yellow();
        Colour violet =new Violet();
        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK,1);

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT,2);

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN,3);

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN,4);

        Map<Resource,Integer> yellowOne =new HashMap<>();
        yellowOne.put(Resource.COIN, 0);
        yellowOne.put(Resource.ROCK, 2);
        yellowOne.put(Resource.SERVANT, 0);
        yellowOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowOneIn =new HashMap<>() ;
        yellowOneIn.put(Resource.COIN, 0);
        yellowOneIn.put(Resource.ROCK, 0);
        yellowOneIn.put(Resource.SERVANT, 1);
        yellowOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowOneOut =new HashMap<>();
        yellowOneOut.put(Resource.COIN, 0);
        yellowOneOut.put(Resource.ROCK, 0);
        yellowOneOut.put(Resource.SERVANT, 0);
        yellowOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyFive =new ProductionCard(yellowOne, yellowOneIn, yellowOneOut, 1, 1, yellow ,1,1);




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
        ProductionCard cardOne =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1,1);

        DeckProductionCardTwoYellow deckProductionCardTwoYellow = new DeckProductionCardTwoYellow();
        gameMultiPlayer3.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFour);
        gameMultiPlayer3.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardOne,0);
        gameMultiPlayer3.getPlayerFromList(0).getGameBoardOfPlayer().setProductionCard(cardTwentyFive,1);
        gameMultiPlayer3.getPlayerFromList(0).activationLeaderCard(0);

        //gameMultiPlayer3.getPlayerFromList(0).buyProductionCard(deckProductionCardTwoYellow,0);

        gameMultiPlayer3.saveInformation();

        ArrayList<ClientController> clientControllers2 = new ArrayList<>();
        GameMultiPlayer gameMultiPlayer4 =new GameMultiPlayer( 2,nickname,false, clientControllers);

        gameMultiPlayer4.saveInformation();
        ArrayList<ClientController> clientControllers22 = new ArrayList<>();
        GameMultiPlayer gameMultiPlayer5 =new GameMultiPlayer( 2,nickname,false, clientControllers);
        gameMultiPlayer5.getPlayerFromList(0).getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardThree);

        gameMultiPlayer5.endGame();






    }
}
