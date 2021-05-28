package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.client.view.gui.PanelContainer;
import it.polimi.ingsw.messages.PushColumnMessage;
import it.polimi.ingsw.messages.PushRowMessage;
import it.polimi.ingsw.messages.RestartAnswerMessage;
import it.polimi.ingsw.server.model.marbles.Marble;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MarketFrame extends JFrame{
    private static final int marketWidth = 390;
    private static final int marketHeight = 504;
    private static final int marbleWidth = 44;
    private static final int marbleHeight = 44;

    private final ViewController viewController;
    private PanelContainer container;

    private JPanel gridPanel;
    private JPanel extraPanel;
    private JFrame marketFrame;

    private JButton buttonC0;
    private JButton buttonC1;
    private JButton buttonC2;
    private JButton buttonC3;
    private JButton buttonR0;
    private JButton buttonR1;
    private JButton buttonR2;

    public MarketFrame(ViewController viewController){
        this.viewController = viewController;

        initMarket();

    }

    public void initMarket(){
        SwingUtilities.invokeLater(() -> {
            marketFrame = new JFrame("Market");
            marketFrame.setSize(marketWidth, marketHeight);
            marketFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            marketFrame.setResizable(false);
            ImageIcon icon = new ImageIcon("src/main/resources/resources/punchboard/plancia portabiglie.png");
            Image image = icon.getImage();
            JPanel background = new PBackground(image);
            marketFrame.repaint();
            background.setLayout(null);
            marketFrame.add(background);

            container = new PanelContainer();
            container.setBounds(0, 0, marketWidth, marketHeight);
            background.add(container);

            addButtons();

            marketFrame.setVisible(true);

        });
    }

    public void addButtons(){
        SwingUtilities.invokeLater(() -> {
            container.setLayout(null);

            buttonC0 = new JButton();
            buttonC0.setBounds(115, 275, 30, 60);
            buttonC1 = new JButton();
            buttonC1.setBounds(157, 275, 30, 60);
            buttonC2 = new JButton();
            buttonC2.setBounds(205, 275, 30, 60);
            buttonC3 = new JButton();
            buttonC3.setBounds(247, 275, 30, 60);
            buttonR0 = new JButton();
            buttonR0.setBounds(330, 113, 60, 30);
            buttonR1 = new JButton();
            buttonR1.setBounds(330, 150, 60, 30);
            buttonR2 = new JButton();
            buttonR2.setBounds(330, 190, 60, 30);

            container.add(buttonC0);
            container.add(buttonC1);
            container.add(buttonC2);
            container.add(buttonC3);
            container.add(buttonR0);
            container.add(buttonR1);
            container.add(buttonR2);

            this.buttonC0.addActionListener(eC0 -> {
                sendPushColumn(0);
            });
            this.buttonC1.addActionListener(eC1 -> {
                sendPushColumn(1);});
            this.buttonC2.addActionListener(eC2 -> {
                sendPushColumn(2);});
            this.buttonC3.addActionListener(eC3 -> {
                sendPushColumn(3);});
            this.buttonR0.addActionListener(eR0 -> {
                sendPushRow(0);});
            this.buttonR1.addActionListener(eR1 -> {
                sendPushRow(1);});
            this.buttonR2.addActionListener(eR2 -> {
                sendPushRow(2);});

            applyChangesTo(container);

            marketFrame.setVisible(true);
        });
    }

    public void sendPushColumn(int column){
        viewController.sendMessage(new PushColumnMessage(column));
        container.remove(buttonC0);
        container.remove(buttonC1);
        container.remove(buttonC2);
        container.remove(buttonC3);
        container.remove(buttonR0);
        container.remove(buttonR1);
        container.remove(buttonR2);

        applyChangesTo(container);
    }

    public void sendPushRow(int row){
        viewController.sendMessage(new PushRowMessage(row));
        container.remove(buttonC0);
        container.remove(buttonC1);
        container.remove(buttonC2);
        container.remove(buttonC3);
        container.remove(buttonR0);
        container.remove(buttonR1);
        container.remove(buttonR2);

        applyChangesTo(container);
    }


    public void setMarbleGrid(Marble[][] grid){
        SwingUtilities.invokeLater(() -> {
            clear(container);
            container.setLayout(null);
            gridPanel = new JPanel();
            gridPanel.setOpaque(false);
            gridPanel.setLayout(new GridLayout(3, 4));
            gridPanel.setBounds(100, 95, 192, 144);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    gridPanel.add(getMarble(grid[i][j].getColour()));
                }
            }
            container.add(gridPanel);
            applyChangesTo(container);
            marketFrame.setVisible(true);
        });
    }

    public void setMarbleExtra(Marble extra){
        SwingUtilities.invokeLater(() -> {
            container.setLayout(null);
            extraPanel = new JPanel();
            extraPanel.setOpaque(false);
            extraPanel.setSize(marbleWidth, marbleHeight);
            extraPanel.setLocation(250, 45);

            extraPanel.add(getMarble(extra.getColour()));
            container.add(extraPanel);
            marketFrame.setVisible(true);
            applyChangesTo(container);
        });

    }

    public JLabel getMarble(String color){
        switch (color) {
            case "white":
                ImageIcon whiteMarbleImage = new ImageIcon("src/main/resources/resources/marbles/palline-04.png");
                Image image = whiteMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                whiteMarbleImage.setImage(image);
                JLabel whiteMarble=new JLabel(whiteMarbleImage);
                return whiteMarble;
            case "blue":
                ImageIcon bluMarbleImage = new ImageIcon("src/main/resources/resources/marbles/palline-03.png");
                image = bluMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                bluMarbleImage.setImage(image);
                JLabel bluMarble=new JLabel(bluMarbleImage);
                return bluMarble;
            case "grey":
                ImageIcon greyMarbleImage = new ImageIcon("src/main/resources/resources/marbles/palline-05.png");
                image = greyMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                greyMarbleImage.setImage(image);
                JLabel greyMarble=new JLabel(greyMarbleImage);
                return greyMarble;
            case "yellow":
                ImageIcon yellowMarbleImage = new ImageIcon("src/main/resources/resources/marbles/palline-07.png");
                image = yellowMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                yellowMarbleImage.setImage(image);
                JLabel yellowMarble=new JLabel(yellowMarbleImage);
                return yellowMarble;
            case "purple":
                ImageIcon violetMarbleImage = new ImageIcon("src/main/resources/resources/marbles/palline-06.png");
                image = violetMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                violetMarbleImage.setImage(image);
                JLabel violetMarble=new JLabel(violetMarbleImage);
                return violetMarble;
            case "red":
                ImageIcon redMarbleImage = new ImageIcon("src/main/resources/resources/marbles/palline-02.png");
                image = redMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                redMarbleImage.setImage(image);
                JLabel redMarble=new JLabel(redMarbleImage);
                return redMarble;


        }
        return null;
    }

    private void clear(JPanel panel){
        panel.removeAll();
    }

    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }

}
