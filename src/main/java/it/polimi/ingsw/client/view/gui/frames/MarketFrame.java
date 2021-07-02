package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.client.view.gui.PanelContainer;
import it.polimi.ingsw.messages.PushColumnMessage;
import it.polimi.ingsw.messages.PushRowMessage;
import it.polimi.ingsw.server.model.marbles.Marble;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This class is used to create the frame of the market.
 */
public class MarketFrame extends JFrame{
    /**
     * This attribute indicates the width of the frame
     */
    private static final int marketWidth = 390;
    /**
     * This attribute indicates the height of the frame
     */
    private static final int marketHeight = 504;
    /**
     * This attribute indicates the width of the marble
     */
    private static final int marbleWidth = 40;
    /**
     * This attribute indicates the height of the marble
     */
    private static final int marbleHeight = 40;
    /**
     * This attribute indicates the position of the frame
     */
    private final static int marketX = 20;
    /**
     * This attribute indicates the position of the frame
     */
    private final static int marketY = 122;

    /**
     * This attribute represents the reference to the gui
     */
    private Gui gui;
    /**
     * This attribute is the component container of the frame
     */
    private PanelContainer container;
    /**
     * This attribute is a panel with black background
     */
    private JPanel blackPanel;

    /**
     * This component contains the gird of the market
     */
    private JPanel gridPanel;
    /**
     * This component contains the extra marble of the market
     */
    private JPanel extraPanel;

    /**
     * This attribute represents the zero column button
     */
    private PushColumnButton buttonC0;
    /**
     * This attribute represents the one column button
     */
    private PushColumnButton buttonC1;
    /**
     * This attribute represents the two column button
     */
    private PushColumnButton buttonC2;
    /**
     * This attribute represents the three column button
     */
    private PushColumnButton buttonC3;
    /**
     * This attribute represents the zero row button
     */
    private PushRowButton buttonR0;
    /**
     * This attribute represents the one row button
     */
    private PushRowButton buttonR1;
    /**
     * This attribute represents the two row button
     */
    private PushRowButton buttonR2;

    /**
     * This attribute is tre if the market is visible
     */
    private boolean visible;

    /**
     * Constructor of the class. It creates the market frame.
     * @param gui : the reference to the gui
     */
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

    /**
     * This method initialises the market background and the buttons.
     */
    public void initMarket(){
            this.setSize(marketWidth, marketHeight);
            this.setResizable(false);
            ImageIcon icon = new ImageIcon(getClass().getResource("/punchboard/plancia portabiglie.png"));
            Image image = icon.getImage();
            JPanel background = new PBackground(image);
            this.repaint();
            background.setLayout(null);
            this.add(background);

            blackPanel = new JPanel();
            blackPanel.setBackground(new Color(28, 28, 28));
            blackPanel.setBounds(60, 57, 257, 205);
            blackPanel.setOpaque(true);

            container = new PanelContainer();
            container.setBounds(0, 0, marketWidth, marketHeight);
            background.add(container);

            container.add(blackPanel);

            addButtons();
    }

    /**
     * This method changes the visibility of the frame
     */
    public void changeVisibility(){
        this.visible = !visible;
        this.setVisible(visible);
    }

    /**
     * This method creates and adds to the frame the buttons
     */
    public void addButtons(){

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

    }

    /**
     * This method disables all buttons
     */
    public void removeButton(){
        buttonC0.setEnabled(false);
        buttonC1.setEnabled(false);
        buttonC2.setEnabled(false);
        buttonC3.setEnabled(false);
        buttonR0.setEnabled(false);
        buttonR1.setEnabled(false);
        buttonR2.setEnabled(false);

    }

    /**
     * This method enables all buttons
     */
    public void enableButton(){
        buttonC0.setEnabled(true);
        buttonC1.setEnabled(true);
        buttonC2.setEnabled(true);
        buttonC3.setEnabled(true);
        buttonR0.setEnabled(true);
        buttonR1.setEnabled(true);
        buttonR2.setEnabled(true);

    }

    /**
     * This method sends a push column message when a column button has been clicked
     * @param column : the number of the column
     */
    public void sendPushColumn(int column){
        (new Thread(() -> {
            try {
                gui.notifyObserver(new PushColumnMessage(column));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        })).start();

        gui.actionDoneMode();
    }

    /**
     * This method sends a push row message when a row button has been clicked
     * @param row : the number of the row
     */
    public void sendPushRow(int row){

        (new Thread(() -> {
            try {
                gui.notifyObserver(new PushRowMessage(row));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        })).start();
        gui.actionDoneMode();
    }


    /**
     * This method sets the marbles in the market grid
     * @param grid : the marbles of the grid
     */
    public void setMarbleGrid(Marble[][] grid){
            if(gridPanel != null)
                clear(blackPanel);
            container.setLayout(null);
        blackPanel.setLayout(null);
            gridPanel = new JPanel();
            gridPanel.setOpaque(true);
            gridPanel.setBackground(new Color(28, 28, 28));
            gridPanel.setLayout(new GridLayout(3, 4, 5,5));
            //gridPanel.setBounds(43, 40, 192, 144);
            gridPanel.setBounds(52, 55, 175, 130);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    gridPanel.add(getMarble(grid[i][j].getColour()));
                }
            }
            blackPanel.add(gridPanel);
            applyChangesTo(blackPanel);
    }

    /**
     * This method sets the extra marble of the market
     * @param extra : the extra marble
     */
    public void setMarbleExtra(Marble extra){
        blackPanel.setLayout(null);
            extraPanel = new JPanel();
            extraPanel.setOpaque(false);
            extraPanel.setSize(marbleWidth, marbleHeight);
            extraPanel.setLocation(200, 0);

            extraPanel.add(getMarble(extra.getColour()));
            blackPanel.add(extraPanel);
            applyChangesTo(blackPanel);

    }

    /**
     * This method returns a label containing the marble with the color passed as a parameter
     * @param color : the marble color
     * @return : a label containing the marble
     */
    public JLabel getMarble(String color){
        switch (color) {
            case "white":
                ImageIcon whiteMarbleImage = new ImageIcon(getClass().getResource("/marbles/palline-04.png"));
                Image image = whiteMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                whiteMarbleImage.setImage(image);
                JLabel whiteMarble=new JLabel(whiteMarbleImage);
                return whiteMarble;
            case "blue":
                ImageIcon bluMarbleImage = new ImageIcon(getClass().getResource("/marbles/palline-03.png"));
                image = bluMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                bluMarbleImage.setImage(image);
                JLabel bluMarble=new JLabel(bluMarbleImage);
                return bluMarble;
            case "grey":
                ImageIcon greyMarbleImage = new ImageIcon(getClass().getResource("/marbles/palline-05.png"));
                image = greyMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                greyMarbleImage.setImage(image);
                JLabel greyMarble=new JLabel(greyMarbleImage);
                return greyMarble;
            case "yellow":
                ImageIcon yellowMarbleImage = new ImageIcon(getClass().getResource("/marbles/palline-07.png"));
                image = yellowMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                yellowMarbleImage.setImage(image);
                JLabel yellowMarble=new JLabel(yellowMarbleImage);
                return yellowMarble;
            case "purple":
                ImageIcon violetMarbleImage = new ImageIcon(getClass().getResource("/marbles/palline-06.png"));
                image = violetMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                violetMarbleImage.setImage(image);
                JLabel violetMarble=new JLabel(violetMarbleImage);
                return violetMarble;
            case "red":
                ImageIcon redMarbleImage = new ImageIcon(getClass().getResource("/marbles/palline-02.png"));
                image = redMarbleImage.getImage();
                image = image.getScaledInstance(marbleWidth, marbleHeight, 0);
                redMarbleImage.setImage(image);
                JLabel redMarble=new JLabel(redMarbleImage);
                return redMarble;


        }
        return null;
    }

    /**
     * This method removes all the marbles
     */
    private void clear(JPanel panel){
        panel.remove(gridPanel);
        panel.remove(extraPanel);
    }

    @Override
    public void paintComponents(Graphics g){
        super.paintComponents(g);
    }

    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }

}
