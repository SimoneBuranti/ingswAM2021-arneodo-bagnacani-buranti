package it.polimi.ingsw.model;

public class LeaderCardStorage extends LeaderCard {
    private Resource specialStorage;

    public LeaderCardStorage(Requirements requirements, int point, Resource specialStorage) {
        super(requirements, point);
        this.specialStorage=specialStorage;
    }

    /**
     * method  on abilityActivation of the decorator
     */
    @Override
    public boolean abilityActivation(GameBoardInterface gameBoard){
        if(check(gameBoard)){
            gameBoard.setStorageExtra(specialStorage);
            gameBoard.setReductionCardActivated();
            return true;
        }else
            return false;
    }

    /**
     * method check for the possibility of activate leader card
     * the ability is about extraStorage on resource
     */
    public boolean check(GameBoardInterface gameBoard){
        if(gameBoard.resourceQuantity(requirements.getResourceRequirement()) < 5)
            return false;
        return true;
    }
}
