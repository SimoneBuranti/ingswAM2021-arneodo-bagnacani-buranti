package it.polimi.ingsw.server.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.messages.observable.ConfigurationMarketMessage;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.exceptions.CallForCouncilException;
import it.polimi.ingsw.server.model.exceptions.LastSpaceReachedException;
import it.polimi.ingsw.server.model.exceptions.NotEnoughSpaceInStorageException;
import it.polimi.ingsw.server.model.exceptions.WhiteMarbleException;
import it.polimi.ingsw.server.model.marbles.*;
import it.polimi.ingsw.server.model.players.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represents the game market  common to all players
 */
public class Market extends Observable {




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
     * this attribute is the list of balls in the initial order
     */
    private final ArrayList<Marble> latestMarbleList = new ArrayList<>(13);


    /**
     * This constructor creates the 13 marbles by adding them to the list.
     * After shuffling the list, it initialises the two attributes grid and extra
     */
    public Market() throws IOException, InterruptedException {

        RedMarble redOne = new RedMarble();
        initialMarbleList.add(redOne);

        YellowMarble yellowFirst = new YellowMarble();
        initialMarbleList.add(yellowFirst);
        YellowMarble yellowSecond = new YellowMarble();
        initialMarbleList.add(yellowSecond);

        BluMarble bluFirst = new BluMarble();
        initialMarbleList.add(bluFirst);
        BluMarble bluSecond = new BluMarble();
        initialMarbleList.add(bluSecond);

        GreyMarble greyFirst = new GreyMarble();
        initialMarbleList.add(greyFirst);
        GreyMarble greySecond = new GreyMarble();
        initialMarbleList.add(greySecond);

        PurpleMarble purpleFirst = new PurpleMarble();
        initialMarbleList.add(purpleFirst);
        PurpleMarble purpleSecond = new PurpleMarble();
        initialMarbleList.add(purpleSecond);

        WhiteMarble whiteFirst = new WhiteMarble();
        initialMarbleList.add(whiteFirst);
        WhiteMarble whiteSecond = new WhiteMarble();
        initialMarbleList.add(whiteSecond);
        WhiteMarble whiteThird = new WhiteMarble();
        initialMarbleList.add(whiteThird);
        WhiteMarble whiteFourth = new WhiteMarble();
        initialMarbleList.add(whiteFourth);

        Mix.MIXED(initialMarbleList);

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
     * @param player : the player who wants to make the market action
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     * @throws WhiteMarbleException : the exception which is thrown when the player has activated two white marble-type leader cards
     */
    public void pushRow(int chosenRow, Player player) throws CallForCouncilException, LastSpaceReachedException, WhiteMarbleException, NotEnoughSpaceInStorageException {
        int j;
        WhiteMarbleException exception = new WhiteMarbleException(0);
        Marble temp;

        for(j=0; j<4; j++)
            try {
                grid[chosenRow][j].giveResource(player);
            }catch(WhiteMarbleException e){
                exception.increase();
        }

        temp=extra;
        extra=grid[chosenRow][0];
        for(j=1; j<4; j++)
            grid[chosenRow][j-1]=grid[chosenRow][j];
        grid[chosenRow][3]=temp;

        if(exception.getN() == 0)
            player.takeFromMarket();
        else
            throw exception;
      }


    /**
     * This method calls the marble's giveResource method for each marble in the market grid in the chosen column
     * to give the corresponding resource to the player. Then the method puts the extra marble in the last place
     * of the chosen column and shifts all the other marbles of the column back by one position until a new extra marble is obtained.
     * If at the end no exceptions were caught then it calls the player's takeFromMarket method,
     * otherwise it throws a new WhiteMarbleException which has as a parameter the total number of exceptions caught
     * @param chosenColumn : the chosen column on which to make the market action
     * @param player : the player who wants to make the market action
     * @throws CallForCouncilException : the exception which is thrown when the faith indicator has reached the current papal space
     * @throws LastSpaceReachedException : the exception which is thrown when the faith indicator has reached the last papal space
     * @throws WhiteMarbleException : the exception which is thrown when the player has activated two white marble-type leader cards
     */
    public void pushColumn(int chosenColumn, Player player) throws CallForCouncilException, LastSpaceReachedException, WhiteMarbleException, NotEnoughSpaceInStorageException {
        int i;
        WhiteMarbleException exception = new WhiteMarbleException(0);
        Marble temp;
        for(i=0; i<3; i++){
            try {
                grid[i][chosenColumn].giveResource(player);
            }catch(WhiteMarbleException e) {
                exception.increase();
            }
        }

        temp=extra;
        extra=grid[0][chosenColumn];
        for(i=1; i<3; i++)
            grid[i-1][chosenColumn]=grid[i][chosenColumn];
        grid[2][chosenColumn]=temp;

        if(exception.getN() == 0)
            player.takeFromMarket();
        else
            throw exception;
    }

    /**
     * this method initialises grid with the first 12 elements of the ArrayList passed as a parameter

     */
    private void setGrid(){
    int i;
    int j;
    int index=0;
    for(i=0; i<3;i++)
        {
            for(j=0; j<4;j++)
                {
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



    /**
     * method for saveInformationOfmarket
     */
    public void saveInformationOfMarket(){
        int i;
        int j;
        for(i=0;i<3;i++){
            for (j=0;j<4;j++)
            latestMarbleList.add(getCellGrid(i,j));
        }
        latestMarbleList.add(getExtra());


        Gson gson=gsonForEveryoneMArket();


        FileWriter config = null;
        String jsonStrin = gson.toJson(latestMarbleList);

        try {

            config = new FileWriter("src/main/resources/Market.json");
            config.write(jsonStrin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                config.flush();
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            } } }




    public Market(Marble[] list) throws IOException, InterruptedException {

        for(int i=0; i < 13; i++)
            initialMarbleList.add(list[i]);
        setGrid();
        setExtra();
    }


    public ArrayList<Marble> getInitialMarbleList(){
        return initialMarbleList;
    }


public static Gson gsonForEveryoneMArket(){
    RuntimeTypeAdapterFactory<Colour> adapterColour =
            RuntimeTypeAdapterFactory
                    .of(Colour.class)
                    .registerSubtype(Green.class)
                    .registerSubtype(Yellow.class)
                    .registerSubtype(Blue.class)
                    .registerSubtype(Violet.class);

    RuntimeTypeAdapterFactory<Marble> adapterMarble =
            RuntimeTypeAdapterFactory
                    .of(Marble.class)
                    .registerSubtype(Marble.class)
                    .registerSubtype(GreyMarble.class)
                    .registerSubtype(YellowMarble.class)
                    .registerSubtype(BluMarble.class)
                    .registerSubtype(WhiteMarble.class)
                    .registerSubtype(PurpleMarble.class)
                    .registerSubtype(RedMarble.class);



    Gson gson=new GsonBuilder()
            .registerTypeAdapterFactory(adapterMarble)
            .registerTypeAdapterFactory(adapterColour)
            .setPrettyPrinting()
            .create();

return gson;

}




public boolean getRedInColumn(int i){
        for(int j=0; j<3 ; j++)
            if(grid[j][i] instanceof RedMarble)
                return true;

        return false; }


    public boolean getRedInRow(int i){
        for(int j=0; j<4 ; j++)
            if(grid[i][j] instanceof RedMarble)
                return true;

        return false; }

}
