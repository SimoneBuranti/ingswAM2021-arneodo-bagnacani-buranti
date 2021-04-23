package it.polimi.ingsw.server.model.gameBoard;

import it.polimi.ingsw.server.model.Reserve;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.exceptions.UnavailableResourceException;

import java.util.ArrayList;
import java.util.Map;

/**
 * this class represents the storage of the game board with an extra storage activated by a second storage-type leaderCard
 */

public class StorageExtraSecond extends StorageExtraFirst {
    /**
     * this attribute specifies the type of resources of the second extra storage
     */
    private final Resource secondResourceType;
    /**
     * this attribute specifies how many resources there are in the second extra storage
     */
    private final int[] storageExtraSecond = new int[2];

    /**
     * this constructor calls the constructor of the super class with map, resource and int parameters and
     * initialises the resource type of the second extra storage and
     * initialises the values of the storageExtraFirst vector to zero
     * @param resourceFirstType: the type of resources of the first extra storage
     * @param resourceSecondType : the type of resources of the second extra storage
     * @param map : the map to be copied in the super class
     * @param numFirstExtra : the amount of resources contained in the first extra storage
     */
    public StorageExtraSecond(Resource resourceFirstType, Resource resourceSecondType, Map<Resource, Integer> map, int numFirstExtra){
        super(resourceFirstType, map, numFirstExtra);
        this.secondResourceType = resourceSecondType;
        storageExtraSecond[0] = 0;
        storageExtraSecond[1] = 0;
    }

    /**
     * This method returns an ArrayList containing the whole available resources inside the storage
     * @return ArrayList<Resource> : collection of all the resources present in the storage
     */
    @Override
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> storageExtraSecondResources = new ArrayList<>();

        for(int i=0;i<2;i++)
            if (storageExtraSecond[i]==1)
                storageExtraSecondResources.add(secondResourceType);
        storageExtraSecondResources.addAll(super.availableResources());

        return storageExtraSecondResources;
    }

    /**
     * this method removes a resource type from the reserve if available and
     * adds it to the second extra storage if it can, otherwise
     * it adds it in the map or in the first extra storage by calling the method of the super class
     * @param resource :type of resource to add
     */
    @Override
    public void addResource(Resource resource) {

        if(resource.equals(secondResourceType) && !isStorageExtraSecondFull()){
            try {
                Reserve.getResource(resource);
                if(storageExtraSecond[0] == 0)
                    storageExtraSecond[0] = 1;
                else
                    storageExtraSecond[1] = 1;
            } catch (UnavailableResourceException ignored) {}
        }else
            super.addResource(resource);

    }

    /**
     * this method adds a resource type to the reserve and
     * removes it from the second extra storage if it can, otherwise
     * it removes the resource by calling the method of the super class
     * @param resource: type of resource to remove
     * @throws UnavailableResourceException : the exception which is thrown when there are no more resources in the storage
     *                                        of the resource type to be withdrawn
     */
    @Override
    public void useResource(Resource resource) throws UnavailableResourceException {
        if(resource.equals(secondResourceType) && !isStorageExtraSecondEmpty()){
            Reserve.addResource(resource);
            if(storageExtraSecond[1] == 1)
                storageExtraSecond[1] = 0;
            else
                storageExtraSecond[0] = 0;
        }else
            super.useResource(resource);
    }

    /**
     * this method removes all the resources that can be in the second extra storage
     * from the list passed as a parameter and
     * calls the method of the super class passing it the modified list
     * @param list : a list of resources to check before adding
     * @return boolean: if it checks the conditions returns true, false otherwise
     */
    @Override
    public boolean check(ArrayList<Resource> list) {
        ArrayList<Resource> listWithoutExtra = new ArrayList<>();
        int cont = getNUmExtraSecondAvailable();
        listWithoutExtra.addAll(list);

        if(cont != 0 && listWithoutExtra.contains(secondResourceType)){
            for(Resource resource : listWithoutExtra)
                if(cont != 0 && resource.equals(secondResourceType)){
                    cont--;
                }
            while(cont != getNUmExtraSecondAvailable()){
                listWithoutExtra.remove(secondResourceType);
                cont++;
            }
        }

        return super.check(listWithoutExtra);
    }

    /**
     * This method calls the method of the super class and
     * adds it the amount of resources contained in the second extra storage and
     * the returns the current number of a resource type
     * @param resource : type of resource
     * @return int : the current amount of the resource
     */
    @Override
    public int getResource(Resource resource) {
        int numSecondResourceType = 0;

        if(resource.equals(secondResourceType))
            numSecondResourceType = 2 - getNUmExtraSecondAvailable();

        return numSecondResourceType + super.getResource(resource);
    }

    /**
     * this method calls the method of the super class and
     * adds it the amount of resources contained in the second extra storage and
     * returns the total number of resources in the storage
     * @return int : the total amount of resources
     */
    @Override
    public int resourceScore() {
        int numSecondResourceType = 2 - getNUmExtraSecondAvailable();

        return numSecondResourceType + super.resourceScore();
    }

    /**
     * this method returns true if the second extra storage is full, false otherwise
     * @return boolean : true if the second extra storage is full, false otherwise
     */
    @Override
    public boolean isStorageExtraSecondFull(){
        if (storageExtraSecond[0] == 1 && storageExtraSecond[1] == 1)
            return true;
        return false;
    }

    /**
     * this method returns true if the second extra storage is empty, false otherwise
     * @return boolean : true if the second extra storage is empty, false otherwise
     */
    @Override
    public boolean isStorageExtraSecondEmpty(){
        if (storageExtraSecond[0] == 0 && storageExtraSecond[1] == 0)
            return true;
        return false;
    }


    /**
     * this method returns the type of resources of the second extra storage
     * @return Resource : the type of resources of the second extra storage
     */
    @Override
    public Resource getSecondResourceType() {
        return secondResourceType;
    }


    /**
     * this method returns the amount of places available in the second extra storage
     * @return int : the amount of places available in the second extra storage
     */
    @Override
    public int getNUmExtraSecondAvailable(){
        int numResourceExtra;
        if(storageExtraSecond[0] == 0 && storageExtraSecond[1] == 0)
            numResourceExtra = 2;
        else if(storageExtraSecond[0] == 1 && storageExtraSecond[1] == 1)
            numResourceExtra = 0;
        else
            numResourceExtra = 1;

        return numResourceExtra;
    }
}
