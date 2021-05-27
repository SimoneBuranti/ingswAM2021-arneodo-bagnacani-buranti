package it.polimi.ingsw.client.view.gui.frames;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class LobbyFrame extends JFrame implements ActionListener {


    JTextField textField;
    JButton submitButton;
    JFrame otherFrame;

    public LobbyFrame(JFrame otherFrame){

        this.otherFrame = otherFrame;

        this.setLocation(475,208);
        this.setSize(600,450);
        this.setLayout(new FlowLayout());

        this.setTitle("Master of Renaissance");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        getContentPane().setBackground(new Color(14, 26, 80));

        this.submitButton = new JButton("Submit");
        this.textField = new JTextField();
        this.textField.setText("Username");
        this.textField.setEditable(true);
        this.textField.setPreferredSize(new Dimension(100,15));
        this.textField.addActionListener(e -> textField.setEditable(false));
        this.submitButton.addActionListener(e -> {
            this.showNickname(textField.getText());
            this.otherFrame.setVisible(true);
            this.setVisible(false);
        });

        this.submitButton.setSize(new Dimension(30,15));



        this.add(textField);
        this.add(submitButton);

        this.setVisible(true);

        try {
            askRestartGame();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LobbyFrame(){

        this.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();




        Image img = Toolkit.getDefaultToolkit().getImage("src/main/resources/resources/board/Masters of Renaissance_PlayerBoard (11_2020)-1.png");

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
        pack();


        this.setVisible(true);
    }



    private void showNickname(String nick) {
        this.add(new Label(nick));
        this.setVisible(true);
    }


    public void startInterface(){
        try {
            askRestartGame();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        askUsername();


    }


    public void askUsername(){


        this.setVisible(true);

    }





    public boolean askRestartGame() throws IOException, InterruptedException {
        int resume;

        ImageIcon icon =new ImageIcon("src/main/resources/resources/punchboard/calamaio.png");
        Image image = icon.getImage();
        icon.setImage(image.getScaledInstance(40,40,0));

        resume = JOptionPane.showConfirmDialog(
                this,
                "Do you want to resume the previous match?",
                "Master of Renaissance",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon);

        return ((resume == 0));
    }









    @Override
    public void actionPerformed(ActionEvent e) {

        e.getSource();

    }

    public void handleAction(){

    }


}
