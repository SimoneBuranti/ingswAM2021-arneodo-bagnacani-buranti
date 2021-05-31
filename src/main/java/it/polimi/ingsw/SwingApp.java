package it.polimi.ingsw;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.GameboardPanel;
import it.polimi.ingsw.client.view.gui.frames.LeaderCardsPanel;
import it.polimi.ingsw.client.view.gui.frames.MainFrame;
import it.polimi.ingsw.client.view.gui.frames.ServerMessagePanel;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SwingApp {

    public static void main(String[] args) {

        /*ProductionCardArray productionCardArray = new ProductionCardArray();
        ProductionDeckFrame productionDeckFrame;

        try {
            productionDeckFrame = new ProductionDeckFrame(new ViewController(new SocketClient("127.0.0.1", 1234, new Gui()), new Gui()));
            productionDeckFrame.addDecks(productionCardArray.getList());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("simone");
        nicknames.add("alice");
        nicknames.add("aeeeeeeeeeeeeeeee");
        nicknames.add("AAAAAAAAAAA");*/

        /*MainFrame mainFrame = new MainFrame("Master of Renaissance");
        mainFrame.initGameMode();
        mainFrame.setCurrentPlayer("simone");
        mainFrame.showLorenzoActionPopUp("ActionMarkerForCrossDouble");
        mainFrame.paintComponents(mainFrame.getGraphics());
        mainFrame.paintComponents(mainFrame.getGraphics());*/


        /*Frame frame = new JFrame();
        frame.setSize(1200,668);
        GameboardPanel gameboard = new GameboardPanel(new Gui());
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(gameboard);
        frame.setVisible(true);
        frame.setLocation(250,160);

        ProductionCardArray leaderCards = new ProductionCardArray();
        LeaderCardsPanel leaderCardsPanel = new LeaderCardsPanel(new Gui());
        frame.add(leaderCardsPanel);
        leaderCardsPanel.addLeaderCards(leaderCards.getList(), false);
        //leaderCardsPanel.discardLeaderCard(1);

        leaderCardsPanel.activatedLeaderCard(0, 4);
        leaderCardsPanel.activatedLeaderCard(1, 4);*/
        //leaderCardsPanel.activatedLeaderCard(1, 1);
        //leaderCardsPanel.addToStorageExtra(0, Resource.ROCK, 2);
        //leaderCardsPanel.addToStorageExtra(1,Resource.SERVANT, 2);

        //ActionMarkerPanel actionMarkerPanel = new ActionMarkerPanel();
        //frame.add(actionMarkerPanel);
        /*ServerMessagePanel serverMessagePanel = new ServerMessagePanel();
        frame.add(serverMessagePanel);
        serverMessagePanel.display("Ha un grande valore rappresentativo, essendo \n architettonicamente e artisticamente incentrato \nsul Risorgimento, il complesso processo di unità nazionale e liberazione dalla dominazione straniera portato a compimento sotto il regno di Vittorio Emanuele II di Savoia, cui il monumento è dedicato: per tale motivo il Vittoriano è considerato uno dei simboli patri italiani.");

        HashMap<Resource,Integer> newResources = new HashMap<>();
        newResources.put(Resource.COIN,3);
        newResources.put(Resource.ROCK,2);
        newResources.put(Resource.SHIELD,1);
        gameboard.updateStorage(newResources);


        newResources = new HashMap<>();
        newResources.put(Resource.SERVANT,1);
        newResources.put(Resource.SHIELD,0);
        newResources.put(Resource.COIN,1);
        gameboard.updateStorage(newResources);



        frame.paintComponents(frame.getGraphics());
        frame.paintComponents(frame.getGraphics());*/

    }

    //JOptionPane.showConfirmDialog(frame,"Error","Title",JOptionPane.ERROR_MESSAGE);

    /*
    frame.setTitle(String);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(dimensione);
    frame.setSize(width,heigth);
    frame.setVisible(true);

    ImageIcon image = new ImageIcon(image path);
    frame.estIconImage(image.getImage());


     */
}

/*
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI2();
            }
        });
JFrame frame = new JFrame();

        frame.setTitle("Master of Renaissance");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setSize(1050,700);

                ImageIcon image = new ImageIcon("resources/punchboard/calamaio.png");
                frame.setIconImage(image.getImage());
                frame.getContentPane().setBackground(new Color(255, 255, 255));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);

    private static void createAndShowGUI1() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        CustomFrame f = new CustomFrame();
        f.setBackground(new Color(255, 255, 255));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1050,700);
        f.setVisible(true);
    }

    private static void createAndShowGUI2() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        CustomFrame frame = new CustomFrame();
        frame.setTitle("Master of Renaissance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1050,700);

        ImageIcon image = new ImageIcon("resources/punchboard/calamaio.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
 */