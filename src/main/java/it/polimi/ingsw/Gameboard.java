package it.polimi.ingsw;

import java.util.ArrayList;

public class Gameboard {

    private ArrayList<Resource> buffer = new ArrayList<Resource>(4);
    private FaithPath faithPathOfGameboard;
    private Storage storageOfGameboard;
    private Strongbox strongboxOfGameboard;



    public Gameboard() {
        faithPathOfGameboard = new FaithPath();
        strongboxOfGameboard = new Strongbox();
        storageOfGameboard = new Storage();
    }

    public void addToBuffer(Resource resource){
        buffer .add(resource);
    }

    public void getFromBuffer(int index){buffer.get(index);
    }

    public int getSizeBuffer(){
        return buffer.size();
    }


    public void faithMove(){
        try {
            faithPathOfGameboard.move();
        } catch (CallForCouncilException e) {
            System.out.println("quello che vuoi tu");
        }
    }
    public int getIndicator(){
       return faithPathOfGameboard.getIndicator();
    }
}
