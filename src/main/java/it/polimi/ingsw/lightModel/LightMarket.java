package it.polimi.ingsw.lightModel;

import com.google.gson.Gson;
import it.polimi.ingsw.server.model.marbles.*;

import java.io.*;
import java.util.ArrayList;

public class LightMarket {
    /**
     * this attribute is the market structure and contains 12 marbles
     */
    private final Marble[][] grid = new Marble[3][4];
    /**
     * this attribute is the extra marble to use after a market action
     */
    private Marble extra= new Marble();
    /**
     * this attribute is the list of balls in the initial order
     */
    private ArrayList<Marble> initialMarbleList = new ArrayList<>(13);


    /**
     * This constructor creates the 13 marbles by adding them to the list.
     * After shuffling the list, it initialises the two attributes grid and extra
     */
    public LightMarket(File file){
        Gson gson = new Gson();
        ArrayList<Marble> listMarble = new ArrayList<>();
        RedMarble redOne = new RedMarble();
        listMarble.add(redOne);

        YellowMarble yellowFirst = new YellowMarble();
        listMarble.add(yellowFirst);
        YellowMarble yellowSecond = new YellowMarble();
        listMarble.add(yellowSecond);

        BluMarble bluFirst = new BluMarble();
        listMarble.add(bluFirst);
        BluMarble bluSecond = new BluMarble();
        listMarble.add(bluSecond);

        GreyMarble greyFirst = new GreyMarble();
        listMarble.add(greyFirst);
        GreyMarble greySecond = new GreyMarble();
        listMarble.add(greySecond);

        PurpleMarble purpleFirst = new PurpleMarble();
        listMarble.add(purpleFirst);
        PurpleMarble purpleSecond = new PurpleMarble();
        listMarble.add(purpleSecond);

        WhiteMarble whiteFirst = new WhiteMarble();
        listMarble.add(whiteFirst);
        WhiteMarble whiteSecond = new WhiteMarble();
        listMarble.add(whiteSecond);
        WhiteMarble whiteThird = new WhiteMarble();
        listMarble.add(whiteThird);
        WhiteMarble whiteFourth = new WhiteMarble();
        listMarble.add(whiteFourth);

        try {
            String[] listColour = gson.fromJson(new FileReader(file), String[].class);

            for(String colour : listColour) {
                for (Marble marble : listMarble) {
                    if (marble.getColour() == colour)
                        initialMarbleList.add(marble);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        setGrid();
        setExtra();


    }

    public LightMarket(ArrayList<Marble> listMarble){
        this.initialMarbleList = listMarble;
        setGrid();
        setExtra();
    }


    /**
     * This method calls the marble's giveResource method for each marble in the market grid in the chosen row
     * to give the corresponding resource to the player. Then the method puts the extra marble in the last place
     * of the chosen row and shifts all the other marbles of the row back by one position until a new extra marble is obtained.
     * If at the end no exceptions were caught then it calls the player's takeFromMarket method,
     * otherwise it throws a new WhiteMarbleException which has as a parameter the total number of exceptions caught
     * @param chosenRow : the chosen row on which to make the market action
     */
    public void pushRow(int chosenRow) {
        int j;
        Marble temp = extra;
        extra = grid[chosenRow][0];
        for(j=1; j<4; j++)
            grid[chosenRow][j-1]=grid[chosenRow][j];
        grid[chosenRow][3]=temp;
    }


    /**
     * This method calls the marble's giveResource method for each marble in the market grid in the chosen column
     * to give the corresponding resource to the player. Then the method puts the extra marble in the last place
     * of the chosen column and shifts all the other marbles of the column back by one position until a new extra marble is obtained.
     * If at the end no exceptions were caught then it calls the player's takeFromMarket method,
     * otherwise it throws a new WhiteMarbleException which has as a parameter the total number of exceptions caught
     * @param chosenColumn : the chosen column on which to make the market action
     */
    public void pushColumn(int chosenColumn) {
        int i;
        Marble temp = extra;
        extra = grid[0][chosenColumn];
        for(i=1; i<3; i++)
            grid[i-1][chosenColumn]=grid[i][chosenColumn];
        grid[2][chosenColumn]=temp;

    }

    /**
     * this method initialises grid with the first 12 elements of the ArrayList passed as a parameter

     */
    private void setGrid(){
        int i;
        int j;
        int index=0;
        for(i=0; i<3;i++) {
            for(j=0; j<4;j++) {
                grid[i][j]=initialMarbleList.get(index);
                index++;
            }
        }
    }

    /**
     * this method initialises extra with the last element of initialMarbleList
     */
    private void setExtra(){
        extra=initialMarbleList.get(12);
    }


    /**
     * Test only method : it returns the marble to the i position in the initialMarbleList
     * @param i : the marble position in the list
     * @return Marble : the marble in the position i in the list
     */
    public Marble getCellInitialMarbleList(int i) {
        return initialMarbleList.get(i);
    }

    /**
     * Getter method for the extra marble
     * @return Marble : the extra marble
     */
    public Marble getExtra() {
        return extra;
    }

    /**
     * Getter method for the market structure
     * @return Marble[][] : the market structure
     */
    public Marble[][] getGrid() {
        return grid;
    }

    /**
     * Getter method for the marble in the market structure cell in position i,j
     * @param i : cell row
     * @param j : cell column
     * @return Marble : the marble in the market structure cell
     */
    public Marble getCellGrid(int i, int j) {
        return grid[i][j];
    }


}
