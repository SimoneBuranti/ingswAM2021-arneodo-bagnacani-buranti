package it.polimi.ingsw.model;
import java.util.ArrayList;

/**
 * @author bagna
 */
public class Market {
    private Marble[][] Grid = new Marble[3][4];
    private Marble extra= new Marble();
    private ArrayList<Marble> InitialMarbleList = new ArrayList<>(13);



    public Market(){
        RedMarble redOne = new RedMarble();
        InitialMarbleList.add(redOne);

        YellowMarble yellowFirst = new YellowMarble();
        InitialMarbleList.add(yellowFirst);
        YellowMarble yellowSecond = new YellowMarble();
        InitialMarbleList.add(yellowSecond);

        BluMarble bluFirst = new BluMarble();
        InitialMarbleList.add(bluFirst);
        BluMarble bluSecond = new BluMarble();
        InitialMarbleList.add(bluSecond);

        GreyMarble greyFirst = new GreyMarble();
        InitialMarbleList.add(greyFirst);
        GreyMarble greySecond = new GreyMarble();
        InitialMarbleList.add(greySecond);

        PurpleMarble purpleFirst = new PurpleMarble();
        InitialMarbleList.add(purpleFirst);
        PurpleMarble purpleSecond = new PurpleMarble();
        InitialMarbleList.add(purpleSecond);

        WhiteMarble whiteFirst = new WhiteMarble();
        InitialMarbleList.add(whiteFirst);
        WhiteMarble whiteSecond = new WhiteMarble();
        InitialMarbleList.add(whiteSecond);
        WhiteMarble whiteThird = new WhiteMarble();
        InitialMarbleList.add(whiteThird);
        WhiteMarble whiteFourth = new WhiteMarble();
        InitialMarbleList.add(whiteFourth);

        Mix.MIXED(InitialMarbleList);

        setGrid(InitialMarbleList);
        setExtra();
    };

    /**
     *
     * @return extra
     */
    public Marble getExtra() {
        return extra;
    }

    /**
        *
        * @return Grid
     */
    public Marble[][] getGrid() {
        return Grid;
    }


    /**
     * @param i
     * @param j
     * @return Grid[i][j]
     */
    public Marble getCellGrid(int i, int j) {
        return Grid[i][j];
    }

/**
 *action called by ActionMarket, when the player choose  row instead of column
 * @param ChosenRow
 * it activates methods of marble belonging to chosenRow
 * then it reactive the grid and the extra marble
 */

    public void pushRow(int ChosenRow, Player player) throws CallForCouncilException, LastSpaceReachedException, WhiteMarbleException {
        int j;
        WhiteMarbleException exception = new WhiteMarbleException(0);
        Marble temp;
        for(j=0; j<4; j++)
            try {
                Grid[ChosenRow][j].giveResource(player);
            }catch(WhiteMarbleException e){
                exception.increase();
        }
        temp=extra;
        extra=Grid[ChosenRow][0];
        for(j=1; j<4; j++)
            Grid[ChosenRow][j-1]=Grid[ChosenRow][j];
        Grid[ChosenRow][3]=temp;

        if(exception.getN() == 0)
            player.takeFromMarket();
        else
            throw exception;
      }


    /**
     *action called by ActionMarket, when the player choose column instead of row
     * @param ChosenColumn
     *  * it activates methods of marble belonging to chosenColumn
     *  * then it reactive the grid and the extra marble
     */

    public void pushColumn(int ChosenColumn,Player player) throws CallForCouncilException, LastSpaceReachedException, WhiteMarbleException {
        int i;
        Marble temp;
        for(i=0; i<3; i++)
            Grid[i][ChosenColumn].giveResource(player);

        temp=extra;
        extra=Grid[0][ChosenColumn];
        for(i=1; i<3; i++)
            Grid[i-1][ChosenColumn]=Grid[i][ChosenColumn];
        Grid[2][ChosenColumn]=temp;

        player.takeFromMarket();
    }


    /**
     * create Grid with the first 12 elements of arrayList (starting from 0... to 11)
     */
    private void setGrid(ArrayList<Marble> InitialMarbleList){
    int i;
    int j;
    int index=0;
    for(i=0; i<3;i++)
        {
            for(j=0; j<4;j++)
                {
                    Grid[i][j]=InitialMarbleList.get(index);
                    index++;
                }
        }
    }

    /**
     * set extra, last element of initialMarbleList (starting from 0... to 12)
     */
    private void setExtra(){
        extra=InitialMarbleList.get(12);
    }


    /**
     * @param i
     * @return InitialMarbleList.get(i)
     */
    public Marble getCellInitialMarbleList(int i) {
        return InitialMarbleList.get(i);
    }


}
