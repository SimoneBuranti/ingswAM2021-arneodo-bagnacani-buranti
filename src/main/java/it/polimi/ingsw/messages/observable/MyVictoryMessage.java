package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class MyVictoryMessage extends Message {
    private final MessageType messageType = MessageType.MYVICTORY;

    int score;
    public MyVictoryMessage(int score)
{
    this.score=score;
}

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString(){
        return "your score : "+getScore();
    }
}
