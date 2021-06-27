package it.polimi.ingsw.client.view.gui.frames;


import it.polimi.ingsw.MainApp;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.PBackground;

import javax.swing.*;
import java.awt.*;

public class IPInitialFrame extends JFrame {

    /**
     * Graphic parameters.
     */
    private final static int initFrameWidth = 600;
    private final static int initFrameHeight = 450;

    /**
     * Gui reference.
     */
    private Gui gui;

    /**
     * Host name textField
     */
    private JTextField textField;

    /**
     * Background image attribute.
     */
    private Image background;

    /**
     * Backgournd panel.
     */
    private PBackground uniquePanel;

    /**
     * Text label.
     */
    private JLabel textLabel;
    /**
     * Submit button.
     */
    private JButton submitButton;

    /**
     * Port number textField
     */
    private JTextField portNumberField;


    /**
     * Class constructor.
     */
    public IPInitialFrame(){
        super();

        this.setLocation(Gui.initFrameX,Gui.initFrameY);
        this.setSize(initFrameWidth,initFrameHeight);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);


        this.textLabel = new JLabel("Insert the IP address of the server ");
        this.textLabel.setBounds(270,140,250,25);
        this.textLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        this.textLabel.setForeground(Color.WHITE);
        this.textLabel.setOpaque(false);

        this.textField = new JTextField(MainApp.defHostName);
        this.textField.setForeground(Color.WHITE);
        this.textField.setBounds(270,170,150,40);
        this.textField.setFont(new Font("Helvetica", Font.BOLD, 16));
        this.textField.setOpaque(false);

        this.portNumberField = new JTextField(Command.fromIntToString(MainApp.defPortNumber));
        this.portNumberField.setForeground(Color.WHITE);
        this.portNumberField.setBounds(270,212,150,40);
        this.portNumberField.setFont(new Font("Helvetica", Font.BOLD, 14));
        this.portNumberField.setVisible(true);
        this.portNumberField.setOpaque(false);


        this.submitButton = new JButton("Submit");
        this.submitButton.setBounds(425,212,100,40);
        this.submitButton.addActionListener(e -> {
            String hostName = textField.getText();
            String portNumber = portNumberField.getText();
            if (correctHostName(hostName) && correctPortNumber(portNumber)) {
                MainApp.setIPAddress(hostName);
                MainApp.setPortNumber(Command.fromStringToInt(portNumber));
                this.dispose();
            } else {
                if (!correctHostName(hostName))
                    textLabel.setText("Please insert a valid host name");
                else
                    textLabel.setText("Please insert a valid port number");

                textLabel.setForeground(new Color(212, 21, 1));
            }
        });


        this.uniquePanel = new PBackground();
        Image image = Toolkit.getDefaultToolkit().createImage("src/main/resources/resources/board/lory_magny.jpg");
        this.background = image.getScaledInstance(Gui.initFrameWidth,Gui.initFrameHeight,0);
        this.uniquePanel.setSize(initFrameWidth,initFrameHeight);
        this.uniquePanel.setBounds(0,0,initFrameWidth,initFrameHeight);
        this.uniquePanel.setImage(this.background);
        this.uniquePanel.setLayout(null);


        this.uniquePanel.add(textField);
        this.uniquePanel.add(portNumberField);
        this.uniquePanel.add(submitButton);
        this.uniquePanel.add(textLabel);

        this.add(uniquePanel);

        this.setVisible(true);

        this.paintComponents(this.getGraphics());
        this.paintComponents(this.getGraphics());
    }

    /**
     * This method checks the given host name string and returns whether it is correct or not.
     * @param hostName
     * @return
     */
    public static boolean correctHostName(String hostName){
        String cha;
        int figure;
        int dots =0;

        if(hostName.length() ==0)
            return false;

        for(int i=0,cont = 0;i<hostName.length();i++){
            if (cont >0 && hostName.charAt(i) =='.'){
                cont = 0;
                dots++;
            }
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

        if (dots != 3)
            return false;

        return true;
    }


    /**
     * This method checks whether the given port number string is correct or not.
     */
    public static boolean correctPortNumber(String portNumber){
        String cha;
        int pn,i;

        if (portNumber.length() == 0)
            return false;
        for(pn = 0,i=0;i<portNumber.length();i++){
            pn*=10;
            pn += portNumber.charAt(i) -'0';
            if (portNumber.charAt(i) -'0' > 9 || portNumber.charAt(i) -'0' <0 ){
                return false;
            }
        }

        if (pn < 0 || pn > 100000)
            return false;

        return true;
    }


}
