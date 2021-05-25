package it.polimi.ingsw.server.model.exceptions;

import it.polimi.ingsw.server.model.Resource;

import java.util.ArrayList;

/**
 * This exception is thrown when a player does not have enough space in the storage for the resources obtained from the market
 */
public class NotEnoughSpaceInStorageException extends Exception {

    private ArrayList<Resource> resources;

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public NotEnoughSpaceInStorageException(ArrayList<Resource> resources) {
        this.resources = resources;
    }
    public NotEnoughSpaceInStorageException() {

    }

    public ArrayList<Resource> getResources() {
        return resources;
    }
}
