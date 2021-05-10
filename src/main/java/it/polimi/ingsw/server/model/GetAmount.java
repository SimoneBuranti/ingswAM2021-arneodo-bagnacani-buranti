package it.polimi.ingsw.server.model;

import java.util.ArrayList;

public class GetAmount {
   public static int getAmount (ArrayList<Resource> list, Resource resource){
       int i=0;
       for(Resource p : list)
           if (list.equals(resource))
               i++;
       return i;
   }

    public static int isThere (ArrayList<Resource> list, Resource resource1,Resource resource2){
        int i=0;
        for(Resource p : list){
            if (list.equals(resource1))
                i=1;}
        for(Resource p : list){
            if (list.equals(resource2))
                i=2;}
        return i;
    }

    public static int isThereEqual (Resource resource1,Resource resource2){
        int i=0;
        if (resource1.equals(resource2))
                i=1;
        return i;
    }





}
