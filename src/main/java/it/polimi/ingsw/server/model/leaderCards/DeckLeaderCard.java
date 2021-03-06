package it.polimi.ingsw.server.model.leaderCards;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.util.ArrayList;

/**
 * this class represents the leader card deck
 */
public class DeckLeaderCard {

    /**
     * this attribute collects the leader cards of the deck
     */
    private static  ArrayList<LeaderCard> deckLeaderCard;

    private static ArrayList<LeaderCard> cloneOfLeadercard=new ArrayList<>();

    /**
     * this constructor creates all the leader cards and adds them to the list and shuffles the newly created deck
     */
    public DeckLeaderCard(){

        Colour blue =new Blue();
        Colour green =new Green();
        Colour yellow =new Yellow();
        Colour violet =new Violet();

        deckLeaderCard = new ArrayList<>(16);

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
        LeaderCard leaderCardThirteen = new LeaderCardReduction(requirementsThirteen, 2, Resource.SHIELD, 12);

        Requirements requirementsFourteen = new TwoFlagsTwoColourRequirement(yellow, green);
        LeaderCard leaderCardFourteen = new LeaderCardReduction(requirementsFourteen, 2, Resource.SERVANT, 13);

        Requirements requirementsFifteen = new TwoFlagsTwoColourRequirement(yellow, violet);
        LeaderCard leaderCardFifteen = new LeaderCardReduction(requirementsFifteen, 2, Resource.COIN, 14);

        Requirements requirementsSixteen = new TwoFlagsTwoColourRequirement(green, blue);
        LeaderCard leaderCardSixteen = new LeaderCardReduction(requirementsSixteen, 2, Resource.ROCK, 15);


        deckLeaderCard.add(leaderCardOne);
        deckLeaderCard.add(leaderCardTwo);
        deckLeaderCard.add(leaderCardThree);
        deckLeaderCard.add(leaderCardFour);
        deckLeaderCard.add(leaderCardFive);
        deckLeaderCard.add(leaderCardSix);
        deckLeaderCard.add(leaderCardSeven);
        deckLeaderCard.add(leaderCardEight);
        deckLeaderCard.add(leaderCardNine);
        deckLeaderCard.add(leaderCardTen);
        deckLeaderCard.add(leaderCardEleven);
        deckLeaderCard.add(leaderCardTwelve);
        deckLeaderCard.add(leaderCardThirteen);
        deckLeaderCard.add(leaderCardFourteen);
        deckLeaderCard.add(leaderCardFifteen);
        deckLeaderCard.add(leaderCardSixteen);


        Mix.MIXED(deckLeaderCard);

        copyAll(deckLeaderCard);


    }

    private void copyAll(ArrayList<LeaderCard> deckLeaderCard) {
        for(int i=0; i<deckLeaderCard.size();i++)
            cloneOfLeadercard.add(deckLeaderCard.get(i));
    }


    /**
     * Test only method: this method returns the size of the leader card deck
     * @return int : size of the deck
     */
    public int size(){
        return deckLeaderCard.size();
    }


    /**
     * this method returns the leader card in the index position in the list
     * @param index : the position of the leader card in the list
     * @return LeaderCard : the leaderCard in the index position
     */
    public LeaderCard getCardDeck(int index){
        return deckLeaderCard.get(index);
    }


    /**
     * this method returns the first deck card and shifts all other cards of one position
     * @return LeaderCard : the first leader card of the deck
     */
    public static LeaderCard arrangeDeckLeaderCards(){
        LeaderCard tempLeaderCard=deckLeaderCard.get(0);
        for(int i=0; i<deckLeaderCard.size()-1; i++)
                deckLeaderCard.set(i,deckLeaderCard.get(i+1));
        deckLeaderCard.remove(deckLeaderCard.size()-1);
        return tempLeaderCard;
    }


    /**
     * @param key
     * @return return leader card defined whit key
     */
    public static LeaderCard controlKey(int key){
       for(int i=0; i<cloneOfLeadercard.size(); i++)
           if (key==cloneOfLeadercard.get(i).key)
               return cloneOfLeadercard.get(i);
       return null;
    }
}

