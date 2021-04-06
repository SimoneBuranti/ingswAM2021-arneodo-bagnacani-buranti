package it.polimi.ingsw;

public class LeaderCardStorage extends LeaderCard {
    private Resource specialStorage;

    public LeaderCardStorage(Requirements requirements, int point, Resource specialStorage) {
        super(requirements, point);
        this.specialStorage=specialStorage;
    }

    /**
     * method  on abilityActivation of the decorator
     */
    public void abilityActivation(){}

    /**
     * method check for the possibility of activate leader card
     * the ability is about extraStorage on resource
     */
    public void check(){}
}
