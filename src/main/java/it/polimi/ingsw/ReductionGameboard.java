package it.polimi.ingsw;

import java.util.ArrayList;

public class ReductionGameboard extends GameboardDecorator{

    private final Resource resourceTypeFirst;

    public ReductionGameboard(GameboardInterface gameboard,Resource resourceType) {
        super(gameboard);
        this.resourceTypeFirst = resourceType;
    }

    @Override
    public ArrayList<Resource> costReduction(ArrayList<Resource> cost) {
        cost.remove(resourceTypeFirst);
        return cost;
    }

    @Override
    public void buyProductionCard(DeckProductionCard deck, int choosenColumn) throws LevelException, NotEnoughResourcesException, EmptyException, FullColumnException, EndGameException {
        ArrayList<Resource> availableResources = availableResources();
        ArrayList<Resource> requiredResources = costReduction(deck.requiredResources());

        if(deck.getLevel()!=firstRowFree(choosenColumn))
            throw new LevelException();
        for(Resource resource : requiredResources)
            if (!availableResources.remove(resource))
                throw new NotEnoughResourcesException();

        payResources(requiredResources);

        setNewProductionCard(deck,choosenColumn);

        seventhCardCheck();
    }

    @Override
    public LeaderCard reportLeaderCardToGameboard(int index){
        return null;
    }

    @Override
    public void addLeaderCardToGameboard(LeaderCard leaderCard){
        return;
    }

    @Override
    public int leaderCardsSize(){
        return 0;
    }
    @Override
    public  void removeLeaderCardToGameboard(int index){

    }




}

