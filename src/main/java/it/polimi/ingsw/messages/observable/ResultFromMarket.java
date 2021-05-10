package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;

public class ResultFromMarket extends Message {
    private final MessageType messageType = MessageType.RESULTFROMARKET;


    private int coins;
    private int servant;
    private int shield;
    private int rock;


    public ResultFromMarket(int coins, int shield, int rock, int servant){

        this.coins=coins;
        this.shield=shield;
        this.rock=rock;
        this.servant=servant;

    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public int getCoins() {
        return coins;
    }

    public int getServant() {
        return servant;
    }

    public int getShield() {
        return shield;
    }

    public int getRock() {
        return rock;
    }
}
