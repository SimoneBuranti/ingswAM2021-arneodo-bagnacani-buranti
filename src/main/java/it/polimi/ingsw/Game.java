package it.polimi.ingsw;

public class Game {



    public Game(){
        Market market = new Market();
        Reserve reserve = new Reserve();
        Player player = new Player();
        DeckProductionCardOneBlu deckProductionCardOneBlu = new DeckProductionCardOneBlu();
        DeckProductionCardTwoBlu deckProductionCardTwoBlu = new DeckProductionCardTwoBlu();
        DeckProductionCardThreeBlu deckProductionCardThreeBlu = new DeckProductionCardThreeBlu();

        DeckProductionCardOneGreen deckProductionCardOneGreen = new DeckProductionCardOneGreen();
        DeckProductionCardTwoGreen deckProductionCardTwoGreen = new DeckProductionCardTwoGreen();
        DeckProductionCardThreeGreen deckProductionCardThreeGreen = new DeckProductionCardThreeGreen();

        DeckProductionCardOneYellow deckProductionCardOneYellow = new DeckProductionCardOneYellow();
        DeckProductionCardTwoYellow deckProductionCardTwoYellow = new DeckProductionCardTwoYellow();
        DeckProductionCardThreeYellow deckProductionCardThreeYellow = new DeckProductionCardThreeYellow();

        DeckProductionCardOneViolet deckProductionCardOneViolet = new DeckProductionCardOneViolet();
        DeckProductionCardTwoViolet deckProductionCardTwoViolet = new DeckProductionCardTwoViolet();
        DeckProductionCardThreeViolet deckProductionCardThreeViolet = new DeckProductionCardThreeViolet();
    }



    public void DoActionMarket(Player player, DeckProductionCard deckProductionCard, int choosenColumns) throws LevelException, EmptyException {
        deckProductionCard.PickUpFirstCard(player, choosenColumns);
    }








}
