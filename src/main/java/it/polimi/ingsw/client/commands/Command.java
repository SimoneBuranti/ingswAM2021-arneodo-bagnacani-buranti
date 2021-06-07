package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.view.*;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.Resource;

import java.util.Scanner;

/**
 * The Command class represents the general features of a command.
 */

public abstract class Command {

    /**
     * The commandOn() method represents the specific command action. Every command implements this method in a different
     * way depending on the command aim.
     * @return
     * @throws SpentTokenException
     * @throws InvalidCommandException
     * @throws AlreadyActivatedProductionException
     * @throws NoMessageReturnException
     * @throws EndAfterThisException
     * @throws InitLeaderCardsException
     */
    public Message commandOn() throws SpentTokenException, InvalidCommandException, AlreadyActivatedProductionException, NoMessageReturnException, EndAfterThisException, InitLeaderCardsException {
        throw new NoMessageReturnException();
    }

    /**
     * This method returns the command structure which is printed whenever the player types the help command.
     * @return
     */
    public static String defToString(){
        return "";
    }

    /**
     * This method parses the resource type from a string to a Resource type.
     * @param resource
     */
    public static Resource fromStringToResource(String resource){
        //resource.toLowerCase();
        switch (resource) {
            case "coin":
                return Resource.COIN;
            case "rock":
                return Resource.ROCK;
            case "shield":
                return Resource.SHIELD;
            case "servant":
                return Resource.SERVANT;
            default :
                return null;
        }
    }

    /**
     *This method displays the resource accepted text and parse the written word.
     *If it is correct it returns the resource type.
     *@return
     */
    public static Resource askForOutputResource(){
        Scanner in = new Scanner(System.in);
        Resource o;
        System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
        System.out.println("Output resource type: ");
        while ((o = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }
        return o;
    }

    /**
     * This method displays the resource accepted text and parse the written word.
     * If it is correct it returns the resource type.
     * @return
     */
    public static Resource askForInputResource(){
        Scanner in = new Scanner(System.in);
        Resource i;
        System.out.println("COIN: 'coin'        ROCK: 'rock'        SHIELD: 'shield'        SERVANT: 'servant'");
        System.out.println("Input resource type: ");
        while ((i = fromStringToResource(in.nextLine())) == null){
            System.out.println("Invalid resource type");
        }
        return i;
    }

    /**
     * This method cuts the initial spaces of a string.
     * @param word
     * @return
     */
    public static String deleteInitSpaces(String word){
        for(int s = 0; s <word.length();s++){
            if(word.charAt(s)!=' '){
                return word.substring(s);
            }
        }
        return "";
    }

    /**
     * This is the general implementation of the conversion from a string to its int value.
     * @param number
     * @return
     */
    public static int fromStringToInt(String number){
        int n = 0;

        for(int i = 0;i<number.length();i++){
            n*=10;
            n+= number.charAt(i) -'0';
        }
        return n;
    }

    /**
     * This is the general implementation of the conversion from an int to its string representation.
     * @param num
     * @return
     */
    public static String fromIntToString(int num){
        String parsed = "";
        String temp = "";
        char figure;
        while( num>0 ){
            figure = (char) ((num%10) + '0');
            num /= 10;
            temp += figure;
        }
        for (int i=temp.length()-1;i>=0;i--){
            parsed += temp.charAt(i);
        }
        return parsed;
    }

    /**
     * Every command has a different to string. If the command has a state this method returns the command type and the
     * value of its attributes. If it does not it return the default command type.
     * @return
     */
    public String toString(){
        return defToString();
    }

}