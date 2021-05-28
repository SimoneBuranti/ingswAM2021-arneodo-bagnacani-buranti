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
    private static final int deckWidth = 650;
    private static final int deckHeight = 800;
    private static final int marbleWidth = 140;
    private static final int marbleHeight = 212;

    private JPanel decksPanel;
    private PanelContainer container;
    private JFrame deckFrame;

    private JButton deck1Button;
    private JButton deck2Button;
    private JButton deck3Button;
    private JButton deck4Button;
    private JButton deck5Button;
    private JButton deck6Button;
    private JButton deck7Button;
    private JButton deck8Button;
    private JButton deck9Button;
    private JButton deck10Button;
    private JButton deck11Button;
    private JButton deck12Button;

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
            decksPanel.setLayout(new GridLayout(3, 4, 10,30));
            decksPanel.setBounds(0, 0, deckWidth, deckHeight);

            for(int i = 0; i < 3 ; i++){
                if(productionCards.get(5-i) != null){
                    decksPanel.add(new CardLabel(productionCards.get(5-i).getKey()));
                }else{
                    JLabel labelWhite = new JLabel();
                    labelWhite.setBackground(Color.WHITE);
                    decksPanel.add(labelWhite);
                }
                if(productionCards.get(2-i) != null){
                    decksPanel.add(new CardLabel(productionCards.get(2-i).getKey()));
                }
                if(productionCards.get(8-i) != null){
                    decksPanel.add(new CardLabel(productionCards.get(8-i).getKey()));
                }
                if(productionCards.get(11-i) != null){
                    decksPanel.add(new CardLabel(productionCards.get(11-i).getKey()));
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
