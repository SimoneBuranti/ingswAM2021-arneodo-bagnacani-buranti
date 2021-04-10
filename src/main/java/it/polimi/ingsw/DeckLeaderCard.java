package it.polimi.ingsw;

import java.util.ArrayList;


/**
 * class of Leader Card deck, only 1 object instantiated
 */
public class DeckLeaderCard {


    /**
     * it represents deck
     */
    private static  ArrayList<LeaderCard> deckLeaderCard;
    private Colour blue =new  Blue();
    private Colour green =new  Green();
    private Colour yellow =new  Yellow();
    private Colour violet =new  Violet();

    /**
     * constructor of deck
     */
    public DeckLeaderCard(){

        deckLeaderCard= new ArrayList<>(16);


        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK);

        Requirements requirementsTwo= new ResourceRequirement(Resource.ROCK);
        LeaderCard leaderCardTwo= new LeaderCardStorage(requirementsTwo,3, Resource.SERVANT);

        Requirements requirementsThree= new ResourceRequirement(Resource.SHIELD);
        LeaderCard leaderCardThree= new LeaderCardStorage(requirementsThree,3, Resource.COIN);

        Requirements requirementsFour= new ResourceRequirement(Resource.SERVANT);
        LeaderCard leaderCardFour= new LeaderCardStorage(requirementsFour,3, Resource.SHIELD);





        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardFive= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT);

        Requirements requirementsSix= new SecondLevelRequirement(green);
        LeaderCard leaderCardSix= new LeaderCardProduction(requirementsSix,4, Resource.COIN);

        Requirements requirementsSeven= new SecondLevelRequirement(yellow);
        LeaderCard leaderCardSeven= new LeaderCardProduction(requirementsSeven,4, Resource.SHIELD);

        Requirements requirementsEight= new SecondLevelRequirement(violet);
        LeaderCard leaderCardEight= new LeaderCardProduction(requirementsEight,4, Resource.ROCK);






        Requirements requirementsNine= new ThreeFlagsTwoColourRequirement(blue,yellow);
        LeaderCard leaderCardNine= new LeaderCardMarble(requirementsNine,5, Resource.ROCK);

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardTen= new LeaderCardMarble(requirementsTen,5, Resource.COIN);

        Requirements requirementsEleven= new ThreeFlagsTwoColourRequirement(green,violet);
        LeaderCard leaderCardEleven= new LeaderCardMarble(requirementsEleven,5, Resource.SHIELD);

        Requirements requirementsTwelve= new ThreeFlagsTwoColourRequirement(yellow, blue);
        LeaderCard leaderCardTwelve= new LeaderCardMarble(requirementsTwelve,5, Resource.SERVANT);






        Requirements requirementsThirteen= new TwoFlagsTwoColourRequirement(blue, violet);
        LeaderCard leaderCardThirteen= new LeaderCardStorage(requirementsThirteen,3, Resource.SHIELD);

        Requirements requirementsFourteen= new TwoFlagsTwoColourRequirement(yellow,green);
        LeaderCard leaderCardFourteen= new LeaderCardStorage(requirementsFourteen,3, Resource.SERVANT);

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFifteen= new LeaderCardStorage(requirementsFifteen,3, Resource.COIN);

        Requirements requirementsSixteen= new TwoFlagsTwoColourRequirement(green,blue);
        LeaderCard leaderCardSixteen= new LeaderCardStorage(requirementsSixteen,3, Resource.ROCK);


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

    }


    /**
     * @return deckLeaderCard.size()
     */
    public int size(){
        return deckLeaderCard.size();
    }


    /**
     * method which return card at index position
     * @param index
     * @return deckLeaderCard.get(index)
     */
    public LeaderCard getCardDeck(int index){
        return deckLeaderCard.get(index);
    }


    /**
     * method which return the first deck card and shift all other cards of one position
     * @return deckLeaderCard.get(0)
     */
    public static LeaderCard arrangeDeckLeaderCards(){
        LeaderCard tempLeaderCard=deckLeaderCard.get(0);
        for(int i=0; i<deckLeaderCard.size()-1; i++)
                deckLeaderCard.set(i,deckLeaderCard.get(i+1));
        deckLeaderCard.remove(deckLeaderCard.size()-1);
        return tempLeaderCard;
    }
    }

