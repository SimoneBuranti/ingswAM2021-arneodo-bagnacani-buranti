package it.polimi.ingsw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.requirements.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Colour colourGreen = new Green();
        Colour colourYellow = new Yellow();
        Colour colourBlue = new Blue();
        Colour colourViolet = new Violet();
        Requirements requirements = new ResourceRequirement(Resource.COIN);
        Requirements requirements1 = new SecondLevelRequirement(colourBlue);





        RuntimeTypeAdapterFactory<Requirements> adapter =
                RuntimeTypeAdapterFactory
                        .of(Requirements.class)
                        .registerSubtype(ResourceRequirement.class)
                        .registerSubtype(SecondLevelRequirement.class)
                        .registerSubtype(ThreeFlagsTwoColourRequirement.class)
                        .registerSubtype(TwoFlagsTwoColourRequirement.class);

        Gson gson2=new GsonBuilder().setPrettyPrinting().registerTypeAdapterFactory(adapter).create();

        System.out.println(gson2.toJson(requirements1));

}}
