package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.commands.BaseProductionCommand;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.BaseProductionOnMessage;

import javax.swing.*;
import java.awt.*;

public class BaseProductionPanel extends JPanel {

    private static final int psWidth = 90;
    private static final int psHeight = 340;
    private static final int resourceDimension = 27;
    private static final int iX = 8;
    private static final int i1Y = 182;
    private static final int i2Y = 208;
    private static final int oX = 56;
    private static final int oY = 195;


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
        productionButton.setSize(90,20);
        productionButton.setBounds(0,310,90,20);
        productionButton.setText("Activate");
        productionButton.setHorizontalTextPosition(SwingConstants.CENTER);
        productionButton.addActionListener( e -> {
            this.viewController.sendMessage(new BaseProductionOnMessage(this.input1.getResource(),this.input2.getResource(),this.output.getResource()));
            //System.out.println(new BaseProductionOnMessage(this.input1.getResource(),this.input2.getResource(),this.output.getResource()));
            this.productionButton.setEnabled(false);
        });

        this.setSize(psWidth,psHeight);
        this.setBounds(205,225,psWidth,psHeight);
        this.setOpaque(false);
        //this.setBackground(Color.WHITE);

        this.add(productionButton);
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void initInput1(){
        input1 = new ResourceClickableLabel(iX,i1Y);
        input1.setBounds(iX,i1Y,resourceDimension,resourceDimension);
        //input1.setOpaque(true);
        this.add(input1);
    }

    public void initInput2(){
        input2 = new ResourceClickableLabel(iX,i2Y);
        input2.setBounds(iX,i2Y,resourceDimension,resourceDimension);
        //input2.setOpaque(true);
        this.add(input2);
    }

    public void initOutput(){
        output = new ResourceClickableLabel(oX,oY);
        output.setBounds(oX,oY,resourceDimension,resourceDimension);
        //output.setOpaque(true);
        this.add(output);
    }

    public void enableButton(){
        this.productionButton.setEnabled(true);
    }

    public void disableButton(){
        this.productionButton.setEnabled(false);
    }

}
