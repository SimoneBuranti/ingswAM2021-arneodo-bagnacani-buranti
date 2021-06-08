package it.polimi.ingsw;

import com.google.gson.Gson;
import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.IPInitialFrame;
import it.polimi.ingsw.server.network.Server;
import it.polimi.ingsw.server.network.SocketServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

    public static final String defHostName = "127.0.0.1";
    public static final int defPortNumber = 12345;

    private static String hostName;
    private static int portNumber;
    private static String strPortNumber;


    public static void main(String[] args){

        boolean isServer,isGui,missingPar;
        int port = 0;


        SocketClient socketClient = null;
        View view = null;
        SocketServer socketServer;
        Server server;
        hostName = null;
        portNumber = -1;


        missingPar = true;
        isServer = false;
        for(String par : args){
            if(par.equals("--server") || par.equals("-s")){
                isServer = true;
                missingPar = false;
                break;
            }

            if(par.equals("--client") || par.equals("-c")){
                isServer = false;
                missingPar = false;
                break;
            }
        }

        if (!missingPar){
            if (isServer){

                for (int i = 0; i < args.length; i++) {
                    if (args.length >= 2 && (args[i].equals("--port") || args[i].equals("-p"))) {
                        try {
                            port = Integer.parseInt(args[i + 1]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid port specified. Using default port.");
                        }
                    }
                }


                server = new Server();

                if (port==0){

                    Gson g = new Gson();
                    Map map = null;
                    try {
                        map = g.fromJson(new FileReader("fileConfiguration/defaultServer.json"), Map.class);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: fileConfiguration not found");
                        return;
                    }

                    socketServer = new SocketServer(server,((Double) map.get("defaultServerPort")).intValue());

                }else{
                    socketServer = new SocketServer(server,port);
                }

                socketServer.create();



            } else {
                missingPar = true;
                isGui = true;
                for(String par : args){
                    if(par.equals("--cli")){
                        isGui = false;
                        missingPar = false;
                        break;
                    }

                    if(par.equals("--gui")){
                        isGui = true;
                        missingPar = false;
                        break;
                    }
                }

                if (!missingPar){


                    if (!isGui) {

                        Scanner in = new Scanner(System.in);
                        System.out.println("Insert the host name of the server\n");
                        hostName = in.nextLine();

                        while (!IPInitialFrame.correctHostName(hostName)){
                            System.out.println("Wrong host name, try again\n");
                            hostName = in.nextLine();
                        }

                        System.out.println("Insert the port number of the server\n");
                        strPortNumber = in.nextLine();

                        while (!IPInitialFrame.correctPortNumber(strPortNumber)){
                            System.out.println("Wrong host name, try again\n");
                            strPortNumber = in.nextLine();
                        }

                        portNumber = Command.fromStringToInt(strPortNumber);

                        view = new Cli();

                        try {
                            socketClient = new SocketClient(hostName, portNumber, view );
                        } catch (IOException e) {
                            System.out.println("Error: server not found");
                            return;
                        }

                    } else {


                        new IPInitialFrame();

                        while(MainApp.getIPAddress() == null || MainApp.getPortNumber() == -1){
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        view = new Gui();


                        try {
                            socketClient = new SocketClient(hostName, portNumber, view);

                        } catch (IOException e) {
                            System.out.println("Error: server not found");
                            return;
                        }


                    }

                    view.startView();
                    SocketClient finalSocketClient = socketClient;
                    new Thread() {
                        public void run() {
                            finalSocketClient.readMessage();
                        }
                    }.start();

                }

            }
        }



    }



    public static synchronized void setIPAddress(String ipAddress){
        MainApp.hostName = ipAddress;
    }

    public static synchronized void setPortNumber(int portNumber){
        MainApp.portNumber = portNumber;
    }

    public static synchronized String getIPAddress(){
        return MainApp.hostName;
    }

    public static synchronized int getPortNumber(){
        return MainApp.portNumber;
    }

}
