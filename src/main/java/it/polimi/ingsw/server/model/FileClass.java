package it.polimi.ingsw.server.model;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileClass {
    public static void FileDestroyer(){
        File f = new File("fileConfiguration/GameInit.json");
        if (f.exists())
            f.delete();

       f = new File("fileConfiguration/InformationAboutInkwell.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardOneBluLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardOneGreenLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardOneYellowLatest.json");
        if (f.exists())
            f.delete();
        f = new File("fileConfiguration/DeckProductionCardOneVioletLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/InformationAboutNickname.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardTwoBluLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardTwoGreenLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardTwoYellowLatest.json");
        if (f.exists())
            f.delete();
        f = new File("fileConfiguration/DeckProductionCardTwoVioletLatest.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/DeckProductionCardThreeBluLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardThreeGreenLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckProductionCardThreeYellowLatest.json");
        if (f.exists())
            f.delete();
        f = new File("fileConfiguration/DeckProductionCardThreeVioletLatest.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationPlayerFirst.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationPlayerSecond.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationPlayerThird.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationPlayerFourth.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/InformationAboutCurrentPosition.json");
        if (f.exists())
            f.delete();



        f = new File("fileConfiguration/InformationAboutTurnPlayerNumber.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/LoriMagnific.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/Reserve.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/Market.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/lastTurn.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/DeckActionMarker.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/fileInformationLeaderInitLeaderPlayerFirst.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationInitOnLeaderPlayerFirst.json");
        if (f.exists())
            f.delete();

        

        f = new File("fileConfiguration/fileInformationInitOnResourcePlayerFirst.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/fileInformationLeaderInitLeaderPlayerSecond.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationInitOnLeaderPlayerSecond.json");
        if (f.exists())
            f.delete();



        f = new File("fileConfiguration/fileInformationInitOnResourcePlayerSecond.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/fileInformationLeaderInitLeaderPlayerThird.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationInitOnLeaderPlayerThird.json");
        if (f.exists())
            f.delete();



        f = new File("fileConfiguration/fileInformationInitOnResourcePlayerThird.json");
        if (f.exists())
            f.delete();


        f = new File("fileConfiguration/fileInformationLeaderInitLeaderPlayerFourth.json");
        if (f.exists())
            f.delete();

        f = new File("fileConfiguration/fileInformationInitOnLeaderPlayerFourth.json");
        if (f.exists())
            f.delete();



        f = new File("fileConfiguration/fileInformationInitOnResourcePlayerFourth.json");
        if (f.exists())
            f.delete();


        Gson gson = new Gson();
        FileWriter config = null;
        String jsonStrin = gson.toJson(null,ArrayList.class);
        try {
            config = new FileWriter("fileConfiguration/InformationAboutTurn.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
