package it.polimi.ingsw.client.lightModel.lightGameBoard;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.util.ArrayList;

public class LightLeaderCards {

    static ArrayList<LeaderCard>  leaderCards;

    public LightLeaderCards() {
        Colour blue = new Blue();
        Colour green = new Green();
        Colour yellow = new Yellow();
        Colour violet = new Violet();

        leaderCards = new ArrayList<>(16);

        Requirements requirementsOne = new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne = new LeaderCardStorage(requirementsOne, 3, Resource.ROCK, 0);

        Requirements requirementsTwo = new ResourceRequirement(Resource.ROCK);
        LeaderCard leaderCardTwo = new LeaderCardStorage(requirementsTwo, 3, Resource.SERVANT, 1);

        Requirements requirementsThree = new ResourceRequirement(Resource.SHIELD);
        LeaderCard leaderCardThree = new LeaderCardStorage(requirementsThree, 3, Resource.COIN, 2);

        Requirements requirementsFour = new ResourceRequirement(Resource.SERVANT);
        LeaderCard leaderCardFour = new LeaderCardStorage(requirementsFour, 3, Resource.SHIELD, 3);


        Requirements requirementsFive = new SecondLevelRequirement(blue);
        LeaderCard leaderCardFive = new LeaderCardProduction(requirementsFive, 4, Resource.SERVANT, 4);

        Requirements requirementsSix = new SecondLevelRequirement(green);
        LeaderCard leaderCardSix = new LeaderCardProduction(requirementsSix, 4, Resource.COIN, 5);

        Requirements requirementsSeven = new SecondLevelRequirement(yellow);
        LeaderCard leaderCardSeven = new LeaderCardProduction(requirementsSeven, 4, Resource.SHIELD, 6);

        Requirements requirementsEight = new SecondLevelRequirement(violet);
        LeaderCard leaderCardEight = new LeaderCardProduction(requirementsEight, 4, Resource.ROCK, 7);


        Requirements requirementsNine = new ThreeFlagsTwoColourRequirement(blue, yellow);
        LeaderCard leaderCardNine = new LeaderCardMarble(requirementsNine, 5, Resource.ROCK, 8);

        Requirements requirementsTen = new ThreeFlagsTwoColourRequirement(violet, green);
        LeaderCard leaderCardTen = new LeaderCardMarble(requirementsTen, 5, Resource.COIN, 9);

        Requirements requirementsEleven = new ThreeFlagsTwoColourRequirement(green, violet);
        LeaderCard leaderCardEleven = new LeaderCardMarble(requirementsEleven, 5, Resource.SHIELD, 10);

        Requirements requirementsTwelve = new ThreeFlagsTwoColourRequirement(yellow, blue);
        LeaderCard leaderCardTwelve = new LeaderCardMarble(requirementsTwelve, 5, Resource.SERVANT, 11);


        Requirements requirementsThirteen = new TwoFlagsTwoColourRequirement(blue, violet);
        LeaderCard leaderCardThirteen = new LeaderCardReduction(requirementsThirteen, 3, Resource.SHIELD, 12);

        Requirements requirementsFourteen = new TwoFlagsTwoColourRequirement(yellow, green);
        LeaderCard leaderCardFourteen = new LeaderCardReduction(requirementsFourteen, 3, Resource.SERVANT, 13);

        Requirements requirementsFifteen = new TwoFlagsTwoColourRequirement(yellow, violet);
        LeaderCard leaderCardFifteen = new LeaderCardReduction(requirementsFifteen, 3, Resource.COIN, 14);

        Requirements requirementsSixteen = new TwoFlagsTwoColourRequirement(green, blue);
        LeaderCard leaderCardSixteen = new LeaderCardReduction(requirementsSixteen, 3, Resource.ROCK, 15);


        leaderCards.add(leaderCardOne);
        leaderCards.add(leaderCardTwo);
        leaderCards.add(leaderCardThree);
        leaderCards.add(leaderCardFour);
        leaderCards.add(leaderCardFive);
        leaderCards.add(leaderCardSix);
        leaderCards.add(leaderCardSeven);
        leaderCards.add(leaderCardEight);
        leaderCards.add(leaderCardNine);
        leaderCards.add(leaderCardTen);
        leaderCards.add(leaderCardEleven);
        leaderCards.add(leaderCardTwelve);
        leaderCards.add(leaderCardThirteen);
        leaderCards.add(leaderCardFourteen);
        leaderCards.add(leaderCardFifteen);
        leaderCards.add(leaderCardSixteen);
    }

    public static LeaderCard leaderCardByKey(int key){
        return leaderCards.get(key);
    }
}
