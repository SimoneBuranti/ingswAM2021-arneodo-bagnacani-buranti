package it.polimi.ingsw;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardProduction;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardStorage;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import it.polimi.ingsw.server.model.requirements.Requirements;
import it.polimi.ingsw.server.model.requirements.ResourceRequirement;
import it.polimi.ingsw.server.model.requirements.SecondLevelRequirement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductionCardArray {
    ArrayList<LeaderCard> list;
    public ProductionCardArray(){

        list = new ArrayList<>();
        Colour blue = new Blue();
        Colour green = new Green();
        Colour yellow = new Yellow();
        Colour violet = new Violet();


        Requirements requirementsFive = new SecondLevelRequirement(blue);
        LeaderCard leaderCardOne = new LeaderCardProduction(requirementsFive, 4, Resource.SERVANT, 4);
        list.add(leaderCardOne);

        Requirements requirementsTwo = new ResourceRequirement(Resource.ROCK);
        LeaderCard leaderCardTwo = new LeaderCardStorage(requirementsTwo, 3, Resource.SERVANT, 1);
        list.add(leaderCardTwo);
        /*list = new ArrayList<>();
        Blue blue= new Blue();
        Green green = new Green();
        Yellow yellow = new Yellow();
        Violet violet = new Violet();

        Map<Resource,Integer> blueOne =new HashMap<>();
        blueOne.put(Resource.COIN, 2);
        blueOne.put(Resource.ROCK, 0);
        blueOne.put(Resource.SERVANT, 0);
        blueOne.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueOneIn =new HashMap<>() ;
        blueOneIn.put(Resource.COIN, 0);
        blueOneIn.put(Resource.ROCK, 0);
        blueOneIn.put(Resource.SERVANT, 0);
        blueOneIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueOneOut =new HashMap<>();
        blueOneOut.put(Resource.COIN, 0);
        blueOneOut.put(Resource.ROCK, 0);
        blueOneOut.put(Resource.SERVANT, 0);
        blueOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardOne =new ProductionCard(blueOne, blueOneIn, blueOneOut, 1, 1, blue ,1,1);
        list.add(cardOne);
        //list.add(null);

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
        ProductionCard cardFive =new ProductionCard(blueFive, blueFiveIn, blueFiveOut, 5, 2, blue,2,5);
        list.add(cardFive);

        Map<Resource,Integer> blueNine =new HashMap<>();
        blueNine.put(Resource.COIN, 6);
        blueNine.put(Resource.ROCK, 0);
        blueNine.put(Resource.SERVANT, 0);
        blueNine.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueNineIn =new HashMap<>() ;
        blueNineIn.put(Resource.COIN, 0);
        blueNineIn.put(Resource.ROCK, 0);
        blueNineIn.put(Resource.SERVANT, 2);
        blueNineIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueNineOut =new HashMap<>();
        blueNineOut.put(Resource.COIN, 0);
        blueNineOut.put(Resource.ROCK, 0);
        blueNineOut.put(Resource.SERVANT, 0);
        blueNineOut.put(Resource.SHIELD, 3);
        ProductionCard cardNine =new ProductionCard(blueNine, blueNineIn, blueNineOut, 9, 3, blue,2,9);
        list.add(cardNine);

        Map<Resource,Integer> greenOne =new HashMap<>();
        greenOne.put(Resource.COIN, 0);
        greenOne.put(Resource.ROCK, 0);
        greenOne.put(Resource.SERVANT, 0);
        greenOne.put(Resource.SHIELD, 2);
        Map<Resource,Integer> greenOneIn =new HashMap<>() ;
        greenOneIn.put(Resource.COIN, 1);
        greenOneIn.put(Resource.ROCK, 0);
        greenOneIn.put(Resource.SERVANT, 0);
        greenOneIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenOneOut =new HashMap<>();
        greenOneOut.put(Resource.COIN, 0);
        greenOneOut.put(Resource.ROCK, 0);
        greenOneOut.put(Resource.SERVANT, 0);
        greenOneOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirteen =new ProductionCard(greenOne, greenOneIn, greenOneOut, 1, 1, green ,1,13);
        list.add(cardThirteen);

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
        list.add(cardSeventeen);

        Map<Resource,Integer> greenNine =new HashMap<>();
        greenNine.put(Resource.COIN, 0);
        greenNine.put(Resource.ROCK, 0);
        greenNine.put(Resource.SERVANT, 0);
        greenNine.put(Resource.SHIELD, 6);
        Map<Resource,Integer> greenNineIn =new HashMap<>() ;
        greenNineIn.put(Resource.COIN, 0);
        greenNineIn.put(Resource.ROCK, 0);
        greenNineIn.put(Resource.SERVANT, 2);
        greenNineIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenNineOut =new HashMap<>();
        greenNineOut.put(Resource.COIN, 0);
        greenNineOut.put(Resource.ROCK, 3);
        greenNineOut.put(Resource.SERVANT, 0);
        greenNineOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyOne =new ProductionCard(greenNine, greenNineIn, greenNineOut, 9, 3, green,2,21);
        list.add(cardTwentyOne);

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
        ProductionCard cardThirtySeven =new ProductionCard(yellowOne, yellowOneIn, yellowOneOut, 1, 1, yellow ,1,37);
        list.add(cardThirtySeven);

        Map<Resource,Integer> yellowFive =new HashMap<>();
        yellowFive.put(Resource.COIN, 0);
        yellowFive.put(Resource.ROCK, 4);
        yellowFive.put(Resource.SERVANT, 0);
        yellowFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowFiveIn =new HashMap<>() ;
        yellowFiveIn.put(Resource.COIN, 0);
        yellowFiveIn.put(Resource.ROCK, 0);
        yellowFiveIn.put(Resource.SERVANT, 0);
        yellowFiveIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowFiveOut =new HashMap<>();
        yellowFiveOut.put(Resource.COIN, 0);
        yellowFiveOut.put(Resource.ROCK, 0);
        yellowFiveOut.put(Resource.SERVANT, 0);
        yellowFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyOne =new ProductionCard(yellowFive, yellowFiveIn, yellowFiveOut, 5, 2, yellow,2,41);
        list.add(cardFortyOne);

        Map<Resource,Integer> yellowNine =new HashMap<>();
        yellowNine.put(Resource.COIN, 0);
        yellowNine.put(Resource.ROCK, 6);
        yellowNine.put(Resource.SERVANT, 0);
        yellowNine.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowNineIn =new HashMap<>() ;
        yellowNineIn.put(Resource.COIN, 0);
        yellowNineIn.put(Resource.ROCK, 0);
        yellowNineIn.put(Resource.SERVANT, 0);
        yellowNineIn.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowNineOut =new HashMap<>();
        yellowNineOut.put(Resource.COIN, 0);
        yellowNineOut.put(Resource.ROCK, 0);
        yellowNineOut.put(Resource.SERVANT, 3);
        yellowNineOut.put(Resource.SHIELD, 0);
        ProductionCard cardFortyFive =new ProductionCard(yellowNine, yellowNineIn, yellowNineOut, 9, 3, yellow,2,45);
        list.add(cardFortyFive);

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
        ProductionCard cardTwentyFive =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1,25);
        list.add(cardTwentyFive);

        Map<Resource,Integer> violetFive =new HashMap<>();
        violetFive.put(Resource.COIN, 0);
        violetFive.put(Resource.ROCK, 0);
        violetFive.put(Resource.SERVANT, 4);
        violetFive.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFiveIn=new HashMap<>() ;
        violetFiveIn.put(Resource.COIN, 1);
        violetFiveIn.put(Resource.ROCK, 0);
        violetFiveIn.put(Resource.SERVANT, 0);
        violetFiveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetFiveOut=new HashMap<>();
        violetFiveOut.put(Resource.COIN, 0);
        violetFiveOut.put(Resource.ROCK, 0);
        violetFiveOut.put(Resource.SERVANT, 0);
        violetFiveOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentyNine =new ProductionCard(violetFive,violetFiveIn,violetFiveOut, 5, 2, violet,2,29);
        list.add(cardTwentyNine);

        Map<Resource,Integer> violetNine =new HashMap<>();
        violetNine.put(Resource.COIN, 0);
        violetNine.put(Resource.ROCK, 0);
        violetNine.put(Resource.SERVANT, 6);
        violetNine.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetNineIn=new HashMap<>() ;
        violetNineIn.put(Resource.COIN, 0);
        violetNineIn.put(Resource.ROCK, 2);
        violetNineIn.put(Resource.SERVANT, 0);
        violetNineIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetNineOut=new HashMap<>();
        violetNineOut.put(Resource.COIN, 3);
        violetNineOut.put(Resource.ROCK, 0);
        violetNineOut.put(Resource.SERVANT, 0);
        violetNineOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyThree =new ProductionCard(violetNine,violetNineIn,violetNineOut, 9, 3, violet,2,33);
        list.add(cardThirtyThree);*/

    }

    public ArrayList<LeaderCard> getList(){
        return list;
    }
}
