package it.polimi.ingsw;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.GameboardPanel;
import it.polimi.ingsw.client.view.gui.frames.LobbyFrame;
import it.polimi.ingsw.client.view.gui.frames.NickFrame;

import javax.swing.*;

public class SwingApp {

    public static void main(String[] args) {


        JFrame frame = new JFrame();


        GameboardPanel p = new GameboardPanel();


        frame.setSize(500,500);
        frame.add(p);

        frame.setVisible(true);




    }


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