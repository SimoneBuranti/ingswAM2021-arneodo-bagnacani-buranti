package it.polimi.ingsw;

public class WhiteMarbleGameBoard extends GameBoardDecorator{

    protected Resource resourceTypeFirst;

    public WhiteMarbleGameBoard(GameBoardInterface gameBoard, Resource resourceTypeFirst) {
        super(gameBoard);
        this.resourceTypeFirst = resourceTypeFirst;
    }

    @Override
    public Resource getResourceTypeFirst() {
        return this.resourceTypeFirst;
    }

    @Override
    public Resource whiteExchange() throws WhiteMarbleException {
        return this.resourceTypeFirst;
    }


}
