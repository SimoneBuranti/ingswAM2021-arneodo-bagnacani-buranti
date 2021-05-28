package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InitResourceCommand;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InitResourceParserTest {

    public Cli cli;
    public ViewController viewController;

    InitResourceParserTest() throws IOException {

        cli = new Cli();
        viewController= new ViewController(cli);

    }

    @Test
    @DisplayName("InitResourceParserTest - 1")
    public void InitResourceParserTest1(){
        CommandParser commandParser = new InitResourceParser(1);
        ArrayList<Resource> resources = new ArrayList<>();
        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("coin",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            resources.add(Resource.COIN);
            assertEquals(((InitResourceCommand) command).getResources(),resources);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("InitResourceParserTest - 2")
    public void InitResourceParserTest2(){
        CommandParser commandParser = new InitResourceParser(1);
        ArrayList<Resource> resources = new ArrayList<>();
        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("coin servant",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            resources.add(Resource.COIN);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("InitResourceParserTest - 3")
    public void InitResourceParserTest3(){
        CommandParser commandParser = new InitResourceParser(1);

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("simo",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("InitResourceParserTest - 4")
    public void InitResourceParserTest4(){
        CommandParser commandParser = new InitResourceParser(2);
        ArrayList<Resource> resources = new ArrayList<>();
        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("coin servant",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            resources.add(Resource.COIN);
            resources.add(Resource.SERVANT);
            assertEquals(((InitResourceCommand) command).getResources(),resources);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("InitResourceParserTest - 5")
    public void InitResourceParserTest5(){
        CommandParser commandParser = new InitResourceParser(2);
        ArrayList<Resource> resources = new ArrayList<>();
        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("coin servant coin",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            resources.add(Resource.COIN);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("InitResourceParserTest - 6")
    public void InitResourceParserTest6(){
        CommandParser commandParser = new InitResourceParser(2);

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("simo",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("InitResourceParserTest - 7")
    public void InitResourceParserTest7(){
        CommandParser commandParser = new InitResourceParser(2);

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("rock",viewController,cli);
            assertTrue(command instanceof InitResourceCommand);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }
}