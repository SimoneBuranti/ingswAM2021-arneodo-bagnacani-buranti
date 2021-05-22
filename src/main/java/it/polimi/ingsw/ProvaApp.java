package it.polimi.ingsw;

import it.polimi.ingsw.client.commands.*;
import it.polimi.ingsw.server.model.colours.Blue;
import it.polimi.ingsw.server.model.colours.Green;

import java.util.Scanner;

public class ProvaApp {


    public static void main(String[] args) {


        (new HelpCommand()).commandOn();


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