package it.polimi.ingsw.client.view.gui.frames;

import it.polimi.ingsw.server.model.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StoragePanel extends JPanel {


    private static final int resourceDimension = 40;

    private boolean[] printed = {false,false,false};

    public StoragePanel() {

        ResourceLabel coinLabel = new ResourceLabel(0,0,resourceDimension, Resource.COIN);
        ResourceLabel rockLabel = new ResourceLabel(0,0,resourceDimension, Resource.ROCK);
        ResourceLabel shieldLabel = new ResourceLabel(0,0,resourceDimension, Resource.SHIELD);
        ResourceLabel servantLabel = new ResourceLabel(0,0,resourceDimension, Resource.SERVANT);

        this.add(coinLabel);
        this.add(rockLabel);
        this.add(shieldLabel);
        this.add(servantLabel);
    }

    public void updateStorage(Map<Resource,Integer> storage){

        for (Resource r : storage.keySet()){
            for(int i = 0; i<3;i++){
                if(!printed[storage.get(r)]){
                    show(storage.get(r),i);
                    i = 3;
                }

            }


        }
        /*coinLabel.setValue(strongBox.get(Resource.COIN));
        rockLabel.setValue(strongBox.get(Resource.COIN));
        shieldLabel.setValue(strongBox.get(Resource.COIN));
        servantLabel.setValue(strongBox.get(Resource.COIN));*/
    }

    private void show(Integer integer, int i) {
        switch(i){
            case 0 : {

            }
            case 1 : {

            }
            case 2 : {

            }

        }
    }


}
