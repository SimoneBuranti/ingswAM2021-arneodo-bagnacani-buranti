package it.polimi.ingsw.server.model;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.actionMarkers.*;
import it.polimi.ingsw.server.model.exceptions.EmptyException;
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

        assertEquals("ActionMarkerForCrossDouble", actionMarker.getType());

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

    /**
     * Check of the correct behavior of the action marker that moves the black cross forward by one space
     */
    @Test
    @DisplayName("Action Marker Black Cross Once Test")
    public void ActionMarkerCrossOnceTest() throws IOException, InterruptedException {
        ActionMarkerForCrossOnce actionMarker = new ActionMarkerForCrossOnce();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals("ActionMarkerForCrossOnce", actionMarker.getType());

        assertEquals(0, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);

        assertEquals(1, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);

        assertEquals(4, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);

        assertEquals(8, game.getLorenzoFaithIndicator());

        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);
        game.activateActionMarker(actionMarker);

        assertEquals(12, game.getLorenzoFaithIndicator());

        FileClass.FileDestroyer();

    }


    /**
     * Check of the correct behavior of the action marker that removes two blue production cards
     */
    @Test
    @DisplayName("Action Marker Production Blue Test")
    public void ActionMarkerProductionBlueTest() throws IOException, InterruptedException {
        ActionMarkerProductionBlue actionMarker = new ActionMarkerProductionBlue();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals("ActionMarkerProductionBlue", actionMarker.getType());

        assertEquals(4, game.productionDeckSize(0));
        assertEquals(4, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(0));
        assertEquals(4, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(4, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(2, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(0, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(0, game.productionDeckSize(1));
        assertEquals(2, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(0, game.productionDeckSize(1));
        assertEquals(0, game.productionDeckSize(2));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two blue production cards
     */
    @Test
    @DisplayName("Action Marker Production Blue And Buy Test")
    public void ActionMarkerProductionBlueAndBuyTest() throws IOException, InterruptedException {
        ActionMarkerProductionBlue actionMarker = new ActionMarkerProductionBlue();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals(4, game.productionDeckSize(0));
        assertEquals(4, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(0));
        assertEquals(4, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        try {
            game.deckFromDeckNumber(10).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(1, game.productionDeckSize(0));
        assertEquals(4, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(3, game.productionDeckSize(1));
        assertEquals(4, game.productionDeckSize(2));

        try {
            game.deckFromDeckNumber(2).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(3, game.productionDeckSize(1));
        assertEquals(3, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(1, game.productionDeckSize(1));
        assertEquals(3, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(0, game.productionDeckSize(1));
        assertEquals(2, game.productionDeckSize(2));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(0));
        assertEquals(0, game.productionDeckSize(1));
        assertEquals(0, game.productionDeckSize(2));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two green production cards
     */
    @Test
    @DisplayName("Action Marker Production Green Test")
    public void ActionMarkerProductionGreenTest() throws IOException, InterruptedException {
        ActionMarkerProductionGreen actionMarker = new ActionMarkerProductionGreen();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals("ActionMarkerProductionGreen", actionMarker.getType());

        assertEquals(4, game.productionDeckSize(3));
        assertEquals(4, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(3));
        assertEquals(4, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(4, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(2, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(0, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(0, game.productionDeckSize(4));
        assertEquals(2, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(0, game.productionDeckSize(4));
        assertEquals(0, game.productionDeckSize(5));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two green production cards
     */
    @Test
    @DisplayName("Action Marker Production Green And Buy Test")
    public void ActionMarkerProductionGreenAndBuyTest() throws IOException, InterruptedException {
        ActionMarkerProductionGreen actionMarker = new ActionMarkerProductionGreen();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals(4, game.productionDeckSize(3));
        assertEquals(4, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(3));
        assertEquals(4, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        try {
            game.deckFromDeckNumber(9).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(1, game.productionDeckSize(3));
        assertEquals(4, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(3, game.productionDeckSize(4));
        assertEquals(4, game.productionDeckSize(5));

        try {
            game.deckFromDeckNumber(1).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(3, game.productionDeckSize(4));
        assertEquals(3, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(1, game.productionDeckSize(4));
        assertEquals(3, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(0, game.productionDeckSize(4));
        assertEquals(2, game.productionDeckSize(5));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(3));
        assertEquals(0, game.productionDeckSize(4));
        assertEquals(0, game.productionDeckSize(5));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two violet production cards
     */
    @Test
    @DisplayName("Action Marker Production Violet Test")
    public void ActionMarkerProductionVioletTest() throws IOException, InterruptedException {
        ActionMarkerProductionViolet actionMarker = new ActionMarkerProductionViolet();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals("ActionMarkerProductionViolet", actionMarker.getType());

        assertEquals(4, game.productionDeckSize(6));
        assertEquals(4, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(6));
        assertEquals(4, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(4, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(2, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(0, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(0, game.productionDeckSize(7));
        assertEquals(2, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(0, game.productionDeckSize(7));
        assertEquals(0, game.productionDeckSize(8));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two violet production cards
     */
    @Test
    @DisplayName("Action Marker Production Violet And Buy Test")
    public void ActionMarkerProductionVioletAndBuyTest() throws IOException, InterruptedException {
        ActionMarkerProductionViolet actionMarker = new ActionMarkerProductionViolet();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals(4, game.productionDeckSize(6));
        assertEquals(4, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(6));
        assertEquals(4, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        try {
            game.deckFromDeckNumber(12).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(1, game.productionDeckSize(6));
        assertEquals(4, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(3, game.productionDeckSize(7));
        assertEquals(4, game.productionDeckSize(8));

        try {
            game.deckFromDeckNumber(4).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(3, game.productionDeckSize(7));
        assertEquals(3, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(1, game.productionDeckSize(7));
        assertEquals(3, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(0, game.productionDeckSize(7));
        assertEquals(2, game.productionDeckSize(8));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(6));
        assertEquals(0, game.productionDeckSize(7));
        assertEquals(0, game.productionDeckSize(8));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two yellow production cards
     */
    @Test
    @DisplayName("Action Marker Production Yellow Test")
    public void ActionMarkerProductionYellowTest() throws IOException, InterruptedException {
        ActionMarkerProductionYellow actionMarker = new ActionMarkerProductionYellow();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals("ActionMarkerProductionYellow", actionMarker.getType());

        assertEquals(4, game.productionDeckSize(9));
        assertEquals(4, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(9));
        assertEquals(4, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(4, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(2, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(0, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(0, game.productionDeckSize(10));
        assertEquals(2, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(0, game.productionDeckSize(10));
        assertEquals(0, game.productionDeckSize(11));

        FileClass.FileDestroyer();

    }

    /**
     * Check of the correct behavior of the action marker that removes two yellow production cards
     */
    @Test
    @DisplayName("Action Marker Production Yellow And Buy Test")
    public void ActionMarkerProductionYellowAndBuyTest() throws IOException, InterruptedException {
        ActionMarkerProductionYellow actionMarker = new ActionMarkerProductionYellow();
        Server server= new Server();
        ClientHandler clientHandler= new ClientHandler(server);
        ClientController clientController= new ClientController(server,clientHandler) ;
        VirtualView virtualView = new VirtualView(clientController);

        GameSolitaire game = new GameSolitaire("Ali",true,clientController);

        assertEquals(4, game.productionDeckSize(9));
        assertEquals(4, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(2, game.productionDeckSize(9));
        assertEquals(4, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        try {
            game.deckFromDeckNumber(11).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(1, game.productionDeckSize(9));
        assertEquals(4, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(3, game.productionDeckSize(10));
        assertEquals(4, game.productionDeckSize(11));

        try {
            game.deckFromDeckNumber(3).removeOneCard();
        } catch (EmptyException | EndOfSolitaireGame ignored) {
        }

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(3, game.productionDeckSize(10));
        assertEquals(3, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(1, game.productionDeckSize(10));
        assertEquals(3, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(0, game.productionDeckSize(10));
        assertEquals(2, game.productionDeckSize(11));

        game.activateActionMarker(actionMarker);

        assertEquals(0, game.productionDeckSize(9));
        assertEquals(0, game.productionDeckSize(10));
        assertEquals(0, game.productionDeckSize(11));

        FileClass.FileDestroyer();

    }

}
