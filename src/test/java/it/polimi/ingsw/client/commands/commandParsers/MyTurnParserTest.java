package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.leaderCards.LeaderCardReduction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MyTurnParserTest {

    public Cli cli;
    public ViewController viewController;

    MyTurnParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
    }

    @Test
    @DisplayName("MyTurnParser - Market action")
    public void myTurnParserTest1(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("market r 1",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(0,((MarketActionCommand) command).getN());
            assertEquals('r',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market r 2",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(1,((MarketActionCommand) command).getN());
            assertEquals('r',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market r 3",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(2,((MarketActionCommand) command).getN());
            assertEquals('r',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 1",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(0,((MarketActionCommand) command).getN());
            assertEquals('c',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 2",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(1,((MarketActionCommand) command).getN());
            assertEquals('c',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 3",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(2,((MarketActionCommand) command).getN());
            assertEquals('c',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 4",viewController,cli);

            assertTrue(command instanceof MarketActionCommand);
            assertEquals(3,((MarketActionCommand) command).getN());
            assertEquals('c',((MarketActionCommand) command).getRc());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        // Invalid expected --------------------------------

        try {
            command = commandParser.parseCommand("market r 4",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("market r 0",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("market c 0",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("market c 5",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("market",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("market r",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("market c",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }


    @Test
    @DisplayName("MyTurnParser - Base Production On")
    public void myTurnParserTest2(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("baseProductionOn",viewController,cli);

            assertTrue(command instanceof BaseProductionCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("baseproductionon",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }

    @Test
    @DisplayName("MyTurnParser - End Production")
    public void myTurnParserTest3(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("endProduction",viewController,cli);

            assertTrue(command instanceof EndOfProductionCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("endproduction",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }

    @Test
    @DisplayName("MyTurnParser - Buy action")
    public void myTurnParserTest4(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("buy 1 1",viewController,cli);

            assertTrue(command instanceof BuyActionCommand);
            assertEquals(0,((BuyActionCommand) command).getDeckNumber());
            assertEquals(0,((BuyActionCommand) command).getColumnNumber());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 12 2",viewController,cli);

            assertTrue(command instanceof BuyActionCommand);
            assertEquals(11,((BuyActionCommand) command).getDeckNumber());
            assertEquals(1,((BuyActionCommand) command).getColumnNumber());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 11 3",viewController,cli);

            assertTrue(command instanceof BuyActionCommand);
            assertEquals(10,((BuyActionCommand) command).getDeckNumber());
            assertEquals(2,((BuyActionCommand) command).getColumnNumber());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 10 3",viewController,cli);

            assertTrue(command instanceof BuyActionCommand);
            assertEquals(9,((BuyActionCommand) command).getDeckNumber());
            assertEquals(2,((BuyActionCommand) command).getColumnNumber());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 9 3",viewController,cli);

            assertTrue(command instanceof BuyActionCommand);
            assertEquals(8,((BuyActionCommand) command).getDeckNumber());
            assertEquals(2,((BuyActionCommand) command).getColumnNumber());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 7 3",viewController,cli);

            assertTrue(command instanceof BuyActionCommand);
            assertEquals(6,((BuyActionCommand) command).getDeckNumber());
            assertEquals(2,((BuyActionCommand) command).getColumnNumber());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }



        // Invalid expected --------------------------------

        try {
            command = commandParser.parseCommand("buy 0 1",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 13 1",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 1 0",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 13 4",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("MyTurnParser - End turn")
    public void myTurnParserTest5(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("endTurn",viewController,cli);

            assertTrue(command instanceof EndOfTurnCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("endTur",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }
    @Test
    @DisplayName("MyTurnParser - Exit")
    public void myTurnParserTest6(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("exit",viewController,cli);

            assertTrue(command instanceof ExitCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("endTur",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }
    @Test
    @DisplayName("MyTurnParser - ExtraProduction")
    public void myTurnParserTest7(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("extraProductionOn",viewController,cli);

            assertTrue(command instanceof ExtraProductionCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("extraProduction",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }
    @Test
    @DisplayName("MyTurnParser - Help")
    public void myTurnParserTest8(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("help",viewController,cli);

            assertTrue(command instanceof HelpCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("Help",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }

    @Test
    @DisplayName("MyTurnParser - ProductionOn")
    public void myTurnParserTest10(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("productionOn",viewController,cli);

            assertTrue(command instanceof ProductionCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("productionon",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }
    @Test
    @DisplayName("MyTurnParser - ShowGameBoard")
    public void myTurnParserTest11(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("showGameboard",viewController,cli);

            assertTrue(command instanceof ShowGameBoardCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("showgameboar",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }
    @Test
    @DisplayName("MyTurnParser - ShowMarket")
    public void myTurnParserTest12(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("showMarket",viewController,cli);

            assertTrue(command instanceof ShowMarketCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("showgameboar",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }
    @Test
    @DisplayName("MyTurnParser - showProductionDecks")
    public void myTurnParserTest13(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("showProductionDecks",viewController,cli);

            assertTrue(command instanceof ShowProductionDeckCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("showProductionDeck",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }
    @Test
    @DisplayName("MyTurnParser - showReserve")
    public void myTurnParserTest14(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("showReserve",viewController,cli);

            assertTrue(command instanceof ShowReserveCommand);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("showReserv",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }
    @Test
    @DisplayName("MyTurnParser - leader")
    public void myTurnParserTest9(){
        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("leader a 1",viewController,cli);

            assertTrue(command instanceof LeaderCardActionCommand);
            assertEquals('a',((LeaderCardActionCommand) command).getAd());
            assertEquals(0,((LeaderCardActionCommand) command).getN());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("leader x 1",viewController,cli);

            assertTrue(command instanceof LeaderCardActionCommand);
            assertEquals('x',((LeaderCardActionCommand) command).getAd());
            assertEquals(0,((LeaderCardActionCommand) command).getN());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("leader a 2",viewController,cli);

            assertTrue(command instanceof LeaderCardActionCommand);
            assertEquals('a',((LeaderCardActionCommand) command).getAd());
            assertEquals(1,((LeaderCardActionCommand) command).getN());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("leader x 2",viewController,cli);

            assertTrue(command instanceof LeaderCardActionCommand);
            assertEquals('x',((LeaderCardActionCommand) command).getAd());
            assertEquals(1,((LeaderCardActionCommand) command).getN());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("showReserv",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("MyTurnParser - showPlayer")
    public void myTurnParserTest15(){

        CommandParser commandParser = new MyTurnParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("showPlayer 1",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
            assertEquals(0,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 2",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
            assertEquals(1,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 3",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
            assertEquals(2,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 4",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
            assertEquals(3,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 12",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
            assertEquals(0,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
    }

}