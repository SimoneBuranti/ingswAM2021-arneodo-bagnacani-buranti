package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.messages.PushColumnMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushColumnButton extends JButton{


    public PushColumnButton(){


        this.setIcon(new ImageIcon((Paths.getImageFromPath("src/main/resources/resources/punchboard/frecciaSu.png")).getScaledInstance(30,60,0)));
        this.setSize(30,60);
    }

}
