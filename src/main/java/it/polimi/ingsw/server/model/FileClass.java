package it.polimi.ingsw.server.model;

import java.io.File;

public class FileClass {
    public static void FileDestroyer(){

        File f = new File("src/main/resources/GameInit.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardOneBluLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardOneGreenLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardOneYellowLatest.json");
        if (f.exists())
            f.delete();
        f = new File("src/main/resources/DeckProductionCardOneVioletLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardTwoBluLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardTwoGreenLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardTwoYellowLatest.json");
        if (f.exists())
            f.delete();
        f = new File("src/main/resources/DeckProductionCardTwoVioletLatest.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/DeckProductionCardThreeBluLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardThreeGreenLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/DeckProductionCardThreeYellowLatest.json");
        if (f.exists())
            f.delete();
        f = new File("src/main/resources/DeckProductionCardThreeVioletLatest.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/fileInformationPlayerFirst.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/fileInformationPlayerSecond.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/fileInformationPlayerThird.json");
        if (f.exists())
            f.delete();

        f = new File("src/main/resources/fileInformationPlayerFourth.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/InformationAboutCurrentPosition.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/InformationAboutTurn.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/InformationAboutTurnPlayerNumber.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/LoriMagnific.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/Reserve.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/Market.json");
        if (f.exists())
            f.delete();


        f = new File("src/main/resources/lastTurn.json");
        if (f.exists())
            f.delete();

    }
}
