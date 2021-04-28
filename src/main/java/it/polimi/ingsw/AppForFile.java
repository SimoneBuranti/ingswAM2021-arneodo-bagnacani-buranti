package it.polimi.ingsw;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardStorage;
import it.polimi.ingsw.server.model.requirements.Requirements;
import it.polimi.ingsw.server.model.requirements.ResourceRequirement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AppForFile {

    public static void main(String[] args) throws FileNotFoundException {
        FileWriter configGame = null;
        Gson g = new Gson();


        Requirements requirementsThree= new ResourceRequirement(Resource.SHIELD);
        LeaderCard leaderCardThree= new LeaderCardStorage(requirementsThree,3, Resource.COIN);


        String jsonString = g.toJson(leaderCardThree);

        System.out.println(jsonString);
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            configGame = new FileWriter("src/main/resources/configGame");
            configGame.write(jsonString);


        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                configGame.flush();
                configGame.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


    }


}}
