package it.polimi.ingsw.server.model.exceptions;

/**
 * This exception is thrown when a player (or Lorenzo the Magnificent) has reached the current papal space on his faith path
 */
public class CallForCouncilException extends Exception{
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
