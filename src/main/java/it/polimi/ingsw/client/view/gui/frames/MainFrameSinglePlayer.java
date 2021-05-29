package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.gui.*;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrameSinglePlayer extends MainFrame{
    private PanelContainer container;
    private JLabel errorLabel;
    private Gui gui;

    private int readyToSend=0;

    public MainFrameSinglePlayer(Gui gui,String title){
        super(title);
        this.gui=gui;
        SwingUtilities.invokeLater(() -> {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocation(475,208);
            this.setSize(820,420);

            this.setResizable(true);



            ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
            Image image=icon.getImage();
            JPanel background = new PBackground(image);
            this.repaint();
            background.setLayout(null);
            this.add(background);
            background.setOpaque(true);
            //mainFrame.add(errorText);

            // Prepare the body container
            container = new PanelContainer();
            container.setBounds(50,35, 700, 400);
            background.add(container);

            this.setVisible(true);

        });

    }


    public MainFrameSinglePlayer(){     // SOLO PER FARE LA GRAFICA
        super("Master of Renaissance");
        SwingUtilities.invokeLater(() -> {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocation(475,208);
            this.setSize(820,420);

            this.setResizable(true);



            ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpg");
            Image image=icon.getImage();
            JPanel background = new PBackground(image);
            this.repaint();
            background.setLayout(null);
            this.add(background);
            background.setOpaque(true);
            //mainFrame.add(errorText);

            // Prepare the body container
            container = new PanelContainer();
            container.setBounds(50,35, 700, 400);
            background.add(container);
            //---------------------------------------------------------------------------------------------



            //---------------------------------------------------------------------------------------------
            this.setVisible(true);

        });

    }




    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards) throws IOException, InterruptedException {

        SwingUtilities.invokeLater(() -> {
            clear(container);

            CardManager cardManager = new CardManager(container,gui);
            cardManager.setHeading("Choose two cards:");
            cardManager.showWhatToChoose(true);

            applyChangesTo(container);
        });

    }

    /**
     * Apply changes to a component
     * @param component The component
     */
    @Override
    public void applyChangesTo(Component component) {
        component.revalidate();
        component.repaint();
    }


    /**
     * Flush the components inside a frame
     * @param frame     The frame
     */
    @Override
    public void clear(JFrame frame){
        frame.getContentPane().removeAll();
    }


    /**
     * Flush the components inside a panel
     * @param panel     The panel
     */
    @Override
    public void clear(JPanel panel){
        panel.removeAll();
    }

    @Override
    public void showLabel(Message message){
        SwingUtilities.invokeLater(() -> {
            clear(container);
            container.setLayout(new FlowLayout());
            errorLabel = new JLabel(message.toString());
            container.add(errorLabel);
            errorLabel.setLocation(475,108);
            errorLabel.setSize(100,100);
            applyChangesTo(container);

        });
    }

    @Override
    public void askInitResource() throws IOException, InterruptedException {

        SwingUtilities.invokeLater(() -> {
            clear(container);

            if (gui.getViewController().getGame().getPosition()!=1)
            {
                ResourceManager resourceManager = new ResourceManager(container,gui);
                resourceManager.setHeading("Choose two resources:");
                resourceManager.showWhatToChoose(true);
            }
            else
            {

                container.setLayout(new FlowLayout());
                errorLabel = new JLabel("sorry, you are the first player, take a nap");
                errorLabel.setBackground(Color.WHITE);
                errorLabel.setOpaque(true);
                container.add(errorLabel);
                errorLabel.setLocation(475,108);
                errorLabel.setSize(100,100);
            }

            applyChangesTo(container);
        });}


}
