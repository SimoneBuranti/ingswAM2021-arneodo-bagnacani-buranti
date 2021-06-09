package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoragePanel extends JPanel {

    /**
     * Graphic parameters.
     */
    private static final int storageWidth = 146;
    private static final int storageHeight = 155;
    private static final int storageX = 24;
    private static final int storageY = 235;
    private static final int singleX = 85-storageX;
    private static final int singleY = 245 - storageY;
    private static final int[] doubleX = {59-storageX,109-storageX};
    private static final int doubleY = 290 - storageY;
    private static final int[] tripleX = {42-storageX,85-storageX,126-storageX};
    private static final int tripleY = 343-storageY;
    private static final int resourceDimension = 40;

    /**
     * toPrintDownUp attribute contains player's resources to be printed from the bigger to the smaller storage space.
     */
    private ArrayList<Resource> toPrintDownUp;

    /**
     * Resource labels.
     */
    private ArrayList<ResourceLabel> printed;

    /**
     * Storage panel constructor.
     */
    public StoragePanel() {
        super();
        this.setLayout(null);
        this.printed = new ArrayList<>();
        this.setBounds(storageX,storageY,storageWidth,storageHeight);
        setOpaque(false);
    }

    /**
     * Updates storage resources.
     * @param newStorage
     */
    public void updateStorage(Map<Resource,Integer> newStorage){

        refreshPrinted();

        createToPrintDownUp(newStorage);

        for(int k = 0; k<newStorage.get(toPrintDownUp.get(0));k++){
            ResourceLabel l = new ResourceLabel(tripleX[k],tripleY,resourceDimension,toPrintDownUp.get(0));
            this.add(l);
            printed.add(l);
        }

        for(int k = 0; k<newStorage.get(toPrintDownUp.get(1));k++){
            ResourceLabel l = new ResourceLabel(doubleX[k],doubleY,resourceDimension,toPrintDownUp.get(1));
            this.add(l);
            printed.add(l);
        }

        for(int k = 0; k<newStorage.get(toPrintDownUp.get(2));k++){
            ResourceLabel l = new ResourceLabel(singleX,singleY,resourceDimension,toPrintDownUp.get(2));
            this.add(l);
            printed.add(l);
        }

        this.setVisible(true);
    }

    /**
     * Remove every resource label from the gameboard panel.
     */
    private void refreshPrinted() {
        for(ResourceLabel label : printed)
            this.remove(label);
    }

    /**
     * This method initialises toPrintDownUp attribute to accept a new resource set to display.
     * @param newStorage
     */
    private void createToPrintDownUp(Map<Resource,Integer> newStorage){

        toPrintDownUp = new ArrayList<>();
        Resource currMax;
        HashMap<Resource,Integer> cloned = new HashMap<>();
        cloned.putAll(newStorage);

        for (int i = 0; i<4;i++){
            currMax = null;
            for (Resource r : cloned.keySet()){
                if (currMax == null)
                    currMax = r;
                if (cloned.get(r)>cloned.get(currMax))
                    currMax = r;

            }
            toPrintDownUp.add(currMax);
            cloned.remove(currMax);
        }
    }


}
