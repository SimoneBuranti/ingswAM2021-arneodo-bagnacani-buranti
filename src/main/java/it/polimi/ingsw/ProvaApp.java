package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.client.commands.commandParsers.CommandParser;
import it.polimi.ingsw.client.commands.commandParsers.InitLeaderCardParser;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;

import java.io.IOException;
import java.util.Scanner;

public class ProvaApp {


    public static void main(String[] args) {

        Cli cli = new Cli();
        ViewController viewController= null;
        try {
            viewController = new ViewController(new SocketClient("127.0.0.1",1234,cli),cli);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] chosen = new int[2];
        CommandParser commendParser = new InitLeaderCardParser();
        Scanner in = new Scanner(System.in);
        String commandText;

        commandText = in.nextLine();


        Command command = null;
        try {
            command = commendParser.parseCommand(commandText,viewController,cli);
            System.out.println( command instanceof KeepLeaderCardsCommand);
            System.out.println(((KeepLeaderCardsCommand) command).getChosenLeaderCards()[0] ==1);
            System.out.println(((KeepLeaderCardsCommand) command).getChosenLeaderCards()[1] ==2);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }



    }
}

        /*Gson g = new Gson();
        Message message = g.fromJson(new FileReader("src/main/resources/fileConfiguration/prova.json"),Message.class);

        /*System.out.println(message.getMessageType() +" "+ message.getNickname());

        message = g.fromJson(new FileReader("src/main/resources/fileConfiguration/prova2.json"),Message.class);

        System.out.println(message.getMessageType() +" "+ message.getResources().get(0));*/




        /*String jsonString = g.toJson(msg);

        System.out.println(jsonString);

        message = g.fromJson(jsonString,Message.class);

        System.out.println(message.getMessageType() +" "+ message.getNickname());


        File file = new File("src/main/resources/fileConfiguration/modelState.json");

        System.out.println(file.exists());

        try {
            System.out.println(file.createNewFile());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter fileBufferInput = new BufferedWriter(new FileWriter(file));
            fileBufferInput.write(g.toJson(msg));
            fileBufferInput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*import java.util.*;
        import org.json.simple.*;
        public class ConvertListToJSONArrayTest {
            public static void main(String[] args) {
                List<String> list = new ArrayList<String>();
                list.add("India");
                list.add("Australia");
                list.add("England");
                list.add("South Africa");
                list.add("West Indies");
                list.add("Newzealand");
                // this method converts a list to JSON Array
                String jsonStr = JSONArray.toJSONString(list);
                System.out.println(jsonStr);
            }
        }*/