package it.polimi.ingsw;

public class Game {

    Market market;
    Reserve reserve;
    Player player;
    DeckProductionCard deckProductionCardOneBlu ;
    DeckProductionCard deckProductionCardTwoBlu ;
    DeckProductionCard deckProductionCardThreeBlu ;

    DeckProductionCard deckProductionCardOneGreen ;
    DeckProductionCard deckProductionCardTwoGreen;
    DeckProductionCard deckProductionCardThreeGreen ;

    DeckProductionCard deckProductionCardOneYellow ;
    DeckProductionCard deckProductionCardTwoYellow ;
    DeckProductionCard deckProductionCardThreeYellow;

    DeckProductionCard deckProductionCardOneViolet ;
    DeckProductionCard deckProductionCardTwoViolet ;
    DeckProductionCard  deckProductionCardThreeViolet ;

    public Game(){
        market = new Market();
        reserve = new Reserve();
        player = new Player();
        deckProductionCardOneBlu = new DeckProductionCardOneBlu();
        deckProductionCardTwoBlu = new DeckProductionCardTwoBlu();
        deckProductionCardThreeBlu = new DeckProductionCardThreeBlu();

        deckProductionCardOneGreen = new DeckProductionCardOneGreen();
        deckProductionCardTwoGreen = new DeckProductionCardTwoGreen();
        deckProductionCardThreeGreen = new DeckProductionCardThreeGreen();

        deckProductionCardOneYellow = new DeckProductionCardOneYellow();
        deckProductionCardTwoYellow = new DeckProductionCardTwoYellow();
        deckProductionCardThreeYellow = new DeckProductionCardThreeYellow();

        deckProductionCardOneViolet = new DeckProductionCardOneViolet();
        deckProductionCardTwoViolet = new DeckProductionCardTwoViolet();
         deckProductionCardThreeViolet = new DeckProductionCardThreeViolet();
    }



    public static void DoActionMarket(Player player, DeckProductionCard deckProductionCard, int choosenColumns) throws LevelException, EmptyException {
        deckProductionCard.PickUpFirstCard(player, choosenColumns);
    }








}
