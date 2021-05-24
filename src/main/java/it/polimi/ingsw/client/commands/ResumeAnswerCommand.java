package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.RestartAnswerMessage;

public class ResumeAnswerCommand extends Command {

    private boolean answer;
    //private Cli cli;

    public ResumeAnswerCommand(boolean answer,Cli cli) {
        this.answer = answer;
        //this.cli = cli;
    }

    public boolean getAnswer() {
        return answer;
    }

    @Override
    public Message commandOn(){

        //cli.changeCommandParser(new );
        return new RestartAnswerMessage(answer);
    }
}
