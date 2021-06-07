package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StandardParserTest {

    public Cli cli;
    public ViewController viewController;

    StandardParserTest() throws IOException {

        cli = new Cli();
        viewController= new ViewController(cli);
    }

    @Test
    @DisplayName("standardParser - Market action")
    public void standardParserTest1(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("market r 1",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market r 2",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market r 3",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 1",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 2",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 3",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("market c 4",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - Base Production On")
    public void standardParserTest2(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("baseProductionOn",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - End Production")
    public void standardParserTest3(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("endProduction",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - Buy action")
    public void standardParserTest4(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("buy 1 1",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 12 2",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 11 3",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 10 3",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 9 3",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("buy 7 3",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - End turn")
    public void standardParserTest5(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("endTurn",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - Exit")
    public void standardParserTest6(){
        CommandParser commandParser = new StandardParser();
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
    @DisplayName("standardParser - ExtraProduction")
    public void standardParserTest7(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("extraProductionOn",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - Help")
    public void standardParserTest8(){
        CommandParser commandParser = new StandardParser();
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
    @DisplayName("standardParser - ProductionOn")
    public void standardParserTest10(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("productionOn",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - ShowGameBoard")
    public void standardParserTest11(){
        CommandParser commandParser = new StandardParser();
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
    @DisplayName("standardParser - ShowMarket")
    public void standardParserTest12(){
        CommandParser commandParser = new StandardParser();
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
    @DisplayName("standardParser - showProductionDecks")
    public void standardParserTest13(){
        CommandParser commandParser = new StandardParser();
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
    @DisplayName("standardParser - showReserve")
    public void standardParserTest14(){
        CommandParser commandParser = new StandardParser();
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
    @DisplayName("standardParser - leader")
    public void standardParserTest9(){
        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("leader a 1",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("leader x 1",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("leader a 2",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("leader x 2",viewController,cli);

            assertTrue(false);
        } catch (InvalidCommandException e) {
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
    @DisplayName("standardParser - showPlayer")
    public void standardParserTest15(){

        CommandParser commandParser = new StandardParser();
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        try {
            command = commandParser.parseCommand("showPlayer 1",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
            //  assertEquals(0,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 2",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
     //       assertEquals(1,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 3",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
       //     assertEquals(2,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 4",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
         //   assertEquals(3,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
        try {
            command = commandParser.parseCommand("showPlayer 12",viewController,cli);

            assertTrue(command instanceof ShowPlayerCommand);
        //    assertEquals(0,((ShowPlayerCommand) command).getNumberPlayer());
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }
    }


}