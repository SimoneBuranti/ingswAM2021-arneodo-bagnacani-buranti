package it.polimi.ingsw;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.MainFrame;
import it.polimi.ingsw.client.view.gui.frames.MainFrameSinglePlayer;
import it.polimi.ingsw.messages.observable.EndGamePlayerWinnerMessage;
import it.polimi.ingsw.messages.observable.MagnificentWinMessage;
import it.polimi.ingsw.messages.observable.MyVictoryMessage;

public class appPopUp {
    public static void main(String[] args) {

        /*ProductionCardArray productionCardArray = new ProductionCardArray();
        ProductionDeckFrame productionDeckFrame;

        try {
            productionDeckFrame = new ProductionDeckFrame(new ViewController(new SocketClient("127.0.0.1", 1234, new Gui()), new Gui()));
            productionDeckFrame.addDecks(productionCardArray.getList());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //MainFrame frame = new MainFrame();
        int score=1;
        String nickname= "ale";
        Gui gui = new Gui();
        //MainFrame mainFrameOfGame = new MainFrameSinglePlayer(gui,"hello");
        /*mainFrameOfGame.showPopUp(new MyVictoryMessage(score));
        mainFrameOfGame.showPopUp(new MagnificentWinMessage());
        mainFrameOfGame.showPopUp("server is crashed, you i've been disconnected");
        mainFrameOfGame.showPopUp(new EndGamePlayerWinnerMessage(nickname));*/

    }

}
