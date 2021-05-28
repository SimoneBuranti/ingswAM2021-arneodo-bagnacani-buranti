package it.polimi.ingsw.client.commands.commandParsers;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.KeepLeaderCardsCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class InitLeaderCardParserTest {

    public Cli cli;
    public ViewController viewController;

    InitLeaderCardParserTest() throws IOException {

        cli = new Cli();
        viewController= new ViewController(cli);

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