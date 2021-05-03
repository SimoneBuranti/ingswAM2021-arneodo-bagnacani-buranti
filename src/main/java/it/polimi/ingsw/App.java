package it.polimi.ingsw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.requirements.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Colour blue =new Blue();
        Colour green =new Green();
        Colour yellow =new Yellow();
        Colour violet =new Violet();

        Requirements requirementsOne= new ResourceRequirement(Resource.COIN);
        LeaderCard leaderCardOne= new LeaderCardStorage(requirementsOne,3, Resource.ROCK);

        Requirements requirementsFive= new SecondLevelRequirement(blue);
        LeaderCard leaderCardTwo= new LeaderCardProduction(requirementsFive,4, Resource.SERVANT);

        Requirements requirementsTen= new ThreeFlagsTwoColourRequirement(violet,green);
        LeaderCard leaderCardThree= new LeaderCardMarble(requirementsTen,5, Resource.COIN);

        Requirements requirementsFifteen= new TwoFlagsTwoColourRequirement(yellow,violet);
        LeaderCard leaderCardFour= new LeaderCardReduction(requirementsFifteen,3, Resource.COIN);

        ArrayList<LeaderCard> leaderCards = new ArrayList<>();

        leaderCards.add(leaderCardOne);
        leaderCards.add(leaderCardTwo);
        leaderCards.add(leaderCardThree);
        leaderCards.add(leaderCardFour);

        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);


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

        Gson gson=new GsonBuilder().setPrettyPrinting().registerTypeAdapterFactory(adapterColour).registerTypeAdapterFactory(adapterRequirements).registerTypeAdapterFactory(adapterLeader).create();

        System.out.println(gson.toJson(leaderCards));

        /*Colour colourGreen = new Green();
        Colour colourYellow = new Yellow();
        Colour colourBlue = new Blue();
        Colour colourViolet = new Violet();
        Requirements requirements = new ResourceRequirement(Resource.COIN);
        Requirements requirements1 = new SecondLevelRequirement(colourBlue);
        Requirements requirements2 = new TwoFlagsTwoColourRequirement(colourGreen, colourViolet);
        Requirements requirements3 = new ThreeFlagsTwoColourRequirement(colourBlue, colourYellow);
        ArrayList<Requirements> list = new ArrayList<>();

        list.add(requirements);
        list.add(requirements1);
        list.add(requirements2);
        list.add(requirements3);

        RuntimeTypeAdapterFactory<Colour> adapterColour =
                RuntimeTypeAdapterFactory
                        .of(Colour.class)
                        .registerSubtype(Green.class)
                        .registerSubtype(Yellow.class)
                        .registerSubtype(Blue.class)
                        .registerSubtype(Violet.class);


        RuntimeTypeAdapterFactory<Requirements> adapter =
                RuntimeTypeAdapterFactory
                        .of(Requirements.class)
                        .registerSubtype(ResourceRequirement.class)
                        .registerSubtype(SecondLevelRequirement.class)
                        .registerSubtype(ThreeFlagsTwoColourRequirement.class)
                        .registerSubtype(TwoFlagsTwoColourRequirement.class);

        Gson gson2=new GsonBuilder().setPrettyPrinting().registerTypeAdapterFactory(adapterColour).registerTypeAdapterFactory(adapter).create();

        System.out.println(gson2.toJson(list));*/

    }
}
