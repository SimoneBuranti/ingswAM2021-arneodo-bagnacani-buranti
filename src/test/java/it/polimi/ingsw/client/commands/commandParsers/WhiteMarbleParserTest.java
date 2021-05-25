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

class WhiteMarbleParserTest {

    /*public Cli cli;
    public ViewController viewController;

    WhiteMarbleParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
    }

    @Test
    @DisplayName("WhiteMarbleParser - 4 types")
    public void whiteMarbleParserTest1(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.ROCK);
        resources.add(Resource.SHIELD);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(4,resources);
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        resources = new ArrayList<>();

        try {
            command = commandParser.parseCommand("coin rock shield servant",viewController,cli);
            resources.add(Resource.COIN);
            resources.add(Resource.ROCK);
            resources.add(Resource.SHIELD);
            resources.add(Resource.SERVANT);
            assertTrue(command instanceof WhiteMarbleCommand);
            assertEquals(((WhiteMarbleCommand) command).getResources(),resources);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("coin coin shield servant",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.COIN);
            resources.add(Resource.COIN);
            resources.add(Resource.SHIELD);
            resources.add(Resource.SERVANT);
            assertTrue(command instanceof WhiteMarbleCommand);
            assertEquals(((WhiteMarbleCommand) command).getResources(),resources);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("coin coin",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.COIN);
            resources.add(Resource.COIN);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("servant servant servant servant",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            assertTrue(command instanceof WhiteMarbleCommand);
            assertEquals(((WhiteMarbleCommand) command).getResources(),resources);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("SERVANT servAnt SeRvaNt servAnt",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("coin coi shild serant",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }

    @Test
    @DisplayName("WhiteMarbleParser - 2 types")
    public void whiteMarbleParserTest2(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
        Scanner in = new Scanner(System.in);
        String commandText;
        Command command;

        resources = new ArrayList<>();

        try {
            command = commandParser.parseCommand("coin  COIN servant",viewController,cli);
            resources.add(Resource.COIN);
            resources.add(Resource.COIN);
            resources.add(Resource.SERVANT);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("coin coin shield servant",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.COIN);
            resources.add(Resource.COIN);
            resources.add(Resource.SERVANT);
            assertTrue(command instanceof WhiteMarbleCommand);
            assertEquals(((WhiteMarbleCommand) command).getResources(),resources);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("coin coin",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.COIN);
            resources.add(Resource.COIN);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("SERVANT servAnt SeRvaNt servAnt",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }


        try {
            command = commandParser.parseCommand("coin coi shild serant",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

        try {
            command = commandParser.parseCommand("servant servant servant servant",viewController,cli);
            resources = new ArrayList<>();
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            resources.add(Resource.SERVANT);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }

    }


    @Test
    @DisplayName("WhiteMarbleParser - Market action")
    public void WhiteMarbleParserTest1(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - Base Production On")
    public void WhiteMarbleParserTest2(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - End Production")
    public void WhiteMarbleParserTest3(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - Buy action")
    public void WhiteMarbleParserTest4(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - End turn")
    public void WhiteMarbleParserTest5(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - Exit")
    public void WhiteMarbleParserTest6(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - ExtraProduction")
    public void WhiteMarbleParserTest7(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - Help")
    public void WhiteMarbleParserTest8(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - ProductionOn")
    public void WhiteMarbleParserTest10(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - ShowGameBoard")
    public void WhiteMarbleParserTest11(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - ShowMarket")
    public void WhiteMarbleParserTest12(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - showProductionDecks")
    public void WhiteMarbleParserTest13(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - showReserve")
    public void WhiteMarbleParserTest14(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - leader")
    public void WhiteMarbleParserTest9(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
    @DisplayName("WhiteMarbleParser - showPlayer")
    public void WhiteMarbleParserTest15(){
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.COIN);
        resources.add(Resource.SERVANT);
        CommandParser commandParser = new WhiteMarbleParser(3,resources);
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
*/
}