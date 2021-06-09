package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PanelContainer;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class is used to create the frame of the production card decks.
 */
public class ProductionDeckFrame extends JFrame{
    /**
     * This attribute indicates the width of the frame
     */
    private static final int deckWidth = 580;
    /**
     * This attribute indicates the height of the frame
     */
    private static final int deckHeight = 870;
    /**
     * This attribute indicates the position of the frame
     */
    private final static int deckProductionX = 980;
    /**
     * This attribute indicates the position of the frame
     */
    private final static int deckProductionY = 0;

    /**
     * This attribute represents the reference to the gui
     */
    private Gui gui;
    /**
     * This component contains the decks
     */
    private JPanel decksPanel;
    /**
     * This attribute is the component container of the frame
     */
    private PanelContainer container;

    /**
     * This attributes contains the reference to all the labels with a production cards
     */
    private ArrayList<CardLabelWithButton> cardLabelWithButtons;

    /**
     * This attribute is tre if the market is visible
     */
    private boolean visible;

    /**
     * Constructor of the class. It creates the production deck frame.
     * @param gui : the reference to the gui
     */
    public  ProductionDeckFrame(Gui gui){
        this.gui = gui;

        initDecks();

    }

    /**
     * This method initialises the frame.
     */
    public void initDecks(){

            this.setLocation(deckProductionX,deckProductionY);
            this.setSize(deckWidth, deckHeight);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.setResizable(false);
            this.setAlwaysOnTop(true);

            this.cardLabelWithButtons = new ArrayList<>();

            container = new PanelContainer();
            container.setBounds(0, 0, deckWidth, deckHeight);

            this.add(container);

            this.setDefaultCloseOperation(HIDE_ON_CLOSE);
            visible = false;
            this.setVisible(visible);


    }

    /**
     * This method changes the visibility of the frame
     */
    public void changeVisibility(){
        this.visible = !visible;
        this.setVisible(visible);
    }

    /**
     * This method sets all visible the production cards of the decks or an empty label
     * @param productionCards : a list containing the production cards to add
     */
    public void addDecks(ArrayList<ProductionCard> productionCards){

            clear(container);
            container.setLayout(null);
            cardLabelWithButtons = new ArrayList<>();
            decksPanel = new JPanel();
            decksPanel.setLayout(new GridLayout(3, 4, 10,0));
            decksPanel.setBounds(3, 0, deckWidth-20, deckHeight-50);
            decksPanel.setBackground( new Color(232,228,212) );
            for(int i = 0; i < 3 ; i++){
                if(productionCards.get(5-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(5-i).getKey(), 1+(4*i),gui);
                    card.setSize(140, 248);
                    decksPanel.add(card);
                    cardLabelWithButtons.add(card);
                    card.disableButton();
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(2-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(2-i).getKey(), 2+(4*i),gui);
                    card.setSize(140, 248);
                    decksPanel.add(card);
                    cardLabelWithButtons.add(card);
                    card.disableButton();
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(8-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(8-i).getKey(), 3+(4*i),gui);
                    card.setSize(140, 248);
                    decksPanel.add(card);
                    cardLabelWithButtons.add(card);
                    card.disableButton();
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(11-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(11-i).getKey(), 4+(4*i),gui);
                    card.setSize(140, 248);
                    decksPanel.add(card);
                    cardLabelWithButtons.add(card);
                    card.disableButton();
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
            }
            container.add(decksPanel);
            applyChangesTo(container);


    }

    /**
     * This method removes all from the frame
     */
    private void clear(JPanel panel){
        panel.removeAll();
    }

    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }

    /**
     * This method disables all buttons
     */
    public void disableButtons() {
        for (CardLabelWithButton c : cardLabelWithButtons){
            c.disableButton();
        }
    }

    /**
     * This method enables all buttons
     */
    public void enableButtons() {
        for (CardLabelWithButton c : cardLabelWithButtons){
            c.enableButton();
        }
    }
}
