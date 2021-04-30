package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

public class OpponentActivateLeaderCardMessage extends Message{
    private final MessageType messageType = MessageType.OPPONENTACTIVATELC;
    private String nickname;
    private LeaderCard leaderCard;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LeaderCard getLeaderCard() {
        return leaderCard;
    }

    public void setLeaderCard(LeaderCard leaderCard) {
        this.leaderCard = leaderCard;
    }
}
