package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.messages.PushColumnMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushColumnButton extends JButton implements ActionListener {

    private int column;
    private ViewController viewController;

    public PushColumnButton(){

        //this.setIcon(new ImageIcon((Paths.getImageFromPath("src/main/resources/resources/punchboard/frecciaSx.png")).getScaledInstance(,,0)));
        //this.setBounds();
        //this.setSize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewController.sendMessage(new PushColumnMessage(this.column));
    }
}
