package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.PBackground;
import it.polimi.ingsw.client.view.gui.PanelContainer;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductionDeckFrame extends JFrame{
    private ViewController viewController;
    private static final int deckWidth = 580;
    private static final int deckHeight = 870;
    private final static int deckProductionX = 980;
    private final static int deckProductionY = 0;

    private JPanel decksPanel;
    private PanelContainer container;

    private boolean visible;

    public ProductionDeckFrame(ViewController viewController){
        this.viewController = viewController;

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
            decksPanel = new JPanel();
            decksPanel.setLayout(new GridLayout(3, 4, 10,0));
            decksPanel.setBounds(0, 0, deckWidth, deckHeight);

            for(int i = 0; i < 3 ; i++){
                if(productionCards.get(5-i) != null){
                    decksPanel.add(new CardLabelWithButton(productionCards.get(5-i).getKey(), 1+(4*i)));
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(2-i) != null){
                    decksPanel.add(new CardLabelWithButton(productionCards.get(2-i).getKey(), 2+(4*i)));
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(8-i) != null){
                    decksPanel.add(new CardLabelWithButton(productionCards.get(8-i).getKey(),3+(4*i)));
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(11-i) != null){
                    decksPanel.add(new CardLabelWithButton(productionCards.get(11-i).getKey(),4+(4*i)));
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
            }
            container.add(decksPanel);
            applyChangesTo(container);
            this.setVisible(true);
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
