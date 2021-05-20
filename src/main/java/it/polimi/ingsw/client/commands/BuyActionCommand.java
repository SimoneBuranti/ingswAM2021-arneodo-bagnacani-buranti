package it.polimi.ingsw.client.commands;

public class BuyActionCommand extends Command {
    private char colour;
    private int level;

    public BuyActionCommand(char colour, int level) {
        this.colour = colour;
        this.level = level;
    }

    public char getColour() {
        return colour;
    }

    public int getLevel() {
        return level;
    }

    public String toString(){
        return "buy "+colour+" "+level;
    }
    public static String defToString(){
        return "buy b/g/y/v 1/2/3";
    }
}
