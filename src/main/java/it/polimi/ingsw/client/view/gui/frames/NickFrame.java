package it.polimi.ingsw.client.view.gui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NickFrame extends JFrame implements ActionListener {

    private JButton button;
    private JFrame otherFrame;

    public NickFrame(){
        this.setLocation(475,208);
        this.setSize(600,450);
        this.setLayout(new FlowLayout());

        this.setTitle("Master of Renaissance");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        getContentPane().setBackground(new Color(78, 80, 14));

        this.button = new JButton("Change");

        this.button.addActionListener(e -> {
            this.otherFrame.setVisible(true);
            this.setVisible(false);});

        this.button.setSize(new Dimension(30,15));


        this.add(button);

        this.setVisible(true);
    }

    public void setOtherFrame(JFrame otherFrame) {
        this.otherFrame = otherFrame;
    }

    public void askUsername() throws IOException, InterruptedException {

        String nickname;


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
