package it.polimi.ingsw;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.client.view.gui.frames.GameboardPanel;
import it.polimi.ingsw.client.view.gui.frames.LobbyFrame;
import it.polimi.ingsw.client.view.gui.frames.NickFrame;
import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SwingApp {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setSize(800,600);
        GameboardPanel gameboard = new GameboardPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(gameboard);
        frame.setVisible(true);
        frame.setLocation(350,100);

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
        frame.paintComponents(frame.getGraphics());

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