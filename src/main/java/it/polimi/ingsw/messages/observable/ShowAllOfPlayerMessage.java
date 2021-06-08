package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowAllOfPlayerMessage extends Message {
    /**
     * message which contain the information
     * of chosen player
     * it includes all information
     * about leader card, only te activated
     * from server to client
     */
    private final MessageType messageType = MessageType.ALLOFPLAYER;

    int[][] productioncard;
    ArrayList<Integer> listLeaderActivated;
    Map<Resource,Integer> storage;
    Map<Resource,Integer> strongBox;
    int faithIndicator;

    boolean connected;
    String nickname;

    Resource resource1=null;
    Resource resource2=null;
    int howMany1=0;
    int howMany2=0;

   public ShowAllOfPlayerMessage (int[][] productioncard,ArrayList<Integer> listLeaderActivated,Map<Resource,Integer> storage,Map<Resource,Integer> strongBox,int faithIndicator, boolean connected,String nickname
     ,Resource resource1,
             Resource resource2,
             int howMany1,
             int howMany2)
   {

       this.faithIndicator=faithIndicator;
       this.listLeaderActivated=new ArrayList<>();
       this.listLeaderActivated=listLeaderActivated;
       this.productioncard=productioncard;
       this.storage=new HashMap<>();
       this.storage=storage;
       this.strongBox=new HashMap<>();
       this.strongBox=strongBox;
       this.connected=connected;
       this.nickname=nickname;

      this.resource1=resource1;
       this.resource2=resource2;
      this.howMany1=howMany1;
       this.howMany2=howMany2;
   }


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public ArrayList<Integer> getListLeaderActivated() {
        return listLeaderActivated;
    }

    public Map<Resource, Integer> getStrongBox() {
        return strongBox;
    }

    public Map<Resource, Integer> getStorage() {
        return storage;
    }

    public int[][] getProductioncard() {
        return productioncard;
    }

    public int getFaithIndicator() {
        return faithIndicator;
    }



    public boolean isConnected() {
        return connected;
    }

    public String getNickname() {
        return nickname;
    }

    public int getHowMany1() {
        return howMany1;
    }

    public Resource getResource1() {
        return resource1;
    }

    public int getHowMany2() {
        return howMany2;
    }

    public Resource getResource2() {
        return resource2;
    }
}
