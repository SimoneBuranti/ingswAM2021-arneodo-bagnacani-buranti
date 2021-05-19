package it.polimi.ingsw.server.model.exceptions;

/**
 * This exception is thrown when a player has reached the last papal space of the faith path
 */
public class LastSpaceReachedException extends Exception {
    private String nickName;
    private int currCall;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getCurrCall() {
        return currCall;
    }

    public void setCurrCall(int currCall) {
        this.currCall = currCall;
    }
}
