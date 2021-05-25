package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.ResumeAnswerCommand;
import it.polimi.ingsw.client.commands.UsernameCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ResumeGameParserTest {
    public Cli cli;
    public ViewController viewController;

    ResumeGameParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
    }

    @Test
    @DisplayName("ResumeGameParserTest - 1")
    public void ResumeGameParserTest1(){
        CommandParser commandParser = new ResumeGameParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("yes",viewController,cli);
            assertTrue(command instanceof ResumeAnswerCommand);
            assertEquals(((ResumeAnswerCommand) command).getAnswer(),true);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("ResumeGameParserTest - 2")
    public void ResumeGameParserTest2(){
        CommandParser commandParser = new ResumeGameParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("no",viewController,cli);
            assertTrue(command instanceof ResumeAnswerCommand);
            assertEquals(((ResumeAnswerCommand) command).getAnswer(),false);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("ResumeGameParserTest - 3")
    public void ResumeGameParserTest3(){
        CommandParser commandParser = new ResumeGameParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("boh",viewController,cli);
            assertTrue(false);
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command exception");
        }
    }

}