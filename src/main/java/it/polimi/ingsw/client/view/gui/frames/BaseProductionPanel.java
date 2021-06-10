package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.commands.BaseProductionCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.messages.ActivateLeaderCardMessage;
import it.polimi.ingsw.messages.BaseProductionOnMessage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BaseProductionPanel extends JPanel {

    /**
     * Graphic parameters.
     */
    private static final int psWidth = 90;
    private static final int psHeight = 340;
    private static final int resourceDimension = 27;
    private static final int iX = 8;
    private static final int i1Y = 182;
    private static final int i2Y = 208;
    private static final int oX = 56;
    private static final int oY = 195;

    /**
     * Player's Gui reference.
     */
    private Gui gui;

    /**
     * Clickable resource label representing the first input resource.
     */
    private ResourceClickableLabel input1;

    /**
     * Clickable resource label representing the second input resource.
     */
    private ResourceClickableLabel input2;

    /**
     * Clickable resource label representing the base production output.
     */
    private ResourceClickableLabel output;

    /**
     * Base-production button.
     */
    private ProductionButton productionButton;

    /**
     * Panel constructor.
     * @param gui
     */
    public BaseProductionPanel(Gui gui){

        this.gui = gui;

        this.setLayout(null);

        initInput1();

        initInput2();

        initOutput();

        productionButton = new ProductionButton();
        productionButton.setSize(90,20);
        productionButton.setBounds(0,310,90,20);
        productionButton.setText("Activate");
        productionButton.setToken(true);
        productionButton.setHorizontalTextPosition(SwingConstants.CENTER);
        productionButton.addActionListener( e -> {
            productionButton.setToken(false);
            this.productionButton.setEnabled(false);
            this.gui.disableAllExceptProductions();

            (new Thread(() -> {
                try {
                    this.gui.notifyObserver(new BaseProductionOnMessage(this.input1.getResource(),this.input2.getResource(),this.output.getResource()));
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            })).start();
        });

        this.setSize(psWidth,psHeight);
        this.setBounds(205,225,psWidth,psHeight);
        this.setOpaque(false);
        //this.setBackground(Color.WHITE);

        this.add(productionButton);
    }


    /**
     * Initial input settings - first input resource.
     */
    public void initInput1(){
        input1 = new ResourceClickableLabel(iX,i1Y);
        input1.setBounds(iX,i1Y,resourceDimension,resourceDimension);
        //input1.setOpaque(true);
        this.add(input1);
    }

    /**
     * Initial input settings - second input resource.
     */
    public void initInput2(){
        input2 = new ResourceClickableLabel(iX,i2Y);
        input2.setBounds(iX,i2Y,resourceDimension,resourceDimension);
        //input2.setOpaque(true);
        this.add(input2);
    }

    /**
     * Initial output settings - output resource.
     */
    public void initOutput(){
        output = new ResourceClickableLabel(oX,oY);
        output.setBounds(oX,oY,resourceDimension,resourceDimension);
        //output.setOpaque(true);
        this.add(output);
    }

    /**
     * Enables the base-prouction button.
     */
    public void enableButton(){
        this.productionButton.setToken(true);
        this.productionButton.setEnabled(true);
    }

    /**
     * Disable the base-production button.
     */
    public void disableButton(){
        this.productionButton.setToken(false);
        this.productionButton.setEnabled(false);
    }

    /**
     * Base-production button getter.
     * @return
     */
    public ProductionButton getProductionButton(){
        return productionButton;
    }

}
