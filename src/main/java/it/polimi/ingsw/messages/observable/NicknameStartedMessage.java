package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;
import java.util.ArrayList;

public class NicknameStartedMessage extends Message {
    private final MessageType messageType = MessageType.NICKNAME;
    private ArrayList<String> nickname;

    public NicknameStartedMessage(ArrayList<String> nickname){
        this.nickname=new ArrayList<>();

        this.nickname=nickname;
    }
    public ArrayList<String> getNickname() {
        return nickname;
    }



    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
