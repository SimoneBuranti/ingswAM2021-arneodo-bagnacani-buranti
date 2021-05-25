package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.UsernameCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NickNameParserTest {
    public Cli cli;
    public ViewController viewController;

    NickNameParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
    }

    @Test
    @DisplayName("Nickname test - 1")
    public void NickNameParserTest1(){
        CommandParser commandParser = new NickNameParser();

        String nick;
        Command command;

        try {
            command = commandParser.parseCommand("simo",viewController,cli);
            assertTrue(command instanceof UsernameCommand);
            assertEquals(((UsernameCommand) command).getNickname(),"simo");
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

}