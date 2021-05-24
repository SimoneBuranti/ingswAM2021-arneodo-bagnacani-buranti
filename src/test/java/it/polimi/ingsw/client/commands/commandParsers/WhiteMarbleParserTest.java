package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.BaseProductionCommand;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.WhiteMarbleCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.Resource;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMarbleParserTest {

    public Cli cli;
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

}