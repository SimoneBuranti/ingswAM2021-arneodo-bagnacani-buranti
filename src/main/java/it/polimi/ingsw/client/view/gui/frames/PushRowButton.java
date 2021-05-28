package it.polimi.ingsw.client.view.gui.frames;

import com.sun.rowset.internal.Row;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.gui.Paths;
import it.polimi.ingsw.messages.PushColumnMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushRowButton extends JButton implements ActionListener {

    private int row;
    private ViewController viewController;

    public PushRowButton(){

        //this.setIcon(new ImageIcon((Paths.getImageFromPath("src/main/resources/resources/punchboard/frecciaSx.png")).getScaledInstance(,,0)));
        //this.setBounds();
        //this.setSize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewController.sendMessage(new PushColumnMessage(this.row));
    }
}
