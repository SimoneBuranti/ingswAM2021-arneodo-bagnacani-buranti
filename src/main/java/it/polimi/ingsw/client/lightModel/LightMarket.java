package it.polimi.ingsw.client.lightModel;

import it.polimi.ingsw.server.model.marbles.*;

import java.util.ArrayList;

/**
 * This class represent the market of the light model
 */
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
    private ArrayList<Marble> initialMarbleList;

    /**
     * This constructor initializes the grid and the extra marble with the list of marbles passed as a parameter
     * @param listMarble : collection containing the initial order of marbles
     */
    public LightMarket(ArrayList<Marble> listMarble){
        this.initialMarbleList = listMarble;
        setGrid();
        setExtra();
    }


    /**
     * This method puts the extra marble in the last place of the chosen row and shifts all the other marbles
     * of the row back by one position until a new extra marble is obtained.
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
     * This method puts the extra marble in the last place of the chosen column and shifts all the other marbles
     * of the column back by one position until a new extra marble is obtained.
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
     * this method initialises grid with the first 12 elements of the initialMarbleList
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

}
