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
    private final MessageType messageType = MessageType.ALLOFPLAYER;

    int[][] productioncard;
    ArrayList<Integer> listLeaderActivated;
    Map<Resource,Integer> storage;
    Map<Resource,Integer> strongBox;
    int faithIndicator;

    boolean connected;
    String nickname;

   public ShowAllOfPlayerMessage (int[][] productioncard,ArrayList<Integer> listLeaderActivated,Map<Resource,Integer> storage,Map<Resource,Integer> strongBox,int faithIndicator, boolean connected,String nickname)
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
}
