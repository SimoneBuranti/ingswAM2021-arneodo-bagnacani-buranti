package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.server.model.Resource;

import java.awt.*;

public abstract class Paths {



    public static Image getProdImageFromKey(int key){

        String srcPath = "src/main/resources/resources/front/";

        switch(key) {
            case 1 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-3-1.png");
            case 2 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-7-1.png");
            case 3 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-11-1.png");
            case 4 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-15-1.png");
            case 5 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-19-1.png");
            case 6 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-23-1.png");
            case 7 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-27-1.png");
            case 8 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-31-1.png");
            case 9 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-35-1.png");
            case 10 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-39-1.png");
            case 11 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-43-1.png");
            case 12 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-47-1.png");
            case 13 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-1-1.png");
            case 14 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-5-1.png");
            case 15 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-9-1.png");
            case 16 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-13-1.png");
            case 17 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-17-1.png");
            case 18 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-21-1.png");
            case 19 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-25-1.png");
            case 20 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-29-1.png");
            case 21 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-33-1.png");
            case 22 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-37-1.png");
            case 23 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-41-1.png");
            case 24 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-46-1.png");
            case 25 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-2-1.png");
            case 26 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-6-1.png");
            case 27 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-10-1.png");
            case 28 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-14-1.png");
            case 29 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-18-1.png");
            case 30 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-22-1.png");
            case 31 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-26-1.png");
            case 32 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-30-1.png");
            case 33 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-34-1.png");
            case 34 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-38-1.png");
            case 35 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-42-1.png");
            case 36 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-46-1.png");
            case 37 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-4-1.png");
            case 38 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-8-1.png");
            case 39 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-12-1.png");
            case 40 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-16-1.png");
            case 41 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-20-1.png");
            case 42 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-24-1.png");
            case 43 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-28-1.png");
            case 44 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-32-1.png");
            case 45 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-36-1.png");
            case 46 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-40-1.png");
            case 47 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-44-1.png");
            case 48 :
                return Toolkit.getDefaultToolkit().createImage(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-48-1.png");
        }
        return null;
    }

    public static Image getPapalCardImageFromCurrCall(int currCall){

        String srcPath = "src/main/resources/resources/punchboard/";

        switch(currCall) {
            case 0:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "quadrato giallo.png");
            case 1:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "quadrato arancione.png");
            case 2:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "quadrato rosso.png");
            default: return Toolkit.getDefaultToolkit().createImage(srcPath + "quadrato rosso.png");
        }
    }

    public static Image getLeaderImageFromKey(int key){

        String srcPath = "src/main/resources/resources/front/";

        switch(key) {
            case 0:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-56-1.png");
            case 1:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-53-1.png");
            case 2:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-55-1.png");
            case 3:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-54-1.png");


            case 4:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-62-1.png");
            case 5:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-64-1.png");
            case 6:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-61-1.png");
            case 7:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-63-1.png");


                case 8:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-59-1.png");
            case 9:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-60-1.png");
            case 10:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-58-1.png");
            case 11:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-57-1.png");


           case 12:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-50-1.png");
            case 13:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-49-1.png");
            case 14:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-52-1.png");
            case 15:
                return Toolkit.getDefaultToolkit().createImage(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-51-1.png");
                }
        return null;
    }





    public static Image getImageFromPath(String path){
        return Toolkit.getDefaultToolkit().createImage(path);

    }

    public static Image getImageFromResource(Resource selected) {

        switch(selected) {
            case COIN: {
                return Paths.getImageFromPath("src/main/resources/resources/punchboard/coin.png");
            }
            case ROCK: {
                return Paths.getImageFromPath("src/main/resources/resources/punchboard/stone.png");
            }
            case SHIELD: {
                return Paths.getImageFromPath("src/main/resources/resources/punchboard/shield.png");
            }
            case SERVANT: {
                return Paths.getImageFromPath("src/main/resources/resources/punchboard/servant.png");
            }
        }
        return Paths.getImageFromPath("src/main/resources/resources/punchboard/coin.png");
    }






}
