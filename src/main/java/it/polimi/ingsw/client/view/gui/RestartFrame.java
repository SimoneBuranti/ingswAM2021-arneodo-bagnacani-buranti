package it.polimi.ingsw.client.view.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RestartFrame extends JFrame implements ActionListener {


    JTextField textField;
    JButton submitButton;
    JButton yesButton;
    JButton noButton;

    JPanel backGRoundPanel;



    public RestartFrame(){

        this.setLocation(475,208);
        this.setSize(1000,730);
        this.setLayout(new FlowLayout());

        this.setTitle("Master of Renaissance");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        ImageIcon icon = new ImageIcon("src/main/resources/resources/title.jpeg");
        Image image = icon.getImage();
        icon.setImage(image.getScaledInstance(600, 450, 0));
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 600, 450);
        add(background);
        
        
       /* this.submitButton = new JButton("Do you want restart the previous match?");
        this.submitButton.setSize(new Dimension(50,30));
        this.yesButton = new JButton("yes");
        this.yesButton.setSize(new Dimension(30,15));
        this.noButton = new JButton("no");
        this.noButton.setSize(new Dimension(30,15));
         /*this.textField = new JTextField();
         this.textField.setText("Username");
        this.textField.setEditable(true);
        this.textField.setPreferredSize(new Dimension(100,15));
        this.textField.addActionListener(e -> textField.setEditable(false));*/
       // this.submitButton.addActionListener(e -> this.);

        this.add(submitButton);


        
        
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

    }


}