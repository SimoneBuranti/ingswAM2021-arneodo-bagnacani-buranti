package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoragePanel extends JPanel {


    private static final int storageWidth = 146;
    private static final int storageHeight = 155;
    private static final int storageX = 24;
    private static final int storageY = 235;
    private static final int singleX = 92-storageX;
    private static final int singleY = 250 - storageY;
    private static final int[] doubleX = {63-storageX,115-storageX};
    private static final int doubleY = 345 - storageX;
    private static final int[] tripleX = {48-storageX,87-storageX,130-storageX};
    private static final int tripleY = 350-storageY;
    private static final int resourceDimension = 40;

    private ArrayList<Resource> toPrintDownUp;

    private ArrayList<ResourceLabel> printed;

    public StoragePanel() {
        super();

        this.printed = new ArrayList<>();
        this.setBounds(storageX,storageY,storageWidth,storageHeight);
        this.setOpaque(false);
    }

    public void updateStorage(Map<Resource,Integer> newStorage){

        refreshPrinted();

        for(int k = 0; k<newStorage.get(toPrintDownUp.get(0));k++){
            this.add(new ResourceLabel(tripleX[k],tripleY,resourceDimension,toPrintDownUp.get(0)));
        }

        for(int k = 0; k<newStorage.get(toPrintDownUp.get(1));k++){
            this.add(new ResourceLabel(doubleX[k],doubleY,resourceDimension,toPrintDownUp.get(1)));
        }

        for(int k = 0; k<newStorage.get(toPrintDownUp.get(2));k++){
            this.add(new ResourceLabel(singleX,singleY,resourceDimension,toPrintDownUp.get(2)));
        }


    }

    private void refreshPrinted() {
        for(ResourceLabel label : printed)
            this.remove(label);
    }

    private void createToPrintDownUp(Map<Resource,Integer> newStorage){

        toPrintDownUp = new ArrayList<>();
        Resource currMax = Resource.COIN;
        HashMap<Resource,Integer> cloned = new HashMap<Resource,Integer>();
        cloned.putAll(newStorage);

        for (int i = 0; i<4;i++){
            for ( Resource r : newStorage.keySet()){
                if (newStorage.get(r)>newStorage.get(currMax))
                    currMax = r;

            }
            toPrintDownUp.add(currMax);
            newStorage.remove(currMax);
        }
    }


}
