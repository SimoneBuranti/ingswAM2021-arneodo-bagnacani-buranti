package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Map;

/**
 * this class represents the storage of the gameboard with an extra storage activated by a second leaderCard
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
     * it adds it in the map by calling the method of the super class
     * @param resource :type of resource to add
     * @throws UnavailableResourceException
     */
    @Override
    public void addResource(Resource resource) throws UnavailableResourceException {

        if(resource.equals(secondResourceType) && !isStorageExtraSecondFull()){
            Reserve.getResource(resource);
            if(storageExtraSecond[0] == 0)
                storageExtraSecond[0] = 1;
            else
                storageExtraSecond[1] = 1;
        }else
            super.addResource(resource);

    }

    /**
     * this method adds a resource type to the reserve and
     * removes it from the second extra storage if it can, otherwise
     * it removes the resource by calling the method of the super class
     * @param resource: type of resource to remove
     * @throws UnavailableResourceException
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
     * @return boolean
     */
    public boolean isStorageExtraSecondFull(){
        if (storageExtraSecond[0] == 1 && storageExtraSecond[1] == 1) {
            return true;
        }else
            return false;
    }

    /**
     * this method returns true if the second extra storage is empty, false otherwise
     * @return boolean
     */
    public boolean isStorageExtraSecondEmpty(){
        if (storageExtraSecond[0] == 0 && storageExtraSecond[1] == 0) {
            return true;
        }else
            return false;
    }


    /**
     * this method return the type of resources of the second extra storage
     * @return Resource
     */
    public Resource getSecondResourceType() {
        return secondResourceType;
    }


    /**
     * this method return the amount of places available in the second extra storage
     * @return int
     */
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
