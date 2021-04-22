package it.polimi.ingsw.model.gameBoard;

import it.polimi.ingsw.model.Reserve;
import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.exceptions.UnavailableResourceException;

import java.util.ArrayList;
import java.util.Map;

/**
 * this class represents the storage of the game board with an extra storage activated by a first storage-type leaderCard
 */
public class StorageExtraFirst extends Storage{
    /**
     * this attribute specifies the type of resources of the first extra storage
     */
    private final Resource firstResourceType;
    /**
     * this attribute specifies how many resources there are in the first extra storage
     */
    private final int[] storageExtraFirst = new int[2];

    /**
     * this constructor calls the constructor of the super class with map parameter and
     * initialises the resource type of the first extra storage and
     * initialises the values of the storageExtraFirst vector to zero
     * @param resourceType : the type of resources of the first extra storage
     * @param map : the map to be copied in the super class
     */
    public StorageExtraFirst(Resource resourceType, Map<Resource, Integer> map){
        super(map);
        this.firstResourceType = resourceType;
        storageExtraFirst[0] = 0;
        storageExtraFirst[1] = 0;
    }

    /**
     * this constructor calls the constructor of the super class with map parameter and
     * initialises the resource type of the first extra storage and
     * initialises the vector storageExtraFirst values depending on the number numFirstExtra
     * @param resourceType :the type of resources of the first extra storage
     * @param map : the map to be copied in the super class
     * @param numFirstExtra: the amount of resources that can be contained in the first extra storage
     */
    public StorageExtraFirst(Resource resourceType, Map<Resource, Integer> map, int numFirstExtra){
        super(map);
        this.firstResourceType = resourceType;
        if(numFirstExtra == 2) {
            storageExtraFirst[0] = 0;
            storageExtraFirst[1] = 0;
        }else if(numFirstExtra == 1){
            storageExtraFirst[0] = 1;
            storageExtraFirst[1] = 0;
        }else{
            storageExtraFirst[0] = 1;
            storageExtraFirst[1] = 1;
        }
    }

    /**
     * This method returns an ArrayList containing the whole available resources inside the storage
     * @return ArrayList<Resource> : collection of all the resources present in the storage
     */
    public ArrayList<Resource> availableResources() {
        ArrayList<Resource> storageExtraFirstResources = new ArrayList<>();

        for(int i=0;i<2;i++)
            if (storageExtraFirst[i]==1)
                storageExtraFirstResources.add(firstResourceType);
        storageExtraFirstResources.addAll(super.availableResources());

        return storageExtraFirstResources;
    }

    /**
     * this method removes a resource type from the reserve if available and
     * adds it to the first extra storage if it can, otherwise
     * it adds it in the map by calling the method of the super class
     * @param resource : type of resource to add
     */
    @Override
    public void addResource(Resource resource) {

        if(resource.equals(firstResourceType) && !isStorageExtraFirstFull()){
            try {
                Reserve.getResource(resource);
                if(storageExtraFirst[0] == 0)
                    storageExtraFirst[0] = 1;
                else
                    storageExtraFirst[1] = 1;
            } catch (UnavailableResourceException ignored) {}
        }else
            super.addResource(resource);

    }

    /**
     * this method adds a resource type to the reserve and
     * removes it from the first extra storage if it can, otherwise
     * it removes the resource by calling the method of the super class
     * @param resource: type of resource to remove
     * @throws UnavailableResourceException : the exception which is thrown when there are no more resources in the storage
     *                                        of the resource type to be withdrawn
     */
    @Override
    public void useResource(Resource resource) throws UnavailableResourceException {
        if(resource.equals(firstResourceType) && !isStorageExtraFirstEmpty()){
            Reserve.addResource(resource);
            if(storageExtraFirst[1] == 1)
                storageExtraFirst[1] = 0;
            else
                storageExtraFirst[0] = 0;
        }else
            super.useResource(resource);
    }

    /**
     * this method removes all the resources that can be in the first extra storage
     * from the list passed as a parameter and
     * calls the method of the super class passing it the modified list
     * @param list : a list of resources to check before adding
     * @return boolean : if it checks the conditions returns true, false otherwise
     */
    @Override
    public boolean check(ArrayList<Resource> list) {
        ArrayList<Resource> listWithoutExtra = new ArrayList<>();
        int cont = getNumExtraFirstAvailable();
        listWithoutExtra.addAll(list);

        if(cont != 0 && listWithoutExtra.contains(firstResourceType)){
            for(Resource resource : listWithoutExtra)
                if(cont != 0 && resource.equals(firstResourceType)){
                    cont--;
                }
            while(cont != getNumExtraFirstAvailable()){
                listWithoutExtra.remove(firstResourceType);
                cont++;
            }
        }

        return super.check(listWithoutExtra);
    }

    /**
     * This method calls the method of the super class and
     * adds it the amount of resources contained in the first extra storage and
     * returns the current number of a resource type
     * @param resource : type of resource
     * @return int : the current amount of the resource
     */
    @Override
    public int getResource(Resource resource) {
        int numFirstResourceType = 0;

        if(resource.equals(firstResourceType))
            numFirstResourceType = 2 - getNumExtraFirstAvailable();

        return numFirstResourceType + super.getResource(resource);
    }

    /**
     * this method calls the method of the super class and
     * adds it the amount of resources contained in the first extra storage and
     * returns the total number of resources in the storage
     * @return int : the total amount of resources
     */
    @Override
    public int resourceScore() {
        int numFirstResourceType = 2 - getNumExtraFirstAvailable();

        return numFirstResourceType + super.resourceScore();
    }

    /**
     * this method returns true if the first extra storage is full, false otherwise
     * @return boolean : true if the first extra storage is full, false otherwise
     */
    @Override
    public boolean isStorageExtraFirstFull(){
        if (storageExtraFirst[0] == 1 && storageExtraFirst[1] == 1)
            return true;
        return false;
    }

    /**
     * this method returns true if the first extra storage is empty, false otherwise
     * @return boolean : true if the first extra storage is empty, false otherwise
     */
    @Override
    public boolean isStorageExtraFirstEmpty(){
        if (storageExtraFirst[0] == 0 && storageExtraFirst[1] == 0)
            return true;
        return false;
    }


    /**
     * this method returns the type of resources of the first extra storage
     * @return Resource : the type of resources of the first extra storage
     */
    @Override
    public Resource getFirstResourceType() {
        return firstResourceType;
    }


    /**
     * this method returns the amount of places available in the second extra storage
     * @return int : the amount of places available in the second extra storage
     */
    @Override
    public int getNumExtraFirstAvailable(){
        int numResourceExtra;
        if(storageExtraFirst[0] == 0 && storageExtraFirst[1] == 0)
            numResourceExtra = 2;
        else if(storageExtraFirst[0] == 1 && storageExtraFirst[1] == 1)
            numResourceExtra = 0;
        else
            numResourceExtra = 1;

        return numResourceExtra;
    }

}
