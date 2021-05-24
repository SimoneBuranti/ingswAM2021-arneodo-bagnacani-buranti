package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.Resource;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class KeepResourcesParserTest {

    public Cli cli;
    public ViewController viewController;
    public ArrayList<Resource> pickedResources;

    KeepResourcesParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
        pickedResources = new ArrayList<>();
        pickedResources.add(Resource.ROCK);
        pickedResources.add(Resource.SHIELD);
        pickedResources.add(Resource.COIN);
    }

    @Test
    @DisplayName("KeepResourcesParser - Market action")
    public void KeepResourcesParserTest1(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - Base Production On")
    public void KeepResourcesParserTest2(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - End Production")
    public void KeepResourcesParserTest3(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - Buy action")
    public void KeepResourcesParserTest4(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - End turn")
    public void KeepResourcesParserTest5(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - Exit")
    public void KeepResourcesParserTest6(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - ExtraProduction")
    public void KeepResourcesParserTest7(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - Help")
    public void KeepResourcesParserTest8(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - ProductionOn")
    public void KeepResourcesParserTest10(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - ShowGameBoard")
    public void KeepResourcesParserTest11(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - ShowMarket")
    public void KeepResourcesParserTest12(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - showProductionDecks")
    public void KeepResourcesParserTest13(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - showReserve")
    public void KeepResourcesParserTest14(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - leader")
    public void KeepResourcesParserTest9(){
        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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
    @DisplayName("KeepResourcesParser - showPlayer")
    public void KeepResourcesParserTest15(){

        CommandParser commandParser = new KeepResourcesParser(pickedResources);
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