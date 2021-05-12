package it.polimi.ingsw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.gameBoard.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.players.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.IOException;

public class JsonApp {
    public static void main( String[] args ) throws IOException, InterruptedException {
        //Game game = new GameSolitaire("Ali");
        Reserve reserve = new Reserve();
        Player player = new PlayerFirst("Ali", new Game(false));
        //GameBoardInterface gameBoard = new GameBoard();

        /*Colour blue =new Blue();
        Colour green =new Green();
        Colour yellow =new Yellow();
        Colour violet =new Violet();

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK);

        Requirements requirementsFour= new ResourceRequirement(Resource.SERVANT);
        LeaderCard leaderCardFive= new LeaderCardStorage(requirementsFour,3, Resource.SHIELD);

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT);

        Requirements requirementsSix= new SecondLevelRequirement(blue);
        LeaderCard leaderCardThree= new LeaderCardProduction(requirementsSix,4, Resource.COIN);

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN);

        player.getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardOne);
        player.getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardFive);
        player.getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardTwo);
        player.getGameBoardOfPlayer().addLeaderCardToGameBoard(leaderCardThree);

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
        ProductionCard cardOne=new ProductionCard(blueOne, blueOneIn, blueOneOut, 1, 1, blue ,1,1);

        player.getGameBoardOfPlayer().setProductionCard(cardOne, 0);

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


        player.getGameBoardOfPlayer().setProductionCard(cardFortyOne, 0);

        player.getGameBoardOfPlayer().addToStrongbox(Resource.COIN);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.COIN);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.COIN);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.COIN);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.COIN);

        player.getGameBoardOfPlayer().addToStrongbox(Resource.SERVANT);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.SERVANT);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.SERVANT);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.SERVANT);
        player.getGameBoardOfPlayer().addToStrongbox(Resource.SERVANT);

        try {
            player.activationLeaderCard(0);
        } catch (LeaderCardsGameBoardEmptyException e) {
            e.printStackTrace();
        } catch (RequirementsException e) {
            e.printStackTrace();
        }


        player.getGameBoardOfPlayer().addToStorage(Resource.ROCK);


        try {
            player.activationLeaderCard(0);
        } catch (LeaderCardsGameBoardEmptyException e) {
            e.printStackTrace();
        } catch (RequirementsException e) {
            e.printStackTrace();
        }

        player.getGameBoardOfPlayer().addToStorage(Resource.SHIELD);


        try {
            player.activationLeaderCard(0);
        } catch (LeaderCardsGameBoardEmptyException e) {
            e.printStackTrace();
        } catch (RequirementsException e) {
            e.printStackTrace();
        }

        try {
            player.activationLeaderCard(0);
        } catch (LeaderCardsGameBoardEmptyException e) {
            e.printStackTrace();
        } catch (RequirementsException e) {
            e.printStackTrace();
        }

        try {
            player.getGameBoardOfPlayer().extraProductionOn(Resource.COIN);
        } catch (ImpossibleProductionException e) {
            System.out.println("ImpossibleProductionException");
        } catch (CallForCouncilException e) {
            System.out.println("CallForCouncilException");
        } catch (LastSpaceReachedException e) {
            System.out.println("LastSpaceReachedException");
        }

        try {
            player.getGameBoardOfPlayer().anotherExtraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("ImpossibleProductionException");
        } catch (CallForCouncilException e) {
            System.out.println("CallForCouncilException");
        } catch (LastSpaceReachedException e) {
            System.out.println("LastSpaceReachedException");
        }

        try {
            player.endOfProduction();
        } catch (CallForCouncilException e) {
            e.printStackTrace();
        } catch (LastSpaceReachedException e) {
            e.printStackTrace();
        }*/

        RuntimeTypeAdapterFactory<Storage> adapterStorage =
                RuntimeTypeAdapterFactory
                        .of(Storage.class)
                        .registerSubtype(Storage.class)
                        .registerSubtype(StorageExtraFirst.class)
                        .registerSubtype(StorageExtraSecond.class);


        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);

        RuntimeTypeAdapterFactory<GameBoardInterface> adapterGameBoard =
                RuntimeTypeAdapterFactory
                        .of(GameBoardInterface.class)
                        .registerSubtype(GameBoard.class)
                        .registerSubtype(ProductionGameBoardDouble.class)
                        .registerSubtype(ProductionGameBoard.class)
                        .registerSubtype(WhiteMarbleGameBoard.class)
                        .registerSubtype(WhiteMarbleGameBoardDouble.class)
                        .registerSubtype(ReductionGameBoard.class)
                        .registerSubtype(ReductionGameBoardDouble.class);

        RuntimeTypeAdapterFactory<Player> adapterPlayer =
                RuntimeTypeAdapterFactory
                        .of(Player.class)
                        .registerSubtype(Player.class)
                        .registerSubtype(PlayerFirst.class)
                        .registerSubtype(PlayerFourth.class)
                        .registerSubtype(PlayerSecond.class)
                        .registerSubtype(PlayerThird.class);


        RuntimeTypeAdapterFactory<Requirements> adapterRequirements =
                RuntimeTypeAdapterFactory
                        .of(Requirements.class)
                        .registerSubtype(ResourceRequirement.class)
                        .registerSubtype(SecondLevelRequirement.class)
                        .registerSubtype(ThreeFlagsTwoColourRequirement.class)
                        .registerSubtype(TwoFlagsTwoColourRequirement.class);

        RuntimeTypeAdapterFactory<LeaderCard> adapterLeader =
                RuntimeTypeAdapterFactory
                        .of(LeaderCard.class)
                        .registerSubtype(LeaderCardMarble.class)
                        .registerSubtype(LeaderCardProduction.class)
                        .registerSubtype(LeaderCardReduction.class)
                        .registerSubtype(LeaderCardStorage.class);

        RuntimeTypeAdapterFactory<Game> adapterGame =
                RuntimeTypeAdapterFactory
                        .of(Game.class)
                        .registerSubtype(Game.class)
                        .registerSubtype(GameSolitaire.class)
                        .registerSubtype(GameMultiPlayer.class);

        Gson gson=new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapterFactory(adapterGameBoard)
                .registerTypeAdapterFactory(adapterStorage)
                .registerTypeAdapterFactory(adapterColour)
                .registerTypeAdapterFactory(adapterRequirements)
                .registerTypeAdapterFactory(adapterLeader)
                //.registerTypeAdapterFactory(adapterPlayer)
                .registerTypeAdapterFactory(adapterGame)
                .create();

        System.out.println(gson.toJson(player));

        //String jsonString = gson.toJson(game, Game.class);

        //Game game1 = gson.fromJson(jsonString,Game.class);


        /*try {
            gameBoard1.extraProductionOn(Resource.ROCK);
        } catch (ImpossibleProductionException e) {
            System.out.println("ImpossibleProductionException");
        } catch (CallForCouncilException e) {
            System.out.println("CallForCouncilException");
        } catch (LastSpaceReachedException e) {
            System.out.println("LastSpaceReachedException");
        }*/

        //System.out.println(gson.toJson(gameBoard1));

    }
}
