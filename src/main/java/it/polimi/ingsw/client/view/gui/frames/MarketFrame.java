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
    private final static int marketX = 20;
    private final static int marketY = 122;

    private Gui gui;
    private PanelContainer container;

    private JPanel gridPanel;
    private JPanel extraPanel;

    private PushColumnButton buttonC0;
    private PushColumnButton buttonC1;
    private PushColumnButton buttonC2;
    private PushColumnButton buttonC3;
    private PushRowButton buttonR0;
    private PushRowButton buttonR1;
    private PushRowButton buttonR2;

    private boolean visible;

    public MarketFrame(Gui gui){
        super();
        this.gui = gui;

        this.setLocation(marketX,marketY);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        visible = false;
        this.setVisible(visible);
        initMarket();

    }

    /*public MarketFrame(){// SOLO PER GRAFICA
        super();
        this.setLocation(marketX,marketY);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        visible = false;
        this.setVisible(visible);
        initMarket();

    }*/

    public void initMarket(){
        SwingUtilities.invokeLater(() -> {
            //marketFrame = new JFrame("Market");
            this.setSize(marketWidth, marketHeight);
            //marketFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setResizable(false);
            ImageIcon icon = new ImageIcon("src/main/resources/resources/punchboard/plancia portabiglie.png");
            Image image = icon.getImage();
            JPanel background = new PBackground(image);
            this.repaint();
            background.setLayout(null);
            this.add(background);

            container = new PanelContainer();
            container.setBounds(0, 0, marketWidth, marketHeight);
            background.add(container);



            addButtons();

        });
    }

    public void changeVisibility(){
        this.visible = !visible;
        this.setVisible(visible);
    }

    public void addButtons(){
        SwingUtilities.invokeLater(() -> {
            container.setLayout(null);

            buttonC0 = new PushColumnButton();
            buttonC0.setBounds(115, 275, 30, 60);
            buttonC1 = new PushColumnButton();
            buttonC1.setBounds(157, 275, 30, 60);
            buttonC2 = new PushColumnButton();
            buttonC2.setBounds(205, 275, 30, 60);
            buttonC3 = new PushColumnButton();
            buttonC3.setBounds(247, 275, 30, 60);
            buttonR0 = new PushRowButton();
            buttonR0.setBounds(330, 113, 60, 30);
            buttonR1 = new PushRowButton();
            buttonR1.setBounds(330, 150, 60, 30);
            buttonR2 = new PushRowButton();
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
        });
    }

    public void removeButton(){
        buttonC0.setEnabled(false);
        buttonC1.setEnabled(false);
        buttonC2.setEnabled(false);
        buttonC3.setEnabled(false);
        buttonR0.setEnabled(false);
        buttonR1.setEnabled(false);
        buttonR2.setEnabled(false);

    }
    public void enableButton(){
        buttonC0.setEnabled(true);
        buttonC1.setEnabled(true);
        buttonC2.setEnabled(true);
        buttonC3.setEnabled(true);
        buttonR0.setEnabled(true);
        buttonR1.setEnabled(true);
        buttonR2.setEnabled(true);

    }

    public void sendPushColumn(int column){
        try {
            gui.notifyObserver(new PushColumnMessage(column));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gui.actionDoneMode();
    }

    public void sendPushRow(int row){
        try {
            gui.notifyObserver(new PushRowMessage(row));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gui.actionDoneMode();
    }


    public void setMarbleGrid(Marble[][] grid){
        //SwingUtilities.invokeLater(() -> {
            if(gridPanel != null)
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
        //});
    }

    public void setMarbleExtra(Marble extra){
        //SwingUtilities.invokeLater(() -> {
            container.setLayout(null);
            extraPanel = new JPanel();
            extraPanel.setOpaque(false);
            extraPanel.setSize(marbleWidth, marbleHeight);
            extraPanel.setLocation(250, 45);

            extraPanel.add(getMarble(extra.getColour()));
            container.add(extraPanel);
            applyChangesTo(container);
        //});

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
        panel.remove(gridPanel);
        panel.remove(extraPanel);
    }

    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }

}
