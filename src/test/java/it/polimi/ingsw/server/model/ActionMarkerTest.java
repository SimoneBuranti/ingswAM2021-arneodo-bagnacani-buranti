package it.polimi.ingsw.server.model;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerForCrossDouble;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarkerProductionBlue;
import it.polimi.ingsw.server.model.exceptions.EndOfSolitaireGame;
import it.polimi.ingsw.server.network.ClientHandler;
import it.polimi.ingsw.server.network.Server;
import it.polimi.ingsw.server.virtualview.VirtualView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * test class about ActionMarkerTest
 */
public class ActionMarkerTest {

    /**
     * Check of the correct behavior of the action marker that moves the black cross forward by two spaces
     */
    @Test
    @DisplayName("Action Marker Black Cross Double Test")
    public void ActionMarkerCrossDoubleTest() throws IOException, InterruptedException {
        ActionMarkerForCrossDouble actionMarker = new ActionMarkerForCrossDouble();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        ActionMarker actionMarker1;
        actionMarker1 = game.showFirst();
        assertEquals(0, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(4, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(8, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(16, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        actionMarker1 = game.showFirst();
        game.activateActionMarker(actionMarker);

        assertEquals(24, game.getLorenzoFaithIndicator());
        assertEquals(actionMarker1, game.showFirst());

        FileClass.FileDestroyer();

    }
}
