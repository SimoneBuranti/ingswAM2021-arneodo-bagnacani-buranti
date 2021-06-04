package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.ClientApp;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;

import javax.swing.*;
import java.awt.*;

public class IPInitialFrame extends JFrame {

    private Gui gui;

    private JTextField textField;
    private Image background;
    private PBackground uniquePanel;
    private JLabel textLabel;
    private JButton submitButton;

    public IPInitialFrame(){
        super();

        this.setLocation(Gui.initFrameX,Gui.initFrameY);
        this.setSize(Gui.initFrameWidth,Gui.initFrameHeight);
        this.setResizable(false);
        this.setAlwaysOnTop(true);


        this.textLabel = new JLabel("Insert the IP address of the server ");
        this.textLabel.setBounds(200,140,250,25);
        this.textLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        this.textLabel.setBackground(Color.WHITE);
        this.textLabel.setOpaque(true);

        this.textField = new JTextField("127.0.0.1");
        this.textField.setBounds(200,170,150,40);
        this.textField.setFont(new Font("Helvetica", Font.BOLD, 14));


        this.submitButton = new JButton("Submit");
        this.submitButton.setBounds(355,170,100,40);
        this.submitButton.addActionListener(e -> {
            String hostName = textField.getText();
            if (correctHostName(hostName)) {
                ClientApp.setIPAddress(hostName);
                notifyAll();
            } else {
                textLabel.setText("Please insert a valid host name");
                textLabel.setForeground(new Color(173, 0, 0));
            }
        });


        this.uniquePanel = new PBackground();
        Image image = Toolkit.getDefaultToolkit().createImage("src/main/resources/resources/board/Masters of Renaissance_PlayerBoard (11_2020)-2.png");
        this.background = image.getScaledInstance(Gui.initFrameWidth,Gui.initFrameHeight,0);
        this.uniquePanel.setSize(Gui.initFrameWidth,Gui.initFrameHeight);
        this.uniquePanel.setBounds(0,0,Gui.initFrameWidth,Gui.initFrameHeight);
        this.uniquePanel.setImage(this.background);
        this.uniquePanel.setLayout(null);


        this.uniquePanel.add(textField);
        this.uniquePanel.add(submitButton);
        this.uniquePanel.add(textLabel);

        this.add(uniquePanel);

        this.setVisible(true);

        this.paintComponents(this.getGraphics());
        this.paintComponents(this.getGraphics());
    }

    public static boolean correctHostName(String hostName){
        String cha;
        int figure;
        for(int i=0,cont = 0;i<hostName.length();i++){
            if (cont >0 && hostName.charAt(i) =='.')
                cont = 0;
            else if (cont == 0 && hostName.charAt(i)=='.')
                return false;
            else if (cont>3 && hostName.charAt(i)!='.')
                return false;
            else {
                cha = "";
                figure = Command.fromStringToInt(cha + hostName.charAt(i));
                if (figure <10 && figure >=0)
                    cont++;
                else
                    return false;
            }
        }
        return true;
    }

}
