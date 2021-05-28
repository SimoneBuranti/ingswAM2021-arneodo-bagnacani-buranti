package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.messages.PushColumnMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushRowButton extends JButton{


    public PushRowButton(){

        this.setIcon(new ImageIcon((Paths.getImageFromPath("src/main/resources/resources/punchboard/frecciaSx.png")).getScaledInstance(60,30,0)));
        this.setSize(60,30);
    }

}
