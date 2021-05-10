package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.gameBoard.GameBoard;
import it.polimi.ingsw.server.model.gameBoard.GameBoardInterface;
import it.polimi.ingsw.server.model.marbles.Marble;

import java.util.ArrayList;

public class GameboardConfigMessage extends Message {

    private final MessageType messageType = MessageType.CONFIGURATIONGAMEBOARD;



    private GameBoardInterface gameBoardInterface;

    public GameboardConfigMessage(GameBoardInterface gameBoardInterface){
        this.gameBoardInterface=gameBoardInterface;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public GameBoardInterface getGameBoardInterface() {
        return gameBoardInterface;
    }
}
