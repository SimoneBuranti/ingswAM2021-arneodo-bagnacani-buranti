package it.polimi.ingsw;


public class WhiteMarbleGameBoardDouble extends WhiteMarbleGameBoard{

    private final Resource resourceTypeSecond;

    public WhiteMarbleGameBoardDouble(GameBoardInterface gameBoard, Resource resourceTypeFirst, Resource resourceTypeSecond) {
        super(gameBoard,resourceTypeFirst);
        this.resourceTypeSecond = resourceTypeSecond;
    }

    public Resource getResourceTypeSecond() {
        return resourceTypeSecond;
    }

    @Override
    public Resource whiteExchange() throws WhiteMarbleException{

        throw new WhiteMarbleException(1);

    }


}