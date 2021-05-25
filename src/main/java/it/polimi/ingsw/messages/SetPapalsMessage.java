package it.polimi.ingsw.messages;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class SetPapalsMessage extends Message {
    private final MessageType messageType = MessageType.SETPAPALS;
    //private int currCall;
    private String nickname;
    private int papalCard;

    public SetPapalsMessage(int papalCard, String nickname){
        this.papalCard = papalCard;
        //this.currCall = currCall;
        this.nickname = nickname;
    }

    public int getPapalCard() {
        return papalCard;
    }

    /*public int getCurrCall() {
        return currCall;
    }*/

    public String getNickname() {
        return nickname;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }}
