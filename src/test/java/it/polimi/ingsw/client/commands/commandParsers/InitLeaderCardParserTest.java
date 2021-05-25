package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.KeepLeaderCardsCommand;
import it.polimi.ingsw.client.commands.KeepResourcesCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class InitLeaderCardParserTest {

    public Cli cli;
    public ViewController viewController;

    InitLeaderCardParserTest() throws IOException {
        cli = new Cli();
        viewController= new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
    }


    @Test
    @DisplayName("InitLeaderCard - two in a line")
    public void initCardLeaderCard1(){
        int[] chosen = new int[2];
        CommandParser commendParser = new InitLeaderCardParser();

        try {
            Command command = commendParser.parseCommand("1 2",viewController,cli);
            assertTrue( command instanceof KeepLeaderCardsCommand);
            assertEquals(((KeepLeaderCardsCommand) command).getChosenLeaderCards()[0],1);
            assertEquals(((KeepLeaderCardsCommand) command).getChosenLeaderCards()[1],2);
        } catch (InvalidCommandException e) {
            assertTrue(false);
            System.out.println("Invalid command");
        }

    }



}