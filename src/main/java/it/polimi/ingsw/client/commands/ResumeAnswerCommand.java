package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.RestartAnswerMessage;

public class ResumeAnswerCommand extends Command {

    /**
     * Answer attribute.
     */
    private boolean answer;
    //private Cli cli;

    public ResumeAnswerCommand(boolean answer) {
        this.answer = answer;
        //this.cli = cli;
    }

    /**
     * Answer attribute getter.
     * @return
     */
    public boolean getAnswer() {
        return answer;
    }

    /**
     * @return RestartAnswerMessage
     */
    @Override
    public Message commandOn(){

        //cli.changeCommandParser(new );
        return new RestartAnswerMessage(answer);
    }
}
