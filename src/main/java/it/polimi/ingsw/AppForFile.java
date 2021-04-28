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
        FileWriter cofiguration = null;
        Gson g = new Gson();


        Requirements requirementsThree= new ResourceRequirement(Resource.SHIELD);
        LeaderCard leaderCardThree= new LeaderCardStorage(requirementsThree,3, Resource.COIN);
        String jsonString = g.toJson(leaderCardThree);

        Requirements requirementsthwo= new ResourceRequirement(Resource.SHIELD);
        LeaderCard leaderCardtwo= new LeaderCardStorage(requirementsthwo,3, Resource.SHIELD);
        String jsonStrin = g.toJson(leaderCardtwo);

        System.out.println(jsonStrin);
        System.out.println(jsonString);
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            cofiguration = new FileWriter("src/main/resources/cofiguration.json");
            cofiguration.write(jsonString);
            cofiguration.write("\n");
            cofiguration.write(jsonStrin);
            cofiguration.write("");





        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                cofiguration.flush();
                cofiguration.close();
            } catch (IOException e) {

                e.printStackTrace();
            }















    }


}}
