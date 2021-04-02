package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckProductionCard {
    private ArrayList<ProductionCard> deckVioletOne ;
    private ArrayList<ProductionCard> deckVioletTwo ;
    private ArrayList<ProductionCard> deckVioletThree ;

    private ArrayList<ProductionCard> deckGreenOne ;
    private ArrayList<ProductionCard> deckGreenTwo ;
    private ArrayList<ProductionCard> deckGreenThree;

    private ArrayList<ProductionCard> deckYellowOne ;
    private ArrayList<ProductionCard> deckYellowTwo ;
    private ArrayList<ProductionCard> deckYellowThree;

    private ArrayList<ProductionCard> deckBlueOne ;
    private ArrayList<ProductionCard> deckBlueTwo ;
    private ArrayList<ProductionCard> deckBlueThree;


    public DeckProductionCard (){

        DeckvioletOne();
        DeckVioletTwo();
        DeckVioletThree();

        DeckGreenOne();
        DeckGreenTwo();
        DeckGreenThree();

        DeckYellowOne();
        DeckYellowTwo();
        DeckYellowThree();
        
        DeckBlueOne();
        DeckBlueTwo();
        DeckBlueThree();


    }

    public void pickFromDVone(){};
    /**
     * constructor for violetdecklevel1
     */

    private void DeckvioletOne (){
        Violet violet= new Violet();
        deckVioletOne = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardOne =new ProductionCard(violetOne,violetOneIn,violetOneOut, 1, 1, violet,1);
        deckVioletOne.add(cardOne);

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
        ProductionCard cardTwo =new ProductionCard(violetTwo,violetTwoIn,violetTwoOut, 2, 1, violet, 0);
        deckVioletOne.add(cardTwo);



        Map<Resource,Integer> violetThree =new HashMap<>();
        violetThree.put(Resource.COIN, 0);
        violetThree.put(Resource.ROCK, 0);
        violetThree.put(Resource.SERVANT, 3);
        violetThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetThreeIn=new HashMap<>() ;
        violetThreeIn.put(Resource.COIN, 2);
        violetThreeIn.put(Resource.ROCK, 0);
        violetThreeIn.put(Resource.SERVANT, 0);
        violetThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetThreeOut=new HashMap<>();
        violetThreeOut.put(Resource.COIN, 0);
        violetThreeOut.put(Resource.ROCK, 1);
        violetThreeOut.put(Resource.SERVANT, 1);
        violetThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardThree =new ProductionCard(violetThree,violetThreeIn,violetThreeOut, 3, 1, violet, 0);
        deckVioletOne.add(cardThree);


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
        ProductionCard cardSecond =new ProductionCard(violetFour,violetFourIn,violetFourOut, 4, 1, violet, 1);
        deckVioletOne.add(cardSecond);

        Mix.MIXED(deckVioletOne);
    }




    public void pickFromDVtwo(){};
    /**
     * constructor for violetdecklevel2
     */


    private void DeckVioletTwo (){
        Violet violet= new Violet();
        deckVioletTwo = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardFive =new ProductionCard(violetFive,violetFiveIn,violetFiveOut, 5, 2, violet,2);
        deckVioletTwo.add(cardFive);

        Map<Resource,Integer> violetSix =new HashMap<>();
        violetSix.put(Resource.COIN, 2);
        violetSix.put(Resource.ROCK, 0);
        violetSix.put(Resource.SERVANT, 3);
        violetSix.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSixIn=new HashMap<>() ;
        violetSixIn.put(Resource.COIN, 1);
        violetSixIn.put(Resource.ROCK, 0);
        violetSixIn.put(Resource.SERVANT, 1);
        violetSixIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSixOut=new HashMap<>();
        violetSixOut.put(Resource.COIN, 0);
        violetSixOut.put(Resource.ROCK, 0);
        violetSixOut.put(Resource.SERVANT, 0);
        violetSixOut.put(Resource.SHIELD, 3);
        ProductionCard cardSix =new ProductionCard(violetSix,violetSixIn,violetSixOut, 6, 2, violet, 0);
        deckVioletTwo.add(cardSix);



        Map<Resource,Integer> violetSeven =new HashMap<>();
        violetSeven.put(Resource.COIN, 0);
        violetSeven.put(Resource.ROCK, 0);
        violetSeven.put(Resource.SERVANT, 5);
        violetSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSevenIn=new HashMap<>() ;
        violetSevenIn.put(Resource.COIN, 0);
        violetSevenIn.put(Resource.ROCK, 2);
        violetSevenIn.put(Resource.SERVANT, 0);
        violetSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetSevenOut=new HashMap<>();
        violetSevenOut.put(Resource.COIN, 2);
        violetSevenOut.put(Resource.ROCK, 0);
        violetSevenOut.put(Resource.SERVANT, 0);
        violetSevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardSeven =new ProductionCard(violetSeven,violetSevenIn,violetSevenOut, 7, 2, violet, 2);
        deckVioletTwo.add(cardSeven);


        Map<Resource,Integer> violetEight =new HashMap<>();
        violetEight.put(Resource.COIN, 0);
        violetEight.put(Resource.ROCK, 0);
        violetEight.put(Resource.SERVANT, 3);
        violetEight.put(Resource.SHIELD, 3);
        Map<Resource,Integer> violetEightIn=new HashMap<>() ;
        violetEightIn.put(Resource.COIN, 0);
        violetEightIn.put(Resource.ROCK, 1);
        violetEightIn.put(Resource.SERVANT, 0);
        violetEightIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetEightOut=new HashMap<>();
        violetEightOut.put(Resource.COIN, 0);
        violetEightOut.put(Resource.ROCK, 0);
        violetEightOut.put(Resource.SERVANT, 2);
        violetEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardEight =new ProductionCard(violetEight,violetEightIn,violetEightOut, 8, 2, violet, 1);
        deckVioletTwo.add(cardEight);

        Mix.MIXED(deckVioletTwo);
    }


    public void pickFromDVthree(){};

    /**
     * constructor for violetdecklevel3
     */

    private void DeckVioletThree (){
        Violet violet= new Violet();
        deckVioletThree = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardNine =new ProductionCard(violetNine,violetNineIn,violetNineOut, 9, 3, violet,2);
        deckVioletThree.add(cardNine);

        Map<Resource,Integer> violetTen =new HashMap<>();
        violetTen.put(Resource.COIN, 2);
        violetTen.put(Resource.ROCK, 0);
        violetTen.put(Resource.SERVANT, 5);
        violetTen.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTenIn =new HashMap<>() ;
        violetTenIn.put(Resource.COIN, 0);
        violetTenIn.put(Resource.ROCK, 1);
        violetTenIn.put(Resource.SERVANT, 0);
        violetTenIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> violetTenOut =new HashMap<>();
        violetTenOut.put(Resource.COIN, 2);
        violetTenOut.put(Resource.ROCK, 0);
        violetTenOut.put(Resource.SERVANT, 2);
        violetTenOut.put(Resource.SHIELD, 0);
        ProductionCard cardTen =new ProductionCard(violetTen, violetTenIn, violetTenOut, 10, 3, violet, 1);
        deckVioletThree.add(cardTen);



        Map<Resource,Integer> violetEleven =new HashMap<>();
        violetEleven.put(Resource.COIN, 0);
        violetEleven.put(Resource.ROCK, 0);
        violetEleven.put(Resource.SERVANT, 7);
        violetEleven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetElevenIn=new HashMap<>() ;
        violetElevenIn.put(Resource.COIN, 1);
        violetElevenIn.put(Resource.ROCK, 0);
        violetElevenIn.put(Resource.SERVANT, 0);
        violetElevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetElevenOut =new HashMap<>();
        violetElevenOut.put(Resource.COIN, 0);
        violetElevenOut.put(Resource.ROCK, 1);
        violetElevenOut.put(Resource.SERVANT, 0);
        violetElevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardEleven =new ProductionCard(violetEleven,violetElevenIn, violetElevenOut, 11, 3, violet, 3);
        deckVioletThree.add(cardEleven);


        Map<Resource,Integer> violetTwelve =new HashMap<>();
        violetTwelve.put(Resource.COIN, 0);
        violetTwelve.put(Resource.ROCK, 0);
        violetTwelve.put(Resource.SERVANT, 4);
        violetTwelve.put(Resource.SHIELD, 4);
        Map<Resource,Integer> violetTwelveIn =new HashMap<>() ;
        violetTwelveIn.put(Resource.COIN, 1);
        violetTwelveIn.put(Resource.ROCK, 0);
        violetTwelveIn.put(Resource.SERVANT, 0);
        violetTwelveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> violetTwEightOut =new HashMap<>();
        violetTwEightOut.put(Resource.COIN, 0);
        violetTwEightOut.put(Resource.ROCK, 3);
        violetTwEightOut.put(Resource.SERVANT, 1);
        violetTwEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwelve =new ProductionCard(violetTwelve, violetTwelveIn, violetTwEightOut, 12, 3, violet, 0);
        deckVioletThree.add(cardTwelve);

        Mix.MIXED(deckVioletThree);
    }





    public void pickFromDGone(){};


    /**
     * constructor for greendecklevel1
     */

    private void DeckGreenOne (){
        Green green= new Green();
        deckGreenOne = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardThirteen =new ProductionCard(greenOne, greenOneIn, greenOneOut, 1, 1, green ,1);
        deckGreenOne.add(cardThirteen);

        Map<Resource,Integer> greenTwo =new HashMap<>();
        greenTwo.put(Resource.COIN, 0);
        greenTwo.put(Resource.ROCK, 1);
        greenTwo.put(Resource.SERVANT, 1);
        greenTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> greenTwoIn =new HashMap<>() ;
        greenTwoIn.put(Resource.COIN, 0);
        greenTwoIn.put(Resource.ROCK, 1);
        greenTwoIn.put(Resource.SERVANT, 0);
        greenTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTwoOut =new HashMap<>();
        greenTwoOut.put(Resource.COIN, 0);
        greenTwoOut.put(Resource.ROCK, 0);
        greenTwoOut.put(Resource.SERVANT, 1);
        greenTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourteen =new ProductionCard(greenTwo, greenTwoIn, greenTwoOut, 2, 1, green, 0);
        deckGreenOne.add(cardFourteen);



        Map<Resource,Integer> greenThree =new HashMap<>();
        greenThree.put(Resource.COIN, 0);
        greenThree.put(Resource.ROCK, 0);
        greenThree.put(Resource.SERVANT, 0);
        greenThree.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenThreeIn =new HashMap<>() ;
        greenThreeIn.put(Resource.COIN, 0);
        greenThreeIn.put(Resource.ROCK, 0);
        greenThreeIn.put(Resource.SERVANT, 2);
        greenThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenThreeOut =new HashMap<>();
        greenThreeOut.put(Resource.COIN, 1);
        greenThreeOut.put(Resource.ROCK, 1);
        greenThreeOut.put(Resource.SERVANT, 0);
        greenThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardFiveteen =new ProductionCard(greenThree, greenThreeIn, greenThreeOut, 3, 1, green, 0);
        deckGreenOne.add(cardFiveteen);


        Map<Resource,Integer> greenFour =new HashMap<>();
        greenFour.put(Resource.COIN, 2);
        greenFour.put(Resource.ROCK, 0);
        greenFour.put(Resource.SERVANT, 0);
        greenFour.put(Resource.SHIELD, 2);
        Map<Resource,Integer> greenFourIn =new HashMap<>() ;
        greenFourIn.put(Resource.COIN, 0);
        greenFourIn.put(Resource.ROCK, 1);
        greenFourIn.put(Resource.SERVANT, 1);
        greenFourIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenFourOut =new HashMap<>();
        greenFourOut.put(Resource.COIN, 2);
        greenFourOut.put(Resource.ROCK, 0);
        greenFourOut.put(Resource.SERVANT, 0);
        greenFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardSixteen =new ProductionCard(greenFour, greenFourIn, greenFourOut, 4, 1,green, 1);
        deckGreenOne.add(cardSixteen);

        Mix.MIXED(deckGreenOne);
    }



    public void pickFromDGtwo(){};

    /**
     * constructor for greendecklevel2
     */


    private void DeckGreenTwo (){
        Green green= new Green();
        deckGreenTwo  = new ArrayList<ProductionCard>(4);

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
        ProductionCard cardSeventeen =new ProductionCard(greenFive, greenFiveIn, greenFiveOut, 5, 2, green,2);
        deckGreenTwo.add(cardSeventeen);

        Map<Resource,Integer> greenSix =new HashMap<>();
        greenSix.put(Resource.COIN, 0);
        greenSix.put(Resource.ROCK, 0);
        greenSix.put(Resource.SERVANT, 2);
        greenSix.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenSixIn =new HashMap<>() ;
        greenSixIn.put(Resource.COIN, 0);
        greenSixIn.put(Resource.ROCK, 0);
        greenSixIn.put(Resource.SERVANT, 1);
        greenSixIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> greenSixOut =new HashMap<>();
        greenSixOut.put(Resource.COIN, 0);
        greenSixOut.put(Resource.ROCK, 3);
        greenSixOut.put(Resource.SERVANT, 0);
        greenSixOut.put(Resource.SHIELD, 0);
        ProductionCard cardEighteen =new ProductionCard(greenSix, greenSixIn, greenSixOut, 6, 2, green, 0);
        deckGreenTwo.add(cardEighteen);



        Map<Resource,Integer> greenSeven =new HashMap<>();
        greenSeven.put(Resource.COIN, 0);
        greenSeven.put(Resource.ROCK, 0);
        greenSeven.put(Resource.SERVANT, 0);
        greenSeven.put(Resource.SHIELD, 5);
        Map<Resource,Integer> greenSevenIn =new HashMap<>() ;
        greenSevenIn.put(Resource.COIN, 2);
        greenSevenIn.put(Resource.ROCK, 0);
        greenSevenIn.put(Resource.SERVANT, 0);
        greenSevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenSevenOut =new HashMap<>();
        greenSevenOut.put(Resource.COIN, 0);
        greenSevenOut.put(Resource.ROCK, 2);
        greenSevenOut.put(Resource.SERVANT, 0);
        greenSevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardNineteen =new ProductionCard(greenSeven, greenSevenIn, greenSevenOut, 7, 2, green, 2);
        deckGreenTwo.add(cardNineteen);


        Map<Resource,Integer> greenEight =new HashMap<>();
        greenEight.put(Resource.COIN, 3);
        greenEight.put(Resource.ROCK, 0);
        greenEight.put(Resource.SERVANT, 0);
        greenEight.put(Resource.SHIELD, 3);
        Map<Resource,Integer> greenEightIn =new HashMap<>() ;
        greenEightIn.put(Resource.COIN, 1);
        greenEightIn.put(Resource.ROCK, 0);
        greenEightIn.put(Resource.SERVANT, 0);
        greenEightIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenEightOut =new HashMap<>();
        greenEightOut.put(Resource.COIN, 0);
        greenEightOut.put(Resource.ROCK, 0);
        greenEightOut.put(Resource.SERVANT, 0);
        greenEightOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwenty =new ProductionCard(greenEight, greenEightIn, greenEightOut, 8, 2, green, 1);
        deckGreenTwo.add(cardTwenty);

        Mix.MIXED(deckGreenTwo);
    }




    public void pickFromDGthree(){};

    /**
     * constructor for greendecklevel3
     */

    private void DeckGreenThree (){
        Green green = new Green();
        deckGreenThree = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardTwentyone =new ProductionCard(greenNine, greenNineIn, greenNineOut, 9, 3, green,2);
        deckGreenThree.add(cardTwentyone);

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
        ProductionCard cardTwentytwo =new ProductionCard(greenTen, greenTenIn, greenTenOut, 10, 3, green, 1);
        deckGreenThree.add(cardTwentytwo);



        Map<Resource,Integer> greenEleven =new HashMap<>();
        greenEleven.put(Resource.COIN, 0);
        greenEleven.put(Resource.ROCK, 0);
        greenEleven.put(Resource.SERVANT, 0);
        greenEleven.put(Resource.SHIELD, 7);
        Map<Resource,Integer> greenElevenIn =new HashMap<>() ;
        greenElevenIn.put(Resource.COIN, 0);
        greenElevenIn.put(Resource.ROCK, 0);
        greenElevenIn.put(Resource.SERVANT, 1);
        greenElevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenElevenOut =new HashMap<>();
        greenElevenOut.put(Resource.COIN, 1);
        greenElevenOut.put(Resource.ROCK, 0);
        greenElevenOut.put(Resource.SERVANT, 0);
        greenElevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentythree =new ProductionCard(greenEleven, greenElevenIn, greenElevenOut, 11, 3, green, 3);
        deckGreenThree.add(cardTwentythree);


        Map<Resource,Integer> greenTwelve =new HashMap<>();
        greenTwelve.put(Resource.COIN, 4);
        greenTwelve.put(Resource.ROCK, 0);
        greenTwelve.put(Resource.SERVANT, 0);
        greenTwelve.put(Resource.SHIELD, 4);
        Map<Resource,Integer> greenTwelveIn =new HashMap<>() ;
        greenTwelveIn.put(Resource.COIN, 0);
        greenTwelveIn.put(Resource.ROCK, 1);
        greenTwelveIn.put(Resource.SERVANT, 0);
        greenTwelveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> greenTwEightOut =new HashMap<>();
        greenTwEightOut.put(Resource.COIN, 3);
        greenTwEightOut.put(Resource.ROCK, 0);
        greenTwEightOut.put(Resource.SERVANT, 0);
        greenTwEightOut.put(Resource.SHIELD, 1);
        ProductionCard cardTwentyfour =new ProductionCard(greenTwelve, greenTwelveIn, greenTwEightOut, 12, 3, green, 0);
        deckGreenThree.add(cardTwentyfour);

        Mix.MIXED(deckGreenThree);
    }




    public void pickFromDYone(){};






    /**
     * constructor for deckYellowOnelevel1
     */

    private void DeckYellowOne (){
       Yellow yellow= new Yellow();
        deckYellowOne = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardTwentyfive =new ProductionCard(yellowOne, yellowOneIn, yellowOneOut, 1, 1, yellow ,1);
        deckYellowOne.add(cardTwentyfive);

        Map<Resource,Integer> yellowTwo =new HashMap<>();
        yellowTwo.put(Resource.COIN, 1);
        yellowTwo.put(Resource.ROCK, 1);
        yellowTwo.put(Resource.SERVANT, 0);
        yellowTwo.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowTwoIn =new HashMap<>() ;
        yellowTwoIn.put(Resource.COIN, 0);
        yellowTwoIn.put(Resource.ROCK, 0);
        yellowTwoIn.put(Resource.SERVANT, 0);
        yellowTwoIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowTwoOut=new HashMap<>();
        yellowTwoOut.put(Resource.COIN, 1);
        yellowTwoOut.put(Resource.ROCK, 0);
        yellowTwoOut.put(Resource.SERVANT, 0);
        yellowTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardTwentysix =new ProductionCard(yellowTwo, yellowTwoIn,yellowTwoOut, 2, 1, yellow, 0);
        deckYellowOne.add(cardTwentysix );



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
        ProductionCard cardTwentyseven =new ProductionCard(yellowThree, yellowThreeIn, yellowThreeOut, 3, 1, yellow, 0);
        deckYellowOne.add(cardTwentyseven);


        Map<Resource,Integer> yellowFour =new HashMap<>();
        yellowFour.put(Resource.COIN, 0);
        yellowFour.put(Resource.ROCK, 2);
        yellowFour.put(Resource.SERVANT, 0);
        yellowFour.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowFourIn =new HashMap<>() ;
        yellowFourIn.put(Resource.COIN, 1);
        yellowFourIn.put(Resource.ROCK, 0);
        yellowFourIn.put(Resource.SERVANT, 1);
        yellowFourIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowFourOut=new HashMap<>();
        yellowFourOut.put(Resource.COIN, 0);
        yellowFourOut.put(Resource.ROCK, 0);
        yellowFourOut.put(Resource.SERVANT, 0);
        yellowFourOut.put(Resource.SHIELD, 2);
        ProductionCard cardTwentyeight =new ProductionCard(yellowFour, yellowFourIn,yellowFourOut, 4, 1,yellow, 1);
        deckYellowOne.add(cardTwentyeight);

        Mix.MIXED(deckYellowOne);
    }

    public void pickFromDYtwo(){};


    /**
     * constructor for yellowdecklevel2
     */


    private void DeckYellowTwo(){
        Yellow yellow= new Yellow();
        deckYellowTwo = new ArrayList<ProductionCard>(4);

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
        ProductionCard cardTwentynine =new ProductionCard(yellowFive, yellowFiveIn, yellowFiveOut, 5, 2, yellow,2);
        deckYellowTwo.add(cardTwentynine);

        Map<Resource,Integer> yellowSix =new HashMap<>();
        yellowSix.put(Resource.COIN, 0);
        yellowSix.put(Resource.ROCK, 3);
        yellowSix.put(Resource.SERVANT, 0);
        yellowSix.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowSixIn =new HashMap<>() ;
        yellowSixIn.put(Resource.COIN, 0);
        yellowSixIn.put(Resource.ROCK, 1);
        yellowSixIn.put(Resource.SERVANT, 0);
        yellowSixIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowSixOut =new HashMap<>();
        yellowSixOut.put(Resource.COIN, 3);
        yellowSixOut.put(Resource.ROCK, 0);
        yellowSixOut.put(Resource.SERVANT, 0);
        yellowSixOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirty =new ProductionCard(yellowSix, yellowSixIn, yellowSixOut, 6, 2, yellow, 0);
        deckYellowTwo.add(cardThirty);



        Map<Resource,Integer> yellowSeven =new HashMap<>();
        yellowSeven.put(Resource.COIN, 0);
        yellowSeven.put(Resource.ROCK, 5);
        yellowSeven.put(Resource.SERVANT, 0);
        yellowSeven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowSevenIn =new HashMap<>() ;
        yellowSevenIn.put(Resource.COIN, 0);
        yellowSevenIn.put(Resource.ROCK, 0);
        yellowSevenIn.put(Resource.SERVANT, 0);
        yellowSevenIn.put(Resource.SHIELD, 2);
        Map<Resource,Integer> yellowSevenOut =new HashMap<>();
        yellowSevenOut.put(Resource.COIN, 0);
        yellowSevenOut.put(Resource.ROCK, 0);
        yellowSevenOut.put(Resource.SERVANT, 2);
        yellowSevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyone =new ProductionCard(yellowSeven, yellowSevenIn, yellowSevenOut, 7, 2, yellow, 2);
        deckYellowTwo.add(cardThirtyone);


        Map<Resource,Integer> yellowEight =new HashMap<>();
        yellowEight.put(Resource.COIN, 0);
        yellowEight.put(Resource.ROCK, 3);
        yellowEight.put(Resource.SERVANT, 3);
        yellowEight.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowEightIn =new HashMap<>() ;
        yellowEightIn.put(Resource.COIN, 0);
        yellowEightIn.put(Resource.ROCK, 0);
        yellowEightIn.put(Resource.SERVANT, 0);
        yellowEightIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowEightOut =new HashMap<>();
        yellowEightOut.put(Resource.COIN, 2);
        yellowEightOut.put(Resource.ROCK, 0);
        yellowEightOut.put(Resource.SERVANT, 0);
        yellowEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardcardThirtytwo =new ProductionCard(yellowEight, yellowEightIn, yellowEightOut, 8, 2, yellow, 1);
        deckYellowTwo.add(cardcardThirtytwo);

        Mix.MIXED(deckYellowTwo);
    }



    public void pickFromDYthree(){};

    /**
     * constructor for yellowdecklevel3
     */

    private void DeckYellowThree(){
        Yellow yellow= new Yellow();
        deckYellowThree = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardThirtythree =new ProductionCard(yellowNine, yellowNineIn, yellowNineOut, 9, 3, yellow,2);
        deckYellowThree.add(cardThirtythree);

        Map<Resource,Integer> yellowTen =new HashMap<>();
        yellowTen.put(Resource.COIN, 0);
        yellowTen.put(Resource.ROCK, 5);
        yellowTen.put(Resource.SERVANT, 2);
        yellowTen.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowTenIn =new HashMap<>() ;
        yellowTenIn.put(Resource.COIN, 0);
        yellowTenIn.put(Resource.ROCK, 1);
        yellowTenIn.put(Resource.SERVANT, 1);
        yellowTenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowTenOut =new HashMap<>();
        yellowTenOut.put(Resource.COIN, 2);
        yellowTenOut.put(Resource.ROCK, 0);
        yellowTenOut.put(Resource.SERVANT, 0);
        yellowTenOut.put(Resource.SHIELD, 2);
        ProductionCard cardThirtyfour =new ProductionCard(yellowTen, yellowTenIn, yellowTenOut, 10, 3, yellow, 1);
        deckYellowThree.add(cardThirtyfour);



        Map<Resource,Integer> yellowEleven =new HashMap<>();
        yellowEleven.put(Resource.COIN, 0);
        yellowEleven.put(Resource.ROCK, 7);
        yellowEleven.put(Resource.SERVANT, 0);
        yellowEleven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowElevenIn =new HashMap<>() ;
        yellowElevenIn.put(Resource.COIN, 0);
        yellowElevenIn.put(Resource.ROCK, 0);
        yellowElevenIn.put(Resource.SERVANT, 0);
        yellowElevenIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowElevenOut =new HashMap<>();
        yellowElevenOut.put(Resource.COIN, 0);
        yellowElevenOut.put(Resource.ROCK, 0);
        yellowElevenOut.put(Resource.SERVANT, 1);
        yellowElevenOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyfive =new ProductionCard(yellowEleven, yellowElevenIn, yellowElevenOut, 11, 3, yellow, 3);
        deckYellowThree.add(cardThirtyfive);


        Map<Resource,Integer> yellowTwelve =new HashMap<>();
        yellowTwelve.put(Resource.COIN, 0);
        yellowTwelve.put(Resource.ROCK, 4);
        yellowTwelve.put(Resource.SERVANT, 4);
        yellowTwelve.put(Resource.SHIELD, 0);
        Map<Resource,Integer> yellowTwelveIn =new HashMap<>() ;
        yellowTwelveIn.put(Resource.COIN, 0);
        yellowTwelveIn.put(Resource.ROCK, 0);
        yellowTwelveIn.put(Resource.SERVANT, 0);
        yellowTwelveIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> yellowTwEightOut =new HashMap<>();
        yellowTwEightOut.put(Resource.COIN, 0);
        yellowTwEightOut.put(Resource.ROCK, 1);
        yellowTwEightOut.put(Resource.SERVANT, 3);
        yellowTwEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtysix =new ProductionCard(yellowTwelve, yellowTwelveIn, yellowTwEightOut, 12, 3, yellow, 0);
        deckYellowThree.add(cardThirtysix);

        Mix.MIXED(deckYellowThree);
    }

    public void pickFromDBone(){};
    /**
     * constructor for deckblueOnelevel1
     */

    private void DeckBlueOne (){
        Blue blue= new Blue();
        deckBlueOne = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardThirtyseven=new ProductionCard(blueOne, blueOneIn, blueOneOut, 1, 1, blue ,1);
        deckBlueOne.add(cardThirtyseven);

        Map<Resource,Integer> blueTwo =new HashMap<>();
        blueTwo.put(Resource.COIN, 1);
        blueTwo.put(Resource.ROCK, 1);
        blueTwo.put(Resource.SERVANT, 1);
        blueTwo.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwoIn =new HashMap<>() ;
        blueTwoIn.put(Resource.COIN, 0);
        blueTwoIn.put(Resource.ROCK, 0);
        blueTwoIn.put(Resource.SERVANT, 1);
        blueTwoIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwoOut=new HashMap<>();
        blueTwoOut.put(Resource.COIN, 0);
        blueTwoOut.put(Resource.ROCK, 1);
        blueTwoOut.put(Resource.SERVANT, 0);
        blueTwoOut.put(Resource.SHIELD, 0);
        ProductionCard cardThirtyeight =new ProductionCard(blueTwo, blueTwoIn,blueTwoOut, 2, 1, blue, 0);
        deckBlueOne.add(cardThirtyeight);



        Map<Resource,Integer> blueThree =new HashMap<>();
        blueThree.put(Resource.COIN, 3);
        blueThree.put(Resource.ROCK, 0);
        blueThree.put(Resource.SERVANT, 0);
        blueThree.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueThreeIn =new HashMap<>() ;
        blueThreeIn.put(Resource.COIN, 0);
        blueThreeIn.put(Resource.ROCK, 2);
        blueThreeIn.put(Resource.SERVANT, 0);
        blueThreeIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueThreeOut =new HashMap<>();
        blueThreeOut.put(Resource.COIN, 1);
        blueThreeOut.put(Resource.ROCK, 0);
        blueThreeOut.put(Resource.SERVANT, 1);
        blueThreeOut.put(Resource.SHIELD, 1);
        ProductionCard cardThirtynine =new ProductionCard(blueThree, blueThreeIn, blueThreeOut, 3, 1, blue, 0);
        deckBlueOne.add(cardThirtynine);


        Map<Resource,Integer> blueFour =new HashMap<>();
        blueFour.put(Resource.COIN, 2);
        blueFour.put(Resource.ROCK, 0);
        blueFour.put(Resource.SERVANT, 2);
        blueFour.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueFourIn =new HashMap<>() ;
        blueFourIn.put(Resource.COIN, 0);
        blueFourIn.put(Resource.ROCK, 1);
        blueFourIn.put(Resource.SERVANT, 0);
        blueFourIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueFourOut=new HashMap<>();
        blueFourOut.put(Resource.COIN, 0);
        blueFourOut.put(Resource.ROCK, 0);
        blueFourOut.put(Resource.SERVANT, 2);
        blueFourOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourty =new ProductionCard(blueFour, blueFourIn,blueFourOut, 4, 1,blue, 1);
        deckBlueOne.add(cardFourty);

        Mix.MIXED(deckBlueOne);
    }



    public void pickFromDBtwo(){};
    /**
     * constructor for bluedecklevel2
     */


    private void DeckBlueTwo(){
        Blue blue= new Blue();
        deckBlueTwo = new ArrayList<ProductionCard>(4);

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
        ProductionCard cardFourtyone =new ProductionCard(blueFive, blueFiveIn, blueFiveOut, 5, 2, blue,2);
        deckBlueTwo.add(cardFourtyone);

        Map<Resource,Integer> blueSix =new HashMap<>();
        blueSix.put(Resource.COIN, 3);
        blueSix.put(Resource.ROCK, 2);
        blueSix.put(Resource.SERVANT, 0);
        blueSix.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSixIn =new HashMap<>() ;
        blueSixIn.put(Resource.COIN, 1);
        blueSixIn.put(Resource.ROCK, 1);
        blueSixIn.put(Resource.SERVANT, 0);
        blueSixIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueSixOut =new HashMap<>();
        blueSixOut.put(Resource.COIN, 0);
        blueSixOut.put(Resource.ROCK, 0);
        blueSixOut.put(Resource.SERVANT, 3);
        blueSixOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourtyTwo =new ProductionCard(blueSix, blueSixIn, blueSixOut, 6, 2, blue, 0);
        deckBlueTwo.add(cardFourtyTwo);



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
        ProductionCard cardFourtyThree =new ProductionCard(blueSeven, blueSevenIn, blueSevenOut, 7, 2, blue, 2);
        deckBlueTwo.add(cardFourtyThree);


        Map<Resource,Integer> blueEight =new HashMap<>();
        blueEight.put(Resource.COIN, 3);
        blueEight.put(Resource.ROCK, 3);
        blueEight.put(Resource.SERVANT, 0);
        blueEight.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueEightIn =new HashMap<>() ;
        blueEightIn.put(Resource.COIN, 0);
        blueEightIn.put(Resource.ROCK, 0);
        blueEightIn.put(Resource.SERVANT, 1);
        blueEightIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueEightOut =new HashMap<>();
        blueEightOut.put(Resource.COIN, 0);
        blueEightOut.put(Resource.ROCK, 2);
        blueEightOut.put(Resource.SERVANT, 0);
        blueEightOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourtyfour =new ProductionCard(blueEight, blueEightIn, blueEightOut, 8, 2, blue, 1);
        deckBlueTwo.add(cardFourtyfour);

        Mix.MIXED(deckBlueTwo);
    }







   public void pickFromDBthree(){};


    /**
     * constructor for bluedecklevel3
     */

    private void DeckBlueThree(){
        Blue blue= new Blue();
        deckBlueThree = new ArrayList<ProductionCard>(4);
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
        ProductionCard cardFourtyfive =new ProductionCard(blueNine, blueNineIn, blueNineOut, 9, 3, blue,2);
        deckBlueThree .add(cardFourtyfive);

        Map<Resource,Integer> blueTen =new HashMap<>();
        blueTen.put(Resource.COIN, 5);
        blueTen.put(Resource.ROCK, 2);
        blueTen.put(Resource.SERVANT, 0);
        blueTen.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTenIn =new HashMap<>() ;
        blueTenIn.put(Resource.COIN, 1);
        blueTenIn.put(Resource.ROCK, 0);
        blueTenIn.put(Resource.SERVANT, 0);
        blueTenIn.put(Resource.SHIELD, 1);
        Map<Resource,Integer> blueTenOut =new HashMap<>();
        blueTenOut.put(Resource.COIN, 0);
        blueTenOut.put(Resource.ROCK, 2);
        blueTenOut.put(Resource.SERVANT, 2);
        blueTenOut.put(Resource.SHIELD, 0);
        ProductionCard cardFourtysix =new ProductionCard(blueTen, blueTenIn, blueTenOut, 10, 3, blue, 1);
        deckBlueThree.add(cardFourtysix);



        Map<Resource,Integer> blueEleven =new HashMap<>();
        blueEleven.put(Resource.COIN, 7);
        blueEleven.put(Resource.ROCK, 0);
        blueEleven.put(Resource.SERVANT, 0);
        blueEleven.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueElevenIn =new HashMap<>() ;
        blueElevenIn.put(Resource.COIN, 0);
        blueElevenIn.put(Resource.ROCK, 1);
        blueElevenIn.put(Resource.SERVANT, 0);
        blueElevenIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueElevenOut =new HashMap<>();
        blueElevenOut.put(Resource.COIN, 0);
        blueElevenOut.put(Resource.ROCK, 0);
        blueElevenOut.put(Resource.SERVANT, 0);
        blueElevenOut.put(Resource.SHIELD, 1);
        ProductionCard cardFourtyseven =new ProductionCard(blueEleven, blueElevenIn, blueElevenOut, 11, 3, blue, 3);
        deckBlueThree.add(cardFourtyseven);


        Map<Resource,Integer> blueTwelve =new HashMap<>();
        blueTwelve.put(Resource.COIN, 4);
        blueTwelve.put(Resource.ROCK, 4);
        blueTwelve.put(Resource.SERVANT, 0);
        blueTwelve.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwelveIn =new HashMap<>() ;
        blueTwelveIn.put(Resource.COIN, 0);
        blueTwelveIn.put(Resource.ROCK, 0);
        blueTwelveIn.put(Resource.SERVANT, 1);
        blueTwelveIn.put(Resource.SHIELD, 0);
        Map<Resource,Integer> blueTwEightOut =new HashMap<>();
        blueTwEightOut.put(Resource.COIN, 1);
        blueTwEightOut.put(Resource.ROCK, 0);
        blueTwEightOut.put(Resource.SERVANT, 0);
        blueTwEightOut.put(Resource.SHIELD, 3);
        ProductionCard cardFourtyeight =new ProductionCard(blueTwelve, blueTwelveIn, blueTwEightOut, 12, 3, blue, 0);
        deckBlueThree.add(cardFourtyeight);

        Mix.MIXED(deckBlueThree );
    }
}









