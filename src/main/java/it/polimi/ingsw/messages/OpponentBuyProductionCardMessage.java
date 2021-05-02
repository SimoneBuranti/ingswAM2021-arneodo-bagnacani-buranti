package it.polimi.ingsw.messages;

public class OpponentBuyProductionCardMessage extends Message{
    private final MessageType messageType = MessageType.OPPONENTBUYPRODCARD;
    private String nickname;
    private int productionDeck;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getProductionDeck() {
        return productionDeck;
    }

    public void setProductionDeck(int productionDeck) {
        this.productionDeck = productionDeck;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
