package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.HowManyPlayersCommand;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.ResumeAnswerCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HowManyPlayerParserTest {

    public Cli cli;
    public ViewController viewController;

    HowManyPlayerParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - 1")
    public void HowManyPlayerParserTest1(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("1",viewController,cli);
            assertTrue(command instanceof HowManyPlayersCommand);
            assertEquals(((HowManyPlayersCommand) command).getnOfPlayers(),1);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - 2")
    public void HowManyPlayerParserTest2(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("2",viewController,cli);
            assertTrue(command instanceof HowManyPlayersCommand);
            assertEquals(((HowManyPlayersCommand) command).getnOfPlayers(),2);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - 3")
    public void HowManyPlayerParserTest3(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("3",viewController,cli);
            assertTrue(command instanceof HowManyPlayersCommand);
            assertEquals(((HowManyPlayersCommand) command).getnOfPlayers(),3);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - 4")
    public void HowManyPlayerParserTest4(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("4",viewController,cli);
            assertTrue(command instanceof HowManyPlayersCommand);
            assertEquals(((HowManyPlayersCommand) command).getnOfPlayers(),4);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - invalid")
    public void HowManyPlayerParserTest5(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("5",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - invalid")
    public void HowManyPlayerParserTest6(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("0",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

    @Test
    @DisplayName("HowManyPlayerParserTest - word")
    public void HowManyPlayerParserTest7(){
        CommandParser commandParser = new HowManyPlayerParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("hello",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

}