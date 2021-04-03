package it.polimi.ingsw;

import java.util.ArrayList;

public class Gameboard {

    private ArrayList<Resource> buffer = new ArrayList<Resource>(4);
    private FaithPath faithPathOfGameboard;
    private Storage storageOfGameboard;
    private Strongbox strongboxOfGameboard;
    private ProductionCard[][] developmentBoard;


    public void addCardToDevelopmentBoard(ProductionCard productioncard, int choosenColumns) throws LevelException{


       if(productioncard.getLevel()==firstRowFree(choosenColumns))
           developmentBoard[firstRowFree(choosenColumns)-1][choosenColumns]=productioncard;
       else
           throw new LevelException();


    }





    public Gameboard() {
        faithPathOfGameboard = new FaithPath();
        strongboxOfGameboard = new Strongbox();
        storageOfGameboard = new Storage();
        developmentBoard = new ProductionCard[3][3];
        }


    public ProductionCard[][] getDevelopmentBoard() {
        return developmentBoard;
    }

    public ProductionCard getCellDevelopmentBoard(int i, int j) {
        return developmentBoard[i][j];
    }

    public void addToBuffer(Resource resource){
        buffer.add(resource);
    }

    public void getFromBuffer(int index){buffer.get(index);
    }

    public int getSizeBuffer(){
        return buffer.size();
    }


    public void  faithMove () throws CallForCouncilException{
            faithPathOfGameboard.move(); }


    public int getIndicator(){
       return faithPathOfGameboard.getIndicator();
    }

    public int firstRowFree(int choosenColumns){
        int i;
        for( i=0; i<3; i++){
            if(developmentBoard[i][choosenColumns]==null)
                return i+1;}
        return i+1;
    }
}
