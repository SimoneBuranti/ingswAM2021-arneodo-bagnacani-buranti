package it.polimi.ingsw;

public class WhiteMarbleGameboard extends GameboardDecorator{

    protected Resource resourceTypeFirst;

    public WhiteMarbleGameboard(GameboardInterface gameboard, Resource resourceTypeFirst) {
        super(gameboard);
        this.resourceTypeFirst = resourceTypeFirst;
    }

    public Resource getResourceTypeFirst() {
        return this.resourceTypeFirst;
    }

    @Override
    public Resource whiteExchange() throws UnavailableResourceException {
        Reserve.getResource(resourceTypeFirst);

        return this.resourceTypeFirst;
    }


    @Override
    public void addLeaderCardToGameboard(LeaderCard leaderCard){
        return;
    }

    @Override
    public int leaderCardsSize(){
        return 0;

    }
}
