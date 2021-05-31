package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.client.view.gui.PanelContainer;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductionDeckFrame extends JFrame{

    private static final int deckWidth = 580;
    private static final int deckHeight = 870;
    private final static int deckProductionX = 980;
    private final static int deckProductionY = 0;

    private Gui gui;
    private JPanel decksPanel;
    private PanelContainer container;

    private ArrayList<CardLabelWithButton> cardLabelWithButtons;

    private boolean visible;

    public  ProductionDeckFrame(Gui gui){
        this.gui = gui;

        initDecks();

    }

    public ProductionDeckFrame(){// SOLO PER GRAFICA

        initDecks();

    }


    public void initDecks(){
        SwingUtilities.invokeLater(() -> {
            //deckFrame = new JFrame("Production decks");
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

        });
    }

    public void changeVisibility(){
        this.visible = !visible;
        this.setVisible(visible);
    }

    public void addDecks(ArrayList<ProductionCard> productionCards){
        SwingUtilities.invokeLater(() -> {
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
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
            }
            container.add(decksPanel);
            applyChangesTo(container);
        });
    }

    private void clear(JPanel panel){
        panel.removeAll();
    }

    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }

    public void disableButtons() {
        for (CardLabelWithButton c : cardLabelWithButtons){
            c.disableButton();
        }
    }

    public void enableButtons() {
        for (CardLabelWithButton c : cardLabelWithButtons){
            c.enableButton();
        }
    }
}
