package it.polimi.ingsw.model;

public class WhiteMarbleException extends Throwable {
    int n;

    public WhiteMarbleException(int n){
        this.n = n;
    }

    public void increase() {
        n++;
    }

    public int getN(){
        return n;
    }
}
