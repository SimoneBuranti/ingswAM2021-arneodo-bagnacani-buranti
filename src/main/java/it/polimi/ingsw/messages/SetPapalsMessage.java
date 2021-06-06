package it.polimi.ingsw.messages;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

import java.io.IOException;

public class SetPapalsMessage extends Message {

    /**
     *message for notify the setting on papals card from server to client
     */
    private final MessageType messageType = MessageType.SETPAPALS;
    private String nickname;
    private int papalCard;



    public SetPapalsMessage(int papalCard, String nickname){
        this.papalCard = papalCard;
        this.nickname = nickname;
    }

    public int getPapalCard() {
        return papalCard;
    }

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
