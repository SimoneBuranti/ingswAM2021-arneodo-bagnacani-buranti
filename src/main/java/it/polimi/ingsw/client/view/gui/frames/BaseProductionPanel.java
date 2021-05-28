package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.commands.BaseProductionCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.BaseProductionOnMessage;

import javax.swing.*;
import java.awt.*;

public class BaseProductionPanel extends JPanel {

    private static final int psWidth = 90;
    private static final int psHeight = 340;
    private static final int resourceDimension = 20;
    private static final int iX = 10;
    private static final int i1Y = 185;
    private static final int i2Y = 211;
    private static final int oX = 58;
    private static final int oY = 198;


    private ViewController viewController;
    private ResourceClickableLabel input1;
    private ResourceClickableLabel input2;
    private ResourceClickableLabel output;

    private JButton productionButton;

    public BaseProductionPanel(){

        this.setLayout(null);

        initInput1();

        initInput2();

        initOutput();

        productionButton = new JButton();
        productionButton.setSize(108,20);
        productionButton.setBounds(0,310,108,20);
        productionButton.addActionListener( e -> {
            //this.viewController.sendMessage(new BaseProductionOnMessage(this.input1.getSelected(),this.input2.getSelected(),this.output.getSelected()));
            System.out.println(new BaseProductionOnMessage(this.input1.getSelected(),this.input2.getSelected(),this.output.getSelected()));
            this.productionButton.setEnabled(false);
        });

        this.setSize(psWidth,psHeight);
        this.setBounds(205,225,psWidth,psHeight);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        this.add(productionButton);
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void initInput1(){
        input1 = new ResourceClickableLabel(iX,i1Y);
        input1.setBounds(iX,i1Y,resourceDimension,resourceDimension);
        input1.setOpaque(true);
        input1.setBackground(Color.BLACK);
        this.add(input1);
    }

    public void initInput2(){
        input2 = new ResourceClickableLabel(iX,i2Y);
        input2.setBounds(iX,i2Y,resourceDimension,resourceDimension);
        input2.setOpaque(true);
        input2.setBackground(Color.BLACK);
        this.add(input2);
    }

    public void initOutput(){
        output = new ResourceClickableLabel(oX,oY);
        output.setBounds(oX,oY,resourceDimension,resourceDimension);
        output.setOpaque(true);
        output.setBackground(Color.BLACK);
        this.add(output);
    }

}
