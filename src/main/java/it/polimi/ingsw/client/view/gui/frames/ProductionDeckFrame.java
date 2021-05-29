package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.client.view.gui.PanelContainer;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductionDeckFrame extends JFrame{
    private final ViewController viewController;
    private static final int deckWidth = 600;
    private static final int deckHeight = 800;

    private JPanel decksPanel;
    private PanelContainer container;
    private JFrame deckFrame;

    public ProductionDeckFrame(ViewController viewController){
        this.viewController = viewController;

        initDecks();

    }

    public void initDecks(){
        SwingUtilities.invokeLater(() -> {
            deckFrame = new JFrame("Production decks");
            deckFrame.setSize(deckWidth, deckHeight);
            deckFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            deckFrame.setResizable(true);
            deckFrame.getContentPane().setBackground( new Color(232,228,212) );
            container = new PanelContainer();
            container.setBounds(0, 0, deckWidth, deckHeight);

            deckFrame.add(container);

            deckFrame.setVisible(true);

        });
    }

    public void addDecks(ArrayList<ProductionCard> productionCards){
        SwingUtilities.invokeLater(() -> {
            clear(container);
            container.setLayout(null);
            decksPanel = new JPanel();
            decksPanel.setLayout(new GridLayout(3, 4, 10,0));
            decksPanel.setBounds(3, 0, deckWidth-20, deckHeight-50);
            decksPanel.setBackground( new Color(232,228,212) );
            for(int i = 0; i < 3 ; i++){
                if(productionCards.get(5-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(5-i).getKey(), 1+(4*i));
                    card.setSize(140, 248);
                    decksPanel.add(card);
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(2-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(2-i).getKey(), 2+(4*i));
                    card.setSize(140, 248);
                    decksPanel.add(card);
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(8-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(8-i).getKey(), 3+(4*i));
                    card.setSize(140, 248);
                    decksPanel.add(card);
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(11-i) != null){
                    CardLabelWithButton card = new CardLabelWithButton(productionCards.get(11-i).getKey(), 4+(4*i));
                    card.setSize(140, 248);
                    decksPanel.add(card);
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
            }
            container.add(decksPanel);
            applyChangesTo(container);
            deckFrame.setVisible(true);
        });
    }

    private void clear(JPanel panel){
        panel.removeAll();
    }

    private void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }

}
