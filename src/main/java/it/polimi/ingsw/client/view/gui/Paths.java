package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.server.model.Resource;

import java.awt.*;


/**
 * This abstract class contains several useful method for the graphical part of the game.
 */
public abstract class Paths {


    /**
     * Given the production card key this method returns the corresponding image.
     * @param key
     * @return
     */
    public static Image getProdImageFromKey(int key){

        String srcPath = "/front/";

        switch(key) {
            case 1 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-3-1.png"));
            case 2 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-7-1.png"));
            case 3 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-11-1.png"));
            case 4 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-15-1.png"));
            case 5 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-19-1.png"));
            case 6 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-23-1.png"));
            case 7 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-27-1.png"));
            case 8 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-31-1.png"));
            case 9 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-35-1.png"));
            case 10 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-39-1.png"));
            case 11 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-43-1.png"));
            case 12 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-47-1.png"));
            case 13 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-1-1.png"));
            case 14 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-5-1.png"));
            case 15 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-9-1.png"));
            case 16 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-13-1.png"));
            case 17 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-17-1.png"));
            case 18 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-21-1.png"));
            case 19 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-25-1.png"));
            case 20 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-29-1.png"));
            case 21 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-33-1.png"));
            case 22 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-37-1.png"));
            case 23 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-41-1.png"));
            case 24 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-45-1.png"));
            case 25 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-2-1.png"));
            case 26 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-6-1.png"));
            case 27 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-10-1.png"));
            case 28 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-14-1.png"));
            case 29 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-18-1.png"));
            case 30 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-22-1.png"));
            case 31 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-26-1.png"));
            case 32 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-30-1.png"));
            case 33 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-34-1.png"));
            case 34 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-38-1.png"));
            case 35 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-42-1.png"));
            case 36 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-46-1.png"));
            case 37 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-4-1.png"));
            case 38 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-8-1.png"));
            case 39 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-12-1.png"));
            case 40 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-16-1.png"));
            case 41 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-20-1.png"));
            case 42 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-24-1.png"));
            case 43 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-28-1.png"));
            case 44 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-32-1.png"));
            case 45 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-36-1.png"));
            case 46 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-40-1.png"));
            case 47 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-44-1.png"));
            case 48 :
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath+"Masters of Renaissance_Cards_FRONT_3mmBleed_1-48-1.png"));
        }
        return null;
    }

    /**
     * This method returns the correct papal card back image given its index.
     * @param currCall
     * @return
     */
    public static Image getPapalCardBackImageFromCurrCall(int currCall){

        String srcPath = "/punchboard/";

        switch(currCall) {
            case 0:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "quadrato giallo.png"));
            case 1:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "quadrato arancione.png"));
            case 2:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "quadrato rosso.png"));
            default: return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "quadrato rosso.png"));
        }
    }

    /**
     * This method returns the correct papal card front image given its index.
     * @param currCall
     * @return
     */
    public static Image getPapalCardFrontImageFromCurrCall(int currCall){

        String srcPath = "/punchboard/";

        switch(currCall) {
            case 0:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "carte-05.png"));
            case 1:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "carte-03.png"));
            case 2:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "carte-04.png"));
            default: return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "carte-04.png"));
        }
    }

    /**
     * This method returns the correct leader card image given its key.
     * @param key
     */
    public static Image getLeaderImageFromKey(int key){

        String srcPath = "/front/";

        switch(key) {
            case 0:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-53-1.png"));
            case 1:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-54-1.png"));
            case 2:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-56-1.png"));
            case 3:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-55-1.png"));


            case 4:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-62-1.png"));
            case 5:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-64-1.png"));
            case 6:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-61-1.png"));
            case 7:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-63-1.png"));


            case 8:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-59-1.png"));
            case 9:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-60-1.png"));
            case 10:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-58-1.png"));
            case 11:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-57-1.png"));


            case 12:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-50-1.png"));
            case 13:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-49-1.png"));
            case 14:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-52-1.png"));
            case 15:
                return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(srcPath + "Masters of Renaissance_Cards_FRONT_3mmBleed_1-51-1.png"));
                }
        return null;
    }


    /**
     * General method: it returns the image of a general path.
     * @param path
     * @return
     */
    public static Image getImageFromPath(String path){
        return Toolkit.getDefaultToolkit().createImage(Paths.class.getResource(path));

    }

    /**
     * Given the resource type this method returns the corresponding image.
     * @param selected
     * @return
     */
    public static Image getImageFromResource(Resource selected) {

        switch(selected) {
            case COIN: {
                return Paths.getImageFromPath("/punchboard/coin.png");
            }
            case ROCK: {
                return Paths.getImageFromPath("/punchboard/stone.png");
            }
            case SHIELD: {
                return Paths.getImageFromPath("/punchboard/shield.png");
            }
            case SERVANT: {
                return Paths.getImageFromPath("/punchboard/servant.png");
            }
        }
        return Paths.getImageFromPath("/punchboard/coin.png");
    }


    /**
     * Given the action marker type this method returns the corresponding image.
     * @param actionMarker
     * @return
     */
    public static Image getImageFromActionMarker(String actionMarker) {
        switch(actionMarker) {
            case "ActionMarkerProductionYellow" : {
                return Paths.getImageFromPath("/punchboard/cerchio4.png");
            }
            case "ActionMarkerProductionGreen" : {
                return Paths.getImageFromPath("/punchboard/cerchio2.png");
            }
            case "ActionMarkerProductionBlue" : {
                return Paths.getImageFromPath("/punchboard/cerchio1.png");
            }
            case "ActionMarkerProductionViolet" : {
                return Paths.getImageFromPath("/punchboard/cerchio3.png");
            }
            case "ActionMarkerForCrossOnce" : {
                return Paths.getImageFromPath("/punchboard/cerchio7.png");
            }
            case "ActionMarkerForCrossDouble" : {
                return Paths.getImageFromPath("/punchboard/cerchio6.png");
            }
        }
        return Paths.getImageFromPath("/punchboard/cerchio4.png");
    }
}
