package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.RestartAnswerMessage;

public class ResumeAnswerCommand extends Command {

    private boolean answer;

    public ResumeAnswerCommand(boolean answer) {
        this.answer = answer;
    }

    public boolean getAnswer() {
        return answer;
    }

    @Override
    public Message commandOn(){
        return new RestartAnswerMessage(answer);
    }
}
